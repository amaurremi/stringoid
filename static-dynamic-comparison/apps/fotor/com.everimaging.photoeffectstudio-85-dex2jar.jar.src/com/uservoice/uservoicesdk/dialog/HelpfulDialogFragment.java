package com.uservoice.uservoicesdk.dialog;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.uservoice.uservoicesdk.R.string;
import com.uservoice.uservoicesdk.ui.Utils;

public class HelpfulDialogFragment
        extends DialogFragmentBugfixed {
    public Dialog onCreateDialog(Bundle paramBundle) {
        paramBundle = new AlertDialog.Builder(getActivity());
        if (!Utils.isDarkTheme(getActivity())) {
            paramBundle.setInverseBackgroundForced(true);
        }
        paramBundle.setTitle(R.string.uv_helpful_article_message_question);
        paramBundle.setNegativeButton(R.string.uv_no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                paramAnonymousDialogInterface.cancel();
                HelpfulDialogFragment.this.getActivity().finish();
            }
        });
        paramBundle.setPositiveButton(R.string.uv_yes, null);
        return paramBundle.create();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/dialog/HelpfulDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */