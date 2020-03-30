package stepDefinations;

import org.openqa.selenium.WebDriver;


import com.PageObjects.HomePage;
import base.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyGames {
	
	public TestBase testBaseInstance;
	
	// PicoContainer injects class TestBase
	public VerifyGames (TestBase testbase) {
		
		this.testBaseInstance = testbase;
	}
	WebDriver driver;
	

	@Given("^User Opens the \"([^\"]*)\" in \"([^\"]*)\"$")
	public void OpenBrowser(String arg1, String arg2) throws Throwable {
	    
		TestBase.SetupDriver(arg2);		
		WebDriver driver = testBaseInstance.GetDriver();
		
		TestBase.OpenURL(driver, arg1);
		
		System.out.println("Opened the URL: "+arg1+" in the Browser: "+arg2+" Successfully");
	}

		
	@When("^User Navigates to Games Tiles and Verify Games$")
	public void user_Navigates_to_Games_Tiles_and_Verify_Games() throws Throwable {
		
		WebDriver driver = testBaseInstance.GetDriver();
	    
		HomePage.VerifyGames(driver);		
	   
	}

	
	@Then("^Close Browser$")
	public void close_Browser() throws Throwable {
		WebDriver driver = testBaseInstance.GetDriver();
		driver.close();
		System.out.println("Closed the Browser Successfully");
		System.out.println("\n");
	}
}
