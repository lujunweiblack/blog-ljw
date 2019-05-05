package com.ljw.blog.manage.ctrl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljw.blog.common.model.BArticle;
import com.ljw.blog.common.model.ResultBean;
import com.ljw.blog.manage.api.ArticleFeignClientApi;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author: lujunwei
 * @time: 17:01 2019/4/17
 * @des:
 */
@RestController
@RequestMapping(value = "/manage/article")
@CrossOrigin
public class ManageArticleCtrl {

    @Autowired
    private ArticleFeignClientApi articleFeignClientApi;

    /**
     * @author: lujunwei
     * @param: [bArticle]
     * @return: java.lang.String
     * @time: 17:11 2019/4/17
     * @des: This is a function
     */
    @PostMapping("/upAndDown")
    public String upAndDown(@RequestBody BArticle bArticle) {
        Date sysDate = new Date();
        if (bArticle.getArticleState() == 1) {
            bArticle.setArticleState(1);
            bArticle.setPublishDate(sysDate);
        } else if (bArticle.getArticleState() == 0) {
            bArticle.setArticleState(0);
            bArticle.setPublishDate(null);
        } else {
            bArticle.setArticleState(2);
            bArticle.setPublishDate(null);
        }
        bArticle.setUpdateDate(sysDate);

        articleFeignClientApi.articleInsertByPrimaryKeyAndSql(bArticle);
        return ResultBean.resultInit(ResultBean.SUCCESS);
    }

    /**
     * @author: lujunwei
     * @param: [bArticle]
     * @return: java.lang.String
     * @time: 17:11 2019/4/17
     * @des: This is a function
     */
    @PostMapping("/markDel")
    public String markDel(@RequestBody BArticle bArticle) {
        bArticle.setArticleState(2);
        articleFeignClientApi.articleInsertByPrimaryKey(bArticle);
        bArticle.setUpdateDate(new Date());
        return ResultBean.resultInit(ResultBean.SUCCESS);
    }
    /**
     * @author: lujunwei
     * @param: [article]
     * @return: java.lang.String
     * @time: 12:58 2019/4/17
     * @des: This is a function
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String articleQueryPage(BArticle article, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<BArticle> bArticles = articleFeignClientApi.articleQuery(article);
        return ResultBean.resultInit(ResultBean.SUCCESS, new PageInfo<>(bArticles));
    }
}
