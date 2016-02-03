package mobi.ifunny.profile;

import android.os.Bundle;
import android.support.v7.a.a;
import android.text.TextUtils;
import mobi.ifunny.d;
import mobi.ifunny.main.i;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Account;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Users;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.social.auth.l;

public abstract class b
        extends i {
    protected static final RestHttpHandler<User, b> g = new c();
    private static final String h = b.class.getSimpleName();
    protected User a;
    protected String b;
    protected String c;
    protected boolean d;
    protected boolean e;
    protected boolean f;

    protected void a(RestError paramRestError) {
        this.f = true;
        c();
    }

    protected void a(User paramUser) {
    }

    protected void b() {
        if (f("profile")) {
            d.d(h, "Do not request profile - already running");
            return;
        }
        if (this.d) {
            d.c(h, "Request own profile");
            IFunnyRestRequest.Account.get(this, "profile", g);
            return;
        }
        if (TextUtils.isEmpty(this.b)) {
            d.c(h, "Request profile by nick " + this.c);
            IFunnyRestRequest.Users.getByNick(this, "profile", this.c, g);
            return;
        }
        d.c(h, "Request profile by uid " + this.b);
        IFunnyRestRequest.Users.get(this, "profile", this.b, g);
    }

    protected void b(User paramUser) {
        this.a = paramUser;
        if (this.e) {
            this.b = paramUser.id;
            this.d = TextUtils.equals(this.b, l.a().d());
        }
        if (this.d) {
            l.a().a(getActivity(), paramUser);
        }
        a(paramUser);
    }

    protected void c() {
    }

    public boolean i() {
        return false;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        paramBundle = a();
        if (this.d) {
        }
        for (int i = 2131689844; ; i = 2131689877) {
            paramBundle.a(getString(i));
            return;
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        boolean bool1;
        label60:
        String str;
        StringBuilder localStringBuilder;
        if (paramBundle == null) {
            paramBundle = getArguments();
            this.b = paramBundle.getString("uid");
            this.c = paramBundle.getString("nick");
            boolean bool2 = TextUtils.isEmpty(this.b);
            bool1 = TextUtils.isEmpty(this.c);
            if ((!bool2) || (bool1)) {
                break label165;
            }
            bool1 = true;
            this.e = bool1;
            if (!bool2) {
                this.d = TextUtils.equals(this.b, l.a().d());
                str = h;
                localStringBuilder = new StringBuilder().append("onCreate ").append(this.b).append(" ");
                if (!this.d) {
                    break label170;
                }
            }
        }
        label165:
        label170:
        for (paramBundle = "is mine"; ; paramBundle = "is another's") {
            d.c(str, paramBundle);
            return;
            this.b = paramBundle.getString("intent.uid");
            this.c = paramBundle.getString("intent.nick");
            break;
            bool1 = false;
            break label60;
        }
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putParcelable("state.profile", this.a);
        paramBundle.putString("intent.uid", this.b);
        paramBundle.putString("intent.nick", this.c);
        paramBundle.putBoolean("state.banned", this.f);
    }

    public void onViewStateRestored(Bundle paramBundle) {
        super.onViewStateRestored(paramBundle);
        if (paramBundle != null) {
            this.a = ((User) paramBundle.getParcelable("state.profile"));
            this.f = paramBundle.getBoolean("state.banned");
        }
        if ((this.a == null) && (!this.f)) {
            b();
            return;
        }
        if (this.f) {
            c();
            return;
        }
        a(this.a);
    }

    public boolean y() {
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */