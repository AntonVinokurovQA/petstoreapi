package api.endpoints;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndPoints {
    public static Response createUser(User payload) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.userUrl);

        return response;
    }

    public static Response readUser(String userName) {
        Response response = given()
                .when()
                .get(Routes.userUrl + "/" + userName);

        return response;
    }

    public static Response updateUser(String userName, User payload) {
        Response response = given().log().all()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .put(Routes.userUrl + "/" + userName);

        return response;
    }

    public static Response deleteUser(String userName) {
        Response response = given()
                .when()
                .delete(Routes.userUrl + "/" + userName);

        return response;
    }
}
