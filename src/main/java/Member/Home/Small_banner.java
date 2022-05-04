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
    public void beforeTest() throws MalformedParameterizedTypeException, MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.dbs.kurly.m2.beta");
        capabilities.setCapability("appActivity", "com.dbs.kurly.m2.a_new_presentation.deeplink.DeepLinkActivity");
        capabilities.setCapability("noReset", "false");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //앱실행
        sleep(5000);

        //권한팝업 확인
        MobileElement popup = driver.findElementById("com.dbs.kurly.m2.beta:id/okButton");
        popup.click();
        sleep(1000);

        //혜택정보 확인
        MobileElement popup2 = driver.findElementById("com.dbs.kurly.m2.beta:id/okButton");
        popup2.click();
        sleep(1000);

        //메인팝업 오늘 하루 안보기
        MobileElement mainpopup1 = driver.findElementById("android:id/button2");
        if (mainpopup1.getText().equals("오늘 하루 안 보기")) {
            mainpopup1.click();
        }
        sleep(1000);

        MobileElement mainpopup2 = driver.findElementById("android:id/button2");
        if (mainpopup2.getText().equals("오늘 하루 안 보기")) {
            mainpopup2.click();
        }
        sleep(1000);


        // 마이컬리 탭 선택
        MobileElement Mykurly = driver.findElementById("com.dbs.kurly.m2.beta:id/mykurly");
        Mykurly.click();
        sleep(1000);

        // 로그인/회원가입 버튼 선택
        MobileElement LoginSignup_Btn = driver.findElementById("com.dbs.kurly.m2.beta:id/loginBtn");
        LoginSignup_Btn.click();
        sleep(1000);

        // 아이디 입력
        MobileElement ID_input = driver.findElementById("com.dbs.kurly.m2.beta:id/idEditView");
        ID_input.sendKeys("autotest");
        sleep(500);

        // 패스워드 입력
        MobileElement PW_input = driver.findElementById("com.dbs.kurly.m2.beta:id/passwordEditView");
        PW_input.sendKeys("qawsedrf12");
        sleep(500);

        // 로그인 버튼 선택
        MobileElement Login_Btn = driver.findElementById("com.dbs.kurly.m2.beta:id/loginButton");
        Login_Btn.click();
        sleep(1000);

    }

    @Test
    public void Small_banner() throws InterruptedException {

        //홈 탭
        MobileElement Home = driver.findElementById("com.dbs.kurly.m2.beta:id/home");
        Home.click();
        sleep(500);

        //컬리추천 스크롤
        MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"com.dbs.kurly.m2.beta:id/home_content\")).getChildByText("
                        + "new UiSelector().className(\"android.widget.TextView\"), \"컬리의 레시피1\")"));
        sleep(2000);

        //띠배너 선택
        MobileElement banner = driver.findElementById("com.dbs.kurly.m2.beta:id/bannerClickArea");
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