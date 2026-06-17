package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
    public static void main(String[] args) {

        // Setup ChromeDriver automatically (no manual install needed)
        WebDriverManager.chromedriver().setup();

        // Chrome options for Jenkins/CI
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        // Start browser
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open site
            driver.get("https://www.saucedemo.com");

            // Login steps
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // Optional verification (basic check)
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL after login: " + currentUrl);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Always close browser
            driver.quit();
        }
    }
}
