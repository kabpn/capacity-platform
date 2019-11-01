package com.capacity.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.capacity.user.entity.TbAdmin;
import com.capacity.user.mapper.TbAdminMapper;
import com.capacity.user.service.ITbAdminService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员 服务实现类
 * </p>
 *
 * @author yuh
 * @since 2019-10-09
 */
@Service
public class TbAdminServiceImpl extends ServiceImpl<TbAdminMapper, TbAdmin> implements ITbAdminService {

}
