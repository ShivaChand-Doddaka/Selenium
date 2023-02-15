import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException 
	{
		String name="Shiva";
		System.setProperty("webdriver.chrome.driver","E:\\\\Selenium\\\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		String password = getPassword(driver);
		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'login')]/h2")).getText(), "Hello "+name+",");
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'login')]/p")).getText());
 		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'login')]/p")).getText(), "You are successfully logged in.");
 		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
 		System.out.println("Test Executed Succefully");
 		driver.close();
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		String[] passwordArray = passwordText.split("'");
		String finalPassword = passwordArray[1];
		return finalPassword;
	}

}
