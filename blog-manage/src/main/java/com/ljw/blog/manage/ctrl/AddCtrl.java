package com.ljw.blog.manage.ctrl;
import java.util.Date;

import com.ljw.blog.common.model.BArticle;
import com.ljw.blog.common.model.ResultBean;
import com.ljw.blog.common.tools.QiNiuTool;
import com.ljw.blog.manage.api.ArticleFeignClientApi;
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
@CrossOrigin
public class AddCtrl {

    @Autowired
    private ArticleFeignClientApi articleFeignClientApi;


    /**
     * @author: lujunwei
     * @param: [bArticle]
     * @return: java.lang.String
     * @time: 11:21 2019/4/17
     * @des: This is a function
     */
    @PostMapping("/save")
    public String save(@RequestBody BArticle bArticle) {

        //获取递增主键
        int articleId = articleFeignClientApi.articleiNextId();
        //上传.md的文件到七牛云
        String fileName = BUCKET_PREFIX_MD + articleId + BUCKET_SUFFIX_MD;
        QiNiuTool.inputStreamUpload(fileName, BLOG_ARTICLE, bArticle.getBackupFieldOne());
        //临时设置基本数据
        Date sysDate = new Date();
        bArticle.setArticleId(articleId);
        bArticle.setArticleDetailUrl(fileName);
        bArticle.setArticleType(1);
        bArticle.setAuthorId(20190016);
        bArticle.setAuthorName("lujunwei");
        bArticle.setCategoryId(10000913);
        bArticle.setCategoryName("陆军委组织");
        bArticle.setCreateDate(sysDate);
        bArticle.setUpdateDate(sysDate);

        //将文章的基本信息插入到数据库
        articleFeignClientApi.articleInsertByPrimaryKey(bArticle);
        return ResultBean.resultInit(ResultBean.SUCCESS);
    }

}
