package com.quoord.tapatalkpro.action;

import android.content.Context;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.quoord.tapatalkpro.bean.TapatalkForumForSearch;
import com.quoord.tapatalkpro.ics.action.IcsSearchForumAction.IcsSearchForumActionBack;

import java.util.ArrayList;

import org.json.JSONArray;

public class IcsRecommendForumAction {
    private AQuery aq;

    public IcsRecommendForumAction(Context paramContext) {
        this.aq = new AQuery(paramContext);
    }

    private ArrayList<TapatalkForumForSearch> getSearchForumResult(JSONArray paramJSONArray) {
        ArrayList localArrayList = new ArrayList();
        int j;
        int i;
        if (paramJSONArray != null) {
            j = paramJSONArray.length();
            if (j > 0) {
                i = 0;
            }
        }
        for (; ; ) {
            if (i >= j) {
                return localArrayList;
            }
            localArrayList.add(TapatalkForumForSearch.getForum(paramJSONArray.optJSONObject(i), null, null, null));
            i += 1;
        }
    }

    public void getRecommendForums(String paramString, final IcsSearchForumAction.IcsSearchForumActionBack paramIcsSearchForumActionBack) {
        this.aq.ajax(paramString, JSONArray.class, new AjaxCallback() {
            public void callback(String paramAnonymousString, JSONArray paramAnonymousJSONArray, AjaxStatus paramAnonymousAjaxStatus) {
                super.callback(paramAnonymousString, paramAnonymousJSONArray, paramAnonymousAjaxStatus);
                try {
                    paramIcsSearchForumActionBack.searchForumActionBack(IcsRecommendForumAction.this.getSearchForumResult(paramAnonymousJSONArray));
                    return;
                } catch (Exception paramAnonymousString) {
                    paramAnonymousString.printStackTrace();
                }
            }
        });
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/IcsRecommendForumAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */