package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.bean.AttachmentInfo;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;

public class CheckUpdate
        implements CallBackInterface {
    public static String CHECK_VERSION = "https://directory.tapatalk.com/check_app_version.php";
    private Activity mActivity;

    public CheckUpdate(Activity paramActivity) {
        this.mActivity = paramActivity;
        try {
            String str = this.mActivity.getPackageManager().getPackageInfo(this.mActivity.getPackageName(), 0).versionName;
            str = CHECK_VERSION + "?version=" + str;
            new TapatalkJsonEngine(paramActivity, this).call(str);
            return;
        } catch (PackageManager.NameNotFoundException paramActivity) {
            paramActivity.printStackTrace();
        }
    }

    public void callBack(final EngineResponse paramEngineResponse) {
        if ((paramEngineResponse.getResponse() != null) && (((String) paramEngineResponse.getResponse()).length() > 0)) {
            paramEngineResponse = ((String) paramEngineResponse.getResponse()).replaceAll("\\\\", "").replaceAll("\"", "");
            if (paramEngineResponse.length() > 0) {
                new AlertDialog.Builder(this.mActivity).setTitle("Update Available").setCancelable(false).setMessage("A newer version of Tapatalk is now available.").setPositiveButton("Download", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        if (paramEngineResponse.contains("market")) {
                            paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW");
                            paramAnonymousDialogInterface.setData(Uri.parse(paramEngineResponse));
                            CheckUpdate.this.mActivity.startActivity(paramAnonymousDialogInterface);
                            return;
                        }
                        AttachmentInfo.download(CheckUpdate.this.mActivity, paramEngineResponse);
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    }
                }).create().show();
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/CheckUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */