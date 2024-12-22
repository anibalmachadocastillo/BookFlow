package pe.edu.cibertec.bookFlow.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.bookFlow.entity.Author;
import pe.edu.cibertec.bookFlow.entity.Book;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
