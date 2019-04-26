package com.ljw.blog.common.tools;

import com.ljw.blog.common.model.SysUser;
import com.ljw.blog.common.vo.MailInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: lujunwei
 * @time: 13:48 2019/4/23
 * @des:
 */
public class DataTools {

    /**
     * @author: lujunwei
     * @param:
     * @return:
     * @time: 13:50 2019/4/23
     * @des: This is a function
     */
    public static boolean dataIsNotNullAndEmpty(Object o) {
        if (o == null || "".equals(o.toString().trim())) {
            return false;
        }
        return true;
    }

    /**
     * @author: lujunwei
     * @param:
     * @return:
     * @time: 17:19 2019/4/26
     * @des: This is a function
     */
    public static MailInfo parsingInputFormat(List<SysUser> users, MailInfo mailInfo) {
        StringBuilder toAddress = new StringBuilder();
        StringBuilder toUserName = new StringBuilder();
        for (SysUser user : users) {
            toAddress.append(user.getEmail()).append(",");
            toUserName.append(user.getUserName()).append(",");
        }
        mailInfo.setToUserName(toUserName.toString().substring(0,toUserName.length()-1));
        mailInfo.setToAddress(toAddress.toString().substring(0,toAddress.length()-1));
        return mailInfo;
    }

    public static void main(String[] args) {
      List<SysUser> list = new ArrayList<>();
         SysUser user = new SysUser();
        user.setEmail("773517966@qq.com");
        user.setUserName("陆军委");
        SysUser user1 = new SysUser();
        user1.setEmail("773517966@qq.com");
        user1.setUserName("中");
        list.add(user);
        list.add(user1);
         MailInfo mailInfo = new MailInfo();
        parsingInputFormat(list,mailInfo);
    }

    /**
     * @author: lujunwei
     * @param:
     * @return:
     * @time: 13:50 2019/4/23
     * @des: This is a function
     */
    public boolean mapIsNotNullAndEmpty(Map<String, Object> map, String key) {
        if (map == null) {
            return false;
        }
        if (!map.containsKey(key)) {
            return false;
        }
        if (!dataIsNotNullAndEmpty(map.get(key))) {
            return false;
        }
        return true;
    }
}
