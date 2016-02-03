package com.quoord.tapatalkpro.adapter.forum;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.quoord.tapatalkpro.activity.forum.ProfilesOuterFragment;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.NoTopicView;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.bean.TopicParser;
import com.quoord.tapatalkpro.util.TapatalkEngine;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class StartPostAdapter
        extends ForumRootAdapter {
    private LinearLayout footlay;
    private ForumStatus forumStatus;
    private ArrayList<Object> mDatas = new ArrayList();
    private ProfilesOuterFragment outerFragment;
    private String userId;
    private String userName;

    public StartPostAdapter(ProfilesOuterFragment paramProfilesOuterFragment, ForumStatus paramForumStatus, String paramString1, String paramString2, String paramString3, LinearLayout paramLinearLayout) {
        super(paramProfilesOuterFragment.mActivity, paramProfilesOuterFragment, paramString1);
        this.outerFragment = paramProfilesOuterFragment;
        this.forumStatus = paramForumStatus;
        this.userName = paramString2;
        this.userId = paramString3;
        this.footlay = paramLinearLayout;
        paramProfilesOuterFragment = new ArrayList();
        if ((this.userName != null) && (!this.userName.equals(""))) {
        }
        try {
            paramProfilesOuterFragment.add(this.userName.getBytes("UTF-8"));
            if ((this.userId != null) && (!this.userId.equals(""))) {
                paramProfilesOuterFragment.add(this.userId);
            }
            this.engine.call("get_user_topic", paramProfilesOuterFragment);
            return;
        } catch (UnsupportedEncodingException paramForumStatus) {
            for (; ; ) {
                paramForumStatus.printStackTrace();
            }
        }
    }

    public int getCount() {
        return this.mDatas.size();
    }

    public Object getItem(int paramInt) {
        return this.mDatas.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if ((getItem(paramInt) instanceof NoTopicView)) {
            return ((NoTopicView) getItem(paramInt)).getItemView(this.outerFragment.mActivity);
        }
        paramViewGroup = new HashMap();
        paramViewGroup.put("showForumName", Boolean.valueOf(true));
        paramViewGroup.put("isSubscribedTab", Boolean.valueOf(false));
        return ((Topic) getItem(paramInt)).createView(paramViewGroup, paramView, this.outerFragment);
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
        if (paramEngineResponse.getMethod().equals("get_user_topic")) {
            if (paramEngineResponse.isSuccess()) {
                break label55;
            }
            this.mDatas.add(new NoTopicView());
        }
        for (; ; ) {
            if (this.footlay != null) {
                this.footlay.setVisibility(8);
            }
            notifyDataSetChanged();
            return;
            label55:
            paramEngineResponse = (Object[]) paramEngineResponse.getResponse();
            if (paramEngineResponse.length <= 0) {
                this.mDatas.add(new NoTopicView());
            } else {
                int i = 0;
                while (i < paramEngineResponse.length) {
                    Topic localTopic = TopicParser.createTopicBean((HashMap) paramEngineResponse[i], null, this.outerFragment.mActivity, this.forumStatus);
                    this.mDatas.add(localTopic);
                    i += 1;
                }
            }
        }
    }

    public void refresh() {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/StartPostAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */