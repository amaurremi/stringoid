package com.quoord.tapatalkpro.action;

import android.content.Context;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.util.MySSLSocketFactory;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;

import java.security.KeyStore;
import java.util.ArrayList;

import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONObject;

public class SynchaAccountAction {
    private Context activity;
    private AQuery aq = null;
    private TapatalkId tapatalkId;

    public SynchaAccountAction(Context paramContext) {
        this.activity = paramContext;
        this.aq = new AQuery(this.activity);
        this.tapatalkId = TapatalkIdFactory.getTapatalkId(this.activity);
    }

    public void synchAccount(ArrayList<TapatalkForum> paramArrayList) {
        try {
            Object localObject = new MySSLSocketFactory(KeyStore.getInstance(KeyStore.getDefaultType()));
            ((SSLSocketFactory) localObject).setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            AjaxCallback local1 = new AjaxCallback() {
                public void callback(String paramAnonymousString, JSONObject paramAnonymousJSONObject, AjaxStatus paramAnonymousAjaxStatus) {
                    super.callback(paramAnonymousString, paramAnonymousJSONObject, paramAnonymousAjaxStatus);
                }
            };
            AjaxCallback.setSSF((SocketFactory) localObject);
            AjaxCallback.setTimeout(7000);
            int j = this.tapatalkId.getAuid();
            String str1 = this.tapatalkId.getToken();
            String str2 = TapatalkJsonEngine.AU_UPDATE_ACCOUNT_ORDER;
            localObject = "";
            int i = 0;
            for (; ; ) {
                if (i >= paramArrayList.size()) {
                    paramArrayList = (ArrayList<TapatalkForum>) localObject;
                    if (((String) localObject).length() > 1) {
                        paramArrayList = ((String) localObject).substring(0, ((String) localObject).length() - 1);
                    }
                    if ((j == -1) || (str1 == null)) {
                        break;
                    }
                    paramArrayList = str2 + "?au_id=" + j + "&token=" + str1 + "&data=" + paramArrayList + "&" + TapatalkApp.APP_KEY;
                    this.aq.ajax(paramArrayList, JSONObject.class, local1);
                    return;
                }
                TapatalkForum localTapatalkForum = (TapatalkForum) paramArrayList.get(i);
                localObject = localObject + localTapatalkForum.getId() + "-" + localTapatalkForum.getUserId() + "-" + (i + 1) + ",";
                i += 1;
            }
            return;
        } catch (Exception paramArrayList) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/SynchaAccountAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */