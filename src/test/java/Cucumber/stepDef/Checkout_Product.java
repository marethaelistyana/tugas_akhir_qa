package Cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Checkout_Product {
    WebDriver driver;
    String baseUrl = "http://www.saucedemo.com/";

    @Given("user berada di halaman Your Cart")
    public void your_cart(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
    }

    @When("user klik button Checkout")
    public void button_checkout(){
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
    }

    @And("user input informasi Checkout")
    public void informasi_checkout(){
        driver.findElement(By.id("first-name")).sendKeys("example");
        driver.findElement(By.id("last-name")).sendKeys("example");
        driver.findElement(By.id("postal-code")).sendKeys("54813");
    }

    @And("user klik button continue")
    public void button_continue(){
        driver.findElement(By.xpath("//input[@id='continue']")).click();
    }

    @And("user klik button finish")
    public void button_finish(){
        driver.findElement(By.xpath("//button[@id='finish']")).click();
    }

    @Then("menampilkan halaman Checkout Complete")
    public void checkout_complete_page(){
        driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your order!')]"));
        driver.quit();
    }
}
