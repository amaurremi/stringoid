package com.quoord.tapatalkpro.adapter.forum;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.CallBackResult;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.ics.tapatalkid.SignInWithOtherUtil;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.net.CallBackInterfaceHasHandleListener;
import com.quoord.tapatalkpro.net.HandleCallBackResultListener;
import com.quoord.tapatalkpro.util.Prefs;
import org.json.JSONArray;
import org.json.JSONObject;

public class TapatalkIdCallBack
        implements CallBackInterfaceHasHandleListener {
    private HandleCallBackResultListener handleListener;
    private Context mContext;
    private TapatalkIdHandleBackResult resultHandle;

    public TapatalkIdCallBack(Context paramContext) {
        this.mContext = paramContext;
    }

    public void callBack(EngineResponse paramEngineResponse) {
        this.resultHandle = new TapatalkIdHandleBackResult();
        this.resultHandle.handleBackResult(paramEngineResponse, this.mContext);
        if (this.handleListener != null) {
            this.handleListener.handleOver(this.resultHandle);
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

    public class TapatalkIdHandleBackResult
            extends CallBackResult {
        private SharedPreferences prefs;

        public TapatalkIdHandleBackResult() {
        }

        private void checkPrefs(Context paramContext) {
            if (this.prefs == null) {
                this.prefs = Prefs.get(paramContext);
            }
        }

        private String getLocalMethodName(String paramString) {
            if (paramString.equals("normal")) {
                return SignInWithOtherUtil.tapatalkIdString;
            }
            if (paramString.equals("twitter")) {
                return SignInWithOtherUtil.twitterString;
            }
            if (paramString.equals("facebook")) {
                return SignInWithOtherUtil.facebookString;
            }
            if (paramString.equals("google")) {
                return SignInWithOtherUtil.googleString;
            }
            return SignInWithOtherUtil.unknow;
        }

        private int getResultCode(JSONObject paramJSONObject) {
            boolean bool1 = paramJSONObject.optBoolean("request_email");
            boolean bool2 = paramJSONObject.optBoolean("request_tapatalk_id_password");
            if ((bool1) && (!bool2)) {
                return 101;
            }
            if ((!bool1) && (bool2)) {
                return 102;
            }
            if ((bool1) && (bool2)) {
                return 103;
            }
            paramJSONObject = paramJSONObject.optString("status");
            if ("1".equals(paramJSONObject)) {
                return 105;
            }
            if ("0".equals(paramJSONObject)) {
                return 104;
            }
            return -100;
        }

        private void writeHandle(String paramString, Context paramContext) {
            checkPrefs(paramContext);
            paramContext = this.prefs.edit();
            paramContext.putString("handle", paramString);
            paramContext.commit();
        }

        public void handleBackResult(EngineResponse paramEngineResponse, Context paramContext) {
            boolean bool = paramEngineResponse.isSuccess();
            setConnectionResult(bool);
            if (bool) {
                JSONObject localJSONObject = (JSONObject) paramEngineResponse.getResponse();
                if (localJSONObject != null) {
                    setCallResultEntity(localJSONObject);
                    setInvokeResult(localJSONObject.optBoolean("result"));
                    if (localJSONObject.has("result_text")) {
                        setResultText(localJSONObject.optString("result_text"));
                    }
                    if (getInvokeResult()) {
                        saveResponseValue(paramEngineResponse, paramContext);
                        setResultCode(getResultCode(localJSONObject));
                        paramEngineResponse = getLocalMethodName(localJSONObject.optString("login_type"));
                        writeHandle(paramEngineResponse, paramContext);
                        setMethodName(paramEngineResponse);
                    }
                }
            }
            for (; ; ) {
                setHandleResult(true);
                return;
                setResultText(TapatalkIdCallBack.this.mContext.getResources().getString(2131100069));
            }
        }

        public void handleBackResult(EngineResponse paramEngineResponse, ForumActivityStatus paramForumActivityStatus) {
        }

        public void handleBackResult(String paramString, Context paramContext) {
        }

        public void handleBackResult(String paramString, ForumActivityStatus paramForumActivityStatus) {
        }

        public void handleBackResult(JSONArray paramJSONArray, Context paramContext) {
        }

        public void handleBackResult(JSONArray paramJSONArray, ForumActivityStatus paramForumActivityStatus) {
        }

        public void handleBackResult(JSONObject paramJSONObject, Context paramContext) {
        }

        public void handleBackResult(JSONObject paramJSONObject, ForumActivityStatus paramForumActivityStatus) {
        }

        public void saveResponseValue(EngineResponse paramEngineResponse, Context paramContext) {
            JSONObject localJSONObject = null;
            if ((paramEngineResponse.getResponse() instanceof JSONObject)) {
                localJSONObject = (JSONObject) paramEngineResponse.getResponse();
            }
            if (localJSONObject != null) {
                TapatalkIdFactory.getTapatalkId(paramContext).saveTapatalkId(localJSONObject);
            }
        }

        public void saveResponseValue(EngineResponse paramEngineResponse, ForumActivityStatus paramForumActivityStatus) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/TapatalkIdCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */