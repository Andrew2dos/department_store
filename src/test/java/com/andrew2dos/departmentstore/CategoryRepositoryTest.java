package com.andrew2dos.departmentstore;

import com.andrew2dos.departmentstore.category.Category;
import com.andrew2dos.departmentstore.category.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

//import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void testCreateCategory(){
        Category savedCategory = repository.save(new Category("Electronics"));

            assertThat(savedCategory.getId()).isGreaterThan(0);
    }
}
