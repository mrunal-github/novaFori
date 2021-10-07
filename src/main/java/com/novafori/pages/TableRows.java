package com.novafori.pages;

import com.novafori.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
//In the same website, there is a <table></table>.
 //Code or describe the algorithm to count and output the number of <tr></tr> elements (number of rows).
public class TableRows extends Utility {

    public static void main(String[] args) {
        // Instantiating Chromedriver
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Maximize the browser
        driver.manage().window().maximize();

        // Implicit wait for 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("https://www.novafori.com/");

        WebElement table = driver.findElement(By.xpath(""));//xpath of table
        // Used tagName method to collect the list of items with tagName "tr"
        // findElements - to find all the elements with in the current page. It
        // returns a list of all web elements or an empty list if nothing matches
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        System.out.println(rows.size());//Printing number of rows
    }
}
