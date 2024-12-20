package pe.edu.cibertec.bookFlow.dto;

import java.util.Date;

public record User(
        Integer userId,
        String userName,
        String password,
        Date creationDate
) {
}
