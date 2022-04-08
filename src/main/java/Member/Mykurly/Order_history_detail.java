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

public class Order_history_detail {

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
    public void Order_history_detail() throws InterruptedException {

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


        //주문번호 확인
        MobileElement order_num = driver.findElementById("com.dbs.kurly.m2.beta:id/orderNoView");
        if (order_num.getText().equals("1649399839254")) {
            order_num.click();
        }
        sleep(3000);

        //주문내역 상세 이동 확인
        MobileElement order_detail_page = driver.findElementByClassName("android.widget.TextView");
        if (order_detail_page.getText().equals("주문 내역 상세")) {
            System.out.println("주문내역상세 이동 확인");
        }


    }

    @AfterTest
    public void aftertest() throws InterruptedException {

        sleep(2000);
        driver.quit();
    }
}
