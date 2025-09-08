package ng.tienda_suplementos.service.product;

import ng.tienda_suplementos.model.Product;

import java.util.List;

public interface IProduct {
    List<Product> listProducts();
    Product saveProduct(Product product);
    Product searchById(String id);
    void deleteProduct(Product product);
}
