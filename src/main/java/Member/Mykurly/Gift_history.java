package Member.Mykurly;

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

public class Gift_history {

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
    public void Present_history() throws InterruptedException {


        //마이컬리 탭 선택
        MobileElement Mykurly = driver.findElementById("com.dbs.kurly.m2.beta:id/mykurly");
        Mykurly.click();
        sleep(3000);

        //선물내역 버튼 선택
        MobileElement gift_btn = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.TextView");
        gift_btn.click();
        sleep(3000);

        //선물내역 페이지 이동 확인
        MobileElement order_his_page = driver.findElementByClassName("android.widget.TextView");
        if (order_his_page.getText().equals("선물 내역")) {
            System.out.println("선물 내역 페이지 이동 확인");
        }
        sleep(2000);


        //상품명 확인
        MobileElement prd_name = driver.findElementById("com.dbs.kurly.m2.beta:id/productName");
        if (prd_name.getText().equals("QA_상온상품4 (선물하기)")) {
            System.out.println("상품명 QA_상온상품4 (선물하기) 노출 확인");
        }
        sleep(2000);


        //썸네일 확인
        MobileElement image = driver.findElementById("com.dbs.kurly.m2.beta:id/productImage");
        boolean isDisplay = image.isDisplayed();
        if (isDisplay == true) {
            System.out.println("썸네일 노출 확인");
        }


        //받으실분 확인
        MobileElement receiver = driver.findElementById("com.dbs.kurly.m2.beta:id/receiver");
        if (receiver.getText().equals("test (카카오톡)")) {
            System.out.println("받을실분 test (카카오톡) 노출 확인");
        }
        sleep(2000);

        //결제일시 확인
        MobileElement payment_date = driver.findElementById("com.dbs.kurly.m2.beta:id/paymentDate");
        if (payment_date.getText().equals("2022-04-08 15:40:13")) {
            System.out.println("결제 일시 노출 확인");
        }
        sleep(2000);


        //주문번호 확인
        MobileElement order_num = driver.findElementById("com.dbs.kurly.m2.beta:id/orderNo");
        if (order_num.getText().equals("7100000001661")) {
            System.out.println("주문번호 7100000001661 노출 확인");
        }
        sleep(2000);


        //결제금액 확인
        MobileElement paymentPrice = driver.findElementById("com.dbs.kurly.m2.beta:id/paymentPrice");
        if (paymentPrice.getText().equals("0원")) {
            System.out.println("결제금액 노출 확인");
        }
        sleep(2000);


        //선물상태확인
        MobileElement gift_status = driver.findElementById("com.dbs.kurly.m2.beta:id/giftState");
        if (gift_status.getText().equals("선물 수락 대기")) {
            System.out.println("선물 상태 선물 수락 대기 노출 확인");
        }
        sleep(1000);


    }

    @AfterTest
    public void aftertest() throws InterruptedException {

        sleep(2000);
        driver.quit();
    }

}

