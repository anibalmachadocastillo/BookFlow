package pe.edu.cibertec.bookFlow.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.bookFlow.dto.Loan.LoanDetailDto;
import pe.edu.cibertec.bookFlow.dto.Loan.LoanDto;
import pe.edu.cibertec.bookFlow.dto.Loan.LoanEditDto;
import pe.edu.cibertec.bookFlow.dto.person.PersonDto;
import pe.edu.cibertec.bookFlow.dto.book.BookCreateDto;
import pe.edu.cibertec.bookFlow.dto.book.BookDto;
import pe.edu.cibertec.bookFlow.dto.book.BookEditDto;

import java.util.List;

@Service

public interface LoanService {

    List<BookDto> findAllBooks();

    List<PersonDto> findAllPersons();

    void createLoan(LoanDto loanDto);

    LoanDetailDto findDetailById(Integer id);

    LoanEditDto findById(Integer id);

    Boolean updateLoan(LoanEditDto loanEditDto);

    Boolean deleteLoan(Integer id);

    List<LoanDetailDto> findAllLoans();

}
