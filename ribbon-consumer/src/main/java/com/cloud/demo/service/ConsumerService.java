package com.cloud.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerService {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    //@CacheResult(cacheKeyMethod = "getCacheKey")
    @HystrixCommand(fallbackMethod = "error")
    public String consumer() {
        return restTemplate.getForEntity("http://HELLO-FIRST/index", String.class).getBody();
    }

    public String error() {
        return "error";
    }

    private String getCacheKey() {
        return "key";
    }

}
