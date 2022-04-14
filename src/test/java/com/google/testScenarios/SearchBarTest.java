package com.google.testScenarios;

import org.testng.annotations.Test;

import com.google.base.TestBase;
import com.google.pages.TestPages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class SearchBarTest extends TestBase {
  @Test
  public void f() {
	  TestPages tester= new TestPages();
	  tester.searchBar("we did it!!!");
  }
  @BeforeMethod
  public void beforeMethod() {
	  navigateToUrl();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.navigate().refresh();
  }

  @BeforeClass
  public void beforeClass() {
	  setUp();
  }

  @AfterClass
  public void afterClass() {
	  tearDown();
  }

}
