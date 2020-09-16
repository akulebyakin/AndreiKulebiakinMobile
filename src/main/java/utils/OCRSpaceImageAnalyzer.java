package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.io.File;

import static utils.GetTestProperties.OCR_SPACE_API_KEY;
import static utils.GetTestProperties.OCR_SPACE_ENDPOINT;

/*
    Documentation: https://ocr.space/OCRAPI
 */
public class OCRSpaceImageAnalyzer {

    private static final String PARSED_TEXT_JSON_PATH = "ParsedResults.ParsedText";

    public static String getTextFromScreenshot(File imageFile) {
        // Fiddler proxy
        // RestAssured.proxy("http://localhost:8888");

        RequestSpecification sendFileSpecification = new RequestSpecBuilder()
                .setBaseUri(OCR_SPACE_ENDPOINT)
                .addHeader("Accept", "application/json")
                .addHeader("apikey", OCR_SPACE_API_KEY)
                .build();

        String parsedText = RestAssured
                .given(sendFileSpecification)
//                .log().all()
                .multiPart("file", imageFile, "application/octet-stream")
                .post()
                .then()
                .extract().response()
                .prettyPeek()
                .jsonPath()
                .getString(PARSED_TEXT_JSON_PATH);

        return parsedText;
    }

}
