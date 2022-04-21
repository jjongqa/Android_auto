package Non_member.Mykurly;

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

public class Kakao_Login {

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
    public void Kakao_Login() throws InterruptedException {

        // 앱 실행
        sleep(5000);

        // 마이컬리 탭 선택
        MobileElement Mykurly = driver.findElementById("com.dbs.kurly.m2.beta:id/mykurly");
        Mykurly.click();
        sleep(1000);

        // 로그인/회원가입 버튼 선택
        MobileElement LoginSignup_Btn = driver.findElementById("com.dbs.kurly.m2.beta:id/loginBtn");
        LoginSignup_Btn.click();
        sleep(1000);

        // 카카오로 시작하기
        MobileElement kakao_login = driver.findElementById("com.dbs.kurly.m2.beta:id/btnLoginWithKakao");
        kakao_login.click();
        sleep(5000);

        // 로그인 성공 확인
        MobileElement Name_check = (MobileElement) driver.findElementById("com.dbs.kurly.m2.beta:id/nameTextView");
        assert Name_check.getText().equals("jjongqa") : "Actual value is : " + Name_check.getText() + "not match with expected value: 로그인 실패";
        sleep(500);

        System.out.println("카카오 간편 로그인 확인");


    }

    @AfterTest
    public void aftertest() throws InterruptedException {

        // 마이컬리 페이지 스크롤
        MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"com.dbs.kurly.m2.beta:id/content\")).getChildByText("
                        + "new UiSelector().className(\"android.widget.TextView\"), \"로그아웃\")"));
        sleep(1000);

        // 로그아웃 버튼 선택
        MobileElement Logout_Btn = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[22]/android.widget.TextView");
        Logout_Btn.click();
        sleep(500);

        driver.quit();

    }

}
