package com.example.contactlist.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsNull.notNullValue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApiTest {

    private static String token;      //variables token q necesitamos para Agregar un registro esta la obtenemos en el login
    private static String contactId; //variable q tomamos del registro  del nuevo contacto para la bajar y la modificacion
    private static final String url = "https://thinking-tester-contact-list.herokuapp.com"; //definimos url base

    //Tener en cuenta  el adduser permite crear el usuario para el login, tener en cuenta cuando hacemos el Login cambiar el Email (del body ) a uno nuevo en caso contrario el primer servicio va a fallar por q ya existe alguien con ese mail

    @Test
    public void test1_addUser() {


        RestAssured.baseURI = url;  //url sevicio  abajo tenemos el body donde creamos el usuario para hacer el login

        String requestBody = """
                {
                    "firstName": "don",
                    "lastName": "coronado",
                    "email": "p222rito@saail.com",
                    "password": "myPassword"
                }
                """;

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("/users");
        response.then().statusCode(201);  // Valida el código de estado aquí


    }


    @Test
    public void test2_loginUser() {
        RestAssured.baseURI = url; //hacemos el  login con el email y la contraseña enviadas anteriormente

        String requestBody = """
                {
                      "email": "p222rito@saail.com",
                      "password": "myPassword"
                  }
                """;

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("/users/login");

        response.then().statusCode(200)           //Validamos el statucode
                .body("token", notNullValue());  // Verifica que el token esté presente en la respuesta
        System.out.println("Response: " + response.asString());
        token = response.jsonPath().getString("token");
    }

    @Test
    public void test3_createContact() {
        RestAssured.baseURI = url;
                                        //Se agrega el siguiente resgistro
        String requestBody = """
                {
                    "firstName": "don naranaja",
                    "lastName": "Doe",
                    "birthdate": "1990-03-05",
                    "email": "jdoe@donanaranja.com",
                    "phone": "8005555555",
                    "street1": "1 Main St.",
                    "street2": "Apartment A",
                    "city": "Anytown",
                    "stateProvince": "KS",
                    "postalCode": "12345",
                    "country": "USA"
                }
                """;

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)  // Incluye el token en el header
                .body(requestBody)
                .post("/contacts");

        contactId = response.jsonPath().getString("_id");
        response.then().statusCode(201);
        System.out.println("Response: " + response.asString());
    }

    @Test
    public void test4_updateContact() {
        RestAssured.baseURI = url;
                                    //hacemos la modificacion utilizando el contacID y cargando el fomulario con este body
        String requestBody = """
                {
                    "firstName": "Amy",
                    "lastName": "Miller",
                    "birthdate": "1992-02-02",
                    "email": "amiller@fake.com",
                    "phone": "8005554242",
                    "street1": "13 School St.",
                    "street2": "Apt. 5",
                    "city": "Washington",
                    "stateProvince": "QC",
                    "postalCode": "A1A1A1",
                    "country": "Canada"
                }
                """;

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)  // Incluye el token en el header
                .body(requestBody)
                .put("/contacts/" + contactId); // Usando el contactId obtenido de createContact
        System.out.println(url + response.asString());
        response.then().statusCode(200); // Ajusta el código de estado según la respuesta esperada
        System.out.println("Response: " + response.asString());
    }

    // elimina el regisro utilizando  el contactid
   @Test
    public void test5_deleteContact() {
        RestAssured.baseURI = url;

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)  // Incluye el token en el header
                .delete("/contacts/" + contactId); // Usando el contactId obtenido de createContact
        System.out.println(url + response.asString());
        response.then().statusCode(200); // Ajusta el código de estado según la respuesta esperada
        System.out.println("Response: " + response.asString());
    }


}
