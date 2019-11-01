package com.capacity.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.capacity.user.entity.TbUser;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author yuh
 * @since 2019-10-09
 */
public interface ITbUserService extends IService<TbUser> {
    public void sendSms(String mobile);

    public void add(TbUser user);

    public TbUser login(String mobile, String password);

}
