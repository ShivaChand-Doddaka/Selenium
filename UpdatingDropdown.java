

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatingDropdown {

	public static void main(String[] args) throws InterruptedException 
	{
		
		System.setProperty("WebDriver.Chrome.Driver", "E:\\Selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		int numberOfAdults = 4;
		while(numberOfAdults > 0)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			numberOfAdults--;
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
	}

}
