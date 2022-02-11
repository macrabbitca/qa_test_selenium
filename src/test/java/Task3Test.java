import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import task3.ChromeWebDriverHelper;
import task3.WebDriverCheckBox;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {

    private String testWebUrl = "https://www.dell.com/en-ca/shop/monitors-monitor-accessories/ar/4009";

    @Test@Order(1)
    public void selectOneCheckBoxTest() throws InterruptedException {
        String xpath = "//input[@value='40603']";
        boolean selected = true;

        WebDriver webDriver = ChromeWebDriverHelper.setup(testWebUrl);
        Boolean isCheck = WebDriverCheckBox.selectOne(xpath, selected, webDriver);
        ChromeWebDriverHelper.quit(webDriver);

        assertEquals(true, isCheck);
    }

    @Test@Order(2)
    public void selectMultipleCheckBoxTest() throws InterruptedException {
        Map<String, Boolean> checkBoxMap = new HashMap<>();
        checkBoxMap.put("//input[@value='40603']", true);
        checkBoxMap.put("//input[@value='40604']", true);
        checkBoxMap.put("//input[@value='40747']", false);
        checkBoxMap.put("//input[@value='40605']", true);

        Map<String, Boolean> expectMap =  checkBoxMap;


        WebDriver webDriver = ChromeWebDriverHelper.setup(testWebUrl);
        Map<String, Boolean> resultMap = WebDriverCheckBox.selectMultiple(checkBoxMap, webDriver);
        ChromeWebDriverHelper.quit(webDriver);

        if(resultMap.size() != checkBoxMap.size()){
           assertEquals(true, false);
        }

        for(Map.Entry<String, Boolean> entry : expectMap.entrySet()){
            if(resultMap.containsKey(entry.getKey())){
                if(entry.getValue() != resultMap.get(entry.getKey())){
                    assertEquals(true, false);
                }else {
                    assertEquals(true, true);
                }
            }else {
                assertEquals(true, false);
            }
        }
    }
}
