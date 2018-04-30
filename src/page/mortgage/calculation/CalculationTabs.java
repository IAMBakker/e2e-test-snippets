package page.mortgage.calculation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.base.PageBase;

public class CalculationTabs extends PageBase {

    private By currentSituationTab = By.cssSelector("li > a[href='/aanvraag/ApplicationSandbox/CurrentSituation']");
    private By financialSituationTab = By.cssSelector("li > a[href='/aanvraag/ApplicationSandbox/FinancialState']");

    public CalculationTabs(WebDriver driver) {
        super(driver);
    }

    public SelectCurrentSituationPage clickSituationTab(){
        driver.findElement(currentSituationTab).click();
        return new SelectCurrentSituationPage(driver);
    }

    public FinancialSituationPage clickFinancialSituationTab(){
        driver.findElement(financialSituationTab).click();
        return new FinancialSituationPage(driver);
    }
}
