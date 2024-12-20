package pe.edu.cibertec.bookFlow.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.bookFlow.dto.BookDto;

import java.util.List;

@Service
public interface BookService {
    List<BookDto> findAllBooks();
}
