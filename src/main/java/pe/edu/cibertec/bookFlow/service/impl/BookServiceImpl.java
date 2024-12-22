package pe.edu.cibertec.bookFlow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.bookFlow.dto.AuthorDto;
import pe.edu.cibertec.bookFlow.dto.EditorialDto;
import pe.edu.cibertec.bookFlow.dto.TypeBookGenreDto;
import pe.edu.cibertec.bookFlow.dto.book.BookCreateDto;
import pe.edu.cibertec.bookFlow.dto.book.BookDto;
import pe.edu.cibertec.bookFlow.dto.book.BookEditDto;
import pe.edu.cibertec.bookFlow.entity.Author;
import pe.edu.cibertec.bookFlow.entity.Book;
import pe.edu.cibertec.bookFlow.entity.Editorial;
import pe.edu.cibertec.bookFlow.entity.TypeBookGenre;
import pe.edu.cibertec.bookFlow.repository.AuthorRepository;
import pe.edu.cibertec.bookFlow.repository.BookRepository;
import pe.edu.cibertec.bookFlow.repository.EditorialRepository;
import pe.edu.cibertec.bookFlow.repository.TypeBookGenreRepository;
import pe.edu.cibertec.bookFlow.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private EditorialRepository editorialRepository;

    @Autowired
    private TypeBookGenreRepository typeBookGenreRepository;


    @Override
    public List<BookDto> findAllBooks() {
        List<BookDto> bookDtos = new ArrayList<>();
        Iterable<Book> iterable = bookRepository.findAll();
        iterable.forEach(book -> {
            BookDto bookDto = new BookDto(book.getBookId(),
                    book.getTitle(),
                    book.getAuthor().getName(),
                    book.getEditorial().getName(),
                    book.getTypeBookGenre().getName(),
                    book.getPublishedYear(),
                    book.getIsAvailable());
            bookDtos.add(bookDto);
        });

        return bookDtos;
    }

    @Override
    public List<AuthorDto> findAllAuthors() {
        List<AuthorDto> authorDtos = new ArrayList<>();
        Iterable<Author> iterable = authorRepository.findAll();
        iterable.forEach(author -> {
            AuthorDto authorDto = new AuthorDto(author.getAuthorId(),author.getName());
            authorDtos.add(authorDto);
        });
        return authorDtos;
    }

    @Override
    public List<EditorialDto> findAllEditorials() {
        List<EditorialDto> editorialDtos = new ArrayList<>();
        Iterable<Editorial> iterable = editorialRepository.findAll();
        iterable.forEach(editorial -> {
            EditorialDto editorialDto = new EditorialDto(editorial.getEditorialId(),editorial.getName());
            editorialDtos.add(editorialDto);
        });
        return editorialDtos;
    }

    @Override
    public List<TypeBookGenreDto> findAllTypeBookGenre() {
        List<TypeBookGenreDto> typeBookGenreDtos = new ArrayList<>();
        Iterable<TypeBookGenre> iterable = typeBookGenreRepository.findAll();
        iterable.forEach(typeBookGenre -> {
            TypeBookGenreDto typeBookGenreDto = new TypeBookGenreDto(typeBookGenre.getTypeBookGenreId(),
                    typeBookGenre.getName());
            typeBookGenreDtos.add(typeBookGenreDto);
        });
        return typeBookGenreDtos;
    }

    @Override
    public void createBook(BookCreateDto bookCreateDto) {

        if (bookCreateDto.authorId() == null || bookCreateDto.editorialId() == null || bookCreateDto.typeBookGenreId() == null) {
            throw new IllegalArgumentException("One or more required IDs are null");
        }


        Author author = authorRepository.findById(bookCreateDto.authorId()).
                orElseThrow(() -> new IllegalArgumentException("Author not found"));
        Editorial editorial = editorialRepository.findById(bookCreateDto.editorialId()).
                orElseThrow(() -> new IllegalArgumentException("Author not found"));
        TypeBookGenre typeBookGenre = typeBookGenreRepository.findById(bookCreateDto.typeBookGenreId()).
                orElseThrow(() -> new IllegalArgumentException("Author not found"));

        Book book = new Book();
        book.setTitle(bookCreateDto.title());
        book.setAuthor(author);
        book.setEditorial(editorial);
        book.setTypeBookGenre(typeBookGenre);
        book.setPublishedYear(bookCreateDto.publishedYear());
        book.setIsAvailable(bookCreateDto.isAvailable());
        bookRepository.save(book);

        System.out.println(author);
        System.out.println(editorial);
        System.out.println(typeBookGenre);
        System.out.println(bookCreateDto);

    }

    @Override
    public BookDto findDetailById(Integer id) {
        Optional<Book> optional= bookRepository.findById(id);
        return optional.map(
                book -> new BookDto(book.getBookId(),
                        book.getTitle(),
                        book.getAuthor().getName(),
                        book.getTypeBookGenre().getName(),
                        book.getEditorial().getName(),
                        book.getPublishedYear(),
                        book.getIsAvailable())
                ).orElse(null);
    }

    @Override
    public Boolean deleteBook(Integer id) {
        return bookRepository.findById(id).map(book ->{
            bookRepository.deleteById(book.getBookId());
            return true;
        }).orElse(false);

    }

    @Override
    public Boolean updateBook(BookEditDto bookEditDto) {
        if (bookEditDto.authorId() == null || bookEditDto.editorialId() == null || bookEditDto.typeBookGenreId() == null) {
            throw new IllegalArgumentException("One or more required IDs are null");
        }
        Author author = authorRepository.findById(bookEditDto.authorId()).
                orElseThrow(() -> new IllegalArgumentException("Author not found"));
        Editorial editorial = editorialRepository.findById(bookEditDto.editorialId()).
                orElseThrow(() -> new IllegalArgumentException("Author not found"));
        TypeBookGenre typeBookGenre = typeBookGenreRepository.findById(bookEditDto.typeBookGenreId()).
                orElseThrow(() -> new IllegalArgumentException("Author not found"));

        Optional<Book> optional = bookRepository.findById(bookEditDto.bookId());
        return optional.map(
                book -> {
                   book.setTitle(bookEditDto.title());
                   book.setAuthor(author);
                   book.setEditorial(editorial);
                   book.setTypeBookGenre(typeBookGenre);
                   book.setPublishedYear(bookEditDto.publishedYear());
                   book.setIsAvailable(bookEditDto.isAvailable());
                   bookRepository.save(book);
                   return true;
                }
        ).orElse(false);

    }

    @Override
    public BookEditDto findById(Integer id) {
        Optional<Book> optional= bookRepository.findById(id);
        return optional.map(
                book -> new BookEditDto(book.getBookId(),
                        book.getTitle(),
                        book.getAuthor().getAuthorId(),
                        book.getTypeBookGenre().getTypeBookGenreId(),
                        book.getEditorial().getEditorialId(),
                        book.getPublishedYear(),
                        book.getIsAvailable())
        ).orElse(null);
    }
}
