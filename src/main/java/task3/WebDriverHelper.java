package task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Selenium web driver helper class.
 * @author Jim Wang
 * @createTime 2022-02-09
 */
public class WebDriverHelper {

    private static int SLEEP_TIME = 2000;

    protected static WebDriver driver;

    public WebDriverHelper(WebDriver driver) {
        super();
    }

    /**
     * Set up the chrome web driver for tested web page.
     * @param url test web url
     * @param  browser name like chrome, firefox
     * @return chrome web driver
     */
    public static WebDriver setup(String url, Browser browser) {

        switch (browser){
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", BrowserDriver.FIREFOX.getPath());
                driver = new FirefoxDriver();
                break;
            case EDGE:
                System.setProperty("webdriver.edge.driver", BrowserDriver.EDGE.getPath());
                driver = new EdgeDriver();
                break;
            case SAFARI:
                System.setProperty("webdriver.safari.driver", BrowserDriver.EDGE.getPath());
                driver = new SafariDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", BrowserDriver.CHROME.getPath());
                //Create a instance of your web driver - chrome driver 98.0.4758.80 ver. for mac
                driver = new ChromeDriver();
        }

        driver.get(url);

        return driver;
    }

    /**
     * close webdriver and quit
     * @param driver webDriver
     */
    public static void quit(WebDriver driver) throws InterruptedException {
        Thread.sleep(SLEEP_TIME);
        driver.quit();
    }
}
