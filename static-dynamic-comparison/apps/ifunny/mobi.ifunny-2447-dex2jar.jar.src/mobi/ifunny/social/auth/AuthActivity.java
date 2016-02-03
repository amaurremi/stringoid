package mobi.ifunny.social.auth;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.common.GooglePlayServicesUtil;
import mobi.ifunny.social.a.h;
import mobi.ifunny.social.auth.b.g;

public class AuthActivity
        extends AuthActivityMain
        implements View.OnClickListener {
    private void c(int paramInt) {
        q localq = f();
        h localh = (h) localq.a("GPLUS_ERROR_DIALOG_TAG");
        if (localh != null) {
            localh.b();
            localq.b();
        }
        h.a(paramInt).a(localq, "GPLUS_ERROR_DIALOG_TAG");
        localq.b();
    }

    private void p() {
        q localq = f();
        Object localObject2 = (g) localq.a("GPLUS_FRAGMENT");
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = new g();
            localObject2 = localq.a();
            ((ab) localObject2).a((Fragment) localObject1, "GPLUS_FRAGMENT");
            ((ab) localObject2).c();
            localq.b();
        }
        ((g) localObject1).a(false);
        this.rootView.setVisibility(4);
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            default:
                return;
        }
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (i != 0) {
            c(i);
            return;
        }
        this.o = 3;
        p();
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        findViewById(2131493025).setOnClickListener(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/AuthActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */