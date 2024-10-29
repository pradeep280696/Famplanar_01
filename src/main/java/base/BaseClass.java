package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{
	
	 public WebDriver driver;
     
     @BeforeMethod
      public void initializeDriver(@Optional("chrome") String browserName) 
      { 
    	  Properties prop = new Properties();
          FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\Selenium\\Famplanr\\Configuration\\config.configuration"); 
				prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			catch (IOException e) {
				e.printStackTrace();
		}
          String browserName1  = prop.getProperty("browser");
          String urlName  = prop.getProperty("url");
          
          switch(browserName1.toLowerCase())
          {
          case "chrome":
        	  WebDriverManager.chromedriver().setup();
        	  driver = new ChromeDriver();
        	  break;
        	  
          case "firefox":
        	  WebDriverManager.firefoxdriver().setup();
        	  driver = new FirefoxDriver();
        	  break;
        	  
          case "edge":
        	  WebDriverManager.edgedriver().setup();
        	  driver = new EdgeDriver();
        	  break;
        	  
        	  default:
        		  System.out.println("Entered browserName is invalid");
          }
          driver.manage().window().maximize();
          driver.manage().deleteAllCookies();
          driver.manage().timeouts().implicitlyWait(Integer.parseInt(System.getProperty("waitTime")), TimeUnit.SECONDS);
          driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(System.getProperty("waitTime")), TimeUnit.SECONDS);
          driver.get(urlName);    
      }
      
      @AfterMethod
      public void closeApplication(){
    	  
    	  driver.quit();
    	  System.out.println();      }

}
