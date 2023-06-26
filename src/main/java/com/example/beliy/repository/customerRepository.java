package com.example.beliy.repository;

import com.example.beliy.entity.users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface customerRepository extends CrudRepository<users, Integer> {
        users save(users c);
        users findByLogin(String login);

        users existsByLogin(String login);
}
