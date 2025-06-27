package com.dogapi.core.clients;

import com.dogapi.core.factories.RequestSpecFactory;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class DogApiClient {
    private static final RequestSpecification REQ = RequestSpecFactory.create();

    public static Response listBreeds() {
        return given().spec(REQ).get("/breeds/list/all");
    }

    public static Response getBreedImages(String breed) {
        return given().spec(REQ).get("/breed/{b}/images", breed);
    }

    public static Response getRandomImage() {
        return given().spec(REQ).get("/breeds/image/random");
    }
}