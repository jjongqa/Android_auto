package Member.Search;

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

public class Search_result {

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
    public void Search_result() throws InterruptedException {

        //검색 탭 선택
        MobileElement Search_btn = driver.findElementById("com.dbs.kurly.m2.beta:id/search");
        Search_btn.click();
        sleep(3000);

        //검색 키워드 입력
        MobileElement Search_input = (MobileElement) driver.findElementById("com.dbs.kurly.m2.beta:id/search_edt");
        Search_input.sendKeys("삼겹살");
        sleep(2000);

        //상품 바로가기 선택
        MobileElement result_tap = driver.findElementById("com.dbs.kurly.m2.beta:id/suggestionItemText");
        if (result_tap.getText().equals("[미트클레버] 더건강한 삼겹살")) {
            result_tap.click();
        }
        sleep(5000);

        //상품 상세 확인
        MobileElement prd_detail = driver.findElementByClassName("android.widget.TextView");
        if (prd_detail.getText().equals("[미트클레버] 더건강한 삼겹살")) {
            System.out.println("상품 바로가기 정상 확인");

        }

    }

    @AfterTest
    public void aftertest() throws InterruptedException {

        sleep(3000);
        driver.quit();

    }
}
