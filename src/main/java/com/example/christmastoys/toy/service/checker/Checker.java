package com.example.christmastoys.toy.service.checker;

import com.example.christmastoys.toy.model.Toy;
import com.example.christmastoys.toy.model.ToyDTO;


public interface Checker {
    ToyDTO process(ToyDTO toyDTO);
}
