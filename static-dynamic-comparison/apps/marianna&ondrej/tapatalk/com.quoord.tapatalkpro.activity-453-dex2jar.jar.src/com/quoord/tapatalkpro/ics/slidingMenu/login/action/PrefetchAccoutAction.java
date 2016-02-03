package com.quoord.tapatalkpro.ics.slidingMenu.login.action;

import android.app.Activity;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.ics.slidingMenu.login.CustomRegisterField;
import com.quoord.tapatalkpro.ics.slidingMenu.login.PrefetchAccountInfo;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.net.HashUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class PrefetchAccoutAction
        implements TryTwiceCallBackInterface {
    private ActionCallBack actionCallBack;
    private Activity context;
    private TapatalkEngine engine;
    private boolean tryTwice = true;

    public PrefetchAccoutAction(ForumStatus paramForumStatus, Activity paramActivity) {
        this.context = paramActivity;
        this.engine = new TapatalkEngine(this, paramForumStatus, this.context);
    }

    public void callBack(EngineResponse paramEngineResponse) {
        Object[] arrayOfObject = null;
        if ((paramEngineResponse.getResponse() != null) && (!paramEngineResponse.getResponse().equals(""))) {
            HashMap localHashMap = (HashMap) paramEngineResponse.getResponse();
            Object localObject = arrayOfObject;
            if (paramEngineResponse.isSuccess()) {
                localObject = arrayOfObject;
                if (localHashMap != null) {
                    localObject = arrayOfObject;
                    if (localHashMap.size() > 0) {
                        paramEngineResponse = new PrefetchAccountInfo();
                        paramEngineResponse.hasUser = ((Boolean) localHashMap.get("result")).booleanValue();
                    }
                }
            }
            for (; ; ) {
                try {
                    if (paramEngineResponse.hasUser) {
                        if (localHashMap.containsKey("result_text")) {
                            paramEngineResponse.resultTxt = new String((byte[]) localHashMap.get("result_text"));
                        }
                        if (localHashMap.containsKey("user_id")) {
                            paramEngineResponse.uid = ((String) localHashMap.get("user_id"));
                        }
                        if (localHashMap.containsKey("login_name")) {
                            paramEngineResponse.userName = new String((byte[]) localHashMap.get("login_name"));
                        }
                        if (localHashMap.containsKey("display_name")) {
                            paramEngineResponse.displayName = new String((byte[]) localHashMap.get("display_name"));
                        }
                        if (localHashMap.containsKey("avatar")) {
                            paramEngineResponse.avatorUrl = ((String) localHashMap.get("avatar"));
                        }
                    }
                    localObject = paramEngineResponse;
                    if (localHashMap.containsKey("custom_register_fields")) {
                        arrayOfObject = (Object[]) localHashMap.get("custom_register_fields");
                        localObject = paramEngineResponse;
                        if (arrayOfObject != null) {
                            localObject = paramEngineResponse;
                            if (arrayOfObject.length > 0) {
                                paramEngineResponse.customFields = new ArrayList();
                                i = 0;
                                int j = arrayOfObject.length;
                                if (i < j) {
                                    continue;
                                }
                                localObject = paramEngineResponse;
                            }
                        }
                    }
                } catch (Exception localException) {
                    int i;
                    EngineResponse localEngineResponse = paramEngineResponse;
                    continue;
                }
                this.actionCallBack.actionCallBack((PrefetchAccountInfo) localObject);
                return;
                localObject = new CustomRegisterField();
                localHashMap = (HashMap) arrayOfObject[i];
                if (localHashMap.get("name") != null) {
                    ((CustomRegisterField) localObject).name = new String((byte[]) localHashMap.get("name"));
                }
                if (localHashMap.get("description") != null) {
                    ((CustomRegisterField) localObject).description = new String((byte[]) localHashMap.get("description"));
                }
                ((CustomRegisterField) localObject).key = ((String) localHashMap.get("key"));
                ((CustomRegisterField) localObject).type = ((String) localHashMap.get("type"));
                if ((localHashMap.containsKey("options")) && (localHashMap.get("options") != null)) {
                    ((CustomRegisterField) localObject).options = new String((byte[]) localHashMap.get("options"));
                }
                if (localHashMap.containsKey("format")) {
                    ((CustomRegisterField) localObject).format = ((String) localHashMap.get("format"));
                }
                if (localHashMap.containsKey("default")) {
                    ((CustomRegisterField) localObject).defaultValue = HashUtil.getString(localHashMap.get("default"));
                }
                paramEngineResponse.customFields.add(localObject);
                i += 1;
            }
        }
        this.actionCallBack.actionCallBack(null);
    }

    public boolean getSaxCall() {
        return false;
    }

    public boolean getTryTwice() {
        return this.tryTwice;
    }

    public boolean isOpCancel() {
        return false;
    }

    public void prefetch(String paramString, ActionCallBack paramActionCallBack) {
        this.actionCallBack = paramActionCallBack;
        paramActionCallBack = new ArrayList();
        if (Util.checkString(paramString)) {
            paramActionCallBack.add(paramString.getBytes());
            this.engine.call("prefetch_account", paramActionCallBack);
        }
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

    public static abstract interface ActionCallBack {
        public abstract void actionCallBack(PrefetchAccountInfo paramPrefetchAccountInfo);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/login/action/PrefetchAccoutAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */