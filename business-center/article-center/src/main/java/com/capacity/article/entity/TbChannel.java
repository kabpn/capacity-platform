package com.capacity.article.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 频道
 * </p>
 *
 * @author yuh
 * @since 2019-09-30
 */
@TableName("tb_channel")
public class TbChannel implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * ID
     */
    private String id;

    /**
     * 频道名称
     */
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "TbChannel{" +
        "id=" + id +
        ", name=" + name +
        ", state=" + state +
        "}";
    }
}
