package com.example.beliy;

import com.example.beliy.entity.orders;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.beliy.repository.ordersRepository;


@AllArgsConstructor

@RestController
@RequestMapping("/orders")
public class ordersController {
    private ordersRepository oR;
    @PostMapping("/save")
    public ResponseEntity<String> saveOrder(@RequestBody orders o ){
        oR.save(o);
        return ResponseEntity.ok("saved");
    }
}
