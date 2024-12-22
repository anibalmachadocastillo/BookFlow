package pe.edu.cibertec.bookFlow.dto.person;

import java.util.Date;

public record PersonEditDto(Integer personId,
                            String firstName,
                            String lastName,
                            Integer typeDocumentId,
                            String documentNumber,
                            String address,
                            String phoneNumber,
                            String email) {
}
