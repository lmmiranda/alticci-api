package com.lmmiranda.alticciapi.controller;

import com.lmmiranda.alticciapi.service.AlticciSequenceService;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("alticci")
public class AlticciSequenceController {

    @GetMapping("{n}")
    public ResponseEntity<BigInteger> calculate(@PathVariable Integer n) {
        BigInteger value = AlticciSequenceService.calculate(n);
        return ResponseEntity.ok().cacheControl(CacheControl.maxAge(10, TimeUnit.SECONDS)).body(value);
    }
}
