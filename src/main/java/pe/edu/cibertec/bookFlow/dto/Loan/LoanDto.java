package pe.edu.cibertec.bookFlow.dto.Loan;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record LoanDto(Integer loanId,
                      Integer bookId,
                      Integer personId,
                      Date loanDate,
                      @DateTimeFormat(pattern = "yyyy-MM-dd") Date returnDate,
                      Boolean status
) {
}
