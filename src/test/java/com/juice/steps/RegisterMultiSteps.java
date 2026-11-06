package com.juice.steps;

import com.juice.utils.Base;
import io.cucumber.java.en.Given;
import java.util.List;
import java.util.Map;


public class RegisterMultiSteps extends Base {

    @Given("The following registration details are provided")
    public void the_following_registration_details_are_provided(io.cucumber.datatable.DataTable dataTable) {

        List<Map<String, String>> registerForm = dataTable.asMaps();

        for (Map<String, String> row : registerForm) {
            String email = row.get("email");
            String password = row.get("password");
            String repeatPassword = row.get("repeatPassword");
            String securityQuestion = row.get("securityQuestion");
            String answer = row.get("answer");

            registerPage.fillOutFormDataTable(email, password, repeatPassword, securityQuestion, answer);
            registerPage.clickRegisterButton();

        }
    }

}
