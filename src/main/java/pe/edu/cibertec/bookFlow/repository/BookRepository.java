package pe.edu.cibertec.bookFlow.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.bookFlow.entity.Book;

public interface  BookRepository extends CrudRepository<Book, Integer> {
}
