package com.lmmiranda.alticciapi.controller.openapi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigInteger;

@Api(tags = "Alticci")
public interface AlticciSequenceControllerOpenApi {

    @ApiOperation("Returns the value that corresponds to the index n.")
    ResponseEntity<BigInteger> calculate(@ApiParam("represents the index of the sequence’s value to return.") @PathVariable Integer n);
}
