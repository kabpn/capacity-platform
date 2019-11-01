package com.capacity.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 城市
 * </p>
 *
 * @author yuh
 * @since 2019-09-29
 */
@TableName("tb_city")
public class TbCity implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * ID
     */
    private String id;

    /**
     * 城市名称
     */
    private String name;

    /**
     * 是否热门
     */
    private String ishot;


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

    public String getIshot() {
        return ishot;
    }

    public void setIshot(String ishot) {
        this.ishot = ishot;
    }

    @Override
    public String toString() {
        return "TbCity{" +
        "id=" + id +
        ", name=" + name +
        ", ishot=" + ishot +
        "}";
    }
}
