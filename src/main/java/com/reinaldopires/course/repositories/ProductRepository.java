package com.reinaldopires.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reinaldopires.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}