package utility;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class WebDriverUtility {
	
	
	/**
	 * This function will maximize the browser 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	
	
	
	/**
	 * This function will minimize the browser
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
		
	}
	
	
	/**
	 * This function is for implicitly wait it will wait for 10 second for page to load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	
	/**
	 * This function checks if the element in visible on the webpage and waits for 20 seconds before giving exception
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.visibilityOf(element));
	        
	    } catch (Exception e) {
	        Reporter.log("Element not visible after waiting for 20 seconds: " + element);
	    }
	}
	
	
	/**
	 * This function checks if the element in clickable on the webpage and waits for 20 seconds before giving exception
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) 
	{
		try {
			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Exception e)
		{
			Reporter.log("Element not clickable after waiting for 20 seconds: " + element);
		}
	}
	
	/**
	 * This method will perform right action mouse click on the provided element
	 * @param driver
	 * @param element
	 * 
	 */
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	
	/**
	 * this method will perform double click on the given element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	
	/**
	 * This method will perform javascript execution for click
	 * useful where there is overlay or the elements are in css
	 * @param driver
	 * @param element
	 */
	 public void javaScriptExecutorClick(WebDriver driver, WebElement element) {
	        try {
	            JavascriptExecutor js = (JavascriptExecutor) driver;  // Cast WebDriver to JavascriptExecutor
	            js.executeScript("arguments[0].click();", element);  // Click using JS Executor
	        } catch (Exception e) {
	            Reporter.log("Click Failed with exception: "+e.getMessage());
	        }
	 }
	 
	 
	 /**.
	  * This method will switch to iframe with the given webelement
	  * @param driver
	  * @param element
	  */
	 public void switchToiFrame(WebDriver driver,WebElement element )
	 {
		 
		 driver.switchTo().frame(element);
	 }
	 
	 
	 /**
	  * This method will switch to iframe with the given index number
	  * @param driver
	  * @param index
	  */
	 public void switchToiFrame(WebDriver driver,int index )
	 {
		 
		 driver.switchTo().frame(index);
	 }
	 
	 /**
	  * This method will switch back to orignal window
	  * @param driver
	  */
	public void swtichToDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	

    /**
     * This method will return true or false for particular attribute with its acutal and expected value
     * @param driver WebDriver instance.
     * @param element The WebElement to check.
     * @param attributeName The name of the attribute.
     * @param expectedValue The expected value of the attribute.
     * @param timeout Timeout in seconds.
     * @return true if the attribute value matches, false otherwise.
     */
    public  boolean waitForAttributeValue(WebDriver driver, WebElement element, String attributeName, String expectedValue, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            return wait.until(driver1 -> expectedValue.equals(element.getAttribute(attributeName)));
        } catch (Exception e) {
            return false;
        }
    }
    
    
    /**
     * This method will move the move over given element
     * @param driver
     * @param element
     */
    
    public void moveToElement(WebDriver driver,WebElement element)
    {
    	Actions ac = new Actions(driver);
        ac.moveToElement(element).perform();
    	
    	
    }
    
    
    /**
     * This metod will select the value by visible text using select class
     * @param element
     * @param text
     */
    public void selectByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
    

   /**
    * This method will select the value by its value using select class
    * @param element
    * @param value
    */
    public void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }
    

    /**
     * This method will select the value by given index using select class
     * @param element
     * @param index
     */
    public void selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    
    /**
     * This method will return true or fale for the visibility of the element on webage 
     * Will throw exception after waiting for 20 secs
     * @param driver
     * @param element
     * @return
     */
    public boolean isElementVisible(WebDriver driver,WebElement element)
    {
    	try {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.visibilityOf(element));
    	return true;
    	}
    	
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		Reporter.log("Element not visible within timeout: " + element.toString());
    	   
    	return false;
    	}
    }
    
    
}
