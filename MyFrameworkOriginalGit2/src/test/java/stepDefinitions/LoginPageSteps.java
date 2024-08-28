package stepDefinitions;

import com.aventstack.extentreports.util.Assert;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private LoginPage loginPage= new LoginPage(DriverFactory.getDriver());
	String loginPageTitle;
	
	@Given("User is on login page")
	public void user_is_on_login_page() {

		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		loginPageTitle=loginPage.getLoginPageTitle(); 
		System.out.println("Login Page title is: "+loginPageTitle);
	
	
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		org.junit.Assert.assertTrue(loginPageTitle.contains(expectedTitle));
	
	}
	
	@When("user enters username {string}")
	public void user_enters_username(String username) throws InterruptedException {
		Thread.sleep(2000);
		loginPage.enterUsername(username);
	   
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	    loginPage.clickOnLogin();
	}

	@Then("OrangeHRM homepage displayed with url {string}")
	public void orange_hrm_homepage_displayed_with_url(String expectedHomepageURL) {
		String homePageURL=loginPage.getHomePageURL();
		System.out.println("Home page URL is : "+homePageURL);
		org.junit.Assert.assertTrue(homePageURL.contains(expectedHomepageURL));
		
	}

}
