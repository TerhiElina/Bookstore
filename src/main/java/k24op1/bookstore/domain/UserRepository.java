package k24op1.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

//Luodaan repository ja lisätään toiminto findByUsername
public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);

}
