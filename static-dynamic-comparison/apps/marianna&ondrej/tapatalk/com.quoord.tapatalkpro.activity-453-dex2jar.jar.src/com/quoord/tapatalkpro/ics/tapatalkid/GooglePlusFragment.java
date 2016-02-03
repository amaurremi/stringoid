package com.quoord.tapatalkpro.ics.tapatalkid;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.DialogFragment;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;

public class GooglePlusFragment
        extends QuoordFragment
        implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public static final int AUTH_CODE_REQUEST_CODE = 9001;
    public static final int CALLFOR_GOOGLE_SERVICE = 9002;
    private static final String DIALOG_ERROR = "dialog_error";
    public static final int REQUEST_CODE_RESOLVE_ERR = 9000;
    public static final int REQUEST_RESOLVE_ERROR = 9003;
    private static Activity context;
    public String accountName;
    public Person currentPerson = null;
    public ErrorDialogFragment dialogFragment;
    protected GoogleGetToken getToken;
    public ConnectionResult mConnectionResult;
    public GoogleApiClient mGoogleApiClient;
    public boolean mResolvingError = false;
    private String scopes = "oauth2:profile https://www.googleapis.com/auth/plus.profile.emails.read";
    public Handler uiHandler;

    public void buildPlusClient(String paramString) {
        if (this.mGoogleApiClient != null) {
            this.mGoogleApiClient.disconnect();
            this.mGoogleApiClient = null;
        }
        this.accountName = paramString;
        this.mGoogleApiClient = new GoogleApiClient.Builder(context).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(Plus.API).addScope(Plus.SCOPE_PLUS_LOGIN).addScope(new Scope("https://www.googleapis.com/auth/plus.profile.emails.read")).setAccountName(paramString).build();
        this.mGoogleApiClient.connect();
    }

    public void disMisDialog() {
        if ((this.dialogFragment != null) && (this.dialogFragment.isVisible())) {
            this.dialogFragment.dismiss();
        }
    }

    public int getGooglePlayServiceStatus() {
        return GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
    }

    public void getToken(final String paramString) {
        new Thread() {
            public void run() {
                Object localObject = null;
                try {
                    String str = GoogleAuthUtil.getToken(GooglePlusFragment.context, paramString, GooglePlusFragment.this.scopes);
                    localObject = str;
                    GoogleAuthUtil.invalidateToken(GooglePlusFragment.context, str);
                    localObject = str;
                    Message localMessage2 = GooglePlusFragment.this.uiHandler.obtainMessage();
                    localObject = str;
                    localMessage2.what = 1;
                    localObject = str;
                    localMessage2.obj = str;
                    localObject = str;
                    GooglePlusFragment.this.uiHandler.sendMessage(localMessage2);
                    return;
                } catch (UserRecoverableAuthException localUserRecoverableAuthException) {
                    GooglePlusFragment.this.startActivityForResult(localUserRecoverableAuthException.getIntent(), 9001);
                    return;
                } catch (GoogleAuthException localGoogleAuthException) {
                } catch (Exception localException) {
                    Message localMessage1 = GooglePlusFragment.this.uiHandler.obtainMessage();
                    localMessage1.what = 0;
                    localMessage1.obj = localGoogleAuthException;
                    GooglePlusFragment.this.uiHandler.sendMessage(localMessage1);
                }
            }
        }.start();
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        context = getActivity();
        this.uiHandler = new Handler() {
            public void handleMessage(Message paramAnonymousMessage) {
                switch (paramAnonymousMessage.what) {
                }
                for (; ; ) {
                    super.handleMessage(paramAnonymousMessage);
                    return;
                    if (GooglePlusFragment.this.getToken != null) {
                        GooglePlusFragment.this.getToken.getTokenResult(false, paramAnonymousMessage.obj.toString());
                        continue;
                        if (GooglePlusFragment.this.getToken != null) {
                            GooglePlusFragment.this.getToken.getTokenResult(true, paramAnonymousMessage.obj.toString());
                        }
                    }
                }
            }
        };
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if (paramInt1 == 9003) {
            this.mResolvingError = false;
            if ((paramInt2 == -1) && (this.mGoogleApiClient != null) && (!this.mGoogleApiClient.isConnecting()) && (!this.mGoogleApiClient.isConnected())) {
                this.mGoogleApiClient.connect();
            }
        }
        if ((paramInt1 == 9001) && (paramInt2 == -1)) {
            getToken(this.accountName);
        }
    }

    public void onConnected(Bundle paramBundle) {
        try {
            this.accountName = Plus.AccountApi.getAccountName(this.mGoogleApiClient);
            if (Plus.PeopleApi.getCurrentPerson(this.mGoogleApiClient) != null) {
                this.currentPerson = Plus.PeopleApi.getCurrentPerson(this.mGoogleApiClient);
                getToken(this.accountName);
                return;
            }
            buildPlusClient(this.accountName);
            return;
        } catch (Exception paramBundle) {
        }
    }

    public void onConnectionFailed(ConnectionResult paramConnectionResult) {
        if (this.mResolvingError) {
            return;
        }
        if (paramConnectionResult.hasResolution()) {
            try {
                this.mResolvingError = true;
                paramConnectionResult.startResolutionForResult(context, 9003);
                return;
            } catch (IntentSender.SendIntentException paramConnectionResult) {
                this.mGoogleApiClient.connect();
                return;
            }
        }
        showErrorDialog(paramConnectionResult.getErrorCode());
        this.mResolvingError = true;
    }

    public void onConnectionSuspended(int paramInt) {
    }

    public void onDialogDismissed() {
        this.mResolvingError = false;
    }

    public void onStop() {
        super.onStop();
        if ((this.mGoogleApiClient != null) && (this.mGoogleApiClient.isConnected())) {
            this.mGoogleApiClient.disconnect();
        }
    }

    public void showErrorDialog(int paramInt) {
        this.dialogFragment = new ErrorDialogFragment();
        Bundle localBundle = new Bundle();
        localBundle.putInt("dialog_error", paramInt);
        this.dialogFragment.setArguments(localBundle);
        this.dialogFragment.show(getFragmentManager(), "errordialog");
    }

    public class ErrorDialogFragment
            extends DialogFragment {
        public ErrorDialogFragment() {
        }

        public Dialog onCreateDialog(Bundle paramBundle) {
            return GooglePlayServicesUtil.getErrorDialog(getArguments().getInt("dialog_error"), getActivity(), 9003);
        }

        public void onDismiss(DialogInterface paramDialogInterface) {
            GooglePlusFragment.this.onDialogDismissed();
        }
    }

    public static abstract interface GoogleGetToken {
        public abstract void getTokenResult(boolean paramBoolean, String paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/tapatalkid/GooglePlusFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */