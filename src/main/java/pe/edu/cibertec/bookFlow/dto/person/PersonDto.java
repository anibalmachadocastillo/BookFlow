package pe.edu.cibertec.bookFlow.dto;

public record PersonDto(
        Integer personId,
        String name,
//        TypeDocument typeDocument,
        String documentNumber,
        String email
//        String user,
//        String address,
        //        Date birthDate,
//        PersonGenre personGenre,
//        String district
) {
}
