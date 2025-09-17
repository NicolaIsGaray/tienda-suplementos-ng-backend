package ng.tienda_suplementos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private String id;

    private String name;

    private String description;

    private Integer stock;

    private Double price;

    private Boolean hasOffer;

    private Integer discount;

    private Double weight;

    private String colour;

    private String flavour;

    private String size;

    private String brand;

    private String category;

    private String subcategory;

    private String[] images;

    private String coverImage;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
}
