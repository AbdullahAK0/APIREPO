import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ArabamAppTest {


    AndroidDriver<AndroidElement> driver;
    //AppiumDriver<MobileElement> appiumDriver;
    final String cihazAdi = "PIXEL";
    final String platformIsmi = "Android";
    final String version = "10.0";
    final String automation = "UiAutomator2";

    @BeforeTest
    public void setup() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, cihazAdi);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformIsmi);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automation);


        // hangi uygulamada calisacaksak
        capabilities.setCapability("appPackage","com.dogan.arabam");
        // hangi sayfayi gormek ya da baslatmak istedigimiz yer. genelde home page ya da main activity olarak bulunur
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");

        // eger false kullanirsak uygulama calistiktan sonra yapilacak adimlari gerceklestirir uygulamayi islem bitince SIFIRLAR
        // eger true kullanirsak uygulama calistiktan sonra yapilacak adimlari gerceklestirir uygulamayi islem bitince SIFIRLAMAZ
        capabilities.setCapability(MobileCapabilityType.NO_RESET,false);

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void arabamTest(){
        driver.getDeviceTime();

    }
}
