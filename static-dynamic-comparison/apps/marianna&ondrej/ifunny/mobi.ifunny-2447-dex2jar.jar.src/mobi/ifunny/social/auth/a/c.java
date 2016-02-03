package mobi.ifunny.social.auth.a;

import android.net.Uri;
import android.support.v4.app.Fragment;
import mobi.ifunny.social.auth.n;
import mobi.ifunny.social.auth.w;

public class c
        extends d {
    protected void a(String paramString1, String paramString2, n paramn) {
        super.a(paramString1, paramString2, paramn);
        l().a(getTargetRequestCode(), paramString1, paramString2);
    }

    protected void b() {
        super.b();
        l().b(getTargetRequestCode());
    }

    protected void b(n paramn) {
        super.b(paramn);
        e();
        l().a(getTargetRequestCode(), Uri.parse(paramn.c));
    }

    protected w l() {
        Fragment localFragment = getTargetFragment();
        if ((localFragment instanceof w)) {
            return (w) localFragment;
        }
        return null;
    }

    public void o() {
        d();
        b(false);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */