package org.example;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ProveribalIOS {


    public static String userName = "ishwarya.ganapathy";
    public static String accessKey = "H4kwD8BEy7Z64r9P4sYk9qvFcqTZsbAoWrtFaxe4b8nafFbvfg";


    public static void main(String[] args) {
        DesiredCapabilities capabilities = new DesiredCapabilities();


        capabilities.setCapability("app", "lt://APP1016025291728481321059323");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 12 Pro");
        capabilities.setCapability("platformVersion", "14.0");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("isRealMobile", true);

        AppiumDriver driver = null;
        try {
            driver = new AppiumDriver(new URL("http://" + userName + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub"), capabilities);

            // Validate app launch
            System.out.println("Hello! Welcome to the lambda test Sample App called Proverbial");

            // Click the "Color" button
            WebElement colorButton = driver.findElement(By.xpath("//XCUIElementTypeButton[@name='color']"));
            colorButton.click();
            Thread.sleep(3000); // Wait for color change
            colorButton.click();

            // Click the "Text" button and log the updated text
            WebElement textButton = driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Text']"));
            textButton.click();
            WebElement updatedText = driver.findElement(By.xpath("//XCUIElementTypeTextView[@name='Textbox']"));
            System.out.println(updatedText.getText());

            // Click the "Toast" button and log the toast message
            WebElement toastButton = driver.findElement(By.xpath("//XCUIElementTypeButton[@name='toast']"));
            toastButton.click();
            Thread.sleep(4000);

            // Click the "Notification" button
            WebElement notificationButton = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Notification']"));
            notificationButton.click();

        /*    WebElement notificationTitle = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='NotificationTitle']"));
            notificationTitle.click();*/

            Thread.sleep(10000); // Wait for notification change
            // Click the "GeoLocation" button and navigate back
            WebElement geoLocationButton = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='GeoLocation']"));
            geoLocationButton.click();
            Thread.sleep(3000);
            WebElement Backbuttn = driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Back']"));
            Backbuttn.click();
            // Click the "Browser" button
            WebElement browserButton = driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Browser']"));
            browserButton.click();
            Thread.sleep(3000);
            // Enter URL and click "Find" button
            WebElement urlField = driver.findElement(By.xpath("//XCUIElementTypeOther[@name='search']"));
            urlField.sendKeys("lambdatest");
            WebElement findButton = driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Search']"));
            findButton.click();
            //URL launch page validate
            System.out.println("Test is Passed ");

            //Verifiying to Handle No Such ElementException
            WebElement geoLocationButton1 = driver.findElement(By.xpath("//XCUIElementTypeButton[@name='geoLocation']"));
            geoLocationButton1.click();


        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
        } catch (ElementClickInterceptedException e) {
            System.out.println("Element click intercepted: " + e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}



