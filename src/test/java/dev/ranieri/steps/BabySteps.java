package dev.ranieri.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BabySteps {

    @Given("I am somewhere")
    public void i_am_somewhere() throws InterruptedException {
        System.out.println("I am somewhere");
        Thread.sleep(5000); } // It is not recommended , it won't send an Error and just simply waits for 5 sec.

    @When("I do something")
    public void i_do_something() {
        System.out.println("I did something");
    }

    @Then("Something should appear")
    public void something_should_appear() {
        System.out.println("Something done did happened");
    }
}
