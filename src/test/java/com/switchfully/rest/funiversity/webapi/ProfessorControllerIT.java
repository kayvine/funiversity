package com.switchfully.rest.funiversity.webapi;

import com.switchfully.rest.funiversity.webapi.dtos.RequestProfessorDto;
import com.switchfully.rest.funiversity.webapi.dtos.ProfessorDto;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static com.switchfully.rest.funiversity.webapi.ProfessorController.PROFESSOR_CONTROLLER_RESOURCE_URI;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ProfessorControllerIT {

    @Value("${server.port}")
    private int port;

    @Test
    void createProfessor_givenAProfessorToCreate_thenTheNewlyCreatedProfessorIsSavedAndReturned() {
        RequestProfessorDto createProfessorDto = new RequestProfessorDto()
                .setFirstname("Billy")
                .setLastname("Bob");

        ProfessorDto professorDto =
                RestAssured
                        .given()
                            .body(createProfessorDto)
                            .accept(JSON)
                            .contentType(JSON)
                        .when()
                            .port(port)
                            .post(PROFESSOR_CONTROLLER_RESOURCE_URI)
                        .then()
                            .assertThat()
                                .statusCode(HttpStatus.CREATED.value())
                                .extract()
                                    .as(ProfessorDto.class);

        assertThat(professorDto.getId()).isNotBlank();
        assertThat(professorDto.getFirstname()).isEqualTo(createProfessorDto.getFirstname());
        assertThat(professorDto.getLastname()).isEqualTo(createProfessorDto.getLastname());
    }

    @Test
    void createProfessor_givenAProfessorThatAlreadyExists_thenThrowException() {
        RequestProfessorDto createProfessorDto = new RequestProfessorDto()
                .setFirstname("Arnold")
                .setLastname("Bob");

        ProfessorDto professorDto =
                RestAssured
                        .given()
                            .body(createProfessorDto)
                            .accept(JSON)
                            .contentType(JSON)
                        .when()
                            .port(port)
                            .post(PROFESSOR_CONTROLLER_RESOURCE_URI)
                        .then()
                            .assertThat()
                                .statusCode(HttpStatus.CREATED.value())
                                .extract()
                                    .as(ProfessorDto.class);

        assertThat(professorDto.getId()).isNotBlank();
        assertThat(professorDto.getFirstname()).isEqualTo(createProfessorDto.getFirstname());
        assertThat(professorDto.getLastname()).isEqualTo(createProfessorDto.getLastname());
    }

}
