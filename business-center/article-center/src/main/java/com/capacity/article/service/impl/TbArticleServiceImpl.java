package com.capacity.article.service.impl;

import com.capacity.article.entity.TbArticle;
import com.capacity.article.mapper.TbArticleMapper;
import com.capacity.article.service.ITbArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 文章 服务实现类
 * </p>
 *
 * @author yuh
 * @since 2019-09-30
 */
@Service
public class TbArticleServiceImpl extends ServiceImpl<TbArticleMapper, TbArticle> implements ITbArticleService {

    @Autowired
    private TbArticleMapper articleDao;


    @Autowired
    private RedisTemplate redisTemplate;



    /**
     * 根据ID查询实体
     * @param id
     * @return
     */
    public TbArticle findById(String id) {
        //先从缓存中拿数据
        TbArticle article = (TbArticle)redisTemplate.opsForValue().get("article_"+id);
        //如果拿不到，就去数据库中查询
        if (article==null){
            article = articleDao.selectById(id);
            //放入缓存中
            redisTemplate.opsForValue().set("article_"+id, article, 20, TimeUnit.SECONDS);
        }
        return article;
    }


    /**
     * 修改
     * @param article
     */
    public void update(TbArticle article) {
        //清除缓存中的数据
        redisTemplate.delete("article_"+article.getId());
        articleDao.insert(article);
    }

    /**
     * 删除
     * @param id
     */
    public void deleteById(String id) {
        //清除缓存中的数据
        redisTemplate.delete("article_"+id);
        articleDao.deleteById(id);
    }
}
