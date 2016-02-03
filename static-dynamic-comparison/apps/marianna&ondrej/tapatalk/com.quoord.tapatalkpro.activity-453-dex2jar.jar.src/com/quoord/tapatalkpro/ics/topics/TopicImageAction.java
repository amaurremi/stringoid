package com.quoord.tapatalkpro.ics.topics;

import android.app.Activity;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.quoord.tapatalkpro.util.MySSLSocketFactory;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;

import java.security.KeyStore;
import java.util.ArrayList;

import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONObject;

public class TopicImageAction {
    private TopicImageCallBack callback;
    private Activity context;

    public TopicImageAction(Activity paramActivity, TopicImageCallBack paramTopicImageCallBack) {
        this.context = paramActivity;
        this.callback = paramTopicImageCallBack;
    }

    public void getTopicImgUrl(String paramString, ArrayList<String> paramArrayList) {
        paramString = TapatalkJsonEngine.API_IMAGE + paramString;
        Object localObject = new StringBuilder();
        ((StringBuilder) localObject).append("&tid=");
        int i;
        if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
            i = 0;
        }
        for (; ; ) {
            if (i >= paramArrayList.size()) {
                paramArrayList = ((StringBuilder) localObject).toString();
                paramString = paramString + paramArrayList.substring(0, paramArrayList.length() - 1);
            }
            try {
                localObject = KeyStore.getInstance(KeyStore.getDefaultType());
                paramArrayList = new AQuery(this.context);
                localObject = new MySSLSocketFactory((KeyStore) localObject);
                ((SSLSocketFactory) localObject).setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                TopicImageAjaxCallback localTopicImageAjaxCallback = new TopicImageAjaxCallback(null);
                TopicImageAjaxCallback.setSSF((SocketFactory) localObject);
                TopicImageAjaxCallback.setTimeout(7000);
                paramArrayList.ajax(paramString, JSONObject.class, localTopicImageAjaxCallback);
                return;
            } catch (Exception paramString) {
            }
            ((StringBuilder) localObject).append((String) paramArrayList.get(i) + ",");
            i += 1;
        }
    }

    private class TopicImageAjaxCallback
            extends AjaxCallback<JSONObject> {
        private TopicImageAjaxCallback() {
        }

        public void callback(String paramString, JSONObject paramJSONObject, AjaxStatus paramAjaxStatus) {
            super.callback(paramString, paramJSONObject, paramAjaxStatus);
            TopicImageAction.this.callback.imageLoad(paramJSONObject, paramAjaxStatus);
        }
    }

    public static abstract interface TopicImageCallBack {
        public abstract void imageLoad(JSONObject paramJSONObject, AjaxStatus paramAjaxStatus);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/topics/TopicImageAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */