package com.lmmiranda.alticciapi.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.lmmiranda.alticciapi.service.exception.BusinessException;

import java.math.BigInteger;

public class AlticciSequenceService {

    private static LoadingCache<Integer, BigInteger> cache = CacheBuilder.newBuilder()
            .maximumSize(200)
            .build(CacheLoader.from(AlticciSequenceService::calculate));

    public static BigInteger calculate(Integer n) {
        BigInteger value = null;
        if (n < 0) {
            throw new BusinessException("invalid.index");
        }

        if (n > 2) {
            value = cache.getUnchecked(n - 3).add(cache.getUnchecked(n - 2));
        } else if (n == 2 || n == 1) {
            value = BigInteger.ONE;
        } else if (n == 0) {
            value = BigInteger.ZERO;
        }

        return value;
    }
}
