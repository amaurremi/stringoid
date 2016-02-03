package com.uservoice.uservoicesdk.flow;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.uservoice.uservoicesdk.R.string;
import com.uservoice.uservoicesdk.Session;
import com.uservoice.uservoicesdk.babayaga.Babayaga;
import com.uservoice.uservoicesdk.babayaga.Babayaga.Event;
import com.uservoice.uservoicesdk.dialog.PasswordDialogFragment;
import com.uservoice.uservoicesdk.dialog.SigninDialogFragment;
import com.uservoice.uservoicesdk.model.AccessTokenResult;
import com.uservoice.uservoicesdk.model.RequestToken;
import com.uservoice.uservoicesdk.model.User;
import com.uservoice.uservoicesdk.rest.Callback;
import com.uservoice.uservoicesdk.rest.RestResult;
import com.uservoice.uservoicesdk.ui.DefaultCallback;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SigninManager {
    private final FragmentActivity activity;
    private final SigninCallback callback;
    private String email;
    private Pattern emailFormat = Pattern.compile("\\A(\\w[-+.\\w!\\#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\|\\}~]*@([-\\w]*\\.)+[a-zA-Z]{2,9})\\z");
    private String name;
    private boolean passwordOnly;

    private SigninManager(FragmentActivity paramFragmentActivity, String paramString1, String paramString2, SigninCallback paramSigninCallback) {
        this.activity = paramFragmentActivity;
        if (paramString1 != null) {
            paramFragmentActivity = paramString1;
            if (paramString1.trim().length() != 0) {
            }
        } else {
            paramFragmentActivity = null;
        }
        this.email = paramFragmentActivity;
        if (paramString2 != null) {
            paramFragmentActivity = paramString2;
            if (paramString2.trim().length() != 0) {
            }
        } else {
            paramFragmentActivity = null;
        }
        this.name = paramFragmentActivity;
        this.callback = paramSigninCallback;
    }

    private void createUser() {
        RequestToken.getRequestToken(new DefaultCallback(this.activity) {
            public void onModel(RequestToken paramAnonymousRequestToken) {
                Session.getInstance().setRequestToken(paramAnonymousRequestToken);
                User.findOrCreate(SigninManager.this.email, SigninManager.this.name, new DefaultCallback(SigninManager.this.activity) {
                    public void onModel(AccessTokenResult<User> paramAnonymous2AccessTokenResult) {
                        Session.getInstance().setUser((User) paramAnonymous2AccessTokenResult.getModel());
                        Session.getInstance().setAccessToken(SigninManager.this.activity, paramAnonymous2AccessTokenResult.getAccessToken());
                        Babayaga.track(Babayaga.Event.IDENTIFY);
                        SigninManager.this.callback.onSuccess();
                    }
                });
            }
        });
    }

    private void promptToSignIn() {
        if (this.passwordOnly) {
            new PasswordDialogFragment(this.callback).show(this.activity.getSupportFragmentManager(), "PasswordDialogFragment");
            return;
        }
        new SigninDialogFragment(this.email, this.name, this.callback).show(this.activity.getSupportFragmentManager(), "SigninDialogFragment");
    }

    private void signIn() {
        Object localObject = Session.getInstance().getUser();
        if ((localObject != null) && ((this.email == null) || (this.email.equals(((User) localObject).getEmail())))) {
            this.callback.onSuccess();
            return;
        }
        if (Session.getInstance().getAccessToken() != null) {
            this.callback.onSuccess();
            return;
        }
        if ((this.email != null) && (!this.emailFormat.matcher(this.email).matches())) {
            Toast.makeText(this.activity, R.string.uv_msg_bad_email_format, 0).show();
            this.callback.onFailure();
            return;
        }
        if (this.email == null) {
            localObject = Session.getInstance().getEmail();
            this.email = ((String) localObject);
            if (this.name != null) {
                break label172;
            }
        }
        label172:
        for (localObject = Session.getInstance().getName(); ; localObject = this.name) {
            this.name = ((String) localObject);
            if (this.email == null) {
                break label180;
            }
            User.discover(this.email, new Callback() {
                public void onError(RestResult paramAnonymousRestResult) {
                    SigninManager.this.createUser();
                }

                public void onModel(User paramAnonymousUser) {
                    SigninManager.this.promptToSignIn();
                }
            });
            return;
            localObject = this.email;
            break;
        }
        label180:
        promptToSignIn();
    }

    public static void signIn(FragmentActivity paramFragmentActivity, SigninCallback paramSigninCallback) {
        new SigninManager(paramFragmentActivity, null, null, paramSigninCallback).signIn();
    }

    public static void signIn(FragmentActivity paramFragmentActivity, String paramString1, String paramString2, SigninCallback paramSigninCallback) {
        new SigninManager(paramFragmentActivity, paramString1, paramString2, paramSigninCallback).signIn();
    }

    public static void signinForSubscribe(FragmentActivity paramFragmentActivity, String paramString, SigninCallback paramSigninCallback) {
        paramFragmentActivity = new SigninManager(paramFragmentActivity, paramString, Session.getInstance().getName(), paramSigninCallback);
        paramFragmentActivity.setPasswordOnly(true);
        paramFragmentActivity.signIn();
    }

    public void setPasswordOnly(boolean paramBoolean) {
        this.passwordOnly = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/flow/SigninManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */