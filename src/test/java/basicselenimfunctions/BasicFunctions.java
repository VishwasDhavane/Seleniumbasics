package basicselenimfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BasicFunctions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32 (8)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//String a=driver.getTitle();
		System.out.println(driver.getTitle());
		//To add input value to text field
		WebElement firstname=driver.findElement(By.id("firstName"));
		firstname.sendKeys("Test1");
		
		WebElement lastname=driver.findElement(By.id("lastName"));
		lastname.sendKeys("Test2");
		
		WebElement email=driver.findElement(By.id("userEmail"));
		email.sendKeys("Test2@example.com");
		
		//click on radio button
		
		//org.openqa.selenium.ElementClickInterceptedException:
		//used actions class to click
		
		Actions act =  new Actions(driver);
		act.moveToElement(driver.findElement(By.id("gender-radio-1"))).click().perform();

		driver.get("https://demoqa.com/select-menu");
		//String b=driver.getTitle();
		System.out.println(driver.getTitle());
		//select class
		
		Select objSelect =new Select(driver.findElement(By.id("oldSelectMenu")));
		objSelect.selectByVisibleText("Yellow");
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");	
		System.out.println(driver.getTitle());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,50)", "");
	  
		WebElement hover  = driver.findElement(By.id("mousehover"));

		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(hover).click().build().perform();
		//checkbox
		WebElement checkbox  = driver.findElement(By.id("checkBoxOption1"));
		checkbox.click();
		
		if(!checkbox.isSelected())
			checkbox.click();
		
		
		//handling alerts
		
		WebElement alert  = driver.findElement(By.id("alertbtn"));
		alert.click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		driver.quit();
		
		
	}

}
