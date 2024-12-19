package pe.edu.cibertec.bookFlow.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.bookFlow.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
