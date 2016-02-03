package com.quoord.tapatalkpro.net;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.quoord.tapatalkpro.adapter.CallBackResult;
import com.quoord.tapatalkpro.util.MySSLSocketFactory;
import com.quoord.tapatalkpro.util.Util;

import java.security.KeyStore;

import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONObject;

public class AQueryEngine {
    public static final String METHOD_GET_FEED = "feed";
    public static final String METHOD_GET_FORUM_BY_ID = "getforumbyid";
    public static final String METHOD_GET_FORUM_BY_URL = "getforumbyurl";
    public static final String METHOD_SEARCH_FORUMS = "searchforum";
    private static int timeOut = 20000;
    private AQuery aQuery;
    private AQueryEngineCallBackResultFactory callBackFactory;
    private HandleCallBackResultListener callBackHandleListener;
    private CallBackResult callBackResult;

    public AQueryEngine(AQuery paramAQuery) {
        this.aQuery = paramAQuery;
    }

    private void call(String paramString) {
        switch (this.callBackResult.getResultTypeCode()) {
            default:
                return;
            case 1:
                callForResultJsonArray(paramString);
                return;
            case 0:
                callForResultJsonObject(paramString);
                return;
        }
        callForResultString(paramString);
    }

    private void callBack() {
        this.callBackResult.addNumsCall();
        if (this.callBackHandleListener != null) {
            this.callBackHandleListener.handleOver(this.callBackResult);
        }
    }

    private void callForResultJsonArray(String paramString) {
        try {
            MySSLSocketFactory localMySSLSocketFactory = new MySSLSocketFactory(KeyStore.getInstance(KeyStore.getDefaultType()));
            localMySSLSocketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            AjaxCallback local2 = new AjaxCallback() {
                public void callback(String paramAnonymousString, JSONArray paramAnonymousJSONArray, AjaxStatus paramAnonymousAjaxStatus) {
                    try {
                        AQueryEngine.this.callBackResult.handleBackResult(paramAnonymousJSONArray, AQueryEngine.this.aQuery.getContext());
                        AQueryEngine.this.callBackResult.setHandleResult(true);
                        AQueryEngine.this.callBack();
                        return;
                    } catch (Exception paramAnonymousString) {
                        for (; ; ) {
                        }
                    }
                }
            };
            AjaxCallback.setSSF(localMySSLSocketFactory);
            AjaxCallback.setTimeout(timeOut);
            this.aQuery.ajax(paramString, JSONArray.class, local2);
            return;
        } catch (Exception paramString) {
            paramString.printStackTrace();
        }
    }

    private void callForResultJsonObject(String paramString) {
        try {
            MySSLSocketFactory localMySSLSocketFactory = new MySSLSocketFactory(KeyStore.getInstance(KeyStore.getDefaultType()));
            localMySSLSocketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            AjaxCallback local1 = new AjaxCallback() {
                public void callback(String paramAnonymousString, JSONObject paramAnonymousJSONObject, AjaxStatus paramAnonymousAjaxStatus) {
                    try {
                        AQueryEngine.this.callBackResult.handleBackResult(paramAnonymousJSONObject, AQueryEngine.this.aQuery.getContext());
                        AQueryEngine.this.callBackResult.setHandleResult(true);
                        AQueryEngine.this.callBack();
                        return;
                    } catch (Exception paramAnonymousString) {
                        for (; ; ) {
                        }
                    }
                }
            };
            AjaxCallback.setSSF(localMySSLSocketFactory);
            AjaxCallback.setTimeout(timeOut);
            this.aQuery.ajax(paramString, JSONObject.class, local1);
            return;
        } catch (Exception paramString) {
            paramString.printStackTrace();
        }
    }

    private void callForResultString(String paramString) {
        AjaxCallback.setTimeout(timeOut);
        this.aQuery.ajax(paramString, String.class, new AjaxCallback() {
            public void callback(String paramAnonymousString1, String paramAnonymousString2, AjaxStatus paramAnonymousAjaxStatus) {
                try {
                    AQueryEngine.this.callBackResult.handleBackResult(paramAnonymousString2, AQueryEngine.this.aQuery.getContext());
                    AQueryEngine.this.callBackResult.setHandleResult(true);
                    AQueryEngine.this.callBack();
                    return;
                } catch (Exception paramAnonymousString1) {
                    for (; ; ) {
                    }
                }
            }
        });
    }

    private void checkCallBack(String paramString1, String paramString2) {
        if (this.callBackResult == null) {
            this.callBackFactory = new AQueryEngineCallBackResultFactory();
            this.callBackResult = this.callBackFactory.getBackResultInstance(paramString1);
            setCallBackBaseInfo(paramString1, paramString2);
        }
        do {
            return;
            if (!paramString1.equals(this.callBackResult.getMethodName())) {
                this.callBackResult = this.callBackFactory.getBackResultInstance(paramString1);
                setCallBackBaseInfo(paramString1, paramString2);
            }
        } while (paramString2.equals(this.callBackResult.getUrl()));
        this.callBackResult.setUrl(paramString2);
        this.callBackResult.resetNumsCall();
    }

    private void setCallBackBaseInfo(String paramString1, String paramString2) {
        if (this.callBackResult != null) {
            this.callBackResult.setMethodName(paramString1);
            this.callBackResult.setUrl(paramString2);
        }
    }

    public void call(String paramString1, String paramString2) {
        if ((!Util.checkString(paramString1)) || (!Util.checkString(paramString2))) {
            throw new IllegalArgumentException("method and url can not be null or empty String");
        }
        checkCallBack(paramString1, paramString2);
        if (this.callBackResult != null) {
            call(paramString2);
            return;
        }
        throw new IllegalArgumentException("AQueryJsonEngine can not handle this method:" + paramString1);
    }

    public void reCall() {
        if (this.callBackResult == null) {
            throw new IllegalAccessError("reCall() method must be called after the call(String,String) method");
        }
        call(this.callBackResult.getUrl());
    }

    public void setCallBackHandleListener(HandleCallBackResultListener paramHandleCallBackResultListener) {
        this.callBackHandleListener = paramHandleCallBackResultListener;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/net/AQueryEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */