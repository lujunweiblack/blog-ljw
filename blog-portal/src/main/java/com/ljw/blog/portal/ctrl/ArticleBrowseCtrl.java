package com.ljw.blog.portal.ctrl;

/**
 * @author: lujunwei
 * @time: 11:20 2019/5/24
 * @des:
 */

import com.ljw.blog.common.model.BArticleBrowse;
import com.ljw.blog.common.model.ResultBean;
import com.ljw.blog.portal.api.ArticleBrowseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lujunwei
 * @time: 13:41 2019/3/20
 * @des:
 */
@RestController
@RequestMapping(value = "/portal")
public class ArticleBrowseCtrl {

    @Autowired
    private ArticleBrowseApi articleBrowseApi;

    /**
     * @author: lujunwei
     * @param:
     * @return:
     * @time: 13:31 2019/5/24
     * @des: 记录文章的访问量
     */
    @RequestMapping(value = "/browse", method = RequestMethod.POST)
    public String articleBrowse(@RequestBody BArticleBrowse articleBrowse){
        try {
            //根据客户端信息判断当前用户当天是否是第一次访问此文章
            if(articleBrowseApi.articleBrowseDistinct(articleBrowse) != 0){
                return ResultBean.resultInit(ResultBean.SUCCESS);
            }
            articleBrowseApi.articleBrowseInsert(articleBrowse);
            return ResultBean.resultInit(ResultBean.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return ResultBean.resultInit(ResultBean.ERROR);
        }

    }

}
