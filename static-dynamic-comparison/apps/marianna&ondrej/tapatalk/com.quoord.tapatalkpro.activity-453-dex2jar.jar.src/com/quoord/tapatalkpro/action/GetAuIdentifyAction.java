package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.util.Log;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.quoord.tapatalkpro.util.FakeX509TrustManager;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONObject;

public class GetAuIdentifyAction {
    private Activity mActivity;
    private GetAuIdentifyActionBack mCallback;
    private RequestQueue mQueue = null;

    public GetAuIdentifyAction(Activity paramActivity) {
        this.mActivity = paramActivity;
        this.mQueue = Volley.newRequestQueue(this.mActivity);
    }

    public void getAuIdentify(String paramString, ArrayList<String> paramArrayList, GetAuIdentifyActionBack paramGetAuIdentifyActionBack) {
        if ((paramString == null) || (paramString.length() < 1) || (paramArrayList == null) || (paramArrayList.size() < 1) || (paramGetAuIdentifyActionBack == null)) {
            return;
        }
        this.mCallback = paramGetAuIdentifyActionBack;
        if (paramArrayList.size() == 1) {
            paramArrayList = (String) paramArrayList.get(0);
            paramString = DirectoryUrlUtil.getAuIdentifyTapatalkUserUrl(this.mActivity, paramString, paramArrayList);
            FakeX509TrustManager.allowAllSSL();
            paramString = new JsonObjectRequest(paramString, null, new Response.Listener() new Response.ErrorListener
            {
                public void onResponse (JSONObject paramAnonymousJSONObject)
                {
                    if (paramAnonymousJSONObject == null) {
                    }
                    for (; ; ) {
                        return;
                        try {
                            if (!paramAnonymousJSONObject.getBoolean("result")) {
                                continue;
                            }
                            ArrayList localArrayList = new ArrayList();
                            paramAnonymousJSONObject = paramAnonymousJSONObject.getJSONObject("data");
                            Iterator localIterator = paramAnonymousJSONObject.keys();
                            for (; ; ) {
                                if (!localIterator.hasNext()) {
                                    GetAuIdentifyAction.this.mCallback.getAuIdentifyActionBack(localArrayList);
                                    return;
                                }
                                String str = (String) localIterator.next();
                                if (paramAnonymousJSONObject.getString(str).equals("0")) {
                                    localArrayList.add(str);
                                }
                            }
                            return;
                        } catch (Exception paramAnonymousJSONObject) {
                        }
                    }
                }
            },new Response.ErrorListener() {
                public void onErrorResponse(VolleyError paramAnonymousVolleyError) {
                    Log.e("AuIdentify", paramAnonymousVolleyError.getMessage(), paramAnonymousVolleyError);
                }
            });
            paramString.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0F));
            this.mQueue.add(paramString);
            return;
        }
        paramGetAuIdentifyActionBack = new StringBuilder("");
        int i = 0;
        for (; ; ) {
            if (i >= paramArrayList.size()) {
                paramArrayList = paramGetAuIdentifyActionBack.toString();
                break;
            }
            paramGetAuIdentifyActionBack.append((String) paramArrayList.get(i));
            if (i < paramArrayList.size() - 1) {
                paramGetAuIdentifyActionBack.append(",");
            }
            i += 1;
        }
    }

    public static abstract interface GetAuIdentifyActionBack {
        public abstract void getAuIdentifyActionBack(ArrayList<String> paramArrayList);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/GetAuIdentifyAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */