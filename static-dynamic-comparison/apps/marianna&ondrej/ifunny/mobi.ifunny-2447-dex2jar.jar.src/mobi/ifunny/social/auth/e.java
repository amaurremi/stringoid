package mobi.ifunny.social.auth;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.g;

public final class e
        extends g
        implements DialogInterface.OnClickListener {
    private int j;
    private AuthHelper.AuthInfo k;

    public static e a(int paramInt, AuthHelper.AuthInfo paramAuthInfo) {
        e locale = new e();
        Bundle localBundle = new Bundle();
        localBundle.putInt("ARG_AUTH_TYPE", paramInt);
        localBundle.putParcelable("ARG_AUTH_INFO", paramAuthInfo);
        locale.setArguments(localBundle);
        return locale;
    }

    public Dialog a(Bundle paramBundle) {
        paramBundle = new AlertDialog.Builder(getActivity());
        paramBundle.setNegativeButton(2131689677, this);
        paramBundle.setPositiveButton(2131689685, this);
        paramBundle.setMessage(2131689898);
        b(true);
        return paramBundle.create();
    }

    public AuthActivityMain d() {
        return (AuthActivityMain) getActivity();
    }

    public void onCancel(DialogInterface paramDialogInterface) {
        super.onCancel(paramDialogInterface);
        AuthActivityMain.a(d());
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        if (paramInt == -2) {
            b();
            AuthActivityMain.a(d());
        }
        while (paramInt != -1) {
            return;
        }
        b();
        AuthActivityMain.a(d(), this.j, this.k);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = getArguments();
        this.j = paramBundle.getInt("ARG_AUTH_TYPE");
        this.k = ((AuthHelper.AuthInfo) paramBundle.getParcelable("ARG_AUTH_INFO"));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */