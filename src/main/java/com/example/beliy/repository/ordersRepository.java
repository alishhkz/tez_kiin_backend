package com.example.beliy.repository;

import com.example.beliy.entity.orders;

import org.springframework.data.repository.CrudRepository;

public interface ordersRepository extends CrudRepository<orders,Integer> {
    orders save(orders o);
}
