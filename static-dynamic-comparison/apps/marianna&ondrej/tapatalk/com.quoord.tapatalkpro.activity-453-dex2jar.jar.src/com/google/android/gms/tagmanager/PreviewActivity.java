package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class PreviewActivity
        extends Activity {
    private void b(String paramString1, String paramString2, String paramString3) {
        AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
        localAlertDialog.setTitle(paramString1);
        localAlertDialog.setMessage(paramString2);
        localAlertDialog.setButton(-1, paramString3, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        });
        localAlertDialog.show();
    }

    public void onCreate(Bundle paramBundle) {
        try {
            super.onCreate(paramBundle);
            bh.x("Preview activity");
            paramBundle = getIntent().getData();
            if (!TagManager.getInstance(this).g(paramBundle)) {
                paramBundle = "Cannot preview the app with the uri: " + paramBundle + ". Launching current version instead.";
                bh.z(paramBundle);
                b("Preview failure", paramBundle, "Continue");
            }
            paramBundle = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (paramBundle != null) {
                bh.x("Invoke the launch activity for package name: " + getPackageName());
                startActivity(paramBundle);
                return;
            }
            bh.x("No launch activity found for package name: " + getPackageName());
            return;
        } catch (Exception paramBundle) {
            bh.w("Calling preview threw an exception: " + paramBundle.getMessage());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/PreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */