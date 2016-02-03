package com.quoord.tapatalkpro.action;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.quoord.tapatalkpro.bean.ForumStatus;

public class BanedDialogAction {
    public static void showBannedDialog(Activity paramActivity, ForumStatus paramForumStatus) {
        if ("banned".equals(paramForumStatus.getUserType())) {
            new AlertDialog.Builder(paramActivity).setTitle(paramActivity.getResources().getString(2131100889)).setCancelable(false).setMessage(paramForumStatus.getBanedTips()).setPositiveButton(paramActivity.getResources().getString(2131099976), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    BanedDialogAction.this.finish();
                }
            }).create().show();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/action/BanedDialogAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */