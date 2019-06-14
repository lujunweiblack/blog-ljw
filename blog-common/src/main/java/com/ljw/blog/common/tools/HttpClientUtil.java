package com.ljw.blog.common.tools;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.tomcat.util.http.fileupload.disk.DiskFileItem.DEFAULT_CHARSET;

public class HttpClientUtil {

//    public static String doGet(String url) {
//        CloseableHttpClient httpClient = null;
//        HttpGet httpGet = null;
//        HttpResponse httpResponse = null;
//        try {
//            httpClient = HttpClients.createDefault();
//            httpGet = new HttpGet(url);
//            httpResponse = httpClient.execute(httpGet);
//            int statusCode = httpResponse.getStatusLine().getStatusCode();
//            if (statusCode == HttpStatus.SC_OK) {
//                HttpEntity entity = httpResponse.getEntity();
//                String string = EntityUtils.toString(entity, "UTF-8");
//                return string;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (null != httpGet) httpGet.releaseConnection();
//            if (null != httpResponse) {
//                try {
//                    if (null != httpClient) httpClient.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return null;
//    }
//
//    public static String doPost(String url) {
//        CloseableHttpClient httpClient = null;
//        HttpPost httpPost = null;
//        String result = "";
//        try {
//            httpClient = HttpClients.createDefault();
//            httpPost = new HttpPost(url);
//            HttpResponse response = httpClient.execute(httpPost);
//            HttpEntity responseEntity = response.getEntity();
//            result = EntityUtils.toString(responseEntity, "UTF-8");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (null != httpPost) httpPost.releaseConnection();
//            try {
//                if (null != httpClient) httpClient.close();
//            } catch (IOException ioE) {
//
//            }
//        }
//        return result;
//    }
//
//    public static String doPost(String url, JSONObject param) {
//        StringEntity entity = new StringEntity(param.toString(), "UTF-8");
//        entity.setContentType("application/json");
//        return post(url, entity);
//    }
//
//    @Deprecated
//    public static String doPost(String url, Map<String, String> param) throws UnsupportedEncodingException {
//        List<NameValuePair> params = new ArrayList<>();
//        if (null != params) {
//            for (Map.Entry<String, String> entry : param.entrySet()) {
//                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
//            }
//        }
//        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
//        return post(url, entity);
//    }
//
//    public static String doGet(String url, Map<String, String> param) throws UnsupportedEncodingException {
//        List<NameValuePair> params = new ArrayList<>();
//        if (null != params) {
//            for (Map.Entry<String, String> entry : param.entrySet()) {
//                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
//            }
//        }
//        return get(url, new UrlEncodedFormEntity(params, "UTF-8"));
//    }
//
//    private static String post(String url, HttpEntity requestEntity) {
//        CloseableHttpClient client = null;
//        HttpPost post = null;
//        String result = "";
//        try {
//            client = HttpClients.createDefault();
//            post = new HttpPost(url);
//            post.setEntity(requestEntity);
//            HttpResponse response = client.execute(post);
//            HttpEntity responseEntity = response.getEntity();
//            result = EntityUtils.toString(responseEntity, "UTF-8");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (null != post) post.releaseConnection();
//            if (null != client) {
//                try {
//                    client.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return result;
//    }
//
//    private static String get(String url, HttpEntity requestEntity) {
//        CloseableHttpClient client = null;
//        HttpGet get = null;
//        String result = "";
//        try {
//            client = HttpClients.createDefault();
//            get = new HttpGet(url + "?" + EntityUtils.toString(requestEntity, "UTF-8"));
//            HttpResponse response = client.execute(get);
//            HttpEntity responseEntity = response.getEntity();
//            result = EntityUtils.toString(responseEntity, "UTF-8");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (null != get) get.releaseConnection();
//            try {
//                if (null != client) client.close();
//            } catch (IOException ioE) {
//                ioE.printStackTrace();
//            }
//        }
//        return result;
//    }
//
//
//    @Deprecated
//    public static String filePost(String postUrl, String filepath, HashMap<String, String> map) throws Exception {
//        MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE, "----------ThIs_Is_tHe_bouNdaRY_$", Charset.defaultCharset());
//        for (String in : map.keySet()) {
//            multipartEntity.addPart(in, new StringBody(map.get(in), Charset.forName("UTF-8")));
//        }
//        multipartEntity.addPart("avatarFile", new FileBody(new File(filepath), "image/png/jpg"));
//        HttpPost request = new HttpPost(postUrl);
//        request.setEntity(multipartEntity);
//        request.addHeader("Content-Type", "multipart/form-data; boundary=----------ThIs_Is_tHe_bouNdaRY_$");
//        DefaultHttpClient httpClient = new DefaultHttpClient();
//        HttpResponse response = httpClient.execute(request);
//        InputStream is = response.getEntity().getContent();
//        BufferedReader in = new BufferedReader(new InputStreamReader(is));
//        StringBuffer buffer = new StringBuffer();
//        String line;
//        while ((line = in.readLine()) != null) {
//            buffer.append(line);
//        }
//        return buffer.toString();
//    }
//
//    public static String doPost(String url, String filePath, Map<String, String> params) {
//        String result = "";
//        CloseableHttpClient httpClient = null;
//        HttpPost post = null;
//        try {
//            httpClient = HttpClients.createDefault();
//            post = new HttpPost(url);
//            File file = new File(filePath);
//            FileBody avatar = new FileBody(file);
//            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//            builder.addPart("avatar", avatar);
//            for (Map.Entry<String, String> entry : params.entrySet()) {
//                builder.addPart(entry.getKey(), new StringBody(entry.getValue(), ContentType.TEXT_PLAIN.withCharset("UTF-8")));
//            }
//            HttpEntity requestEntity = builder.build();
//            post.setEntity(requestEntity);
//            HttpResponse response = httpClient.execute(post);
//            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
//                result = EntityUtils.toString(response.getEntity(), "UTF-8");
//            else
//                result = response.toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (null != post) post.releaseConnection();
//            if (null != httpClient) {
//                try {
//                    httpClient.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return result;
//    }
//
//    public static String doPost(String url, List<NameValuePair> params,Map<String, String> headers) {
//        String result = "";
//        CloseableHttpClient httpClient = null;
//        HttpPost post = null;
//        try {
//            httpClient = HttpClients.createDefault();
//            post = new HttpPost(url);
//
//             UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(params, "UTF-8");
//            for (Map.Entry<String, String> entry : headers.entrySet()) {
//                post.setHeader(entry.getKey(), entry.getValue());
//            }
//
//            post.setEntity(urlEncodedFormEntity);
//            HttpResponse response = httpClient.execute(post);
//            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
//                result = EntityUtils.toString(response.getEntity(), "UTF-8");
//            else
//                result = response.toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (null != post) post.releaseConnection();
//            if (null != httpClient) {
//                try {
//                    httpClient.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("login", "lujunwei_black@163.com"));
        params.add(new BasicNameValuePair("password", "xtjyie3344521"));
        params.add(new BasicNameValuePair("commit", "Sign+in"));
        params.add(new BasicNameValuePair("authenticity_token", "+PYUHfaVYn+F6iH1lXDdOBzTOxKJmVkHxiXlUysLoWZPcJs5LYDEoUvZgx7Tp8TT4A8lCrOeUN0KylBQM4dZcA=="));
        params.add(new BasicNameValuePair("utf8", "%E2%9C%93"));
        params.add(new BasicNameValuePair("webauthn-support", "supported"));
        map.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        map.put("Accept-Encoding","gzip, deflate, sdch, br");
        map.put("Accept-Language","zh-CN,zh;q=0.9");
        map.put("Cache-Control","max-age=0");
        map.put("Connection","229");
      //  map.put("Content-Length","keep-alive");
        map.put("Content-Type","application/x-www-form-urlencoded");
        map.put("Cookie","_device_id=9e8728bee7be213b4d689a130551487e; has_recent_activity=1; logged_in=no; _ga=GA1.2.1237045449.1560506426; _gat=1; _octo=GH1.1.1357655347.1560506426; tz=Asia%2FShanghai; _gh_sess=bStMSUJLckVxeTd0VC9RZUIzK2Z2eWJ1N0hmRkJZQzFwa0xva2UvR0hPUVdQOCtNdzNsRURPTTBvSzUzek9hWmlLbnYybFljdkVKcXorb0dkN3RVTlVEekp2QkRVc0ZORGlYd1UrMTJtK0RPZWw0Tm9BV2hKMHVLQUF6c25uL1c4d3NDb1FYV0h0L21JT2N1cklBdStjMkhyanYxd2RkREFaOHg1dzhXTXE4VHViblhuM1AyYzZjdjc1Q09hYTZZK2FIeGMvZEZXTkFEVlZBMGdIblVvdFZtVStCNjYxa04xdUxSa09kQXV5ZDNUaTBvTFV6Z2hwL3dJRVB0MG9ZcVo4U2c5bUxka3UxMjMxTUc0TGpTZlp1TXNibjZ1MmdTNjcydDZiSjFtRkhWTUNkeFFEeWFLQ1ZlYVU0REZJNDlIcTk3eVZZcUdUb2t4T3FCR21NMzYxWUVWcjBHbjJHQ3VjNXlaS0kxSzFvVlF5YVJDQmhscjdXKzNodEZKTXVsbE9QRXVuM2hhVGZRR1lNTXgzZWMrQWJ0c2dCcElpU0FMaElYeVpZQ3o3VEEyTWNxWm03bURnb3duOGZib1NsdDZQS0pqa1lTYTl3OVJkMUNIT3hoK2lNa0Q1c0dUeHR4M1F0SUdMeTYvZ1FIbmx2N2IzdncvWGFZT2lnYTE3S0o2ejQyOGlmaWc0ODY1SVpCckRsajZDeVpuRHYzUHI1VFMySks5dU9nSURzV2cvdzAzRms3QzA0Y1BOTDIyNFYxa1UxT284azlhK09WR0I3VTl5YkxPOGRGVTFsb3JrdkhzVXl0MzBuTGFxcGJmWGpCQmpZYmlmeXl2VHNVYmdTY056b3FucTArSXlsWENSWCs4dVpWY21sTk1UR25BRC9KbjBsZC9RYnFXa0JtUkFqZmtNUGwvNGVoQjFkTGg4dUkvaFg1Rkc5Q0RaYnRNYWd6WndqdWVsYTZSUDE1dUhaeTZQdHBnbWNmQzZHaG1jM3dDWDUzTkxvbXYrVDd3WkFKRGV4TklXbW92blVyb01ra0Z4M2wrNDRNdmwzZlpWRTJMa0JNVGhJYk8vMm9yMmtjTWVkYnZISXJ5LzlVay9JaXljKzdYd1NYT3dQWXdTaWZFU1krbHBOekl3elRYZEhWQ1BGeG5CUTNXU1k9LS1vYlFrMkVsRXdGQ2xJVU12WnJZaDdnPT0%3D--0b5913742d6d0ba25827faba509855094ea66b4e");
        map.put("Host","github.com");
        map.put("Origin","https");
        map.put("Referer","https://github.com/login?client_id=f4be0445071889777565&return_to=%2Flogin%2Foauth%2Fauthorize%3Fclient_id%3Df4be0445071889777565%26redirect_uri%3Dhttp%253A%252F%252Flujunwei.com%252Fportal%252Finfo%253FarticleId%253D220029%26scope%3Dpublic_repo");
        map.put("Upgrade-Insecure-Requests","1");
        map.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");
       // System.out.println(doPost("https://github.com/session",params,map));
        RestTemplate restTemplate = new RestTemplate();


        HttpHeaders headers1 = new HttpHeaders();
        headers1.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            headers1.set(entry.getKey(), entry.getValue());
        }
        MultiValueMap<String, String> map2= new LinkedMultiValueMap<String, String>();
        map2.add("email", "first.last@example.com");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map2, headers1);


        ResponseEntity<String> response = restTemplate.postForEntity("https://github.com/session",  request , String.class );
    }
}
