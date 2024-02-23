package api.tests;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UserTests {
    Faker faker = new Faker();
    User userPayload = new User();

    @BeforeClass
    public void setup() {
        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password());
        userPayload.setPhone(faker.phoneNumber().cellPhone());
    }

    @Test(priority = 1)
    public void testCreateUser() {
        Response response = UserEndPoints.createUser(userPayload);

        assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void testGetUserByName() {
        Response response = UserEndPoints.readUser(userPayload.getUsername());

        assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void testUpdateUserByName() {
        Response response = UserEndPoints.updateUser(userPayload.getUsername(), userPayload);

        assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 4)
    public void testDeleteUserByName() {
        Response response = UserEndPoints.deleteUser(userPayload.getUsername());

        assertEquals(response.getStatusCode(), 200);
    }
}
