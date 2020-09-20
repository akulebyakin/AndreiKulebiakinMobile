package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;

import static utils.GetTestProperties.EMC_API_KEY;

public class EPAMMobileCloudApi {

    private static final String INSTALL_APP_ENDPOINT =
            "https://mobilecloud.epam.com/automation/api/storage/install/";

    public static void installApp(String appPathName, String deviceUdid) {
        File app = new File(appPathName);

        RequestSpecification sendFileSpecification = new RequestSpecBuilder()
                .setBaseUri(INSTALL_APP_ENDPOINT + deviceUdid)
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer " + EMC_API_KEY)
                .build();

        Response response = RestAssured
                .given(sendFileSpecification)
//                .queryParam("noResign", true)
                .multiPart("file", app, "application/octet-stream")
                .post()
                .then()
                .extract().response()
                .prettyPeek();

        int statusCode = response.getStatusCode();
        if (statusCode != 201) {
            throw new RuntimeException("Code " + statusCode + ": "
                    + response.jsonPath().get("message"));
        }
    }

}
