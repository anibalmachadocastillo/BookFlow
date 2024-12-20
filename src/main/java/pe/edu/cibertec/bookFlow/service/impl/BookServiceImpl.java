package pe.edu.cibertec.bookFlow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.bookFlow.dto.BookDto;
import pe.edu.cibertec.bookFlow.entity.Book;
import pe.edu.cibertec.bookFlow.repository.BookRepository;
import pe.edu.cibertec.bookFlow.service.BookService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookDto> findAllBooks() {
        List<BookDto> bookDtos = new ArrayList<>();
        Iterable<Book> iterable = bookRepository.findAll();
        iterable.forEach(book -> {
            BookDto bookDto = new BookDto(book.getBookId(),
                    book.getTitle(),
                    book.getAuthor().getName(),
                    book.getEditorial().getName(),
                    book.getPublishedYear(),
                    book.getIsAvailable());
            bookDtos.add(bookDto);
        });

        return bookDtos;
    }
}
