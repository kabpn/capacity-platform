package com.capacity.qa.client.impl;


import com.capacity.qa.client.BaseClient;
import com.capacity.entity.Result;
import com.capacity.entity.StatusCode;
import org.springframework.stereotype.Component;

@Component
public class BaseClientImpl implements BaseClient {
    @Override
    public Result findById(String labelId) {
        return new Result(false, StatusCode.ERROR, "熔断器触发了！");
    }
}
