package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.base.PageBase;
import page.mortgage.MortgagePage;

public class HomePage extends PageBase {

    private By getStartedButton = By.xpath("//A[@href='/hypotheek'][text()='Aan de slag'][text()='Aan de slag'][1]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public MortgagePage getStarted() {
        driver.findElement(getStartedButton).click();
        return new MortgagePage(driver);
    }
}
