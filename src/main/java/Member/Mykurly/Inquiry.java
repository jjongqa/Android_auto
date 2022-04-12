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

public class Inquiry {

    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void beforeTest() throws MalformedParameterizedTypeException, MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.dbs.kurly.m2.beta");
        capabilities.setCapability("appActivity", "com.dbs.kurly.m2.a_new_presentation.deeplink.DeepLinkActivity");
        capabilities.setCapability("noReset", "true");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }


    @Test
    public void Inquiry() throws InterruptedException {

        //앱실행
        sleep(5000);

        //마이컬리 탭 선택
        MobileElement Mykurly = driver.findElementById("com.dbs.kurly.m2.beta:id/mykurly");
        Mykurly.click();
        sleep(3000);

        //1:1문의 버튼 선택
        MobileElement inquiry = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[13]/android.widget.TextView");
        inquiry.click();
        sleep(3000);

        //1:1문의 페이지 이동 확인
        MobileElement inquiry_page = driver.findElementByClassName("android.widget.TextView");
        if (inquiry_page.getText().equals("1:1문의")) {
            System.out.println("1:1문의 페이지 이동 확인");
        } else {
            System.out.println(inquiry_page.getText());
            assert inquiry_page.getText().equals("1:1문의") : "Actual value is :" + inquiry_page.getText() + "did not match with expected value : 1:1문의 타이틀명 이슈";
        }
        sleep(2000);

        //1:1문의 선택
        MobileElement inquiry_tap = driver.findElementById("com.dbs.kurly.m2.beta:id/btnInquiryCompose");
        inquiry_tap.click();
        sleep(4000);

        //1:1문의 팝업 확인 선택
        MobileElement inquiry_popup = driver.findElementById("android:id/button1");
        inquiry_popup.click();
        sleep(1000);

        //문의유형
        MobileElement type = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/androidx.appcompat.widget.LinearLayoutCompat/androidx.appcompat.widget.LinearLayoutCompat[1]/androidx.cardview.widget.CardView[1]/android.widget.TextView");
        type.click();
        sleep(1000);

        //문의유형 리스트 선택
        MobileElement type_tap = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[6]");
        type_tap.click();
        sleep(1000);

        //문의유형 상세 선택
        MobileElement type_detail = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/androidx.appcompat.widget.LinearLayoutCompat/androidx.appcompat.widget.LinearLayoutCompat[1]/androidx.cardview.widget.CardView[2]/android.widget.TextView");
        type_detail.click();
        sleep(1000);

        //문의유형 상세 리스트 선택
        MobileElement type_detail_tap = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[1]");
        type_detail_tap.click();
        sleep(1000);

        //문의제목 입력
        MobileElement inquiry_title = (MobileElement) driver.findElementById("com.dbs.kurly.m2.beta:id/etInquirySubject");
        inquiry_title.sendKeys("테스트입니다.");
        sleep(1000);

        //문의상세 입력
        MobileElement inquiry_content = driver.findElementById("com.dbs.kurly.m2.beta:id/etInquiryContents");
        inquiry_content.sendKeys("테스트입니다.");
        sleep(1000);

        //등록하기 선택
        MobileElement register = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/androidx.appcompat.widget.LinearLayoutCompat/androidx.appcompat.widget.LinearLayoutCompat[2]/android.widget.Button");
        register.click();
        sleep(3000);


        //등록완료 팝업 확인
        MobileElement register_popup = driver.findElementById("com.dbs.kurly.m2.beta:id/tvMessage");
        boolean isDisplay = register_popup.isDisplayed();
        if (isDisplay == true) {
            System.out.println(" `1:1문의가 정상적으로 접수되었습니다.` 팝업 문구 노출 확인");
        }
        sleep(2000);

        //등록완룐 팝업 확인 선택
        MobileElement register_popup_check = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.TextView[2]");
        register_popup_check.click();
        sleep(3000);

        //1:1문의 등록
        MobileElement inqury_check = driver.findElementById("com.dbs.kurly.m2.beta:id/tv_inquiry_subject");
        if (inqury_check.getText().equals("테스트입니다.")) {
            System.out.println("문의글 노출 확인");
        } else {
            System.out.println(inqury_check.getText());
            assert inqury_check.getText().equals("테스트입니다.") : "기대값 : " + inqury_check.getText() + "이슈내용 : 문의글 미노출";
        }
        sleep(2000);


    }

    @AfterTest
    public void aftertest() throws InterruptedException {

        sleep(2000);
        driver.quit();
    }
}
