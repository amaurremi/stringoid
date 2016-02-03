package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.google.android.gms.common.internal.ag;

public class b
        extends DialogFragment {
    private Dialog a = null;
    private DialogInterface.OnCancelListener b = null;

    public static b a(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener) {
        b localb = new b();
        paramDialog = (Dialog) ag.a(paramDialog, "Cannot display null dialog");
        paramDialog.setOnCancelListener(null);
        paramDialog.setOnDismissListener(null);
        localb.a = paramDialog;
        if (paramOnCancelListener != null) {
            localb.b = paramOnCancelListener;
        }
        return localb;
    }

    public void onCancel(DialogInterface paramDialogInterface) {
        if (this.b != null) {
            this.b.onCancel(paramDialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle paramBundle) {
        if (this.a == null) {
            setShowsDialog(false);
        }
        return this.a;
    }

    public void show(FragmentManager paramFragmentManager, String paramString) {
        super.show(paramFragmentManager, paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */