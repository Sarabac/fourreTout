package com.example.bety.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Calculateur {

    public Integer add(Integer a, Integer b) {
        return a + b;
    }

    public Optional<Float> divise(Float a, Float b) {
        if(Float.valueOf(0).equals(b)){
            return Optional.empty();
        }else{
            return Optional.of(a/b);
        }
    }
}
