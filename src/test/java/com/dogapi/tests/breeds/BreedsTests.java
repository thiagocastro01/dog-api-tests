package com.dogapi.tests.breeds;

import com.dogapi.core.clients.DogApiClient;
import com.dogapi.core.factories.ResponseSpecFactory;
import com.dogapi.tests.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

@Epic("Dog API Tests")
@Feature("Breed validations")
@Owner("Thiago.castro")
public class BreedsTests extends BaseTest {

    /*---------------------------------------------------
     * Validações para o endpoint: /breeds/list/all
     *--------------------------------------------------*/

    @Severity(SeverityLevel.CRITICAL)
    @Test
    @DisplayName("ct 01: Should return list of all breeds")
    void shouldValidateBreedList() {
        DogApiClient.listBreeds()
                .then()
                .spec(ResponseSpecFactory.success())
                .body("message.size()", greaterThan(0))
                .body("status", equalTo("success"));
    }

    @Severity(SeverityLevel.BLOCKER)
    @Test
    @DisplayName("ct 02: Contract validation for /breed/list/all")
    void shouldValidateBreedListContract() {
        DogApiClient.listBreeds()
                .then()
                .spec(ResponseSpecFactory.success())
                .body(matchesJsonSchemaInClasspath("schemas/list-all-breeds_schema.json"));
    }

    /*---------------------------------------------------
     * Validações para o endpoint: /breed/{breed}/images
     *--------------------------------------------------*/

    // Nota para o avaliador: optei por buscar a primeira breed retornada pelo endpoint de listagem
    // para garantir que o teste funcione de forma independente, sem depender de dados fixos.
    // Em um ambiente interno, a melhor prática seria utilizar dados controlados via seed/fixtures,
    // garantindo previsibilidade e maior estabilidade nos testes.
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @DisplayName("ct 03: Should return image list for a valid breed")
    void shouldReturnImageListForValidBreed() {
        Response resp = DogApiClient.listBreeds().then().extract().response();
        Map<String, List<String>> breeds = resp.jsonPath().getMap("message");
        String breed = breeds.keySet().stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Has no breeds available!"));


        DogApiClient.getBreedImages(breed)
                .then()
                .spec(ResponseSpecFactory.success())
                .body("status", equalTo("success"))
                .body("message.size()", greaterThan(0))
                .body("message[0]", matchesPattern("https?://.*\\.(jpg|jpeg)"));
    }
    @Severity(SeverityLevel.NORMAL)
    @Test
    @DisplayName("ct 04: Should return 404 for an invalid breed")
    void shouldReturn404ForInvalidBreed() {
        DogApiClient.getBreedImages("invalid")
                .then()
                .statusCode(404)
                .body("status", equalTo("error"))
                .body("message", containsString("Breed not found"));
    }

    /*---------------------------------------------------
     * Validações para o endpoint: /breeds/image/random
     *--------------------------------------------------*/
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @DisplayName("ct 05: Should return a random image")
    void shouldReturnValidRandomImage() {
        DogApiClient.getRandomImage()
                .then()
                .spec(ResponseSpecFactory.success())
                .body("status", equalTo("success"))
                .body("message", matchesPattern("https?://.*\\.(jpg|jpeg)"));
    }
}
