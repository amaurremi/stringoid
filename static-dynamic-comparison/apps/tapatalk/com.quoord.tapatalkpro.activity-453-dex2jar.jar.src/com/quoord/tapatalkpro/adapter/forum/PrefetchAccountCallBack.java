package com.quoord.tapatalkpro.adapter.forum;

import android.content.Context;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.CallBackResult;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.SimpleTapatalkForumAccount;
import com.quoord.tapatalkpro.net.CallBackInterfaceHasHandleListener;
import com.quoord.tapatalkpro.net.HandleCallBackResultListener;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class PrefetchAccountCallBack
        implements CallBackInterfaceHasHandleListener {
    private HandleCallBackResultListener handleListener;
    private Context mContext;
    private PrefetchAccountCallBackResult resultHandle;

    public PrefetchAccountCallBack(Context paramContext) {
        this.mContext = paramContext;
    }

    public void callBack(EngineResponse paramEngineResponse) {
        this.resultHandle = new PrefetchAccountCallBackResult();
        try {
            this.resultHandle.handleBackResult(paramEngineResponse, this.mContext);
            if (this.handleListener != null) {
                this.handleListener.handleOver(this.resultHandle);
            }
            return;
        } catch (Exception paramEngineResponse) {
            for (; ; ) {
                this.resultHandle.setHandleError("Handle Error!");
            }
        }
    }

    public boolean getSaxCall() {
        return false;
    }

    public boolean getTryTwice() {
        return false;
    }

    public boolean isOpCancel() {
        return false;
    }

    public void setHandleListener(HandleCallBackResultListener paramHandleCallBackResultListener) {
        this.handleListener = paramHandleCallBackResultListener;
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

    public class PrefetchAccountCallBackResult
            extends CallBackResult {
        public PrefetchAccountCallBackResult() {
        }

        public void handleBackResult(EngineResponse paramEngineResponse, Context paramContext)
                throws Exception {
            setConnectionResult(paramEngineResponse.isSuccess());
            paramContext = (HashMap) paramEngineResponse.getResponse();
            if ((paramContext != null) && (paramContext.size() > 0)) {
                if (paramContext.containsKey("result")) {
                    setInvokeResult(((Boolean) paramContext.get("result")).booleanValue());
                }
                if (getInvokeResult()) {
                    paramEngineResponse = new SimpleTapatalkForumAccount();
                    paramEngineResponse.setIconUrl((String) paramContext.get("avatar"));
                    paramEngineResponse.setTapatalkUserName(new String((byte[]) paramContext.get("login_name")));
                    paramEngineResponse.setTapatalkDisplayName(new String((byte[]) paramContext.get("display_name")));
                    setCallResultEntity(paramEngineResponse);
                }
                while (!paramContext.containsKey("result_text")) {
                    return;
                }
                setResultText((String) paramContext.get("result_text"));
                return;
            }
            setResultText(paramEngineResponse.getErrorMessage());
        }

        public void handleBackResult(EngineResponse paramEngineResponse, ForumActivityStatus paramForumActivityStatus)
                throws Exception {
        }

        public void handleBackResult(String paramString, Context paramContext)
                throws Exception {
        }

        public void handleBackResult(String paramString, ForumActivityStatus paramForumActivityStatus)
                throws Exception {
        }

        public void handleBackResult(JSONArray paramJSONArray, Context paramContext)
                throws Exception {
        }

        public void handleBackResult(JSONArray paramJSONArray, ForumActivityStatus paramForumActivityStatus)
                throws Exception {
        }

        public void handleBackResult(JSONObject paramJSONObject, Context paramContext)
                throws Exception {
        }

        public void handleBackResult(JSONObject paramJSONObject, ForumActivityStatus paramForumActivityStatus)
                throws Exception {
        }

        public void saveResponseValue(EngineResponse paramEngineResponse, Context paramContext)
                throws Exception {
        }

        public void saveResponseValue(EngineResponse paramEngineResponse, ForumActivityStatus paramForumActivityStatus)
                throws Exception {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/PrefetchAccountCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */