package Prueba.Tecnica.Advantage.Online.Shopping.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverBrowser {
	
	public static WebDriver driver;

	public static WebDriverBrowser chromeHisBrowserWeb() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-infobars");

		driver = new ChromeDriver(options);
		return new WebDriverBrowser();
	}

	public static WebDriver on(String url) {
		driver.get(url);
		return driver;
	}

}
