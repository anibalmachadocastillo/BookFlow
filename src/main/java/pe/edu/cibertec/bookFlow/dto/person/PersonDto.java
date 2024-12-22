package pe.edu.cibertec.bookFlow.dto.person;

public record PersonDto(Integer personId,
                        String name,
                        String documentNumber,
                        String email
) {
}
