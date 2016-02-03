package mobi.ifunny.social.auth.a;

import com.facebook.Session;
import mobi.ifunny.social.auth.aa;

public class k
        extends aa {
    protected int f() {
        return 2131689931;
    }

    public void h() {
        d();
        i();
    }

    protected void j() {
        super.j();
        Session localSession2 = Session.getActiveSession();
        Session localSession1 = localSession2;
        if (localSession2 == null) {
            localSession1 = new Session(getActivity());
        }
        localSession1.closeAndClearTokenInformation();
        k();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */