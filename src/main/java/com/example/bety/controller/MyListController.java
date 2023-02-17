package com.example.bety.controller;

import com.example.bety.model.MyList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyListController {

    MyList myList=new MyList(1000);


    @GetMapping("/MLadd/{a}")
    public ResponseEntity<Boolean> MLadd(@PathVariable String a) {
        return new ResponseEntity<>(myList.add(a), HttpStatus.OK);
    }

    @GetMapping("/MLsize")
    public ResponseEntity<Integer> MLsize() {
        return new ResponseEntity<>(myList.size(), HttpStatus.OK);
    }
}
