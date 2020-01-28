package br.com.rsinet.hub_bdd.dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import br.com.rsinet.hub_bdd.enums.DriverType;
import br.com.rsinet.hub_bdd.enums.EnvironmentType;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath="configs/Configuation.properties";

	
	public ConfigFileReader() {
		BufferedReader reader;	
		try {
			reader=new BufferedReader(new FileReader(propertyFilePath));
			properties=new Properties();
			try {
				properties.load(reader);
				reader.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}	catch(FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}
	
	public String getDriverPath() {
		String driverPath=properties.getProperty("driverPath");
		if(driverPath!=null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitWait");
		if(implicitlyWait != null) 
		{
			try {
				return Long.parseLong(implicitlyWait);
			}catch(NumberFormatException e) {
				throw new RuntimeException("Not able to parse: "+implicitlyWait);
			}
		}
		return 30;
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public DriverType getBrowser() {
		String browser=properties.getProperty("browser");
		if(browser==null|| browser.equalsIgnoreCase("chrome"))
			return DriverType.CHROME;
		else if(browser.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if(browser.equalsIgnoreCase("internetexplorer"))
			return DriverType.INTERNETEXPLORER;
		else
			throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " +browser);
	}
	
	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
		else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}
	
	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if(windowSize != null) return Boolean.valueOf(windowSize);
		return true;	
	}	
	
	
	public String getTestDataResourcePath() {
		String testDataResourcePath=properties.getProperty("testDataResourcePath");
		if(testDataResourcePath!= null) return testDataResourcePath;
		else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
	}
	
	public String getReportConfigPath() {
		String reportPath=properties.getProperty("reportConfigPath");
		if(reportPath!=null)
			return reportPath;
		else 
			throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}
	
}
