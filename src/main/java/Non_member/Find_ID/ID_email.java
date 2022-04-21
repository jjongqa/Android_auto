package Non_member.Find_ID;

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

public class ID_email {

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
    public void ID_email() throws InterruptedException {

        //앱실행
        sleep(5000);

        //마이컬리 탭 선택
        MobileElement Mykurly = driver.findElementById("com.dbs.kurly.m2.beta:id/mykurly");
        Mykurly.click();
        sleep(3000);

        // 로그인/회원가입 버튼 선택
        MobileElement LoginSignup_Btn = driver.findElementById("com.dbs.kurly.m2.beta:id/loginBtn");
        LoginSignup_Btn.click();
        sleep(1000);

        //아이디 찾기 버튼 선택
        MobileElement findid_btn = driver.findElementById("com.dbs.kurly.m2.beta:id/findIdButton");
        findid_btn.click();
        sleep(2000);

        //이메일 인증 탭
        MobileElement email_btn = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.widget.Button[2]");
        email_btn.click();
        sleep(1000);

        //이름 입력
        MobileElement name_input = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText");
        name_input.click();
        driver.pressKey(new KeyEvent(AndroidKey.A));
        driver.pressKey(new KeyEvent(AndroidKey.U));
        driver.pressKey(new KeyEvent(AndroidKey.T));
        driver.pressKey(new KeyEvent(AndroidKey.O));

        //이메일 입력
        MobileElement email_input = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[4]/android.widget.EditText");
        email_input.click();
        driver.pressKey(new KeyEvent(AndroidKey.A));
        driver.pressKey(new KeyEvent(AndroidKey.U));
        driver.pressKey(new KeyEvent(AndroidKey.T));
        driver.pressKey(new KeyEvent(AndroidKey.O));
        driver.pressKey(new KeyEvent(AndroidKey.AT));
        driver.pressKey(new KeyEvent(AndroidKey.K));
        driver.pressKey(new KeyEvent(AndroidKey.U));
        driver.pressKey(new KeyEvent(AndroidKey.R));
        driver.pressKey(new KeyEvent(AndroidKey.L));
        driver.pressKey(new KeyEvent(AndroidKey.Y));
        driver.pressKey(new KeyEvent(AndroidKey.C));
        driver.pressKey(new KeyEvent(AndroidKey.O));
        driver.pressKey(new KeyEvent(AndroidKey.R));
        driver.pressKey(new KeyEvent(AndroidKey.P));
        driver.pressKey(new KeyEvent(AndroidKey.PERIOD));
        driver.pressKey(new KeyEvent(AndroidKey.C));
        driver.pressKey(new KeyEvent(AndroidKey.O));
        driver.pressKey(new KeyEvent(AndroidKey.M));
        sleep(1000);

        //확인 선택
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        sleep(3000);

        //아이디 전체보기 선택
        MobileElement id_allview = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.widget.Button[1]");
        id_allview.click();
        sleep(2000);

        //얼럿 확인
        MobileElement alert = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.app.Dialog/android.view.View/android.view.View/android.widget.TextView");
        System.out.println(alert.getText());
        assert alert.getText().equals("가입하신 이메일로 아이디가 발송되었습니다. 메일을 받지 못하셨다면 스팸함을 확인해 보세요.\n" +
                "\n" +
                "* 휴대폰 인증으로 아이디 찾기 시에도 전체 아이디 확인이 가능해요.") : "기대결과값 :" + alert.getText() + "실제결과값 : 얼럿내용 이슈";
        System.out.println("아이디 전체보기 얼럿 노출 확인");


    }

    @AfterTest
    public void aftertest() throws InterruptedException {

        sleep(3000);
        driver.quit();
    }

}
