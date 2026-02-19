package com.example.ex_bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ex_bbs.Repository.ArticleRepository;
import com.example.ex_bbs.domain.Article;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    /**
     * 記事一覧表示
     */
    @RequestMapping("")
    public String index(Model model) {
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articleList", articleList);
        return "article-list";
    }

    /**
     * 記事を新規追加する
     * 
     * @param name 髙橋昂秀
     * @return 記事一覧画面にリダイレクトする
     */

    @PostMapping("/add")
    public String add(@RequestParam("name") String name,@RequestParam("content") String content) {

        Article article = new Article();
        article.setName(name);
        article.setContent(content);

        articleRepository.insert(article);

        // 二重送信防止＆一覧再表示
        return "redirect:/article";
    }
}
