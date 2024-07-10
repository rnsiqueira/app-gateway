package br.com.rns.app_gateway;

import br.com.rns.app_gateway.Repository.RequestRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = AppGatewayApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class AppGatewayApplicationTests {

    @Autowired
    private RequestRepository requestRepository;

    @LocalServerPort
    private int portApp;

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = String.format("http://localhost:%d", portApp);
    }


    @Test
    void takeDataRequests() throws Exception {

        var response = given()
                .when()
                .get("/store/home")
                .thenReturn();

        assertEquals(200, response.getStatusCode());

    }

}
