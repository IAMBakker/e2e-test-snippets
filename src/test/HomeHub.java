package test;

import org.junit.Test;
import page.HomePage;
import page.mortgage.calculation.SelectCurrentSituationPage;
import test.base.TestBase;

import static org.junit.Assert.assertEquals;

public class HomeHub extends TestBase {

    @Test
    public void fillApplicantAndPartnerFieldsTest() {

        new HomePage(driver).getStarted()
        .openMortgageCalculationDashboard()
        .startNewCalculation()
        .select().starter()
        .submitCurrentSituation()
        .fillMainApplicantInformation("Man", "Jan", "J",
                "Het", "Testkanon", "15-07-1877")
        .clickWithPartnerBlock()
        .fillPartnerApplicantInformation("Man", "Jan", "J",
        "Het", "Testkanon", "15-07-1877")
        .getTabs().clickSituationTab()
        .select().transferrer()
        .submitCurrentSituation();

        assertEquals("Expect submit button to exist",true,
                new SelectCurrentSituationPage(driver).submitButtonExists());

        assertEquals("Expect submitButton visible is false", false,
                new SelectCurrentSituationPage(driver).submitButtonIsVisible());

//        WebElement checkboxIncome = driver.findElement(By.xpath("(//SPAN[@class='icon js-ui-checkbox'])[1]"));
//        checkboxIncome.click();
//        Select selectEmploymentType = new Select(driver.findElement(By.id("MainApplicant_IncomeFromEmployment_0__EmploymentType")));
//        selectEmploymentType.selectByVisibleText("Fulltime tijdelijk met intentieverklaring");
//        WebElement elementEmployer = driver.findElement(By.id("MainApplicant_IncomeFromEmployment_0__Employer"));
//        elementEmployer.sendKeys("Beste werkgever 2018");
//        WebElement elementStartDateEmployment = driver.findElement(By.id("MainApplicant_IncomeFromEmployment_0__StartDateEmployment"));
//        elementStartDateEmployment.sendKeys("01-01-1995");
//        WebElement elementGrossSalaryPeriod = driver.findElement(By.id("MainApplicant_IncomeFromEmployment_0__GrossSalaryPeriod"));
//        elementGrossSalaryPeriod.sendKeys("5000");
//        Select selectSalaryPaymentFrequency = new Select(driver.findElement(By.id("MainApplicant_IncomeFromEmployment_0__SalaryPaymentFrequency")));
//        selectSalaryPaymentFrequency.selectByVisibleText("Maand");
//        driver.findElement(By.id("MainApplicant_IncomeFromEmployment_0__HolidayAllowanceAmount")).clear();
//        WebElement elementHolidayAllowanceAmount = driver.findElement(By.id("MainApplicant_IncomeFromEmployment_0__HolidayAllowanceAmount"));
//        elementHolidayAllowanceAmount.sendKeys("4487");
//        WebElement elementIrregularityPolicyAmountAnnual = driver.findElement(By.id("MainApplicant_IncomeFromEmployment_0__IrregularityPolicyAmountAnnual"));
//        elementIrregularityPolicyAmountAnnual.sendKeys("2950");
//        WebElement elementExtraMonthAmount = driver.findElement(By.id("MainApplicant_IncomeFromEmployment_0__ExtraMonthAmount"));
//        elementExtraMonthAmount.sendKeys("5159");
//        WebElement elementProvisionAmountAnnual = driver.findElement(By.id("MainApplicant_IncomeFromEmployment_0__ProvisionAmountAnnual"));
//        elementProvisionAmountAnnual.sendKeys("6660");
//        WebElement elementAnnualBonusAmount = driver.findElement(By.id("MainApplicant_IncomeFromEmployment_0__AnnualBonusAmount"));
//        elementAnnualBonusAmount.sendKeys("2710");
//        WebElement elementOvertimeAllowanceAmount = driver.findElement(By.id("MainApplicant_IncomeFromEmployment_0__OvertimeAllowanceAmount"));
//        elementOvertimeAllowanceAmount.sendKeys("925");
//        WebElement checkboxHasPartnerAlimony = driver.findElement(By.xpath("//INPUT[@id='MainApplicant_HasPartnerAlimonyObligations']"));
//        checkboxHasPartnerAlimony.click();
//        WebElement elementPartnerAlimonyAnnualAmount = driver.findElement(By.id("MainApplicant_PartnerAlimonyObligations_0__AnnualAmount"));
//        elementPartnerAlimonyAnnualAmount.sendKeys("12500");
//        WebElement elementPartnerAlimonyEndDate = driver.findElement(By.id("MainApplicant_PartnerAlimonyObligations_0__EndDate"));
//        elementPartnerAlimonyEndDate.sendKeys("31-12-2020");
//        driver.findElement(By.className("CalculateMaxLoanByIncome")).click();
//
//        WebDriverWait wait = new WebDriverWait(driver, 5000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSubmit")));
//        driver.findElement(By.id("btnSubmit")).click();

    }

    @Test
    public void returnTabThenSelectDifferentRadioButtonTest(){
        new HomePage(driver).getStarted()
                .openMortgageCalculationDashboard()
                .startNewCalculation()
                .select().starter()
                .submitCurrentSituation()
                .fillMainApplicantInformation("Man", "Jan", "J",
                        "Het", "Testkanon", "15-07-1877")
                .getTabs().clickSituationTab()
                .select().transferrer()
                .submitCurrentSituation();

        assertEquals("Expect submit button to exist",true,
                new SelectCurrentSituationPage(driver).submitButtonExists());

        assertEquals("Expect submitButton visible is false", false,
                new SelectCurrentSituationPage(driver).submitButtonIsVisible());
    }

}
