package page.mortgage.calculation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import page.base.PageBase;

public class FinancialSituationPage extends PageBase {

    private CalculationTabs tabs;

    private String mainApplicantPrefix = "MainApplicant_";
    private String partnerApplicantPrefix = "PartnerApplicant_";

    private By hasPartnerBlock = By.cssSelector("div.personal-status-choice > div.partner");

    public FinancialSituationPage(WebDriver driver) {
        super(driver);
        tabs = new CalculationTabs(driver);
    }

    public CalculationTabs getTabs() {
        return tabs;
    }

    public FinancialSituationPage clickWithPartnerBlock(){
        driver.findElement(hasPartnerBlock).click();
        return this;
    }

    /**
     * Fills personal information for the main applicant
     * @param gender
     * @param firstName
     * @param initials
     * @param insertion
     * @param lastName
     * @param dateOfBirth
     */
    public FinancialSituationPage fillMainApplicantInformation(String gender, String firstName, String initials,
                                                               String insertion, String lastName, String dateOfBirth){
        selectGender(mainApplicantPrefix, gender);
        fillFirstName(mainApplicantPrefix, firstName);
        fillInitials(mainApplicantPrefix, initials);
        fillInsertion(mainApplicantPrefix, insertion);
        fillLastName(mainApplicantPrefix, lastName);
        fillDateOfBirth(mainApplicantPrefix, dateOfBirth);

        return this;
    }

    /**
     * Fills personal information for the partner applicant
     * @param gender
     * @param firstName
     * @param initials
     * @param insertion
     * @param lastName
     * @param dateOfBirth
     */
    public FinancialSituationPage fillPartnerApplicantInformation(String gender, String firstName, String initials,
                                                                  String insertion, String lastName, String dateOfBirth){
        selectGender(partnerApplicantPrefix, gender);
        fillFirstName(partnerApplicantPrefix, firstName);
        fillInitials(partnerApplicantPrefix, initials);
        fillInsertion(partnerApplicantPrefix, insertion);
        fillLastName(partnerApplicantPrefix, lastName);
        fillDateOfBirth(partnerApplicantPrefix, dateOfBirth);

        return this;
    }

    private void selectGender(String prefix, String gender){
        Select selectGender = new Select(driver.findElement(By.id(prefix + "Gender")));
        selectGender.selectByVisibleText(gender);
    }

    private void fillFirstName(String prefix, String firstName){
        WebElement elementFirstName = driver.findElement(By.id(prefix + "FirstName"));
        elementFirstName.sendKeys(firstName);
    }

    private void fillInitials(String prefix, String initials){
        WebElement elementInitials = driver.findElement(By.id(prefix + "Initials"));
        elementInitials.sendKeys(initials);
    }

    private void fillInsertion(String prefix, String insertion){
        WebElement elementInsertion = driver.findElement(By.id(prefix + "Insertion"));
        elementInsertion.sendKeys(insertion);
    }

    private void fillLastName(String prefix, String lastName){
        WebElement elementLastName = driver.findElement(By.id(prefix + "LastName"));
        elementLastName.sendKeys(lastName);
    }

    private void fillDateOfBirth(String prefix, String dateOfBirth){
        WebElement elementDateOfBirth = driver.findElement(By.id(prefix + "DateOfBirth"));
        elementDateOfBirth.sendKeys(dateOfBirth);
    }
}
