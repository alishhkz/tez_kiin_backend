package com.example.beliy.services;

import com.example.beliy.entity.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.beliy.repository.customerRepository;

@Service
public class customerService {
    @Autowired
    private customerRepository userRepository;
    public boolean checkUserExists(String login, String password) {
        users c = userRepository.findByLogin(login);
        if (c.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
    public void changePassword(String login,String newPassword){
        users c = userRepository.findByLogin(login);
        c.setPassword(newPassword);
        userRepository.save(c);
    }

}
