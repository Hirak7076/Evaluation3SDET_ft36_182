package EVALUATIONsteps;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class steps {

	WebDriver driver;
	Select S;
	WebElement Tab;
	SoftAssert sA;
	
	@Given("Open the browser and Enter the eBay url")
	public void open_the_browser_and_enter_the_e_bay_url() {
	    
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ebay.com/");
		
	}

	@Given("Click the Advanced Link beside Search button")
	public void click_the_advanced_link_beside_search_button() {
	    
		driver.findElement(By.cssSelector("[title='Advanced Search']")).click();;
		
	}

	@When("Select the appropiate option as displayed in the image")
	public void select_the_appropiate_option_as_displayed_in_the_image() {
	    
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Shoes adidas");
		S = new Select(driver.findElement(By.cssSelector("[aria-label='Keyword options']")));
		S.selectByVisibleText("Exact words, exact order");
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("adidas , S , L , M");
		S = new Select(driver.findElement(By.cssSelector("[aria-label='In this category']")));
		S.selectByVisibleText("Collectibles");
		
	}

	@When("Click the Using Advanced search option Link and Switching to the Child window and Assert that the text - Costomer Service - is present and Switch back to the Parent Window")
	public void click_the_using_advanced_search_option_link_and_switching_to_the_child_windowand_Assert_that_the_text_Costomer_Service_is_present_switch_back_to_the_parent_window() {
	    
		String Parent = driver.getWindowHandle();
		driver.findElement(By.cssSelector("[href='/help/buying/search-tips/advanced-search?id=4049']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		Set<String> allWindows1 = driver.getWindowHandles();
		for (String window : allWindows1) {
		    if (!window.equals(Parent)) {
		        driver.switchTo().window(window);
		        break;
		    }
		}
		
		
		
		sA = new SoftAssert();
		String Display = driver.findElement(By.xpath("//tbody/tr/td/h2[text()='Customer Service']")).getText();
		sA.assertEquals(Display, "Customer Service");
		sA.assertAll();
		
		driver.switchTo().window(Parent);
		
	}

	@When("Enter the search details as shown in image")
	public void enter_the_search_details_as_shown_in_image() {
	    
		driver.findElement(By.xpath("(//input[@data-radio=\"set-input\"])[7]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[5]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[6]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[7]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[8]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[9]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[10]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[11]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[12]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[13]")).click();
		driver.findElement(By.cssSelector("[aria-label=\"Enter minimum number of bids\"]")).sendKeys("100");
		driver.findElement(By.cssSelector("[aria-label=\"Enter maximum number of bids\"]")).sendKeys("200");
		driver.findElement(By.cssSelector("[aria-label=\"Enter minimum quantity\"]")).sendKeys("10");
		driver.findElement(By.cssSelector("[aria-label=\"Enter Maximum Quantity\"]")).sendKeys("20");
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[17]")).click();
		
	}

	@When("Enter the Additional Details as shown in image")
	public void enter_the_additional_details_as_shown_in_image() {
	    
		driver.findElement(By.cssSelector("[aria-label=\"Seller ID\"]")).sendKeys("Ambani");
		S = new Select(driver.findElement(By.cssSelector("[aria-label=\"Sort By\"]")));
		S.selectByVisibleText("Time: newly listed");
		S = new Select(driver.findElement(By.cssSelector("[aria-label=\"View Results\"]")));
		S.selectByVisibleText("List view");
		S = new Select(driver.findElement(By.cssSelector("[aria-label=\"Results Per Page\"]")));
		S.selectByVisibleText("120");
		
	}

	@When("Click on the Search button")
	public void click_on_the_search_button() {
	    
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		
	}

	@Then("Assert the text - No exact matches found - as result")
	public void assert_the_text_no_exact_matches_found_as_result() {
	    
		sA = new SoftAssert();
		String Display = driver.findElement(By.xpath("//div/h3[text()='No exact matches found']")).getText();
		sA.assertEquals(Display, "No exact matches found");
		sA.assertAll();
		
	}

	@Then("Close the browser")
	public void close_the_browser() {
	    
		driver.quit();
		
	}	
	
}
