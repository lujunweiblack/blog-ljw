package com.ljw.blog.common.tools;

import com.alibaba.fastjson.JSONObject;
import com.ljw.blog.common.vo.IssuesDto;
import com.ljw.blog.common.vo.RestTemplateParam;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: lujunwei
 * @Date: 19:26 2019/6/15
 * @Desc:
 */
public class RestTemplateTools {

    public static void main(String[] args) {
        String[] s = new String[]{"13","14","18","23","25","27","220028","220029","220030","220031","220032","220035"};
        for (int i = 0; i < s.length; i++) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
            httpHeaders.add("Accept", "application/vnd.github.symmetra-preview+json");
            httpHeaders.add("Authorization", "token 0d855bd004d447fc4f1be61d8dc562ac86e307cb");
            IssuesDto issuesDto = new IssuesDto();
            issuesDto.setTitle("傻不拉几的二哈 - " + s[i]);
            issuesDto.setBody("Automatically initialize article reviews");
            issuesDto.setLabels(new String[]{s[i], "Gitalk"});
            RestTemplateParam restTemplateParam = new RestTemplateParam();
            restTemplateParam.setHeaders(httpHeaders);
            restTemplateParam.setUrl("https://api.github.com/repos/lujunweiblack/blog-ljw-gitalk/issues");
            restTemplateParam.setParam(issuesDto);
            JSONObject jsonObject = sendPost(restTemplateParam);
            System.out.println(jsonObject);
        }

    }

    /**
     * @author: lujunwei
     * @param: RestTemplateParam
     * @return: JSONObject
     * @time: 19:55 2019/6/15
     * @des: post 方法  基于创建github的issues所设计
     */
    public static JSONObject sendPost(RestTemplateParam restTemplateParam) {
        return new RestTemplate().postForObject(restTemplateParam.getUrl(), new HttpEntity<>(JSONObject.toJSONString(restTemplateParam.getParam()), restTemplateParam.getHeaders()), JSONObject.class);
    }

    /**
     * @author: lujunwei
     * @time: 0:43 2019/6/16
     * @des: This is a function
     */
    public static HttpHeaders fillheaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
        httpHeaders.add("Accept", "application/vnd.github.symmetra-preview+json");
        httpHeaders.add("Authorization", "token 0d855bd004d447fc4f1be61d8dc562ac86e307cb");
        return httpHeaders;
    }
}
