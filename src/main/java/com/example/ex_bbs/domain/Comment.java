package com.example.ex_bbs.domain;
/**
 * コメント情報を表すドメインクラスです。
 * 
 * @Author 髙橋昂秀
 */
public class Comment {
    /** コメントID */
    private Integer id;
     /** コメント者名 */
    private String name;
     /** コメント内容 */
    private String content;
     /** 紐づく記事ID */
    private Integer articleId;
    
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
     public Integer getArticleId() {
         return articleId;
     }
     public void setArticleId(Integer articleId) {
         this.articleId = articleId;
     }
}
