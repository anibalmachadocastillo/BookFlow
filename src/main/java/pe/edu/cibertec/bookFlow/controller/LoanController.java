package pe.edu.cibertec.bookFlow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.bookFlow.dto.Loan.LoanDetailDto;
import pe.edu.cibertec.bookFlow.dto.Loan.LoanDto;
import pe.edu.cibertec.bookFlow.dto.Loan.LoanEditDto;
import pe.edu.cibertec.bookFlow.dto.person.PersonDto;
import pe.edu.cibertec.bookFlow.dto.book.BookCreateDto;
import pe.edu.cibertec.bookFlow.dto.book.BookDto;
import pe.edu.cibertec.bookFlow.dto.book.BookEditDto;
import pe.edu.cibertec.bookFlow.service.LoanService;

import java.util.List;

@Controller
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/list")
    public String list(Model model) {
        List<LoanDetailDto>  loanDtos = loanService.findAllLoans();
        model.addAttribute("loanDtos", loanDtos);
        return "loan/list-loans";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        List<BookDto> books = loanService.findAllBooks();
        List<PersonDto> persons = loanService.findAllPersons();
        model.addAttribute("books", books);
        model.addAttribute("persons", persons);

        return "loan/create-loan";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute LoanDto loanDto, Model model) {
        try {
            loanService.createLoan(loanDto);
            return "redirect:/loan/list";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Ocurrió un error inesperado al crear el libro.");
            return "loan/create-loan";
        }
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        LoanDetailDto loan = loanService.findDetailById(id);

        model.addAttribute("loan", loan);
        return "loan/detail-loan";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        LoanEditDto loan = loanService.findById(id);
        model.addAttribute("loan", loan);
        return "loan/edit-loan";
    }


    @PostMapping("/edit")
    public String edit(@ModelAttribute LoanEditDto loanEditDto, Model model) {
        loanService.updateLoan(loanEditDto);
        return "redirect:/loan/list";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        Boolean resultado = loanService.deleteLoan(id);
        String message = resultado ? "Eliminacion exitosa" : "No se encontró valor o error en algun punto" ;

        model.addAttribute("message", message);
        return "redirect:/loan/list";
    }
}
