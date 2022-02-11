package task3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * Checkbox test class.
 * @author Jim Wang
 * @createTime 2022-02-10
 */
public class WebDriverCheckBox {

    private static int SLEEP_TIME = 1000;

    /**
     * Select a checkbox,
     * @param xpath string path
     * @param selected  true: check ; false: uncheck
     * @param webDriver WebDriver
     * @return true: selected, false : unselected
     * @throws InterruptedException
     */
    public static Boolean selectOne(String xpath, Boolean selected, WebDriver webDriver) throws InterruptedException {
        Thread.sleep(SLEEP_TIME);

        //find by xpath
        if(selected) {
            webDriver.findElement(By.xpath(xpath)).click();
        }else {
            //if already selected, click to unselect the checkbox
            if(webDriver.findElement(By.xpath(xpath)).isSelected()) {
                webDriver.findElement(By.xpath(xpath)).click();
            }
        }
        //sleep seconds waiting for the page loading
        Thread.sleep(SLEEP_TIME);
        if(webDriver.findElement(By.xpath(xpath)).isSelected()){
            return true;
        }

        return false;
    }

    /**
     * Select multiple checkbox and return result whit a map.
     * @param webDriver WebDriver
     * @param map key: xpath, value : selected,
     * @return map, key: xpath , value : whether the checkbox has been selected. true : selected, false: unselected
     */
    public static Map<String, Boolean> selectMultiple(Map<String, Boolean> map, WebDriver webDriver) throws InterruptedException {
        Map<String, Boolean> resultMap = new HashMap<>();
        if(map == null || map.size() == 0){
            return resultMap;
        }

        for(Map.Entry<String, Boolean> entry :map.entrySet()){
            Boolean isSelected = entry.getValue();
            String xpath = entry.getKey();

            if(isSelected) {
                webDriver.findElement(By.xpath(xpath)).click();
            }else {
                //if already selected, click to unselect the checkbox
                if(webDriver.findElement(By.xpath(xpath)).isSelected()) {
                    webDriver.findElement(By.xpath(xpath)).click();
                }
            }

            //put the xpath value and whether selected checkbox  into the result map
            resultMap.put(xpath, webDriver.findElement(By.xpath(xpath)).isSelected());

        }
        Thread.sleep(SLEEP_TIME);

        return resultMap;
    }
}
