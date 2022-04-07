package Member.category;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Thread.sleep;

public class Second_category_prddetail {


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
    public void Second_category_prddetail() throws InterruptedException {

        //앱실행
        sleep(5000);

        // 카테고리 탭 선택
        MobileElement category_btn = (MobileElement) driver.findElementByAccessibilityId("카테고리");
        category_btn.click();
        sleep(3000);


        // 샛별카테고리 선택
        MobileElement category_list_tap = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]");
        category_list_tap.click();
        sleep(3000);


        // 2차카테고리 선택 (210)
        MobileElement smallcategory_tap = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView");
        smallcategory_tap.click();
        sleep(3000);


        // 201 카테고리 리스트 페이지
        MobileElement second_category_page = driver.findElementByAccessibilityId("210");
        boolean selected = second_category_page.isSelected();
        {
            if (selected == true) {
                System.out.println("201 카테고리 리스트 페이지 확인");
            }
        }
        sleep(3000);

        //상품 선택
        MobileElement prd = driver.findElementById("com.dbs.kurly.m2.beta:id/productNameView");
        {
            if (prd.getText().equals("[마켓베라즈] 양념 생연어장 200g(냉장)")) {
                prd.click();
            }
        }
        sleep(2000);

        //다른고객이 함께 본 상품
        MobileElement prd_scroll = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"com.dbs.kurly.m2.beta:id/product_detail_pager\")).getChildByText("
                        + "new UiSelector().className(\"android.widget.TextView\"), \"다른 고객이 함께 본 상품\")"));
        sleep(1000);

        System.out.println("다른 고객이 함꼐 본 상품 노출 확인");


    }


}
