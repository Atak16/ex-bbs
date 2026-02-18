package com.example.ex_bbs.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.ex_bbs.domain.Comment;

@Repository
public class CommentRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;
    /**
     * commentsテーブル1行 → Commentオブジェクト変換
     */
    private static final RowMapper<Comment> COMMENT_ROW_MAPPER = (rs, i) -> {
        Comment comment = new Comment();
        comment.setId(rs.getInt("id"));
        comment.setName(rs.getString("name"));
        comment.setContent(rs.getString("content"));
        comment.setArticleId(rs.getInt("article_id"));
        return comment;
    };
//     /**
//      * 記事IDに紐づくコメント一覧取得
//      */
//     public List<Comment> findByArticleId(Integer articleId) {
//         String sql = "SELECT id, name, content, article_id FROM comment WHERE article_id = :articleId ORDER BY id DESC";
//         MapSqlParameterSource param = new MapSqlParameterSource().addValue("articleId", articleId);
//         return template.addValue(sql, COMMENT_ROW_MAPPER, "articleId", articleId);
//     }
}
