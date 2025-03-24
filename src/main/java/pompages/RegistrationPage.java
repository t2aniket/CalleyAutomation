package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegistrationPage {
	
	
	public RegistrationPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="txtName")
	private WebElement nameField;
	
	
	@FindBy(id="txtEmail")
	private WebElement emailField;
	
	
	@FindBy(id="txtPassword")
	private WebElement passwordField;
	
	
	@FindBy(id="txt_mobile")
	private WebElement mobileNumberField;
	
	
	@FindBy(xpath="//iframe[@title='reCAPTCHA']")
	private WebElement iFrameCAPTCHAField;
	
	
	@FindBy(id="checkbox-signup")
	private WebElement checkBoxField;


	@FindBy(xpath="//div[@class='sa-confirm-button-container']/button")
	private WebElement otpSentOkBtn;
	
	/**
	 * This is the attribute that we are checking for google recaptcha solved or not
	 */
	private  String RECAPTCHA_CHECKED_ATTRIBUTE = "aria-checked";
	

	@FindBy(id="recaptcha-anchor")
	private WebElement reCAPTCHAField;
	
	
	@FindBy(id="btnSignUp")
	private WebElement Signupbtn;
	
	
	@FindBy(id="ancPop2")
	private WebElement calleyTamsActivationBtn;
	
	
	@FindBy(id="btnteamsplanactive")
	private WebElement confirmCalleyTeamsActivationPopup;
	
	
	@FindBy(xpath="//a[@class='btn btn-new2 icon_right']")
	private WebElement goToDashboardBtn;
	
	
	@FindBy(xpath="//div[@class='card-box mb-0 mb-bottom mob-view']//h4[@class='page-title number-title mb-bottom strong_text']")
	private WebElement currentUserName;
	
	
	@FindBy(id="txtOTP_Char1")
	private WebElement otpChar1Field;
	
	
	@FindBy(id="txtOTP_Char2")
	private WebElement otpChar2Field;
	
	
	@FindBy(id="txtOTP_Char3")
	private WebElement otpChar3Field;
	
	
	@FindBy(id="txtOTP_Char4")
	private WebElement otpChar4Field;
	
	
	@FindBy(id="txtOTP_Char5")
	private WebElement otpChar5Field;
	
	
	@FindBy(id="txtOTP_Char6")
	private WebElement otpChar6Field;
	
	
	public WebElement getConfirmCalleyTeamsActivationPopup() {
		return confirmCalleyTeamsActivationPopup;
	}

	
	public WebElement getOtpChar1Field() {
		return otpChar1Field;
	}

	
	public WebElement getOtpChar2Field() {
		return otpChar2Field;
	}

	
	public WebElement getOtpChar3Field() {
		return otpChar3Field;
	}

	
	public WebElement getOtpChar4Field() {
		return otpChar4Field;
	}

	
	public WebElement getOtpChar5Field() {
		return otpChar5Field;
	}

	
	public WebElement getOtpChar6Field() {
		return otpChar6Field;
	}

	
	public WebElement getCalleyTamsActivationBtn() {
		return calleyTamsActivationBtn;
	}

	
	public WebElement confirmCalleyTeamsActivationPopup() {
		return confirmCalleyTeamsActivationPopup;
	}

	
	public WebElement getGoToDashboardBtn() {
		return goToDashboardBtn;
	}

	
	public WebElement getCurrentUserName() {
		return currentUserName;
	}

	
	public WebElement getNameField() {
		return nameField;
	}

	
	public WebElement getEmailField() {
		return emailField;
	}

	
	public WebElement getPasswordField() {
		return passwordField;
	}

	
	public WebElement getMobileNumberField() {
		return mobileNumberField;
	}

	
	public WebElement getiFrameCAPTCHAField() {
		return iFrameCAPTCHAField;
	}

	
	public WebElement getCheckBoxField() {
		return checkBoxField;
	}

	
	public WebElement getReCAPTCHAField() {
		return reCAPTCHAField;
	}


	public String getRECAPTCHA_CHECKED_ATTRIBUTE() {
		return RECAPTCHA_CHECKED_ATTRIBUTE;
	}
	
	
	public WebElement getOtpSentOkBtn() {
		return otpSentOkBtn;
	}
	
	
	public WebElement getSignupbtn() {
		return Signupbtn;
	}

	
	

}
