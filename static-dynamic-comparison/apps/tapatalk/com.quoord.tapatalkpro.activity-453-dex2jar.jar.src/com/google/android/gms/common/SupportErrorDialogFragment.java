package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.internal.fq;

public class SupportErrorDialogFragment
        extends DialogFragment {
    private DialogInterface.OnCancelListener Ai = null;
    private Dialog mDialog = null;

    public static SupportErrorDialogFragment newInstance(Dialog paramDialog) {
        return newInstance(paramDialog, null);
    }

    public static SupportErrorDialogFragment newInstance(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener) {
        SupportErrorDialogFragment localSupportErrorDialogFragment = new SupportErrorDialogFragment();
        paramDialog = (Dialog) fq.b(paramDialog, "Cannot display null dialog");
        paramDialog.setOnCancelListener(null);
        paramDialog.setOnDismissListener(null);
        localSupportErrorDialogFragment.mDialog = paramDialog;
        if (paramOnCancelListener != null) {
            localSupportErrorDialogFragment.Ai = paramOnCancelListener;
        }
        return localSupportErrorDialogFragment;
    }

    public void onCancel(DialogInterface paramDialogInterface) {
        if (this.Ai != null) {
            this.Ai.onCancel(paramDialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle paramBundle) {
        return this.mDialog;
    }

    public void show(FragmentManager paramFragmentManager, String paramString) {
        super.show(paramFragmentManager, paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/common/SupportErrorDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */