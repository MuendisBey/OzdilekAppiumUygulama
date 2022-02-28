import com.google.common.collect.ImmutableMap;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
import java.util.List;
import java.util.Random;


public class BasePage extends BaseTest{



    Logger logger = LogManager.getLogger(BasePage.class);

    @Step("<time> saniye kadar bekle")
    public void waitForseconds(int time) throws InterruptedException {
        Thread.sleep(time * 1000);

    }

    @Step("sepete ürün eklendi")
        public void sepeteUrunEklendi(){
            System.out.println("sepete ürün eklendi");
        }


    @Step("id <id> li elemente tıkla")
    public void clickByid(String id) {
        appiumDriver.findElement(By.id(id)).click();

    }
    @Step("xpath <xpath> li elemente tıkla")
    public void clickByXpath(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();

    }

    @Step("id <id> li elementi bul ve <text> değerini yaz")
    public void sendkeysByid(String id, String text) {
        appiumDriver.findElement(By.id(id)).sendKeys(text);
    }

    @Step("Android klavyeyi kapat")
    public void closeKeyboardonAndroid() {
        appiumDriver.hideKeyboard();


    }

    @Step("Sayfayı sola kaydır")
    public void swipeLeft() {
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;
        // init screen variables
        Dimension dims = appiumDriver.manage().window().getSize();
        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
        new TouchAction(appiumDriver)
                .press(pointOptionStart)
                // a bit more reliable when we add small wait
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointOptionEnd)
                .release().perform();


    }
    @Step("Sayfayı aşağı kaydır")
    public void swipeUp() {
        final int ANIMATION_TIME = 2000; // ms

        final int PRESS_TIME = 2000; // ms

        int edgeBorder = 2; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;
        // init screen variables
        Dimension dims = appiumDriver.manage().window().getSize();
        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        pointOptionEnd = PointOption.point(dims.width / 2,edgeBorder);
        new TouchAction(appiumDriver)
                .press(pointOptionStart)
                // a bit more reliable when we add small wait
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointOptionEnd)
                .release().perform();

    }

    @Step("id <id> li elementi bul ve <text> alanını kontrol et")
    public void textIdAreacontrol(String id, String text) {
        Assert.assertTrue("Element text değerini içermiyor", appiumDriver.findElement(By.id(id)).getText().contains(text));
    }
    @Step("xpath <xpath> li elementi bul ve <text> alanını kontrol et")
    public void textXpathAreacontrol(String xpath, String text) {
        Assert.assertTrue("Element text değerini içermiyor", appiumDriver.findElement(By.xpath(xpath)).getText().contains(text));
    }

    @Step("Android klavyeden arama tuşuna bas")
    public void clickSearchbuttonOnadnroidKeyboard() {
        ((JavascriptExecutor) appiumDriver).executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
    }

    @Step("Elementler <id> arasından rasgele bir tanesini seç ve tıkla")
    public void clickRandomelement(String id) {
        Random random = new Random();
        List<MobileElement> products = appiumDriver.findElements(By.id(id));
        int index = random.nextInt(products.size());
        products.get(index).click();
    }

    @Step("Elementleri <xpath> arasından rasgele bir tanesini seç ve tıkla")
    public void clickRandomXpathelement(String xpath) {
        Random random = new Random();
        List<MobileElement> products = appiumDriver.findElements(By.xpath(xpath));
        int index = random.nextInt(products.size());
        products.get(index).click();

    }




}
