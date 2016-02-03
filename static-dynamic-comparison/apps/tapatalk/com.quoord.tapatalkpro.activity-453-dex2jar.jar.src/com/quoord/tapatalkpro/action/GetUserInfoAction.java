package com.quoord.tapatalkpro.action;

import android.content.Context;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.User;
import com.quoord.tapatalkpro.util.TapatalkEngine;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class GetUserInfoAction
        implements TryTwiceCallBackInterface {
    private Context context;
    private TapatalkEngine engine;
    private ForumStatus forumStauts;
    private boolean tryTwice = true;
    private User user;
    private UserInfoBack userInfoBack;

    public GetUserInfoAction(Context paramContext, ForumStatus paramForumStatus) {
        this.context = paramContext;
        this.forumStauts = paramForumStatus;
        this.engine = new TapatalkEngine(this, this.forumStauts, this.context);
    }

    public void callBack(EngineResponse paramEngineResponse) {
        boolean bool = paramEngineResponse.isSuccess();
        Object localObject = paramEngineResponse.getMethod();
        if ((bool) && (((String) localObject).equals("get_user_info"))) {
            paramEngineResponse = (HashMap) paramEngineResponse.getResponse();
        }
        try {
            if ((byte[]) paramEngineResponse.get("username") == null) {
                localObject = (byte[]) paramEngineResponse.get("user_name");
            }
            this.user.setIconUrl((String) paramEngineResponse.get("icon_url"));
            if (paramEngineResponse.containsKey("user_id")) {
                this.user.setId((String) paramEngineResponse.get("user_id"));
            }
            if (paramEngineResponse != null) {
                if (!paramEngineResponse.containsKey("display_text")) {
                }
            }
        } catch (Exception localUnsupportedEncodingException2) {
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
                    if (paramEngineResponse.containsKey("is_online")) {
                        this.user.setOnline(((Boolean) paramEngineResponse.get("is_online")).booleanValue());
                    }
                    if (!paramEngineResponse.containsKey("current_activity")) {
                    }
                } catch (UnsupportedEncodingException localUnsupportedEncodingException2) {
                    try {
                        for (; ; ) {
                            this.user.setCurrentActivity(new String((byte[]) paramEngineResponse.get("current_activity"), "UTF-8"));
                            if (this.userInfoBack != null) {
                                this.userInfoBack.userInfoBack(this.user);
                            }
                            return;
                            localException = localException;
                            localException.printStackTrace();
                            continue;
                            localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
                            localUnsupportedEncodingException1.printStackTrace();
                            continue;
                            this.user.setBan(false);
                        }
                        localUnsupportedEncodingException2 = localUnsupportedEncodingException2;
                        localUnsupportedEncodingException2.printStackTrace();
                    } catch (UnsupportedEncodingException localUnsupportedEncodingException3) {
                        for (; ; ) {
                            this.user.setCurrentActivity(new String((byte[]) paramEngineResponse.get("current_activity")));
                        }
                    }
                }
            }
        }
    }

    public boolean getSaxCall() {
        return false;
    }

    public boolean getTryTwice() {
        return this.tryTwice;
    }

    public void getUserInfo(String paramString1, String paramString2, UserInfoBack paramUserInfoBack) {
        this.userInfoBack = paramUserInfoBack;
        this.user = new User();
        ArrayList localArrayList = new ArrayList();
        try {
            paramUserInfoBack = paramString1.getBytes("UTF-8");
            paramString1 = paramUserInfoBack;
        } catch (Exception paramUserInfoBack) {
            for (; ; ) {
                paramString1 = paramString1.getBytes();
            }
        }
        localArrayList.add(paramString1);
        if ((this.forumStauts.isSupportUserId()) && (paramString2 != null) && (!paramString2.equals(""))) {
            localArrayList.add(paramString2);
        }
        this.engine.call("get_user_info", localArrayList);
    }

    public boolean isOpCancel() {
        return false;
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTryTwice(boolean paramBoolean) {
        this.tryTwice = paramBoolean;
    }

    public void tryFailed(String paramString) {
    }

    public void updateSubclassDialog(int paramInt) {
    }

    public static abstract interface UserInfoBack {
        public abstract void userInfoBack(User paramUser);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/GetUserInfoAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */