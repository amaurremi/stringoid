package mobi.ifunny.profile.settings;

import android.support.v4.app.Fragment;
import android.support.v4.app.ab;
import android.support.v4.app.k;
import android.support.v4.app.q;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.common.GooglePlayServicesUtil;
import mobi.ifunny.rest.content.UserSocials.ProfileSocialState;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Account;
import mobi.ifunny.social.a.h;
import mobi.ifunny.social.auth.b.a;
import mobi.ifunny.social.auth.b.b;
import mobi.ifunny.social.auth.n;

public class e
        extends ProfileSettingsFragmentMain
        implements b {
    private void m() {
        q localq = getActivity().f();
        b("append_gplus");
        Object localObject2 = (a) localq.a("GPLUS_FRAGMENT");
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = new a();
            localObject2 = localq.a();
            ((ab) localObject2).a((Fragment) localObject1, "GPLUS_FRAGMENT");
            ((ab) localObject2).c();
            localq.b();
        }
        ((a) localObject1).setTargetFragment(this, 0);
        ((a) localObject1).a(false);
    }

    protected void a(int paramInt) {
        q localq = getChildFragmentManager();
        h localh = (h) localq.a("GPLUS_ERROR_DIALOG_TAG");
        if (localh != null) {
            localh.b();
            localq.b();
        }
        h.a(paramInt).a(localq, "GPLUS_ERROR_DIALOG_TAG");
        localq.b();
    }

    public void a(String paramString1, String paramString2, n paramn) {
        if (!TextUtils.isEmpty(paramString2)) {
            Toast.makeText(mobi.ifunny.e.a, paramString2, 1).show();
        }
        for (; ; ) {
            l();
            return;
            Toast.makeText(mobi.ifunny.e.a, 2131689929, 1).show();
        }
    }

    public void a(n paramn, String paramString) {
        IFunnyRestRequest.Account.socialsPut(this, "append_gplus", new g(paramn.b, paramn.a, null), "gplus", paramn.a, paramString, null, false);
    }

    public void d() {
        l();
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            default:
                super.onClick(paramView);
                return;
        }
        if (!this.h.isGPlusConnected()) {
            int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity());
            if (i != 0) {
                a(i);
                return;
            }
            m();
            return;
        }
        super.onClick(paramView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/settings/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */