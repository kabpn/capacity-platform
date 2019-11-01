package com.capacity.qa.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 问题
 * </p>
 *
 * @author yuh
 * @since 2019-10-10
 */
@TableName("tb_problem")
public class TbProblem implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * ID
     */
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建日期
     */
    private LocalDateTime createtime;

    /**
     * 修改日期
     */
    private LocalDateTime updatetime;

    /**
     * 用户ID
     */
    private String userid;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 浏览量
     */
    private Long visits;

    /**
     * 点赞数
     */
    private Long thumbup;

    /**
     * 回复数
     */
    private Long reply;

    /**
     * 是否解决
     */
    private String solve;

    /**
     * 回复人昵称
     */
    private String replyname;

    /**
     * 回复日期
     */
    private LocalDateTime replytime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    public LocalDateTime getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(LocalDateTime updatetime) {
        this.updatetime = updatetime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getVisits() {
        return visits;
    }

    public void setVisits(Long visits) {
        this.visits = visits;
    }

    public Long getThumbup() {
        return thumbup;
    }

    public void setThumbup(Long thumbup) {
        this.thumbup = thumbup;
    }

    public Long getReply() {
        return reply;
    }

    public void setReply(Long reply) {
        this.reply = reply;
    }

    public String getSolve() {
        return solve;
    }

    public void setSolve(String solve) {
        this.solve = solve;
    }

    public String getReplyname() {
        return replyname;
    }

    public void setReplyname(String replyname) {
        this.replyname = replyname;
    }

    public LocalDateTime getReplytime() {
        return replytime;
    }

    public void setReplytime(LocalDateTime replytime) {
        this.replytime = replytime;
    }

    @Override
    public String toString() {
        return "TbProblem{" +
        "id=" + id +
        ", title=" + title +
        ", content=" + content +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        ", userid=" + userid +
        ", nickname=" + nickname +
        ", visits=" + visits +
        ", thumbup=" + thumbup +
        ", reply=" + reply +
        ", solve=" + solve +
        ", replyname=" + replyname +
        ", replytime=" + replytime +
        "}";
    }
}
