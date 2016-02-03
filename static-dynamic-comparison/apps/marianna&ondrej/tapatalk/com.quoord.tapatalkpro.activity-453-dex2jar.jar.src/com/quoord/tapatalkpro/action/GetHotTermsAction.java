package com.quoord.tapatalkpro.action;

import android.app.Activity;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;
import com.quoord.tools.net.TapatalkAjaxAction;
import com.quoord.tools.net.TapatalkAjaxAction.ActionCallBack;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

public class GetHotTermsAction {
    public static ArrayList<String> hotTerms = new ArrayList();
    private Activity activity;

    public GetHotTermsAction(Activity paramActivity) {
        this.activity = paramActivity;
    }

    public void getHotTerms(final ActionBack paramActionBack) {
        if ((hotTerms != null) && (hotTerms.size() > 0)) {
            paramActionBack.getActionBack(hotTerms);
            return;
        }
        new TapatalkAjaxAction(this.activity).getJsonArrayAction(DirectoryUrlUtil.getHotTermsUrl(this.activity), new TapatalkAjaxAction.ActionCallBack() {
            public void actionCallBack(Object paramAnonymousObject) {
                paramAnonymousObject = (JSONArray) paramAnonymousObject;
                int i = 0;
                for (; ; ) {
                    if (i >= ((JSONArray) paramAnonymousObject).length()) {
                        paramActionBack.getActionBack(GetHotTermsAction.hotTerms);
                        return;
                    }
                    try {
                        String str = ((JSONArray) paramAnonymousObject).getString(i);
                        GetHotTermsAction.hotTerms.add(str);
                        i += 1;
                    } catch (JSONException localJSONException) {
                        for (; ; ) {
                            localJSONException.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public static abstract interface ActionBack {
        public abstract void getActionBack(ArrayList<String> paramArrayList);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/GetHotTermsAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */