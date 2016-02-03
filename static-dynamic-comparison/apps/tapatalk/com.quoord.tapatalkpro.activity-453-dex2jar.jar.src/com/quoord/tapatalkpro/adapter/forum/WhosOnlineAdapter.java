package com.quoord.tapatalkpro.adapter.forum;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.activity.forum.ProfilesOuterFragment;
import com.quoord.tapatalkpro.activity.forum.ThreadActivity;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.User;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.saxparser.OnlineSaxParser;
import com.quoord.tapatalkpro.saxparser.OnlineSaxParser.ICallback;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.bitmap.ui.GifImageView;

import java.util.ArrayList;
import java.util.HashMap;

public class WhosOnlineAdapter
        extends ForumRootAdapter
        implements CallBackInterface, AdapterView.OnItemClickListener {
    private int CLOSE_PROGRESS = 0;
    private int UPDATE_BEGIN = 3;
    private int UPDATE_END = 2;
    private int UPDATE_ITEM = 1;
    int countPerPage = 20;
    private int currentSelectPosition = -1;
    private LinearLayout footProgressView = null;
    HashMap<String, GifImageView> icons = new HashMap();
    private Activity mContext;
    private ArrayList mDatas = new ArrayList();
    private Integer mGuestCount = Integer.valueOf(0);
    private Integer mMemberCount = Integer.valueOf(0);
    int mPage = 1;
    OnlineSaxParser mParser;
    Handler mUIHandler;

    public WhosOnlineAdapter(Activity paramActivity, ListView paramListView, String paramString) {
        super(paramActivity, paramString);
        this.mContext = paramActivity;
        this.mListView = paramListView;
        this.mListView.setOnItemClickListener(this);
        this.footProgressView = ButtomProgress.get(this.mContext);
        this.mListView.addFooterView(this.footProgressView);
        this.mListView.setAdapter(this);
        this.mDatas.add("diver1");
        this.mDatas.add("me");
        this.mParser = new OnlineSaxParser();
        this.mParser.setCallback(new OnlineSaxParser.ICallback() {
            public void onAddItem(User paramAnonymousUser) {
                Message localMessage = WhosOnlineAdapter.this.mUIHandler.obtainMessage();
                localMessage.what = WhosOnlineAdapter.this.UPDATE_ITEM;
                localMessage.obj = paramAnonymousUser;
                WhosOnlineAdapter.this.mUIHandler.sendMessage(localMessage);
            }

            public void onDocBegin() {
                Message localMessage = WhosOnlineAdapter.this.mUIHandler.obtainMessage();
                localMessage.what = WhosOnlineAdapter.this.UPDATE_BEGIN;
                WhosOnlineAdapter.this.mUIHandler.sendMessage(localMessage);
            }

            public void onDocEnd() {
                Message localMessage = WhosOnlineAdapter.this.mUIHandler.obtainMessage();
                localMessage.what = WhosOnlineAdapter.this.UPDATE_END;
                WhosOnlineAdapter.this.mUIHandler.sendMessage(localMessage);
            }

            public void onGetGuestNum(int paramAnonymousInt) {
                Message localMessage = WhosOnlineAdapter.this.mUIHandler.obtainMessage();
                localMessage.what = WhosOnlineAdapter.this.CLOSE_PROGRESS;
                WhosOnlineAdapter.this.mGuestCount = Integer.valueOf(paramAnonymousInt);
                WhosOnlineAdapter.this.mUIHandler.sendMessage(localMessage);
            }

            public void onGetOnlineNum(int paramAnonymousInt) {
                Message localMessage = WhosOnlineAdapter.this.mUIHandler.obtainMessage();
                localMessage.what = WhosOnlineAdapter.this.CLOSE_PROGRESS;
                WhosOnlineAdapter.this.mMemberCount = Integer.valueOf(paramAnonymousInt);
                WhosOnlineAdapter.this.mUIHandler.sendMessage(localMessage);
            }
        });
        this.mUIHandler = new Handler() {
            public void handleMessage(Message paramAnonymousMessage) {
                Object localObject;
                if (paramAnonymousMessage.what == WhosOnlineAdapter.this.CLOSE_PROGRESS) {
                    localObject = "";
                    if (WhosOnlineAdapter.this.mMemberCount.intValue() != -1) {
                        localObject = WhosOnlineAdapter.this.mMemberCount + " " + WhosOnlineAdapter.this.mContext.getString(2131099868);
                    }
                    if (WhosOnlineAdapter.this.mGuestCount.intValue() != -1) {
                        new StringBuilder(String.valueOf(localObject)).append(" ").append(WhosOnlineAdapter.this.mGuestCount).append(" ").append(WhosOnlineAdapter.this.mContext.getString(2131099869)).toString();
                    }
                    WhosOnlineAdapter.this.notifyDataSetChanged();
                }
                if (paramAnonymousMessage.what == WhosOnlineAdapter.this.UPDATE_ITEM) {
                    localObject = (User) paramAnonymousMessage.obj;
                    if (((((User) localObject).getDisplay_name() == null) || (!((User) localObject).getDisplay_name().equals(WhosOnlineAdapter.this.forumStatus.tapatalkForum.getUserName()))) && ((((User) localObject).getName() == null) || (!((User) localObject).getName().equals(WhosOnlineAdapter.this.forumStatus.tapatalkForum.getUserName())))) {
                        WhosOnlineAdapter.this.mDatas.add(localObject);
                        WhosOnlineAdapter.this.notifyDataSetChanged();
                    }
                }
                if (paramAnonymousMessage.what == WhosOnlineAdapter.this.UPDATE_END) {
                    if (WhosOnlineAdapter.this.mListView.getFooterViewsCount() > 0) {
                        WhosOnlineAdapter.this.mListView.removeFooterView(WhosOnlineAdapter.this.footProgressView);
                    }
                    if (WhosOnlineAdapter.this.mMemberCount.intValue() == 1) {
                        WhosOnlineAdapter.this.mDatas.remove("diver2");
                    }
                    WhosOnlineAdapter.this.notifyDataSetChanged();
                    WhosOnlineAdapter.this.loadingMore = false;
                    if (WhosOnlineAdapter.this.forumStatus.isAdvancedOnlineUsers()) {
                        WhosOnlineAdapter.this.loadmore();
                    }
                }
            }
        };
        get_online_users();
    }

    private void get_online_users() {
        setTryTwice(false);
        this.loadingMore = true;
        if (this.mListView.getFooterViewsCount() == 0) {
            this.mListView.addFooterView(this.footProgressView);
        }
        ArrayList localArrayList = new ArrayList();
        if (this.forumStatus.isAdvancedOnlineUsers()) {
            localArrayList.add(Integer.valueOf(this.mPage));
            localArrayList.add(Integer.valueOf(this.countPerPage));
        }
        this.engine.saxcall(this.mParser, "get_online_users", localArrayList);
    }

    private boolean isFootNeeded() {
        return (this.mPage - 1) * this.countPerPage <= this.mMemberCount.intValue();
    }

    public void cancel(boolean paramBoolean) {
        this.isOpCancel = paramBoolean;
    }

    public String getCallBackTag() {
        return System.currentTimeMillis();
    }

    public int getCount() {
        return this.mDatas.size();
    }

    public Integer getGuestCount() {
        return this.mGuestCount;
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
        int i = 1;
        if (paramInt == 1) {
            i = 0;
        }
        while (paramInt == 0) {
            return i;
        }
        return 2;
    }

    public Integer getMemberCount() {
        return this.mMemberCount;
    }

    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup) {
        Object localObject;
        if (paramInt == 1) {
            paramView = this.mContext.getLayoutInflater().inflate(2130903436, null);
            localObject = (LinearLayout) paramView.findViewById(2131231739);
            paramViewGroup = (ImageView) paramView.findViewById(2131231737);
            ((LinearLayout) localObject).setBackgroundResource(ThemeUtil.getDialogDrawableId("forum_top_item_bg", this.mContext));
            localObject = (TextView) paramView.findViewById(2131231740);
            ((TextView) localObject).setText(this.mMemberCount + " " + this.mContext.getString(2131099868) + " " + this.mGuestCount + " " + this.mContext.getString(2131099869));
            ThemeUtil.setAuthorColor(this.mContext, (TextView) localObject);
            if (this.mMemberCount.intValue() > 0) {
                paramViewGroup.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_item_diver", this.mContext));
                paramViewGroup.setVisibility(0);
                return paramView;
            }
            paramViewGroup.setVisibility(8);
            return paramView;
        }
        if (paramInt == 0) {
            paramView = this.mContext.getLayoutInflater().inflate(2130903434, null);
            paramViewGroup = paramView.findViewById(2131231738);
            localObject = (TextView) paramView.findViewById(2131231735);
            GifImageView localGifImageView = (GifImageView) paramView.findViewById(2131231733);
            paramViewGroup.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("topic_item_bg", this.mContext));
            paramInt = this.mContext.getResources().getDimensionPixelOffset(2131427354);
            paramViewGroup.setPadding(0, paramInt, 0, paramInt);
            ((TextView) localObject).setText(this.forumStatus.getCurrentUserName());
            if ((this.forumStatus.isSupport_avatar()) && (!TapatalkApp.rebranding_url.contains("xda-developers"))) {
                if (!Util.is2GState(this.mContext)) {
                    if (SettingsFragment.isShowAvatar(this.mContext)) {
                        AvatarTool.showAvatar(this.mContext, this.forumStatus, localGifImageView, this.forumStatus.getPrefectUrl() + "mobiquo/avatar.php?user_id=" + this.forumStatus.getUserId(), 0);
                    }
                }
            }
            for (; ; ) {
                return paramView;
                localGifImageView.setVisibility(8);
                continue;
                if (SettingsFragment.isShowAvatarWithSlowConn(this.mContext)) {
                    AvatarTool.showAvatar(this.mContext, this.forumStatus, localGifImageView, this.forumStatus.getPrefectUrl() + "mobiquo/avatar.php?user_id=" + this.forumStatus.getUserId(), 0);
                } else {
                    localGifImageView.setVisibility(8);
                    continue;
                    Util.getUserImage(this.mContext, this.forumStatus, localGifImageView, this.forumStatus.getAvatarUrl(), null);
                }
            }
        }
        if (paramView == null) {
            paramView = this.mContext.getLayoutInflater().inflate(2130903433, null);
            paramViewGroup = new ViewHolder(null);
            paramViewGroup.layoutView = ((RelativeLayout) paramView.findViewById(2131231732));
            paramViewGroup.diver = ((ImageView) paramView.findViewById(2131231737));
            paramViewGroup.textLayout = ((LinearLayout) paramView.findViewById(2131231734));
            paramViewGroup.icon = ((GifImageView) paramView.findViewById(2131231733));
            paramViewGroup.text = ((TextView) paramView.findViewById(2131231735));
            paramViewGroup.display = ((TextView) paramView.findViewById(2131231736));
            ThemeUtil.setAuthorColor(this.mContext, paramViewGroup.text);
            paramViewGroup.diver.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_item_diver", this.mContext));
            paramView.setTag(paramViewGroup);
            localObject = (User) this.mDatas.get(paramInt);
            if (((User) localObject).getDisplay_name() == null) {
                break label993;
            }
            paramViewGroup.text.setText(((User) localObject).getDisplay_name());
            label668:
            this.icons.put(((User) localObject).getId(), paramViewGroup.icon);
            if ((((User) localObject).getId() == null) || (!this.forumStatus.isSupport_avatar()) || (TapatalkApp.rebranding_url.contains("xda-developers"))) {
                break label1095;
            }
            if (Util.is2GState(this.mContext)) {
                break label1020;
            }
            if (!SettingsFragment.isShowAvatar(this.mContext)) {
                break label1008;
            }
            AvatarTool.showAvatar(this.mContext, this.forumStatus, paramViewGroup.icon, this.forumStatus.getPrefectUrl() + "mobiquo/avatar.php?user_id=" + ((User) localObject).getId(), 0);
            label785:
            paramViewGroup.layoutView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    WhosOnlineAdapter.this.currentSelectPosition = paramInt;
                    if ((WhosOnlineAdapter.this.getItem(paramInt) instanceof User)) {
                        paramAnonymousView = (User) WhosOnlineAdapter.this.getItem(paramInt);
                        WhosOnlineAdapter.this.openProfile(paramAnonymousView.getName(), paramAnonymousView.getId(), paramAnonymousView);
                        return;
                    }
                    WhosOnlineAdapter.this.openProfile(WhosOnlineAdapter.this.forumStatus.getCurrentUserName(), WhosOnlineAdapter.this.forumStatus.tapatalkForum.getUserId(), null);
                }
            });
            paramViewGroup.display.setText(((User) localObject).getParsedDisplayText());
            paramViewGroup.display.setLinkTextColor(this.mContext.getApplicationContext().getResources().getColor(2131165329));
            localObject = new MyLinkMovementMethod((User) localObject, paramInt, paramViewGroup.layoutView);
            paramViewGroup.display.setMovementMethod((MovementMethod) localObject);
            if ((getCount() - 3 != 0) && (paramInt != getCount() - 1)) {
                break label1119;
            }
            paramViewGroup.layoutView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_bottom_item_bg", this.mContext));
            paramViewGroup.diver.setVisibility(8);
            label907:
            if (((this.mContext instanceof SlidingMenuActivity)) && (((SlidingMenuActivity) this.mContext).getShowSlectionStatus())) {
                if (this.currentSelectPosition != paramInt) {
                    break label1184;
                }
                paramViewGroup.layoutView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_mid_bg_select", this.mContext));
            }
        }
        for (; ; ) {
            paramInt = this.mContext.getResources().getDimensionPixelOffset(2131427354);
            paramViewGroup.layoutView.setPadding(0, paramInt, 0, paramInt);
            return paramView;
            paramViewGroup = (ViewHolder) paramView.getTag();
            break;
            label993:
            paramViewGroup.text.setText(((User) localObject).getName());
            break label668;
            label1008:
            paramViewGroup.icon.setVisibility(8);
            break label785;
            label1020:
            if (SettingsFragment.isShowAvatarWithSlowConn(this.mContext)) {
                AvatarTool.showAvatar(this.mContext, this.forumStatus, paramViewGroup.icon, this.forumStatus.getPrefectUrl() + "mobiquo/avatar.php?user_id=" + ((User) localObject).getId(), 0);
                break label785;
            }
            paramViewGroup.icon.setVisibility(8);
            break label785;
            label1095:
            Util.getUserImage(this.mContext, this.forumStatus, paramViewGroup.icon, ((User) localObject).getIconUrl(), null);
            break label785;
            label1119:
            if (getCount() - 3 != 0) {
                paramViewGroup.layoutView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_mid_item_bg", this.mContext));
                paramViewGroup.diver.setVisibility(0);
                break label907;
            }
            paramViewGroup.layoutView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_mid_item_bg", this.mContext));
            paramViewGroup.diver.setVisibility(0);
            break label907;
            label1184:
            paramViewGroup.layoutView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_mid_item_bg", this.mContext));
        }
    }

    public int getViewTypeCount() {
        return 3;
    }

    public void loadmore() {
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                if ((paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3) && (!WhosOnlineAdapter.this.loadingMore) && (WhosOnlineAdapter.this.isFootNeeded())) {
                    paramAnonymousAbsListView = WhosOnlineAdapter.this;
                    paramAnonymousAbsListView.mPage += 1;
                    WhosOnlineAdapter.this.get_online_users();
                }
            }

            public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
            }
        });
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        if (paramInt == 1) {
        }
        while (paramInt != 0) {
            return;
        }
        openProfile(this.forumStatus.getCurrentUserName(), this.forumStatus.tapatalkForum.getUserId(), null);
        this.currentSelectPosition = paramInt;
    }

    public void openProfile(String paramString1, String paramString2, User paramUser) {
        try {
            paramString1 = ProfilesOuterFragment.newInstance(paramString1, paramString2, this.forumStatus);
            ((SlidingMenuActivity) this.mContext).getActionBar().setDisplayShowTitleEnabled(false);
            ((SlidingMenuActivity) this.mContext).showDetail(paramString1);
            notifyDataSetChanged();
            return;
        } catch (Exception paramString1) {
            paramString1.printStackTrace();
        }
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
    }

    public void refresh() {
        this.mDatas.clear();
        this.mDatas.add("diver1");
        this.mDatas.add("me");
        if (this.mListView.getFooterViewsCount() > 0) {
            this.mListView.removeFooterView(this.footProgressView);
        }
        this.mPage = 1;
        get_online_users();
    }

    public void updateIcons() {
        notifyDataSetChanged();
    }

    class MyLinkMovementMethod
            implements MovementMethod {
        private View layout;
        private MovementMethod mParen = null;
        private String mUrl = null;
        private int position;
        private User user;

        public MyLinkMovementMethod(User paramUser, int paramInt, View paramView) {
            this.user = paramUser;
            this.layout = paramView;
            this.position = paramInt;
        }

        private boolean action(String paramString) {
            openTopic(paramString);
            return false;
        }

        public boolean canSelectArbitrarily() {
            return this.mParen.canSelectArbitrarily();
        }

        public void initialize(TextView paramTextView, Spannable paramSpannable) {
            this.mParen.initialize(paramTextView, paramSpannable);
        }

        public boolean onGenericMotionEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent) {
            return false;
        }

        public boolean onKeyDown(TextView paramTextView, Spannable paramSpannable, int paramInt, KeyEvent paramKeyEvent) {
            this.mUrl = paramSpannable.toString();
            switch (paramInt) {
                default:
                    return this.mParen.onKeyDown(paramTextView, paramSpannable, paramInt, paramKeyEvent);
            }
            action(this.mUrl);
            return true;
        }

        public boolean onKeyOther(TextView paramTextView, Spannable paramSpannable, KeyEvent paramKeyEvent) {
            return this.mParen.onKeyOther(paramTextView, paramSpannable, paramKeyEvent);
        }

        public boolean onKeyUp(TextView paramTextView, Spannable paramSpannable, int paramInt, KeyEvent paramKeyEvent) {
            return this.mParen.onKeyUp(paramTextView, paramSpannable, paramInt, paramKeyEvent);
        }

        public void onTakeFocus(TextView paramTextView, Spannable paramSpannable, int paramInt) {
            this.mParen.onTakeFocus(paramTextView, paramSpannable, paramInt);
        }

        public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent) {
            this.mUrl = paramSpannable.toString();
            switch (paramMotionEvent.getAction()) {
                default:
                    return this.mParen.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
                case 1:
                    int i = (int) paramMotionEvent.getX();
                    int j = (int) paramMotionEvent.getY();
                    int k = paramTextView.getTotalPaddingLeft();
                    int m = paramTextView.getTotalPaddingTop();
                    int n = paramTextView.getScrollX();
                    int i1 = paramTextView.getScrollY();
                    paramTextView = paramTextView.getLayout();
                    i = paramTextView.getOffsetForHorizontal(paramTextView.getLineForVertical(j - m + i1), i - k + n);
                    paramTextView = (URLSpan[]) paramSpannable.getSpans(i, i, URLSpan.class);
                    if (paramTextView.length != 0) {
                        if (paramMotionEvent.getAction() == 0) {
                            Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(paramTextView[0]), paramSpannable.getSpanEnd(paramTextView[0]));
                        }
                    }
                    for (; ; ) {
                        this.layout.setPressed(false);
                        return true;
                        openTopic(paramTextView[0].getURL());
                        continue;
                        WhosOnlineAdapter.this.openProfile(this.user.getName(), this.user.getId(), this.user);
                        WhosOnlineAdapter.this.currentSelectPosition = this.position;
                    }
            }
            this.layout.setPressed(true);
            return this.mParen.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
        }

        public boolean onTrackballEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent) {
            return this.mParen.onTrackballEvent(paramTextView, paramSpannable, paramMotionEvent);
        }

        public void openTopic(String paramString) {
            Intent localIntent = new Intent();
            localIntent.setClass(WhosOnlineAdapter.this.mContext, ThreadActivity.class);
            localIntent.putExtra("topic_id", paramString);
            localIntent.putExtra("topic_title", "");
            localIntent.putExtra("reply_count", 0);
            localIntent.putExtra("forumid", "0");
            localIntent.putExtra("isNew", false);
            localIntent.putExtra("forumStatus", WhosOnlineAdapter.this.forumStatus);
            if (!WhosOnlineAdapter.this.forumStatus.isLogin()) {
                localIntent.putExtra("goto_first_post", true);
            }
            WhosOnlineAdapter.this.mContext.startActivityForResult(localIntent, 8);
        }
    }

    private static class ViewHolder {
        TextView display;
        ImageView diver;
        GifImageView icon;
        RelativeLayout layoutView;
        TextView text;
        LinearLayout textLayout;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/WhosOnlineAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */