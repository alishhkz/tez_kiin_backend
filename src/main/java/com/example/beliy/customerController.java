package com.example.beliy;

import com.example.beliy.entity.users;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.beliy.repository.customerRepository;
import com.example.beliy.services.customerService;

import java.io.IOException;


@AllArgsConstructor

@RestController
@RequestMapping("/users")
public class customerController {
    private customerRepository cR;
    private customerService cS;
    @GetMapping("/getC")
    public ResponseEntity<String> getC(@RequestParam("login") String login,
                                       @RequestParam("password") String password) throws IOException {

        boolean as =cS.checkUserExists(login, password);

        if(as){
            return ResponseEntity.ok("user exists");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User not found");
        }
    }
    @PostMapping("/save")
    public users saveC(@RequestBody users c){
            return cR.save(c);
    }
   @PutMapping("/change")
    public ResponseEntity<String> change(@RequestParam("login") String login,
                                         @RequestParam("password") String newpassword){

       users q =cR.existsByLogin(login);
       boolean as = false;
       if(q== null){as =true;}
       if(as){
           cS.changePassword(login,newpassword);
           return ResponseEntity.ok("changed successfully");
       }else{
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User not found");
       }

    }
}
