package com.quoord.tapatalkpro.action;

import android.content.Context;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.quoord.tapatalkpro.bean.FunctionConfig;
import com.quoord.tapatalkpro.util.FakeX509TrustManager;
import com.quoord.tools.TapatalkLog;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;

import java.util.Iterator;

import org.json.JSONObject;

public class FunctionConfigAction {
    private GetFunctionConfigActionBack mCallBack;
    private Context mContext;
    private FunctionConfig mFunctionConfig;
    private RequestQueue mQueue = null;

    public FunctionConfigAction(Context paramContext) {
        this.mContext = paramContext;
        this.mFunctionConfig = new FunctionConfig(this.mContext);
        this.mQueue = Volley.newRequestQueue(this.mContext);
        this.mCallBack = null;
    }

    private void parseErrorReponse(String paramString) {
        TapatalkLog.v("FunctionConfigAction", "Exception occured: " + paramString);
    }

    private void parseResponse(JSONObject paramJSONObject) {
        if (paramJSONObject == null) {
            return;
        }
        for (; ; ) {
            try {
                if (!paramJSONObject.getBoolean("result")) {
                    break;
                }
                paramJSONObject = paramJSONObject.getJSONObject("list");
                localIterator = paramJSONObject.keys();
                boolean bool = localIterator.hasNext();
                if (bool) {
                    continue;
                }
            } catch (Exception paramJSONObject) {
                Iterator localIterator;
                String str;
                TapatalkLog.v("FunctionConfigAction", "Exception occured: " + paramJSONObject.getMessage());
                continue;
            }
            this.mCallBack.setFunctionConfig(this.mFunctionConfig);
            return;
            str = (String) localIterator.next();
            if (str.equals("invitation")) {
                this.mFunctionConfig.setInvitation(Integer.valueOf(paramJSONObject.getInt(str)));
            }
            if (str.equals("invitation_click_times")) {
                this.mFunctionConfig.setInvitationClickTimes(Integer.valueOf(paramJSONObject.getInt(str)));
            }
            if (str.equals("invitation_max_num_one_time")) {
                this.mFunctionConfig.setInvitationMaxNumOneTime(Integer.valueOf(paramJSONObject.getInt(str)));
            }
            if (str.equals("tid_reg_push")) {
                this.mFunctionConfig.setTidRegPush(Integer.valueOf(paramJSONObject.getInt(str)));
            }
            if (str.equals("new_invitaion_display_period")) {
                this.mFunctionConfig.setNewInvitaionDisplayPeriod(Integer.valueOf(paramJSONObject.getInt(str)));
            }
            if (str.equals("enable_new_invitation")) {
                this.mFunctionConfig.setEnableNewInvitation(Integer.valueOf(paramJSONObject.getInt(str)));
            }
        }
    }

    public void getFunctionConfig(GetFunctionConfigActionBack paramGetFunctionConfigActionBack) {
        if (paramGetFunctionConfigActionBack == null) {
            return;
        }
        this.mCallBack = paramGetFunctionConfigActionBack;
        paramGetFunctionConfigActionBack = DirectoryUrlUtil.getFunctionConfigUrl(this.mContext);
        FakeX509TrustManager.allowAllSSL();
        paramGetFunctionConfigActionBack = new JsonObjectRequest(paramGetFunctionConfigActionBack, null, new Response.Listener()
        new Response.ErrorListener
        {
            public void onResponse (JSONObject paramAnonymousJSONObject)
            {
                FunctionConfigAction.this.parseResponse(paramAnonymousJSONObject);
            }
        },new Response.ErrorListener() {
            public void onErrorResponse(VolleyError paramAnonymousVolleyError) {
                FunctionConfigAction.this.parseErrorReponse(paramAnonymousVolleyError.getMessage());
            }
        });
        paramGetFunctionConfigActionBack.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0F));
        this.mQueue.add(paramGetFunctionConfigActionBack);
    }

    public static abstract interface GetFunctionConfigActionBack {
        public abstract void setFunctionConfig(FunctionConfig paramFunctionConfig);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/FunctionConfigAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */