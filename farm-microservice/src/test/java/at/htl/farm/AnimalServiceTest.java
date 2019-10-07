package at.htl.farm;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AnimalServiceTest {

    @Test
    public void testAnimalCount() {
        given()
          .when().get("/api/animal/count")
          .then()
             .statusCode(200)
             .body(is("15"));
    }

    @Test
    public void testAnimalAverageAge() {
        given()
                .when().get("/api/animal/avg/age")
                .then()
                .statusCode(200)
                .body(is("3.2"));
    }
}