package Cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Add_to_Cart {
    WebDriver driver;
    String baseUrl = "http://www.saucedemo.com/";

    @Given("user berada di halaman Products")
    public void add_to_cart(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @When("user klik button Add to Cart")
    public void button_add_to_cart(){
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
    }

    @Then("jumlah produk di Cart bertambah")
    public void jumlah_produk (){
        driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        driver.quit();
    }


}
