package pe.edu.cibertec.bookFlow.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.bookFlow.dto.Loan.LoanDetailDto;
import pe.edu.cibertec.bookFlow.dto.Loan.LoanDto;
import pe.edu.cibertec.bookFlow.dto.Loan.LoanEditDto;
import pe.edu.cibertec.bookFlow.dto.person.PersonDto;
import pe.edu.cibertec.bookFlow.dto.book.BookCreateDto;
import pe.edu.cibertec.bookFlow.dto.book.BookDto;
import pe.edu.cibertec.bookFlow.dto.book.BookEditDto;
import pe.edu.cibertec.bookFlow.entity.*;
import pe.edu.cibertec.bookFlow.repository.BookRepository;
import pe.edu.cibertec.bookFlow.repository.LoanRepository;
import pe.edu.cibertec.bookFlow.repository.PersonRepository;
import pe.edu.cibertec.bookFlow.service.LoanService;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<LoanDetailDto> findAllLoans() {

        List<LoanDetailDto> loanDtos = new ArrayList<>();
        Iterable<Loan> iterable = loanRepository.findAll();
        iterable.forEach(loan -> {
            LoanDetailDto loanDetailDto = new LoanDetailDto(loan.getLoanId(),
                    loan.getBook().getTitle(),
                    loan.getPerson().getFirstName() + " " + loan.getPerson().getLastName(),
                    loan.getLoanDate(),
                    loan.getReturnDate(),
                    loan.getStatus());
            loanDtos.add(loanDetailDto);
        });

        return loanDtos;
    }

    @Override
    public List<BookDto> findAllBooks() {
        List<BookDto> bookDtos = new ArrayList<>();
        Iterable<Book> iterable = bookRepository.findAll();
        iterable.forEach(book -> {
            if (book.getIsAvailable()){
                BookDto bookDto = new BookDto(book.getBookId(),
                        book.getTitle(),
                        book.getAuthor().getName(),
                        book.getEditorial().getName(),
                        book.getTypeBookGenre().getName(),
                        book.getPublishedYear(),
                        book.getIsAvailable());
                bookDtos.add(bookDto);
            }
        });

        return bookDtos;
    }

    @Override
    public List<PersonDto> findAllPersons() {
        List<PersonDto> personDtos = new ArrayList<>();
        Iterable<Person> iterable = personRepository.findAll();
        iterable.forEach(person -> {
            PersonDto personDto = new PersonDto(person.getPersonId(),
                    person.getFirstName() + " " + person.getLastName(),
                    person.getDocumentNumber(),
                    person.getEmail());
            personDtos.add(personDto);
        });

        return personDtos;
    }

    @Override
    public void createLoan(LoanDto loanDto) {
        Book book = bookRepository.findById(loanDto.bookId()).
                orElseThrow(() -> new IllegalArgumentException("Book not found"));
        Person person = personRepository.findById(loanDto.personId()).
                orElseThrow(() -> new IllegalArgumentException("Person not found"));
        book.setIsAvailable(false);

        Loan loan = new Loan();
        loan.setBook(book);
        loan.setPerson(person);
        loan.setLoanDate(new Date());
        loan.setReturnDate(loanDto.returnDate());
        loan.setStatus(loanDto.status());
        loanRepository.save(loan);
    }

    @Override
    public LoanDetailDto findDetailById(Integer id) {
        Optional<Loan> optional= loanRepository.findById(id);
        return optional.map(
                loan -> new LoanDetailDto(loan.getLoanId(),
                        loan.getBook().getTitle(),
                        loan.getPerson().getFirstName()+ " " + loan.getPerson().getLastName(),
                        loan.getLoanDate(),
                        loan.getReturnDate(),
                        loan.getStatus())
        ).orElse(null);
    }

    @Override
    public LoanEditDto findById(Integer id) {
        Optional<Loan> optional= loanRepository.findById(id);
        return optional.map(
                loan -> new LoanEditDto(loan.getLoanId(),
                        loan.getBook().getBookId(),
                        loan.getPerson().getPersonId(),
                        loan.getBook().getTitle(),
                        loan.getPerson().getFirstName() + " " + loan.getPerson().getLastName(),
                        loan.getLoanDate(),
                        loan.getReturnDate(),
                        loan.getStatus())
        ).orElse(null);
    }

    @Override
    public Boolean   updateLoan(LoanEditDto loanEditDto) {
        if (loanEditDto.bookId() == null || loanEditDto.personId() == null) {
            throw new IllegalArgumentException("One or more required IDs are null");
        }
        Book book = bookRepository.findById(loanEditDto.bookId()).
                orElseThrow(() -> new IllegalArgumentException("Book not found"));
        Person person = personRepository.findById(loanEditDto.personId()).
                orElseThrow(() -> new IllegalArgumentException("Person not found"));

        Optional<Loan> optional = loanRepository.findById(loanEditDto.loanId());
        return optional.map(
                loan -> {
                    loan.setBook(book);
                    loan.setPerson(person);
                    loan.setReturnDate(loanEditDto.returnDate());
                    loan.setStatus(loan.getStatus());
                    loanRepository.save(loan);
                    return true;
                }
        ).orElse(false);

    }

    @Transactional
    @Override
    public Boolean deleteLoan(Integer id) {
        return loanRepository.findById(id).map(loan ->{
            loanRepository.deleteById(loan.getLoanId());
            Book book= bookRepository.findById(loan.getBook().getBookId()).orElseThrow(() -> new IllegalArgumentException("Book not found"));
            book.setIsAvailable(true);
            bookRepository.save(book);
            return true;
        }).orElse(false);
    }


}
