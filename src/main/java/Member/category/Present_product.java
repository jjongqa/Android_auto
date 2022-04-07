package Member.category;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Thread.sleep;

public class Present_product {

    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void beforeTest() throws MalformedParameterizedTypeException, MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.dbs.kurly.m2.beta");
        capabilities.setCapability("appActivity", "com.dbs.kurly.m2.a_new_presentation.deeplink.DeepLinkActivity");
        capabilities.setCapability("noReset", "true");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }


    @Test
    public void Present_product() throws InterruptedException {

        //앱실행
        sleep(5000);

        // 카테고리 탭 선택
        MobileElement category_btn = (MobileElement) driver.findElementByAccessibilityId("카테고리");
        category_btn.click();
        sleep(3000);

        // 선물하기 카테고리 선택
        MobileElement present_category = driver.findElementById("com.dbs.kurly.m2.beta:id/nameView");
        {
            if (present_category.getText().equals("선물하기")) {
                present_category.click();
            }
        }
        sleep(3000);

        // 선물하기 리스트 페이지
        MobileElement present_listpage = driver.findElementByClassName("android.widget.TextView");
        {
            if (present_listpage.getText().equals("선물하기")) {
                System.out.println("선물하기 리스트 페이지 확인");
            }


        }


    }

    @AfterTest
    public void afterTest() throws InterruptedException {

        sleep(1000);

        driver.quit();
    }
}