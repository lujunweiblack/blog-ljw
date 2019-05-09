package com.ljw.blog.common.vo;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author: lujunwei
 * @time: 18:55 2019/5/5
 * @des:
 */
@Data
public class BArticleVo {

        @Id
        private Integer articleId;
        private String articleTitleName;
        private String articleDetailUrl;
        private String articleIntroduction;
        private Integer articleState;
        private Integer articleType;
        private Integer authorId;
        private String authorName;
        private Integer categoryId;
        private String categoryName;
        private Date publishDate;
        private String backupFieldOne;
        private String backupFieldTwo;
        private Date createDate;
        private Date updateDate;
        private Integer pageNum;
        private Integer pageSize;
}
