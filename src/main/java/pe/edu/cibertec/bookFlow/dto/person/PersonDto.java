package pe.edu.cibertec.bookFlow.dto.person;

import pe.edu.cibertec.bookFlow.entity.PersonGenre;
import pe.edu.cibertec.bookFlow.entity.TypeDocument;

import java.util.Date;

public record PersonDto(
        Integer personId,
        String firstName,
        String lastName,
        TypeDocument typeDocument,
        String documentNumber,
        String email,
        String user,
        String address,
        String phone,
        Date birthDate,
        PersonGenre personGenre,
        String district
) {
}
