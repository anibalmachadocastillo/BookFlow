package pe.edu.cibertec.bookFlow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.bookFlow.dto.AuthorDto;
import pe.edu.cibertec.bookFlow.dto.EditorialDto;
import pe.edu.cibertec.bookFlow.dto.TypeBookGenreDto;
import pe.edu.cibertec.bookFlow.dto.book.BookCreateDto;
import pe.edu.cibertec.bookFlow.dto.book.BookDetailDto;
import pe.edu.cibertec.bookFlow.dto.book.BookDto;
import pe.edu.cibertec.bookFlow.dto.book.BookEditDto;
import pe.edu.cibertec.bookFlow.service.BookService;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;


    @GetMapping("/list")
    public String list(Model model){
        List<BookDto> bookDtos = bookService.findAllBooks();
        model.addAttribute("bookDtos", bookDtos);
        return "book/list-books";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        List<AuthorDto> authors = bookService.findAllAuthors();
        List<EditorialDto> editorials = bookService.findAllEditorials();
        List<TypeBookGenreDto> typeBookGenres = bookService.findAllTypeBookGenre();
        model.addAttribute("authors", authors);
        model.addAttribute("editorials", editorials);
        model.addAttribute("typeBookGenres", typeBookGenres);

        return "book/create-book";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute BookCreateDto bookCreateDto, Model model) {
        try {
            bookService.createBook(bookCreateDto);
            return "redirect:/book/list";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Ocurrió un error inesperado al crear el libro.");
            return "book/create-book";
        }
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        BookDto book = bookService.findDetailById(id);

        model.addAttribute("book", book);
        return "book/detail-book";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        BookEditDto book = bookService.findById(id);
        List<AuthorDto> authors = bookService.findAllAuthors();
        List<EditorialDto> editorials = bookService.findAllEditorials();
        List<TypeBookGenreDto> typeBookGenres = bookService.findAllTypeBookGenre();
        model.addAttribute("book", book);
        model.addAttribute("authors", authors);
        model.addAttribute("editorials", editorials);
        model.addAttribute("typeBookGenres", typeBookGenres);
        return "book/edit-book";
    }


    @PostMapping("/edit")
    public String edit(@ModelAttribute BookEditDto bookEditDto, Model model) {
        bookService.updateBook(bookEditDto);
        return "redirect:/book/list";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        Boolean resultado = bookService.deleteBook(id);
        String message = resultado ? "Eliminacion exitosa" : "No se encontró valor o error en algun punto" ;

        model.addAttribute("message", message);
        return "redirect:/book/list";
    }
}
