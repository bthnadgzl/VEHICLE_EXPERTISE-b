package com.tofas.vehicleExpertize.service;


public interface CacheService {

     void addTokenToCache(Object cacheValue,String tokenKey);

     String getTokenFromCache(String tokenKey);


    boolean isTokenCachedExist(String tokenKey);

     void updateTokenCache(Object cacheValue, String tokenKey);


     boolean isCachedTokenExpire(String tokenKey);

}
