package pe.edu.cibertec.bookFlow.dto.person;

import java.util.Date;

public record PersonDetailDto(Integer personId,
                              String name,
                              String typeDocument,
                              String documentNumber,
                              String address,
                              String phoneNumber,
                              String email) {
}
