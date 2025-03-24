package base;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

import utility.PropertyFileUtility;
import utility.WebDriverUtility;

public class BaseClass {
	
	public PropertyFileUtility pUtil;
	public WebDriverUtility wUtil= new WebDriverUtility(); 
	public static WebDriver driver= null;
	
	
	
	/**
	 * This method will load the property file
	 * @param propertyFilePath
	 */
	public void setPropertyFile(String propertyFilePath) {
        pUtil = new PropertyFileUtility(propertyFilePath);
    }
	
	

	/**
	 * This method will open the browser and go to the given url
	 */
	public void browserConfig() {
		
		
		String BROWSER = pUtil.readPropertyFile("browser");
		String URL = pUtil.readPropertyFile("url");
		
		Reporter.log("Opening Browser");
		if (BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			
		}
		
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
	
		}
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		Reporter.log("Visiting URL "+URL);		
		
	}
	
	
	/**
	 * This method will close the driver
	 */
	@AfterClass
	public void close() {
		pUtil.closeFile();
		driver.quit();
	}

}
