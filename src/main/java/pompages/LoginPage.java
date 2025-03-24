package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="txtEmailId")
	private WebElement userEmailField;
	
	
	@FindBy(id="txtPassword")
	private WebElement userPasswordField;
	
	
	@FindBy(id="btnLogIn")
	private WebElement loginBtn;
	
	
	@FindBy (id="onesignal-slidedown-cancel-button")
	private WebElement notificationLaterBtn;

	
	public WebElement getNotificationLaterBtn() {
		return notificationLaterBtn;
	}
	
	
	public WebElement getUserEmailField() {
		return userEmailField;
	}

	
	public WebElement getUserPasswordField() {
		return userPasswordField;
	}
	
	
	public WebElement getLoginBtn() {
		return loginBtn;
	}

}
