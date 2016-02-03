package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.quoord.DialogUtil.UploadDialog;
import com.quoord.tapatalkpro.activity.forum.ProfilesOuterFragment;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.adapter.forum.ProfilesAdapter;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.User;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserInfoAction
        implements TryTwiceCallBackInterface {
    public static final int UPDATA_USERINFO = 5;
    protected TapatalkEngine engine = null;
    private ForumStatus forumStatus = null;
    boolean isAcceptPm = true;
    private boolean isShowUpdate = false;
    private ProfilesAdapter mAdapter;
    private Activity mContext = null;
    public ArrayList mData = new ArrayList();
    public Handler mHandler = null;
    public UploadDialog mUploadDialog;
    private String mUsername = null;
    public ProgressDialog progress = null;
    public boolean supportOnlineStatus = false;
    public User user = new User();
    private String userId;

    public UserInfoAction(Activity paramActivity, String paramString1, String paramString2, String paramString3, ForumStatus paramForumStatus, ProfilesAdapter paramProfilesAdapter) {
        this.mContext = paramActivity;
        this.mUsername = paramString2;
        this.userId = paramString3;
        this.forumStatus = paramForumStatus;
        this.mAdapter = paramProfilesAdapter;
        if ((this.forumStatus.isRegister()) && (this.mUsername != null) && (!this.mUsername.equals("")) && (this.mUsername.equalsIgnoreCase(this.forumStatus.getUser()))) {
            this.isShowUpdate = true;
        }
        this.progress = new ProgressDialog(this.mContext);
        this.progress.setMessage(this.mContext.getResources().getString(2131099873));
        this.engine = new TapatalkEngine(this, this.forumStatus, this.mContext);
        get_user_info(paramString2, this.userId);
        GoogleAnalyticsTools.trackPageView(this.mContext, "profile", this.forumStatus.getForumId(), this.forumStatus.getUrl());
        this.mUploadDialog = new UploadDialog(paramActivity, this.forumStatus, this.engine);
    }

    private void get_user_info(String paramString1, String paramString2) {
        ArrayList localArrayList = new ArrayList();
        try {
            byte[] arrayOfByte = paramString1.getBytes("UTF-8");
            paramString1 = arrayOfByte;
        } catch (Exception localException) {
            for (; ; ) {
                paramString1 = paramString1.getBytes();
            }
        }
        localArrayList.add(paramString1);
        if ((this.forumStatus.isSupportUserId()) && (paramString2 != null) && (!paramString2.equals(""))) {
            localArrayList.add(paramString2);
        }
        this.engine.call("get_user_info", localArrayList);
    }

    public void callBack(EngineResponse paramEngineResponse) {
        Object localObject1 = paramEngineResponse.getMethod();
        if (((String) localObject1).equals("get_user_info")) {
            localObject1 = null;
        }
        try {
            paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
            Object localObject3;
            try {
                localObject3 = (byte[]) paramEngineResponse.get("username");
                localObject1 = localObject3;
                if (localObject3 == null) {
                    localObject1 = (byte[]) paramEngineResponse.get("user_name");
                }
                if (localObject1 != null) {
                    break label700;
                }
            } catch (Exception localUnsupportedEncodingException2) {
                for (; ; ) {
                    try {
                        this.user.setDisplayText(new String((byte[]) paramEngineResponse.get("display_text"), "UTF-8"));
                        if (paramEngineResponse.containsKey("can_ban")) {
                            this.user.setCanBan(((Boolean) paramEngineResponse.get("can_ban")).booleanValue());
                        }
                        if (paramEngineResponse.containsKey("is_ban")) {
                            this.user.setBan(((Boolean) paramEngineResponse.get("is_ban")).booleanValue());
                            if (paramEngineResponse.containsKey("post_count")) {
                                this.user.setPostCount(((Integer) paramEngineResponse.get("post_count")).intValue());
                            }
                            this.user.setRegTime((Date) paramEngineResponse.get("reg_time"));
                            this.user.setIconUrl((String) paramEngineResponse.get("icon_url"));
                            if (!paramEngineResponse.containsKey("display_name")) {
                            }
                        }
                    } catch (UnsupportedEncodingException localUnsupportedEncodingException2) {
                        try {
                            this.user.setDisplay_name(new String((byte[]) paramEngineResponse.get("display_name"), "UTF-8"));
                            this.mData.add("userinfo_section");
                            this.mData.add("post_count");
                            if ((paramEngineResponse.containsKey("reg_timestamp")) && ((String) paramEngineResponse.get("reg_timestamp") != null) && (!paramEngineResponse.get("reg_timestamp").equals("")) && (Integer.parseInt((String) paramEngineResponse.get("reg_timestamp")) > 0)) {
                                this.mData.add("reg_time");
                            }
                            if (paramEngineResponse.containsKey("is_online")) {
                                this.supportOnlineStatus = true;
                                this.user.setOnline(((Boolean) paramEngineResponse.get("is_online")).booleanValue());
                            }
                            if (!paramEngineResponse.containsKey("current_activity")) {
                            }
                        } catch (UnsupportedEncodingException localUnsupportedEncodingException2) {
                            try {
                                this.user.setCurrentActivity(new String((byte[]) paramEngineResponse.get("current_activity"), "UTF-8"));
                                if (paramEngineResponse.containsKey("custom_fields_list")) {
                                    paramEngineResponse = (Object[]) paramEngineResponse.get("custom_fields_list");
                                    i = 0;
                                    if (i < paramEngineResponse.length) {
                                        continue;
                                    }
                                    if ((this.user.getDisplayText() != null) && (this.user.getDisplayText().length() > 0)) {
                                        paramEngineResponse = new HashMap();
                                        paramEngineResponse.put("name", this.mContext.getString(2131100246).getBytes());
                                        paramEngineResponse.put("value", this.user.getDisplayText().getBytes());
                                        this.mData.add(paramEngineResponse);
                                    }
                                }
                                if ((this.mContext instanceof SlidingMenuActivity)) {
                                    if (((SlidingMenuActivity) this.mContext).getOuterFragment() == null) {
                                        break label865;
                                    }
                                    ((ProfilesOuterFragment) ((SlidingMenuActivity) this.mContext).getOuterFragment()).user = this.user;
                                }
                                if (this.mAdapter.footlay != null) {
                                    this.mAdapter.footlay.setVisibility(8);
                                }
                                this.mContext.invalidateOptionsMenu();
                                this.mAdapter.setmDatas(this.mData);
                                this.mAdapter.notifyDataSetChanged();
                                this.progress.dismiss();
                                this.mContext.dismissDialog(0);
                                return;
                                new String((byte[]) localObject1);
                                continue;
                                localException1 = localException1;
                                localException1.printStackTrace();
                                continue;
                                localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
                                localUnsupportedEncodingException1.printStackTrace();
                                continue;
                                this.user.setBan(false);
                                continue;
                                localUnsupportedEncodingException2 = localUnsupportedEncodingException2;
                                localUnsupportedEncodingException2.printStackTrace();
                            } catch (UnsupportedEncodingException localUnsupportedEncodingException3) {
                                this.user.setCurrentActivity(new String((byte[]) paramEngineResponse.get("current_activity")));
                                continue;
                                localObject2 = (HashMap) paramEngineResponse[i];
                                localObject3 = (byte[]) ((HashMap) localObject2).get("name");
                                localObject2 = (byte[]) ((HashMap) localObject2).get("value");
                                if ((localObject2 != null) && (localObject2.length > 0)) {
                                    this.mData.add(paramEngineResponse[i]);
                                }
                                i += 1;
                                continue;
                            }
                        }
                    }
                    this.user.setPostCount(0);
                    this.user.setRegTime(new Date());
                    this.user.setIconUrl(null);
                    continue;
                    ((ProfilesOuterFragment) ((SlidingMenuActivity) this.mContext).currentFragment).user = this.user;
                }
            }
            if (paramEngineResponse.containsKey("icon_url")) {
                this.user.setIconUrl((String) paramEngineResponse.get("icon_url"));
            }
            this.engine.getLoginStatus();
            if (paramEngineResponse.containsKey("user_id")) {
                this.user.setId((String) paramEngineResponse.get("user_id"));
            }
            if (paramEngineResponse != null) {
                if (paramEngineResponse.containsKey("accept_pm")) {
                    this.isAcceptPm = ((Boolean) paramEngineResponse.get("accept_pm")).booleanValue();
                }
                break label699;
                if (!paramEngineResponse.containsKey("display_text")) {
                }
            }
            label699:
            label700:
            label865:
            do {
                int i;
                while (!((String) localObject2).endsWith("upload_avatar_x")) {
                }
                localObject2 = null;
                try {
                    localObject3 = (HashMap) paramEngineResponse.getResponse();
                    localObject2 = localObject3;
                    this.mData.clear();
                    localObject2 = localObject3;
                    this.mData = new ArrayList();
                    localObject2 = localObject3;
                    this.mUploadDialog.closeDialog();
                    localObject2 = localObject3;
                    this.progress.show();
                    localObject2 = localObject3;
                } catch (Exception localException2) {
                    for (; ; ) {
                    }
                }
                if ((localObject2 != null) && (((HashMap) localObject2).containsKey("result")) && (((Boolean) ((HashMap) localObject2).get("result")).booleanValue())) {
                    if ((this.user.getLocalIconUri() != null) && (this.user.getLocalIconUri().length() > 0)) {
                    }
                    try {
                        Util.delFile(this.user.getLocalIconUri());
                        get_user_info(this.mUsername, this.userId);
                        this.mContext.showDialog(0);
                        return;
                    } catch (Exception paramEngineResponse) {
                        for (; ; ) {
                            paramEngineResponse.printStackTrace();
                        }
                    }
                }
                this.engine.getLoginStatus();
                get_user_info(this.mUsername, this.userId);
                localObject3 = new HashMap();
                ((Map) localObject3).put("methodName", paramEngineResponse.getMethod());
            } while ((localObject2 == null) || (((HashMap) localObject2).get("result_text") == null));
            ((Map) localObject3).put("errormessage", new String((byte[]) ((HashMap) localObject2).get("result_text")));
            Toast.makeText(this.mContext, new String((byte[]) ((HashMap) localObject2).get("result_text")).toString(), 1).show();
            return;
        } catch (Exception paramEngineResponse) {
            for (; ; ) {
                Object localObject2;
                paramEngineResponse = (EngineResponse) localObject2;
            }
        }
    }

    public boolean getSaxCall() {
        return false;
    }

    public boolean getTryTwice() {
        return false;
    }

    public User getUser() {
        return this.user;
    }

    public boolean isOpCancel() {
        return false;
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTryTwice(boolean paramBoolean) {
    }

    public void tryFailed(String paramString) {
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/UserInfoAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */