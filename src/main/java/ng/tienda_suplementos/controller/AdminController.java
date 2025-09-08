package ng.tienda_suplementos.controller;

import ng.tienda_suplementos.exceptions.ProductNotFound;
import ng.tienda_suplementos.model.Product;
import ng.tienda_suplementos.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminController {
    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private ProductService productService;

    @PostMapping("/agregar-producto")
    public Product addProduct(@RequestBody Product product){
        Product productAdded = this.productService.saveProduct(product);

        if (productAdded != null) {
            logger.info("\nProducto registrado: " + productAdded);
        } else {
            logger.info("\nNo se pudo registrar el producto.\n");
        }

        return productAdded;
    }

    @PutMapping("/editar-producto/{id}")
    public ResponseEntity<Product> modifyProduct(@PathVariable String id, @RequestBody Product product) {
        Product productObtained = this.productService.searchById(id);

        if (productObtained == null) {
            throw new ProductNotFound("No se ha encontrado el producto.");
        }

        productObtained.setName(product.getName());

        productObtained.setDescription(product.getDescription());

        productObtained.setStock(product.getStock());

        productObtained.setPrice(product.getPrice());

        productObtained.setHasOffer(product.getHasOffer());

        productObtained.setDiscount(product.getDiscount());

        productObtained.setWeight(product.getWeight());

        productObtained.setColour(product.getColour());

        productObtained.setFlavour(product.getFlavour());

        productObtained.setSize(product.getSize());

        productObtained.setBrand(product.getBrand());

        productObtained.setCategory(product.getCategory());

        productObtained.setSubcategory(product.getSubcategory());

        productObtained.setImages(product.getImages());

        productObtained.setCoverImage(product.getCoverImage());

        this.productService.saveProduct(productObtained);

        return ResponseEntity.ok(productObtained);
    }

    @DeleteMapping("/eliminar-producto/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable String id) {
        Product product = this.productService.searchById(id);

        if (product == null) {
            throw new ProductNotFound("No se ha encontrado el producto.");
        }

        this.productService.deleteProduct(product);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Erased", true);

        return ResponseEntity.ok(response);
    }
}
