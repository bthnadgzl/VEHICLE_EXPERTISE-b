package com.tofas.vehicleExpertize.service.impl;

import com.tofas.vehicleExpertize.service.CacheService;
import com.tofas.vehicleExpertize.util.ExpertiseAppUtils;
import lombok.AllArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class CacheServiceImpl implements CacheService {
    private final static String TOKEN_CACHE = "TOKENS";


    private final CacheManager cacheManager;

    @Override
    public void addTokenToCache(Object cacheValue, String tokenKey) {
        var cacheObject = cacheManager.getCache(TOKEN_CACHE);
        var authTokenValue = cacheObject.get(tokenKey);
        if (isNull(authTokenValue))
            cacheObject.put(tokenKey, cacheValue);
    }


    @Override
    public String getTokenFromCache(String tokenKey) {
        var cacheObject = cacheManager.getCache(TOKEN_CACHE).get(tokenKey);
        return cacheObject.get().toString();
    }

    @Override
    public boolean isTokenCachedExist(String tokenKey) {
        return (cacheManager.getCache(TOKEN_CACHE).get(tokenKey) != null);
    }

    @Override
    public void updateTokenCache(Object cacheValue, String tokenKey) {
        var cacheObject = cacheManager.getCache(TOKEN_CACHE);
        cacheObject.put(tokenKey, cacheValue);
    }

    @Override
    public boolean isCachedTokenExpire(String tokenKey) {
        var cacheObject = cacheManager.getCache(TOKEN_CACHE);

        if (isNull(cacheObject.get(tokenKey)))
            return true;

        String token = cacheObject.get(tokenKey).get().toString();
        return ExpertiseAppUtils.checkIsJWTExpired(token);
    }
}
