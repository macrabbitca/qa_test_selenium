package task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Selenium web driver helper class.
 * @author Jim Wang
 * @createTime 2022-02-09
 */
public class ChromeWebDriverHelper {

    private static int SLEEP_TIME = 2000;

    protected static WebDriver driver;

    public ChromeWebDriverHelper(WebDriver driver) {
        super();
    }

    /**
     * Set up the chrome web driver for tested web page.
     * @param url test web url
     * @return chrome web driver
     */
    public static WebDriver setup(String url) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
        //Create a instance of your web driver - chrome driver 98.0.4758.80 ver. for mac
        driver = new ChromeDriver();
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
