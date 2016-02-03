package com.quoord.tapatalkpro.util;

import android.app.Activity;
import android.app.ProgressDialog;

public class ProgressDialogUtil {
    private Activity mActivity;
    private ProgressDialog mDialog;

    public ProgressDialogUtil(Activity paramActivity) {
        this.mActivity = paramActivity;
    }

    private boolean checkDialog() {
        return this.mDialog != null;
    }

    private void createProgressDialog() {
        this.mDialog = new ProgressDialog(this.mActivity);
        this.mDialog.setMessage(this.mActivity.getString(2131099870));
        this.mDialog.setIndeterminate(true);
        this.mDialog.setCancelable(true);
    }

    public void closeProgressDialog() {
        if ((checkDialog()) && (this.mDialog.isShowing())) {
            this.mDialog.cancel();
        }
    }

    public void showProgressDialog() {
        if (checkDialog()) {
            if (!this.mDialog.isShowing()) {
                this.mDialog.show();
            }
            return;
        }
        createProgressDialog();
        this.mDialog.show();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/ProgressDialogUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */