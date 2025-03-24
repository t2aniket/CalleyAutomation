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
		
		Reporter.log("On Registeration Page");
		RegistrationPage RP = new RegistrationPage(driver);//RegistrationPage is loaded as RP
		
		String Name=pUtil.readPropertyFile("name");
		String Email=pUtil.readPropertyFile("email");
		String Password=pUtil.readPropertyFile("password");
		String MobileNumber=pUtil.readPropertyFile("mobile");
		
		
		RP.getNameField().sendKeys(Name);
		RP.getEmailField().sendKeys(Email);
		RP.getPasswordField().sendKeys(Password);
		Reporter.log("Entered Name,Email & Password");
		
		
		Reporter.log("Swiching to iFrame for google CAPTCHA");
		wUtil.switchToiFrame(driver, RP.getiFrameCAPTCHAField());
		Reporter.log("Switched to IFrame");
		
		
		RP.getReCAPTCHAField().click();
		Reporter.log("Please solve the captcha manually since it is not disabled");
		Reporter.log("Waiting for Captcha to be solved");
		
		
		wUtil.waitForAttributeValue(driver,RP.getReCAPTCHAField(), RP.getRECAPTCHA_CHECKED_ATTRIBUTE(),"true", 20);//this method check if the captcha is solved
		Reporter.log("Captcha solved switching back to main frame");
		wUtil.swtichToDefaultContent(driver);
		
		
		RP.getMobileNumberField().sendKeys(MobileNumber);
		Reporter.log("Entered MobileNumber");
		
		
		wUtil.javaScriptExecutorClick(driver, RP.getCheckBoxField());
		Reporter.log("Terms and Condition checkbox checked");
		
		
		wUtil.javaScriptExecutorClick(driver, RP.getSignupbtn());
		Reporter.log("Clicked Signup Button");
		
		
		wUtil.waitForElementToBeVisible(driver, RP.getOtpSentOkBtn());
		RP.getOtpSentOkBtn().click();
		Reporter.log("OTP sent to mobile number enter it on eclipse since otp is dynamic and not turned off for testing purpose");
		
		
		Scanner sc = new Scanner(System.in);
		Reporter.log("Please Enter OTP", true);
		String OTP = sc.next();  //since otp cannot be automated at this movement asking manual from user
		Reporter.log("Entering the given OTP");
		sc.close();

	
		// Enter OTP into the fields one by one
		RP.getOtpChar1Field().sendKeys(Character.toString(OTP.charAt(0)));
		RP.getOtpChar2Field().sendKeys(Character.toString(OTP.charAt(1)));
		RP.getOtpChar3Field().sendKeys(Character.toString(OTP.charAt(2)));
		RP.getOtpChar4Field().sendKeys(Character.toString(OTP.charAt(3)));
		RP.getOtpChar5Field().sendKeys(Character.toString(OTP.charAt(4)));
		RP.getOtpChar6Field().sendKeys(Character.toString(OTP.charAt(5)));
		
		
		Reporter.log("OTP Entered");
		wUtil.javaScriptExecutorClick(driver, RP.getSignupbtn());
		Reporter.log("Clicked Singup Button");
		
		
		if(wUtil.isElementVisible(driver, RP.getCalleyTamsActivationBtn()))
		{
			RP.getCalleyTamsActivationBtn().click();
			Reporter.log("Selected Calley Teams");
		}
		

		if(wUtil.isElementVisible(driver, RP.confirmCalleyTeamsActivationPopup()))
		{
			RP.confirmCalleyTeamsActivationPopup().click();
			Reporter.log("Confirmed the selection of Calley Teams");
			
		}
		
		
		if (wUtil.isElementVisible(driver, RP.getGoToDashboardBtn()))
		{
			RP.getGoToDashboardBtn().click();
			Reporter.log("Going to main dashboard");
			
		}
		
		
		String currentName = RP.getCurrentUserName().getText();
		Reporter.log("Checking the currently logged in user");
		
		//checking is the user is successfully registered
		Assert.assertTrue(currentName.toLowerCase().contains(Name.toLowerCase()), "User login failed. Expected name: " + Name + ", but found: " + currentName);

		
		
	}
	
	
	

}
