package Member.Search;

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

public class Search_discount {

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
    public void Search_discount() throws InterruptedException {

        //앱실행
        sleep(5000);

        //검색 탭 선택
        MobileElement Search_btn = driver.findElementById("com.dbs.kurly.m2.beta:id/search");
        Search_btn.click();
        sleep(3000);

        //검색 키워드 입력
        MobileElement Search_input = (MobileElement) driver.findElementById("com.dbs.kurly.m2.beta:id/search_edt");
        Search_input.sendKeys("할인");
        sleep(2000);

        //검색 아이콘 선택
        MobileElement Search_icon = driver.findElementById("com.dbs.kurly.m2.beta:id/iv_search_icon");
        Search_icon.click();
        sleep(5000);

        //할인 상품 대상
        MobileElement discount_prd = driver.findElementById("com.dbs.kurly.m2.beta:id/productNameView");
        if (discount_prd.getText().equals("csm_정률10%할인")) {
            System.out.println("테스트 할인 상품 존재 확인");
        }
        sleep(3000);

        //할인율 확인
        MobileElement discount_rate = driver.findElementById("com.dbs.kurly.m2.beta:id/discountRateView");
        if (discount_rate.getText().equals("50%")) {
            System.out.println("할인율 50% 노출 확인");
        }
        sleep(3000);

        // 할인가 확인
        MobileElement discount_price = driver.findElementById("com.dbs.kurly.m2.beta:id/priceView");
        if (discount_price.getText().equals("1,000원")) {
            System.out.println("할인금액 1,000원 노출 확인");
        }
        sleep(3000);

        // 정상가 확인
        MobileElement normal_price = driver.findElementById("com.dbs.kurly.m2.beta:id/originalPriceView");
        if (normal_price.getText().equals("2,000원")) {
            System.out.println("정상가 2,000원 노출 확인");
        }


    }

    @AfterTest
    public void aftertest() throws InterruptedException {

        sleep(3000);
        driver.quit();
    }
}
