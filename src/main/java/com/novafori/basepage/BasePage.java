package com.novafori.basepage;



import com.novafori.propertyreader.PropertyReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
        * Test Base class (TestBase.java) deals with all the common functions used by all the pages.
        * This class is responsible for loading the configurations from properties files,
        * Initializing the WebDriver, Implicit Waits, Extent Reports,
        * and also to create the object of FileInputStream which is responsible for pointing
        * towards the file from which the data should be read.
        */

public class BasePage {
   public static WebDriver driver;
   String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");
   String projectPath = System.getProperty("user.dir");
   private static final Logger log = LogManager.getLogger(BasePage.class.getName());

   public BasePage() {
      PageFactory.initElements(driver,this);
      PropertyConfigurator.configure(projectPath + "/src/test/java/resources/propertiesfile/log4j.properties");
   }

   public void selectBrowser(String browser) {
      if (browser.equalsIgnoreCase("chrome")) {
         System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");
         log.info("Launching Chrome Browser ");
         driver = new ChromeDriver();
      } else if (browser.equalsIgnoreCase("firefox")) {
         System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver.exe");
         log.info("Launching FireFox Browser ");
         driver = new FirefoxDriver();
      } else if (browser.equalsIgnoreCase("ie")) {
         System.setProperty("webdriver.ie.driver", projectPath + "/drivers/IEDriverServer.exe");
         log.info("Launching IE Browser");
         driver = new InternetExplorerDriver();
      } else {
         log.info("Wrong browser name");
         System.out.println("Wrong browser name");
      }
      driver.manage().window().maximize();
      driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
      driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertyReader.getInstance().getProperty("implicitlyWait")), TimeUnit.SECONDS);
      driver.get(baseUrl);
   }

   public void closeBrowser(){
      if (driver != null){
         driver.quit(); }
   }

}


