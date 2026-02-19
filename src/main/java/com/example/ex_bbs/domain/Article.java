package com.example.ex_bbs.domain;

import java.util.List;
/**
 * 記事情報を表すドメインクラスです。
 * 
 * @Author 髙橋昂秀
 */
public class Article {
    /** 投稿ID */
    private Integer id;
    /** 投稿者名 */
    private String name;
    /** 記事内容 */
    private String content;
    /** この記事に紐づくコメント一覧 */
    private List<Comment> commentList;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public List<Comment> getCommentList() {
        return commentList;
    }
    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
