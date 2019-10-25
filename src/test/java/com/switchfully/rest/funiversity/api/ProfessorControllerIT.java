package com.switchfully.rest.funiversity.api;

import com.switchfully.rest.funiversity.api.dtos.RequestProfessorDto;
import com.switchfully.rest.funiversity.api.dtos.ResponseProfessorDto;
import com.switchfully.rest.funiversity.api.exceptionclasses.ProfessorAlreadyExistsException;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.switchfully.rest.funiversity.api.ProfessorController.PROFESSOR_CONTROLLER_RESOURCE_URI;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ProfessorControllerIT {

    @Value("${server.port}")
    private int port;

    @Test
    void createProfessor_givenAProfessorToCreate_thenTheNewlyCreatedProfessorIsSavedAndReturned() {
        RequestProfessorDto requestProfessorDto = new RequestProfessorDto()
                .setFirstname("Billy")
                .setLastname("Bob");

        ResponseProfessorDto responseProfessorDto = createProfessor(requestProfessorDto);

        assertThat(responseProfessorDto.getId()).isNotBlank();
        assertThat(responseProfessorDto.getFirstname()).isEqualTo(requestProfessorDto.getFirstname());
        assertThat(responseProfessorDto.getLastname()).isEqualTo(requestProfessorDto.getLastname());
    }

    @Test
    void createProfessor_givenAProfessorThatAlreadyExists_thenThrowException() {
        RequestProfessorDto requestProfessorDto = new RequestProfessorDto()
                .setFirstname("Arnold")
                .setLastname("Bob"); // This one already exists in ProfessorRepository

//        ResponseProfessorDto professor = createProfessor(requestProfessorDto);

        assertThrows(ProfessorAlreadyExistsException.class, () -> {
            RestAssured
                    .given()
                        .body(requestProfessorDto)
                        .accept(JSON)
                        .contentType(JSON)
                    .when()
                        .port(port)
                        .post(PROFESSOR_CONTROLLER_RESOURCE_URI)
                    .then()
                        .assertThat()
                        .statusCode(HttpStatus.BAD_REQUEST.value());
        });
    }

    @Test
    void getAllProfessors_thenReturnListOfProfessorsFromDatabase() {
        RequestProfessorDto requestProfessorDto1 = new RequestProfessorDto()
                .setFirstname("Maxime")
                .setLastname("Verbinnen");
        RequestProfessorDto requestProfessorDto2 = new RequestProfessorDto()
                .setFirstname("Kevin")
                .setLastname("Bass");

        ResponseProfessorDto professor1 = createProfessor(requestProfessorDto1);
        ResponseProfessorDto professor2 = createProfessor(requestProfessorDto2);

        ResponseProfessorDto[] responseProfessorDtos =
                RestAssured
                        .given()
                            .accept(JSON)
                            .contentType(JSON)
//                            .auth().preemptive().basic("ADMIN","ADMIN")
                        .when()
                            .port(port)
                            .get(PROFESSOR_CONTROLLER_RESOURCE_URI)
                        .then()
                            .assertThat()
                                .statusCode(HttpStatus.OK.value())
                                .extract()
                                    .as(ResponseProfessorDto[].class);

        List<ResponseProfessorDto> list = new ArrayList<>(Arrays.asList(responseProfessorDtos));
        assertThat(list).contains(professor1);
        assertThat(list).contains(professor2);
    }

    private ResponseProfessorDto createProfessor(RequestProfessorDto requestProfessorDto) {
        return RestAssured
                .given()
                    .body(requestProfessorDto)
                    .accept(JSON)
                    .contentType(JSON)
                .when()
                    .port(port)
                    .post(PROFESSOR_CONTROLLER_RESOURCE_URI)
                .then()
                    .assertThat()
                        .statusCode(HttpStatus.CREATED.value())
                        .extract()
                            .as(ResponseProfessorDto.class);
    }
}
