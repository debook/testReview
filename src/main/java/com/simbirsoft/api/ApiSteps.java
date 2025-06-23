package com.simbirsoft.api;


import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ApiSteps {

    @Step("Авторизоватся")
    public Response authRequest() {
        String data = "{\"login\": \"admin\", \"password\": \"1234\"}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(data)
                .when()
                .post("http://api/auth")
                .then()
                .extract()
                .response();

        return response;
    }

    @Step("Создать новую заявку")
    public String create(String token, String name) throws IOException {
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(name)
                .when()
                .post("http://api/create")
                .then()
                .extract()
                .response();

        return response.jsonPath().getString("id");
    }
}
