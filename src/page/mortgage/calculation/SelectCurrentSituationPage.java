package page.mortgage.calculation;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import page.base.PageBase;

public class SelectCurrentSituationPage extends PageBase {

    private CalculationTabs tabs;
    private By starterRadioButton = By.id("radio_starter_id");
    private By transfererRadioButton = By.id("radio_transferrer_id");

    private By submitButton = By.xpath("//BUTTON[@type='submit']");

    public SelectCurrentSituationPage(WebDriver driver) {
        super(driver);
        tabs = new CalculationTabs(driver);
    }

    public CalculationTabs getTabs() {
        return tabs;
    }

    public SelectSituation select(){
        return new SelectSituation();
    }

    /**
     * Inner class made to represent the radio button options.
     */
    public class SelectSituation {
        public SelectSituation(){
        }

        public SelectCurrentSituationPage starter(){
            driver.findElement(starterRadioButton).click();
            return new SelectCurrentSituationPage(driver);
        }

        public SelectCurrentSituationPage transferrer(){
            driver.findElement(transfererRadioButton).click();
            return new SelectCurrentSituationPage(driver);
        }

        public void entrainedTransferrer(){

        }

        public void refinancer(){

        }
    }

    public FinancialSituationPage submitCurrentSituation(){
        driver.findElement(submitButton).click();
        return new FinancialSituationPage(driver);
    }

    /**
     * Checks if the submit button exists in the DOM tree.
     * This one will not give the expected result, since if the button
     * dissapears from the page it will still exist in the DOM tree,
     * but will have its visibility set to false
     * @return
     */
    public boolean submitButtonExists(){
        boolean exists;
        try{
            driver.findElement(submitButton);
            exists = true;
        } catch (NoSuchElementException e){
            exists = false;
        }
        return exists;
    }

    public boolean submitButtonIsVisible(){
        return driver.findElement(submitButton).isDisplayed();
    }
}
