package mobi.ifunny.social.auth.b;

import android.os.Bundle;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Users;
import mobi.ifunny.social.auth.AuthHelper.AuthInfo;
import mobi.ifunny.social.auth.n;
import mobi.ifunny.social.auth.y;

public class j
        extends d {
    protected final int h = 5;
    private AuthHelper.AuthInfo i;
    private String j;
    private String k;
    private final String l = "STATE_INFO";
    private final String m = "STATE_UID";
    private final String n = "STATE_ACCESS_TOKEN";
    private final String o = "REGISTER_GPLUS_TASK";

    private void a(RestError paramRestError) {
        if (paramRestError != null) {
            a(paramRestError.error, g(), null);
            return;
        }
        a(g());
    }

    private void o() {
        if (this.b != 0) {
            b();
            return;
        }
        IFunnyRestRequest.Users.registerGPlus(this, "REGISTER_GPLUS_TASK", this.i.a, this.i.b, this.j, this.k, new l(null));
    }

    private void s() {
        this.b = 5;
    }

    private void t() {
        k().b();
    }

    private void u() {
        this.b = 0;
        e();
    }

    protected void a(String paramString1, String paramString2, n paramn) {
        super.a(paramString1, paramString2, paramn);
        k().a(paramString1, paramString2);
    }

    protected void a(String paramString, n paramn) {
        super.a(paramString, paramn);
        this.j = paramn.a;
        this.k = paramString;
        o();
    }

    public void a(AuthHelper.AuthInfo paramAuthInfo) {
        this.i = paramAuthInfo;
        d();
        b(true);
    }

    protected void b() {
        if (this.b != 5) {
            a(new String[]{"REGISTER_GPLUS_TASK"});
        }
        k().P_();
        super.b();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (paramBundle != null) {
            this.i = ((AuthHelper.AuthInfo) paramBundle.getParcelable("STATE_INFO"));
            this.j = paramBundle.getString("STATE_UID");
            this.k = paramBundle.getString("STATE_ACCESS_TOKEN");
        }
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putParcelable("STATE_INFO", this.i);
        paramBundle.putString("STATE_UID", this.j);
        paramBundle.putString("STATE_ACCESS_TOKEN", this.k);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */