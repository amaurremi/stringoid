package mobi.ifunny.social.auth;

import android.support.v4.app.Fragment;
import mobi.ifunny.b.g;
import mobi.ifunny.rest.retrofit.IFunnyOAuthRequest;

public abstract class aa
        extends f {
    protected final int c = 3;
    private final String d = "TASK_LOGOUT_IFUNNY";

    protected void a(String paramString1, String paramString2, n paramn) {
        super.a(paramString1, paramString2, paramn);
        l().a(paramString1, paramString2);
    }

    protected void b() {
        if (this.b != 3) {
            a(new String[]{"TASK_LOGOUT_IFUNNY"});
        }
        l().k();
        super.b();
    }

    public abstract void h();

    protected void i() {
        if (this.b != 0) {
            return;
        }
        this.b = 3;
        IFunnyOAuthRequest.revokeToken(this, "TASK_LOGOUT_IFUNNY", l.a().b(), new ab());
    }

    protected void j() {
        this.b = 0;
        l.a().b(getActivity());
    }

    protected void k() {
        this.b = 0;
        l().j();
        g.a(getActivity(), 1, "guest");
    }

    protected ac l() {
        Fragment localFragment = getParentFragment();
        if ((localFragment instanceof ac)) {
            return (ac) localFragment;
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */