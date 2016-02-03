package com.quoord.tools.net;

import android.content.Context;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;
import org.json.JSONObject;

public class TapatalkAjaxLogAction {
    private Context activity;
    private AQuery aq = null;

    public TapatalkAjaxLogAction(Context paramContext) {
        this.activity = paramContext;
        this.aq = new AQuery(this.activity);
    }

    public void logTapatalkLog(String paramString) {
        try {
            TapatalkAjaxCallback local1 = new TapatalkAjaxCallback() {
                public void callback(String paramAnonymousString, JSONObject paramAnonymousJSONObject, AjaxStatus paramAnonymousAjaxStatus) {
                    super.callback(paramAnonymousString, paramAnonymousJSONObject, paramAnonymousAjaxStatus);
                }
            };
            this.aq.ajax(paramString, JSONObject.class, local1);
            return;
        } catch (Exception paramString) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/net/TapatalkAjaxLogAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */