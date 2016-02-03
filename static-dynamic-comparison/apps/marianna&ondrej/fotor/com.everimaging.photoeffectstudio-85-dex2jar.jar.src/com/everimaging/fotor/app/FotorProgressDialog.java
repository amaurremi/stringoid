package com.everimaging.fotor.app;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class FotorProgressDialog
        extends DialogFragment {
    public Dialog onCreateDialog(Bundle paramBundle) {
        paramBundle = new ProgressDialog(getActivity());
        Bundle localBundle = getArguments();
        if ((localBundle != null) && (localBundle.containsKey("message"))) {
            paramBundle.setMessage(localBundle.getCharSequence("message"));
        }
        return paramBundle;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/app/FotorProgressDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */