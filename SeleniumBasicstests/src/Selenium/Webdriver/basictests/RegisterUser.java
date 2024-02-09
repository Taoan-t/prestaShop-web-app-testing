package Selenium.Webdriver.basictests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/*
Test Case 1: Register User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
*/

public class RegisterUser {	

	public static void main(String[] args) {	
		String nameValue="sunny";
		String emailValue="sunny@gmail.com";
		String titleValue="Mr.";
		String pwValue="ab123@!jede";
		int dobValueDay=16;
		int dobValueMonth=10;
		int dobValueYear=1996;
		
		
		WebDriver driver=new FirefoxDriver();// Launch browser	
		
		try {
			driver.get("https://www.automationexercise.com/");// Open URL in the browser
			
			// Verify that home page is visible successfully
			WebElement headerElement=driver.findElement(By.id("header"));
			if(headerElement.isDisplayed()) {
				System.out.println("Home page is visible successfully.");
			}else {
				System.out.println("Home page is not visible.");
			}
			
			// Click on 'Signup / Login' button
			WebElement loginElement=driver.findElement(By.cssSelector("[href='/login']"));
			loginElement.click();
			
			// Verify 'New User Signup!' is visible
			WebElement loginFormElement=driver.findElement(By.className("signup-form"));
			if(loginFormElement.isDisplayed()) {
				System.out.println("New User Signup is visible successfully.");
			}else {
				System.out.println("New User Signup is not visible.");
			}
			
			// Enter name and email address
			WebElement signUpForm=driver.findElement(By.className("signup-form"));
			WebElement nameInput=signUpForm.findElement(By.name("name"));
			WebElement emailInput=signUpForm.findElement(By.name("email"));
			nameInput.sendKeys(nameValue);
			emailInput.sendKeys(emailValue);
			
			// Click 'Signup' button
			WebElement signUpBtn=signUpForm.findElement(By.tagName("button"));
			signUpBtn.click();
			
			// Verify that 'ENTER ACCOUNT INFORMATION' is visible
			WebElement fillInfoForm=driver.findElement(By.id("form"));
			if(fillInfoForm.isDisplayed()) {
				System.out.println("'ENTER ACCOUNT INFORMATION' is visible successfully.");
			}else {
				System.out.println("'ENTER ACCOUNT INFORMATION' is not visible.");
			}
			
			// Fill details: Title, Password, Date of birth
			if(titleValue.contentEquals("Mr.")) {
				WebElement MrRadioBtn=driver.findElement(By.id("id_gender1"));
				if(!MrRadioBtn.isSelected()) {
					MrRadioBtn.click();
				}
			}else {
				WebElement MrsRadioBtn=driver.findElement(By.id("id_gender2"));
				if(!MrsRadioBtn.isSelected()) {
					MrsRadioBtn.click();
				}
			}
			
			WebElement passwordInput=fillInfoForm.findElement(By.id("password"));
			passwordInput.sendKeys(pwValue);
			
			WebElement dayDropdown=fillInfoForm.findElement(By.id("days"));
			Select dayOption=new Select(dayDropdown); // 用Select class创建一个下拉列表对象
			dayOption.selectByValue(String.valueOf(dobValueDay));
			
			WebElement monthDropdown=fillInfoForm.findElement(By.id("months"));
			Select monthOption=new Select(monthDropdown);
			monthOption.selectByValue(String.valueOf(dobValueMonth));
			
			WebElement yearDropdown=fillInfoForm.findElement(By.id("years"));
			Select yearOption=new Select(yearDropdown);
			yearOption.selectByValue(String.valueOf(dobValueYear));
			
			// Select checkbox 'Sign up for our newsletter!'
			WebElement newsletterCb=fillInfoForm.findElement(By.id("newsletter"));
			if(!newsletterCb.isSelected()) {
				newsletterCb.click();
			}			
			
			// Select checkbox 'Receive special offers from our partners!'
			WebElement offersCb=fillInfoForm.findElement(By.id("optin"));
			if(!offersCb.isSelected()) {
				offersCb.click();
			}
		}
		finally{
			driver.quit();
		}
		
		


	}

}
