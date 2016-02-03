package com.quoord.tapatalkpro.action.log;

import android.app.Activity;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.util.MySSLSocketFactory;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONObject;

public class LogTopicSubscription {
    private Activity activity;
    private AQuery aq = null;
    private ArrayList<String> needLogIds = new ArrayList();
    private TapatalkId tapatalkId;

    public LogTopicSubscription(Activity paramActivity) {
        this.activity = paramActivity;
        this.aq = new AQuery(this.activity);
        this.tapatalkId = TapatalkIdFactory.getTapatalkId(this.activity);
    }

    public void log(final int paramInt, final String paramString, ArrayList<String> paramArrayList) {
        if ((this.tapatalkId.isTapatalkIdLogin()) && (this.tapatalkId.getAuid() != -1)) {
        }
        label500:
        for (; ; ) {
            try {
                this.needLogIds.clear();
                final String str;
                final Object localObject1;
                Object localObject2;
                int i;
                if ((paramInt != 0) && (!paramString.equals("0"))) {
                    str = AppCacheManager.getSubscribeTopicUrl(this.activity);
                    localObject1 = AppCacheManager.getCacheData(str);
                    if (localObject1 == null) {
                        continue;
                    }
                    localObject2 = (HashMap) localObject1;
                    if ((localObject2 == null) || (!((HashMap) localObject2).containsKey(paramInt + "|" + paramString))) {
                        continue;
                    }
                    localObject2 = (ArrayList) ((HashMap) localObject2).get(paramInt + "|" + paramString);
                    if (((ArrayList) localObject2).size() <= 0) {
                        continue;
                    }
                    i = 0;
                    if (i < paramArrayList.size()) {
                        continue;
                    }
                    continue;
                    if (i < this.needLogIds.size()) {
                        continue;
                    }
                    if (paramArrayList.length() > 0) {
                        paramArrayList = TapatalkJsonEngine.AU_LOG_TOPIC_SUBSCRIPTION + "?fid=" + paramInt + "&uid=" + paramString + "&tids=" + paramArrayList + "&au_id=" + this.tapatalkId.getAuid() + "&token=" + this.tapatalkId.getToken() + "&" + TapatalkApp.APP_KEY;
                    }
                }
                try {
                    localObject2 = new MySSLSocketFactory(KeyStore.getInstance(KeyStore.getDefaultType()));
                    ((SSLSocketFactory) localObject2).setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                    paramString = new AjaxCallback() {
                        public void callback(String paramAnonymousString, JSONObject paramAnonymousJSONObject, AjaxStatus paramAnonymousAjaxStatus) {
                            super.callback(paramAnonymousString, paramAnonymousJSONObject, paramAnonymousAjaxStatus);
                            paramAnonymousString = (HashMap) localObject1;
                            if (paramAnonymousString != null) {
                                paramAnonymousJSONObject = (ArrayList) paramAnonymousString.get(paramInt + "|" + paramString);
                                if (paramAnonymousJSONObject != null) {
                                    paramAnonymousJSONObject.addAll(LogTopicSubscription.this.needLogIds);
                                }
                            }
                            for (; ; ) {
                                AppCacheManager.cacheData(str, paramAnonymousString);
                                return;
                                continue;
                                paramAnonymousString = new HashMap();
                                paramAnonymousString.put(paramInt + "|" + paramString, LogTopicSubscription.this.needLogIds);
                            }
                        }
                    };
                    AjaxCallback.setSSF((SocketFactory) localObject2);
                    AjaxCallback.setTimeout(20000);
                    this.aq.ajax(paramArrayList, JSONObject.class, paramString);
                    return;
                } catch (Exception paramString) {
                    return;
                }
                if (!((ArrayList) localObject2).contains(paramArrayList.get(i))) {
                    this.needLogIds.add((String) paramArrayList.get(i));
                    continue;
                    this.needLogIds = paramArrayList;
                    continue;
                    this.needLogIds = paramArrayList;
                    continue;
                    this.needLogIds = paramArrayList;
                    continue;
                    if (i == this.needLogIds.size() - 1) {
                        paramArrayList = paramArrayList + (String) this.needLogIds.get(i);
                        break label500;
                    }
                    paramArrayList = paramArrayList + (String) this.needLogIds.get(i) + ",";
                    break label500;
                    paramArrayList = "";
                    i = 0;
                    continue;
                }
                i += 1;
                continue;
                i += 1;
            } catch (Exception paramString) {
                return;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/log/LogTopicSubscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */