package com.example.beliy.repository;

import com.example.beliy.entity.products;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface productsRepository extends CrudRepository<products,Integer> {

    List<products> findAll();
    products save(products p);

    List<products> findAllByCategory(String Category);
}
