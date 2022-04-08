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

public class Review {

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
    public void Review_list() throws InterruptedException {

        //앱실행
        sleep(5000);


        //마이컬리 탭 선택
        MobileElement Mykurly = driver.findElementById("com.dbs.kurly.m2.beta:id/mykurly");
        Mykurly.click();
        sleep(3000);

        //상품후기 버튼 선택
        MobileElement prd_review = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[7]/android.widget.TextView");
        prd_review.click();
        sleep(3000);


        //상품후기 페이지 이동 확인
        MobileElement prdreview_page = driver.findElementByClassName("android.widget.TextView");
        if (prdreview_page.getText().equals("상품 후기")) {
            System.out.println("상품 후기 페이지 이동 확인");
        }
        sleep(2000);

        // 작성완료 후기 탭 선택
        MobileElement Completed_review = driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"작성완료 후기 (1)\"]/android.widget.TextView");
        Completed_review.click();
        sleep(2000);

        //상품명 확인
        MobileElement prd_name = driver.findElementById("com.dbs.kurly.m2.beta:id/textViewProductName");
        if (prd_name.getText().equals("@@낮배송@@ [토마스푸드] 프렌치드 숄더랙(냉장)")) {
            System.out.println("상품명 @@낮배송@@ [토마스푸드] 프렌치드 숄더랙(냉장) 노출 확인");
        }
        sleep(2000);


        //제목 확인
        MobileElement textViewTitle = driver.findElementById("com.dbs.kurly.m2.beta:id/textViewTitle");
        if (textViewTitle.getText().equals("test")) {
            System.out.println("제목 test 노출 확인");
        }
        sleep(2000);


        //본문 확인
        MobileElement textViewContents = driver.findElementById("com.dbs.kurly.m2.beta:id/textViewContents");
        if (textViewContents.getText().equals("testy4yrhthtut")) {
            System.out.println("본문 노출 확인");
        }
        sleep(2000);


        //작성일자 확인
        MobileElement textViewDate = driver.findElementById("com.dbs.kurly.m2.beta:id/textViewDate");
        if (textViewDate.getText().equals("22.04.08 작성")) {
            System.out.println("작성일자 22.04.08 작성 노출 확인");
        }
        sleep(2000);


        //도움이돼요 확인
        MobileElement textViewHelpful = driver.findElementById("com.dbs.kurly.m2.beta:id/textViewHelpful");
        if (textViewHelpful.getText().equals("도움이 돼요 0")) {
            System.out.println("도움이 돼요 0 노출 확인");
        }
        sleep(2000);


    }

    @AfterTest
    public void aftertest() throws InterruptedException {

        sleep(2000);
        driver.quit();
    }

}

