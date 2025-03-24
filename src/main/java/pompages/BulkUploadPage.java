package pompages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BulkUploadPage {

    WebDriver driver;  

    public BulkUploadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



	@FindBy(xpath = "//div[@class='btn-group']//button")
    private WebElement agentSelectBtn;

	
    @FindBy(id = "ContentPlaceHolder1_txtlistname")
    private WebElement listName;
    
    
    @FindBy(xpath="//label[@class='checkbox']//input[@value='all']")
    private WebElement selectAllAgents;


	@FindBy(id = "ContentPlaceHolder1_fileUpload")
    private WebElement fileUpload;

	
    @FindBy(id = "btnUp")
    private WebElement uploadbtn;
    
    
    @FindBy(xpath="//button[@class='confirm']")
    private WebElement confirmBtn;
    
    
    @FindBy(id="ddlbelongto_1")
    private WebElement coloum1DropDown;
    
    
    @FindBy(id="ddlbelongto_2")
    private WebElement coloum2DropDown;
    
    
    @FindBy(id="ddlbelongto_3")
    private WebElement coloum3DropDown;
    
    
    @FindBy(id="ContentPlaceHolder1_btnUpload")
    private WebElement importDataBtn;
    
    

    public WebElement getColoum1DropDown() {
		return coloum1DropDown;
	}

	public WebElement getColoum2DropDown() {
		return coloum2DropDown;
	}

	public WebElement getColoum3DropDown() {
		return coloum3DropDown;
	}

	public WebElement getImportDataBtn() {
		return importDataBtn;
	}
	
    public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAgentSelectBtn() {
		return agentSelectBtn;
	}

	public WebElement getListName() {
		return listName;
	}

	public WebElement getFileUpload() {
		return fileUpload;
	}

	public WebElement getUploadbtn() {
		return uploadbtn;
	}

	public WebElement getConfirmBtn() {
		return confirmBtn;
	}

	public WebElement getSelectAllAgents() {
			return selectAllAgents;
		}

}
