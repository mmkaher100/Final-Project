import Utils.BaseMethods;
import Utils.ExcelUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class FinalProjectTest extends BaseMethods {

    WebDriver driver;
    static final String EXCEL_FILE_PATH = System.getProperty("user.dir") + "/ResourceData/TestData/ExcelBook.xlsx";


    @BeforeClass
    void setUp() {
        driver = getWebDriver();
        driver.manage().window().maximize();

    }

    @DataProvider(name = "loadFromData")
    public static Object[][] dataLoad() throws Exception {
        return ExcelUtils.getTableArray(EXCEL_FILE_PATH);
    }

    @Test(priority = 1,dataProvider = "loadFromData")
    void createAccount( String Title, String FirstName, String LastName, String Address, String City, String ZipCode, String Phone) throws InterruptedException {

        driver.get(pageUrl);


        //page 2
        driver.findElement(signInTab).click();

        Faker faker = new Faker(new Locale("en-US"));
        driver.findElement(emailAddressBox).sendKeys(faker.internet().emailAddress());
        driver.findElement(createAccTab).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(zipBox));

        driver.findElement(firstNameBox).sendKeys(FirstName);
        driver.findElement(lastNameBox).sendKeys(LastName);
        driver.findElement(passwordBox).sendKeys(faker.internet().password());

        List<WebElement> days = driver.findElements(dobDay);
        Random randomDay = new Random();
        int d = randomDay.nextInt(1 + days.size() - 1);
        days.get(d).click();

        List<WebElement> months = driver.findElements(dobMonth);
        Random randomMonth = new Random();
        int m = randomMonth.nextInt(1 + months.size() - 1);
        months.get(m).click();

        List<WebElement> years = driver.findElements(dobYear);
        Random randomYear = new Random();
        int y = randomYear.nextInt(1 + years.size() - 1);
        years.get(y).click();


        driver.findElement(addressBox).sendKeys(Address);
        driver.findElement(cityBox).sendKeys(City);

        List<WebElement> states = driver.findElements(stateBox);
        Random randomState = new Random();
        int r = randomState.nextInt(1 + states.size() - 1);
        states.get(r).click();


        driver.findElement(zipBox).sendKeys(ZipCode);
        driver.findElement(homePhone).sendKeys(Phone);
        driver.findElement(registerBtn).click();

        WebElement account = driver.findElement(myAccount);
        Assert.assertTrue(account.isDisplayed());

        driver.findElement(signOut).click();

    }

    @Test(priority = 2)
    void logIn() throws IOException, InterruptedException {

        driver.get(pageUrl);
        driver.findElement(signInTab).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(email));

        driver.findElement(email).sendKeys(getUsername());

        driver.findElement(password).sendKeys(getPassword());

        driver.findElement(signIn).click();

        WebElement account = driver.findElement(myAccount);
        Assert.assertTrue(account.isDisplayed());

        driver.findElement(signOut).click();

    }

    @Test(priority = 3)
    void lastItemPurchase() throws IOException, InterruptedException {

        driver.get(pageUrl);
        driver.findElement(signInTab).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(email));

        driver.findElement(email).sendKeys(getUsername());
        driver.findElement(password).sendKeys(getPassword());
        driver.findElement(signIn).click();

        WebElement account = driver.findElement(myAccount);
        Assert.assertTrue(account.isDisplayed());

        driver.findElement(womanTab).click();
        driver.findElement(smallSize).click();

        List<WebElement> lastProduct = driver.findElements(products);
        lastProduct.get(lastProduct.size() - 1).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCart));
        driver.findElement(addToCart).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(layerCart));
        Assert.assertTrue(driver.findElement(quantity).getText().contains("1"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(xButton)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(logOut)).click();

    }

    @Test(priority = 4)
    void everyItemPurchase() throws IOException {

        driver.get(pageUrl);
        driver.findElement(signInTab).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(email));

        driver.findElement(email).sendKeys(getUsername());
        driver.findElement(password).sendKeys(getPassword());
        driver.findElement(signIn).click();

        WebElement account = driver.findElement(myAccount);
        Assert.assertTrue(account.isDisplayed());

        driver.findElement(womanTab).click();
        driver.findElement(smallSize).click();
        driver.findElement(tops).click();
        wait.until(ExpectedConditions.urlContains("/categories-tops/size-s"));

        List<WebElement> smallTops = driver.findElements(products);
        System.out.println(smallTops.size());
        for (int i = 0; i <= smallTops.size() - 1; i++) {
            javaScriptExecutorClick(smallTops.get(i));
            wait.until(ExpectedConditions.visibilityOfElementLocated(addToCart));
            driver.findElement(addToCart).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(layerCart));
            driver.navigate().back();
        }

        driver.findElement(viewCart).click();
        driver.findElement(proceedCheckout).click();
        wait.until(ExpectedConditions.urlContains("order&step=1"));
        scrollToElementAndClick(proceedCheckout2);
        wait.until(ExpectedConditions.urlContains("controller=order"));
        driver.findElement(termsOfService).click();
        scrollToElementAndClick(proceedCheckout3);
        wait.until(ExpectedConditions.urlContains("controller=order&multi-shipping="));
        wait.until(ExpectedConditions.visibilityOfElementLocated(total));
        Assert.assertTrue(driver.findElement(total).getText().contains("$45.51"));

    }
    @AfterClass
    void wrapUp(){
        quitWebdriver();
    }
}

