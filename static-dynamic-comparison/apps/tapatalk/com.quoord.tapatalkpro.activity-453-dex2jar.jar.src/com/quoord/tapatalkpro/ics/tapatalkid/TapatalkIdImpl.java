package com.quoord.tapatalkpro.ics.tapatalkid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.Prefs;

import java.util.ArrayList;

import org.json.JSONObject;

final class TapatalkIdImpl
        implements TapatalkId {
    private String defaultStringValue = "";
    private Context mContext;
    private SharedPreferences prefs;

    private void checkPrefs() {
        if (this.prefs == null) {
            this.prefs = Prefs.get(this.mContext);
        }
    }

    private void clearTapatalkId() {
        SharedPreferences.Editor localEditor = this.prefs.edit();
        localEditor.remove("username");
        localEditor.remove("email");
        localEditor.remove("login");
        localEditor.remove("tapatalkhasaccount");
        localEditor.remove("vip");
        localEditor.remove("tapatalk_auid");
        localEditor.remove("token");
        localEditor.remove("status");
        localEditor.remove("ttidpassword");
        localEditor.commit();
    }

    public static TapatalkId getInstance(Context paramContext) {
        if (paramContext == null) {
            return null;
        }
        TapatalkIdHolder.tapatalkIdInstance.setContext(paramContext);
        TapatalkIdHolder.tapatalkIdInstance.checkPrefs();
        return TapatalkIdHolder.tapatalkIdInstance;
    }

    private void setContext(Context paramContext) {
        this.mContext = paramContext;
    }

    public int getAuid() {
        return this.prefs.getInt("tapatalk_auid", -1);
    }

    public String getPassword() {
        String str = this.prefs.getString("ttidpassword", this.defaultStringValue);
        if (!str.equals(this.defaultStringValue)) {
            return str;
        }
        return null;
    }

    public String getSignInMode() {
        return this.prefs.getString("handle", this.defaultStringValue);
    }

    public String getTapatalkIdEmail() {
        String str = this.prefs.getString("email", this.defaultStringValue);
        if (!str.equals(this.defaultStringValue)) {
            return str;
        }
        return null;
    }

    public String getToken() {
        String str = this.prefs.getString("token", this.defaultStringValue);
        if (!this.defaultStringValue.equals(str)) {
            return str;
        }
        return null;
    }

    public String getUsername() {
        String str = this.prefs.getString("username", this.defaultStringValue);
        if (!str.equals(this.defaultStringValue)) {
            return str;
        }
        return null;
    }

    public boolean isConfirmed() {
        return "1".equals(this.prefs.getString("status", this.defaultStringValue));
    }

    public boolean isHasAccounts() {
        ArrayList localArrayList = new FavoriateSqlHelper(this.mContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivate();
        return (this.prefs.getBoolean("tapatalkhasaccount", false)) || ((localArrayList != null) && (localArrayList.size() > 0));
    }

    public boolean isTapatalkIdLogin() {
        return this.prefs.getBoolean("login", false);
    }

    public boolean isVIP() {
        return "1".equals(this.prefs.getString("vip", this.defaultStringValue));
    }

    public boolean saveTapatalkId(JSONObject paramJSONObject) {
        SharedPreferences.Editor localEditor = this.prefs.edit();
        try {
            if (paramJSONObject.has("username")) {
                localEditor.putString("username", paramJSONObject.optString("username"));
            }
            if (paramJSONObject.has("email")) {
                localEditor.putString("email", paramJSONObject.optString("email"));
            }
            if (paramJSONObject.has("result")) {
                localEditor.putBoolean("login", paramJSONObject.optBoolean("result"));
            }
            if (paramJSONObject.has("has_accounts")) {
                localEditor.putBoolean("tapatalkhasaccount", paramJSONObject.optBoolean("has_accounts"));
            }
            if (paramJSONObject.has("vip")) {
                localEditor.putString("vip", paramJSONObject.optString("vip"));
            }
            if (paramJSONObject.has("au_id")) {
                localEditor.putInt("tapatalk_auid", paramJSONObject.optInt("au_id"));
            }
            if (paramJSONObject.has("token")) {
                localEditor.putString("token", paramJSONObject.optString("token"));
            }
            if (paramJSONObject.has("status")) {
                localEditor.putString("status", paramJSONObject.optString("status"));
            }
            localEditor.commit();
            return true;
        } catch (Exception paramJSONObject) {
            paramJSONObject.printStackTrace();
        }
        return false;
    }

    public void saveTapatalkIdData(String paramString, int paramInt) {
        SharedPreferences.Editor localEditor = this.prefs.edit();
        localEditor.putInt(paramString, paramInt);
        localEditor.commit();
    }

    public void saveTapatalkIdData(String paramString1, String paramString2) {
        SharedPreferences.Editor localEditor = this.prefs.edit();
        localEditor.putString(paramString1, paramString2);
        localEditor.commit();
    }

    public void saveTapatalkIdData(String paramString, boolean paramBoolean) {
        SharedPreferences.Editor localEditor = this.prefs.edit();
        localEditor.putBoolean(paramString, paramBoolean);
        localEditor.commit();
    }

    public boolean signOut() {
        clearTapatalkId();
        return true;
    }

    private static class TapatalkIdHolder {
        private static final TapatalkIdImpl tapatalkIdInstance = new TapatalkIdImpl(null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/tapatalkid/TapatalkIdImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */