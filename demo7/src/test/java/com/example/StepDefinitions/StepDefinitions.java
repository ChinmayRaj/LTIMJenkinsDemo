package com.example.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Duration;

public class StepDefinitions {
    WebDriver driver;

    @Given("User is on HotelAppLogin Page")
public void user_is_on_hotel_app_login_page() {
    driver=new RemoteWebDriver(new URL("http://localhost:4444"),new ChromeOptions());
    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    driver.get("https://www.adactinhotel.com");
}
@When("User Enters Valid UserName")
public void user_enters_valid_user_name() {
   driver.findElement(By.id("username")).sendKeys("Tonymaontana");
}
@When("User Enters Valid Password")
public void user_enters_valid_password() {
    driver.findElement(By.id("password")).sendKeys("jarvis123");
}
@When("User Clicks on Login Button")
public void user_clicks_on_login_button() {
  driver.findElement(By.id("login")).click();
}
@Then("User is Successfully Logged In")
public void user_is_successfully_logged_in() {
    String text=driver.findElement(By.xpath("//input[@id="username_show"]")).getDomAttribute("value");
    driver.quit();
}
}
