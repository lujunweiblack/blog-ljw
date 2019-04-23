package com.ljw.blog.common.tools;

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
