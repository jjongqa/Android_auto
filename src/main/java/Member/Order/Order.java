package Member.Order;

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

public class Order {

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
    public void Order() throws InterruptedException {

        // 앱 실행
        sleep(5000);

        // 카테고리 탭 선택
        MobileElement category_btn = (MobileElement) driver.findElementByAccessibilityId("카테고리");
        category_btn.click();
        sleep(3000);

        // 샛별카테고리 선택
        MobileElement category_list_tap = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]");
        category_list_tap.click();
        sleep(3000);

        // 2차카테고리 선택
        MobileElement smallcategory_tap = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView");
        smallcategory_tap.click();
        sleep(3000);

        // 상품 선택
        MobileElement product = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup[1]/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]");
        product.click();
        sleep(3000);

        // 구매하기 선택
        MobileElement purchase = (MobileElement) driver.findElementById("com.dbs.kurly.m2.beta:id/titleView");
        purchase.click();
        sleep(3000);

        // 장바구니 담기 선택
        MobileElement Add_to_cart = (MobileElement) driver.findElementById("com.dbs.kurly.m2.beta:id/titleView");
        Add_to_cart.click();
        sleep(3000);

        // 디바이스 back
        driver.navigate().back();
        sleep(1000);

        // 장바구니 버튼 선택
        MobileElement cart_btn = (MobileElement) driver.findElementById("com.dbs.kurly.m2.beta:id/ivCartIcon");
        cart_btn.click();
        sleep(3000);

        // 주문하기 버튼 선택
        MobileElement order_btn = (MobileElement) driver.findElementById("com.dbs.kurly.m2.beta:id/titleView");
        order_btn.click();
        sleep(5000);

        // 적립금 모두사용
        MobileElement mileage = driver.findElementByClassName("android.widget.Button");
        if (mileage.getText().equals("모두 사용")) {
            mileage.click();
        }
        sleep(3000);

        //결제진행 필수동의
        MobileElement agreement = driver.findElementByClassName("android.widget.CheckBox");
        if (agreement.getText().equals("결제 진행 필수 동의")) {
            agreement.click();
        }
        sleep(3000);


        MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"kurlyWrap\")).getChildByText("
                        + "new UiSelector().className(\"android.widget.Button\"), \"0원 결제하기\")"));
        sleep(1000);

        //결제하기
        MobileElement payment = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[8]/android.widget.Button");
        payment.click();
        sleep(10000);

        //주문완료 페이지
        MobileElement order_complete = driver.findElementByClassName("android.widget.TextView");
        assert order_complete.getText().equals("주문완료") : "기대결과값 :" + order_complete.getText() + "이슈발생 : 주문완료 페이지 이동 이슈";

        System.out.println("주문완료 확인");


    }

    @AfterTest
    public void afterTest() throws InterruptedException {

        sleep(1000);

        driver.quit();
    }
}
