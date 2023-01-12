package com.lmmiranda.alticciapi.controller;

import com.lmmiranda.alticciapi.service.AlticciSequenceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("alticci")
public class AlticciSequenceController {

    @GetMapping("{n}")
    public BigInteger calculate(@PathVariable Integer n) {
        return AlticciSequenceService.calculate(n);
    }
}
