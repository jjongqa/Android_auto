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

public class Address_manage {

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
    public void Address_manage() throws InterruptedException {

        //앱실행
        sleep(5000);


        //마이컬리 탭 선택
        MobileElement Mykurly = driver.findElementById("com.dbs.kurly.m2.beta:id/mykurly");
        Mykurly.click();
        sleep(3000);

        //배송지관리 버튼 선택
        MobileElement address_manage = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[8]/android.widget.TextView");
        address_manage.click();
        sleep(3000);

        //배송지관리 페이지 이동 확인
        MobileElement address_page = driver.findElementByClassName("android.widget.TextView");
        if (address_page.getText().equals("배송지 관리")) {
            System.out.println("배송지 관리 페이지 이동 확인");
        } else {
            System.out.println(address_page.getText());
            assert address_page.getText().equals("배송지 관리") : "Actual value is :" + address_page.getText() + "did not match with expected value : 배송지관리 타이틀명 이슈";
        }
        sleep(2000);

        //배송지 선택
        MobileElement address_tap = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.CheckBox");
        address_tap.click();
        sleep(1000);

        // 배송지 선택 토스트 팝업 확인
        MobileElement address_toast = (MobileElement) driver.findElementById("com.dbs.kurly.m2.beta:id/tvTitle");

        System.out.println(address_toast.getText());
        assert address_toast.getText().equals("배송지 선택이 완료되었습니다.") : "Actual value is :" + address_toast.getText() + "did not match with expected value : 토스트 미발생";

        System.out.println("배송지 선택 토스트 확인");


    }

    @AfterTest
    public void aftertest() throws InterruptedException {

        sleep(2000);
        driver.quit();
    }


}
