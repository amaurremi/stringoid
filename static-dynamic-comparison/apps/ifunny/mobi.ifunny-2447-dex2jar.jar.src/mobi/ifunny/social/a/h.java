package mobi.ifunny.social.a;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.g;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class h
        extends g {
    private int j;

    public static h a(int paramInt) {
        h localh = new h();
        Bundle localBundle = new Bundle();
        localBundle.putInt("ARG_ERROR_CODE", paramInt);
        localh.setArguments(localBundle);
        return localh;
    }

    public Dialog a(Bundle paramBundle) {
        paramBundle = GooglePlayServicesUtil.getErrorDialog(this.j, getActivity(), 8000);
        paramBundle.setCancelable(true);
        paramBundle.setOnCancelListener(new i(this));
        paramBundle.setCanceledOnTouchOutside(true);
        return paramBundle;
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.j = getArguments().getInt("ARG_ERROR_CODE");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */