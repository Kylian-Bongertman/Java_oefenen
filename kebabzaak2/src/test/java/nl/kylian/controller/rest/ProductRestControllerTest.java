package nl.kylian.controller.rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import nl.kylian.Application;
import nl.kylian.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)


public class ProductRestControllerTest {
    @LocalServerPort
    private int port;

    private static final String API_ROOT = "/api/producten";

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void whenGetAllProducts_thenOK() {
        Response response = RestAssured.get(API_ROOT);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Test
    public void whenPostProduct_thenOK() {
        Product product = createRandomProduct();
        Response response = createProductAsUri(product);
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
    }

    @Test
    public void whenGetProductsByNaam_thenOK() {
        Product product = createRandomProduct();
        String location = API_ROOT + "/naam/" + createProductAsUri(product).jsonPath().get("naam");
        Response response = RestAssured.get(location);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertTrue(response.as(List.class)
                .size() > 0);
    }

    @Test
    public void whenGetCreatedProductById_thenOK() {
        Product product = createRandomProduct();
        String location = API_ROOT + "/" + createProductAsUri(product).jsonPath().get("id");
        Response response = RestAssured.get(location);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals(product.getNaam(), response.jsonPath()
                .get("naam"));
    }

    @Test
    public void whenGetNotExistProductById_thenNotFound() {
        Response response = RestAssured.get(API_ROOT + "/" + randomNumeric(4));

        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }

    private Product createRandomProduct() {
        Product product = new Product();
        product.setNaam(randomAlphabetic(10));
        product.setPrijs(1.0);
        return product;
    }

    private Response createProductAsUri(Product product) {
        return RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(product)
                .post(API_ROOT);
    }

}