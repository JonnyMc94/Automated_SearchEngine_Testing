import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;

public class Searcher {

    /** Defines search engine URL */
    public static final String SEARCH_ENGINE = "https://bing.com/";
    public static final String SEARCH_ENGINE1 = "https://ie.search.yahoo.com/";
    public static final String SEARCH_ENGINE2 = "https://duckduckgo.com/";


    /** Defines path to the Chrome driver */
    public static final String CHROME_DRIVER_PATH = "/Users/johnnymcnamee/Desktop/chromedriver";

    /**
     *  Selenium controlling the Search Engine Bing
     */
    public void searchBing(String query) {

        System.out.println();
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        WebDriver driver  = new ChromeDriver();
        driver.get(SEARCH_ENGINE); // driver loads search engine URL.

        System.out.println();
        System.out.println("Search engine: " + driver.getTitle());

        // Code to deal with cookie requests
        for (Cookie cook : driver.manage().getCookies()) {
            String writeup = cook.getName();
            driver.manage().deleteCookie(cook);
        }

        // Finding and clearing the search input box
        WebElement searchForm = driver.findElement(By.id("sb_form_q"));
        System.out.println("Search Form ID: " + searchForm.getAttribute("id"));
        searchForm.clear();

        // Entering an interesting search query
        searchForm.sendKeys(query);
        System.out.println("Query: " + query);

        // Option 1: Finding and clicking the 'Search' button
        // I couldn't get this option to work with bing
//		WebElement SearchButton = driver.findElement(By.id("sb_form_go"));
//		System.out.println("Search button ID: " + SearchButton.getAttribute("id"));
//		SearchButton.click();

//		 Option 2: Automatically pressing enter in the search box
//		 usually causes the search to be executed; you can use this if you cannot find
//		 an id for the search button
//       This one works
        searchForm.sendKeys(Keys.RETURN);
        System.out.println("Pressed return");

        waitABit(); // just waits a bit so that you can view the result on screen

        // closing the web browser and the page.
        driver.close();

        System.out.println("Search successfully executed.");

        // closing the driver
        driver.quit();

    }
    //
//	public void searchYahoo(String query) {
//
//		System.out.println();
//		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
//		WebDriver driver  = new ChromeDriver();
//		driver.get(SEARCH_ENGINE1); // driver loads search engine URL.
//
//		System.out.println();
//		System.out.println("Search engine: " + driver.getTitle());
//
//		//Used name as the attribute to get past the cookie request
//		WebElement agreeToCookies = driver.findElement(By.name("agree"));
//		System.out.println("Accept cookies className: " + agreeToCookies.getAttribute("name"));
//		agreeToCookies.click();
//		// Finding and clearing the search input box
//		WebElement searchForm = driver.findElement(By.id("yschsp"));
//		System.out.println("Search Form ID: " + searchForm.getAttribute("id"));
//		searchForm.clear();
//
//
//		searchForm.sendKeys(query);
//		System.out.println("Query: " + query);
//
//		// Option 1: Finding and clicking the 'Search' button
//		WebElement SearchButton = driver.findElement(By.className("sbb"));
//		System.out.println("Search button ID: " + SearchButton.getAttribute("className"));
//		SearchButton.click();
////
////		 Option 2: Automatically pressing enter in the search box
////		 usually causes the search to be executed; you can use this if you cannot find
////		 an id for the search button
////		searchForm.sendKeys(Keys.RETURN);
////		System.out.println("Pressed return");
//
//		waitABit(); // just waits a bit so that you can view the result on screen
//
//		// closing the web browser and the page.
//		driver.close();
//
//		System.out.println("Search successfully executed.");
//
//		// closing the driver
//		driver.quit();
//
//	}
//
//	public void searchDuckDuckGo(String query) {
//
//		System.out.println();
//		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
//		WebDriver driver  = new ChromeDriver();
//		driver.get(SEARCH_ENGINE2); // driver loads search engine URL.
//
//		System.out.println();
//		System.out.println("Search engine: " + driver.getTitle());
//
//		// Finding and clearing the search input box
//		WebElement searchForm = driver.findElement(By.id("search_form_input_homepage"));
//		System.out.println("Search Form ID: " + searchForm.getAttribute("id"));
//		searchForm.clear();
//
//		// Entering an interesting search query
//		searchForm.sendKeys(query);
//		System.out.println("Query: " + query);
//
//		// Option 1: Finding and clicking the 'Search' button
//		WebElement SearchButton = driver.findElement(By.id("search_button_homepage"));
//		System.out.println("Search button ID: " + SearchButton.getAttribute("id"));
//		SearchButton.click();
//
//		// Option 2: Automatically pressing enter in the search box
//		// usually causes the search to be executed; you can use this if you cannot find
//		// an id for the search button
//		//searchForm.sendKeys(Keys.RETURN);
//		//System.out.println("Pressed return");
//
//		waitABit(); // just waits a bit so that you can view the result on screen
//
//		// closing the web browser and the page.
//		driver.close();
//
//		System.out.println("Search successfully executed.");
//
//		// closing the driver
//		driver.quit();
//
//	}
//
//	/** Just waits so that you can view the result on screen */
    private void waitABit(){
        try {
            TimeUnit.SECONDS.sleep(5); // 5 seconds should be enough
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // define a query
        String query = "Automated Testing with Selenium";

        // search query on Bing
        Searcher searcher = new Searcher();
        searcher.searchBing(query);
//		searcher.searchYahoo(query);
//		searcher.searchDuckDuckGo(query);

    }

}