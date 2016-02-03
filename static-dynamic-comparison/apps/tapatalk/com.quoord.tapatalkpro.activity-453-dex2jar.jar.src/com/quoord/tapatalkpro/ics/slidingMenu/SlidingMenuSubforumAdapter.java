package com.quoord.tapatalkpro.ics.slidingMenu;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.saxparser.ForumSaxParser;
import com.quoord.tapatalkpro.util.TapatalkEngine;

import java.util.ArrayList;

public class SlidingMenuSubforumAdapter
        extends ForumRootAdapter {
    public ArrayList<Object> mDatas = new ArrayList();
    protected ForumSaxParser mForumParser;

    public SlidingMenuSubforumAdapter(Activity paramActivity, String paramString) {
        super(paramActivity, paramString);
        getForum();
    }

    public int getCount() {
        return this.mDatas.size();
    }

    public void getForum() {
        this.mDatas.clear();
        notifyDataSetChanged();
        setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Boolean.valueOf(true));
        localArrayList.add("75");
        this.engine.call("get_forum", localArrayList);
    }

    public Object getItem(int paramInt) {
        return this.mDatas.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        return null;
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
        if (paramEngineResponse.getMethod().equals("get_forum")) {
            this.mDatas.clear();
            paramEngineResponse = (Object[]) paramEngineResponse.getResponse();
        }
        notifyDataSetChanged();
    }

    public void refresh() {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/SlidingMenuSubforumAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */