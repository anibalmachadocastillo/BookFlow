package pe.edu.cibertec.bookFlow.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.bookFlow.entity.Editorial;
import pe.edu.cibertec.bookFlow.entity.TypeBookGenre;

public interface TypeBookGenreRepository extends CrudRepository<TypeBookGenre, Integer> {
}
