package com.example.ex_bbs.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.ex_bbs.domain.Article;

/**
 * articlesテーブルから記事を取得する
 */
@Repository
public class ArticleRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;
    /**
     * articlesテーブル1行 → Articleオブジェクト変換
     */
    private static final RowMapper<Article> ARTICLE_ROW_MAPPER = (rs, i) -> {
        Article article = new Article();
        article.setId(rs.getInt("id"));
        article.setName(rs.getString("name"));
        article.setContent(rs.getString("content"));
        return article;
    };
    /**
     * 記事全件取得（新しい順）
     */
    public List<Article> findAll() {
        String sql = "SELECT id, name, content FROM articles ORDER BY id DESC";
        return template.query(sql, ARTICLE_ROW_MAPPER);
    }
}
