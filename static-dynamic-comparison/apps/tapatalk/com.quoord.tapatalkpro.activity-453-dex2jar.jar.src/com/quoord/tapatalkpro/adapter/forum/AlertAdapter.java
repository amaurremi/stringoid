package com.quoord.tapatalkpro.adapter.forum;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.quoord.tapatalkpro.activity.forum.PmContentFragment;
import com.quoord.tapatalkpro.activity.forum.ThreadOuterFragment;
import com.quoord.tapatalkpro.activity.forum.conversation.ConversationOuterFragment;
import com.quoord.tapatalkpro.bean.Alert;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.NoTopicView;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.util.ArrayList;
import java.util.HashMap;

public class AlertAdapter
        extends ForumRootAdapter {
    public int currentSelectedPosition = -1;
    private LinearLayout footlay = null;
    private boolean isLoadingMore = true;
    public ListView listView = null;
    private Activity mActivity;
    private ArrayList<Object> mData = new ArrayList();
    private int page = 1;
    private int per_page = 20;
    public int realaconut;
    public int total = 0;

    public AlertAdapter(Activity paramActivity, String paramString, ListView paramListView) {
        super(paramActivity, paramString);
        this.mActivity = paramActivity;
        this.listView = paramListView;
        this.footlay = ButtomProgress.get(this.mActivity);
        setLoadingMoreEnabled(true);
        this.listView.setAdapter(this);
        setOnClickListener();
        getAlert(this.page);
        GoogleAnalyticsTools.trackPageView(this.mActivity, "notifications", this.forumStatus.getForumId(), this.forumStatus.getUrl());
    }

    public void getAlert(int paramInt) {
        setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(paramInt));
        localArrayList.add(Integer.valueOf(this.per_page));
        this.engine.call("get_alert", localArrayList);
        this.isLoadingMore = true;
    }

    public int getCount() {
        return this.mData.size();
    }

    public Object getItem(int paramInt) {
        return this.mData.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public int getItemViewType(int paramInt) {
        if ((getItem(paramInt) instanceof Alert)) {
            return 0;
        }
        return 1;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if ((this.mActivity instanceof SlidingMenuActivity)) {
            bool1 = bool2;
            if (((SlidingMenuActivity) this.mActivity).getShowSlectionStatus()) {
                if (paramInt != this.currentSelectedPosition) {
                    break label97;
                }
                bool1 = true;
            }
        }
        if ((getItem(paramInt) instanceof Alert)) {
            int i;
            if ((paramInt == 0) && (getCount() == 1)) {
                i = Alert.ONE_ALERT_ITEM;
            }
            for (; ; ) {
                return ((Alert) getItem(paramInt)).getAlertView(paramInt, paramView, paramViewGroup, this, this.mActivity, i, bool1);
                label97:
                bool1 = false;
                break;
                if ((paramInt == 0) && (getCount() > 1)) {
                    i = Alert.TOP_ALERT_ITEM;
                } else if ((paramInt == getCount() - 1) && (getCount() > 1)) {
                    i = Alert.BOTTOM_ALERT_ITEM;
                } else {
                    i = Alert.MID_ALERT_ITEM;
                }
            }
        }
        return ((NoTopicView) getItem(paramInt)).getItemView(this.mActivity, this.mActivity.getResources().getString(2131100208));
    }

    public int getViewTypeCount() {
        return 2;
    }

    public void loadmore() {
        this.listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                paramAnonymousInt1 += paramAnonymousInt2;
                if ((paramAnonymousInt1 != 0) && (paramAnonymousInt1 == paramAnonymousInt3) && (paramAnonymousInt3 > 2) && (!AlertAdapter.this.isLoadingMore) && (AlertAdapter.this.mData.size() < AlertAdapter.this.total) && (AlertAdapter.this.realaconut == 0)) {
                    AlertAdapter.this.setLoadingMoreEnabled(true);
                    paramAnonymousAbsListView = AlertAdapter.this;
                    paramAnonymousAbsListView.page += 1;
                    AlertAdapter.this.getAlert(AlertAdapter.this.page);
                }
            }

            public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
            }
        });
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
        Object localObject1 = paramEngineResponse.getMethod();
        int i;
        if ((localObject1 != null) && (((String) localObject1).equals("get_alert"))) {
            paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
            this.total = ((Integer) paramEngineResponse.get("total")).intValue();
            paramEngineResponse = (Object[]) paramEngineResponse.get("items");
            i = 0;
        }
        for (; ; ) {
            if (i >= paramEngineResponse.length) {
                if (paramEngineResponse.length == 0) {
                    this.realaconut = this.mData.size();
                }
                if (this.mData.size() == 0) {
                    this.mData.add(new NoTopicView());
                }
                this.isLoadingMore = false;
                loadmore();
                notifyDataSetChanged();
                setLoadingMoreEnabled(false);
                return;
            }
            localObject1 = new Alert();
            Object localObject2 = (HashMap) paramEngineResponse[i];
            String str1 = (String) ((HashMap) localObject2).get("timestamp");
            String str2 = (String) ((HashMap) localObject2).get("icon_url");
            String str3 = (String) ((HashMap) localObject2).get("user_id");
            String str4 = new String((byte[]) ((HashMap) localObject2).get("username"));
            String str5 = new String((byte[]) ((HashMap) localObject2).get("message"));
            String str6 = (String) ((HashMap) localObject2).get("content_type");
            localObject2 = (String) ((HashMap) localObject2).get("content_id");
            ((Alert) localObject1).setTimestamp(str1);
            ((Alert) localObject1).setIcon_url(str2);
            ((Alert) localObject1).setUser_id(str3);
            ((Alert) localObject1).setUser_name(str4);
            ((Alert) localObject1).setMessage(str5);
            ((Alert) localObject1).setContent_id((String) localObject2);
            ((Alert) localObject1).setContent_type(str6);
            ((Alert) localObject1).setIcon(this.mActivity, str6);
            this.mData.add(localObject1);
            i += 1;
        }
    }

    public void refresh() {
        if (!this.isLoadingMore) {
            if (this.listView.getFooterViewsCount() > 0) {
                this.listView.removeFooterView(this.footlay);
            }
            this.listView.addFooterView(this.footlay);
            this.mData.clear();
            this.page = 1;
            getAlert(this.page);
            notifyDataSetChanged();
        }
    }

    public void setLoadingMoreEnabled(boolean paramBoolean) {
        if ((paramBoolean) && (this.listView.getFooterViewsCount() == 0)) {
            this.listView.addFooterView(this.footlay);
        }
        while ((paramBoolean) || (this.listView.getFooterViewsCount() <= 0)) {
            return;
        }
        this.listView.removeFooterView(this.footlay);
    }

    public void setOnClickListener() {
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                if (((AlertAdapter.this.listView.getFooterViewsCount() > 0) && (AlertAdapter.this.mData.size() <= 0)) || (paramAnonymousInt >= AlertAdapter.this.mData.size())) {
                    return;
                }
                if ((AlertAdapter.this.mData.get(paramAnonymousInt) instanceof Alert)) {
                    AlertAdapter.this.currentSelectedPosition = paramAnonymousInt;
                    if (!((Alert) AlertAdapter.this.mData.get(paramAnonymousInt)).getContent_type().equals("pm")) {
                        break label167;
                    }
                    paramAnonymousAdapterView = new HashMap();
                    paramAnonymousAdapterView.put("forumStatus", AlertAdapter.this.forumStatus);
                    paramAnonymousAdapterView.put("pmid", ((Alert) AlertAdapter.this.mData.get(paramAnonymousInt)).getContent_id());
                    ((SlidingMenuActivity) AlertAdapter.this.mActivity).showDetail(new PmContentFragment(false, paramAnonymousAdapterView));
                }
                for (; ; ) {
                    AlertAdapter.this.notifyDataSetChanged();
                    return;
                    label167:
                    if (((Alert) AlertAdapter.this.mData.get(paramAnonymousInt)).getContent_type().equals("conv")) {
                        paramAnonymousAdapterView = new HashMap();
                        paramAnonymousAdapterView.put("forumStatus", AlertAdapter.this.forumStatus);
                        paramAnonymousAdapterView.put("conv_id", ((Alert) AlertAdapter.this.mData.get(paramAnonymousInt)).getContent_id());
                        ((SlidingMenuActivity) AlertAdapter.this.mActivity).showDetail(new ConversationOuterFragment(false, paramAnonymousAdapterView));
                    } else {
                        paramAnonymousAdapterView = new HashMap();
                        paramAnonymousAdapterView.put("forumStatus", AlertAdapter.this.forumStatus);
                        paramAnonymousAdapterView.put("getPost", Boolean.valueOf(true));
                        paramAnonymousAdapterView.put("post_id", ((Alert) AlertAdapter.this.mData.get(paramAnonymousInt)).getContent_id());
                        paramAnonymousAdapterView.put("topic_title", "");
                        paramAnonymousAdapterView.put("reply_count", Integer.valueOf(0));
                        paramAnonymousAdapterView.put("forumid", "0");
                        paramAnonymousAdapterView.put("isNew", Boolean.valueOf(false));
                        if (((Alert) AlertAdapter.this.mData.get(paramAnonymousInt)).getContent_type().equals("announcement")) {
                            paramAnonymousAdapterView.put("isAnn", Boolean.valueOf(true));
                        }
                        ((SlidingMenuActivity) AlertAdapter.this.mActivity).getActionBar().setDisplayShowTitleEnabled(false);
                        ((SlidingMenuActivity) AlertAdapter.this.mActivity).showDetail(new ThreadOuterFragment(false, paramAnonymousAdapterView));
                    }
                }
            }
        });
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/AlertAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */