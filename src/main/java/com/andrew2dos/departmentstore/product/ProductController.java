package com.andrew2dos.departmentstore.product;

import com.andrew2dos.departmentstore.category.Category;
import com.andrew2dos.departmentstore.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductController(ProductRepository repository, CategoryRepository categoryRepository) {
        this.productRepository = repository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/products/new")
    public String showNewProductForm(Model model) {
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("product", new Product());
        model.addAttribute("categoryList", categoryList);
        return "product_form";
    }

    @PostMapping("/products/save")
    public String saveProduct(Product product){
        productRepository.save(product);

        return "redirect:/products";
    }

    @GetMapping("/products")
    public String productList(Model model){
        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);
        return "products";
    }

    @GetMapping("products/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
        Product product = productRepository.findById(id).get();
        model.addAttribute("product", product);

        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categoryList", categoryList);
        return "product_form";
    }

    @GetMapping("products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, Model model) {
        productRepository.deleteById(id);
        return "redirect:/products";
    }
}
