package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.google.base.TestBase;

public class TestPages extends TestBase{
	public void searchBar(String s) {
	By searchBarLoc= By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input");
	driver.findElement(searchBarLoc).clear();
	driver.findElement(searchBarLoc).sendKeys(s);
	driver.findElement(searchBarLoc).sendKeys(Keys.ENTER);
}
}
