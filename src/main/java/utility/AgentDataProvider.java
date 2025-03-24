package utility;


import java.io.IOException;
import org.testng.annotations.DataProvider;


public class AgentDataProvider {
	
/**
 * This method if for providing multiple sets of data using dataprovider
 * @return
 * @throws IOException
 */
    @DataProvider(name = "agentData")
    public Object[][] getAgentData() throws IOException {
        
    	PropertyFileUtility pUtil = new PropertyFileUtility(ConstantUtility.AGENT_DATA_FILE);

        //Read values from properties file
        String[] names = pUtil.readPropertyFile("agentname").split(",");
        String[] emails = pUtil.readPropertyFile("agentemail").split(",");
        String[] mobiles = pUtil.readPropertyFile("agentmob").split(",");
        String[] passwords = pUtil.readPropertyFile("agentpass").split(",");

       
        Object[][] data = new Object[names.length][4];
        for (int i = 0; i < names.length; i++) {
            data[i][0] = names[i];
            data[i][1] = emails[i];
            data[i][2] = mobiles[i];
            data[i][3] = passwords[i];
        }

        return data;
    }
}

