package ng.tienda_suplementos.controller;

import ng.tienda_suplementos.exceptions.ProductNotFound;
import ng.tienda_suplementos.model.Product;
import ng.tienda_suplementos.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tienda-suplementos-app")
@CrossOrigin(value = "http://localhost:4200")
public class MainController {

    private Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    ProductService productoService;

    @GetMapping("/productos")
    public List<Product> getProducts() {
        List<Product> products = this.productoService.listProducts();

        if (!products.isEmpty()) {
            logger.info("\n Productos obtenidos: \n");
            products.forEach(product -> logger.info(product.toString()));
        } else {
            logger.info("\nNo se han encontrado productos.\n");
        }

        return products;
    }

    @GetMapping("/productos/{id}")
    public Product getProductById(@PathVariable String id) {
        Product product = this.productoService.searchById(id);

        if (product == null) {
            throw new ProductNotFound("No se ha encontrado el producto.");
        }

        return product;
    }
}
