package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.quoord.tapatalkpro.activity.forum.ProfilesOuterFragment;
import com.quoord.tapatalkpro.activity.forum.RepliesFragment;
import com.quoord.tapatalkpro.activity.forum.ThreadActivity;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.NoTopicView;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.bean.TopicParser;
import com.quoord.tapatalkpro.util.TapatalkEngine;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class RepliesAdapter
        extends ForumRootAdapter {
    private LinearLayout footlay;
    private RepliesFragment fragment;
    private ListView listView;
    private ArrayList<Object> mDatas = new ArrayList();
    private ProfilesOuterFragment outerFragment;
    private String userId;
    private String userName;

    public RepliesAdapter(ProfilesOuterFragment paramProfilesOuterFragment, String paramString1, String paramString2, String paramString3, ListView paramListView, LinearLayout paramLinearLayout, RepliesFragment paramRepliesFragment) {
        super(paramProfilesOuterFragment.mActivity, paramProfilesOuterFragment, paramString1);
        this.outerFragment = paramProfilesOuterFragment;
        this.userName = paramString2;
        this.userId = paramString3;
        this.listView = paramListView;
        this.footlay = paramLinearLayout;
        this.fragment = paramRepliesFragment;
        this.forumStatus = this.outerFragment.forumStatus;
        paramProfilesOuterFragment = new ArrayList();
        if ((this.userName != null) && (!this.userName.equals(""))) {
        }
        try {
            paramProfilesOuterFragment.add(this.userName.getBytes("UTF-8"));
            if ((this.userId != null) && (!this.userId.equals(""))) {
                paramProfilesOuterFragment.add(this.userId);
            }
            this.engine.call("get_user_reply_post", paramProfilesOuterFragment);
            this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                    if (((RepliesAdapter.this.getItem(paramAnonymousInt) instanceof Topic)) && (RepliesAdapter.this.forumStatus != null)) {
                        RepliesAdapter.this.setmLongclickItemPosition(paramAnonymousInt);
                        paramAnonymousAdapterView = new Intent(RepliesAdapter.this.outerFragment.mActivity, ThreadActivity.class);
                        paramAnonymousAdapterView.putExtra("forumStatus", RepliesAdapter.this.forumStatus);
                        paramAnonymousAdapterView.putExtra("topic_id", ((Topic) RepliesAdapter.this.getItem(paramAnonymousInt)).getId());
                        paramAnonymousAdapterView.putExtra("post_id", ((Topic) RepliesAdapter.this.getItem(paramAnonymousInt)).getPostId());
                        paramAnonymousAdapterView.putExtra("getPost", true);
                        RepliesAdapter.this.outerFragment.startActivity(paramAnonymousAdapterView);
                    }
                }
            });
            this.listView.setOnItemLongClickListener(new topicListLongClickListener());
            return;
        } catch (UnsupportedEncodingException paramString1) {
            for (; ; ) {
                paramString1.printStackTrace();
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
            return ((NoTopicView) getItem(paramInt)).getItemView(this.outerFragment.mActivity, this.outerFragment.mActivity.getResources().getString(2131100140));
        }
        paramViewGroup = new HashMap();
        paramViewGroup.put("showForumName", Boolean.valueOf(true));
        paramViewGroup.put("isSubscribedTab", Boolean.valueOf(false));
        return ((Topic) getItem(paramInt)).createView(paramViewGroup, paramView, this.outerFragment);
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
        if (paramEngineResponse.getMethod().equals("get_user_reply_post")) {
            paramEngineResponse = (Object[]) paramEngineResponse.getResponse();
            if (paramEngineResponse.length > 0) {
                break label61;
            }
            this.mDatas.add(new NoTopicView());
        }
        for (; ; ) {
            if (this.footlay != null) {
                this.footlay.setVisibility(8);
            }
            notifyDataSetChanged();
            return;
            label61:
            int i = 0;
            while (i < paramEngineResponse.length) {
                Topic localTopic = TopicParser.createTopicBean((HashMap) paramEngineResponse[i], null, this.outerFragment.mActivity, this.forumStatus);
                if ((localTopic.getLastPosterName() == null) || (localTopic.getLastPosterName().equals(""))) {
                    localTopic.setLastPosterName(this.outerFragment.mIconUsername);
                }
                this.mDatas.add(localTopic);
                i += 1;
            }
        }
    }

    public void refresh() {
    }

    class topicListLongClickListener
            implements AdapterView.OnItemLongClickListener {
        topicListLongClickListener() {
        }

        public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
            paramInt -= RepliesAdapter.this.listView.getHeaderViewsCount();
            if ((paramInt >= RepliesAdapter.this.getCount()) || (RepliesAdapter.this.getCount() <= paramInt)) {
                return true;
            }
            ((Topic) RepliesAdapter.this.getItem(paramInt)).getLongClickDialog(RepliesAdapter.this, RepliesAdapter.this.outerFragment.mActivity, RepliesAdapter.this.forumStatus).show();
            return true;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/RepliesAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */