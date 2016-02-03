package com.uservoice.uservoicesdk.dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import com.uservoice.uservoicesdk.R.id;
import com.uservoice.uservoicesdk.R.layout;
import com.uservoice.uservoicesdk.R.string;
import com.uservoice.uservoicesdk.Session;
import com.uservoice.uservoicesdk.flow.SigninCallback;
import com.uservoice.uservoicesdk.model.AccessToken;
import com.uservoice.uservoicesdk.model.RequestToken;
import com.uservoice.uservoicesdk.ui.DefaultCallback;
import com.uservoice.uservoicesdk.ui.Utils;

@SuppressLint({"ValidFragment"})
public class PasswordDialogFragment
        extends DialogFragmentBugfixed {
    private final SigninCallback callback;
    private EditText password;

    public PasswordDialogFragment(SigninCallback paramSigninCallback) {
        this.callback = paramSigninCallback;
    }

    private void authorize() {
        AccessToken.authorize(Session.getInstance().getEmail(), this.password.getText().toString(), new DefaultCallback(getActivity()) {
            public void onModel(AccessToken paramAnonymousAccessToken) {
                Session.getInstance().setAccessToken(paramAnonymousAccessToken);
                PasswordDialogFragment.this.callback.onSuccess();
            }
        });
    }

    public Dialog onCreateDialog(Bundle paramBundle) {
        paramBundle = new AlertDialog.Builder(getActivity());
        paramBundle.setTitle(R.string.uv_password_dialog_title);
        if (!Utils.isDarkTheme(getActivity())) {
            paramBundle.setInverseBackgroundForced(true);
        }
        View localView = getActivity().getLayoutInflater().inflate(R.layout.uv_password_dialog, null);
        this.password = ((EditText) localView.findViewById(R.id.uv_password));
        paramBundle.setView(localView);
        paramBundle.setNegativeButton(R.string.uv_cancel, null);
        paramBundle.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                if (Session.getInstance().getRequestToken() != null) {
                    PasswordDialogFragment.this.authorize();
                    return;
                }
                RequestToken.getRequestToken(new DefaultCallback(PasswordDialogFragment.this.getActivity()) {
                    public void onModel(RequestToken paramAnonymous2RequestToken) {
                        Session.getInstance().setRequestToken(paramAnonymous2RequestToken);
                        PasswordDialogFragment.this.authorize();
                    }
                });
            }
        });
        paramBundle = paramBundle.create();
        paramBundle.getWindow().setSoftInputMode(5);
        return paramBundle;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/dialog/PasswordDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */