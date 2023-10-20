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

public class Filter {
    WebDriver driver;
    String baseUrl = "http://www.saucedemo.com/";

    @Given("user berada di halaman Product")
    public void products_page(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
}
    @When("user klik dropdown filter")
    public void dropdown_filter(){
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
    }

    @And("user pilih filter")
    public void choose_filter (){
        driver.findElement(By.xpath("//option[@value='za']")).click();
    }

    @Then("menampilkan produk yang difilter")
    public void show_product(){
        driver.findElement(By.xpath("//option[@value='za']")).isSelected();
        driver.quit();
    }

}
