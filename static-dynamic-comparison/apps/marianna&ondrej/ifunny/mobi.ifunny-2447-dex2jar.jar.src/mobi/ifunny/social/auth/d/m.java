package mobi.ifunny.social.auth.d;

import android.os.Bundle;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Users;
import mobi.ifunny.social.auth.AuthHelper.AuthInfo;
import mobi.ifunny.social.auth.n;
import mobi.ifunny.social.auth.y;
import mobi.ifunny.social.b.b;

public class m
        extends d {
    protected final int f = 6;
    private AuthHelper.AuthInfo g;
    private String h;
    private final String i = "STATE_INFO";
    private final String j = "STATE_UID";
    private final String k = "REGISTER_TWITTER_TASK";

    private void a(RestError paramRestError) {
        if (paramRestError != null) {
            a(paramRestError.error, g(), null);
            return;
        }
        a(g());
    }

    private void o() {
        b localb = b.a();
        IFunnyRestRequest.Users.registerTwitter(this, "REGISTER_TWITTER_TASK", this.g.a, this.g.b, this.h, localb.b(), localb.c(), new o(null));
    }

    private void q() {
        this.b = 6;
    }

    private void r() {
        k().b();
    }

    private void s() {
        this.b = 0;
        e();
    }

    protected void a(String paramString1, String paramString2, n paramn) {
        super.a(paramString1, paramString2, paramn);
        k().a(paramString1, paramString2);
    }

    public void a(AuthHelper.AuthInfo paramAuthInfo) {
        this.g = paramAuthInfo;
        d();
        b(true);
    }

    protected void a(g paramg) {
        super.a(paramg);
        this.h = paramg.b().a;
        o();
    }

    protected void b() {
        if (this.b != 6) {
            a(new String[]{"REGISTER_TWITTER_TASK"});
        }
        k().P_();
        super.b();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (paramBundle != null) {
            this.g = ((AuthHelper.AuthInfo) paramBundle.getParcelable("STATE_INFO"));
            this.h = paramBundle.getString("STATE_UID");
        }
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putParcelable("STATE_INFO", this.g);
        paramBundle.putString("STATE_UID", this.h);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/d/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */