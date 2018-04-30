package page.mortgage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.base.PageBase;
import page.mortgage.calculation.SelectCurrentSituationPage;

public class MortgageDashboardPage extends PageBase {

    private By newCalculationButton = By.xpath("//A[@href='/aanvraag/ApplicationSandbox/CurrentSituation']");

    public MortgageDashboardPage(WebDriver driver) {
        super(driver);
    }

    public SelectCurrentSituationPage startNewCalculation(){
        driver.findElement(newCalculationButton).click();
        return new SelectCurrentSituationPage(driver);
    }
}
