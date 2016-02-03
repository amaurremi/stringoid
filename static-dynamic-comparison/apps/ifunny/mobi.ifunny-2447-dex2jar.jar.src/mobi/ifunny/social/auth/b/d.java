package mobi.ifunny.social.auth.b;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import mobi.ifunny.rest.content.AccessToken;
import mobi.ifunny.social.a.c;
import mobi.ifunny.social.a.e;
import mobi.ifunny.social.auth.l;
import mobi.ifunny.social.auth.n;
import mobi.ifunny.social.auth.t;

public class d
        extends t
        implements c, mobi.ifunny.social.a.d, e {
    private static String i = "TASK_GET_TOKEN";
    protected final int f = 3;
    protected final int g = 4;
    private mobi.ifunny.social.a.a h;

    private void b(String paramString, n paramn) {
        this.b = 0;
        a(paramString, paramn);
    }

    private void b(n paramn) {
        if (this.b != 0) {
            b();
            return;
        }
        this.b = 3;
        new f(this, i, this.h.c(), paramn, new String[]{"https://www.googleapis.com/auth/plus.login"}, null).execute(new Void[0]);
    }

    private void o() {
        if (this.b != 0) {
            b();
            return;
        }
        this.b = 4;
        com.google.android.gms.plus.a.b.a locala = this.h.b();
        if (locala != null) {
            n localn = new n();
            localn.a = locala.f();
            localn.b = locala.e();
            localn.c = locala.g().e();
            this.b = 0;
            b(localn);
            return;
        }
        a(g());
    }

    protected void a(String paramString1, String paramString2, n paramn) {
        super.a(paramString1, paramString2, paramn);
        this.b = 0;
        this.h.e();
    }

    protected void a(String paramString, n paramn) {
        this.b = 0;
    }

    protected void a(AccessToken paramAccessToken) {
        l.a().a(getActivity(), paramAccessToken, 3);
    }

    protected void b() {
        super.b();
        switch (this.b) {
            case 2:
            default:
                return;
            case 1:
                this.h.e();
                return;
        }
        a(new String[]{i});
    }

    public void b(String paramString) {
        String str = paramString;
        if (TextUtils.isEmpty(paramString)) {
            str = g();
        }
        a(str);
    }

    protected void b(boolean paramBoolean) {
        if (this.b != 0) {
            b();
            return;
        }
        this.b = 1;
        this.h.a(paramBoolean, true);
    }

    protected int f() {
        return 2131689945;
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        this.h.a(paramInt1, paramInt2, paramIntent);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.h = new mobi.ifunny.social.a.a();
        this.h.a(this, null, this, this, paramBundle);
    }

    public void onDestroy() {
        super.onDestroy();
        this.h.a();
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        this.h.b(paramBundle);
    }

    public Fragment p() {
        return this;
    }

    public void q() {
        this.b = 0;
        o();
    }

    public void r() {
        b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */