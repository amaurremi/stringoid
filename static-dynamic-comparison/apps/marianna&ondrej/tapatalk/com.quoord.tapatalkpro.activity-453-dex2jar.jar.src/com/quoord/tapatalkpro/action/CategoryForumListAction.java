package com.quoord.tapatalkpro.action;

import android.app.Activity;
import com.quoord.tapatalkpro.bean.TapatalkForumForSearch;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;
import com.quoord.tools.net.TapatalkAjaxAction;
import com.quoord.tools.net.TapatalkAjaxAction.ActionCallBack;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

public class CategoryForumListAction {
    private CategoryForumListActionCallBack actionCallBack;
    private Activity mActivity;

    public CategoryForumListAction(Activity paramActivity) {
        this.mActivity = paramActivity;
    }

    public void getRemoteCategoryForumList(String paramString, int paramInt, CategoryForumListActionCallBack paramCategoryForumListActionCallBack) {
        this.actionCallBack = paramCategoryForumListActionCallBack;
        paramString = DirectoryUrlUtil.getCategoryForumListUrl(this.mActivity, paramString, paramInt);
        new TapatalkAjaxAction(this.mActivity).getJsonArrayAction(paramString, new TapatalkAjaxAction.ActionCallBack() {
            public void actionCallBack(Object paramAnonymousObject) {
                ArrayList localArrayList = new ArrayList();
                for (; ; ) {
                    try {
                        paramAnonymousObject = (JSONArray) paramAnonymousObject;
                        i = 0;
                        int j = ((JSONArray) paramAnonymousObject).length();
                        if (i < j) {
                            continue;
                        }
                    } catch (JSONException paramAnonymousObject) {
                        int i;
                        ((JSONException) paramAnonymousObject).printStackTrace();
                        continue;
                    }
                    CategoryForumListAction.this.actionCallBack.actionCallBack(localArrayList);
                    return;
                    localArrayList.add(TapatalkForumForSearch.getForum(((JSONArray) paramAnonymousObject).getJSONObject(i), null, null, null));
                    i += 1;
                }
            }
        });
    }

    public static abstract interface CategoryForumListActionCallBack {
        public abstract void actionCallBack(ArrayList<Object> paramArrayList);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/CategoryForumListAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */