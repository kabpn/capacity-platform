package com.capacity.qa.client;


import com.capacity.qa.client.impl.BaseClientImpl;
import com.capacity.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "base-center", fallback = BaseClientImpl.class)
public interface BaseClient {

    @RequestMapping(value = "/label/{labelId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId);
}
