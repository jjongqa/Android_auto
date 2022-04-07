package Member.Home;

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

public class Mainbanner {


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
    public void Mainbanner() throws InterruptedException {

        // 앱 실행
        sleep(5000);

        // 메인배너 선택
        MobileElement Main_banner = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.View");
        Main_banner.click();
        sleep(2000);

        System.out.println("메인베너 이동 확인");


    }

    @AfterTest
    public void aftertest() throws InterruptedException {

        sleep(1000);

        driver.quit();

    }


}
