package com.quoord.tapatalkpro.action;

import android.app.Activity;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.quoord.tapatalkpro.bean.TapatalkForumForSearch;
import com.quoord.tapatalkpro.util.MySSLSocketFactory;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;

import java.security.KeyStore;
import java.util.ArrayList;

import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONArray;

public class RecommendForumsAction {
    private Activity activity;
    private AQuery aq = null;
    private RecommendActionBack rAction;

    public RecommendForumsAction(Activity paramActivity) {
        this.activity = paramActivity;
        this.aq = new AQuery(this.activity);
    }

    public void getRecommendForums(ArrayList<String> paramArrayList, RecommendActionBack paramRecommendActionBack) {
        paramArrayList = DirectoryUrlUtil.getRecommendForumsByFidsUrl(this.activity, paramArrayList);
        this.rAction = paramRecommendActionBack;
        try {
            paramRecommendActionBack = new MySSLSocketFactory(KeyStore.getInstance(KeyStore.getDefaultType()));
            paramRecommendActionBack.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            AjaxCallback local1 = new AjaxCallback() {
                public void callback(String paramAnonymousString, JSONArray paramAnonymousJSONArray, AjaxStatus paramAnonymousAjaxStatus) {
                    super.callback(paramAnonymousString, paramAnonymousJSONArray, paramAnonymousAjaxStatus);
                    paramAnonymousString = new ArrayList();
                    int i;
                    if (paramAnonymousJSONArray != null) {
                        i = 0;
                    }
                    for (; ; ) {
                        try {
                            int j = paramAnonymousJSONArray.length();
                            if (i < j) {
                                continue;
                            }
                        } catch (Exception paramAnonymousJSONArray) {
                            continue;
                        }
                        RecommendForumsAction.this.rAction.recommendActionBack(paramAnonymousString);
                        return;
                        paramAnonymousString.add(TapatalkForumForSearch.getForum(paramAnonymousJSONArray.getJSONObject(i), null, null, null));
                        i += 1;
                    }
                }
            };
            AjaxCallback.setSSF(paramRecommendActionBack);
            AjaxCallback.setTimeout(20000);
            this.aq.ajax(paramArrayList, JSONArray.class, local1);
            return;
        } catch (Exception paramArrayList) {
        }
    }

    public static abstract interface RecommendActionBack {
        public abstract void recommendActionBack(ArrayList<TapatalkForumForSearch> paramArrayList);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/RecommendForumsAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */