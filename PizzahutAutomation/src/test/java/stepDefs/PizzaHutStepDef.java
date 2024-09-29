package stepDefs;


import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PizzaHutStepDef {
	WebDriver driver = Hooks.driver;
	@Given("I have launch the application")
	public void i_have_launch_the_application() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://www.pizzahut.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Hooks.test.log(LogStatus.PASS, "Application Launched");
	}
		
		
   @When("I enter the location as {string}")
    public void i_enter_the_location_as(String pune) {
	WebElement Location = driver.findElement(By.cssSelector("input[placeholder]"));
	Location.sendKeys("pune");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	Hooks.test.log(LogStatus.PASS,"I enter the location as");

}

      @When("I select the very first suggestion from the list")
      public void i_select_the_very_first_suggestion_from_the_list() {
    	  WebElement select = driver.findElement(By.xpath("//form/div/div[2]/div/button[2]/div[2]/div[2]"));
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
    	select.click();
        Hooks.test.log(LogStatus.PASS, "I select the very first suggestion from the list");
    	  
    
}

      @Then("I should land on the Deals page")
     public void i_should_land_on_the_Deals_page( ) {	
    	  
    	  String ActualTitle = driver.getTitle();
    	  String ExpectedTitle = "Online Pizza Order, Pizza Deals, Pizza Hut Online Orders | Pizza Hut India";
    	  Assert.assertNotSame(ActualTitle, ExpectedTitle);
    	
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
    	  }
    	 
       @Then("I select the tab as {string}")
      public void i_select_the_tab_as(String Pizzas) {
           WebElement tabpizza= driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/a[2]"));
    	   //try {
           tabpizza.click();
    	 
}

     @Then("I add {string} to the basket")
       public void i_add_to_the_basket(String Margherita) {
	    WebElement tabadd= driver.findElement(By.xpath("//span/div[1]/a[2]/div[3]/div/button/span[1]"));
	    tabadd.click(); 
	    WebElement addextra = driver.findElement(By.xpath("//div[2]/div/div[2]/div[1]/div[2]/div[1]/button/span"));
	    addextra.click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
}

    @Then("I note down the price displayed on the screen")
public void i_note_down_the_price_displayed_on_the_screen() {
	WebElement price = driver.findElement(By.xpath("//span/div[1]/a[2]/div[3]/div/button/span[2]"));
	boolean flag=price.isDisplayed();
	System.out.println("I note down the page: " +flag);
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
}

@Then("I should see the pizza {string} is added to the cart")
public void i_should_see_the_pizza_is_added_to_the_cart(String  Margherita) {
	WebElement Basket = driver.findElement(By.xpath("//*[@id=\"basket\"]/div[3]/div/div[1]/a"));
	 Basket.click();
	 WebElement basket = driver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div[3]/button/span"));
	 basket.click();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
   
}

@Then("price is also displayed correctly")
public void price_is_also_displayed_correctly() {
	WebElement checkprice = driver.findElement(By.cssSelector(".amountdue"));
	boolean flag=checkprice.isDisplayed();
	System.out.println("The price is also diplayed correctly: " +flag);
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
}

@Then("I click on the Checkout button")
public void i_click_on_the_Checkout_button() {
	WebElement checkout = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a/span[2]/span"));
   checkout.click();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
   //pizza
}

@Then("I should be landed on the secured checkout page")
public void i_should_be_landed_on_the_secured_checkout_page() {
	String ActualTitle = driver.getTitle();
	  String ExpectedTitle = "Checkout | Pizza Hut India";
	  Assert.assertNotSame(ActualTitle, ExpectedTitle);
	
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
    
}

@Then("I enter the personal details")
public void i_enter_the_personal_details(io.cucumber.datatable.DataTable dataTable) {
	WebElement name = driver.findElement(By.xpath("//*[@id=\"checkout__name\"]"));
	 name.sendKeys(" Rajesh Sharma ");
	 WebElement Mobilenum = driver.findElement(By.xpath("//*[@id=\"checkout__phone\"]"));
	 Mobilenum.sendKeys(" 888888888 ");
	 WebElement Email = driver.findElement(By.xpath("//*[@id=\"checkout__email\"]"));
	Email.sendKeys("abc@xyz.com");
	 
}

@Then("I enter the address details")
public void i_enter_the_address_details(io.cucumber.datatable.DataTable dataTable) {
	WebElement address = driver.findElement(By.xpath("//*[@id=\"checkout__deliveryAddress.interior\"]"));
	 address.sendKeys("123 Main Street ");
	 WebElement landmark = driver.findElement(By.xpath("//*[@id=\"checkout__deliveryAddress.notes\"]"));
	 landmark.sendKeys(" Some Landmark ");
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	
    
}
}
