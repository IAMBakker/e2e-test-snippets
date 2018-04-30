package page.mortgage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.base.PageBase;

public class MortgagePage extends PageBase {

    private By calculateMortgageButton = By.xpath("//A[@href='https://mijnhypotheek.lloydsbank.nl/aanvraag'][text()='Maak een berekening']");

    public MortgagePage(WebDriver driver) {
        super(driver);
    }

    public MortgageDashboardPage openMortgageCalculationDashboard(){
        driver.findElement(calculateMortgageButton).click();
        switchToNewTab();
        return new MortgageDashboardPage(driver);
    }

    /**
     * Switches the drivers focus to the new tab that was opened.
     */
    private void switchToNewTab() {
        String currentHandle = driver.getWindowHandle();
        for(String handle : driver.getWindowHandles()){
            if (!handle .equals(currentHandle))
            {
                driver.switchTo().window(handle);
            }
        }
    }
}
