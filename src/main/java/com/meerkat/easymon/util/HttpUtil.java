package com.meerkat.easymon.util;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.quartz.JobExecutionException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

@Slf4j
public class HttpUtil {
    public HttpUtil() {
    }

    public static String getHttpResponseWithAuth(String url, String username, String password) throws IOException, AuthenticationException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        UsernamePasswordCredentials creds = new UsernamePasswordCredentials(username, password);
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader(new BasicScheme(StandardCharsets.UTF_8).authenticate(creds, httpGet, null));
        httpGet.setHeader("Content-Type", "application/json");
        CloseableHttpResponse response = httpClient.execute(httpGet);

        try {
            if (response.getStatusLine().getStatusCode() != 200) {
                log.error("调用http协议获取URL:数据失败，return Code:{}，url:{}", response.getStatusLine().getStatusCode(), url);
                throw new IOException("MainJob执行错误，未接收到scheduleJob!");
            }
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity);
            }
        } finally {
            response.close();
        }

        return "";
    }

    public static String getHttpResponse(String pageURL) throws IOException{
        StringBuffer pageContent = new StringBuffer("");
        BufferedReader in = null;
        InputStreamReader isr = null;
        InputStream is = null;
        HttpURLConnection huc = null;

        try {
            URL url = new URL(pageURL);
            huc = (HttpURLConnection)url.openConnection();
            is = huc.getInputStream();
            isr = new InputStreamReader(is, "UTF-8");
            in = new BufferedReader(isr);
            String line = null;


            while((line = in.readLine()) != null) {
                if(line.length() != 0) {
                    pageContent.append(line);
                }
            }
        } catch (Exception var16) {
            var16.printStackTrace();
            throw new IOException(var16);
        } finally {
            try {
                if(is != null) {
                    is.close();
                }

                if(isr != null) {
                    isr.close();
                }

                if(in != null) {
                    in.close();
                }

                if(huc != null) {
                    huc.disconnect();
                }
            } catch (Exception var15) {
                var15.printStackTrace();
            }

        }

        return pageContent.toString();
    }

    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuffer result = new StringBuffer("");

        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("content-Type", "application/json");
            conn.setRequestProperty("charset", "utf-8");
            conn.setRequestProperty("Content-length", String.valueOf(param.length()));
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();

            String line;
            for(in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8")); (line = in.readLine()) != null; result.append(line)) {
                ;
            }
        } catch (Exception var16) {
            System.out.println("发送 POST 请求出现异常！" + var16);
            var16.printStackTrace();
        } finally {
            try {
                if(out != null) {
                    out.close();
                }

                if(in != null) {
                    in.close();
                }
            } catch (IOException var15) {
                var15.printStackTrace();
            }

        }

        return result.toString();
    }


}

