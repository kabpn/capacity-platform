package com.capacity.base.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.capacity.base.entity.TbLabel;
import com.capacity.base.service.ITbLabelService;

import com.capacity.entity.PageResult;
import com.capacity.entity.Result;
import com.capacity.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import com.capacity.util.IdWorker;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/label")
@CrossOrigin
@RefreshScope
public class LabelController {

    @Autowired
    private ITbLabelService labelService;
    @Autowired
    private HttpServletRequest request;


    @Autowired
    private IdWorker idWorker;
    @Value("${ip}")
    private String ip;


    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody TbLabel label) {
        label.setId(idWorker.nextId() + "");
        labelService.save(label);
        return new Result(true, StatusCode.OK, "保存成功");
    }

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        System.out.println("ip为："+ip);
        //获取头信息
        String header = request.getHeader("Authorization");
        System.out.println(header);
        System.out.println();
        List<TbLabel> list = labelService.list();
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String id) {
        System.out.println("222222222222222");
        TbLabel label = labelService.getById(id);
        return new Result(true, StatusCode.OK, "查询成功", label);
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.PUT)
    public Result update(@PathVariable String labelId, @RequestBody TbLabel label) {
        label.setId(labelId);
        labelService.updateById(label);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String labelId) {
        labelService.removeById(labelId);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody TbLabel label) {
        List<TbLabel> list = labelService.list((new QueryWrapper<TbLabel>(label)));
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    @RequestMapping(value = "/search2/{id}", method = RequestMethod.POST)
    public Result findSearch2(@PathVariable long id) {
        QueryWrapper<TbLabel> qw = new QueryWrapper<TbLabel>();
        qw.eq("id", id);

        return new Result(true, StatusCode.OK, "查询成功", labelService.list(qw));
    }

    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result pageQuery(@PathVariable int page, @PathVariable int size, @RequestBody TbLabel label) {
        IPage<TbLabel> pageData = labelService.page(new Page<TbLabel>(page, size), new QueryWrapper<TbLabel>(label));

        return new Result(true, StatusCode.OK, "查询成功", new PageResult<TbLabel>(pageData.getTotal(), pageData.getRecords()));
    }


}
