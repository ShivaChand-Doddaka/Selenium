import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FlightsPortalEndToEnd 
{

	public static void main(String[] args) throws InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		FlightsPortalEndToEnd myObj = new FlightsPortalEndToEnd();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		myObj.autoSuggestionsAttribute(driver);
		myObj.radioButtonToEnableReturnDateAttribute(driver);
		myObj.dynamicDropdownAttribute(driver);
		myObj.dateSelectionAttribute(driver);
		myObj.passengerCountUpdatingDropdown(driver);
		myObj.currencyStaticDropdown(driver);
		myObj.passengerTypeCheckbox(driver);
		
		driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
		
		System.out.println("Test Passed Successfully!!!");
				
	}
	
	public void autoSuggestionsAttribute(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.id("autosuggest")).sendKeys("in");
		Thread.sleep(2000);
		
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for(WebElement option:options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}
		}
	}
	public void dynamicDropdownAttribute(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
	}
	public void radioButtonToEnableReturnDateAttribute(WebDriver driver)
	{
		Assert.assertTrue(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		Assert.assertTrue(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"));
	}
	public void dateSelectionAttribute(WebDriver driver)
	{
		driver.findElement(By.xpath("//a[contains(@class,'ui-state-highlight')]")).click();
	}
	public void passengerCountUpdatingDropdown(WebDriver driver) throws InterruptedException
	{
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
	public void currencyStaticDropdown(WebDriver driver)
	{
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByValue("INR");
	}
	public void passengerTypeCheckbox(WebDriver driver)
	{
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
	}
	
}
