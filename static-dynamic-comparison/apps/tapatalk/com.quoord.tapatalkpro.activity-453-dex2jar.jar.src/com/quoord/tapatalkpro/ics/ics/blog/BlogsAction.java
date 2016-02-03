package com.quoord.tapatalkpro.ics.ics.blog;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.ListView;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.util.JsonRpcEngine;
import com.quoord.tapatalkpro.util.Prefs;

import java.util.ArrayList;
import java.util.HashMap;

public class BlogsAction
        implements CallBackInterface {
    public static final String BLOGSETTINGS = "blogsettings";
    public static final String CLICKPOSITION = "clickposition";
    private BlogsActionCallBack blogsActionCallBack;
    private ListView categoryList;
    private String categoryUrl;
    public SharedPreferences.Editor editor;
    private JsonRpcEngine engine;
    private ForumStatus forumStatus;
    private HashMap<Integer, Boolean> isSelected;
    private Activity mActivity;
    public ArrayList<Blog> mDatas = new ArrayList();
    public SharedPreferences prefs;

    public BlogsAction(Activity paramActivity, String paramString, ForumStatus paramForumStatus, BlogsActionCallBack paramBlogsActionCallBack) {
        this.blogsActionCallBack = paramBlogsActionCallBack;
        this.forumStatus = paramForumStatus;
        this.engine = new JsonRpcEngine(this, paramForumStatus, paramActivity);
        this.categoryUrl = paramString;
        this.mActivity = paramActivity;
        this.prefs = Prefs.get(this.mActivity);
        this.editor = this.prefs.edit();
    }

    public void callBack(EngineResponse paramEngineResponse) {
        if (this.blogsActionCallBack != null) {
            this.blogsActionCallBack.actionCallBack(paramEngineResponse);
        }
    }

    public void getBlogsCategoryList() {
        this.engine.call(this.categoryUrl);
    }

    public boolean isOpCancel() {
        return false;
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void updateSubclassDialog(int paramInt) {
    }

    public static abstract interface BlogsActionCallBack {
        public abstract void actionCallBack(EngineResponse paramEngineResponse);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/ics/blog/BlogsAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */