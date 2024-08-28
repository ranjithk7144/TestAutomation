package appHooks;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.gherkin.model.Scenario;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
public class ApplicationHooks {

private ConfigReader configReader;
private WebDriver driver;
Properties prop;


@Before(order = 0)
public void getProperty()
{
	configReader= new ConfigReader();
	prop=configReader.init_prop();
}

@Before(order = 1)
public void launchBrowser()
{
	String browserName=prop.getProperty("browser");
	DriverFactory driverFactory=new DriverFactory();
	driver= driverFactory.init_driver(browserName); 	
}

@After(order = 0)
public void quitBrowser()
{
	driver.quit();	
}


@After(order = 1)
public void tearDown()
{
	System.out.println("Test Failed screenshot");		
}
}
