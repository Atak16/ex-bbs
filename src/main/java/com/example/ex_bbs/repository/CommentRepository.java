package com.example.ex_bbs.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.ex_bbs.domain.Comment;

/**
 * コメント情報を管理するリポジトリクラス
 * 
 * @Author Akihide Takahashi
 * 
 * @return コメント一覧
 */
@Repository
public class CommentRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private final RowMapper<Comment> COMMENT_ROW_MAPPER = (rs, i) -> {
        Comment comment = new Comment();
        comment.setId(rs.getInt("id"));
        comment.setName(rs.getString("name"));
        comment.setContent(rs.getString("content"));
        comment.setArticleId(rs.getInt("article_id"));
        return comment;
    };

    /**
     * 記事に紐づくコメントを全件取得
     * 
     * @return ID の降順で取得したコメント一覧
     */
    public List<Comment> findByArticleId(Integer articleId) {
        String sql = "SELECT id, name, content, article_id FROM comments WHERE article_id = :articleId ORDER BY id DESC";
        Map<String, Object> param = new HashMap<>();
        param.put("articleId", articleId);
        return template.query(sql, param, COMMENT_ROW_MAPPER);
    }

    /**
     * コメントを投稿
     * 
     * @param comment 投稿するコメント情報
     */
    public void insert(Comment comment) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(comment);
        String sql = "INSERT INTO comments (name, content, article_id) VALUES (:name, :content, :articleId)";
        template.update(sql, param);
    }
}
