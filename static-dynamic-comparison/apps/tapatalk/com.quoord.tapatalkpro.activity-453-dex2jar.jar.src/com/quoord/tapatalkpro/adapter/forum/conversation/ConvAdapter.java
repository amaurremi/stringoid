package com.quoord.tapatalkpro.adapter.forum.conversation;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.quoord.gif.GifView;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.conversation.ConversationOuterFragment;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.bean.Conversation;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.NoTopicView;
import com.quoord.tapatalkpro.bean.RebrandingConfig;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ics.conversation.ConversationListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.BackListAdapter;
import com.quoord.tapatalkpro.ics.slidingMenu.BackListFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.BackListFragment.ChangeUnreadNumbers;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ics.slidingMenu.TabItem;
import com.quoord.tapatalkpro.saxparser.TabConvSaxParser;
import com.quoord.tapatalkpro.saxparser.TabConvSaxParser.ICallback;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvAdapter
        extends ForumRootAdapter {
    private static final int DOWNLOAD_ICON_CONVERSATION_FINISHED = 1;
    private static final int HARD_DELETE = 2;
    private static final int ON_ADDITEM_SUCCESS = 0;
    private static final int REMOVE_FOOTVIEW = 3;
    private static final int SOFT_DELETE = 1;
    Handler UIHandler = null;
    public ActionMode anMode;
    public Conversation cData;
    public TabConvSaxParser convSaxParser = null;
    public ConversationActionMode conversationActionMode = null;
    private int conversation_count = 0;
    private int currentPage = 1;
    private int currentSelectPosition = -1;
    private int end = 0;
    private boolean isLoadingMore = true;
    ListView listView;
    View loadingMoreView = null;
    Activity mContext;
    ArrayList<Object> mDatas = null;
    ConvAdapter mThis;
    private int perPageCount = 10;
    private int start = 0;
    private int totalPage = 1;
    private int unread_count;
    public String userNameCacheAddress = "";
    public HashMap<String, String> userNameList;

    public ConvAdapter(Activity paramActivity, String paramString, ListView paramListView) {
        super(paramActivity, paramString);
        this.mContext = paramActivity;
        this.mStatus = ((ForumActivityStatus) paramActivity);
        this.forumStatus = this.mStatus.getForumStatus();
        this.mThis = this;
        this.listView = paramListView;
        ThemeUtil.setListViewStyle(this.listView, this.mContext);
        this.loadingMoreView = ButtomProgress.get(this.mContext);
        this.listView.addFooterView(this.loadingMoreView);
        this.userNameCacheAddress = AppCacheManager.getForumUseNameUrl(this.mContext, this.forumStatus.getUrl(), this.forumStatus.tapatalkForum.getLowerUserName());
        paramActivity = AppCacheManager.getCacheData(this.userNameCacheAddress);
        if (paramActivity == null) {
            this.userNameList = new HashMap();
        }
        for (; ; ) {
            addListViewOnItemClickEvent();
            addListViewOnLongItemClickEvent();
            this.mDatas = new ArrayList();
            this.UIHandler = new Handler() {
                public void handleMessage(Message paramAnonymousMessage) {
                    super.handleMessage(paramAnonymousMessage);
                    switch (paramAnonymousMessage.what) {
                    }
                    for (; ; ) {
                        ConvAdapter.this.mContext.invalidateOptionsMenu();
                        return;
                        ConvAdapter.this.mDatas.add((Conversation) paramAnonymousMessage.obj);
                        ConvAdapter.this.conversation_count = paramAnonymousMessage.arg1;
                        ConvAdapter.this.unread_count = paramAnonymousMessage.arg2;
                        if (ConvAdapter.this.conversation_count % ConvAdapter.this.perPageCount == 0) {
                        }
                        for (ConvAdapter.this.totalPage = (ConvAdapter.this.conversation_count / ConvAdapter.this.perPageCount); ; ConvAdapter.this.totalPage = (ConvAdapter.this.conversation_count / ConvAdapter.this.perPageCount + 1)) {
                            ConvAdapter.this.updateUI();
                            break;
                        }
                        AppCacheManager.cacheData(ConvAdapter.this.userNameCacheAddress, ConvAdapter.this.userNameList);
                        ConvAdapter.this.notifyDataSetChanged();
                        continue;
                        if (ConvAdapter.this.listView.getFooterViewsCount() > 0) {
                            ConvAdapter.this.listView.removeFooterView(ConvAdapter.this.loadingMoreView);
                            ConvAdapter.this.notifyDataSetChanged();
                        }
                        if (ConvAdapter.this.mDatas.size() == 0) {
                            ConvAdapter.this.mDatas.add(new NoTopicView());
                        }
                    }
                }
            };
            this.convSaxParser = new TabConvSaxParser(this.forumStatus);
            this.convSaxParser.setCallback(new TabConvSaxParser.ICallback() {
                public void onAddItem(Conversation paramAnonymousConversation, boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2) {
                    Message localMessage = ConvAdapter.this.UIHandler.obtainMessage();
                    localMessage.what = 0;
                    localMessage.obj = paramAnonymousConversation;
                    localMessage.arg1 = paramAnonymousInt1;
                    localMessage.arg2 = paramAnonymousInt2;
                    ConvAdapter.this.UIHandler.sendMessage(localMessage);
                }

                public void onDocBegin() {
                }

                public void onDocEnd() {
                    ConvAdapter.this.isLoadingMore = false;
                    if (ConvAdapter.this.currentPage == ConvAdapter.this.totalPage) {
                        Message localMessage = ConvAdapter.this.UIHandler.obtainMessage();
                        localMessage.what = 3;
                        ConvAdapter.this.UIHandler.sendMessage(localMessage);
                    }
                }

                public void onGetResultText(String paramAnonymousString) {
                }

                public void onGetTopicNum(int paramAnonymousInt) {
                }
            });
            this.listView.setAdapter(this.mThis);
            getConversations(this.currentPage);
            setListViewScrollListener();
            return;
            if ((paramActivity instanceof HashMap)) {
                this.userNameList = ((HashMap) paramActivity);
            } else {
                this.userNameList = new HashMap();
            }
        }
    }

    public void addListViewOnItemClickEvent() {
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                if (((ConvAdapter.this.listView.getFooterViewsCount() > 0) && (ConvAdapter.this.mDatas.size() <= 0)) || (paramAnonymousInt >= ConvAdapter.this.mDatas.size())) {
                }
                do {
                    return;
                    ConvAdapter.this.currentSelectPosition = paramAnonymousInt;
                } while (!(ConvAdapter.this.mDatas.get(paramAnonymousInt) instanceof Conversation));
                paramAnonymousAdapterView = (Conversation) ConvAdapter.this.mDatas.get(paramAnonymousInt);
                paramAnonymousView = new HashMap();
                paramAnonymousView.put("conversation", paramAnonymousAdapterView);
                paramAnonymousView.put("forumStatus", ConvAdapter.this.forumStatus);
                paramAnonymousView = new ConversationOuterFragment(false, paramAnonymousView);
                ((SlidingMenuActivity) ConvAdapter.this.mContext).getActionBar().setDisplayShowTitleEnabled(false);
                ((SlidingMenuActivity) ConvAdapter.this.mContext).showDetail(paramAnonymousView);
                if (paramAnonymousAdapterView.isNew_post()) {
                    ((BackListFragment) ((SlidingMenuActivity) ConvAdapter.this.mContext).getmFrag()).setChangeIngerface(new BackListFragment.ChangeUnreadNumbers() {
                        public void setUnreadNumbers(BackListAdapter paramAnonymous2BackListAdapter) {
                            int i;
                            if ((paramAnonymous2BackListAdapter != null) && (paramAnonymous2BackListAdapter.tabItemList != null)) {
                                i = 0;
                                if (i >= paramAnonymous2BackListAdapter.tabItemList.size()) {
                                    paramAnonymous2BackListAdapter.notifyDataSetChanged();
                                }
                            } else {
                                return;
                            }
                            int j;
                            if (((TabItem) paramAnonymous2BackListAdapter.tabItemList.get(i)).getMenuid() == 1020) {
                                Object localObject = ((TabItem) paramAnonymous2BackListAdapter.tabItemList.get(i)).getTabName();
                                localObject = Pattern.compile("[^0-9]").matcher((CharSequence) localObject);
                                j = 0;
                                if (!((Matcher) localObject).replaceAll("").trim().equals("")) {
                                    j = Integer.valueOf(((Matcher) localObject).replaceAll("").trim()).intValue() - 1;
                                }
                                if ((!ConvAdapter.this.mContext.getResources().getBoolean(2131558401)) || (ConvAdapter.this.forumStatus.getRebrandingConfig().getOrder().size() <= 0)) {
                                    break label256;
                                }
                                if (j <= 0) {
                                    break label225;
                                }
                                ((TabItem) paramAnonymous2BackListAdapter.tabItemList.get(i)).setTabName(((TabItem) paramAnonymous2BackListAdapter.tabItemList.get(i)).getDisplay_name() + " (" + j + ") ");
                            }
                            for (; ; ) {
                                i += 1;
                                break;
                                label225:
                                ((TabItem) paramAnonymous2BackListAdapter.tabItemList.get(i)).setTabName(((TabItem) paramAnonymous2BackListAdapter.tabItemList.get(i)).getDisplay_name());
                                continue;
                                label256:
                                if (j > 0) {
                                    ((TabItem) paramAnonymous2BackListAdapter.tabItemList.get(i)).setTabName(ConvAdapter.this.mContext.getString(2131100422) + " (" + j + ") ");
                                } else {
                                    ((TabItem) paramAnonymous2BackListAdapter.tabItemList.get(i)).setTabName(ConvAdapter.this.mContext.getString(2131100422));
                                }
                            }
                        }
                    });
                    ((BackListFragment) ((SlidingMenuActivity) ConvAdapter.this.mContext).getmFrag()).ChangeUnreadNumbers();
                }
                if (((ConvAdapter.this.mContext instanceof SlidingMenuActivity)) && ((((SlidingMenuActivity) ConvAdapter.this.mContext).currentFragment instanceof ConversationListFragment))) {
                    ((ConversationListFragment) ((SlidingMenuActivity) ConvAdapter.this.mContext).currentFragment).setIdByTwoPanel(((Conversation) ConvAdapter.this.mDatas.get(paramAnonymousInt)).getConv_id());
                }
                paramAnonymousAdapterView.setNew_post(false);
                ConvAdapter.this.notifyDataSetChanged();
            }
        });
    }

    public void addListViewOnLongItemClickEvent() {
        this.listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                if ((ConvAdapter.this.getItem(paramAnonymousInt) instanceof Conversation)) {
                    paramAnonymousAdapterView = (Conversation) ConvAdapter.this.getItem(paramAnonymousInt);
                    if (ConvAdapter.this.anMode == null) {
                        ConvAdapter.this.conversationActionMode = new ConversationActionMode(ConvAdapter.this.mContext, paramAnonymousAdapterView, paramAnonymousInt, ConvAdapter.this.listView, ConvAdapter.this, ConvAdapter.this.forumStatus);
                        ConvAdapter.this.anMode = ConvAdapter.this.mContext.startActionMode(ConvAdapter.this.conversationActionMode);
                        ConvAdapter.this.notifyDataSetChanged();
                    }
                }
                return true;
            }
        });
    }

    public void changeBackgroud(Conversation paramConversation, View paramView) {
        int j = 0;
        int i = j;
        if (this.conversationActionMode != null) {
            i = j;
            if (this.conversationActionMode.conversations != null) {
                i = j;
                if (this.conversationActionMode.conversations.size() != 0) {
                    i = j;
                    if (this.conversationActionMode.conversations.contains(paramConversation)) {
                        i = 1;
                    }
                }
            }
        }
        if (i != 0) {
            if (this.mContext.getResources().getBoolean(2131558401)) {
                break label127;
            }
            if (SettingsFragment.isLightTheme(this.mContext)) {
                paramView.setBackgroundColor(this.mContext.getResources().getColor(2131165504));
            }
        } else {
            return;
        }
        paramView.setBackgroundColor(this.mContext.getResources().getColor(2131165509));
        return;
        label127:
        ThemeUtil.setHeightLight(this.mContext, paramView);
    }

    public void deleteConversation(Conversation paramConversation) {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramConversation.getConv_id());
        if (this.forumStatus.isXF()) {
            localArrayList.add(Integer.valueOf(1));
        }
        for (; ; ) {
            this.engine.call("delete_conversation", localArrayList);
            if (this.mDatas.contains(paramConversation)) {
                this.mDatas.remove(paramConversation);
            }
            if (this.mDatas.size() == 0) {
                this.mDatas.add(new NoTopicView());
            }
            notifyDataSetChanged();
            return;
            localArrayList.add(Integer.valueOf(2));
        }
    }

    public void destroy() {
        int i = 0;
        for (; ; ) {
            if (i >= getCount()) {
                this.icons.clear();
                this.mDatas.clear();
                return;
            }
            if ((getItem(i) instanceof Topic)) {
                Topic localTopic = (Topic) getItem(i);
                if ((this.icons.get(localTopic.getId()) != null) && ((this.icons.get(localTopic.getId()) instanceof GifView))) {
                    ((GifView) this.icons.get(localTopic.getId())).close();
                }
                this.icons.remove(localTopic.getId());
            }
            i += 1;
        }
    }

    public void getConversations(int paramInt) {
        this.start = ((paramInt - 1) * this.perPageCount);
        this.end = (this.perPageCount * paramInt - 1);
        this.isLoadingMore = true;
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(this.start));
        localArrayList.add(Integer.valueOf(this.end));
        this.engine.saxcall(this.convSaxParser, "get_conversations", localArrayList);
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

    public int getItemViewType(int paramInt) {
        if ((getItem(paramInt) instanceof NoTopicView)) {
            return 0;
        }
        return 1;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if ((getItem(paramInt) instanceof Conversation)) {
            paramViewGroup = (Conversation) this.mDatas.get(paramInt);
            paramView = paramViewGroup.getConversationView(paramInt, paramView, this.mContext, this);
            if (((this.mContext instanceof SlidingMenuActivity)) && (((SlidingMenuActivity) this.mContext).getShowSlectionStatus())) {
                if (this.currentSelectPosition == paramInt) {
                    paramView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("topic_select_bg", this.mContext));
                }
            }
            for (; ; ) {
                changeBackgroud(paramViewGroup, paramView);
                return paramView;
                paramView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("topic_item_bg", this.mContext));
                continue;
                paramView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("topic_item_bg", this.mContext));
            }
        }
        return ((NoTopicView) getItem(paramInt)).getItemView(this.mContext, this.mContext.getResources().getString(2131100211));
    }

    public int getViewTypeCount() {
        return 2;
    }

    public void markConsUnread(int paramInt) {
        setTryTwice(false);
        Conversation localConversation = (Conversation) this.mDatas.get(paramInt);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localConversation.getConv_id());
        localConversation.setNew_post(true);
        this.engine.call("mark_conversation_unread", localArrayList);
        if ((this.mContext instanceof SlidingMenuActivity)) {
            ((SlidingMenuActivity) this.mContext).getUnreadNumbers();
        }
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
    }

    public void refresh() {
        this.icons.clear();
        this.isLoadingMore = true;
        this.mDatas.clear();
        if (this.listView.getFooterViewsCount() > 0) {
            this.listView.removeFooterView(this.loadingMoreView);
        }
        this.listView.addFooterView(this.loadingMoreView);
        this.currentPage = 1;
        getConversations(this.currentPage);
        notifyDataSetChanged();
    }

    public void setListViewScrollListener() {
        this.listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                if ((paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3) && (!ConvAdapter.this.isLoadingMore) && (ConvAdapter.this.currentPage < ConvAdapter.this.totalPage)) {
                    paramAnonymousAbsListView = ConvAdapter.this;
                    paramAnonymousAbsListView.currentPage += 1;
                    ConvAdapter.this.getConversations(ConvAdapter.this.currentPage);
                }
            }

            public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
            }
        });
    }

    public void updateUI() {
        notifyDataSetChanged();
    }

    public static class OnLongItemClickConvAdapter
            extends BaseAdapter {
        private ArrayList<String> list = new ArrayList();
        private Context mContext;

        public OnLongItemClickConvAdapter(Context paramContext, ForumStatus paramForumStatus, Conversation paramConversation) {
            this.mContext = paramContext;
            this.list.add(this.mContext.getResources().getString(2131100170));
            if ((paramForumStatus.isMarkCsUnread()) && (!paramConversation.isNew_post())) {
                this.list.add(this.mContext.getResources().getString(2131099818));
            }
        }

        public int getCount() {
            return this.list.size();
        }

        public Object getItem(int paramInt) {
            return this.list.get(paramInt);
        }

        public long getItemId(int paramInt) {
            return paramInt;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            paramView = (TextView) LayoutInflater.from(this.mContext).inflate(2130903172, null);
            paramView.setText((CharSequence) this.list.get(paramInt));
            paramView.setCompoundDrawablePadding(5);
            if (((String) this.list.get(paramInt)).equalsIgnoreCase(this.mContext.getResources().getString(2131100170))) {
                paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_leave", this.mContext), 0, 0, 0);
            }
            if (((String) this.list.get(paramInt)).equalsIgnoreCase(this.mContext.getResources().getString(2131099818))) {
                paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDialogDrawableId("bubble_mark_unread", this.mContext), 0, 0, 0);
            }
            return paramView;
        }
    }

    public class userNameComparator
            implements Comparator<String> {
        public userNameComparator() {
        }

        public int compare(String paramString1, String paramString2) {
            return paramString1.compareTo(paramString2);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/conversation/ConvAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */