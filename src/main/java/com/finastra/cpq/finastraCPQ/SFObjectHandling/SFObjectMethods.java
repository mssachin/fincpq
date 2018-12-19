package com.finastra.cpq.finastraCPQ.SFObjectHandling;

import com.finastra.cpq.finastraCPQ.pageobjects.sfdccommons.Context;
import com.finastra.cpq.finastraCPQ.utilities.UtilityMethods;
import com.google.common.base.Function;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Component
@DependsOn("base")
public class SFObjectMethods extends Context {


    public void SFLinkOrButtonClick(By locator) {
        WebElement buttonElement = fluentWaitForAnElement(locator);
        buttonElement.click();
    }

    public void SFClickWebElement(WebElement element) {
        element.click();
    }

    public List<WebElement> SFFindElements(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return elements;
    }

    public void SFEnterTextInTextBox(By locator, String textToEnter) {
        WebElement textBoxElement = fluentWaitForAnElement(locator);
        textBoxElement.sendKeys(textToEnter);
    }

    public void keyboardEnterInElement(By locator) {
        WebElement webElement = fluentWaitForAnElement(locator);
        webElement.sendKeys(Keys.ENTER);
    }

    public String SFExtractTextFromWebElement(By locator) {
        WebElement element = fluentWaitForAnElement(locator);
        return element.getText();
    }

    public void SFClearCurrentContentInAnElement(By locator) {
        WebElement element = fluentWaitForAnElement(locator);
        element.clear();
    }

    public WebElement SFReturnWebElement(By locator) {
        WebElement element = fluentWaitForAnElement(locator);
        return element;
    }

    public WebElement SFReturnWebElementWithinAWebElement(WebElement element, By locator) {
        WebElement elementToReturn = element.findElement(locator);
        return elementToReturn;
    }

    public List<WebElement> SFFindElementsWithinAWebElement(WebElement element, By locator) {
        List<WebElement> webElementList = element.findElements(locator);
        return webElementList;
    }

    public void SFDoubleClickOnAnElement(By locator){
        WebElement element = fluentWaitForAnElement(locator);
        Actions actions = new Actions(driver);
        actions.doubleClick(element).build().perform();
    }

    public void SFSelectElementFromAPickList(By locator, String visibleText){
        WebElement element = fluentWaitForAnElement(locator);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(visibleText);
    }

    public String SFGetAttributeOfAWebElement(By locator, String attribute){
        WebElement element = fluentWaitForAnElement(locator);
        return element.getAttribute(attribute);
    }

    public void SFAcceptAlert() {
        if (isAlertPresent()) {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
    }

    public String extractTextOutOfScriptElement(WebElement element, By locator) {
        WebElement scriptElement = element.findElement(locator);
        String scriptTagText = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;", scriptElement);
        return scriptTagText;
    }


    private boolean isAlertPresent() {
        boolean foundAlert;
        WebDriverWait wait = new WebDriverWait(driver, 30);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
        } catch (TimeoutException eTO) {
            foundAlert = false;
        }
        return foundAlert;
    }


    public boolean SFWaitForElementToBeClickable(By locator) {
        boolean isElementPresent;
        WebDriverWait wait = new WebDriverWait(driver, 30);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            wait.pollingEvery(100, TimeUnit.MILLISECONDS)
                    .ignoring(NoSuchElementException.class);
            isElementPresent = true;
        } catch (TimeoutException | NoSuchElementException ex) {
            isElementPresent = false;
            ex.printStackTrace();
        }
        return isElementPresent;
    }

    public boolean SFIsElementPresent(By locator) {

        boolean isElementPresent;
        try {
            WebElement element = driver.findElement(locator);
            isElementPresent = true;
        } catch (NoSuchElementException nse) {
            isElementPresent = false;
        }
        return isElementPresent;
    }

    public boolean SFIsElementPresentInsideWebElement(WebElement element, By locator) {

        boolean isElementPresent;
        try {
            WebElement elementInside = element.findElement(locator);
            isElementPresent = true;
        } catch (NoSuchElementException nse) {
            isElementPresent = false;
        }
        return isElementPresent;
    }




    public boolean SFWaitForElementToBeInVisible(By locator) {
        boolean isElementInvisible;
        WebDriverWait wait = new WebDriverWait(driver, 2);
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            wait.pollingEvery(100, TimeUnit.MILLISECONDS)
            ;
            isElementInvisible = true;
        } catch (TimeoutException | NoSuchElementException ex) {
            isElementInvisible = false;
            ex.printStackTrace();
        }
        return isElementInvisible;
    }

    public String captureFullPageScreenshot(String filename) throws IOException {
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        File imageFile = new File(UtilityMethods.getCurrentReportingDirectory().getAbsolutePath() + "//" + filename + " " + UtilityMethods.getCurrentTimeStampAsString() + ".png");
        ImageIO.write(screenshot.getImage(), "PNG", imageFile);
        byte[] fileContent = FileUtils.readFileToByteArray(imageFile);
        String imageAsString = Base64.getEncoder().encodeToString(fileContent);
        return imageAsString;
    }

    public String captureWebElementScreenshot(By locator, String filename) throws IOException {
        WebElement element = fluentWaitForAnElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        Screenshot screenshot = new AShot().takeScreenshot(driver);
        File imageFile = new File(UtilityMethods.getCurrentReportingDirectory().getAbsolutePath() + "//" + filename + " " + UtilityMethods.getCurrentTimeStampAsString() + ".png");
        ImageIO.write(screenshot.getImage(), "PNG", imageFile);
        byte[] fileContent = FileUtils.readFileToByteArray(imageFile);
        String imageAsString = Base64.getEncoder().encodeToString(fileContent);
        return imageAsString;


    }


    private WebElement fluentWaitForAnElement(final By locator) {

        Wait wait = new FluentWait(driver)
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(WebDriverException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(ElementNotInteractableException.class);

        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
            WebElement elementToReturn = null;
            WebElement element = null;

            public WebElement apply(WebDriver driver) {
                try {
                    element = driver.findElement(locator);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (element.isDisplayed() && element != null) {
                    elementToReturn = element;
                    return elementToReturn;
                }
                return elementToReturn;
            }
        };

        wait.until(function);

        return function.apply(driver);
    }


}
