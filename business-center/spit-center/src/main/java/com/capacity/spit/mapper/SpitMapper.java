package com.capacity.spit.mapper;


import com.capacity.spit.entity.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpitMapper extends MongoRepository<Spit, String> {

    public Page<Spit> findByParentid(String parentid, Pageable pageable);
}
