package com.andrew2dos.departmentstore.brand;

import com.andrew2dos.departmentstore.category.Category;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 45, nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "brand")
    private List<Category> categories;
}
