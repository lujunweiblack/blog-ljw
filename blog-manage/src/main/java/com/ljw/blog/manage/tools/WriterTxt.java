package com.ljw.blog.manage.tools;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: lujunwei
 * @time: 16:34 2019/4/19
 * @des:
 */
public class WriterTxt {

    public static String writerTxt(List<Map<String, Object>> param, String filePath) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File file = new File(filePath);
            File fileParent = file.getParentFile();
            if (!fileParent.exists()) {
                fileParent.mkdirs();
            }
            file.createNewFile();

            StringBuffer write = new StringBuffer();
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));

            //植入判断
            for (Map<String, Object> pa : param) {
                write.append(pa.get("key1").toString());
            }

            //设置编码 防止中文乱码
            String str = new String(write.toString().getBytes(), "gbk");
            bufferedOutputStream.write(str.getBytes("gbk"));
            bufferedOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedOutputStream != null)
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return "完成";
    }

    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> param = new HashMap<>();
        param.put("key1", "测试");
        list.add(param);
        WriterTxt.writerTxt(list, "D:\\WriterTxt\\测试.txt");
    }
}
