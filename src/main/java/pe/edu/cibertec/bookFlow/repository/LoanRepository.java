package pe.edu.cibertec.bookFlow.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.bookFlow.entity.Loan;

public interface LoanRepository extends CrudRepository<Loan, Integer> {
}
