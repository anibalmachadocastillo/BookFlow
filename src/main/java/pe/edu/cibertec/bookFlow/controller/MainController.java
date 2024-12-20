package pe.edu.cibertec.bookFlow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class MainController {

    @GetMapping("/start")
    public String start() {
        return "home";
    }
    @GetMapping("/book")
    public String start(Model model) {
        return "redirect:/book/list";
    }

}
