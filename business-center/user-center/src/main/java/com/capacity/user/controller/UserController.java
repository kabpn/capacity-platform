package com.capacity.user.controller;
import com.capacity.user.entity.TbUser;
import com.capacity.user.service.ITbUserService;
import com.capacity.entity.Result;
import com.capacity.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	@Autowired
	private ITbUserService userService;

	@Autowired
	private RedisTemplate redisTemplate;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Result login(@RequestBody TbUser user){
		user = userService.login(user.getMobile(), user.getPassword());
		if(user==null){
			return new Result(false, StatusCode.LOGINERROR, "登录失败");
		}
//		String token = jwtUtil.createJWT(user.getId(), user.getMobile(), "user");
//		Map<String, Object> map = new HashMap<>();
//		map.put("token", token);
//		map.put("roles", "user");
//		return new Result(true, StatusCode.OK, "登录成功", map);
		return new Result(true, StatusCode.OK, "登录成功");
	}

	/**
	 * 发送短信验证码
	 */
	@RequestMapping(value = "/sendsms/{mobile}", method = RequestMethod.POST)
	public Result sendSms(@PathVariable String mobile){
		userService.sendSms(mobile);
		return new Result(true, StatusCode.OK, "发送成功");
	}

	/**
	 * 注册
	 * @return
	 */
	@RequestMapping(value = "/register/{code}", method = RequestMethod.POST)
	public Result regist(@PathVariable String code, @RequestBody TbUser user){
		//得到缓存中的验证码
		String checkcodeRedis = (String) redisTemplate.opsForValue().get("checkcode_" + user.getMobile());
		if(checkcodeRedis.isEmpty()){
			return new Result(false, StatusCode.ERROR, "请先获取手机验证码");
		}
		if(!checkcodeRedis.equals(code)){
			return new Result(false, StatusCode.ERROR, "请输入正确的验证码");
		}
		userService.add(user);
		return new Result(true, StatusCode.OK, "注册成功");
	}

	
}
