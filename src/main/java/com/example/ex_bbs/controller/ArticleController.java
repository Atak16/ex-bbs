package com.example.ex_bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ex_bbs.domain.Article;
import com.example.ex_bbs.form.ArticleForm;
import com.example.ex_bbs.repository.ArticleRepository;

import org.springframework.ui.Model;

/**
 * 記事情報を表示するコントローラクラス
 * 
 * @author Akihide Takahashi
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    /**
     * 記事一覧画面を表示
     * @param model
     */
    @GetMapping("")
    public String index(Model model) {
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articleList", articleList);
        return "article";
    }

    /**
     * 記事を投稿
     * @param form
     */
    @PostMapping("/insert")
    public String insert(ArticleForm form) {
        Article article = new Article();
        article.setName(form.getName());
        article.setContent(form.getContent());
        articleRepository.insert(article);
        return "redirect:/article";
    }
}
