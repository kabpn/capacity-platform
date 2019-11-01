package com.capacity.article.service;

import com.capacity.article.entity.TbArticle;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 文章 服务类
 * </p>
 *
 * @author yuh
 * @since 2019-09-30
 */
public interface ITbArticleService extends IService<TbArticle> {
    void update(TbArticle article);
     void deleteById(String id) ;
    TbArticle findById(String id);

}
