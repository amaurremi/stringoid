package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;
import com.google.android.gcm.GCMRegistrar;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.Util;

import java.net.URLEncoder;
import java.util.TimeZone;

import org.json.JSONException;
import org.json.JSONObject;

public class SignIn
        implements CallBackInterface {
    private TapatalkJsonEngine engin = null;
    private String isVip = null;
    private boolean login = false;
    private Activity mActivity = null;
    private String password = null;
    private SharedPreferences prefs = null;
    private ProgressDialog progress = null;
    private String username = null;

    public SignIn(Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean) {
        this.mActivity = paramActivity;
        this.username = paramString1;
        this.password = paramString2;
        this.prefs = Prefs.get(this.mActivity);
        this.engin = new TapatalkJsonEngine(this.mActivity, this);
        if (paramBoolean) {
            this.progress = new ProgressDialog(this.mActivity);
        }
        signin();
    }

    private void signin() {
        if (this.password.length() != 32) {
            this.password = Util.getMD5(this.password);
        }
        String str2 = TapatalkJsonEngine.SIGNIN + "?email=" + URLEncoder.encode(this.username) + "&password=" + URLEncoder.encode(this.password) + "&timezone=" + TimeZone.getDefault().getRawOffset() / 1000;
        String str3 = GCMRegistrar.getRegistrationId(this.mActivity);
        String str1 = str2;
        if (!str3.equals("")) {
            str1 = new StringBuilder(String.valueOf(str2)).append("&push_token=").append(str3).toString() + "&device_id=" + Util.getMD5(Util.getMacAddress(this.mActivity)) + "&device_type=" + Util.getDeviceName();
        }
        this.engin.call(str1);
        this.progress.show();
    }

    public void ReLogin(String paramString) {
        if ((paramString != null) && (paramString.equals("Token expired"))) {
            paramString = this.prefs.getString("username", "");
            String str = this.prefs.getString("password", "");
            if ((paramString != null) && (str != null)) {
                signin();
            }
        }
    }

    public void callBack(EngineResponse paramEngineResponse) {
        String str = paramEngineResponse.getMethod();
        if ((!"".equals(str)) && (!paramEngineResponse.getResponse().equals(""))) {
            paramEngineResponse = (JSONObject) paramEngineResponse.getResponse();
            if (!str.contains("au_sign_in")) {
            }
        }
        try {
            this.login = paramEngineResponse.getBoolean("result");
            if (this.login) {
                long l = System.currentTimeMillis();
                int i = paramEngineResponse.getInt("au_id");
                str = paramEngineResponse.getString("token");
                this.isVip = paramEngineResponse.getString("vip");
                paramEngineResponse = this.prefs.edit();
                paramEngineResponse.putInt("tapatalk_auid", i);
                paramEngineResponse.putBoolean("login", this.login);
                paramEngineResponse.putString("username", this.username);
                paramEngineResponse.putString("token", str);
                paramEngineResponse.putString("password", this.password);
                paramEngineResponse.putString("vip", this.isVip);
                paramEngineResponse.putLong("times1", Long.valueOf(l).longValue());
                paramEngineResponse.commit();
            }
            for (; ; ) {
                this.progress.cancel();
                paramEngineResponse = this.mActivity.getIntent();
                this.mActivity.setResult(37, paramEngineResponse);
                return;
                paramEngineResponse = (String) paramEngineResponse.get("result_text");
                ReLogin(paramEngineResponse);
                Toast.makeText(this.mActivity, paramEngineResponse, 1).show();
            }
        } catch (JSONException paramEngineResponse) {
            for (; ; ) {
                paramEngineResponse.printStackTrace();
            }
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/SignIn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */