package com.carnauba.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carnauba.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>  {

}
