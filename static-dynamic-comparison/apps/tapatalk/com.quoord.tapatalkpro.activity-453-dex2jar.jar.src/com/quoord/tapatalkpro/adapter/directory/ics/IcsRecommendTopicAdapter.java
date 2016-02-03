package com.quoord.tapatalkpro.adapter.directory.ics;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.FeedAction;
import com.quoord.tapatalkpro.action.FeedAction.FeedActionCallBack;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class IcsRecommendTopicAdapter
        extends BaseAdapter {
    private FavoriateSqlHelper favHelper;
    private ListView listView;
    private Activity mActivity;
    private ArrayList<Object> mDatas = new ArrayList();
    public int page = 1;
    private ProgressDialog progress;
    private String round = null;

    public IcsRecommendTopicAdapter(Activity paramActivity, ArrayList<Object> paramArrayList, ListView paramListView, String paramString) {
        this.mActivity = paramActivity;
        this.mDatas = paramArrayList;
        this.listView = paramListView;
        this.round = paramString;
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        this.progress = new ProgressDialog(this.mActivity);
        this.progress.setMessage(this.mActivity.getResources().getString(2131100313));
        this.favHelper = new FavoriateSqlHelper(this.mActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
        setListenerAfterActivityCreated();
    }

    private void setListenerAfterActivityCreated() {
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                if ((IcsRecommendTopicAdapter.this.getItem(paramAnonymousInt) instanceof Topic)) {
                    paramAnonymousAdapterView = (Topic) IcsRecommendTopicAdapter.this.getItem(paramAnonymousInt);
                    paramAnonymousView = IcsRecommendTopicAdapter.this.favHelper.getFavrivateById(paramAnonymousAdapterView.getTapatalkForumId());
                    if (paramAnonymousView != null) {
                        paramAnonymousAdapterView.openThreadFromFeed(paramAnonymousView, IcsRecommendTopicAdapter.this.mActivity, "push");
                        IcsRecommendTopicAdapter.this.mActivity.finish();
                        IcsRecommendTopicAdapter.this.notifyDataSetChanged();
                        IcsRecommendTopicAdapter.this.recommendLog(paramAnonymousView, paramAnonymousAdapterView);
                    }
                } else {
                    return;
                }
                IcsRecommendTopicAdapter.this.progress.show();
                IcsRecommendTopicAdapter.this.checkTapatalkForum(paramAnonymousAdapterView);
            }
        });
    }

    public void checkTapatalkForum(final Topic paramTopic) {
        new FeedAction(this.mActivity, false).getTapatalkForums(DirectoryUrlUtil.createGetForumById(this.mActivity, paramTopic.getTapatalkForumId()), new FeedAction.FeedActionCallBack() {
            public void actionCallBack(ArrayList<Object> paramAnonymousArrayList, boolean paramAnonymousBoolean) {
                ((ForumActivityStatus) IcsRecommendTopicAdapter.this.mActivity).closeProgress();
                if ((paramAnonymousArrayList != null) && (paramAnonymousArrayList.size() > 0)) {
                    paramAnonymousArrayList = (TapatalkForum) paramAnonymousArrayList.get(0);
                    if (paramTopic.getTapatalkForumId().equals(paramAnonymousArrayList.getId().toString())) {
                        paramTopic.openThreadFromFeed(paramAnonymousArrayList, IcsRecommendTopicAdapter.this.mActivity, "push");
                        IcsRecommendTopicAdapter.this.recommendLog(paramAnonymousArrayList, paramTopic);
                        IcsRecommendTopicAdapter.this.mActivity.finish();
                        IcsRecommendTopicAdapter.this.progress.cancel();
                    }
                }
            }
        });
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
        paramViewGroup = paramView;
        if ((getItem(paramInt) instanceof Topic)) {
            paramViewGroup = (Topic) getItem(paramInt);
            HashMap localHashMap = new HashMap();
            localHashMap.put("showForumName", Boolean.valueOf(true));
            localHashMap.put("isSubscribedTab", Boolean.valueOf(false));
            paramViewGroup = paramViewGroup.createView(localHashMap, paramView, (ForumActivityStatus) this.mActivity, true);
        }
        return paramViewGroup;
    }

    public void recommendLog(TapatalkForum paramTapatalkForum, Topic paramTopic) {
        int i = Prefs.get(this.mActivity).getInt("tapatalk_auid", -1);
        paramTapatalkForum = TapatalkJsonEngine.LOG_RECOMMEND_TOPIC + "?au_id=" + i + "&fid=" + paramTapatalkForum.getId() + "&tid=" + paramTopic.getId() + "&round=" + this.round + "&" + TapatalkApp.APP_KEY;
        TapatalkJsonEngine.callLogin(this.mActivity, paramTapatalkForum);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/directory/ics/IcsRecommendTopicAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */