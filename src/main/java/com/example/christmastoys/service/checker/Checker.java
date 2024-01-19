package com.example.christmastoys.service.checker;

import com.example.christmastoys.model.ToyDTO;


public interface Checker {
    ToyDTO process(ToyDTO toyDTO);
}
