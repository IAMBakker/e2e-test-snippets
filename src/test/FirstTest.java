package test;

import dataobjects.TestItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import postgres.PostgreSQL;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;

public class FirstTest {

    protected WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/home/ico/Programs/WebDrivers/chromedriver");

        driver = new ChromeDriver();
        driver.get("http://www.reddit.com/r/CryptoCurrency");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.close();
    }


    @Test
    public void collectTextFromElements(){
        List<WebElement> elements = driver.findElements(By.partialLinkText("coin"));

        List<String> coinText = new ArrayList<>();
        elements.stream().forEach(e -> coinText.add(e.getText()));


        System.out.println("Amount of elements containing text (coin) on page: " +
                "" + elements.size());
        coinText.forEach(System.out::println);

    }

    @Test
    public void storeAllAdoptionNewsItems() throws SQLException {
        List<WebElement> elements;
        List<TestItem> items = new ArrayList<>();
        JavascriptExecutor jsDriver = (JavascriptExecutor) driver;

        String searchTerm = "ADOPTION";

        List<WebElement> nextBtns;
        do{
            nextBtns = driver.findElements(By.className("next-button"));
            jsDriver.executeScript("arguments[0].scrollIntoView(true)", nextBtns.get(0));

            elements = driver.findElements(By.className("linkflair-"+ searchTerm));

            elements.forEach(e-> {
                TestItem item = new TestItem(
                        ((int) (random() * 6000000) + 1000000),
                        searchTerm,
                        this.getClass().toString()
                );
                item.setText(e.findElement(By.xpath("./div/div/p/a")).getText());
                item.setUrl(e.getAttribute("data-url"));
                items.add(item);
            });

            nextBtns.get(0).click();
            nextBtns = driver.findElements(By.className("next-button"));

        } while (nextBtns.size() != 0);

        items.forEach(e -> System.out.println(e.toString()));

//        create database connection
        PostgreSQL dbConnection = new PostgreSQL();
        PreparedStatement statement = dbConnection.getConnection()
                .prepareStatement("INSERT INTO TESTITEM (ID,SEARCHTERM,TESTCLASS,TEXT,URL,DATE_CREATED)" +
                        "VALUES (?,?,?,?,?,?)");
        dbConnection.getConnection().setAutoCommit(false);

        for(TestItem i : items){
            statement.setObject(1, i.getKey());
            statement.setObject(2, wrapString(i.getSearchTerm()));
            statement.setObject(3, wrapString(i.getTestClass()));
            statement.setObject(4, wrapString(i.getText()));
            statement.setObject(5, wrapString(i.getUrl()));
            statement.setObject(6, java.sql.Date.valueOf(LocalDate.now()));
            statement.executeUpdate();
        }
        statement.close();

        dbConnection.getConnection().commit();
        dbConnection.getConnection().close();
    }

    private String wrapString(String s){
        return "'" +  s.replaceAll("\\'", "") + "'";
    }

    @Test
    public void movePageTest(){
//        WebElement body = driver.findElement(By.cssSelector("body"));
//        for(int i = 0; i < 5; i++) {
//            body.sendKeys(Keys.PAGE_DOWN);
//        }
    }

    @Test
    public void testWithAction(){
//        Actions actions = new Actions(driver);
//
//        for(WebElement element : elements){
//            Action ctrlClick = actions.keyDown(Keys.CONTROL)
//                    .doubleClick(element)
//                    .keyUp(Keys.CONTROL)
//                    .build();
//            ctrlClick.perform();
//        }

    }

    @Test
    public void scrollDown(){

        WebElement body = driver.findElement(By.cssSelector("body"));
        for(int i = 0; i < 5; i++){
        body.sendKeys(Keys.PAGE_DOWN);
        }
    }
}
