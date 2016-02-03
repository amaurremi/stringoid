package com.androidquery.auth;

import android.net.Uri;
import com.androidquery.callback.AbstractAjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;

import java.net.HttpURLConnection;

import org.apache.http.HttpRequest;

public class BasicHandle
        extends AccountHandle {
    private String password;
    private String username;

    public BasicHandle(String paramString1, String paramString2) {
        this.username = paramString1;
        this.password = paramString2;
    }

    public void applyToken(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback, HttpURLConnection paramHttpURLConnection) {
        Object localObject = (this.username + ":" + this.password).getBytes();
        localObject = "Basic " + new String(AQUtility.encode64((byte[]) localObject, 0, localObject.length));
        paramHttpURLConnection.setRequestProperty("Host", Uri.parse(paramAbstractAjaxCallback.getUrl()).getHost());
        paramHttpURLConnection.setRequestProperty("Authorization", (String) localObject);
    }

    public void applyToken(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback, HttpRequest paramHttpRequest) {
        Object localObject = (this.username + ":" + this.password).getBytes();
        localObject = "Basic " + new String(AQUtility.encode64((byte[]) localObject, 0, localObject.length));
        paramHttpRequest.addHeader("Host", Uri.parse(paramAbstractAjaxCallback.getUrl()).getHost());
        paramHttpRequest.addHeader("Authorization", (String) localObject);
    }

    protected void auth() {
    }

    public boolean authenticated() {
        return true;
    }

    public boolean expired(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback, AjaxStatus paramAjaxStatus) {
        return false;
    }

    public boolean reauth(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback) {
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/androidquery/auth/BasicHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */