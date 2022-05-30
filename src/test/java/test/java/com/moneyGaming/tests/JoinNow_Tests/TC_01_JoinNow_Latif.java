package test.java.com.moneyGaming.tests.JoinNow_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.com.moneyGaming.tests.utilities.ConfigurationReader;
import test.java.com.moneyGaming.tests.utilities.Driver;

public class TC_01_JoinNow_Latif {

    WebDriver driver;

    @BeforeMethod
    public void setup_Method(){
        driver = Driver.getDriver();
        //1. Navigate to: https://moneygaming.qa.gameaccount.com/
        driver.get(ConfigurationReader.getProperty("env"));
    }


    @AfterMethod
    public void tearDown_Method(){
        driver.close();
    }

    @Test
    public void joinNow_Test(){

        //2. Click the JOIN NOW button to open the registration page
        WebElement joinNowButton = driver.findElement(By.xpath("//div[@class='login_links']//a[.='Join Now!']"));
        joinNowButton.click();

        //3. Select a title value from the dropdown
        //Locate the title dropdown
        Select select = new Select(driver.findElement(By.xpath("//select[@name='map(title)']")));
        select.selectByVisibleText("Mr");

        //4. Enter your first name and surname in the form

        WebElement firstNameInputField= driver.findElement(By.xpath("//input[@name='map(firstName)']"));
        firstNameInputField.sendKeys("Madara");

        WebElement lastNameInputField = driver.findElement(By.xpath("//input[@name='map(lastName)']"));
        lastNameInputField.sendKeys("Uchiha");

        //5. Check the tick box with text 'I accept the Terms and Conditions and certify that I am over the age of 18.
        WebElement submitFormCheckBox= driver.findElement(By.xpath("//input[@name='map(terms)']"));
        submitFormCheckBox.click();

        WebElement joinNowButton_InSignUpPage= driver.findElement(By.xpath("//input[@value='Join Now!']"));
        joinNowButton_InSignUpPage.click();

        //7. Validate that a validation message with text ‘ This field is required’ appears under the date of birth box

        WebElement errorMessageUnderTheDateOfBirthBox = driver.findElement(By.xpath("//label[@for='dob']"));
        String expected_ErrorMessage= "This field is required";

        String actual_ErrorMessage= errorMessageUnderTheDateOfBirthBox.getText();

        Assert.assertEquals(actual_ErrorMessage, expected_ErrorMessage);


    }


}
/*
Task 2:
1. Navigate to: https://moneygaming.qa.gameaccount.com/
2. Click the JOIN NOW button to open the registration page
3. Select a title value from the dropdown
4. Enter your first name and surname in the form
5. Check the tick box with text 'I accept the Terms and Conditions and certify that I am over
the age of 18.'
6. Submit the form by clicking the JOIN NOW button
7. Validate that a validation message with text ‘ This field is required’ appears under the date of
birth box

 */