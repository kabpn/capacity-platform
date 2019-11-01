package com.capacity.qa.controller;


import com.capacity.qa.client.BaseClient;
import com.capacity.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 问题 前端控制器
 * </p>
 *
 * @author yuh
 * @since 2019-10-10
 */
@RestController
@CrossOrigin
@RequestMapping("/problem")
public class TbProblemController {
    @Autowired
    private BaseClient baseClient;

    @RequestMapping(value = "/label/{labelId}", method = RequestMethod.GET)
    public Result findByLabelId(@PathVariable String labelId, HttpServletRequest request){

        Result result = baseClient.findById(labelId);
        return result;
    }
}

