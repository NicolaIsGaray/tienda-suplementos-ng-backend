package ng.tienda_suplementos.repository;

import ng.tienda_suplementos.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product, String> {
}
