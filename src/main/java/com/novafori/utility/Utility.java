package com.novafori.utility;



import com.novafori.basepage.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
        * Utility class (TestUtil.java) stores and handles the functions
        * (The code which is repetitive in nature such as waits, actions, capturing screenshots, accessing excels, sending email, etc.,)
        * which can be commonly used across the entire framework. The reason behind creating a utility class is to achieve reusability.
        * This class extends the TestBase class to inherit the properties of TestBase in TestUtil.
        * Inheritance (OOPS concept)
        * We extend the Base Class in other classes such

 */
public class Utility extends BasePage {

    /*Utility Class extends to BasePage for the driver to finding locators
     *All common methods are fixed in the utility Class.
     *
     * This method will generate random number
     */
    public int generateRandomNumber() {
        return (int) (Math.random() * 5000 + 1);

    }

    // this default method generate random number

    public Random randomGenerator = new Random();
    public int randomInt = randomGenerator.nextInt(1000);

    public void iEnterEmail(String email)  {
        Random r = new Random();
        email= "topper" + r.nextInt() + "@gmail.com";
        //new RegistrationPage().enterEmail(email);use this method as a whole in perticular page
        System.out.println(email);//dont call it from utility as ther is no element inside

    }
    /**
     * This method will generate random string
     */
    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * This method will click on element
     */
    public void clickOnElement(WebElement element) {
        element.click();
    }

    /**
     * This method will return text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    /**
     * This method will send text to element or field
     */
    public void sendTextToElement(By by, String str) {
        driver.findElement(by).sendKeys(str);
    }

    public void sendTextToElement(WebElement element, String str) {
        element.sendKeys(str);
    }

    /**
     * This method will used to hover mouse on element
     */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }

    public void mouseHoverToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    /**
     * This method will used to hover mouse on element and click
     */
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().perform();
    }

    public void mouseHoverToElementAndClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    /**
     * This method will used to select drop down menu by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String str) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(str);
    }

    public void selectByVisibleTextFromDropDown(WebElement element, String str) {
        Select select = new Select(element);
        select.selectByVisibleText(str);
    }

    /**
     * This method will used to select drop down menu by index
     */
    public void selectByIndexFromDropDown(By by, int index) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }

//    public void selectByIndexFromDropDown(WebElement element) {
//        Select select = new Select(element);
//        select.selectByIndex(index);
//    }

    /**
     * This method will used to select drop down menu by value
     */
    public void selectByValueFromDropDown(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

//    public void selectByValueFromDropDown(String value) {
//        Select select = new Select(element);
//        select.selectByValue(value);
//    }

    /**
     * This method will used to wait web driver until element become clickable
     */
    public void waitUntilElementToBeClickable(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
    }
    /**
     * This method will used to wait web driver until element become clickable
     */
    public void waitUntilElementToBeClickable(WebElement element, int timeout) {

        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * This method will used to wait web driver until presence of element located by locator
     */
    public void waitUntilPresenceOfElementLocated(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * This method will used to wait web driver until visibility of element located by locator
     */
    public void waitUntilVisibilityOfElementLocated(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilVisibilityOfElementLocated(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf( element ));
    }




    /**
     * This method will verify that element is displayed
     */
    public boolean verifyThatElementIsDisplayed(By by) {
        WebElement element = driver.findElement(by);
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyThatElementIsDisplayed(WebElement element) {
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method will verify that element is displayed
     */
    public boolean verifyThatTextIsDisplayed(By by, String text) {
        WebElement element = driver.findElement(by);
        if (text.equals(element.getText())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyThatTextIsDisplayed(WebElement element, String text) {
        if (text.equals(element.getText())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method will returns list of web elements
     */
    public List<WebElement> webElementList(By by) {
        return driver.findElements(by);
    }
    public List<WebElement> getListOfElements(List<WebElement> element) {

        return (List<WebElement>) element;
    }


    //this method will arrange price in high to low order
    public List<Double> sortPrice(By by) {
        List<WebElement> price1 = driver.findElements(by);
        List<Double> price2 = new ArrayList<>();
        for (WebElement p : price1) {
            price2.add(Double.parseDouble(p.getText().replace("$", "")));
        }
        return price2;
    }

    // this method is for element
    public List<Double> sortPriceWebelement(WebElement element) {
        List<WebElement> price1 = (List<WebElement>) element;
        List<Double> price2 = new ArrayList<>();
        for (WebElement p : price1) {
            price2.add(Double.parseDouble(p.getText().replace("$", "")));
        }
        return price2;
    }
    // sort by rates by by
    public List<Double> sortByRates(By by) {
        List<WebElement> productRates = driver.findElements(by);
        List<Double> afterVerifyRates = new ArrayList<>();
        for (WebElement r : productRates) {
            String rates = r.getAttribute("style").replace("width:","");
            afterVerifyRates.add(Double.parseDouble(rates.replace("%;", "")));
        }
        return afterVerifyRates;
    }

    public List<Double> sortByRatesElement(WebElement element) {
        List<WebElement> productRates = (List<WebElement>) element;
        List<Double> afterVerifyRates = new ArrayList<>();
        for (WebElement r : productRates) {
            String rates = r.getAttribute("style").replace("width:","");
            afterVerifyRates.add(Double.parseDouble(rates.replace("%;", "")));
        }
        return afterVerifyRates;
    }


    /**
     * This method will clear previous stored data
     */
    public void clearTextFromField(By by) {
        driver.findElement(by).sendKeys(Keys.CONTROL + "a");
        driver.findElement(by).sendKeys(Keys.DELETE);
    }

    public void sendTabAndEnterKey(By by) {
        driver.findElement(by).sendKeys(Keys.TAB);
        //driver.findElement(by).sendKeys(Keys.ENTER);
    }


    /**
     * This method will take screen shot
     */
    public static void takeScreenShot() {
        String filePath = System.getProperty("user.dir") + "/src/main/java/com/novafori/screenshots/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scr1, new File(filePath + getRandomString(10) + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
   Screenshot methods
   */
    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    public static String getScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // After execution, you could see a folder "FailedTestsScreenshots" under screenshot folder
        String destination = System.getProperty("user.dir") + "src/main/java/com/novafori/screenshots" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }
}

