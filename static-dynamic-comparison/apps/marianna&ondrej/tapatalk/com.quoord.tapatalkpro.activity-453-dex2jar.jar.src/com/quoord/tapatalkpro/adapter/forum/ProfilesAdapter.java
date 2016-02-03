package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quoord.DialogUtil.UploadDialog;
import com.quoord.tapatalkpro.action.UserInfoAction;
import com.quoord.tapatalkpro.activity.forum.ProfilesOuterFragment;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.User;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tools.bitmap.ui.GifImageView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class ProfilesAdapter
        extends ForumRootAdapter {
    public LinearLayout footlay;
    private ForumStatus forumStatus;
    private String forumUrl;
    private Activity mActivity;
    private ArrayList<Object> mDatas = new ArrayList();
    public UserInfoAction userAction;
    private String userId;
    private String user_name;

    public ProfilesAdapter(ProfilesOuterFragment paramProfilesOuterFragment, String paramString1, String paramString2, String paramString3, ForumStatus paramForumStatus, LinearLayout paramLinearLayout) {
        super(paramProfilesOuterFragment.mActivity, paramProfilesOuterFragment, paramString1);
        this.mActivity = paramProfilesOuterFragment.mActivity;
        this.forumStatus = paramForumStatus;
        this.user_name = paramString2;
        this.userId = paramString3;
        this.forumUrl = paramString1;
        this.footlay = paramLinearLayout;
        this.userAction = new UserInfoAction(this.mActivity, this.forumUrl, this.user_name, this.userId, this.forumStatus, this);
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
        if (this.mDatas.get(paramInt).toString().equals("userinfo_section")) {
            paramView = (RelativeLayout) LayoutInflater.from(this.mActivity).inflate(2130903427, null);
            paramViewGroup = paramView.findViewById(2131231721);
            localObject1 = (ImageView) paramView.findViewById(2131231536);
            if ((this.userAction.supportOnlineStatus) && (!this.forumStatus.isBB())) {
                ((ImageView) localObject1).setVisibility(0);
                if (this.userAction.user.isOnline()) {
                    ((ImageView) localObject1).setImageResource(2130839197);
                }
            } else {
                localObject1 = (TextView) paramView.findViewById(2131231577);
                ((TextView) localObject1).setTextColor(this.mActivity.getResources().getColor(ThemeUtil.getTextColor(this.mActivity)));
                localObject2 = (GifImageView) paramView.findViewById(2131231264);
                AvatarTool.showAvatar(this.mActivity, this.forumStatus, (GifImageView) localObject2, this.userAction.user.getIconUrl(), 0);
                if ((!this.forumStatus.isSupportUploadAvatar()) || (!this.user_name.equalsIgnoreCase(this.forumStatus.getCurrentUserName()))) {
                    break label351;
                }
                ((LinearLayout) paramView.findViewById(2131230768)).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        ProfilesAdapter.this.userAction.mUploadDialog.getUploadSelectorDialog().show();
                    }
                });
                label215:
                this.userAction.user.setName(this.user_name);
                if (this.userAction.user.getDisplay_name() == null) {
                    break label368;
                }
                ((TextView) localObject1).setText(this.userAction.user.getDisplay_name());
                label257:
                localObject1 = (TextView) paramView.findViewById(2131230993);
                if (!this.userAction.user.isBan()) {
                    break label380;
                }
                ((TextView) localObject1).setText(this.mActivity.getResources().getString(2131100637));
            }
            for (; ; ) {
                ((ImageView) paramView.findViewById(2131231725)).setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_item_diver", this.mActivity));
                paramViewGroup.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_top_item_bg", this.mActivity));
                return paramView;
                ((ImageView) localObject1).setVisibility(8);
                ((ImageView) localObject1).setImageResource(17301609);
                break;
                label351:
                ((ImageView) paramView.findViewById(2131231531)).setVisibility(8);
                break label215;
                label368:
                ((TextView) localObject1).setText(this.user_name);
                break label257;
                label380:
                if ((this.userAction.user.getCurrentActivity() != null) && (this.userAction.user.getCurrentActivity().length() > 0)) {
                    ((TextView) localObject1).setText(this.userAction.user.getCurrentActivity());
                }
            }
        }
        if (this.mDatas.get(paramInt).toString().equals("post_count")) {
            paramView = LayoutInflater.from(this.mActivity).inflate(2130903428, null);
            paramViewGroup = paramView.findViewById(2131231721);
            localObject1 = (TextView) paramView.findViewById(2131231727);
            localObject2 = (TextView) paramView.findViewById(2131231726);
            ((TextView) localObject1).setText(2131099883);
            ((ImageView) paramView.findViewById(2131231725)).setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_item_diver", this.mActivity));
            ((TextView) localObject2).setText(this.userAction.user.getPostCount());
            paramViewGroup.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_mid_item_bg", this.mActivity));
            ((TextView) localObject1).setPadding(10, 0, 0, 0);
            ((TextView) localObject2).setPadding(0, 0, 10, 0);
            return paramView;
        }
        if (this.mDatas.get(paramInt).toString().equals("reg_time")) {
            paramView = LayoutInflater.from(this.mActivity).inflate(2130903428, null);
            paramViewGroup = paramView.findViewById(2131231721);
            localObject1 = (TextView) paramView.findViewById(2131231727);
            localObject2 = (TextView) paramView.findViewById(2131231726);
            ((TextView) localObject1).setText(2131099884);
            ((ImageView) paramView.findViewById(2131231725)).setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_item_diver", this.mActivity));
            localObject3 = new SimpleDateFormat("yyyy MMM dd");
            if (this.userAction.user.getRegTime() != null) {
                ((TextView) localObject2).setText(((SimpleDateFormat) localObject3).format(this.userAction.user.getRegTime()));
            }
            paramViewGroup.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_mid_item_bg", this.mActivity));
            ((TextView) localObject1).setPadding(10, 0, 0, 0);
            ((TextView) localObject2).setPadding(0, 0, 10, 0);
            return paramView;
        }
        Object localObject1 = LayoutInflater.from(this.mActivity).inflate(2130903428, null);
        Object localObject2 = ((View) localObject1).findViewById(2131231721);
        Object localObject3 = (TextView) ((View) localObject1).findViewById(2131231727);
        TextView localTextView = (TextView) ((View) localObject1).findViewById(2131231726);
        HashMap localHashMap = (HashMap) this.mDatas.get(paramInt);
        try {
            paramView = new String((byte[]) localHashMap.get("name"), "UTF-8");
        } catch (Exception paramView) {
            try {
                for (; ; ) {
                    paramViewGroup = new String((byte[]) localHashMap.get("value"), "UTF-8");
                    ((TextView) localObject3).setText(paramView + ":");
                    localTextView.setText(paramViewGroup);
                    if ((paramView == null) || (paramView.length() == 0)) {
                        ((TextView) localObject3).setVisibility(8);
                    }
                    ((ImageView) ((View) localObject1).findViewById(2131231725)).setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_item_diver", this.mActivity));
                    ((View) localObject2).setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_mid_item_bg", this.mActivity));
                    ((TextView) localObject3).setPadding(10, 0, 0, 0);
                    localTextView.setPadding(0, 0, 10, 0);
                    return (View) localObject1;
                    paramView = paramView;
                    paramView = new String((byte[]) localHashMap.get("name"));
                }
            } catch (Exception paramViewGroup) {
                for (; ; ) {
                    paramViewGroup = new String((byte[]) localHashMap.get("value"));
                }
            }
        }
    }

    public ArrayList<Object> getmDatas() {
        if (this.mDatas == null) {
            this.mDatas = new ArrayList();
        }
        return this.mDatas;
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
    }

    public void refresh() {
        this.mDatas.clear();
        this.userAction = new UserInfoAction(this.mActivity, this.forumUrl, this.user_name, this.userId, this.forumStatus, this);
        notifyDataSetChanged();
    }

    public void setmDatas(ArrayList<Object> paramArrayList) {
        this.mDatas = paramArrayList;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/ProfilesAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */