package com.quoord.tapatalkpro.favunread;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.activity.directory.ics.AccountEntryActivity;
import com.quoord.tapatalkpro.activity.directory.ics.ShowFragmentActivityInter;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.activity.forum.PMContentActivity;
import com.quoord.tapatalkpro.activity.forum.ThreadActivity;
import com.quoord.tapatalkpro.activity.forum.conversation.ConverSationActivity;
import com.quoord.tapatalkpro.bean.Conversation;
import com.quoord.tapatalkpro.bean.Forum;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.PrivateMessage;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.Topic;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.LoginStatus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class FavForumsInboxFragment
        extends QuoordFragment {
    private ArrayList<TapatalkForum> baseData;
    public ArrayList<UnreadStatus> callList;
    private CurrentGroup currentGroup;
    private TextView emptyText;
    private final int expandGroup = 1;
    private LinearLayout footLay;
    boolean hasExpanded = false;
    private FavoriateSqlHelper helper;
    private boolean isFirst = true;
    private FavoriateForumInboxAdapter mAdapter;
    private Handler mHandler;
    private ExpandableListView mListView;
    private boolean needNotify = false;
    private ArrayList<String> primarySaveList = new ArrayList();
    private ForumStatus usingInClickStatus;

    private void checkHelper() {
        if (this.helper == null) {
            this.helper = new FavoriateSqlHelper(getActivity(), TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
        }
    }

    private void configurationChanged(Configuration paramConfiguration) {
        ViewGroup.MarginLayoutParams localMarginLayoutParams;
        if (Util.getDeviceSize(getActivity()) >= 7.0D) {
            localMarginLayoutParams = (ViewGroup.MarginLayoutParams) this.mListView.getLayoutParams();
            switch (paramConfiguration.orientation) {
            }
        }
        for (; ; ) {
            this.mListView.setLayoutParams(localMarginLayoutParams);
            this.mListView.invalidate();
            setGroupIcon();
            return;
            int i = (int) getResources().getDimension(2131427405);
            localMarginLayoutParams.setMargins(i, 0, i, 0);
            continue;
            localMarginLayoutParams.setMargins(0, 0, 0, 0);
        }
    }

    private void listViewToggle(boolean paramBoolean) {
        if ((this.mListView == null) || (this.emptyText == null)) {
            return;
        }
        if (paramBoolean) {
            this.mListView.setVisibility(0);
            this.emptyText.setVisibility(8);
            return;
        }
        this.mListView.setVisibility(8);
        this.emptyText.setVisibility(0);
    }

    public static FavForumsInboxFragment newInstance(ArrayList<TapatalkForum> paramArrayList) {
        FavForumsInboxFragment localFavForumsInboxFragment = new FavForumsInboxFragment();
        localFavForumsInboxFragment.baseData = paramArrayList;
        return localFavForumsInboxFragment;
    }

    private void setListeners() {
        this.mListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            public boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                if (!FavForumsInboxFragment.this.mListView.isGroupExpanded(paramAnonymousInt)) {
                    FavForumsInboxFragment.this.mListView.expandGroup(paramAnonymousInt);
                    FavForumsInboxFragment.this.mAdapter.setExpandedGroup(paramAnonymousInt);
                }
                for (; ; ) {
                    FavForumsInboxFragment.this.isFirst = false;
                    return true;
                    FavForumsInboxFragment.this.mListView.collapseGroup(paramAnonymousInt);
                }
            }
        });
        this.mListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            public void onGroupExpand(int paramAnonymousInt) {
                FavForumsInboxFragment.this.mAdapter.setExpandedGroup(paramAnonymousInt);
                FavForumsInboxFragment.this.mListView.setSelectedGroup(paramAnonymousInt);
                String str = ((UnreadStatus) FavForumsInboxFragment.this.mAdapter.getmList().get(paramAnonymousInt)).getLoginStatus().getPrimaryKey();
                if (!FavForumsInboxFragment.this.primarySaveList.contains(str)) {
                    FavForumsInboxFragment.this.primarySaveList.add(str);
                }
            }
        });
        this.mListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            public void onGroupCollapse(int paramAnonymousInt) {
                String str = ((UnreadStatus) FavForumsInboxFragment.this.mAdapter.getmList().get(paramAnonymousInt)).getLoginStatus().getPrimaryKey();
                FavForumsInboxFragment.this.primarySaveList.remove(str);
            }
        });
        this.mListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            public boolean onChildClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong) {
                paramAnonymousExpandableListView = ((UnreadStatus) FavForumsInboxFragment.this.mAdapter.getmList().get(paramAnonymousInt1)).getLoginStatus();
                FavForumsInboxFragment.this.checkHelper();
                if (FavForumsInboxFragment.this.currentGroup == null) {
                    FavForumsInboxFragment.this.currentGroup = new FavForumsInboxFragment.CurrentGroup(FavForumsInboxFragment.this, null);
                }
                if (FavForumsInboxFragment.this.currentGroup.groupPosition != paramAnonymousInt1) {
                    FavForumsInboxFragment.this.currentGroup.forum = FavForumsInboxFragment.this.helper.getFavrivateById(paramAnonymousExpandableListView.getForumId());
                    FavForumsInboxFragment.this.usingInClickStatus = ForumStatus.initialForumStatus(FavForumsInboxFragment.this.getActivity(), FavForumsInboxFragment.this.currentGroup.forum, null, null);
                    FavForumsInboxFragment.this.usingInClickStatus.cookies = paramAnonymousExpandableListView.getCookies();
                    FavForumsInboxFragment.this.usingInClickStatus.setLogin(true);
                }
                paramAnonymousView = FavForumsInboxFragment.this.mAdapter.getChild(paramAnonymousInt1, paramAnonymousInt2);
                if ((paramAnonymousView instanceof Topic)) {
                    paramAnonymousExpandableListView = (Topic) paramAnonymousView;
                    paramAnonymousExpandableListView.setNewPost(false);
                    paramAnonymousView = new Intent();
                    paramAnonymousView.setClass(FavForumsInboxFragment.this.getActivity(), ThreadActivity.class);
                    paramAnonymousView.putExtra("topic_id", paramAnonymousExpandableListView.getId());
                    paramAnonymousView.putExtra("topic_title", paramAnonymousExpandableListView.getTitle());
                    paramAnonymousView.putExtra("reply_count", paramAnonymousExpandableListView.getReplyCount());
                    paramAnonymousView.putExtra("forumId", paramAnonymousExpandableListView.getForumId());
                    paramAnonymousView.putExtra("viewsubscribe", true);
                    paramAnonymousView.putExtra("forumStatus", FavForumsInboxFragment.this.usingInClickStatus);
                    paramAnonymousView.putExtra("fromFeed", true);
                    FavForumsInboxFragment.this.startActivity(paramAnonymousView);
                    FavForumsInboxFragment.this.mAdapter.removeChild(paramAnonymousInt1, paramAnonymousInt2);
                    FavForumsInboxFragment.this.mAdapter.notifyDataSetChanged();
                }
                for (; ; ) {
                    return false;
                    Object localObject;
                    if ((paramAnonymousView instanceof PrivateMessage)) {
                        paramAnonymousExpandableListView = (PrivateMessage) paramAnonymousView;
                        paramAnonymousExpandableListView.setMsgState(0);
                        paramAnonymousView = new Intent();
                        paramAnonymousView.setClass(FavForumsInboxFragment.this.getActivity(), PMContentActivity.class);
                        localObject = new Bundle();
                        ((Bundle) localObject).putSerializable("pm", paramAnonymousExpandableListView);
                        ((Bundle) localObject).putSerializable("forumStatus", FavForumsInboxFragment.this.usingInClickStatus);
                        paramAnonymousView.putExtras((Bundle) localObject);
                        FavForumsInboxFragment.this.startActivity(paramAnonymousView);
                        FavForumsInboxFragment.this.mAdapter.removeChild(paramAnonymousInt1, paramAnonymousInt2);
                        FavForumsInboxFragment.this.mAdapter.notifyDataSetChanged();
                    } else if ((paramAnonymousView instanceof Conversation)) {
                        paramAnonymousView = (Conversation) paramAnonymousView;
                        paramAnonymousView.setNew_post(false);
                        localObject = new Intent();
                        ((Intent) localObject).setClass(FavForumsInboxFragment.this.getActivity(), ConverSationActivity.class);
                        HashMap localHashMap = new HashMap();
                        localHashMap.put("forumStatus", FavForumsInboxFragment.this.usingInClickStatus);
                        localHashMap.put("conv_id", paramAnonymousView.getConv_id());
                        localHashMap.put("fid", paramAnonymousExpandableListView.getForumId());
                        ((Intent) localObject).putExtra("hashmap", localHashMap);
                        ((Intent) localObject).putExtra("viewConvos", true);
                        FavForumsInboxFragment.this.startActivity((Intent) localObject);
                        FavForumsInboxFragment.this.mAdapter.removeChild(paramAnonymousInt1, paramAnonymousInt2);
                        FavForumsInboxFragment.this.mAdapter.notifyDataSetChanged();
                    } else if ((paramAnonymousView instanceof Forum)) {
                        paramAnonymousExpandableListView = (Forum) paramAnonymousView;
                        paramAnonymousView = new Intent();
                        paramAnonymousView.setClass(FavForumsInboxFragment.this.getActivity(), SlidingMenuActivity.class);
                        paramAnonymousView.putExtra("defaultclick", 1019);
                        paramAnonymousView.putExtra("subscribeForum", paramAnonymousExpandableListView);
                        paramAnonymousView.putExtra("forum", FavForumsInboxFragment.this.usingInClickStatus.tapatalkForum);
                        FavForumsInboxFragment.this.startActivity(paramAnonymousView);
                    }
                }
            }
        });
    }

    public void expandRightGroupNoHandle() {
        if (this.mAdapter == null) {
            return;
        }
        int j = this.mAdapter.getGroupCount();
        int i = 0;
        label18:
        if (i < j) {
            String str = ((UnreadStatus) this.mAdapter.getmList().get(i)).getLoginStatus().getPrimaryKey();
            if (!this.primarySaveList.contains(str)) {
                break label94;
            }
            int k = this.mAdapter.getGroupidByforum(str);
            if (!this.mListView.isGroupExpanded(k)) {
                this.mListView.expandGroup(k);
            }
        }
        for (; ; ) {
            i += 1;
            break label18;
            break;
            label94:
            if (this.isFirst) {
                if (!this.mListView.isGroupExpanded(i)) {
                    this.mListView.expandGroup(i);
                }
            } else if (this.mListView.isGroupExpanded(i)) {
                this.mListView.collapseGroup(i);
            }
        }
    }

    public void expandRightGroupUseHandle() {
        if (this.mHandler != null) {
            Message localMessage = this.mHandler.obtainMessage(1);
            this.mHandler.sendMessageDelayed(localMessage, 700L);
        }
    }

    public FavoriateForumInboxAdapter getAdapter() {
        if (this.mAdapter == null) {
            this.mAdapter = new FavoriateForumInboxAdapter((ForumActivityStatus) getActivity(), this.baseData, this.mListView);
            if (this.mListView != null) {
                this.mListView.setAdapter(this.mAdapter);
            }
        }
        return this.mAdapter;
    }

    public void notifyDataChange() {
        this.needNotify = true;
        if ((this.needNotify) && (isResumed())) {
            if (this.mAdapter != null) {
                this.mAdapter.notifyDataSetChanged();
            }
            this.needNotify = false;
        }
    }

    public void notifyDataChange(UnreadStatus paramUnreadStatus) {
        this.needNotify = true;
        if ((this.needNotify) && (isResumed())) {
            if (this.mAdapter != null) {
                this.mAdapter.notifyDataSetChanged();
            }
            this.needNotify = false;
        }
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        Prefs.get(getActivity());
        if ((getActivity() instanceof ShowFragmentActivityInter)) {
            ((ShowFragmentActivityInter) getActivity()).actionBar4ShowTitle("defaultTitleString");
        }
        this.mHandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message paramAnonymousMessage) {
                if (paramAnonymousMessage.what == 1) {
                    FavForumsInboxFragment.this.expandRightGroupNoHandle();
                }
            }
        };
        this.mAdapter = new FavoriateForumInboxAdapter((ForumActivityStatus) getActivity(), this.baseData, this.mListView);
        if (this.callList != null) {
            this.mAdapter.setmList(this.callList);
        }
        this.footLay = ButtomProgress.get(getActivity());
        this.footLay.setEnabled(false);
        this.mListView.addFooterView(this.footLay);
        this.footLay.setVisibility(0);
        this.mListView.setAdapter(this.mAdapter);
        if (this.baseData != null) {
            this.mAdapter.setBaseData(this.baseData);
            this.mAdapter.start();
        }
        setListeners();
        this.mListView.setDivider(null);
        this.mListView.setSelector(2131165212);
        configurationChanged(getResources().getConfiguration());
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        configurationChanged(paramConfiguration);
        super.onConfigurationChanged(paramConfiguration);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903142, null);
        this.mListView = ((ExpandableListView) paramLayoutInflater.findViewById(2131231009));
        this.emptyText = ((TextView) paramLayoutInflater.findViewById(2131231010));
        listViewToggle(true);
        return paramLayoutInflater;
    }

    public void onDestroy() {
        super.onDestroy();
        this.mAdapter = null;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (this.mAdapter != null) {
        }
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        this.mAdapter.clearChildrenData();
        this.mAdapter.notifyDataSetChanged();
        paramMenuItem = this.mAdapter.getmList();
        AccountEntryActivity localAccountEntryActivity = (AccountEntryActivity) getActivity();
        int i = 0;
        for (; ; ) {
            if (i >= paramMenuItem.size()) {
                return true;
            }
            this.mListView.expandGroup(i);
            i += 1;
        }
    }

    public void onResume() {
        if (this.needNotify) {
            if (this.mAdapter != null) {
                this.mAdapter.notifyDataSetChanged();
            }
            this.needNotify = false;
        }
        super.onResume();
    }

    public void removeUnread(UnreadStatus paramUnreadStatus) {
        if ((this.mAdapter != null) && (this.mAdapter.getmList() != null) && (this.mAdapter.getmList().contains(paramUnreadStatus))) {
            this.mAdapter.getmList().remove(paramUnreadStatus);
        }
    }

    public void setCallList(ArrayList<UnreadStatus> paramArrayList) {
        if (paramArrayList == null) {
            if ((this.callList == null) || (this.callList.size() == 0)) {
                listViewToggle(false);
            }
            return;
        }
        this.callList = paramArrayList;
        if (this.mAdapter != null) {
            this.mAdapter.setmList(paramArrayList);
            this.mAdapter.notifyDataSetChanged();
        }
        this.footLay.setVisibility(8);
        if (paramArrayList.size() > 0) {
            listViewToggle(true);
            return;
        }
        listViewToggle(false);
    }

    public void setGroupIcon() {
        if ((getActivity() == null) || (this.mListView == null)) {
            return;
        }
        Object localObject = new Rect();
        getActivity().getWindowManager().getDefaultDisplay().getRectSize((Rect) localObject);
        int i = Build.VERSION.SDK_INT;
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams) this.mListView.getLayoutParams();
        int j = ((Rect) localObject).right - localMarginLayoutParams.rightMargin - localMarginLayoutParams.leftMargin;
        if (i >= 18) {
            localObject = this.mListView.getClass();
            try {
                ((Class) localObject).getDeclaredMethod("setIndicatorBoundsRelative", new Class[]{Integer.TYPE, Integer.TYPE}).invoke(this.mListView, new Object[]{Integer.valueOf(j - 70), Integer.valueOf(j)});
                return;
            } catch (Exception localException) {
                this.mListView.setIndicatorBounds(j - 70, j);
                localException.printStackTrace();
                return;
            }
        }
        this.mListView.setIndicatorBounds(j - 70, j);
    }

    private class CurrentGroup {
        public TapatalkForum forum = null;
        public int groupPosition = -1;

        private CurrentGroup() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/favunread/FavForumsInboxFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */