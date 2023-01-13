package com.lmmiranda.alticciapi.controller;

import com.lmmiranda.alticciapi.controller.openapi.AlticciSequenceControllerOpenApi;
import com.lmmiranda.alticciapi.service.AlticciSequenceService;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("alticci")
public class AlticciSequenceController implements AlticciSequenceControllerOpenApi {

    @CrossOrigin
    @GetMapping("{n}")
    public ResponseEntity<BigInteger> calculate(@PathVariable Integer n) {
        BigInteger value = AlticciSequenceService.calculate(n);
        return ResponseEntity.ok().cacheControl(CacheControl.maxAge(10, TimeUnit.SECONDS)).body(value);
    }
}
