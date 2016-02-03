package mobi.ifunny.social.auth.a;

import android.os.Bundle;
import com.facebook.Response;
import com.facebook.Session;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Users;
import mobi.ifunny.social.auth.AuthHelper.AuthInfo;
import mobi.ifunny.social.auth.y;

public class l
        extends d {
    protected final int h = 5;
    private AuthHelper.AuthInfo i;
    private String j;
    private final String k = "STATE_INFO";
    private final String l = "STATE_UID";
    private final String m = "REGISTER_FACEBOOK_TASK";

    private void a(RestError paramRestError) {
        if (paramRestError != null) {
            a(paramRestError.error, g(), null);
            return;
        }
        a(g());
    }

    private void o() {
        Session localSession = Session.getActiveSession();
        IFunnyRestRequest.Users.registerFacebook(this, "REGISTER_FACEBOOK_TASK", this.i.a, this.i.b, this.j, localSession.getAccessToken(), new n(null));
    }

    private void p() {
        this.b = 5;
    }

    private void q() {
        k().b();
    }

    private void r() {
        this.b = 0;
        e();
    }

    protected void a(Bundle paramBundle) {
        paramBundle.putString("fields", "id");
    }

    protected void a(Response paramResponse, mobi.ifunny.social.auth.n paramn) {
    }

    protected void a(String paramString1, String paramString2, mobi.ifunny.social.auth.n paramn) {
        super.a(paramString1, paramString2, paramn);
        k().a(paramString1, paramString2);
    }

    public void a(AuthHelper.AuthInfo paramAuthInfo) {
        this.i = paramAuthInfo;
        d();
        b(true);
    }

    protected void b() {
        if (this.b != 5) {
            a(new String[]{"REGISTER_FACEBOOK_TASK"});
        }
        k().P_();
        super.b();
    }

    protected void b(mobi.ifunny.social.auth.n paramn) {
        super.b(paramn);
        this.j = paramn.a;
        o();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (paramBundle != null) {
            this.i = ((AuthHelper.AuthInfo) paramBundle.getParcelable("STATE_INFO"));
            this.j = paramBundle.getString("STATE_UID");
        }
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putParcelable("STATE_INFO", this.i);
        paramBundle.putString("STATE_UID", this.j);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */