package com.example.apichallenge;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


@SpringBootApplication
public class ApiChallengeApplication {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://petstore3.swagger.io/";
    }

    @Test
    public void testReadUser() {
        // Obtiene información del usuario recién creado
        given()
                .when()
                .get("/api/v3/user/john_john")
                .then()
                .statusCode(200) // Verifica que la solicitud GET sea exitosa
                .body("id", equalTo(12345)) // Verifica el valor del campo "id" en la respuesta
                .body("username", equalTo("john_john")); // Verifica el valor del campo "username" en la respuesta
    }

    @Test
    public void testReadUpdatedUser() {
        // Obtiene la información actualizada del usuario
        given()
                .when()
                .get("/api/v3/user/john_john")
                .then()
                .statusCode(200) // Verifica que la solicitud GET sea exitosa
                .body("id", equalTo(12345)) // Verifica el valor del campo "id" en la respuesta
                .body("username", equalTo("john_john")); // Verifica el valor del campo "username" en la respuesta
        // Agrega más verificaciones según sea necesario para otros campos en la respuesta
    }

    @Test
    public void testPerformanceAndValidation() {
        // Prueba de rendimiento (20 intentos)
        for (int i = 0; i < 5; i++) {
            given()
                    .when()
                    .get("/api/v3/user/john_john")
                    .then()
                    .statusCode(200);
        }

        // Prueba de tiempo de respuesta (opcional)
        given()
                .when()
                .get("/api/v3/user/john_john")
                .then()
                .time(lessThan(1000L)); // Verifica que el tiempo de respuesta sea menor a 1000 milisegundos

        // Pruebas de validación de nombres (solo letras)
        given()
                .when()
                .get("/api/v3/user/john_john")
                .then()
                .statusCode(200)
                .body("firstName", matchesRegex("[A-Za-z]+")) // Verifica que firstName contenga solo letras
                .body("lastName", matchesRegex("[A-Za-z]+")); // Verifica que lastName contenga solo letras
    }



    // Método para crear el cuerpo de la solicitud PUT para actualizar la información del usuario
    private String updateUserRequestBody() {
        return "{\n" +
                "  \"id\": 12345,\n" +
                "  \"username\": \"john_john\",\n" + // Actualiza el nombre de usuario
                "  \"firstName\": \"Johnny\",\n" +
                "  \"lastName\": \"Thunders\",\n" +
                "  \"email\": \"johnny_thunders@example.com\",\n" +
                "  \"password\": \"password\",\n" +
                "  \"phone\": \"1234567890\"\n" +
                "}";
    }
}