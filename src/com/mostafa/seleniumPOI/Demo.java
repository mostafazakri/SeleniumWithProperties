package com.mostafa.seleniumPOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Demo {

    public static void main(String[] args) throws IOException {
        File file = new File("config//propertiesFile.properties");
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(file);
        prop.load(fis);

        String browserName = prop.getProperty("Browser");
        WebDriver driver = null;  

        if (browserName.equals("Firefox")) {
            System.setProperty("webdriver.chrome.driver", "drivers//geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browserName.equals("IE")) {
            System.setProperty("webdriver.ie.driver", "drivers//IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        
        driver.get(prop.getProperty("URL"));
        System.out.println(driver.getTitle());
        
    }
}
 






