package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.tapatalkpro.activity.forum.CategoriesFragment;
import com.quoord.tapatalkpro.activity.forum.CategoryActivity;
import com.quoord.tapatalkpro.activity.forum.moderation.ModerateActivity;
import com.quoord.tapatalkpro.activity.forum.moderation.ModerateFragment;
import com.quoord.tapatalkpro.adapter.forum.moderation.ModerateAdapter;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.saxparser.ForumSaxParser;
import com.quoord.tapatalkpro.saxparser.ForumSaxParser.ICallback;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class ForumAdapter
        extends ForumRootAdapter
        implements AdapterView.OnItemClickListener {
    public static final int flatten = 1;
    public static final int hierarchical = 0;
    private int SAX_CLOSE_PROGRESS = 0;
    private int SAX_DISPLAY_ERROR = 5;
    private int SAX_UPDATE_BEGIN = 3;
    private int SAX_UPDATE_END = 2;
    private int SAX_UPDATE_FLATTEN_ITEM = 4;
    private int SAX_UPDATE_ITEM = 1;
    private LinearLayout buttonmenu;
    private String cacheFile;
    Comparator<Object> comp = new Mycomparator(null);
    private ArrayList<Forum> flattenForumList = new ArrayList();
    private LinearLayout footlay;
    RelativeLayout guestForumContainer;
    RelativeLayout guestView;
    private Boolean guest_okay;
    private Boolean is_flatten = Boolean.valueOf(false);
    ArrayList<String> localSubscribeForum;
    Button loginButton;
    private Activity mContext;
    public ArrayList<Forum> mDatas = new ArrayList();
    protected ForumSaxParser mForumParser;
    private Handler mUIHandler;
    public int maxLevel = 0;
    private boolean onlyRefresh = false;
    Button registerButton;
    protected String shortcutID = null;
    TextView tv;
    Button viewinbroswerButton;

    public ForumAdapter(Activity paramActivity, String paramString, boolean paramBoolean) {
        super(paramActivity, paramString);
        this.mContext = paramActivity;
        if (!paramBoolean) {
        }
        try {
            GoogleAnalyticsTools.trackPageView(this.mContext, "forum/all", this.forumStatus.getForumId(), this.forumStatus.getUrl());
            this.cacheFile = AppCacheManager.getForumCacheUrl(paramActivity, this.forumStatus.getUrl(), this.forumStatus.tapatalkForum.getCacheUsernameDir());
            intiParser();
            return;
        } catch (Exception paramString) {
            for (; ; ) {
                paramString.printStackTrace();
            }
        }
    }

    public ForumAdapter(Activity paramActivity, String paramString1, boolean paramBoolean, ListView paramListView, String paramString2) {
        super(paramActivity, paramString1);
        this.mContext = paramActivity;
        this.stackType = paramString2;
        this.cacheFile = AppCacheManager.getForumCacheUrl(paramActivity, this.forumStatus.getUrl(), this.forumStatus.tapatalkForum.getCacheUsernameDir());
        this.tv = ThemeUtil.getSectionTitle(this.mContext);
        this.tv.setText(this.forumStatus.tapatalkForum.getName());
        this.loadingMore = true;
        this.footlay = ButtomProgress.get(this.mContext);
        this.mListView = paramListView;
        this.mListView.addFooterView(this.footlay);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setAdapter(this);
        if (!paramBoolean) {
        }
        try {
            GoogleAnalyticsTools.trackPageView(this.mContext, "forum/all", this.forumStatus.getForumId(), this.forumStatus.getUrl());
            intiParser();
            updateForum();
            return;
        } catch (Exception paramActivity) {
            for (; ; ) {
                paramActivity.printStackTrace();
            }
        }
    }

    private void getNewPostStatus(HashMap paramHashMap) {
        if ((paramHashMap == null) || (paramHashMap.get("forum_name") == null)) {
        }
        for (; ; ) {
            return;
            if ((paramHashMap.containsKey("new_post")) && (((Boolean) paramHashMap.get("new_post")).booleanValue()) && (!this.forumStatus.checkNewPost((String) paramHashMap.get("forum_id")))) {
                this.forumStatus.addNewPostForForum((String) paramHashMap.get("forum_id"));
            }
            paramHashMap = (Object[]) paramHashMap.get("child");
            if ((paramHashMap != null) && (paramHashMap.length > 0)) {
                int i = 0;
                while (i < paramHashMap.length) {
                    getNewPostStatus((HashMap) paramHashMap[i]);
                    i += 1;
                }
            }
        }
    }

    private void intiParser() {
        this.mUIHandler = new Handler() {
            public void handleMessage(Message paramAnonymousMessage) {
                if ((paramAnonymousMessage.what == ForumAdapter.this.SAX_UPDATE_BEGIN) && (ForumAdapter.this.mDatas.size() > 1)) {
                    ForumAdapter.this.mDatas.remove(ForumAdapter.this.mDatas.size() - 1);
                    ForumAdapter.this.notifyDataSetChanged();
                }
                int i = paramAnonymousMessage.what;
                if ((paramAnonymousMessage.what == ForumAdapter.this.SAX_UPDATE_ITEM) && (!ForumAdapter.this.mDatas.contains((Forum) paramAnonymousMessage.obj))) {
                    ForumAdapter.this.mDatas.add((Forum) paramAnonymousMessage.obj);
                    if (!ForumAdapter.this.is_flatten.booleanValue()) {
                        ForumAdapter.this.notifyDataSetChanged();
                    }
                }
                if (paramAnonymousMessage.what == ForumAdapter.this.SAX_UPDATE_FLATTEN_ITEM) {
                    ForumAdapter.this.flattenForumList.add((Forum) paramAnonymousMessage.obj);
                    if (ForumAdapter.this.is_flatten.booleanValue()) {
                        ForumAdapter.this.notifyDataSetChanged();
                    }
                }
                if (paramAnonymousMessage.what == ForumAdapter.this.SAX_UPDATE_END) {
                }
                try {
                    if ((ForumAdapter.this.flattenForumList != null) && (ForumAdapter.this.comp != null)) {
                        Collections.sort(ForumAdapter.this.flattenForumList, ForumAdapter.this.comp);
                    }
                    ForumAdapter.this.notifyDataSetChanged();
                    if ((ForumAdapter.this.mListView != null) && (ForumAdapter.this.mListView.getFooterViewsCount() > 0)) {
                        ForumAdapter.this.mListView.removeFooterView(ForumAdapter.this.footlay);
                    }
                    AppCacheManager.cacheData(ForumAdapter.this.cacheFile, ForumAdapter.this.mDatas);
                    if (paramAnonymousMessage.what == ForumAdapter.this.SAX_DISPLAY_ERROR) {
                        paramAnonymousMessage = (String) paramAnonymousMessage.obj;
                        Toast.makeText(ForumAdapter.this.mContext, paramAnonymousMessage, 1).show();
                    }
                    return;
                } catch (Exception localException) {
                    for (; ; ) {
                        localException.printStackTrace();
                    }
                }
            }
        };
        this.mForumParser = new ForumSaxParser(this.forumStatus);
        this.mForumParser.setCallback(new ForumSaxParser.ICallback() {
            public void onAddItem(Forum paramAnonymousForum) {
                Message localMessage = ForumAdapter.this.mUIHandler.obtainMessage();
                localMessage.what = ForumAdapter.this.SAX_UPDATE_ITEM;
                localMessage.obj = paramAnonymousForum;
                ForumAdapter.this.mUIHandler.sendMessage(localMessage);
            }

            public void onDocBegin() {
                Message localMessage = ForumAdapter.this.mUIHandler.obtainMessage();
                localMessage.what = ForumAdapter.this.SAX_UPDATE_BEGIN;
                ForumAdapter.this.mUIHandler.sendMessage(localMessage);
            }

            public void onDocEnd() {
                Message localMessage = ForumAdapter.this.mUIHandler.obtainMessage();
                localMessage.what = ForumAdapter.this.SAX_UPDATE_END;
                ForumAdapter.this.loadingMore = false;
                ForumAdapter.this.mUIHandler.sendMessage(localMessage);
            }

            public void onFlattenAdd(Forum paramAnonymousForum) {
                Message localMessage = ForumAdapter.this.mUIHandler.obtainMessage();
                localMessage.what = ForumAdapter.this.SAX_UPDATE_FLATTEN_ITEM;
                localMessage.obj = paramAnonymousForum;
                ForumAdapter.this.mUIHandler.sendMessage(localMessage);
            }

            public void onGetResultText(String paramAnonymousString) {
                Message localMessage = ForumAdapter.this.mUIHandler.obtainMessage();
                localMessage.what = ForumAdapter.this.SAX_DISPLAY_ERROR;
                localMessage.obj = paramAnonymousString;
                ForumAdapter.this.mUIHandler.sendMessage(localMessage);
            }
        });
    }

    public void clearAll() {
        this.mDatas.clear();
        notifyDataSetChanged();
    }

    public void formatResponseData(Object[] paramArrayOfObject) {
        this.mDatas.clear();
        this.flattenForumList.clear();
        int i = 0;
        for (; ; ) {
            if (i >= paramArrayOfObject.length) {
            }
            try {
                this.forumStatus.setForums(this.mDatas);
                return;
            } catch (Exception paramArrayOfObject) {
            }
            Forum localForum = Forum.createForumBean((HashMap) paramArrayOfObject[i], this.forumStatus, this.mContext, this.flattenForumList, this, 0);
            if (!this.mDatas.contains(localForum)) {
                this.mDatas.add(localForum);
            }
            i += 1;
        }
    }

    public int getCount() {
        if (!this.is_flatten.booleanValue()) {
            return this.mDatas.size();
        }
        return this.flattenForumList.size();
    }

    public void getFlattenList(ArrayList<Forum> paramArrayList) {
        int i = 0;
        for (; ; ) {
            if (i >= paramArrayList.size()) {
                return;
            }
            if ((((Forum) paramArrayList.get(i)).getChildForums() != null) && (((Forum) paramArrayList.get(i)).getChildForums().size() > 0)) {
                getFlattenList(((Forum) paramArrayList.get(i)).getChildForums());
            }
            if ((((Forum) paramArrayList.get(i)).getName() != null) && (((Forum) paramArrayList.get(i)).getName().length() > 0)) {
                this.flattenForumList.add((Forum) paramArrayList.get(i));
            }
            i += 1;
        }
    }

    public void getForum() {
        this.mDatas.clear();
        this.flattenForumList.clear();
        notifyDataSetChanged();
        setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        if ((this.mForumParser != null) && (!this.onlyRefresh)) {
            this.loadingMore = true;
            this.engine.saxcall(this.mForumParser, "get_forum", localArrayList);
            return;
        }
        this.engine.call("get_forum", localArrayList);
    }

    public Object getItem(int paramInt) {
        if (!this.is_flatten.booleanValue()) {
            if ((this.mDatas.size() > paramInt) && (paramInt >= 0)) {
                return this.mDatas.get(paramInt);
            }
            return null;
        }
        return this.flattenForumList.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        Forum localForum = (Forum) getItem(paramInt);
        if (paramInt == 0) {
            return Forum.getForumView(Forum.TOP_FORUM_ITEM, localForum, paramView, paramViewGroup, this.forumStatus, this.mContext, this, false);
        }
        if (paramInt == getCount() - 1) {
            return Forum.getForumView(Forum.BOTTOM_FORUM_ITEM, localForum, paramView, paramViewGroup, this.forumStatus, this.mContext, this, false);
        }
        return Forum.getForumView(Forum.MID_FORUM_ITEM, localForum, paramView, paramViewGroup, this.forumStatus, this.mContext, this, false);
    }

    public boolean isEnabled(int paramInt) {
        return (paramInt != getCount() - 1) || (!this.loadingMore);
    }

    public boolean isForumGuestOk() {
        return this.guest_okay.booleanValue();
    }

    public boolean isOnlyRefresh() {
        return this.onlyRefresh;
    }

    public void markForumRead() {
        ArrayList localArrayList = new ArrayList();
        setTryTwice(false);
        this.engine.call("mark_all_as_read", localArrayList);
        this.forumStatus.cleanNewPost();
        notifyDataSetChanged();
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        if ((getItem(paramInt - this.mListView.getHeaderViewsCount()) instanceof Forum)) {
            paramAdapterView = (Forum) getItem(paramInt - this.mListView.getHeaderViewsCount());
            if (!(this.mContext instanceof SlidingMenuActivity)) {
                break label85;
            }
            boolean bool = false;
            if (paramAdapterView.isProtected()) {
                bool = getIsLogin(paramAdapterView.getId());
            }
            forumItemClicked(paramAdapterView, bool, (SlidingMenuActivity) this.mContext, this.stackType);
        }
        label85:
        do {
            do {
                return;
                if (!(this.mContext instanceof CategoryActivity)) {
                    break;
                }
            }
            while ((((CategoryActivity) this.mContext).fragment == null) || (((CategoryActivity) this.mContext).fragment.mForumAdapter == null));
            ((CategoryActivity) this.mContext).fragment.mForumAdapter.setOnItemClick(paramAdapterView);
            return;
        }
        while ((!(this.mContext instanceof ModerateActivity)) || (((ModerateActivity) this.mContext).fragment == null));
        paramAdapterView = ((ModerateActivity) this.mContext).fragment.mForumAdapter;
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
        int i;
        if ((paramEngineResponse.getMethod().equals("get_forum")) && ((paramEngineResponse.getResponse() instanceof Object[]))) {
            this.mDatas.clear();
            paramEngineResponse = (Object[]) paramEngineResponse.getResponse();
            formatResponseData(paramEngineResponse);
            this.forumStatus.cleanNewPost();
            if (this.maxLevel >= 8) {
                break label112;
            }
            AppCacheManager.cacheData(this.cacheFile, this.mDatas);
            i = 0;
        }
        for (; ; ) {
            if (i >= paramEngineResponse.length) {
                if ((this.mListView != null) && (this.mListView.getFooterViewsCount() > 0)) {
                    this.mListView.removeFooterView(this.footlay);
                }
                notifyDataSetChanged();
                return;
                label112:
                AppCacheManager.del(this.cacheFile);
                break;
            }
            getNewPostStatus((HashMap) paramEngineResponse[i]);
            i += 1;
        }
    }

    public void refresh() {
        if (this.mListView.getFooterViewsCount() > 0) {
            this.mListView.removeFooterView(this.footlay);
        }
        this.mListView.addFooterView(this.footlay);
        getForum();
    }

    public void setOnlyRefresh(boolean paramBoolean) {
        this.onlyRefresh = paramBoolean;
    }

    public void setShortcutID(String paramString) {
        this.shortcutID = paramString;
    }

    public void tabChange(int paramInt) {
        if ((paramInt == 0) && (this.is_flatten.booleanValue())) {
            GoogleAnalyticsTools.trackPageView(this.mContext, "forum/all", this.forumStatus.getForumId(), this.forumStatus.getUrl());
            this.is_flatten = Boolean.valueOf(false);
            notifyDataSetChanged();
        }
        while ((paramInt != 1) || (this.is_flatten.booleanValue())) {
            return;
        }
        GoogleAnalyticsTools.trackPageView(this.mContext, "forum/name", this.forumStatus.getForumId(), this.forumStatus.getUrl());
        this.is_flatten = Boolean.valueOf(true);
        notifyDataSetChanged();
    }

    public void updateForum() {
        Object localObject1;
        if ((AppCacheManager.checkFile(this.cacheFile)) && (this.forumStatus.isLogin())) {
            this.loadingMore = false;
            this.mDatas.clear();
            localObject1 = null;
        }
        try {
            Object localObject2 = AppCacheManager.getCacheData(this.cacheFile);
            localObject1 = localObject2;
        } catch (Exception localException2) {
            for (; ; ) {
            }
        }
        if (localObject1 != null) {
            this.mDatas = ((ArrayList) localObject1);
            getFlattenList(this.mDatas);
        }
        try {
            Collections.sort(this.flattenForumList, this.comp);
            for (; ; ) {
                if ((this.mListView != null) && (this.mListView.getFooterViewsCount() > 0) && (this.mDatas.size() > 1)) {
                    this.mListView.removeFooterView(this.footlay);
                }
                return;
                AppCacheManager.del(this.cacheFile);
                getForum();
            }
            getForum();
            return;
        } catch (Exception localException1) {
            for (; ; ) {
            }
        }
    }

    private class Mycomparator
            implements Comparator<Object> {
        private Mycomparator() {
        }

        public int compare(Forum paramForum1, Forum paramForum2) {
            return paramForum1.getName().compareTo(paramForum2.getName());
        }

        public int compare(Object paramObject1, Object paramObject2) {
            return ((Forum) paramObject1).getName().compareTo(((Forum) paramObject2).getName());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/ForumAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */