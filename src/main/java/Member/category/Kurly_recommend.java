package Member.category;

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

public class Kurly_recommend {

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
    public void Kurly_recommend() throws InterruptedException {

        //홈 탭
        MobileElement Home = driver.findElementById("com.dbs.kurly.m2.beta:id/home");
        Home.click();
        sleep(500);

        // 카테고리 탭 선택
        MobileElement category_btn = (MobileElement) driver.findElementByAccessibilityId("카테고리");
        category_btn.click();
        sleep(3000);

        // 컬리의 추천 카테고리리 이동 (관리용 테스트 카테고리)
        MobileElement category_scroll = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"com.dbs.kurly.m2.beta:id/content\")).getChildByText("
                        + "new UiSelector().className(\"android.widget.TextView\"), \"컬리의 추천\")"));
        sleep(5000);

        MobileElement kurly_recommend_category = driver.findElementByXPath(" //android.widget.TextView [@index='3']");
        if (kurly_recommend_category.getText().equals("관리용 테스트 카테고리")) {
            kurly_recommend_category.click();

        }
        sleep(5000);


        // 컬리의 추천 카테고리 상품 선택
        MobileElement kurly_recommend_prd = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup[2]/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
        kurly_recommend_prd.click();

        System.out.println("컬리의 추천 상품 상세 이동 확인");


    }

    @AfterTest
    public void afterTest() throws InterruptedException {

        sleep(1000);

        driver.quit();
    }

}