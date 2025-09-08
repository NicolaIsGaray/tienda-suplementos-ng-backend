package ng.tienda_suplementos.service.product;

import ng.tienda_suplementos.model.Product;
import ng.tienda_suplementos.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProduct {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> listProducts() {
        List<Product> products = this.productRepo.findAll();

        return products;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product searchById(String id) {
        Product product = productRepo.findById(id).orElse(null);

        return product;
    }

    @Override
    public void deleteProduct(Product product) {
        productRepo.delete(product);
    }
}
