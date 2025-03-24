package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	public HomePage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@class='mobileToggleNav']")
	private WebElement profileSideBar;
	
	
	@FindBy(xpath="(//a[@href='profile.aspx'])[2]")
	private WebElement profileField;
	
	
	@FindBy(xpath="(//a[@href='subscription_list.aspx'])[1]")
	private WebElement subscriptionField;
	
	
	@FindBy(xpath="//table[@id='ContentPlaceHolder1_grd_data']//td[3]")
	private WebElement subscriptionNameField;
	
	
	@FindBy(xpath="//div[@class='card-box mb-0 mb-bottom mob-view']//div[@class='title']")
	private WebElement checkCurrentSubscription;
	
	
	@FindBy(xpath="//div[@class='card-box mb-0 mb-bottom mob-view']//h4[@class='page-title number-title mb-bottom strong_text']")
	private WebElement currentUserName;
	
	
	@FindBy(id="ContentPlaceHolder1_txtname")
	private WebElement usernameField;
	
	
	@FindBy(id="ContentPlaceHolder1_txtname")
	private WebElement emailField;
	
	
	@FindBy(id="ContentPlaceHolder1_txtname")
	private WebElement mobileNoField;
	
	
	@FindBy(xpath="//span[.='Team']")
	private WebElement teamBtn;
	
	
	@FindBy (xpath="//span[.='Agents']")
	private WebElement agentBtn;
	
	
	@FindBy (xpath="//span[contains(text(), 'Call List')]")
	private WebElement callListBtn;
	
	
	@FindBy(xpath="//span[.='Add - Power Import']")
	private WebElement addPowerImportBtn;

	
	public WebElement getProfileSideBar() {
		return profileSideBar;
	}

	
	public WebElement getProfileField() {
		return profileField;
	}

	
	public WebElement getSubscriptionField() {
		return subscriptionField;
	}

	
	public WebElement getSubscriptionNameField() {
		return subscriptionNameField;
	}

	
	public WebElement getCheckCurrentSubscription() {
		return checkCurrentSubscription;
	}

	
	public WebElement getCurrentUserName() {
		return currentUserName;
	}

	
	public WebElement getUsernameField() {
		return usernameField;
	}

	
	public WebElement getEmailField() {
		return emailField;
	}

	
	public WebElement getMobileNoField() {
		return mobileNoField;
	}

	
	public WebElement getTeamBtn() {
		return teamBtn;
	}

	
	public WebElement getAgentBtn() {
		return agentBtn;
	}

	
	public WebElement getCallListBtn() {
		return callListBtn;
	}

	
	public WebElement getAddPowerImportBtn() {
		return addPowerImportBtn;
	}
	
	
	
	
	

}
