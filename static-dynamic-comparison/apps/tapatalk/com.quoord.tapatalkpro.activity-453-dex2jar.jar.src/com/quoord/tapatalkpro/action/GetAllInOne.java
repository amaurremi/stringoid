package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import org.json.JSONObject;

public class GetAllInOne
        implements CallBackInterface {
    private TapatalkJsonEngine engine = new TapatalkJsonEngine(paramActivity, this);
    private Activity mContext;
    private SharedPreferences prefs = null;

    public GetAllInOne(Activity paramActivity) {
        this.mContext = paramActivity;
        this.prefs = Prefs.get(paramActivity);
        paramActivity = "https://directory.tapatalk.com/get_branded.php?app_type=android&bid=" + TapatalkApp.rebranding_id;
        this.engine.call(paramActivity);
    }

    public void callBack(EngineResponse paramEngineResponse) {
        try {
            JSONObject localJSONObject = (JSONObject) paramEngineResponse.getResponse();
            paramEngineResponse = this.prefs.edit();
            paramEngineResponse.putString("ext", localJSONObject.getString("ext"));
            paramEngineResponse.putInt("signature_type", Integer.valueOf(localJSONObject.getInt("signature_type")).intValue());
            paramEngineResponse.putString("signature_string", localJSONObject.getString("signature_string"));
            paramEngineResponse.putString("ga_id", localJSONObject.getString("ga_id"));
            paramEngineResponse.putString("admob_id", localJSONObject.getString("admob_id"));
            paramEngineResponse.putString("dfp_320x50", localJSONObject.getString("dfp_320x50"));
            paramEngineResponse.putString("dfp_300x250", localJSONObject.getString("dfp_300x250"));
            paramEngineResponse.putString("viglink", localJSONObject.getString("viglink"));
            if ((localJSONObject.has("purchase")) && (localJSONObject.get("purchase").equals("0"))) {
                paramEngineResponse.putBoolean("purchase", false);
                new AlertDialog.Builder(this.mContext).setTitle("Invalid License").setMessage("This forum is currently not available on this app. Please contact the forum administrator.").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        GetAllInOne.this.mContext.finish();
                    }
                }).create().show();
            }
            if (localJSONObject.get("color") != null) {
                localJSONObject = (JSONObject) localJSONObject.get("color");
                paramEngineResponse.putString("background", localJSONObject.getString("background"));
                paramEngineResponse.putString("sectiontitle", localJSONObject.getString("sectiontitle"));
                paramEngineResponse.putString("highlight", localJSONObject.getString("highlight"));
                paramEngineResponse.putString("datetext", localJSONObject.getString("datetext"));
                paramEngineResponse.putString("subbackground", localJSONObject.getString("subbackground"));
            }
            paramEngineResponse.commit();
            return;
        } catch (Exception paramEngineResponse) {
            paramEngineResponse.printStackTrace();
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/GetAllInOne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */