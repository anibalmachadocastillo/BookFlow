package pe.edu.cibertec.bookFlow.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.bookFlow.dto.AuthorDto;
import pe.edu.cibertec.bookFlow.dto.EditorialDto;
import pe.edu.cibertec.bookFlow.dto.TypeBookGenreDto;
import pe.edu.cibertec.bookFlow.dto.book.BookCreateDto;
import pe.edu.cibertec.bookFlow.dto.book.BookDetailDto;
import pe.edu.cibertec.bookFlow.dto.book.BookDto;
import pe.edu.cibertec.bookFlow.dto.book.BookEditDto;

import java.util.List;

@Service
public interface BookService {
    List<BookDto> findAllBooks();

    List<AuthorDto> findAllAuthors();

    List<EditorialDto> findAllEditorials();

    List<TypeBookGenreDto> findAllTypeBookGenre();

    void createBook(BookCreateDto filmData);

    BookDto findDetailById(Integer id);

    Boolean deleteBook(Integer id);


    Boolean updateBook(BookEditDto bookEditDto);

    BookEditDto findById(Integer id);
}
