package com.capacity.search.dao;


import com.capacity.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
//这是一个测试
public interface ArticleDao extends ElasticsearchRepository<Article, String> {

    public Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);
}
