package mobi.ifunny.social.auth.b;

import mobi.ifunny.social.auth.n;

public class a
        extends d {
    protected void a(String paramString1, String paramString2, n paramn) {
        super.a(paramString1, paramString2, paramn);
        ((b) getTargetFragment()).a(paramString1, paramString2, paramn);
    }

    protected void a(String paramString, n paramn) {
        super.a(paramString, paramn);
        ((b) getTargetFragment()).a(paramn, paramString);
    }

    public void a(boolean paramBoolean) {
        b(paramBoolean);
    }

    protected void b() {
        ((b) getTargetFragment()).d();
        super.b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */