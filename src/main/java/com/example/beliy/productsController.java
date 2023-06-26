package com.example.beliy;

import com.example.beliy.entity.products;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.beliy.repository.productsRepository;

import java.util.List;


@AllArgsConstructor

@RestController
@RequestMapping("/products")
public class productsController {
    private productsRepository pR;
    @GetMapping("/getAll")
    public List<products> getAllP(){
        System.out.println("ASdjsk");
        return pR.findAll();
    }
    @GetMapping("/getByCategory")
    public List<products> getAllCa(@RequestParam("category") String category){
        return pR.findAllByCategory(category);
    }
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody products p){
        pR.save(p);
        return ResponseEntity.ok("product saved");
    }
}
