package pe.edu.cibertec.bookFlow.dto.Loan;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record LoanEditDto(Integer loanId,
                          Integer bookId,
                          Integer personId,
                          String book,
                          String person,
                          Date loanDate,
                          @DateTimeFormat(pattern = "yyyy-MM-dd") Date returnDate,
                          Boolean status) {
}
