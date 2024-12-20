package pe.edu.cibertec.bookFlow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.bookFlow.dto.BookDto;
import pe.edu.cibertec.bookFlow.service.BookService;

import java.util.ArrayList;
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
}
