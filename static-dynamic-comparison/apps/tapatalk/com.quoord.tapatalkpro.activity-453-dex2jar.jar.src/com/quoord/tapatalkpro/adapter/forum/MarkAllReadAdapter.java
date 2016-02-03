package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.util.TapatalkEngine;

import java.util.ArrayList;

public class MarkAllReadAdapter
        extends ForumRootAdapter {
    public MarkAllReadAdapter(Activity paramActivity, String paramString) {
        super(paramActivity, paramString);
        setOpCancel(false);
        markAllRead();
    }

    public int getCount() {
        return 0;
    }

    public Object getItem(int paramInt) {
        return null;
    }

    public long getItemId(int paramInt) {
        return 0L;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        return null;
    }

    public void markAllRead() {
        ArrayList localArrayList = new ArrayList();
        setTryTwice(false);
        this.engine.call("mark_all_as_read", localArrayList);
        this.forumStatus.cleanNewPost();
        com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity.needRefreshCategories = true;
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
        if (paramEngineResponse.getMethod().equals("mark_all_as_read")) {
            this.mStatus.updateUI(45, paramEngineResponse.getResponse());
        }
    }

    public void refresh() {
        setOpCancel(false);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/MarkAllReadAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */