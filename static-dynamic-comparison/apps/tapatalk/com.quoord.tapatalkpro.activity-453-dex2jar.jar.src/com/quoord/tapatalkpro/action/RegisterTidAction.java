package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.alarm.notification.RegisterTapatalkIdNotification;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import org.json.JSONException;
import org.json.JSONObject;

public class RegisterTidAction
        implements CallBackInterface {
    private static int pushCount = 0;
    private long currentTime;
    private TapatalkJsonEngine engine;
    private Activity mActivity;
    private SharedPreferences prefs;

    public RegisterTidAction(Activity paramActivity) {
        this.mActivity = paramActivity;
        this.prefs = Prefs.get(this.mActivity);
        this.engine = new TapatalkJsonEngine(paramActivity, this);
        this.engine.call(TapatalkJsonEngine.GET_FUNCTION_CONFIG + "?");
        paramActivity = this.prefs.edit();
        if (this.prefs.getLong("createTime", 0L) == 0L) {
            paramActivity.putLong("createTime", System.currentTimeMillis());
        }
        if (TapatalkIdFactory.getTapatalkId(this.mActivity).isTapatalkIdLogin()) {
            paramActivity.putBoolean("registerTID_isloginedTID", TapatalkIdFactory.getTapatalkId(this.mActivity).isTapatalkIdLogin());
        }
        paramActivity.commit();
    }

    private void createRegisterTapatalkIdNotification() {
        if (TapatalkIdFactory.getTapatalkId(this.mActivity).getAuid() == -1) {
            new Handler().post(new Runnable() {
                public void run() {
                    RegisterTidAction.pushCount += 1;
                    Object localObject = RegisterTidAction.this.prefs.edit();
                    ((SharedPreferences.Editor) localObject).putInt("pushCount", RegisterTidAction.pushCount);
                    ((SharedPreferences.Editor) localObject).commit();
                    localObject = new Intent();
                    ((Intent) localObject).putExtra("msg", RegisterTidAction.this.mActivity.getResources().getString(2131100622));
                    ((Intent) localObject).putExtra("title", RegisterTidAction.this.mActivity.getResources().getString(2131100621));
                    RegisterTapatalkIdNotification.getTapatalkIdNotification(RegisterTidAction.this.mActivity, (Intent) localObject);
                }
            });
        }
    }

    public static void registerTapatalkIdLog(Activity paramActivity, String paramString) {
        TapatalkJsonEngine.callLogin(paramActivity, TapatalkJsonEngine.REGISTER_TAPATALK_ID_LOG + paramString + "&" + TapatalkApp.APP_KEY);
    }

    public void callBack(EngineResponse paramEngineResponse) {
        int i = -1;
        String str = paramEngineResponse.getMethod();
        if ((str != null) && (str.contains("get_function_config"))) {
            paramEngineResponse = (JSONObject) paramEngineResponse.getResponse();
            if ((paramEngineResponse == null) || (paramEngineResponse.length() <= 0)) {
            }
        }
        try {
            int j = ((Integer) ((JSONObject) paramEngineResponse.get("list")).get("tid_reg_push")).intValue();
            i = j;
        } catch (JSONException paramEngineResponse) {
            for (; ; ) {
                boolean bool;
                paramEngineResponse.printStackTrace();
            }
        }
        this.currentTime = System.currentTimeMillis();
        bool = this.prefs.getBoolean("registerTID_isloginedTID", false);
        if ((this.currentTime - this.prefs.getLong("createTime", 0L) > 259200000L) && (i == 1) && (this.prefs.getInt("pushCount", 0) == 0) && (!bool)) {
            createRegisterTapatalkIdNotification();
        }
    }

    public boolean isOpCancel() {
        return false;
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void updateSubclassDialog(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/RegisterTidAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */