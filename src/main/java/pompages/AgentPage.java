package pompages;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



 
public class AgentPage {
    WebDriver driver;

    public AgentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    

    @FindBy(id="ContentPlaceHolder1_txt_name")
    private WebElement agentNameField;
    

    @FindBy(id="ContentPlaceHolder1_txt_mobile")
    private WebElement agentMobileField;
    

    @FindBy(id="ContentPlaceHolder1_txt_email")
    private WebElement agentEmailField;
    

    @FindBy(id="ContentPlaceHolder1_txt_pass")
    private WebElement agentPasswordField;
   
    
	@FindBy(id="ContentPlaceHolder1_btn_submit")
    private WebElement agentDetailsSubmitBtn;

	
    @FindBy(xpath="//button[text()='OK']")
    private WebElement agentAddedConfirmationBtn;

    
    @FindBy(xpath="//table[@id='dt_table']//tbody/tr")
    private List<WebElement> agentTableRows;

    /**
     * This method will check the agent is added or not and will return true if added else false
     * This method check with the loaded name in table and the name that was passed 
     * @param name
     * @param email
     * @return
     */
    public boolean isAgentAdded(String name, String email) {
        for (WebElement row : agentTableRows) {
            String rowName = row.findElement(By.xpath("./td[3]")).getText();
        
            String rowEmail = row.findElement(By.xpath("./td[4]")).getText();
         
            if (rowName.equals(name) && rowEmail.equals(email)) {
                return true;
            }
        }
        return false;
    }


	public WebElement getAgentNameField() {
		return agentNameField;
	}
	
	

	public WebElement getAgentMobileField() {
		return agentMobileField;
	}
	
	

	public WebElement getAgentEmailField() {
		return agentEmailField;
	}
	
	

	public WebElement getAgentPasswordField() {
		return agentPasswordField;
	}
	
	

	public WebElement getAgentAddedConfirmationBtn() {
		return agentAddedConfirmationBtn;
	}
	
	

	public List<WebElement> getAgentTableRows() {
		return agentTableRows;
	}
	
	
	
	  public WebElement getAgentDetailsSubmitBtn() {
			return agentDetailsSubmitBtn;
		}

	
	
    
    
    
    
}
