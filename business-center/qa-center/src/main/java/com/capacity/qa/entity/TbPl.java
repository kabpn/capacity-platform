package com.capacity.qa.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuh
 * @since 2019-10-10
 */
@TableName("tb_pl")
public class TbPl implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 问题ID
     */
    private String problemid;

    /**
     * 标签ID
     */
    private String labelid;


    public String getProblemid() {
        return problemid;
    }

    public void setProblemid(String problemid) {
        this.problemid = problemid;
    }

    public String getLabelid() {
        return labelid;
    }

    public void setLabelid(String labelid) {
        this.labelid = labelid;
    }

    @Override
    public String toString() {
        return "TbPl{" +
        "problemid=" + problemid +
        ", labelid=" + labelid +
        "}";
    }
}
