import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClient1 {
    /*
        创建HttpClient对象
     */
    public static CloseableHttpClient httpClient = HttpClients.createDefault();

    //创建Http Get
    public static String DoGet(String url) throws IOException{
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse res = null;
        try{
            // 执行请求
            res = httpClient.execute(httpGet);
            System.out.println(res.getStatusLine());
            HttpEntity entity1 = res.getEntity();
            return EntityUtils.toString(entity1, "UTF-8");
        } finally {
            if(res != null){
                res.close();
            }
        }
    }

    public static String DoPost(String url, String json){
        String returnValue = "调用失败";
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        try{
            HttpPost httpPost = new HttpPost(url);

            StringEntity requestEntity = new StringEntity(json, "utf-8");
            requestEntity.setContentEncoding("UTF-8");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setEntity(requestEntity);

            returnValue = httpClient.execute(httpPost, responseHandler);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return returnValue;
    }

    public static void main(String[] args) throws IOException {
        String url = "http://localhost:8801";
        String text = HttpClient1.DoGet(url);
        System.out.println(url + " " + text);
    }

}
