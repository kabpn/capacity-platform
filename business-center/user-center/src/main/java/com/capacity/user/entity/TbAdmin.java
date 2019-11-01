package com.capacity.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 管理员
 * </p>
 *
 * @author yuh
 * @since 2019-10-09
 */
@TableName("tb_admin")
public class TbAdmin implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * ID
     */
    private String id;

    /**
     * 登陆名称
     */
    private String loginname;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态
     */
    private String state;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "TbAdmin{" +
        "id=" + id +
        ", loginname=" + loginname +
        ", password=" + password +
        ", state=" + state +
        "}";
    }
}
