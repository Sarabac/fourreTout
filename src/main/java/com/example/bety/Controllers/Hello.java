package com.example.bety.Controllers;

import com.example.bety.Service.Calculateur;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @Autowired
    private Calculateur calculateur;

    @GetMapping("/")
    public ResponseEntity<String> hello_word(){
        return new ResponseEntity<>( "Hello word", HttpStatus.OK);
    }

    @GetMapping("/salut")
    public ResponseEntity<String> salut() {
        return new ResponseEntity<>("bonjour tout le monde", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/add/{a}/{b}")
    public ResponseEntity<Integer> add(@PathVariable Integer a, @PathVariable Integer b) {
        return new ResponseEntity<>(a + b, HttpStatus.OK);

    }

    @GetMapping("/divise/{a}/{b}")
    public ResponseEntity<Float> divise(@PathVariable Float a, @PathVariable Float b) {
        return calculateur.divise(a, b).map(
                aFloat -> new ResponseEntity<>(aFloat, HttpStatus.OK)
        ).orElseGet(
                () -> new ResponseEntity<>(HttpStatus.BAD_REQUEST)
        );
    }
}
