package com.example.sdi212202spring;

import com.example.sdi212202spring.pageobjects.PO_Properties;
import com.example.sdi212202spring.util.SeleniumUtils;
import org.junit.jupiter.api.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.sdi212202spring.pageobjects.PO_View.getTimeout;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Sdi212202SpringApplicationTests {

    static String PathFirefox = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
    //static String Geckodriver = "C:\\Path\\geckodriver-v0.30.0-win64.exe";
    static String Geckodriver = "C:\\Dev\\tools\\selenium\\geckodriver-v0.30.0-win64.exe";

    //static String PathFirefox = "/Applications/Firefox.app/Contents/MacOS/firefox-bin"; //static String Geckodriver = "/Users/USUARIO/selenium/geckodriver-v0.30.0-macos";
//Común a Windows y a MACOSX
    static WebDriver driver = getDriver(PathFirefox, Geckodriver);
    static String URL = "http://localhost:8090";

    public static WebDriver getDriver(String PathFirefox, String Geckodriver) {
        System.setProperty("webdriver.firefox.bin", PathFirefox);
        System.setProperty("webdriver.gecko.driver", Geckodriver);
        driver = new FirefoxDriver();
        return driver;
    }

    @BeforeEach
    public void setUp() {
        driver.navigate().to(URL);
    }

    //Después de cada prueba se borran las cookies del navegador
    @AfterEach
    public void tearDown() {
        driver.manage().deleteAllCookies();
    }
//Antes de la primera prueba

    @BeforeAll
    static public void begin() {
    } //Al finalizar la última prueba @AfterAll static public void end() { //Cerramos el navegador al finalizar las pruebas driver.quit();


    @Test
    @Order(1)
    void Test1() {

        //Cambiamos el idioma a Inglés
        //PO_HomeView.changeLanguaje (driver, "btnEnglish"));
        //Esperamos porque aparezca que aparezca el texto de bienvenida en inglés
        //SeleniumUtils. waitLoadElementsBy(driver, "text", p.getString("welcome.message", PO_Properties.ENGLISH), getTimeout());
    }

    @Test
    @Order(2)
    void Test2() {
    }

    @Test
    @Order(3)
    void Test3() {
    }

    @Test
    @Order(4)
    void Test4() {
    }

    @Test
    @Order(5)
    void Test5() {
    }

    @Test
    @Order(6)
    void Test6() {
    }

    @Test
    @Order(7)
    void Test7() {
    }

    @Test
    @Order(8)
    void Test8() {
    }

    @Test
    @Order(9)
    void Test9() {
    }


}
