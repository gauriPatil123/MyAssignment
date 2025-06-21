package com.keywords;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Keyword {
	
	// Object of Logger class
		private static final Logger log = Logger.getLogger(Keyword.class) ;
		

		public static RemoteWebDriver driver = null;
		public static FluentWait<WebDriver> wait = null;

		public void launchBrowser(String browserName) {
			if (browserName.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
				//System.out.println("Chrome browser opened");
				log.info("chrome browser opened");
			} else if (browserName.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
				//System.out.println("Edge browser opened");
				log.info("Edge browser opened");
			} else if (browserName.equalsIgnoreCase("FireFox")) {
				driver = new FirefoxDriver();
				log.info("Firefox browser opened");
			} else if (browserName.equalsIgnoreCase("Safari")) {
				driver = new SafariDriver();
				log.info("Safari browser opened");
			} else {
				System.out.println("You have entered invalid browser, so bydefault opening the chrome browser");
				driver = new ChromeDriver();
				log.error("invalid browser name so bydefault chrome is opened");
			}

			driver.manage().window().maximize();
			wait = new FluentWait(Keyword.driver);
			wait.withTimeout(Duration.ofSeconds(60));
			wait.pollingEvery(Duration.ofMillis(500));
			wait.ignoring(Exception.class);
			
		}

		public String getCurrentTimeDate() {
			// Get the current date and time
			LocalDateTime localTImeDate = LocalDateTime.now();
			// Define the format
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
			// Format the current date and time
			String formattedNow = localTImeDate.format(formatter);
			return formattedNow;
		}

		public void launchURL() {
			driver.get("https://ultimaworks.ltimindtree.com/home");
			//System.out.println("Application is opened");
			log.info("application url is opend");
		}
		
		public void launchURL(String URL) {
			driver.get(URL);
			log.info("application url is opend");
		}

		public void waitElementToBePresent(String xpath) {
			//wait = new FluentWait(driver);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			
		}
		
		public void waitElementToBePresent(String locatoyType , String locatorValue) {
			if(locatoyType.equalsIgnoreCase("xpath")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue)));
			}else if (locatoyType.equalsIgnoreCase("css")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locatorValue)));
			}else if (locatoyType.equalsIgnoreCase("id")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locatorValue)));
			}else if (locatoyType.equalsIgnoreCase("name")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locatorValue)));
			}else if (locatoyType.equalsIgnoreCase("tagName")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(locatorValue)));
			}else if (locatoyType.equalsIgnoreCase("className")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locatorValue)));
			}else if (locatoyType.equalsIgnoreCase("linkText")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(locatorValue)));
			}else if (locatoyType.equalsIgnoreCase("partialLinkText")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(locatorValue)));
			}else {
				
				System.err.println("invalid locator type");
				log.error("invalid locator type");
			}
		}
		
		

		public void waitElementToBeClickabe(String xpath) {
			//wait = new FluentWait(driver);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			log.error("invalid locator type");
		}
		
		public void enterText(String xpath , String text) {
			driver.findElement(By.xpath(xpath)).sendKeys(text);
			log.error("input text" + text);
		}
		
		public void enterText(String locatorType,String locatorValue , String text) {
			if(locatorType.equalsIgnoreCase("xpath")) {
				driver.findElement(By.xpath(locatorValue)).sendKeys(text);
			}else if (locatorType.equalsIgnoreCase("css")) {
				driver.findElement(By.cssSelector(locatorValue)).sendKeys(text);
			}else if (locatorType.equalsIgnoreCase("id")) {
				driver.findElement(By.id(locatorValue)).sendKeys(text);
			}else if (locatorType.equalsIgnoreCase("name")) {
				driver.findElement(By.name(locatorValue)).sendKeys(text);
			}else if (locatorType.equalsIgnoreCase("tagName")) {
				driver.findElement(By.tagName(locatorValue)).sendKeys(text);
			}else if (locatorType.equalsIgnoreCase("className")) {
				driver.findElement(By.className(locatorValue)).sendKeys(text);
			}else if (locatorType.equalsIgnoreCase("linkText")) {
				driver.findElement(By.linkText(locatorValue)).sendKeys(text);
			}else if (locatorType.equalsIgnoreCase("partialLinkText")) {
				driver.findElement(By.partialLinkText(locatorValue)).sendKeys(text);
			}else {
				
				System.err.println("invalid locator type");
			}
		}
		
		public void performClick(String xpath) {
			driver.findElement(By.xpath(xpath)).click();
		}
		
		public String titileOfApp() {
			String titleOfApp = driver.getTitle();
			return titleOfApp;
		}
		public void performClick(String locatorType, String locatorValue) {
			
			if(locatorType.equalsIgnoreCase("xpath")) {
				driver.findElement(By.xpath(locatorValue)).click();
			}else if (locatorType.equalsIgnoreCase("css")) {
				driver.findElement(By.cssSelector(locatorValue)).click();
			}else if (locatorType.equalsIgnoreCase("id")) {
				driver.findElement(By.id(locatorValue)).click();
			}else if (locatorType.equalsIgnoreCase("name")) {
				driver.findElement(By.name(locatorValue)).click();
			}else if (locatorType.equalsIgnoreCase("tagName")) {
				driver.findElement(By.tagName(locatorValue)).click();
			}else if (locatorType.equalsIgnoreCase("className")) {
				driver.findElement(By.className(locatorValue)).click();
			}else if (locatorType.equalsIgnoreCase("linkText")) {
				driver.findElement(By.linkText(locatorValue)).click();
			}else if (locatorType.equalsIgnoreCase("partialLinkText")) {
				driver.findElement(By.partialLinkText(locatorValue)).click();
			}else {
				
				System.err.println("invalid locator type");
			}
		}
		
	public void clearTextBx(String locatorType, String locatorValue) {
			
			if(locatorType.equalsIgnoreCase("xpath")) {
				driver.findElement(By.xpath(locatorValue)).clear();
			}else if (locatorType.equalsIgnoreCase("css")) {
				driver.findElement(By.cssSelector(locatorValue)).clear();
			}else if (locatorType.equalsIgnoreCase("id")) {
				driver.findElement(By.id(locatorValue)).clear();
			}else if (locatorType.equalsIgnoreCase("name")) {
				driver.findElement(By.name(locatorValue)).clear();
			}else if (locatorType.equalsIgnoreCase("tagName")) {
				driver.findElement(By.tagName(locatorValue)).clear();
			}else if (locatorType.equalsIgnoreCase("className")) {
				driver.findElement(By.className(locatorValue)).clear();
			}else if (locatorType.equalsIgnoreCase("linkText")) {
				driver.findElement(By.linkText(locatorValue)).clear();
			}else if (locatorType.equalsIgnoreCase("partialLinkText")) {
				driver.findElement(By.partialLinkText(locatorValue)).clear();
			}else {
				
				System.err.println("invalid locator type");
			}
		}
		
		public void impliciWait() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		}
		
		public String getActualtext(String xpath) {
			String actualtext = driver.findElement(By.xpath(xpath)).getText();
			return actualtext;
		}
		
		public String getActualtext(String locatorType, String locatorValue) {
			String actualtext=null;
			if(locatorType.equalsIgnoreCase("xpath")) {
				actualtext=driver.findElement(By.xpath(locatorValue)).getText();
			}else if (locatorType.equalsIgnoreCase("css")) {
				 actualtext = driver.findElement(By.cssSelector(locatorValue)).getText();
			}else if (locatorType.equalsIgnoreCase("id")) {
				 actualtext = driver.findElement(By.id(locatorValue)).getText();
			}else if (locatorType.equalsIgnoreCase("name")) {
				 actualtext = driver.findElement(By.name(locatorValue)).getText();
			}else if (locatorType.equalsIgnoreCase("tagName")) {
				 actualtext = driver.findElement(By.tagName(locatorValue)).getText();
			}else if (locatorType.equalsIgnoreCase("className")) {
				 actualtext = driver.findElement(By.className(locatorValue)).getText();
			}else if (locatorType.equalsIgnoreCase("linkText")) {
				 actualtext = driver.findElement(By.linkText(locatorValue)).getText();
			}else if (locatorType.equalsIgnoreCase("partialLinkText")) {
				 actualtext = driver.findElement(By.partialLinkText(locatorValue)).getText();
			}else {
				
				//System.err.println("invalid locator type");
				log.error("invalid locator type");
			}
			return actualtext;
		}
		
		public void assertText(String expected, String actual) {
			Assert.assertEquals(expected, actual, "actual is not match with expected!!");
		}
		
		/**
		 * This method is used to click on element depends on locator strategies 
		 * @param locatorType {@code xpath, id, className,tagName,linkText, partiallinkText,name}
		 * @param locatorValue {@code locator value}
		 */
		
		public void click(String locatorType, String locatorValue) {
			if (locatorType.equalsIgnoreCase("xpath")) {
				driver.findElement(By.xpath(locatorValue)).click();
			} else if (locatorType.equalsIgnoreCase("id")) {
				driver.findElement(By.id(locatorValue)).click();	
			}
			else if (locatorType.equalsIgnoreCase("className")) {
				driver.findElement(By.className(locatorValue)).click();	
			}
			else if (locatorType.equalsIgnoreCase("tagName")) {
				driver.findElement(By.tagName(locatorValue)).click();	
			}
			else if (locatorType.equalsIgnoreCase("linkText")) {
				driver.findElement(By.linkText(locatorValue)).click();	
			}
			else if (locatorType.equalsIgnoreCase("partiallinkText")) {
				driver.findElement(By.partialLinkText(locatorValue)).click();	
			}
			else if (locatorType.equalsIgnoreCase("css")) {
				driver.findElement(By.cssSelector(locatorValue)).click();	
			}else if (locatorType.equalsIgnoreCase("name")) {
				driver.findElement(By.name(locatorValue)).click();	
			}else {
			System.out.println("Invalid locator Stratigies");
			}
		}
		
		public void clickUsingJS(String css) {
			String cssValue = "\"" + css + "\"" ; 
			//System.out.println(cssValue);
			log.info(cssValue);
			driver.executeScript("document.querySelector("+cssValue+").click()");
		}
		
		public void takeScreenShot() {
			Screenshot src = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(400)).takeScreenshot(driver);
			BufferedImage img = src.getImage();
			try {
				ImageIO.write(img, "png", new File("src/ScreenShots/" +getCurrentTimeDate() + "_screenShotUsingAshot.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public String randonString() {
			String randomString = RandomStringUtils.randomAlphanumeric(12).toUpperCase();
			return randomString;
		}
		
		public String randomNumber() {
			Random ran = new Random();
			String randomNumber = Integer.toString(ran.nextInt(7) + 1252);
			return randomNumber;
		}
		
		
		public void windowHandle() {
			 //Get handles of the windows
	        String mainWindowHandle = driver.getWindowHandle();
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        System.out.println(allWindowHandles + ":--- REST TEST :- ");
	        Iterator<String> iterator = allWindowHandles.iterator();
	       
	        // Here we will check if child window has other child windows and will fetch the heading of the child window
	        while (iterator.hasNext()) {
	            String ChildWindow = iterator.next();
	                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	                
//	                WebElement text = driver.findElement(By.id("sampleHeading"));
//	                System.out.println("Heading of child window is " + text.getText());
	            }
	                }
		}
		
		
		public void windowHamdleUsingTitle(String winTitle) {
			String your_title = winTitle;
			String currentWindow = driver.getWindowHandle();  //will keep current window to switch back
			
			for(String winHandle : driver.getWindowHandles()){
			   if (driver.switchTo().window(winHandle).getTitle().equals(your_title)) {
			     //This is the one you're looking for
			     break;
			   } 
			   else {
			      driver.switchTo().window(currentWindow);
			   } 
			}
		}

	public void browserQuit() {
		driver.quit();
	}

}
