package com.ljw.blog.manage.ctrl;

import com.ljw.blog.common.model.BArticle;
import com.ljw.blog.common.model.ResultBean;
import com.ljw.blog.common.tools.QiNiuTool;
import com.ljw.blog.manage.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static com.ljw.blog.common.tools.QiNiuTool.*;

/**
 * @author: lujunwei
 * @time: 15:03 2019/4/15
 * @des:
 */
@RestController
@RequestMapping(value = "/manage/add")
public class AddCtrl {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/save")
    public String save(@RequestBody BArticle bArticle) {

        //将文章的基本信息插入到数据库

        //上传.md的文件到七牛云
        String fileName = BLOG_ARTICLE + bArticle.getArticleId() + BUCKET_SUFFIX_MD;
        QiNiuTool.inputStreamUpload(fileName, BLOG_STATIC, bArticle.getBackupField01());
        return ResultBean.resultInit(ResultBean.SUCCESS);
    }

    @GetMapping("/aa")
    public BArticle dd(){
        BArticle article = new BArticle();
        article.setArticleType(1);
       return articleService.articleQuery(article).get(0);
    }
}
