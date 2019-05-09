package com.ljw.blog.manage.ctrl;

import java.util.Date;

import com.ljw.blog.common.model.BArticle;
import com.ljw.blog.common.model.ResultBean;
import com.ljw.blog.common.model.SysUser;
import com.ljw.blog.common.tools.QiNiuTool;
import com.ljw.blog.manage.api.ArticleFeignClientApi;
import com.ljw.blog.manage.api.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.ljw.blog.common.constant.JwtCon.JWT_TOKEN_SYS_USER_ID;
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

    @Autowired
    private UserApi userApi;

    /**
     * @author: lujunwei
     * @param: []
     * @return: java.lang.String
     * @time: 13:39 2019/4/23
     * @des: This is a function
     */
    @PostMapping("/articleiNextId")
    public String articleiNextId() {

        //获取递增主键
        int articleId = articleFeignClientApi.articleiNextId();
        return ResultBean.resultInit(ResultBean.SUCCESS, articleId);
    }

    /**
     * @author: lujunwei
     * @param: [bArticle]
     * @return: java.lang.String
     * @time: 11:21 2019/4/17
     * @des: This is a function
     */
    @PostMapping("/complete")
    public String save(@RequestBody BArticle bArticle, HttpServletRequest request) {

        //上传.md的文件到七牛云
        String fileName = BUCKET_PREFIX_MD + bArticle.getArticleId() + BUCKET_SUFFIX_MD;
        QiNiuTool.inputStreamUpload(fileName, BLOG_ARTICLE, bArticle.getBackupFieldOne());
        SysUser user = new SysUser();
        user.setId(Integer.parseInt(request.getAttribute(JWT_TOKEN_SYS_USER_ID).toString()));
        SysUser userByUser = userApi.findUserByUser(user);
        /*-----------临时设置基本数据------------*/
        Date sysDate = new Date();
        bArticle.setArticleId(bArticle.getArticleId());
        bArticle.setArticleDetailUrl(fileName);
        bArticle.setAuthorId(userByUser.getId());
        bArticle.setAuthorName(userByUser.getUserName());
        bArticle.setCategoryId(10000913);
        bArticle.setCategoryName("陆军委组织");
        bArticle.setPublishDate(bArticle.getArticleState() == 1 ? sysDate : null);
        bArticle.setCreateDate(sysDate);
        bArticle.setUpdateDate(sysDate);
        /*-----------临时设置基本数据------------*/

        //将文章的基本信息插入到数据库
        articleFeignClientApi.articleInsertByPrimaryKey(bArticle);
        return ResultBean.resultInit(ResultBean.SUCCESS);
    }

    /**
     * @author: lujunwei
     * @param: [bArticle]
     * @return: java.lang.String
     * @time: 13:22 2019/4/23
     * @des: This is a function
     */
    @PostMapping("/save")
    public String edit(@RequestBody BArticle bArticle) {

        //修改文章-文件名称一样 等同于修改
        String fileName = BUCKET_PREFIX_MD + bArticle.getArticleId() + BUCKET_SUFFIX_MD;
        QiNiuTool.inputStreamUpload(fileName, BLOG_ARTICLE, bArticle.getBackupFieldOne());

        //根据主键查询
        BArticle queryBArticle = articleFeignClientApi.articleQuery(bArticle).get(0);

        //修改文章信息
        queryBArticle.setUpdateDate(new Date());
        queryBArticle.setBackupFieldOne(bArticle.getBackupFieldOne());
        articleFeignClientApi.articleInsertByPrimaryKey(queryBArticle);
        return ResultBean.resultInit(ResultBean.SUCCESS);
    }

    /**
     * @author: lujunwei
     * @param:
     * @return:
     * @time: 17:23 2019/4/22
     * @des: 获取上传图片的token
     */
    @PostMapping("/image/token")
    public String imageUpload() {
        return ResultBean.resultInit(ResultBean.SUCCESS, QiNiuTool.getToken());
    }

}
