package com.andrew2dos.departmentstore.product;

import com.andrew2dos.departmentstore.category.Category;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 128, nullable = false, unique = true)
    private String name;
    private double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
