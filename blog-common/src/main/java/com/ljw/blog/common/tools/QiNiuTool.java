package com.ljw.blog.common.tools;

import com.google.gson.Gson;
import com.ljw.blog.common.vo.QiNiuToken;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: lujunwei
 * @Date: 20:23 2019/4/15
 * @Desc:
 */
public class QiNiuTool {
    public static final String BLOG_ARTICLE = "blog-article";
    public static final String BLOG_STATIC = "blog-static";
    public static final String BLOG_IMAGE = "blog-image";
    public static final String BUCKET_PREFIX_MD = "md/";
    public static final String BUCKET_SUFFIX_MD = ".md";

    private static final String accessKey = "haPHu0pQwFGoYparuOTc5SMepFqY4mIcRrDhXxEb";
    private static final String secretKey = "0CAzx1rNvI0ipHPAJsLHmesGC94EXU30gPPggjB0";

    /**
     * @author: lujunwei
     * @param: fileName, bucket, content
     * @return: String
     * @time: 11:21 2019/4/17
     * @des: This is a function
     */
    public static String inputStreamUpload(String fileName, String bucket, String content) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //String bucket = "blog-article";
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        //String key = "md/20019221122.md";
        try {
            byte[] uploadBytes = content.getBytes("utf-8");
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(uploadBytes);
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(byteInputStream, fileName, upToken, null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
                return putRet.key;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore

                }
            }
        } catch (UnsupportedEncodingException ex) {
            //ignore
        }
        return null;
    }

    /**
     * @author: lujunwei
     * @param:
     * @return: QiNiuToken
     * @time: 18:00 2019/4/22
     * @des: 每次上传图片都会先生成一个token用于七牛上传接口的认证
     */
    public static QiNiuToken getToken() {
        QiNiuToken qiNiu = new QiNiuToken();
        long expireSeconds = 600;
        StringMap putPolicy = new StringMap();
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(BLOG_IMAGE, null, expireSeconds, putPolicy);

        qiNiu.setKey(System.currentTimeMillis()+"");
        qiNiu.setToken(upToken);
        return qiNiu;
    }

    public static void main(String[] args) {
        System.out.println(getToken());
    }
}
