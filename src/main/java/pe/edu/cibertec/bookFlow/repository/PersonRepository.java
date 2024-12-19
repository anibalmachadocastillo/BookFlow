package pe.edu.cibertec.bookFlow.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.bookFlow.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
