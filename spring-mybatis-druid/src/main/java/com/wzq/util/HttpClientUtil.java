package com.wzq.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.*;

/**
 * 类描述:
 * http请求相关方法
 *
 * @author 顺丰科技开源(opensource@sfmail.sf-express.com)
 * @version 1.0.0
 * @date 2018-4-14 13:55:36
*/
@Slf4j
public class HttpClientUtil {
	/**
	 *
	 * @param url 请求连接
	 * @param paramMap 请求参数
	 * @return 响应结果
	 * @throws IOException IO异常
	 */
	public static String post(String url, Map<String,String> paramMap) throws IOException {
        CloseableHttpClient httpClient = null;
        HttpResponse response;
        HttpPost httpPost;
        String result = null;
        try {
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            //有参数的post提交
            if (paramMap!=null){
                List<NameValuePair> list = new ArrayList<>(0);
                for (Map.Entry<String, String> elem : paramMap.entrySet()) {
                    list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
                }
                if(!list.isEmpty()){
                    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8");
                    httpPost.setEntity(entity);
                }
            }
            //发送HttpClient请求，获得响应
            response = httpClient.execute(httpPost);
            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,"UTF-8");
                }
            }
        } finally {
            try {
                if(httpClient!=null){
                    httpClient.close();
                }
            } catch (IOException e) {
                log.error("notify Handler trigger exception", e);
            }
        }
        return result;
    }
    /**
    *
    * @param url 请求连接
    * @param paramJson 请求参数
    * @return 响应结果
    * @throws IOException IO异常
    * @throws URISyntaxException URI格式不正确异常
    */
   public static String get(String url,JSONObject paramJson) throws URISyntaxException, IOException {
       CloseableHttpClient httpClient = null;
       HttpResponse response;
       HttpGet httpGet;
       String result = null;
       URI uri = null;
       try {
           httpClient = HttpClients.createDefault();

           //如果请求有参数
           URIBuilder uriBuilder = new URIBuilder(url);
           if (paramJson!=null){
               Set<String> keys = paramJson.keySet();
               for (String key : keys) {
            	   uriBuilder.addParameter(key,(String) paramJson.get(key));
               }
           }
           uri = uriBuilder.build();
           httpGet = new HttpGet(uri);

           //发送HttpClient请求，获得响应
           response = httpClient.execute(httpGet);
           if(response != null){
               HttpEntity resEntity = response.getEntity();
               if(resEntity != null){
                   result = EntityUtils.toString(resEntity,"UTF-8");
               }
           }
       } finally {
           try {
               if(httpClient!=null){
                   httpClient.close();
               }
           } catch (IOException e) {
               log.error("notify Handler trigger exception", e);
           }
       }
       return result;
   }

   /**
    * 无参数的Get请求
    * @param url 请求连接
    * @return 响应结果
    * @throws IOException IO异常
    * @throws URISyntaxException URI格式不正确异常
    */
   public static String get(String url) throws IOException, URISyntaxException {
       return get(url,null);
   }

    public static String postJSON(String url, Map<String,String> paramMap) throws IOException {
        CloseableHttpClient httpClient = null;
        HttpResponse response;
        HttpPost httpPost;
        String result = null;
        try {
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            //有参数的post提交
            if (paramMap!=null){
                List<NameValuePair> list = new ArrayList<>(0);
                for (Map.Entry<String, String> elem : paramMap.entrySet()) {
                    list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
                }
                if(!list.isEmpty()){
                    httpPost.addHeader("Content-type","application/json; charset=utf-8");
                    httpPost.setHeader("Accept", "application/json");
                    httpPost.setEntity(new StringEntity(JSON.toJSONString(paramMap), Charset.forName("UTF-8")));
                }
            }

            //发送HttpClient请求，获得响应
            response = httpClient.execute(httpPost);
            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,"UTF-8");
                }
            }
        } finally {
            try {
                if(httpClient!=null){
                    httpClient.close();
                }
            } catch (IOException e) {
                log.error("notify Handler trigger exception", e);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        String url = "http://localhost:8080/command";
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("agentId", "121332");
        paramMap.put("cmd", "xxxx");
        String post = HttpClientUtil.post(url, paramMap);
        System.out.println("============" + post);
    }
}
