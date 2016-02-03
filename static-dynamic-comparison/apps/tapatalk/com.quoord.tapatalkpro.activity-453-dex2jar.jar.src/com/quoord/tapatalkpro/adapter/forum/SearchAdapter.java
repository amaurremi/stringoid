package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.SearchActivity;
import com.quoord.tapatalkpro.activity.forum.SearchFragment;
import com.quoord.tapatalkpro.activity.forum.StartPostFragment;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.NoTopicView;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.advancesearch.AdvanceSearchResultFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.saxparser.TopicSaxParser;
import com.quoord.tapatalkpro.saxparser.TopicSaxParser.ICallback;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.AdvancesearchContrast;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class SearchAdapter
        extends ForumRootAdapter {
    private int SAX_CLOSE_PROGRESS = 0;
    private int SAX_DISPLAY_ERROR = 8;
    private int SAX_UPDATE_BEGIN = 3;
    private int SAX_UPDATE_END = 2;
    private int SAX_UPDATE_ITEM = 1;
    public int currentSelectedPosition = -1;
    private String forumId;
    Activity mContext;
    private ArrayList<Object> mDatas = new ArrayList();
    private int mPage = 1;
    private int mStart;
    private TopicSaxParser mTopicParser;
    private Handler mUIHandler;
    private int onlyTitle = 0;
    private int postPerPage = 20;
    private String searchId;
    private String searchQuery;
    private boolean showpost;
    private String threadId;
    private boolean titleOnly;
    private int total_num;
    TextView tv;
    private String userId;
    private String userName;

    public SearchAdapter(Activity paramActivity, String paramString, AdvancesearchContrast paramAdvancesearchContrast, final QuoordFragment paramQuoordFragment) {
        super(paramActivity, paramString);
        this.mContext = paramActivity;
        this.searchQuery = paramAdvancesearchContrast.KEYWORD;
        this.forumId = paramAdvancesearchContrast.FORUMID;
        this.userName = paramAdvancesearchContrast.USERNAME;
        this.titleOnly = paramAdvancesearchContrast.TITLEONLY;
        this.threadId = paramAdvancesearchContrast.THREADID;
        this.showpost = paramAdvancesearchContrast.SHOWPOSTS;
        this.userId = paramAdvancesearchContrast.USERID;
        this.mTopicParser = new TopicSaxParser(this.mContext, this.forumStatus);
        getTopicDatas();
        this.mUIHandler = new Handler() {
            public void handleMessage(Message paramAnonymousMessage) {
                if (paramAnonymousMessage.what == SearchAdapter.this.SAX_CLOSE_PROGRESS) {
                    SearchAdapter.this.total_num = ((Integer) paramAnonymousMessage.obj).intValue();
                }
                if (paramAnonymousMessage.what == SearchAdapter.this.SAX_UPDATE_ITEM) {
                    SearchAdapter.this.mDatas.add(paramAnonymousMessage.obj);
                    SearchAdapter.this.notifyDataSetChanged();
                }
                if (paramAnonymousMessage.what == SearchAdapter.this.SAX_UPDATE_END) {
                    SearchAdapter.this.loadingMore = false;
                    SearchAdapter.this.notifyDataSetChanged();
                    if (SearchAdapter.this.total_num == 0) {
                        if ((paramQuoordFragment == null) || (!(paramQuoordFragment instanceof StartPostFragment))) {
                            break label259;
                        }
                        SearchAdapter.this.mDatas.add(new NoTopicView());
                    }
                }
                if (paramAnonymousMessage.what == SearchAdapter.this.SAX_UPDATE_BEGIN) {
                    SearchAdapter localSearchAdapter = SearchAdapter.this;
                    localSearchAdapter.mStart += SearchAdapter.this.postPerPage;
                    SearchAdapter.this.notifyDataSetChanged();
                }
                if (paramAnonymousMessage.what == SearchAdapter.this.SAX_DISPLAY_ERROR) {
                    paramAnonymousMessage = (String) paramAnonymousMessage.obj;
                    Toast.makeText(SearchAdapter.this.mContext, paramAnonymousMessage, 1);
                }
                if ((paramQuoordFragment != null) && ((paramQuoordFragment instanceof AdvanceSearchResultFragment)) && (((AdvanceSearchResultFragment) paramQuoordFragment).listView != null)) {
                    ((AdvanceSearchResultFragment) paramQuoordFragment).removeListFootLay();
                }
                label259:
                do {
                    return;
                    SearchAdapter.this.mDatas.add(new SearchAdapter.NoSearchResult());
                    break;
                    if ((paramQuoordFragment != null) && ((paramQuoordFragment instanceof StartPostFragment)) && (((StartPostFragment) paramQuoordFragment).listView != null)) {
                        ((StartPostFragment) paramQuoordFragment).removeListFootLay();
                        return;
                    }
                }
                while ((!(SearchAdapter.this.mContext instanceof SearchActivity)) || (((SearchActivity) SearchAdapter.this.mContext).showFragment == null) || (((SearchActivity) SearchAdapter.this.mContext).showFragment.listView == null));
                ((SearchActivity) SearchAdapter.this.mContext).removeListFootLay();
            }
        };
        if (this.forumStatus.isAdvancedSearch()) {
            getSearchTopicAdvance();
            return;
        }
        getSearchTopic();
    }

    public void cancel(boolean paramBoolean) {
        this.isOpCancel = paramBoolean;
    }

    public int getCount() {
        return this.mDatas.size();
    }

    public Object getItem(int paramInt) {
        if (paramInt < this.mDatas.size()) {
            return this.mDatas.get(paramInt);
        }
        return null;
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public int getItemViewType(int paramInt) {
        if ((getItem(paramInt) instanceof NoSearchResult)) {
            return 0;
        }
        if ((getItem(paramInt) instanceof NoTopicView)) {
            return 1;
        }
        return 2;
    }

    public void getSearchTopic() {
        ArrayList localArrayList = new ArrayList();
        this.loadingMore = true;
        try {
            byte[] arrayOfByte = this.searchQuery.getBytes("UTF-8");
            localArrayList.add(arrayOfByte);
            localArrayList.add(Integer.valueOf(this.mStart));
            localArrayList.add(Integer.valueOf(this.mStart + this.postPerPage - 1));
            if ((this.forumStatus.isSearchIDEnabled()) && (this.searchId != null)) {
                localArrayList.add(this.searchId);
                this.engine.saxcall(this.mTopicParser, "search_topic", localArrayList);
                return;
            }
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            for (; ; ) {
                Object localObject = this.searchQuery.getBytes();
                continue;
                if ((this.forumStatus.getApiLevel() >= 4) || (this.forumStatus.isAdvancedSearch())) {
                    localArrayList.add("");
                    if ((this.forumId != null) && (!this.forumId.equals(""))) {
                        localObject = new HashMap();
                        String str = this.forumId;
                        ((HashMap) localObject).put("forumid", this.forumId);
                        localArrayList.add(localObject);
                    }
                }
            }
        }
    }

    public void getSearchTopicAdvance() {
        ArrayList localArrayList = new ArrayList();
        this.loadingMore = true;
        try {
            Object localObject = this.searchQuery.getBytes("UTF-8");
            localHashMap = new HashMap();
            localHashMap.put("page", Integer.valueOf(this.mPage));
            localHashMap.put("perpage", Integer.valueOf(20));
            localHashMap.put("keywords", localObject);
            if (this.titleOnly) {
                this.onlyTitle = 1;
                localHashMap.put("titleonly", Integer.valueOf(this.onlyTitle));
                if ((this.threadId != null) && (!this.threadId.equals(""))) {
                    localHashMap.put("threadid", this.threadId);
                }
                if (!this.showpost) {
                    break label299;
                }
                localHashMap.put("showposts", Integer.valueOf(1));
                if ((this.userName != null) && (this.userName.length() > 0)) {
                    localHashMap.put("searchuser", this.userName);
                }
                if ((this.forumId != null) && (!this.forumId.equals(""))) {
                    localObject = new ArrayList();
                    ((ArrayList) localObject).add(this.forumId);
                    localHashMap.put("only_in", localObject);
                }
                if (this.searchId != null) {
                    localHashMap.put("searchid", this.searchId);
                }
                if (this.userId != null) {
                    localHashMap.put("userid", this.userId);
                }
                localArrayList.add(localHashMap);
                this.engine.saxcall(this.mTopicParser, "search", localArrayList);
            }
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            for (; ; ) {
                HashMap localHashMap;
                byte[] arrayOfByte = this.searchQuery.getBytes();
                continue;
                this.onlyTitle = 0;
                continue;
                label299:
                localHashMap.put("showposts", Integer.valueOf(0));
            }
        }
    }

    public void getTopicDatas() {
        this.mTopicParser.setCallback(new TopicSaxParser.ICallback() {
            public void onAddItem(Topic paramAnonymousTopic) {
                Message localMessage = SearchAdapter.this.mUIHandler.obtainMessage();
                localMessage.what = SearchAdapter.this.SAX_UPDATE_ITEM;
                localMessage.obj = paramAnonymousTopic;
                SearchAdapter.this.mUIHandler.sendMessage(localMessage);
            }

            public void onDocBegin() {
                Message localMessage = SearchAdapter.this.mUIHandler.obtainMessage();
                localMessage.what = SearchAdapter.this.SAX_UPDATE_BEGIN;
                SearchAdapter.this.mUIHandler.sendMessage(localMessage);
            }

            public void onDocEnd() {
                Message localMessage = SearchAdapter.this.mUIHandler.obtainMessage();
                localMessage.what = SearchAdapter.this.SAX_UPDATE_END;
                SearchAdapter localSearchAdapter = SearchAdapter.this;
                localSearchAdapter.mPage += 1;
                SearchAdapter.this.mUIHandler.sendMessage(localMessage);
            }

            public void onGetResultText(String paramAnonymousString) {
                Message localMessage = SearchAdapter.this.mUIHandler.obtainMessage();
                localMessage.what = SearchAdapter.this.SAX_DISPLAY_ERROR;
                localMessage.obj = paramAnonymousString;
                SearchAdapter.this.mUIHandler.sendMessage(localMessage);
            }

            public void onGetSearchID(String paramAnonymousString) {
                SearchAdapter.this.searchId = paramAnonymousString;
            }

            public void onGetTopicNum(int paramAnonymousInt) {
                Message localMessage = SearchAdapter.this.mUIHandler.obtainMessage();
                localMessage.what = SearchAdapter.this.SAX_CLOSE_PROGRESS;
                localMessage.obj = Integer.valueOf(paramAnonymousInt);
                SearchAdapter.this.mUIHandler.sendMessage(localMessage);
            }
        });
    }

    public int getTotal_num() {
        return this.total_num;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if ((getItem(paramInt) instanceof NoSearchResult)) {
            new NoSearchResult();
            return NoSearchResult.getView(this.mContext);
        }
        if ((getItem(paramInt) instanceof NoTopicView)) {
            return ((NoTopicView) getItem(paramInt)).getItemView(this.mContext);
        }
        paramViewGroup = new HashMap();
        paramViewGroup.put("showForumName", Boolean.valueOf(true));
        paramViewGroup.put("isSubscribedTab", Boolean.valueOf(false));
        if (((this.mContext instanceof SlidingMenuActivity)) && (((SlidingMenuActivity) this.mContext).getShowSlectionStatus())) {
            if (paramInt != this.currentSelectedPosition) {
                break label150;
            }
            paramViewGroup.put("showSelectBg", Boolean.valueOf(true));
        }
        for (; ; ) {
            return ((Topic) getItem(paramInt)).createView(paramViewGroup, paramView, (ForumActivityStatus) this.mContext);
            label150:
            paramViewGroup.put("showSelectBg", Boolean.valueOf(false));
        }
    }

    public int getViewTypeCount() {
        return 3;
    }

    public boolean isEnabled(int paramInt) {
        return (getItem(paramInt) instanceof Topic);
    }

    public boolean isFootNeeded() {
        if (this.forumStatus.isAdvancedSearch()) {
            if ((this.mPage - 1) * this.postPerPage >= this.total_num) {
            }
        }
        do {
            return true;
            return false;
            if (!this.forumStatus.isSearchIDEnabled()) {
                break;
            }
        } while (this.mStart < this.total_num);
        return false;
        return false;
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
    }

    public void refresh() {
        this.mDatas.clear();
        this.searchId = null;
        this.mPage = 1;
        notifyDataSetChanged();
        if (this.forumStatus.isAdvancedSearch()) {
            getSearchTopicAdvance();
            return;
        }
        getSearchTopic();
    }

    public static class NoSearchResult {
        public static View getView(Context paramContext) {
            View localView = LayoutInflater.from(paramContext).inflate(2130903292, null);
            ((ImageView) localView.findViewById(2131230762)).setBackgroundResource(ThemeUtil.getDrawableIdByPicName("message_search", paramContext));
            ((TextView) localView.findViewById(2131230763)).setTypeface(Typeface.createFromAsset(paramContext.getAssets(), "font/Roboto_Condensed.ttf"));
            return localView;
        }
    }

    class topicListLongClickListener
            implements AdapterView.OnItemLongClickListener {
        topicListLongClickListener() {
        }

        public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
            SearchAdapter.this.mLongclickItemPosition = paramInt;
            return true;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/SearchAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */