package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;
import utils.ReusableMethods;

import java.awt.geom.RectangularShape;
import java.io.File;
import java.io.IOException;

public class AllCurrencyTest {

    // all currency uygulamasinin yuklendigi dogulanir
    // uygulamanin acildigi dogrulanir
    // cevirmek istedigimiz para birimi zloty olarak secilir
    // cevirelecek olan para birimi Tl olarak secilir
    // cevrilen tutar screenShot olarak kaydedilir
    // Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
    // bu islem dolar tl, sweden kron-tl, Japon yeni- tl olarak tekrarlanir ve kullaniciya sms olarak bildirilir
    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();

    @Test
    public void currencyTest() throws IOException {
        // all currency uygulamasinin yuklendigi dogulanir
        Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"),"uygulama yukleme basarisiz");
        // uygulamanin acildigi dogrulanir
        AndroidElement anaSayfaApp=driver.findElementByXPath("//*[@text='CURRENCY CONVERTER']");
        String uygulamaDogrulamaActual=anaSayfaApp.getText();
        String expected="CURRENCY CONVERTER";
        Assert.assertEquals(uygulamaDogrulamaActual,expected,"uyguluma basarili bir sekilde baslatilamadi");
        driver.findElementById("com.smartwho.SmartAllCurrencyConverter:id/linearLayoutPopupHistory").click();
        // cevirmek istedigimiz para birimi zloty olarak secilir
        //  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"PLN\"))");
        ReusableMethods.scrollWithUiScrollable("PLN");

        // cevirelecek olan para birimi Tl olarak secilir
        driver.findElement(By.id("com.smartwho.SmartAllCurrencyConverter:id/SpinnerCurrencyB")).click();
        ReusableMethods.scrollWithUiScrollable("TRY");

        // cevrilen tutar screenShot olarak kaydedilir

        driver.findElementById("com.smartwho.SmartAllCurrencyConverter:id/b1").click();
        driver.findElementById("com.smartwho.SmartAllCurrencyConverter:id/b5").click();
        driver.findElementById("com.smartwho.SmartAllCurrencyConverter:id/b0").click();
        driver.findElementById("com.smartwho.SmartAllCurrencyConverter:id/b0").click();

        File ekranFotografi = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ekranFotografi,new File("paraSonucu.jpg"));

        ReusableMethods.getScreenshot("T108");






    }
}