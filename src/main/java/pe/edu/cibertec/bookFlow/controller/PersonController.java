package pe.edu.cibertec.bookFlow.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.bookFlow.dto.person.PersonCreateDto;
import pe.edu.cibertec.bookFlow.dto.person.PersonDetailDto;
import pe.edu.cibertec.bookFlow.dto.person.PersonDto;
import pe.edu.cibertec.bookFlow.dto.person.PersonEditDto;
import pe.edu.cibertec.bookFlow.dto.TypeDocumentDto;
import pe.edu.cibertec.bookFlow.service.PersonService;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    private PersonService personService;
    
    @GetMapping("/list")
    public String list(Model model) {
        List<PersonDto> personDtos = personService.findAllPersons();
        model.addAttribute("personDtos", personDtos);
        return "person/list-persons";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        List<TypeDocumentDto> typeDocuments = personService.findAllTypeDocuments();
        model.addAttribute("typeDocuments", typeDocuments);

        return "person/create-person";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute PersonCreateDto personCreatelDto, Model model) {
        try {
            personService.createPerson(personCreatelDto);
            return "redirect:/person/list";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Ocurrió un error inesperado al crear el libro.");
            return "person/create-person";
        }
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        PersonDetailDto person = personService.findDetailById(id);

        model.addAttribute("person", person);
        return "person/detail-person";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        PersonEditDto person = personService.findById(id);
        List<TypeDocumentDto> typeDocuments = personService.findAllTypeDocuments();
        model.addAttribute("person", person);
        model.addAttribute("typeDocuments", typeDocuments);

        return "person/edit-person";
    }


    @PostMapping("/edit")
    public String edit(@ModelAttribute PersonEditDto personEditDto, Model model) {
        personService.updatePerson(personEditDto);
        return "redirect:/person/list";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        Boolean resultado = personService.deletePerson(id);
        String message = resultado ? "Eliminacion exitosa" : "No se encontró valor o error en algun punto" ;

        model.addAttribute("message", message);
        return "redirect:/person/list";
    }
}
