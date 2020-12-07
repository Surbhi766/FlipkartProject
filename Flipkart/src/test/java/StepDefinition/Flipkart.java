package StepDefinition;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Common.Driver_Initialization;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Configuration.Admin_Configmanager;
import Locators.flipkartLocators;



public class Flipkart extends Driver_Initialization{
	
	WebDriverWait wait;//= new WebDriverWait(driver, 30);
	String browser;
	WebElement searchbox;
	String prodAvailability = "";

		@Given("^User is on google search page$")
		public void user_is_on_google_search_page() throws Throwable {
			browser = Admin_Configmanager.getPropertyValue("browser");
			setBrowserProperties();
			driver = openBrowser(browser);
			wait = new WebDriverWait(driver, 30); 
			String appURL = Admin_Configmanager.getPropertyValue("application.url");			
			driver.get(appURL);
		}

		@When("^Search with Keyword Flipkart$")
		public void search_with_Keyword_Flipkart() throws Throwable {
			wait.until(ExpectedConditions.elementToBeClickable(flipkartLocators.searchbox)).sendKeys("Flipkart");			
		}

		@When("^Print all the search result in console$")
		public void print_all_the_search_result_in_console() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			Thread.sleep(1000);
			WebElement searchList = driver
					.findElement(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']/span"));
			List<WebElement> ListOptions = searchList
					.findElements(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/ul"));

			for (WebElement listResult : ListOptions) {
				System.out.println(listResult.getText());
			}
			wait.until(ExpectedConditions.elementToBeClickable(flipkartLocators.searchbox)).submit();
		}

		@When("^Press enter and open the flipkart application$")
		public void press_enter_and_open_the_flipkart_application() throws Throwable {
			
			//Find and click on desired search result
			wait.until(ExpectedConditions.textToBePresentInElementLocated(
					By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/a/div/cite"), "www.flipkart.com"));
		}

		@When("^Close the login popup on the website$")
		public void close_the_login_popup_on_the_website() throws Throwable {
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/a/h3/span"))).click();
		}

		@When("^Click on “TV & Appliances” dropdown button$")
		public void click_on_TV_Appliances_dropdown_button() throws Throwable {
			//TV and appliances
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/button"))).click();

			//Air conditionor 
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/span[2]"))).click();

			
			//Window AC
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div/div[2]/a[8]")))
					.click();
			
		}

		@When("^Navigate to “AirConditioners > Window AC’s” page$")
		public void navigate_to_AirConditioners_Window_AC_s_page() throws Throwable {
		    System.out.println("Test");
		}

		@When("^Click on the “Add To Compare” checkbox of the (\\d+)nd (\\d+)rd and (\\d+)th products displayed\\.$")
		public void click_on_the_Add_To_Compare_checkbox_of_the_nd_rd_and_th_products_displayed(int arg1, int arg2, int arg3) throws Throwable {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
					"//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[3]/div/div/div/a/div[1]/div[2]")))
					.click();

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
					"//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[4]/div/div/div/a/div[1]/div[2]/div/span")))
					.click();

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
					"//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[7]/div/div/div/a/div[1]/div[2]/div/span")))
					.click();
		
		}

		@When("^Click on the compare button$")
		public void click_on_the_compare_button() throws Throwable {
			
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[4]/div/a"))).click();
		}

		@When("^Print Name and price of all three products in the console$")
		public void print_Name_and_price_of_all_three_products_in_the_console() throws Throwable {
			String prodName = "";
			String prodPrice = "";

			for (int itr = 2; itr <= 4; itr++) {
				prodName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
						"//*[@id=\"fk-compare-page\"]/div/div/div/div[1]/div[2]/div/div[1]/div[1]/div[" + itr + "]/a")))
						.getText();
				System.out.println(prodName);

				prodPrice = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[@id=\"fk-compare-page\"]/div/div/div/div[1]/div[2]/div/div[1]/div[2]/div[" + itr
								+ "]/div/div/div[1]")))
						.getText();
				System.out.println(prodPrice);

			}
		}

		@When("^Add all the (\\d+) products into the cart$")
		public void add_all_the_products_into_the_cart(int arg1) throws Throwable {
			for (int itr = 2; itr <= 4; itr++) {
				wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[@id=\"fk-compare-page\"]/div/div/div/div[2]/div[3]/div[5]/div[" + itr + "]/button")))
						.click();

				wait.until((ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[1]/div[1]/div/div[1]/div[1]/div"))));
				driver.navigate().back();
			}
		}

		@When("^Go to the cart add area Pincode and check the availability$")
		public void go_to_the_cart_add_area_Pincode_and_check_the_availability() throws Throwable {
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[5]/div/div")))
					.click();

			// Wait for pin code TB to appear
			wait.until((ExpectedConditions.presenceOfElementLocated(
					By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[1]/div[1]/div/div[1]/div[2]/div/div[2]/input"))));

			// Enter Pin code
			driver.findElement(
					By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[1]/div[1]/div/div[1]/div[2]/div/div[2]/input"))
					.sendKeys("380015");

			// Click on check button
			wait.until((ExpectedConditions.presenceOfElementLocated(
					By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[1]/div[1]/div/div[1]/div[2]/div/div[2]/span"))))
					.click();

			// wait for check button to disappear
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
					"//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div[2]/div[2]/span")));

		}

		@When("^Print message for availabilty and delivery$")
		public void print_message_for_availabilty_and_delivery() throws Throwable {
			
			for (int itr1 = 2; itr1 <= 4; itr1++) {
				prodAvailability = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
						"//*[@id='container']/div/div[2]/div/div/div[1]/div/div[" + itr1 + "]/div/div[1]/div[1]/div[4]")))
						.getText();

				System.out.println(prodAvailability);

			}
		}

		@When("^Click the ‘Deliver to’ input box,$")
		public void click_the_Deliver_to_input_box() throws Throwable {
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div"))).click();

			// Wait for pin code TB to appear
			wait.until((ExpectedConditions.presenceOfElementLocated(By.xpath(
					"//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div[2]/div[2]/input"))));

			
		}

		@When("^Add another pin code and check the availability$")
		public void add_another_pin_code_and_check_the_availability() throws Throwable {
			// Enter Pin code
						driver.findElement(By.xpath(
								"//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div[2]/div[2]/input"))
								.sendKeys("560017");

						// Click on check
						wait.until((ExpectedConditions.presenceOfElementLocated(By.xpath(
								"//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div[2]/div[2]/span"))))
								.click();

						// wait for check to disappear
						wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
								"//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div[2]/div[2]/span")));
		}

		@When("^Print the message getting displayed for the availability/delivery of the product in the console for the changed Pincode$")
		public void print_the_message_getting_displayed_for_the_availability_delivery_of_the_product_in_the_console_for_the_changed_Pincode() throws Throwable {
			prodAvailability = "";

			for (int itr = 2; itr <= 4; itr++) {
				prodAvailability = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
						"//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[" + itr + "]/div/div[1]/div[1]/div[4]")))
						.getText();

				System.out.println(prodAvailability);

			}
			
		}

		@Then("^close the browser$")
		public void close_the_browser() throws Throwable {
			driver.close();
			driver.quit();
		}

	

}
