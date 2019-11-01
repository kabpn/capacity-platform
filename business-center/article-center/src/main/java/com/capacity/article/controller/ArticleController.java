package com.capacity.article.controller;

import com.capacity.article.entity.TbArticle;
import com.capacity.article.service.ITbArticleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.capacity.entity.PageResult;
import com.capacity.entity.Result;
import com.capacity.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.capacity.util.IdWorker;

import java.util.List;

/**
 * 控制器层
 *
 * @author Administrator
 */
@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ITbArticleService articleService;

    @Autowired
    private IdWorker idWorker;


    /**
     * 查询全部数据
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", articleService.list());
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", articleService.findById(id));
    }


    /**
     * 分页+多条件查询
     *
     * @param article 查询条件封装
     * @param page    页码
     * @param size    页大小
     * @return 分页结果
     */
    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result findSearch(@RequestBody TbArticle article, @PathVariable int page, @PathVariable int size) {
        IPage<TbArticle> pageData = articleService.page(new Page<TbArticle>(page, size), new QueryWrapper<TbArticle>(article));

        return new Result(true, StatusCode.OK, "查询成功", new PageResult<TbArticle>(pageData.getTotal(), pageData.getRecords()));
    }

    /**
     * 根据条件查询
     *
     * @param article
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody TbArticle article) {
        List<TbArticle> list = articleService.list((new QueryWrapper<TbArticle>(article)));
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    /**
     * 增加
     *
     * @param article
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody TbArticle article) {
        article.setId(idWorker.nextId()+"");
        articleService.save(article);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 修改
     *
     * @param article
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@RequestBody TbArticle article, @PathVariable String id) {
        article.setId(id);
        articleService.update(article);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        articleService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

}
