package pe.edu.cibertec.bookFlow.dto.person;

public record PersonCreateDto(Integer personId,
                              String firstName,
                              String lastName,
                              Integer typeDocumentId,
                              String documentNumber,
                              String address,
                              String phoneNumber,
                              String email) {
}
