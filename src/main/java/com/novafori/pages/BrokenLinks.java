package com.novafori.pages;

import com.novafori.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import javax.rmi.CORBA.Util;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//	Given a URL, open a browser,
// collect all the links within the HTML and check if all of them are ok (no 404 code).
public class BrokenLinks extends Utility {

    public static void main(String[] args) throws IOException {

        // Instantiating Chromedriver
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Maximize the browser
        driver.manage().window().maximize();

        // Implicit wait for 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.novafori.com/");

//

        //1. get the list of links and images
        List<WebElement> linksList = driver.findElements(By.tagName("a"));
        linksList.addAll(driver.findElements(By.tagName("img")));

        List<WebElement> activeLinks = new ArrayList<WebElement>();

        //2. iterate linksList
        for (int i = 0; i < linksList.size(); i++) {
            System.out.println(linksList.get(i).getAttribute("href"));
            if (linksList.get(i).getAttribute("href") != null && (!linksList.get(i).getAttribute("href").contains("javascript"))) {
                activeLinks.add(linksList.get(i));
            }
        }
        // get the size of active links List
        System.out.println("size of active links and images ----->" + activeLinks.size());


        //3. check the href url, with httpconnection

        for (int j = 0; j < activeLinks.size(); j++) {
            HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();

            connection.connect();
            String response = connection.getResponseMessage();
            connection.disconnect();
            System.out.println(activeLinks.get(j).getAttribute("href") + "----->" + response);
            driver.quit();

        }
    }
}


