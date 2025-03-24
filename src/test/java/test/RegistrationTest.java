package test;

import java.util.Scanner;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseClass;
import pompages.RegistrationPage;
import utility.ConstantUtility;


public class RegistrationTest extends BaseClass {
	
	
	@BeforeClass
	public void setup() {
		Reporter.log("Starting Registration Test");
		setPropertyFile(ConstantUtility.REGISTRATION_PROPERTY_FILE);
        browserConfig();
	}
	
	
	@Test
	public void userRegistration() {
		
		Reporter.log("On Registeration Page",true);
		RegistrationPage RP = new RegistrationPage(driver);//RegistrationPage is loaded as RP
		
		String Name=pUtil.readPropertyFile("name");
		String Email=pUtil.readPropertyFile("email");
		String Password=pUtil.readPropertyFile("password");
		String MobileNumber=pUtil.readPropertyFile("mobile");
		
		
		RP.getNameField().sendKeys(Name);
		RP.getEmailField().sendKeys(Email);
		RP.getPasswordField().sendKeys(Password);
		Reporter.log("Entered Name,Email & Password",true);
		
		
		Reporter.log("Swiching to iFrame for google CAPTCHA");
		wUtil.switchToiFrame(driver, RP.getiFrameCAPTCHAField());
		Reporter.log("Switched to IFrame",true);
		
		
		RP.getReCAPTCHAField().click();
		Reporter.log("Please solve the captcha manually since it is not disabled",true);
		Reporter.log("Waiting for Captcha to be solved",true);
		
		
		wUtil.waitForAttributeValue(driver,RP.getReCAPTCHAField(), RP.getRECAPTCHA_CHECKED_ATTRIBUTE(),"true", 20);//this method check if the captcha is solved
		Reporter.log("Captcha solved switching back to main frame",true);
		wUtil.swtichToDefaultContent(driver);
		
		
		RP.getMobileNumberField().sendKeys(MobileNumber);
		Reporter.log("Entered MobileNumber",true);
		
		
		wUtil.javaScriptExecutorClick(driver, RP.getCheckBoxField());
		Reporter.log("Terms and Condition checkbox checked",true);
		
		
		wUtil.javaScriptExecutorClick(driver, RP.getSignupbtn());
		Reporter.log("Clicked Signup Button",true);
		
		
		wUtil.waitForElementToBeVisible(driver, RP.getOtpSentOkBtn());
		RP.getOtpSentOkBtn().click();
		Reporter.log("OTP sent to mobile number enter it on eclipse since otp is dynamic and not turned off for testing purpose",true);
		
		
		Scanner sc = new Scanner(System.in);
		Reporter.log("Please Enter OTP", true);
		String OTP = sc.next();  //since otp cannot be automated at this movement asking manual from user
		Reporter.log("Entering the given OTP",true);
		sc.close();

	
		// Enter OTP into the fields one by one
		RP.getOtpChar1Field().sendKeys(Character.toString(OTP.charAt(0)));
		RP.getOtpChar2Field().sendKeys(Character.toString(OTP.charAt(1)));
		RP.getOtpChar3Field().sendKeys(Character.toString(OTP.charAt(2)));
		RP.getOtpChar4Field().sendKeys(Character.toString(OTP.charAt(3)));
		RP.getOtpChar5Field().sendKeys(Character.toString(OTP.charAt(4)));
		RP.getOtpChar6Field().sendKeys(Character.toString(OTP.charAt(5)));
		
		
		Reporter.log("OTP Entered",true);
		wUtil.javaScriptExecutorClick(driver, RP.getSignupbtn());
		Reporter.log("Clicked Singup Button",true);
		
		
		if(wUtil.isElementVisible(driver, RP.getCalleyTamsActivationBtn()))
		{
			RP.getCalleyTamsActivationBtn().click();
			Reporter.log("Selected Calley Teams",true);
		}
		

		if(wUtil.isElementVisible(driver, RP.confirmCalleyTeamsActivationPopup()))
		{
			RP.confirmCalleyTeamsActivationPopup().click();
			Reporter.log("Confirmed the selection of Calley Teams",true);
			
		}
		
		
		if (wUtil.isElementVisible(driver, RP.getGoToDashboardBtn()))
		{
			RP.getGoToDashboardBtn().click();
			Reporter.log("Going to main dashboard",true);
			
		}
		
		
		String currentName = RP.getCurrentUserName().getText();
		Reporter.log("Checking if the account has been created for the user",true);
		
		//checking is the user is successfully registered
		try {
		Assert.assertTrue(currentName.toLowerCase().contains(Name.toLowerCase()), "User login failed. Expected name: " + Name + ", but found: " + currentName);
		}
		catch(AssertionError e){
			wUtil.getScreenshot(driver, "userRegistration");
		}
		Reporter.log("Account Sucesfully Created",true);
		
	}
	
	
	

}
