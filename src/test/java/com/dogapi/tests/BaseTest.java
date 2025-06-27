package com.dogapi.tests;

import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.filters;

public abstract class BaseTest{
    @BeforeAll
    static void globalSetup() {
        // Adiciona o filtro do Allure em todas as requisições
        filters(new AllureRestAssured());
    }
}