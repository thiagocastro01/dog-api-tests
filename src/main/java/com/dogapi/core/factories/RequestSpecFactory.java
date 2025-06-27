package com.dogapi.core.factories;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.filter.log.LogDetail;

public class RequestSpecFactory {
    public static RequestSpecification create() {
        return new RequestSpecBuilder()
                .setBaseUri("https://dog.ceo/api")
                .setAccept(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }
}
