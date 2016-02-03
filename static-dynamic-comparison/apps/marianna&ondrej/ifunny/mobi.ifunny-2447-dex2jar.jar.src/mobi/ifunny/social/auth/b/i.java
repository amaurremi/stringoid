package mobi.ifunny.social.auth.b;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import mobi.ifunny.social.a.a;
import mobi.ifunny.social.a.c;
import mobi.ifunny.social.a.d;
import mobi.ifunny.social.a.f;
import mobi.ifunny.social.auth.aa;
import mobi.ifunny.social.auth.n;

public class i
        extends aa
        implements c, d, f {
    private a d;
    private int e = 4;

    protected void a(String paramString1, String paramString2, n paramn) {
        super.a(paramString1, paramString2, paramn);
        this.d.e();
    }

    protected void b() {
        if (this.b == this.e) {
            this.d.e();
        }
        super.b();
    }

    public void b(String paramString) {
        String str = paramString;
        if (TextUtils.isEmpty(paramString)) {
            str = g();
        }
        a(str);
    }

    protected int f() {
        return 2131689945;
    }

    public void h() {
        d();
        i();
    }

    protected void j() {
        super.j();
        if (this.b != 0) {
            b();
        }
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()) == 0) {
            this.b = this.e;
            this.d.d();
            return;
        }
        k();
    }

    public void m() {
        this.b = 0;
        k();
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        this.d.a(paramInt1, paramInt2, paramIntent);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.d = new a();
        this.d.a(null, this, this, this, paramBundle);
    }

    public void onDestroy() {
        super.onDestroy();
        this.d.a();
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        this.d.b(paramBundle);
    }

    public Fragment p() {
        return this;
    }

    public void r() {
        b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */