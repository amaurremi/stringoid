package com.everimaging.fotorsdk.app;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FotorAlertDialog
        extends DialogFragment {
    private a a;

    public static FotorAlertDialog a() {
        return new FotorAlertDialog();
    }

    public void a(FragmentManager paramFragmentManager, String paramString, boolean paramBoolean) {
        if (paramBoolean) {
            paramFragmentManager = paramFragmentManager.beginTransaction();
            paramFragmentManager.add(this, paramString);
            paramFragmentManager.commitAllowingStateLoss();
            return;
        }
        show(paramFragmentManager, paramString);
    }

    public void a(a parama) {
        this.a = parama;
    }

    public Dialog onCreateDialog(Bundle paramBundle) {
        paramBundle = new AlertDialog.Builder(getActivity());
        Bundle localBundle = getArguments();
        if (localBundle.containsKey("TITLE")) {
            paramBundle.setTitle(localBundle.getCharSequence("TITLE"));
        }
        if (localBundle.containsKey("MESSAGE")) {
            paramBundle.setMessage(localBundle.getCharSequence("MESSAGE"));
        }
        if (localBundle.containsKey("POSITIVE_BUTTON_TEXT")) {
            paramBundle.setPositiveButton(localBundle.getCharSequence("POSITIVE_BUTTON_TEXT"), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    if (FotorAlertDialog.a(FotorAlertDialog.this) != null) {
                        FotorAlertDialog.a(FotorAlertDialog.this).a(FotorAlertDialog.this);
                    }
                }
            });
        }
        if (localBundle.containsKey("NEGATIVE_BUTTON_TEXT")) {
            paramBundle.setNegativeButton(localBundle.getCharSequence("NEGATIVE_BUTTON_TEXT"), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    if (FotorAlertDialog.a(FotorAlertDialog.this) != null) {
                        FotorAlertDialog.a(FotorAlertDialog.this).b(FotorAlertDialog.this);
                    }
                }
            });
        }
        if (localBundle.containsKey("NEUTRAL_BUTTON_TEXT")) {
            paramBundle.setNegativeButton(localBundle.getCharSequence("NEUTRAL_BUTTON_TEXT"), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    if (FotorAlertDialog.a(FotorAlertDialog.this) != null) {
                        FotorAlertDialog.a(FotorAlertDialog.this).c(FotorAlertDialog.this);
                    }
                }
            });
        }
        return paramBundle.create();
    }

    public static abstract interface a {
        public abstract void a(FotorAlertDialog paramFotorAlertDialog);

        public abstract void b(FotorAlertDialog paramFotorAlertDialog);

        public abstract void c(FotorAlertDialog paramFotorAlertDialog);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/app/FotorAlertDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */