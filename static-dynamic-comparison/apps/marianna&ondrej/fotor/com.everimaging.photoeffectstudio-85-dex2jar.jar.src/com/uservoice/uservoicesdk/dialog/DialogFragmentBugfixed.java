package com.uservoice.uservoicesdk.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public abstract class DialogFragmentBugfixed
        extends DialogFragment {
    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        setRetainInstance(true);
    }

    public void onDestroyView() {
        if ((getDialog() != null) && (getRetainInstance())) {
            getDialog().setOnDismissListener(null);
        }
        super.onDestroyView();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/dialog/DialogFragmentBugfixed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */