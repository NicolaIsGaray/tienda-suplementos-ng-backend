package ng.tienda_suplementos.repository;

import ng.tienda_suplementos.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {
}
