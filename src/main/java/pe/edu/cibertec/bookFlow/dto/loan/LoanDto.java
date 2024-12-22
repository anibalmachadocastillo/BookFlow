package pe.edu.cibertec.bookFlow.dto.loan;

import java.util.Date;

public record LoanDto(
        Integer loanId,
        String person,
        Date loanDate,
        Date returnDate,
        Boolean status
) {
}
