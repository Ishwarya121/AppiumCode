package org.example;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ProveribalAndroid {

    public static String userName = "ishwarya.ganapathy";
    public static String accessKey = "H4kwD8BEy7Z64r9P4sYk9qvFcqTZsbAoWrtFaxe4b8nafFbvfg";


    public static void main(String[] args) {
        DesiredCapabilities capabilities = new DesiredCapabilities();


        capabilities.setCapability("app", "lt://APP10160542501728481258934820");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Galaxy S20");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("isRealMobile", true);

        AppiumDriver driver = null;
        try {
            driver = new AppiumDriver(new URL("http://" + userName + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub"), capabilities);

            // Validate app launch
            System.out.println("Hello! Welcome to the lambda test Sample App called Proverbial");

            // Click the "Color" button
            WebElement colorButton = driver.findElement(By.xpath("//android.widget.Button[@text='COLOR']"));
            colorButton.click();
            Thread.sleep(3000); // Wait for color change
            colorButton.click();

            // Click the "Text" button and log the updated text
            WebElement textButton = driver.findElement(By.xpath("//android.widget.Button[@text='TEXT']"));
            textButton.click();
            WebElement updatedText = driver.findElement(By.xpath("//android.widget.TextView[@text='Proverbial']"));
            System.out.println(updatedText.getText());

            // Click the "Toast" button and log the toast message
            WebElement toastButton = driver.findElement(By.xpath("//android.widget.Button[@text='TOAST']"));
            toastButton.click();
            WebElement toastMessage = driver.findElement(By.xpath("//android.widget.Toast"));
            System.out.println(toastMessage.getText());

            // Click the "Notification" button
            WebElement notificationButton = driver.findElement(By.xpath("//android.widget.Button[@text='NOTIFICATION']"));
            notificationButton.click();
            Thread.sleep(3000); // Wait for notification change
            // Click the "GeoLocation" button and navigate back
            WebElement geoLocationButton = driver.findElement(By.xpath("//android.widget.Button[@text='GEOLOCATION']"));
            geoLocationButton.click();
            driver.navigate().back();

            // Click the "Browser" button
            WebElement browserButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Browser']"));
            browserButton.click();

            // Enter URL and click "Find" button
            WebElement urlField = driver.findElement(By.xpath("//android.widget.EditText"));
            urlField.sendKeys("www.lambdatest.com");
            WebElement findButton = driver.findElement(By.xpath("//android.widget.Button[@text='FIND']"));
            findButton.click();
            //URL launch page validate
            int ExpLambdatestimg = driver.findElements(By.xpath("//android.widget.Button[@text='Logo']")).size();
            if (ExpLambdatestimg=='1') {
                System.out.println("URl is launched ");
            }
            else {
                System.out.println("URl is not present ");
            }
            //Verifiying to Handle No Such ElementException
            WebElement geoLocationButton1 = driver.findElement(By.xpath("//android.widget.Image[@text='GEOLOCATION']"));
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
