package com.ljw.blog.portal.ctrl;


import com.ljw.blog.common.model.BArticle;
import com.ljw.blog.portal.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: lujunwei
 * @time: 13:41 2019/3/20
 * @des:
 */
@RestController
@RequestMapping(value = "/article")
public class ArticleCtrl {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET)
    public List<BArticle> articleQuery(BArticle article) {
        return articleService.articleQuery(article);
    }
}
