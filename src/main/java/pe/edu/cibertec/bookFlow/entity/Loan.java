package pe.edu.cibertec.bookFlow.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    @Id
    private Integer loanId;
    private Integer bookId;
    private Integer personId;
    private Date loanDate;
    private Date returnDate;
    private String status;
}
