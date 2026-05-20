package com.example.ex_bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ex_bbs.domain.Article;
import com.example.ex_bbs.repository.ArticleRepository;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/article")
public class ArticleController {
    //ArticleRepositoryを注入
    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping("")
    public String index(Model model) {
        // 記事全件をList型で格納
        List<Article> articleList = articleRepository.findAll();
        // 画面側に使えるようにModelに格納
        model.addAttribute("articleList", articleList);
        return "article";
    }
}
