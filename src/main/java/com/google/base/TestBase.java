package com.google.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {
public static WebDriver driver;
FileInputStream fis;
Properties prop;

protected void setUp() {
	prop= new Properties();
	try {
		fis= new FileInputStream(".\\src\\main\\resources\\config.properties");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		prop.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	if(prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver",".\\src\\test\\resources\\drivers\\chromedriver.exe" );
		driver=new ChromeDriver();
	}else if(prop.getProperty("Browser").equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver",".\\src\\test\\resources\\drivers\\geckodriver.exe" );
		driver=new FirefoxDriver();
	}
}

protected void navigateToUrl() {
	driver.get(prop.getProperty("URL"));
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
}

protected void tearDown() {
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.quit();
}

}
