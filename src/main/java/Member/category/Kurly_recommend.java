package Member.category;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Thread.sleep;

public class Kurly_recommend {

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
    public void Kurly_recommend() throws InterruptedException {

        //앱 실행
        sleep(5000);

        // 카테고리 탭 선택
        MobileElement category_btn = (MobileElement) driver.findElementByAccessibilityId("카테고리");
        category_btn.click();
        sleep(3000);

        // 컬리의 추천 카테고리리 이동 (관리용 테스트 카테고리)
        MobileElement category_scroll = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"com.dbs.kurly.m2.beta:id/content\")).getChildByText("
                        + "new UiSelector().className(\"android.widget.TextView\"), \"컬리의 추천\")"));
        sleep(5000);

        MobileElement kurly_recommend_category = driver.findElementByXPath(" //android.widget.TextView [@index='3']");
        if (kurly_recommend_category.getText().equals("관리용 테스트 카테고리")) {
            kurly_recommend_category.click();

        }
        sleep(5000);


        // 컬리의 추천 카테고리 상품 선택
        MobileElement kurly_recommend_prd = driver.findElementById("com.dbs.kurly.m2.beta:id/productNameView");
        if (kurly_recommend_prd.getText().equals("[상하치즈] Mini 스낵 치즈 3종")) {
            kurly_recommend_prd.click();

        }
        sleep(5000);

        // 컬리의 추천 상품 상세 이동 확인
        MobileElement kurly_recommend_prd_detail = driver.findElementByClassName("android.widget.TextView");
        if (kurly_recommend_prd_detail.getText().equals("[상하치즈] Mini 스낵 치즈 3종")) {
            System.out.println("컬리의 추천 상품 상세 이동 확인");
        }

    }

    @AfterTest
    public void afterTest() throws InterruptedException {

        sleep(1000);

        driver.quit();
    }

}