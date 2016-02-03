package com.quoord.tapatalkpro.activity.directory.migration;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.quoord.tapatalkpro.ics.tapatalkid.SignInWithOtherUtil;

public class MigratioinDialogTool {
    public static void showMigrationDialog(Activity paramActivity) {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
        localBuilder.setTitle(paramActivity.getString(2131100894)).setMessage(paramActivity.getString(2131100890)).setCancelable(true).setPositiveButton(paramActivity.getString(2131100288), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                paramAnonymousDialogInterface = new Intent(MigratioinDialogTool.this, MigrationActivity.class);
                MigratioinDialogTool.this.startActivityForResult(paramAnonymousDialogInterface, 1001);
            }
        });
        localBuilder.create().show();
    }

    public static void showMigrationFinishDialog(Activity paramActivity, String paramString) {
        if (paramString.equals(SignInWithOtherUtil.googleString)) {
            paramString = paramActivity.getString(2131100893);
        }
        for (; ; ) {
            AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
            localBuilder.setTitle(paramActivity.getString(2131100895)).setMessage(paramString).setCancelable(true).setPositiveButton(paramActivity.getString(2131100288), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                }
            });
            localBuilder.create().show();
            return;
            if (paramString.equals(SignInWithOtherUtil.facebookString)) {
                paramString = paramActivity.getString(2131100892);
            } else {
                paramString = paramActivity.getString(2131100891);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/directory/migration/MigratioinDialogTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */