package agoda.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
    private Properties prop;
    private final String configPropertyFilePath = "config//config.properties";

    public ConfigReader()
    {
        BufferedReader bufferedReader;
            try {
                    bufferedReader = new BufferedReader(new FileReader(configPropertyFilePath));
            
                    prop = new Properties();
                     try{
                             prop.load(bufferedReader);
                             bufferedReader.close();
                        }
                    catch (IOException exp)
                    {
                        exp.printStackTrace();
                    }
                }
            catch (FileNotFoundException e) 
            {
                
                e.printStackTrace();
                throw new RuntimeException("config.properties file not found: " + configPropertyFilePath);
            }
    }

    public String getEnvironment()
    {
        return prop.getProperty("environment");
    }
    public String getBrowserName()
    {
        return prop.getProperty("browser");
    }
    public String getBaseUrl()
    {
        return prop.getProperty("baseUrl");
    }
}
