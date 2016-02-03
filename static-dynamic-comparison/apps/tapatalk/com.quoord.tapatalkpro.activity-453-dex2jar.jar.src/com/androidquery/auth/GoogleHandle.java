package com.androidquery.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.androidquery.AQuery;
import com.androidquery.callback.AbstractAjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;
import org.apache.http.HttpRequest;

public class GoogleHandle
        extends AccountHandle
        implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
    private Account acc;
    private Account[] accs;
    private Activity act;
    private AccountManager am;
    private String email;
    private String token;
    private String type;

    public GoogleHandle(Activity paramActivity, String paramString1, String paramString2) {
        String str = paramString2;
        if ("aq.account".equals(paramString2)) {
            str = getActiveAccount(paramActivity);
        }
        this.act = paramActivity;
        this.type = paramString1.substring(2);
        this.email = str;
        this.am = AccountManager.get(paramActivity);
    }

    private void accountDialog() {
        Object localObject = new AlertDialog.Builder(this.act);
        this.accs = this.am.getAccountsByType("com.google");
        int j = this.accs.length;
        if (j == 1) {
            auth(this.accs[0]);
            return;
        }
        String[] arrayOfString = new String[j];
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                ((AlertDialog.Builder) localObject).setItems(arrayOfString, this);
                ((AlertDialog.Builder) localObject).setOnCancelListener(this);
                localObject = ((AlertDialog.Builder) localObject).create();
                new AQuery(this.act).show((Dialog) localObject);
                return;
            }
            arrayOfString[i] = this.accs[i].name;
            i += 1;
        }
    }

    private void auth(Account paramAccount) {
        this.acc = paramAccount;
        new Task(null).execute(new String[0]);
    }

    public static String getActiveAccount(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("aq.account", null);
    }

    public static void setActiveAccount(Context paramContext, String paramString) {
        PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString("aq.account", paramString).commit();
    }

    public void applyToken(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback, HttpRequest paramHttpRequest) {
        paramHttpRequest.addHeader("Authorization", "GoogleLogin auth=" + this.token);
    }

    protected void auth() {
        if (this.email == null) {
            accountDialog();
        }
        for (; ; ) {
            return;
            Account[] arrayOfAccount = this.am.getAccountsByType("com.google");
            int i = 0;
            while (i < arrayOfAccount.length) {
                Account localAccount = arrayOfAccount[i];
                if (this.email.equals(localAccount.name)) {
                    auth(localAccount);
                    return;
                }
                i += 1;
            }
        }
    }

    public boolean authenticated() {
        return this.token != null;
    }

    public boolean expired(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback, AjaxStatus paramAjaxStatus) {
        int i = paramAjaxStatus.getCode();
        return (i == 401) || (i == 403);
    }

    public String getCacheUrl(String paramString) {
        return paramString + "#" + this.token;
    }

    public String getType() {
        return this.type;
    }

    public void onCancel(DialogInterface paramDialogInterface) {
        failure(this.act, -102, "cancel");
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        paramDialogInterface = this.accs[paramInt];
        AQUtility.debug("acc", paramDialogInterface.name);
        setActiveAccount(this.act, paramDialogInterface.name);
        auth(paramDialogInterface);
    }

    public boolean reauth(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback) {
        this.am.invalidateAuthToken(this.acc.type, this.token);
        try {
            this.token = this.am.blockingGetAuthToken(this.acc, this.type, true);
            AQUtility.debug("re token", this.token);
            if (this.token != null) {
                return true;
            }
        } catch (Exception paramAbstractAjaxCallback) {
            for (; ; ) {
                AQUtility.debug(paramAbstractAjaxCallback);
                this.token = null;
            }
        }
        return false;
    }

    private class Task
            extends AsyncTask<String, String, Bundle> {
        private Task() {
        }

        protected Bundle doInBackground(String... paramVarArgs) {
            try {
                paramVarArgs = (Bundle) GoogleHandle.this.am.getAuthToken(GoogleHandle.this.acc, GoogleHandle.this.type, null, GoogleHandle.this.act, null, null).getResult();
                return paramVarArgs;
            } catch (AuthenticatorException paramVarArgs) {
                AQUtility.debug(paramVarArgs);
                return null;
            } catch (Exception paramVarArgs) {
                AQUtility.debug(paramVarArgs);
                return null;
            } catch (OperationCanceledException paramVarArgs) {
            }
            return null;
        }

        protected void onPostExecute(Bundle paramBundle) {
            if ((paramBundle != null) && (paramBundle.containsKey("authtoken"))) {
                GoogleHandle.this.token = paramBundle.getString("authtoken");
                GoogleHandle.this.success(GoogleHandle.this.act);
                return;
            }
            GoogleHandle.this.failure(GoogleHandle.this.act, -102, "rejected");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/androidquery/auth/GoogleHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */