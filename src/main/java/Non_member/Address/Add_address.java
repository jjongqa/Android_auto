package Non_member.Address;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Thread.sleep;

public class Add_address {

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
    public void Add_address() throws InterruptedException {

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


        //주소지 입력
        MobileElement address_input = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View");
        address_input.click();
        driver.pressKey(new KeyEvent(AndroidKey.C));
        driver.pressKey(new KeyEvent(AndroidKey.O));
        driver.pressKey(new KeyEvent(AndroidKey.E));
        driver.pressKey(new KeyEvent(AndroidKey.X));
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        sleep(2000);

        //주소지 선택
        MobileElement address_tap = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ListView/android.view.View[2]/android.widget.ListView/android.view.View[2]/android.widget.Button");
        address_tap.click();
        sleep(2000);

        //주소지 저장
        MobileElement address_save = driver.findElementById("com.dbs.kurly.m2.beta:id/titleView");
        address_save.click();
        sleep(1000);

        //얼럿 확인
        MobileElement alert = driver.findElementById("android:id/button1");
        alert.click();
        sleep(1000);

        //배송지 추가 토스트 확인
        MobileElement toast = driver.findElementById("com.dbs.kurly.m2.beta:id/tvTitle");
        System.out.println(toast.getText());
        assert toast.getText().equals("배송지가 설정되었습니다.") : "기대결과 : " + toast.getText() + "실제결과 : 배송지 추가 토스트 미발생";
        System.out.println("배송지 추가 토스트 확인");
        sleep(2000);

        //배송지 추가 확인
        address_icon1.click();
        sleep(1000);

        MobileElement address_check = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[1]");
        System.out.println(address_check.getText());
        System.out.println("서울 강남구 영동대로 513 (코엑스) 배송지 추가 확인");

        sleep(2000);


    }

    @AfterTest
    public void afterTest() throws InterruptedException {

        sleep(1000);
        driver.quit();

    }

}
