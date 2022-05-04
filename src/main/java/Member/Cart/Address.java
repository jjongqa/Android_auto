package Member.Cart;

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

public class Address {

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
    public void Address_change() throws InterruptedException {

        // 장바구니 버튼 선택
        MobileElement cart_btn = (MobileElement) driver.findElementById("com.dbs.kurly.m2.beta:id/ivCartIcon");
        cart_btn.click();
        sleep(3000);

        //배송지 아이콘 선택
        MobileElement address_icon1 = driver.findElementById("com.dbs.kurly.m2.beta:id/addressInfoButton");
        address_icon1.click();
        sleep(2000);

        //배송불가지역 선택
        MobileElement no_delivery = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.view.ViewGroup");
        no_delivery.click();
        sleep(1000);

        //배송불가지역 선택 토스트 확인
        MobileElement no_delivery_toast = driver.findElementById("com.dbs.kurly.m2.beta:id/tvTitle");
        System.out.println(no_delivery_toast.getText());
        assert no_delivery_toast.getText().equals("배송지 변경으로 상품 정보가 업데이트됩니다.") : "기대결과값 :" + no_delivery_toast.getText() + "이슈값 : 배송불가지역 토스트 미발생";
        System.out.println("배송불가지역 토스트 확인");
        sleep(2000);

        //배송지 아이콘 선택
        address_icon1.click();
        sleep(2000);

        //택배지역 선택
        MobileElement nomal_delivery = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.view.ViewGroup");
        nomal_delivery.click();
        sleep(1000);

        //일반택배지역 선택 토스트 확인
        MobileElement nomal_delivery_toast = driver.findElementById("com.dbs.kurly.m2.beta:id/tvTitle");
        System.out.println(nomal_delivery_toast.getText());
        assert nomal_delivery_toast.getText().equals("배송지 변경으로 상품 정보가 업데이트됩니다.") : "기대결과값 :" + nomal_delivery_toast.getText() + "이슈값 : 일반택배 토스트 미발생";
        System.out.println("일반택배지역 토스트 확인");
        sleep(2000);


        //배송지 아이콘 선택
        address_icon1.click();
        sleep(2000);

        //택배지역 선택
        MobileElement fast_delivery = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.view.ViewGroup");
        fast_delivery.click();
        sleep(1000);

        //일반택배지역 선택 토스트 확인
        MobileElement fast_delivery_toast = driver.findElementById("com.dbs.kurly.m2.beta:id/tvTitle");
        System.out.println(fast_delivery_toast.getText());
        assert fast_delivery_toast.getText().equals("배송지 변경으로 상품 정보가 업데이트됩니다.") : "기대결과값 :" + fast_delivery_toast.getText() + "이슈값 : 샛별택배 토스트 미발생";
        System.out.println("샛별택배지역 토스트 확인");
        sleep(2000);


    }

    @AfterTest
    public void afterTest() {

        driver.quit();
    }

}
