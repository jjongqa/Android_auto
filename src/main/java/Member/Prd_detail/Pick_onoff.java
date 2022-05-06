package Member.Prd_detail;

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

public class Pick_onoff {
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
        sleep(2000);

    }

    @Test
    public void Pick_onoff() throws InterruptedException {


        // 카테고리 탭 선택
        MobileElement category_btn = (MobileElement) driver.findElementByAccessibilityId("카테고리");
        category_btn.click();
        sleep(3000);


        // 샛별카테고리 선택
        MobileElement category_list_tap = driver.findElementByXPath(" //android.widget.TextView [@index='2']");
        if (category_list_tap.getText().equals("샛별확장_통합테스트")) {
            category_list_tap.click();
        }
        sleep(3000);


        // 2차카테고리 선택 (210)
        MobileElement smallcategory_tap = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView");
        smallcategory_tap.click();
        sleep(3000);

        //상품 선택
        MobileElement prd = driver.findElementById("com.dbs.kurly.m2.beta:id/productNameView");
        if (prd.getText().equals("[마켓베라즈] 양념 생연어장 200g(냉장)")) {
        }
        prd.click();
        sleep(10000);

        //찜하기 선택(활성화)
        MobileElement pick_btn1 = driver.findElementById("com.dbs.kurly.m2.beta:id/pick_button_container");
        pick_btn1.click();
        sleep(3000);

        //찜하기 선택(비활성화)
        MobileElement pick_btn2 = driver.findElementById("com.dbs.kurly.m2.beta:id/pick_button_container");
        pick_btn2.click();
        sleep(5000);

        //찜하기 버튼 비활성화 확인
        MobileElement pick_off = driver.findElementById("com.dbs.kurly.m2.beta:id/iconView");
        boolean selected2 = pick_off.isSelected();
        if (selected2 == false) {
            System.out.println("찜하기 활성화/비활성화 확인");
        }
        sleep(3000);

    }

    @AfterTest
    public void aftertest() throws InterruptedException {
        sleep(2000);
        driver.quit();

    }

}
