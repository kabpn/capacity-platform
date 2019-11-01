package com.capacity.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.capacity.user.entity.TbUser;
import com.capacity.user.mapper.TbUserMapper;
import com.capacity.user.service.ITbUserService;
import com.capacity.util.IdWorker;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author yuh
 * @since 2019-10-09
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements ITbUserService {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private TbUserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder encoder;


    @Autowired
    private IdWorker idWorker;
    public void sendSms(String mobile) {
        //生成六位数字随机数
        String checkcode = RandomStringUtils.randomNumeric(6);
        //向缓存中放一份
        redisTemplate.opsForValue().set("checkcode_"+mobile, checkcode, 6, TimeUnit.HOURS);
        //给用户发一份
        Map<String, String> map = new HashMap<>();
        map.put("mobile", mobile);
        map.put("checkcode", checkcode);
        rabbitTemplate.convertAndSend("sms", map);
        //在控制台显示一份【方便测试】
        System.out.println("验证码为："+checkcode);
    }

    @Override
    public void add(TbUser user) {
        user.setId( idWorker.nextId()+"" );
        //密码加密
        user.setPassword(encoder.encode(user.getPassword()));
        user.setFollowcount(0);//关注数
        user.setFanscount(0);//粉丝数
        user.setOnline(0L);//在线时长
        user.setRegdate(new Date());//注册日期
        user.setUpdatedate(new Date());//更新日期
        user.setLastdate(new Date());//最后登陆日期
        userMapper.insert(user);
    }
    @Override
    public TbUser login(String mobile, String password) {
        TbUser user = userMapper.selectOne(new QueryWrapper<TbUser>().eq("mobile",mobile));
        if(user!=null && encoder.matches(password, user.getPassword())){
            return user;
        }
        return null;
    }
}
