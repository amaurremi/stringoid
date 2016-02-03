package com.quoord.onboarding.action;

import android.app.Activity;
import com.quoord.tapatalkpro.bean.TapatalkForumForSearch;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;
import com.quoord.tools.net.TapatalkAjaxAction;
import com.quoord.tools.net.TapatalkAjaxAction.ActionCallBack;

import java.util.ArrayList;

import org.json.JSONArray;

public class GetCategoryRecommedForumAction {
    private Activity activity;
    private SubSearchForumActionBack searchAction;

    public GetCategoryRecommedForumAction(Activity paramActivity) {
        this.activity = paramActivity;
    }

    public void searchForums(ArrayList<String> paramArrayList, int paramInt, SubSearchForumActionBack paramSubSearchForumActionBack) {
        paramArrayList = DirectoryUrlUtil.getObRecommendForumsByIabCategory(this.activity, paramArrayList, paramInt);
        this.searchAction = paramSubSearchForumActionBack;
        new TapatalkAjaxAction(this.activity).getJsonArrayAction(paramArrayList, new TapatalkAjaxAction.ActionCallBack() {
            public void actionCallBack(Object paramAnonymousObject) {
                ArrayList localArrayList = new ArrayList();
                if (paramAnonymousObject != null) {
                }
                for (; ; ) {
                    try {
                        paramAnonymousObject = (JSONArray) paramAnonymousObject;
                        i = 0;
                        int j = ((JSONArray) paramAnonymousObject).length();
                        if (i < j) {
                            continue;
                        }
                    } catch (Exception paramAnonymousObject) {
                        int i;
                        continue;
                    }
                    GetCategoryRecommedForumAction.this.searchAction.getRecommendActionBack(localArrayList);
                    return;
                    localArrayList.add(TapatalkForumForSearch.getForum(((JSONArray) paramAnonymousObject).getJSONObject(i), null, null, null));
                    i += 1;
                }
            }
        });
    }

    public static abstract interface SubSearchForumActionBack {
        public abstract void getRecommendActionBack(ArrayList<TapatalkForumForSearch> paramArrayList);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/onboarding/action/GetCategoryRecommedForumAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */