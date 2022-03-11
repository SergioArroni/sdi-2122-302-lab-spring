package com.example.sdi212202spring.pageobjects;

import com.example.sdi212202spring.util.SeleniumUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;

import java.util.List;

public class PO_PrivateView extends PO_NavView {

    static public void fillFormAddMark(WebDriver driver, int userOrder, String descriptionp, String scorep) {
        //Esperamos 5 segundo a que carge el DOM porque en algunos equipos falla
        SeleniumUtils.waitSeconds(driver, 10);
        //Seleccionamos el alumnos userOrder
        new Select(driver.findElement(By.id("user"))).selectByIndex(userOrder);
        //Rellenemos el campo de descripción
        WebElement description = driver.findElement(By.name("description"));
        description.clear();
        description.sendKeys(descriptionp);
        WebElement score = driver.findElement(By.name("score"));
        score.click();
        score.clear();
        score.sendKeys(scorep);
        By boton = By.className("btn");
        driver.findElement(boton).click();
    }

    static public void login(WebDriver driver, String dnip, String passwordp) {
        //Vamos al formulario de logueo.
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary"); //Rellenamos el formulario
        PO_LoginView.fillLoginForm(driver, dnip, passwordp); //Comprobamos que entramos en la pagina privada de Alumno
    }

    static public void click(WebDriver driver, String text, int pos) {
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", text);
        elements.get(pos).click();
    }

    static public void clickCheck(WebDriver driver, String text, int pos) {
        List<WebElement> elements = PO_View.checkElementBy(driver, "text", text);
        Assertions.assertEquals(text, elements.get(pos).getText());
    }

    static public void logout(WebDriver driver) {
        String loginText = PO_HomeView.getP().getString("signup.message", PO_Properties.getSPANISH());
        PO_PrivateView.clickOption(driver, "logout", "text", loginText);
    }

}