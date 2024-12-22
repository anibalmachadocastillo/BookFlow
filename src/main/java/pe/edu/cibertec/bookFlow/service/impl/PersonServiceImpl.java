package pe.edu.cibertec.bookFlow.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.bookFlow.dto.TypeDocumentDto;
import pe.edu.cibertec.bookFlow.dto.book.BookDto;
import pe.edu.cibertec.bookFlow.dto.book.BookEditDto;
import pe.edu.cibertec.bookFlow.dto.person.PersonCreateDto;
import pe.edu.cibertec.bookFlow.dto.person.PersonDetailDto;
import pe.edu.cibertec.bookFlow.dto.person.PersonDto;
import pe.edu.cibertec.bookFlow.dto.person.PersonEditDto;
import pe.edu.cibertec.bookFlow.entity.*;
import pe.edu.cibertec.bookFlow.repository.PersonRepository;
import pe.edu.cibertec.bookFlow.repository.TypeDocumentRepository;
import pe.edu.cibertec.bookFlow.service.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private TypeDocumentRepository typeDocumentRepository;

    @Override
    public List<PersonDto> findAllPersons() {
        List<PersonDto> persons = new ArrayList<>();
        Iterable<Person> iterable = personRepository.findAll();
        iterable.forEach(person -> {
            PersonDto personDto = new PersonDto(person.getPersonId(),
                    person.getFirstName() + " " + person.getLastName(),
                    person.getDocumentNumber(),
                    person.getEmail());
            persons.add(personDto);
        });
        return persons;
    }

    @Override
    public List<TypeDocumentDto> findAllTypeDocuments() {
        List<TypeDocumentDto> typeDocuments = new ArrayList<>();
        Iterable<TypeDocument> iterable = typeDocumentRepository.findAll();
        iterable.forEach(typeDocument -> {
            TypeDocumentDto typeDocumentDto = new TypeDocumentDto(typeDocument.getTypeDocumentId(),
                    typeDocument.getName());
            typeDocuments.add(typeDocumentDto);
        });
        return typeDocuments;
    }

    @Override
    public void createPerson(PersonCreateDto personCreateDto) {
        if (personCreateDto.typeDocumentId() == null) {
            throw new IllegalArgumentException("One or more required IDs are null");
        }
        TypeDocument typeDocument = typeDocumentRepository.findById(personCreateDto.typeDocumentId()).
                orElseThrow(() -> new IllegalArgumentException("Author not found"));

        Person person = new Person();
        person.setFirstName(personCreateDto.firstName());
        person.setLastName(personCreateDto.lastName());
        person.setTypeDocument(typeDocument);
        person.setDocumentNumber(personCreateDto.documentNumber());
        person.setAddress(personCreateDto.address());
        person.setEmail(personCreateDto.email());
        person.setPhone(personCreateDto.phoneNumber());
        personRepository.save(person);
    }

    @Override
    public PersonDetailDto findDetailById(Integer id) {
        Optional<Person> optional= personRepository.findById(id);
        return optional.map(
                person -> new PersonDetailDto(person.getPersonId(),
                        person.getFirstName()+" "+person.getLastName(),
                        person.getTypeDocument().getName(),
                        person.getDocumentNumber(),
                        person.getAddress(),
                        person.getPhone(),
                        person.getEmail())
        ).orElse(null);
    }

    @Override
    public PersonEditDto findById(Integer id) {
        Optional<Person> optional= personRepository.findById(id);
        return optional.map(
                person -> new BookEditDto(person.getPersonId(),
                        person.getFirstName(),
                        person.getLastName(),
                        person.getTypeDocument(),
                        person.getDocumentNumber(),
                        person.getAddress(),
                        person.getPhone(),
                        person.getEmail())
        ).orElse(null);
    }

    @Override
    public Boolean updatePerson(PersonEditDto personEditDto) {
        TypeDocument typeDocument = typeDocumentRepository.findById(personEditDto.typeDocumentId()).
                orElseThrow(() -> new IllegalArgumentException("Author not found"));

        Optional<Person> optional = personRepository.findById(personEditDto.personId());
        return optional.map(
                person -> {
                    person.setFirstName(personEditDto.fisrtName());
                    person.setLastName(personEditDto.lastName());
                    person.setTypeDocument(typeDocument);
                    person.setDocumentNumber(personEditDto.documentNumber());
                    person.setAddress(personEditDto.address());
                    person.setEmail(personEditDto.email());
                    person.setPhone(personEditDto.phoneNumber());
                    personRepository.save(person);
                    return true;
                }
        ).orElse(false);
    }

    @Override
    public Boolean deletePerson(Integer id) {
        return personRepository.findById(id).map(person -> {
            personRepository.deleteById(person.getPersonId());
            return true;
        }).orElse(false);
    }
}
