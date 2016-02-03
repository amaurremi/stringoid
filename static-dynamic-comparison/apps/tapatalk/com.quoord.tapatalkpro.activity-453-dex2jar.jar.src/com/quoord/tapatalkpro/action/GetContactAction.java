package com.quoord.tapatalkpro.action;

import android.content.Context;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.util.TapatalkEngine;

import java.util.ArrayList;
import java.util.HashMap;

public class GetContactAction
        implements TryTwiceCallBackInterface {
    private TapatalkEngine engine;
    private GetContactActionBack mCallBack;
    private Context mContext;
    private ForumStatus mForumStatus;
    private boolean mTryTwice = false;

    public GetContactAction(Context paramContext, ForumStatus paramForumStatus) {
        this.mContext = paramContext;
        this.mForumStatus = paramForumStatus;
        this.engine = new TapatalkEngine(this, this.mForumStatus, this.mContext);
    }

    public void callBack(EngineResponse paramEngineResponse) {
        if (paramEngineResponse == null) {
            break label4;
        }
        for (; ; ) {
            label4:
            return;
            if (!paramEngineResponse.getMethod().equals("get_contact")) {
                continue;
            }
            if (!paramEngineResponse.isSuccess()) {
                if ((paramEngineResponse.getErrorMessage() == null) || (this.mCallBack == null)) {
                    break;
                }
                this.mCallBack.getContactActionErrorBack(paramEngineResponse.getErrorMessage());
                return;
            }
            HashMap localHashMap = (HashMap) paramEngineResponse.getResponse();
            if ((localHashMap.containsKey("result")) && (localHashMap.get("result").equals("false"))) {
                if (this.mCallBack == null) {
                    break;
                }
                this.mCallBack.getContactActionErrorBack(paramEngineResponse.getErrorMessage());
                return;
            }
            paramEngineResponse = null;
            Object localObject3 = null;
            String str = null;
            if (localHashMap.containsKey("user_id")) {
                paramEngineResponse = new String((String) localHashMap.get("user_id"));
            }
            Object localObject1 = localObject3;
            if (localHashMap.containsKey("display_name")) {
            }
            try {
                localObject1 = new String((byte[]) localHashMap.get("display_name"), "UTF-8");
                if (localHashMap.containsKey("enc_email")) {
                    str = new String((String) localHashMap.get("enc_email"));
                }
                if (this.mCallBack == null) {
                    continue;
                }
                this.mCallBack.getContactActionBack(paramEngineResponse, (String) localObject1, str);
                return;
            } catch (Exception localException) {
                for (; ; ) {
                    localException.printStackTrace();
                    Object localObject2 = localObject3;
                }
            }
        }
    }

    public void getContact(String paramString, GetContactActionBack paramGetContactActionBack) {
        if ((paramString == null) || (paramString.length() == 0) || (paramGetContactActionBack == null)) {
            return;
        }
        this.mCallBack = paramGetContactActionBack;
        paramGetContactActionBack = new ArrayList();
        paramGetContactActionBack.add(paramString);
        this.engine.call("get_contact", paramGetContactActionBack);
    }

    public boolean getSaxCall() {
        return false;
    }

    public boolean getTryTwice() {
        return this.mTryTwice;
    }

    public boolean isOpCancel() {
        return false;
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTryTwice(boolean paramBoolean) {
        this.mTryTwice = paramBoolean;
    }

    public void tryFailed(String paramString) {
    }

    public void updateSubclassDialog(int paramInt) {
    }

    public static abstract interface GetContactActionBack {
        public abstract void getContactActionBack(String paramString1, String paramString2, String paramString3);

        public abstract void getContactActionErrorBack(String paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/GetContactAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */