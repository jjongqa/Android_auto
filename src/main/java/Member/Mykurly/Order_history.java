package Member.Mykurly;

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

public class Order_history {

    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void beforeTest() throws MalformedParameterizedTypeException, MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.dbs.kurly.m2.beta");
        capabilities.setCapability("appActivity", "com.dbs.kurly.m2.a_new_presentation.deeplink.DeepLinkActivity");
        capabilities.setCapability("noReset", "true");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void Order_history() throws InterruptedException {

        //앱실행
        sleep(5000);


        //마이컬리 탭 선택
        MobileElement Mykurly = driver.findElementById("com.dbs.kurly.m2.beta:id/mykurly");
        Mykurly.click();
        sleep(3000);

        //주문내역 버튼 선택
        MobileElement order_btn = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.TextView");
        order_btn.click();
        sleep(3000);

        //주문내역 페이지 이동 확인
        MobileElement order_his_page = driver.findElementByClassName("android.widget.TextView");
        if (order_his_page.getText().equals("주문 내역")) {
            System.out.println("주문 내역 페이지 이동 확인");
        }
        sleep(2000);

        //주문번호 확인
        MobileElement order_num = driver.findElementById("com.dbs.kurly.m2.beta:id/orderNoView");
        if (order_num.getText().equals("1649399839254")) {
            System.out.println("주문번호 1649399839254 노출 확인");
        }
        sleep(2000);

        //상품명 확인
        MobileElement order_name = driver.findElementById("com.dbs.kurly.m2.beta:id/orderTitleView");
        if (order_name.getText().equals("@@낮배송@@ [토마스푸드] 프렌치드 숄더랙(냉장)")) {
            System.out.println("상품명 @@낮배송@@ [토마스푸드] 프렌치드 숄더랙(냉장) 노출 확인");
        }
        sleep(2000);

        //결제일시 확인
        MobileElement order_date = driver.findElementById("com.dbs.kurly.m2.beta:id/orderDateView");
        if (order_date.getText().equals("2022.04.08 15:37:23")) {
            System.out.println("결제 일시 노출 확인");
        }
        sleep(2000);

        //결제방법 확인
        MobileElement order_method = driver.findElementById("com.dbs.kurly.m2.beta:id/orderMethodView");
        if (order_method.getText().equals("전액할인 결제 (적립금 사용)")) {
            System.out.println("결제방법 적립금 노출 확인");
        }
        sleep(2000);

        //결제금액 확인
        MobileElement order_price = driver.findElementById("com.dbs.kurly.m2.beta:id/orderPriceView");
        if (order_price.getText().equals("0원")) {
            System.out.println("결제금액 노출 확인");
        }
        sleep(2000);

        //주문상태 확인
        MobileElement order_status = driver.findElementById("com.dbs.kurly.m2.beta:id/orderStatusView");
        if (order_status.getText().equals("배송완료")) {
            System.out.println("주문상태 배송완료 노출 확인");
        }
        sleep(1000);


    }

    @AfterTest
    public void aftertest() throws InterruptedException {

        sleep(2000);
        driver.quit();
    }

}
