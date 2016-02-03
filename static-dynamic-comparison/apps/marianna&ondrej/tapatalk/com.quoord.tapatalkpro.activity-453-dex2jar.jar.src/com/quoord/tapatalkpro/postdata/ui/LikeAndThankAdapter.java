package com.quoord.tapatalkpro.postdata.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.adapter.forum.ForumRootAdapter;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.bitmap.ui.GifImageView;

import java.util.ArrayList;
import java.util.HashMap;

public class LikeAndThankAdapter
        extends ForumRootAdapter {
    private ImageView avatarbg;
    private ActionBar bar;
    private ImageView diver;
    private ForumStatus forumStatus;
    private GifImageView icon;
    private boolean isLike;
    private RelativeLayout layoutView;
    private Activity mActivity;
    private ArrayList<HashMap> mData;
    private TextView user;

    public LikeAndThankAdapter(Activity paramActivity, ForumStatus paramForumStatus, ArrayList<HashMap> paramArrayList, boolean paramBoolean) {
        super(paramActivity, paramForumStatus.getUrl());
        this.mActivity = paramActivity;
        this.forumStatus = paramForumStatus;
        this.mData = paramArrayList;
        this.isLike = paramBoolean;
        this.bar = this.mActivity.getActionBar();
        this.bar.setDisplayHomeAsUpEnabled(true);
        this.bar.setDisplayShowTitleEnabled(true);
        if (this.isLike) {
            this.bar.setTitle(paramArrayList.size() + this.mActivity.getResources().getString(2131100494));
            return;
        }
        this.bar.setTitle(paramArrayList.size() + this.mActivity.getResources().getString(2131100495));
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

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if (this.mData.size() == 1) {
            return getlikeandthankView(paramInt, paramView, paramViewGroup, "bottom");
        }
        if (paramInt == 0) {
            return getlikeandthankView(paramInt, paramView, paramViewGroup, "top");
        }
        if (paramInt == getCount() - 1) {
            return getlikeandthankView(paramInt, paramView, paramViewGroup, "bottom");
        }
        return getlikeandthankView(paramInt, paramView, paramViewGroup, "mid");
    }

    public View getlikeandthankView(int paramInt, View paramView, ViewGroup paramViewGroup, String paramString) {
        if (paramString.equals("bottom")) {
            paramView = LayoutInflater.from(this.mActivity).inflate(2130903256, null);
            this.layoutView = ((RelativeLayout) paramView.findViewById(2131231360));
            this.icon = ((GifImageView) paramView.findViewById(2131231361));
            this.avatarbg = ((ImageView) paramView.findViewById(2131230795));
            this.user = ((TextView) paramView.findViewById(2131231362));
            if ((((HashMap) this.mData.get(paramInt)).get("username") != null) && (!((HashMap) this.mData.get(paramInt)).get("username").equals(""))) {
                this.user.setText(new String((byte[]) ((HashMap) this.mData.get(paramInt)).get("username")));
            }
            ThemeUtil.setAuthorColor(this.mActivity, this.user);
            if (!Util.is2GState(this.mActivity)) {
                if (SettingsFragment.isShowAvatar(this.mActivity)) {
                    AvatarTool.showAvatar(this.mActivity, this.forumStatus, this.icon, this.forumStatus.getPrefectUrl() + "mobiquo/avatar.php?user_id=" + ((HashMap) this.mData.get(paramInt)).get("userid"), 0);
                }
            }
            for (; ; ) {
                this.layoutView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_bottom_item_bg", this.mActivity));
                if (this.mData.size() == 1) {
                    paramView.setPadding(0, 20, 0, 0);
                }
                return paramView;
                this.icon.setVisibility(8);
                this.avatarbg.setVisibility(8);
                continue;
                if (SettingsFragment.isShowAvatarWithSlowConn(this.mActivity)) {
                    AvatarTool.showAvatar(this.mActivity, this.forumStatus, this.icon, this.forumStatus.getPrefectUrl() + "mobiquo/avatar.php?user_id=" + ((HashMap) this.mData.get(paramInt)).get("userid"), 0);
                } else {
                    this.icon.setVisibility(8);
                    this.avatarbg.setVisibility(8);
                }
            }
        }
        if (paramString.equals("top")) {
            paramView = LayoutInflater.from(this.mActivity).inflate(2130903258, null);
            this.layoutView = ((RelativeLayout) paramView.findViewById(2131231360));
            this.icon = ((GifImageView) paramView.findViewById(2131231361));
            this.avatarbg = ((ImageView) paramView.findViewById(2131230795));
            this.user = ((TextView) paramView.findViewById(2131231362));
            this.diver = ((ImageView) paramView.findViewById(2131231363));
            this.diver.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_item_diver", this.mActivity));
            if ((((HashMap) this.mData.get(paramInt)).get("username") != null) && (!((HashMap) this.mData.get(paramInt)).get("username").equals(""))) {
                this.user.setText(new String((byte[]) ((HashMap) this.mData.get(paramInt)).get("username")));
            }
            ThemeUtil.setAuthorColor(this.mActivity, this.user);
            if (!Util.is2GState(this.mActivity)) {
                if (SettingsFragment.isShowAvatar(this.mActivity)) {
                    AvatarTool.showAvatar(this.mActivity, this.forumStatus, this.icon, this.forumStatus.getPrefectUrl() + "mobiquo/avatar.php?user_id=" + ((HashMap) this.mData.get(paramInt)).get("userid"), 0);
                }
            }
            for (; ; ) {
                this.layoutView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_top_item_bg", this.mActivity));
                return paramView;
                this.icon.setVisibility(8);
                this.avatarbg.setVisibility(8);
                continue;
                if (SettingsFragment.isShowAvatarWithSlowConn(this.mActivity)) {
                    AvatarTool.showAvatar(this.mActivity, this.forumStatus, this.icon, this.forumStatus.getPrefectUrl() + "mobiquo/avatar.php?user_id=" + ((HashMap) this.mData.get(paramInt)).get("userid"), 0);
                } else {
                    this.icon.setVisibility(8);
                    this.avatarbg.setVisibility(8);
                }
            }
        }
        paramView = LayoutInflater.from(this.mActivity).inflate(2130903257, null);
        this.layoutView = ((RelativeLayout) paramView.findViewById(2131231360));
        this.icon = ((GifImageView) paramView.findViewById(2131231361));
        this.user = ((TextView) paramView.findViewById(2131231362));
        this.avatarbg = ((ImageView) paramView.findViewById(2131230795));
        this.diver = ((ImageView) paramView.findViewById(2131231363));
        this.diver.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_item_diver", this.mActivity));
        if ((((HashMap) this.mData.get(paramInt)).get("username") != null) && (!((HashMap) this.mData.get(paramInt)).get("username").equals(""))) {
            this.user.setText(new String((byte[]) ((HashMap) this.mData.get(paramInt)).get("username")));
        }
        ThemeUtil.setAuthorColor(this.mActivity, this.user);
        if (!Util.is2GState(this.mActivity)) {
            if (SettingsFragment.isShowAvatar(this.mActivity)) {
                AvatarTool.showAvatar(this.mActivity, this.forumStatus, this.icon, this.forumStatus.getPrefectUrl() + "mobiquo/avatar.php?user_id=" + ((HashMap) this.mData.get(paramInt)).get("userid"), 0);
            }
        }
        for (; ; ) {
            this.layoutView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_mid_item_bg", this.mActivity));
            return paramView;
            this.icon.setVisibility(8);
            this.avatarbg.setVisibility(8);
            continue;
            if (SettingsFragment.isShowAvatarWithSlowConn(this.mActivity)) {
                AvatarTool.showAvatar(this.mActivity, this.forumStatus, this.icon, this.forumStatus.getPrefectUrl() + "mobiquo/avatar.php?user_id=" + ((HashMap) this.mData.get(paramInt)).get("userid"), 0);
            } else {
                this.icon.setVisibility(8);
                this.avatarbg.setVisibility(8);
            }
        }
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
    }

    public void refresh() {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/postdata/ui/LikeAndThankAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */