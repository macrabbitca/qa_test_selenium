import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import task3.WebDriverHelper;
import task3.WebDriverCheckBox;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static task3.Browser.CHROME;
import static task3.Browser.FIREFOX;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Task3Test {

    private String testWebUrl = "https://www.dell.com/en-ca/shop/monitors-monitor-accessories/ar/4009";

    @Test@Order(1)
    public void selectOneCheckBoxChromeTest() throws InterruptedException {
        String xpath = "//input[@value='40603']";
        boolean selected = true;

        WebDriver webDriver = WebDriverHelper.setup(testWebUrl, CHROME);
        Boolean isCheck = WebDriverCheckBox.selectOne(xpath, selected, webDriver);
        WebDriverHelper.quit(webDriver);

        assertEquals(true, isCheck);
    }

    @Test@Order(2)
    public void selectOneCheckBoxFireFoxTest() throws InterruptedException {
        String xpath = "//input[@value='40603']";
        boolean selected = true;

        WebDriver webDriver = WebDriverHelper.setup(testWebUrl, FIREFOX);
        Boolean isCheck = WebDriverCheckBox.selectOne(xpath, selected, webDriver);
        WebDriverHelper.quit(webDriver);

        assertEquals(true, isCheck);
    }

    @Test@Order(3)
    public void selectMultipleCheckBoxChromeTest() throws InterruptedException {
        Map<String, Boolean> checkBoxMap = new HashMap<>();
        checkBoxMap.put("//input[@value='40603']", true);
        checkBoxMap.put("//input[@value='40604']", true);
        checkBoxMap.put("//input[@value='40747']", false);
        checkBoxMap.put("//input[@value='40605']", true);

        Map<String, Boolean> expectMap =  checkBoxMap;


        WebDriver webDriver = WebDriverHelper.setup(testWebUrl, CHROME);
        Map<String, Boolean> resultMap = WebDriverCheckBox.selectMultiple(checkBoxMap, webDriver);
        WebDriverHelper.quit(webDriver);

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
