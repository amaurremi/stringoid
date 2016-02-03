package com.quoord.tools.net;

import android.content.Context;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import org.json.JSONArray;
import org.json.JSONObject;

public class TapatalkAjaxAction {
    private Context activity;
    private AQuery aq = null;

    public TapatalkAjaxAction(Context paramContext) {
        this.activity = paramContext;
        this.aq = new AQuery(this.activity);
    }

    public void getJsonArrayAction(String paramString, final ActionCallBack paramActionCallBack) {
        paramActionCallBack = new TapatalkAjaxCallback() {
            public void callback(String paramAnonymousString, JSONArray paramAnonymousJSONArray, AjaxStatus paramAnonymousAjaxStatus) {
                super.callback(paramAnonymousString, paramAnonymousJSONArray, paramAnonymousAjaxStatus);
                paramActionCallBack.actionCallBack(paramAnonymousJSONArray);
            }
        };
        this.aq.ajax(paramString, JSONArray.class, paramActionCallBack);
    }

    public void getJsonObjectAction(String paramString, final ActionCallBack paramActionCallBack) {
        paramActionCallBack = new TapatalkAjaxCallback() {
            public void callback(String paramAnonymousString, JSONObject paramAnonymousJSONObject, AjaxStatus paramAnonymousAjaxStatus) {
                super.callback(paramAnonymousString, paramAnonymousJSONObject, paramAnonymousAjaxStatus);
                paramActionCallBack.actionCallBack(paramAnonymousJSONObject);
            }
        };
        this.aq.ajax(paramString, JSONObject.class, paramActionCallBack);
    }

    public static abstract interface ActionCallBack {
        public abstract void actionCallBack(Object paramObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/net/TapatalkAjaxAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */