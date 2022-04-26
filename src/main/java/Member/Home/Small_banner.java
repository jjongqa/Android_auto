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

public class Small_banner {

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
    public void Small_banner() throws InterruptedException {

        // 앱 실행
        sleep(5000);

        //컬리추천 스크롤
        MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"com.dbs.kurly.m2.beta:id/home_content\")).getChildByText("
                        + "new UiSelector().className(\"android.widget.TextView\"), \"컬리의 레시피1\")"));
        sleep(2000);

        //띠배너 선택
        MobileElement banner = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.view.View");
        banner.click();
        sleep(2000);

        //띠배너 상세페이지 확인
        MobileElement title = driver.findElementByClassName("android.widget.TextView");
        System.out.println(title.getText());
        assert title.getText().equals("[제로베이커리] 저탄수 브라우니") : "기대결과값 :" + title.getText() + "실제 결과값 : 띠배너 상세페이지 이슈";
        System.out.println("띠배너 상세페이지 이동 확인");
        sleep(1000);

    }

    @AfterTest
    public void aftertest() throws InterruptedException {

        sleep(2000);

        driver.quit();

    }
}