package test;

import java.time.Duration;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseClass;
import pompages.AgentPage;
import pompages.BasePage;
import pompages.BulkUploadPage;
import pompages.HomePage;
import pompages.LoginPage;
import utility.ConstantUtility;
import utility.AgentDataProvider;

public class FullSetupTest extends BaseClass {
	
	//This method will be loaded first and will set the property file and open the browser
	@BeforeClass
	public void setup() {
		setPropertyFile(ConstantUtility.LOGIN_PROPERTY_FILE);
        browserConfig();
	}

    @Test(priority = 1)
    public void userLogin() {
        LoginPage LP = new LoginPage(driver);
        HomePage HP = new HomePage(driver);

        String useremail = pUtil.readPropertyFile("useremail");
        String password = pUtil.readPropertyFile("password");
        String username = pUtil.readPropertyFile("name");

        //login
        Reporter.log("Trying to login with useremail and password");
        LP.getUserEmailField().sendKeys(useremail);
        LP.getUserPasswordField().sendKeys(password);
        LP.getLoginBtn().click();
        
        //close the notification popup
        wUtil.waitForElementToBeClickable(driver, LP.getNotificationLaterBtn());
        LP.getNotificationLaterBtn().click();

        // Verify login
        String currentName = HP.getCurrentUserName().getText();
        try {
        Assert.assertTrue(currentName.toLowerCase().contains(username.toLowerCase()), "User login failed");
        
        }
        catch(Exception e){
        	
        	wUtil.getScreenshot(driver, "UserLogin_Failed");
        }
        Reporter.log("User Logged In Sucess");
        wUtil.moveToElement(driver, HP.getTeamBtn());
        HP.getAgentBtn().click();
    	Reporter.log("On to the Agents Page");
    }

    @Test(priority = 2, dataProvider = "agentData", dataProviderClass = AgentDataProvider.class)
    public void createAgent(String agentName, String agentEmail, String agentMobile, String agentPassword) {
    	AgentPage AP = new AgentPage(driver);
        
    	Reporter.log("Adding Agent Details");
    	
        // Enter agent details
        AP.getAgentNameField().sendKeys(agentName);
        AP.getAgentEmailField().sendKeys(agentEmail);
        AP.getAgentMobileField().sendKeys(agentMobile);
        AP.getAgentPasswordField().sendKeys(agentPassword);

        // Click submit
        AP.getAgentDetailsSubmitBtn().click();
     
        // Wait and confirm agent addition
        wUtil.waitForElementToBeClickable(driver, AP.getAgentAddedConfirmationBtn());
        AP.getAgentAddedConfirmationBtn().click();
        try {
        	
        	Thread.sleep(Duration.ofSeconds(3));
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        //verifying if agent is added or not
        try {
        Assert.assertTrue(AP.isAgentAdded(agentName, agentEmail), "Agent Verification Failed");
        }
        catch(Exception e)
        {
        	wUtil.getScreenshot(driver, "AgentCreation_Failed_");
        }Reporter.log("Agent Details added sucessfully");
    }

    @Test(priority = 3,dependsOnMethods = "createAgent")
    public void bulkUpload() {
    	
        BasePage BP = new BasePage(driver);
        BulkUploadPage BUP = new BulkUploadPage(driver);

        wUtil.moveToElement(driver, BP.getCallListBtn());
        BP.getAddPowerImportBtn().click();

        Reporter.log("Inside the bulk Upload Page");

        
        BUP.getListName().sendKeys(pUtil.readPropertyFile("listname"));
    
        BUP.getAgentSelectBtn().click();
        
        BUP.getSelectAllAgents().click();
        
        BUP.getListName().click();
        
        BUP.getFileUpload().sendKeys(ConstantUtility.AGENT_CSV_FILE);
        
        BUP.getUploadbtn().click();
        
        wUtil.waitForElementToBeVisible(driver, BUP.getConfirmBtn());
        
        try {
			Thread.sleep(Duration.ofSeconds(1));
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
        BUP.getConfirmBtn().click();
        
       Reporter.log("Confirm Button Clicked");
       
       Reporter.log("Mapping the data");
        String coloum1 = pUtil.readPropertyFile("coloum1");
        String coloum2 = pUtil.readPropertyFile("coloum2");
        String coloum3 = pUtil.readPropertyFile("coloum3");

        BUP.getColoum1DropDown().click();
        wUtil.selectByVisibleText(BUP.getColoum1DropDown(), coloum1);
        BUP.getColoum2DropDown().click();
        wUtil.selectByVisibleText(BUP.getColoum2DropDown(), coloum2);
        BUP.getColoum3DropDown().click();
        wUtil.selectByVisibleText(BUP.getColoum3DropDown(), coloum3);
        Reporter.log("Data Sucessfully Mapped");
        
        wUtil.javaScriptExecutorClick(driver, BUP.getImportDataBtn());
        Reporter.log("File Sucessfully Imported");
        
        BUP.getConfirmBtn().click();
        
        Reporter.log("Test Case Passed");
        
        
}}
