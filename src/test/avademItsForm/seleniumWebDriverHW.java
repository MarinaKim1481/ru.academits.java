package ru.academits.java;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class seleniumWebDriverHW {
   private WebDriver driver;

    @BeforeEach
    public void setUp() {

        String browser = System.getProperty("browser");

        if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser.equals("InternetExplorer")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }

        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
    }

    @Test
    public void inputForm(){
        Assertions.assertEquals("ToolsQA", driver.getTitle());

        WebElement firstName = driver.findElement(By.id("firstName")).sendKeys("First Name");

        WebElement lastName = driver.findElement(By.id("lastName")).sendKeys("Last Name");

        WebElement userName = driver.findElement(By.id("userEmail")).sendKeys("userEmail@mail.ru");

        WebElement Female = driver.findElement(By.cssSelector("label[class='custom-control-label'][for='gender-radio-2']"));
        Female.click();

        WebElement userNumber = driver.findElement(By.id("userNumber")).sendKeys("9232491349");

        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput")).click();
        driver.findElement(By.cssSelector("div.react-datepicker__month-dropdown-container.react-datepicker__month-dropdown-container--select > select > option:nth-child(8)")).click();
        driver.findElement(By.cssSelector("option:nth-child(91)")).click();
        driver.findElement(By.cssSelector("div.react-datepicker__day.react-datepicker__day--018.react-datepicker__day--weekend")).click();
        driver.findElement(By.id("dateOfBirthInput"));

        WebElement subjects = driver.findElement(By.id("subjectsInput")).sendKeys("Maths");
        driver.findElement(By.id("subjectsInput")).sendKeys(Keys.RETURN);

        WebElement Hobbies = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-3']"));
        Hobbies.click();

        file = new File(/src/test/img/3184696.png);
        WebElement selectPictureButton =  driver.findElement(By.id("uploadPicture"));
        selectPictureButton.sendKeys(file.getabsolutePath());

 //       By fileInput = By.cssSelector("input[type='file']");
 //       String filePath = "C:/Users/user/IdeaProjects/OOP/src/test/img/3184696.png";
 //       driver.findElement(fileInput).sendKeys(filePath);

        WebElement currentAdress = driver.findElement(By.id("currentAddress")).sendKeys("currentAddress");
        driver.findElement(By.id("react-select-3-input")).sendKeys("Hary");
        driver.findElement(By.id("react-select-3-input")).sendKeys(Keys.RETURN);
        driver.findElement(By.id("react-select-4-input")).sendKeys("Kar");
        driver.findElement(By.id("react-select-4-input")).sendKeys(Keys.RETURN);

        driver.findElement(By.id("submit")).sendKeys(Keys.RETURN);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#example-modal-sizes-title-lg")));

        SoftAssertions softAssertions = new SoftAssertions();


        softAssertions.assertThat("First Name Last Name", driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(2)")).getText());
        softAssertions.assertThat("userEmail@mail.ru", driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(2)")).getText());
        softAssertions.assertThat("Female",driver.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(2)")).getText());
        softAssertions.assertThat("9232491349", driver.findElement(By.cssSelector("tr:nth-child(4) > td:nth-child(2)")).getText());
        softAssertions.assertThat("18 August,1990", driver.findElement(By.cssSelector("tr:nth-child(5) > td:nth-child(2)")).getText());
        softAssertions.assertThat("Maths", driver.findElement(By.cssSelector("tr:nth-child(6) > td:nth-child(2)")).getText());
        softAssertions.assertThat("Music", driver.findElement(By.cssSelector("tr:nth-child(7) > td:nth-child(2)")).getText());
        softAssertions.assertThat("3184696.png", driver.findElement(By.cssSelector("tr:nth-child(8) > td:nth-child(2)")).getText());
        softAssertions.assertThat("currentAddress", driver.findElement(By.cssSelector("tr:nth-child(9)> td:nth-child(2)")).getText());
        softAssertions.assertThat("Haryana Karnal", driver.findElement(By.cssSelector("tr:nth-child(10)> td:nth-child(2)")).getText());

 }
    @AfterEach
    public void setDown() {
        driver.quit();
    }
}
