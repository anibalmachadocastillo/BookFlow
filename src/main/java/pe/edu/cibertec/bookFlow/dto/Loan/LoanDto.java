package pe.edu.cibertec.bookFlow.dto;

import java.util.Date;

public record LoanDto(
        Integer loanId,
        String person,
        Date loanDate,
        Date returnDate,
        Boolean status
) {
}
