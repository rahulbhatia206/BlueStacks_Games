package base;


import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase

{
	protected static WebDriver driver = null;
	static WebDriverWait wait;
	static WebElement element = null;


	public static void loadlog4J() {
		String log4jConfPath = System.getProperty("user.dir") + "\\log4j.xml";
		PropertyConfigurator.configure(log4jConfPath);
	}

	/*
	 * Author - RahulB
	 * Date - 30th March, 2020
	 * Method - Wait till the presence of element is located
	 */
	public static WebElement WaitTimePresence(WebDriver driver, String xpath) throws Exception {
		try {
			wait = new WebDriverWait(driver, 40);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			// ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+driver.findElement(By.xpath(xpath)).getLocation().x+")");
			((JavascriptExecutor) driver)
					.executeScript("window.scrollTo(" + driver.findElement(By.xpath(xpath)).getLocation().x + ","
							+ (driver.findElement(By.xpath(xpath)).getLocation().y - 100) + ");");
		} catch (Exception e) {
			System.out.println("Problem in WebDriverWait Presence !");
			throw e;
		}
		return element;

	}
	
	/*
	 * Author - RahulB
	 * Date - 30th March, 2020
	 * Method - Wait for Some Seconds
	 */
	public static boolean waitFor(int iSeconds) {
		try {
			Thread.sleep(iSeconds * 1000);
		} catch (Exception e) {
			System.out.println("Not able to Wait --- " + e.getMessage());
			return false;
		}
		return true;
	}


	/*
	 * Author - RahulB
	 * Date - 30th March, 2020
	 * Method - Getting Driver
	 */
 public static void SetupDriver(String browser){
	 
			try{
				if(browser.equals("Chrome"))
				{					
					TestBase.loadlog4J();
					System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
					driver = new ChromeDriver();
				}
				if(browser.equals("Firefox"))
				{
					System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
					driver = new FirefoxDriver();
				}
			}
	 
			catch (Exception e)
			{
				System.out.println("Problem in Running the WebDriver !!!!");
				e.printStackTrace();	
			
			}
	 
		}
 
	/*
	 * Author - RahulB
	 * Date - 30th March, 2020
	 * Method - Getting the WebDriver Instance
	 */
 public WebDriver GetDriver() {
	 return driver;
 }
 
	/*
	 * Author - RahulB
	 * Date - 30th March, 2020
	 * Method - Opening the URL in Browser
	 */
 public static String OpenURL(WebDriver driver, String url){
	 
	 
	 try{
				driver.get(url);
				System.out.println("\nOpened the Following URL: " +url+ "\n");
				driver.manage().window().maximize();
		}
 
		catch (Exception e)
		{
			System.err.println("Problem in Opening the browser !!!");
			e.printStackTrace();	
		}
 
		return url;
 
	}
 	
	/*
	 * Author - RahulB
	 * Date - 30th March, 2020
	 * Method - Opening the URL in Browser
	 */
	public static void scrollDown(WebDriver driver, int x, int y)
	{
  	 JavascriptExecutor jse = (JavascriptExecutor)driver;
	 jse.executeScript("window.scrollBy(" + x + ", " + y + ");");
	} 
}