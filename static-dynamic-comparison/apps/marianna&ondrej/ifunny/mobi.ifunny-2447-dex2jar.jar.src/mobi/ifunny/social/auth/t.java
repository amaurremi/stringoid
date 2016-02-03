package mobi.ifunny.social.auth;

import android.os.Bundle;
import android.support.v4.app.k;
import mobi.ifunny.b.g;
import mobi.ifunny.rest.content.AccessToken;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Account;

public abstract class t
        extends f {
    protected final int c = 1;
    protected final int d = 2;
    protected AccessToken e;
    private final String f = "STATE_ACCESS_TOKEN";

    protected void a(String paramString1, String paramString2) {
        z localz = m();
        if (localz != null) {
            localz.a(paramString1, paramString2);
        }
    }

    protected abstract void a(AccessToken paramAccessToken);

    protected void a(User paramUser) {
        this.b = 0;
    }

    protected void a(n paramn) {
        z localz = m();
        if (localz != null) {
            localz.a(paramn);
        }
    }

    protected void b() {
        e();
        this.b = 0;
        switch (this.b) {
            default:
                return;
        }
        a(new String[]{"TASK_GET_ACCOUNT"});
    }

    protected void b(AccessToken paramAccessToken) {
        this.b = 0;
        c(paramAccessToken);
        i();
        g.a(getActivity(), 1, "authed");
        g.a(getActivity(), "app_flow", "sign_in_success", h());
    }

    protected void c(AccessToken paramAccessToken) {
        this.e = paramAccessToken;
        a(paramAccessToken);
    }

    protected String h() {
        return "unknown";
    }

    protected void i() {
        if (this.b != 0) {
            b();
            return;
        }
        this.b = 2;
        IFunnyRestRequest.Account.get(this, "TASK_GET_ACCOUNT", new v(null));
    }

    protected x j() {
        k localk = getActivity();
        if ((localk instanceof x)) {
            return (x) localk;
        }
        return null;
    }

    protected y k() {
        k localk = getActivity();
        if ((localk instanceof y)) {
            return (y) localk;
        }
        return null;
    }

    protected w l() {
        k localk = getActivity();
        if ((localk instanceof w)) {
            return (w) localk;
        }
        return null;
    }

    protected z m() {
        Object localObject = getActivity();
        if ((localObject instanceof z)) {
            return (z) localObject;
        }
        localObject = getTargetFragment();
        if ((localObject != null) && ((localObject instanceof z))) {
            return (z) localObject;
        }
        return null;
    }

    protected void n() {
        z localz = m();
        if (localz != null) {
            localz.a();
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (paramBundle != null) {
            this.e = ((AccessToken) paramBundle.getParcelable("STATE_ACCESS_TOKEN"));
        }
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putParcelable("STATE_ACCESS_TOKEN", this.e);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */