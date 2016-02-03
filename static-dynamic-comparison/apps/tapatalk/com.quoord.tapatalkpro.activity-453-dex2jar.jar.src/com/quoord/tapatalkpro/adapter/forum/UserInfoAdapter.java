package com.quoord.tapatalkpro.adapter.forum;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quoord.DialogUtil.UploadDialog;
import com.quoord.tapatalkpro.activity.forum.CreatePmActivity;
import com.quoord.tapatalkpro.activity.forum.conversation.CreateOrReplyConversationActivity;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.User;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.bitmap.ui.GifImageView;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class UserInfoAdapter
        extends ForumRootAdapter {
    boolean isAcceptPm = true;
    public boolean isShowUpdate = false;
    boolean isSupportConversation = false;
    Activity mContext;
    ArrayList mData = new ArrayList();
    public UploadDialog mUploadDialog;
    String mUsername;
    ImageView myinfoIcon = null;
    TextView myinfoName = null;
    TextView myinfoPostCount = null;
    TextView myinfoRegtime = null;
    LinearLayout myinfoView = null;
    private RelativeLayout profile_layout;
    public ProgressDialog progress = null;
    public boolean supportOnlineStatus = false;
    public User user = new User();

    public UserInfoAdapter(Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean, RelativeLayout paramRelativeLayout) {
        super(paramActivity, paramString1);
        this.isSupportConversation = paramBoolean;
        this.mContext = paramActivity;
        this.profile_layout = paramRelativeLayout;
        this.mUsername = paramString2;
        if ((this.forumStatus.isRegister()) && (this.mUsername.equalsIgnoreCase(this.forumStatus.getUser()))) {
            this.isShowUpdate = true;
        }
        get_user_info(paramString2);
        GoogleAnalyticsTools.trackPageView(this.mContext, "profile", this.forumStatus.getForumId(), this.forumStatus.getUrl());
        this.mUploadDialog = new UploadDialog(paramActivity, this.forumStatus, this.engine);
        this.progress = new ProgressDialog(this.mContext);
        this.progress.setMessage(this.mContext.getResources().getString(2131099873));
    }

    private void get_user_info(String paramString) {
        setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        try {
            byte[] arrayOfByte = paramString.getBytes("UTF-8");
            paramString = arrayOfByte;
        } catch (Exception localException) {
            for (; ; ) {
                paramString = paramString.getBytes();
            }
        }
        localArrayList.add(paramString);
        this.engine.call("get_user_info", localArrayList);
    }

    public String getCallBackTag() {
        return System.currentTimeMillis();
    }

    public int getCount() {
        return this.mData.size();
    }

    public Object getItem(int paramInt) {
        return this.mData.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return 0L;
    }

    public String getPostCount() {
        return this.user.getPostCount();
    }

    public Integer getPost_count() {
        return Integer.valueOf(this.user.getPostCount());
    }

    public String getRegTime() {
        int j = this.user.getRegTime().getHours();
        String str = "AM";
        int i = j;
        if (j > 12) {
            i = j - 12;
            str = "PM";
        }
        return this.user.getRegTime().getMonth() + " " + this.user.getRegTime().getDate() + " " + i + ":" + this.user.getRegTime().getMinutes() + str;
    }

    public Date getReg_time() {
        return this.user.getRegTime();
    }

    public User getUser() {
        return this.user;
    }

    public Bitmap getUsericon() {
        if (this.user.getLocalIconUri() != null) {
            this.user.setIcon(Util.getRemotePic(this.user.getLocalIconUri()));
        }
        return this.user.getIcon();
    }

    public View getView(final int paramInt, final View paramView, ViewGroup paramViewGroup) {
        if (((this.mUsername.equalsIgnoreCase(this.forumStatus.tapatalkForum.getUserName())) || (!this.forumStatus.isCanPm()) || (!this.forumStatus.isCanSendPm()) || (!this.isAcceptPm)) || (this.mData.get(paramInt).toString().equals("post_count"))) {
            paramView = LayoutInflater.from(this.mContext).inflate(2130903428, null);
            paramViewGroup = paramView.findViewById(2131231721);
            localObject1 = (TextView) paramView.findViewById(2131231727);
            localObject2 = (TextView) paramView.findViewById(2131231726);
            ((TextView) localObject1).setText(2131099883);
            ((TextView) localObject2).setText(this.user.getPostCount());
            paramViewGroup.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_top_item_bg", this.mContext));
            paramViewGroup.setPadding(0, 20, 0, 10);
            return paramView;
        }
        if (this.mData.get(paramInt).toString().equals("reg_time")) {
            paramView = LayoutInflater.from(this.mContext).inflate(2130903428, null);
            paramViewGroup = paramView.findViewById(2131231721);
            localObject2 = (TextView) paramView.findViewById(2131231727);
            localObject1 = (TextView) paramView.findViewById(2131231726);
            ((TextView) localObject2).setText(2131099884);
            localObject2 = new SimpleDateFormat("yyyy MMM dd");
            if (this.user.getRegTime() != null) {
                ((TextView) localObject1).setText(((SimpleDateFormat) localObject2).format(this.user.getRegTime()));
            }
            paramViewGroup.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_mid_item_bg", this.mContext));
            return paramView;
        }
        if (this.mData.get(paramInt).toString().equals("show_more")) {
            paramView = LayoutInflater.from(this.mContext).inflate(2130903326, null);
            paramViewGroup = paramView.findViewById(2131231541);
            paramView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    UserInfoAdapter.this.mData.remove(paramInt);
                    paramView.setVisibility(8);
                    UserInfoAdapter.this.notifyDataSetChanged();
                }
            });
            paramViewGroup.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_bottom_item_bg", this.mContext));
            return paramView;
        }
        Object localObject1 = LayoutInflater.from(this.mContext).inflate(2130903428, null);
        Object localObject2 = ((View) localObject1).findViewById(2131231721);
        TextView localTextView1 = (TextView) ((View) localObject1).findViewById(2131231727);
        TextView localTextView2 = (TextView) ((View) localObject1).findViewById(2131231726);
        HashMap localHashMap = (HashMap) this.mData.get(paramInt);
        try {
            paramView = new String((byte[]) localHashMap.get("name"), "UTF-8");
        } catch (Exception paramView) {
            try {
                for (; ; ) {
                    paramViewGroup = new String((byte[]) localHashMap.get("value"), "UTF-8");
                    localTextView1.setText(paramView + ":");
                    localTextView2.setText(paramViewGroup);
                    if ((paramView == null) || (paramView.length() == 0)) {
                        localTextView1.setVisibility(8);
                    }
                    if (this.mData.size() - 1 != paramInt) {
                        break;
                    }
                    ((View) localObject2).setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_bottom_item_bg", this.mContext));
                    ((View) localObject2).setPadding(0, 10, 0, 20);
                    return (View) localObject1;
                    paramView = paramView;
                    paramView = new String((byte[]) localHashMap.get("name"));
                }
            } catch (Exception paramViewGroup) {
                for (; ; ) {
                    paramViewGroup = new String((byte[]) localHashMap.get("value"));
                }
                ((View) localObject2).setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_mid_item_bg", this.mContext));
            }
        }
        return (View) localObject1;
    }

    public void initProfile(RelativeLayout paramRelativeLayout) {
        Object localObject1 = (ImageView) paramRelativeLayout.findViewById(2131231536);
        if ((this.supportOnlineStatus) && (!this.forumStatus.isBB())) {
            ((ImageView) localObject1).setVisibility(0);
            if (this.user.isOnline()) {
                ((ImageView) localObject1).setImageResource(2130839197);
            }
        } else {
            Object localObject2 = Typeface.createFromAsset(this.mContext.getAssets(), "font/Roboto_Condensed.ttf");
            localObject1 = (TextView) paramRelativeLayout.findViewById(2131231024);
            ((TextView) localObject1).setTypeface((Typeface) localObject2);
            localObject2 = (LinearLayout) paramRelativeLayout.findViewById(2131231534);
            if ((this.forumStatus != null) && (!this.mUsername.equalsIgnoreCase(this.forumStatus.getCurrentUserName())) && (this.forumStatus.tapatalkForum != null) && (this.forumStatus.tapatalkForum.isPMEnable())) {
                ((LinearLayout) localObject2).setVisibility(0);
                ((LinearLayout) localObject2).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        if (UserInfoAdapter.this.forumStatus.tapatalkForum.isSupportConve()) {
                            paramAnonymousView = new Intent(UserInfoAdapter.this.mContext, CreateOrReplyConversationActivity.class);
                            paramAnonymousView.putExtra("is_newConversation", true);
                            paramAnonymousView.putExtra("conversationName", UserInfoAdapter.this.mUsername);
                            paramAnonymousView.putExtra("forumStatus", UserInfoAdapter.this.forumStatus);
                            UserInfoAdapter.this.mContext.startActivity(paramAnonymousView);
                            return;
                        }
                        paramAnonymousView = new Intent(UserInfoAdapter.this.mContext, CreatePmActivity.class);
                        paramAnonymousView.putExtra("forumStatus", UserInfoAdapter.this.forumStatus);
                        paramAnonymousView.putExtra("pmto", UserInfoAdapter.this.mUsername);
                        UserInfoAdapter.this.mContext.startActivity(paramAnonymousView);
                    }
                });
            }
            localObject2 = (LinearLayout) paramRelativeLayout.findViewById(2131231532);
            if ((this.user.isCanBan()) && (!this.user.isBan()) && (!this.mUsername.equalsIgnoreCase(this.forumStatus.getUser()))) {
                ((LinearLayout) localObject2).setVisibility(0);
                ((LinearLayout) localObject2).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        UserInfoAdapter.this.mUploadDialog.getUploadSelectorDialog().show();
                    }
                });
            }
            localObject2 = (GifImageView) paramRelativeLayout.findViewById(2131231264);
            AvatarTool.showAvatar(this.mContext, this.forumStatus, (GifImageView) localObject2, this.user.getIconUrl(), 0);
            if ((!this.forumStatus.isSupportUploadAvatar()) || (!this.mUsername.equalsIgnoreCase(this.forumStatus.getCurrentUserName()))) {
                break label391;
            }
            ((RelativeLayout) paramRelativeLayout.findViewById(2131231022)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    UserInfoAdapter.this.mUploadDialog.getUploadSelectorDialog().show();
                }
            });
            label299:
            this.user.setName(this.mUsername);
            if (this.user.getDisplay_name() == null) {
                break label409;
            }
            ((TextView) localObject1).setText(this.user.getDisplay_name());
        }
        for (; ; ) {
            if ((this.user.getCurrentActivity() != null) && (this.user.getCurrentActivity().length() > 0)) {
                ((TextView) paramRelativeLayout.findViewById(2131231537)).setText(this.user.getCurrentActivity());
            }
            return;
            ((ImageView) localObject1).setVisibility(8);
            ((ImageView) localObject1).setImageResource(17301609);
            break;
            label391:
            ((ImageView) paramRelativeLayout.findViewById(2131231531)).setVisibility(8);
            break label299;
            label409:
            ((TextView) localObject1).setText(this.mUsername);
        }
    }

    public void parseCallBack(EngineResponse paramEngineResponse) {
    }

    public void refresh() {
        this.mData.clear();
        ArrayList localArrayList = new ArrayList();
        try {
            byte[] arrayOfByte1 = this.mUsername.getBytes("UTF-8");
            localArrayList.add(arrayOfByte1);
            this.engine.call("get_user_info", localArrayList);
            this.progress.show();
            notifyDataSetChanged();
            return;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            for (; ; ) {
                byte[] arrayOfByte2 = this.mUsername.getBytes();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/UserInfoAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */