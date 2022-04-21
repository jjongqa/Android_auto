package Member.Address;

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

public class Change_address {

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
    public void Change_address() throws InterruptedException {

        //앱실행
        sleep(5000);

        //마이컬리 탭 선택
        MobileElement Mykurly = driver.findElementById("com.dbs.kurly.m2.beta:id/mykurly");
        Mykurly.click();
        sleep(3000);

        //배송지 아이콘 선택
        MobileElement address_icon1 = driver.findElementById("com.dbs.kurly.m2.beta:id/ivAddressIcon");
        address_icon1.click();
        sleep(2000);

        //배송지 선택
        MobileElement address_tap = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup");
        address_tap.click();
        sleep(2000);

        //배송지 변경 토스트 확인
        MobileElement toast = driver.findElementById("com.dbs.kurly.m2.beta:id/tvTitle");
        System.out.println(toast.getText());
        assert toast.getText().equals("배송지가 변경되었습니다.") : "기대결과값 :" + toast.getText() + "실제결과값 : 배송지 변경 토스트 이슈";
        System.out.println("배송지 변경 토스트 노출 확인");
        sleep(2000);


    }

    @AfterTest
    public void aftertest() throws InterruptedException {

        //배송지 아이콘 선택
        MobileElement address_icon1 = driver.findElementById("com.dbs.kurly.m2.beta:id/ivAddressIcon");
        address_icon1.click();
        sleep(2000);

        //배송지 선택
        MobileElement address_tap = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup");
        address_tap.click();
        sleep(2000);

        sleep(2000);
        driver.quit();
    }

}
