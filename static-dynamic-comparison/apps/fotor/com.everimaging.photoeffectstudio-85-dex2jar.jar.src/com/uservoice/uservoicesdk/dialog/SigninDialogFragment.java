package com.uservoice.uservoicesdk.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.uservoice.uservoicesdk.R.id;
import com.uservoice.uservoicesdk.R.layout;
import com.uservoice.uservoicesdk.R.string;
import com.uservoice.uservoicesdk.Session;
import com.uservoice.uservoicesdk.babayaga.Babayaga;
import com.uservoice.uservoicesdk.babayaga.Babayaga.Event;
import com.uservoice.uservoicesdk.flow.SigninCallback;
import com.uservoice.uservoicesdk.model.AccessToken;
import com.uservoice.uservoicesdk.model.AccessTokenResult;
import com.uservoice.uservoicesdk.model.RequestToken;
import com.uservoice.uservoicesdk.model.User;
import com.uservoice.uservoicesdk.rest.Callback;
import com.uservoice.uservoicesdk.rest.RestResult;
import com.uservoice.uservoicesdk.ui.DefaultCallback;
import com.uservoice.uservoicesdk.ui.Utils;

@SuppressLint({"ValidFragment"})
public class SigninDialogFragment
        extends DialogFragmentBugfixed {
    private SigninCallback callback;
    private String email;
    private EditText emailField;
    private Button forgotPassword;
    private String name;
    private EditText nameField;
    private EditText passwordField;
    private View passwordFields;
    private Runnable requestTokenCallback;

    public SigninDialogFragment() {
    }

    public SigninDialogFragment(String paramString1, String paramString2, SigninCallback paramSigninCallback) {
        this.email = paramString1;
        this.name = paramString2;
        this.callback = paramSigninCallback;
    }

    private void discoverUser() {
        User.discover(this.emailField.getText().toString(), new Callback() {
            public void onError(RestResult paramAnonymousRestResult) {
                SigninDialogFragment.this.passwordFields.setVisibility(8);
                SigninDialogFragment.this.nameField.setVisibility(0);
                SigninDialogFragment.this.nameField.requestFocus();
            }

            public void onModel(User paramAnonymousUser) {
                SigninDialogFragment.this.passwordFields.setVisibility(0);
                SigninDialogFragment.this.nameField.setVisibility(8);
                SigninDialogFragment.this.passwordField.requestFocus();
            }
        });
    }

    private void sendForgotPassword() {
        final FragmentActivity localFragmentActivity = getActivity();
        User.sendForgotPassword(this.emailField.getText().toString(), new DefaultCallback(getActivity()) {
            public void onModel(User paramAnonymousUser) {
                Toast.makeText(localFragmentActivity, R.string.uv_msg_forgot_password, 0).show();
            }
        });
    }

    private void signIn() {
        Runnable local6 = new Runnable() {
            public void run() {
                if (SigninDialogFragment.this.nameField.getVisibility() == 0) {
                    User.findOrCreate(SigninDialogFragment.this.emailField.getText().toString(), SigninDialogFragment.this.nameField.getText().toString(), new DefaultCallback(SigninDialogFragment.this.getActivity()) {
                        public void onModel(AccessTokenResult<User> paramAnonymous2AccessTokenResult) {
                            Session.getInstance().setUser((User) paramAnonymous2AccessTokenResult.getModel());
                            Session.getInstance().setAccessToken(SigninDialogFragment .6.
                            this.val$activity, paramAnonymous2AccessTokenResult.getAccessToken());
                            Babayaga.track(Babayaga.Event.AUTHENTICATE);
                            SigninDialogFragment.this.dismiss();
                            SigninDialogFragment.this.callback.onSuccess();
                        }
                    });
                    return;
                }
                AccessToken.authorize(SigninDialogFragment.this.emailField.getText().toString(), SigninDialogFragment.this.passwordField.getText().toString(), new Callback() {
                    public void onError(RestResult paramAnonymous2RestResult) {
                        Toast.makeText(SigninDialogFragment .6. this.val$activity, R.string.uv_failed_signin_error, 0).
                        show();
                    }

                    public void onModel(AccessToken paramAnonymous2AccessToken) {
                        Session.getInstance().setAccessToken(SigninDialogFragment .6.
                        this.val$activity, paramAnonymous2AccessToken);
                        User.loadCurrentUser(new DefaultCallback(SigninDialogFragment.this.getActivity()) {
                            public void onModel(User paramAnonymous3User) {
                                Session.getInstance().setUser(paramAnonymous3User);
                                Babayaga.track(Babayaga.Event.AUTHENTICATE);
                                SigninDialogFragment.this.dismiss();
                                SigninDialogFragment.this.callback.onSuccess();
                            }
                        });
                    }
                });
            }
        };
        if (Session.getInstance().getRequestToken() != null) {
            local6.run();
            return;
        }
        this.requestTokenCallback = local6;
    }

    public Dialog onCreateDialog(final Bundle paramBundle) {
        RequestToken.getRequestToken(new DefaultCallback(getActivity()) {
            public void onModel(RequestToken paramAnonymousRequestToken) {
                Session.getInstance().setRequestToken(paramAnonymousRequestToken);
                if (SigninDialogFragment.this.requestTokenCallback != null) {
                    SigninDialogFragment.this.requestTokenCallback.run();
                }
            }
        });
        paramBundle = new AlertDialog.Builder(getActivity());
        if (!Utils.isDarkTheme(getActivity())) {
            paramBundle.setInverseBackgroundForced(true);
        }
        paramBundle.setTitle(R.string.uv_signin_dialog_title);
        View localView = getActivity().getLayoutInflater().inflate(R.layout.uv_signin_layout, null);
        this.emailField = ((EditText) localView.findViewById(R.id.uv_signin_email));
        this.nameField = ((EditText) localView.findViewById(R.id.uv_signin_name));
        this.passwordField = ((EditText) localView.findViewById(R.id.uv_signin_password));
        this.passwordFields = localView.findViewById(R.id.uv_signin_password_fields);
        this.forgotPassword = ((Button) localView.findViewById(R.id.uv_signin_forgot_password));
        this.passwordFields.setVisibility(8);
        this.emailField.setText(this.email);
        this.nameField.setText(this.name);
        if (this.email != null) {
            discoverUser();
        }
        this.forgotPassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                SigninDialogFragment.this.sendForgotPassword();
            }
        });
        this.emailField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean) {
                if ((paramAnonymousView == SigninDialogFragment.this.emailField) && (!paramAnonymousBoolean)) {
                    SigninDialogFragment.this.discoverUser();
                }
            }
        });
        paramBundle.setView(localView);
        paramBundle.setNegativeButton(17039360, null);
        paramBundle.setPositiveButton(R.string.uv_signin_dialog_ok, null);
        paramBundle = paramBundle.create();
        paramBundle.setOnShowListener(new DialogInterface.OnShowListener() {
            public void onShow(DialogInterface paramAnonymousDialogInterface) {
                paramBundle.getButton(-1).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymous2View) {
                        SigninDialogFragment.this.signIn();
                    }
                });
                ((InputMethodManager) SigninDialogFragment.this.getActivity().getSystemService("input_method")).showSoftInput(SigninDialogFragment.this.emailField, 1);
            }
        });
        paramBundle.getWindow().setSoftInputMode(5);
        return paramBundle;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/dialog/SigninDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */