package com.wbtech.ums.common;

import com.wbtech.ums.objects.MyMessage;

import java.net.URLDecoder;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class NetworkUitlity {
    public static String DEFAULT_CHARSET = " HTTP.UTF_8";
    public static long paramleng = 256L;

    public static MyMessage post(String paramString1, String paramString2) {
        CommonUtil.printLog("ums", paramString1);
        localMyMessage = new MyMessage();
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
        paramString1 = new HttpPost(paramString1);
        try {
            StringEntity localStringEntity = new StringEntity("content=" + paramString2, "UTF-8");
            CommonUtil.printLog("postdata", "content=" + paramString2);
            localStringEntity.setContentType("application/x-www-form-urlencoded");
            paramString1.setEntity(localStringEntity);
            paramString1 = localDefaultHttpClient.execute(paramString1);
            int i = paramString1.getStatusLine().getStatusCode();
            paramString1 = URLDecoder.decode(EntityUtils.toString(paramString1.getEntity()));
            switch (i) {
            }
        } catch (Exception paramString1) {
            for (; ; ) {
                paramString2 = new JSONObject();
                try {
                    paramString2.put("err", paramString1.toString());
                    paramString1 = paramString2.toString();
                    localMyMessage.setFlag(false);
                    localMyMessage.setMsg(paramString1);
                } catch (JSONException paramString1) {
                    paramString1.printStackTrace();
                }
            }
        }
        localMyMessage.setFlag(false);
        localMyMessage.setMsg(paramString1);
        for (; ; ) {
            CommonUtil.printLog("UMSAGENT", localMyMessage.getMsg());
            return localMyMessage;
            localMyMessage.setFlag(true);
            localMyMessage.setMsg(paramString1);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/wbtech/ums/common/NetworkUitlity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */