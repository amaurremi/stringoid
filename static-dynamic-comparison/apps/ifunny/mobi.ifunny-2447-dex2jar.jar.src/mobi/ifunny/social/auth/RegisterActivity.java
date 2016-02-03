package mobi.ifunny.social.auth;

import android.support.v4.app.Fragment;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import com.google.android.gms.common.GooglePlayServicesUtil;
import mobi.ifunny.b.e;
import mobi.ifunny.social.a.h;
import mobi.ifunny.social.auth.b.j;

public class RegisterActivity
        extends RegisterActivityMain {
    private void b(int paramInt) {
        q localq = f();
        h localh = (h) localq.a("GPLUS_ERROR_DIALOG_TAG");
        if (localh != null) {
            localh.b();
            localq.b();
        }
        h.a(paramInt).a(localq, "GPLUS_ERROR_DIALOG_TAG");
        localq.b();
    }

    public void b() {
        switch (this.o) {
            default:
                super.b();
        }
        for (; ; ) {
            e.c();
            return;
            Object localObject2 = (mobi.ifunny.social.auth.b.g) f().a("GPLUS_LOGIN_TAG");
            Object localObject1 = localObject2;
            if (localObject2 == null) {
                localObject2 = f().a();
                localObject1 = new mobi.ifunny.social.auth.b.g();
                ((ab) localObject2).a((Fragment) localObject1, "GPLUS_LOGIN_TAG");
                ((ab) localObject2).b();
                f().b();
            }
            ((mobi.ifunny.social.auth.b.g) localObject1).a(true);
            mobi.ifunny.b.g.a(this, "app_flow", "sign_up_success", "gplus");
        }
    }

    protected void o() {
        switch (this.o) {
            default:
                super.o();
                return;
        }
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (i != 0) {
            b(i);
            return;
        }
        Object localObject2 = (j) f().a("GPLUS_REGISTER_TAG");
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = new j();
            localObject2 = f().a();
            ((ab) localObject2).a((Fragment) localObject1, "GPLUS_REGISTER_TAG");
            ((ab) localObject2).c();
            f().b();
        }
        ((j) localObject1).a(this.p);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/RegisterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */