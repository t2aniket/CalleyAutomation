package utility;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;

public class PropertyFileUtility {
    
    private Properties pObj;
    private FileInputStream fis;
   
    /**
     * This method will load the properties file 
     * @param filePath
     */
    public PropertyFileUtility(String filePath)  {
        
        try {
        	fis = new FileInputStream(filePath);
        	pObj = new Properties();
			pObj.load(fis);
		} catch (IOException e) {
			
			Reporter.log(e.getMessage());
		}  
    }
    
    /**
     * this method will return the value of the given key from property file
     * @param key
     * @return
     */
    public String readPropertyFile(String key) {
        return pObj.getProperty(key);
    }
    
    /**
     * This method will close the opened file using file input stream
     */
    public void closeFile() {
        if (fis != null) {
            try {
				fis.close();
			} catch (IOException e) {
				Reporter.log(e.getMessage());
			}
        }
        
    }
}
