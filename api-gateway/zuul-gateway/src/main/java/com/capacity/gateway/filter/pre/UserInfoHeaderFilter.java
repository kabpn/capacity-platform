package com.capacity.gateway.filter.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.FORM_BODY_WRAPPER_FILTER_ORDER;

/**
 * 工程名:capacity-platform
 * 包名:com.capacity.gateway.filter.pre
 * 文件名:UserInfoHeaderFilter
 * description:
 *
 * @author TAO
 * @version V1.0: UserInfoHeaderFilter.java 2019/10/11 14:28 $$
 **/
@Component
public class UserInfoHeaderFilter  extends ZuulFilter {
    /**
     * 在请求前pre或者后post执行
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 多个过滤器的执行顺序，数字越小，表示越先执行
     * @return
     */
    @Override
    public int filterOrder() {
        return FORM_BODY_WRAPPER_FILTER_ORDER - 1;
    }
    /**
     * 当前过滤器是否开启true表示开启
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }
    /**
     * 过滤器内执行的操作 return 任何ojbect的值都表示继续执行
     * setsendzullRespponse(false)表示不再继续执行
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        System.out.println("----------------网关测试----------------------");
        RequestContext requestContext = RequestContext.getCurrentContext();
        //request域
        HttpServletRequest request = requestContext.getRequest();
        //得到头信息
        String header = request.getHeader("Authorization");
        System.out.println(header);
        requestContext.addZuulRequestHeader("token", header);
        return null;
    }
}
