package pe.edu.cibertec.bookFlow.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.bookFlow.dto.TypeDocumentDto;
import pe.edu.cibertec.bookFlow.dto.person.PersonCreateDto;
import pe.edu.cibertec.bookFlow.dto.person.PersonDetailDto;
import pe.edu.cibertec.bookFlow.dto.person.PersonDto;
import pe.edu.cibertec.bookFlow.dto.person.PersonEditDto;

import java.util.List;

@Service
public interface PersonService {
    List<PersonDto> findAllPersons();

    List<TypeDocumentDto> findAllTypeDocuments();

    void createPerson(PersonCreateDto personCreateDto);

    PersonDetailDto findDetailById(Integer id);

    PersonEditDto findById(Integer id);

    Boolean updatePerson(PersonEditDto personEditDto);

    Boolean deletePerson(Integer id);
}
