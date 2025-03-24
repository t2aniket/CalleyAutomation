package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	
	public BasePage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[.='Team']")
	private WebElement teamBtn;
	
	
	@FindBy (xpath="//span[.='Agents']")
	private WebElement agentBtn;
	
	
	@FindBy (xpath="//span[contains(text(), 'Call List')]")
	private WebElement callListBtn;
	
	
	@FindBy(xpath="//span[.='Add - Power Import']")
	private WebElement addPowerImportBtn;

	
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
