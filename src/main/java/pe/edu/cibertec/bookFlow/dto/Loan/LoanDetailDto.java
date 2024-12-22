package pe.edu.cibertec.bookFlow.dto.Loan;

import java.util.Date;

public record LoanDetailDto(Integer loanId,
                            String book,
                            String person,
                            Date loanDate,
                            Date returnDate,
                            Boolean status) {
}
