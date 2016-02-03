package mobi.ifunny.social.auth;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import android.support.v7.a.a;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import mobi.ifunny.b.g;
import mobi.ifunny.f;
import mobi.ifunny.rest.content.AccessToken;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.social.auth.a.i;
import mobi.ifunny.social.auth.d.j;

@SuppressLint({"Registered"})
public class AuthActivityMain
        extends f
        implements x {
    protected int o;
    private final String p = "STATE_AUTH_TYPE";
    private final String q = "STATE_ROOT_VISIBLE";
    @InjectView(2131493008)
    protected View rootView;

    private void a(int paramInt, AuthHelper.AuthInfo paramAuthInfo) {
        Intent localIntent = new Intent(this, RegisterActivity.class);
        localIntent.putExtra("INTENT_AUTH_TYPE", paramInt);
        localIntent.putExtra("INTENT_AUTH_INFO", paramAuthInfo);
        startActivityForResult(localIntent, 0);
    }

    private void a(n paramn) {
        e locale = (e) f().a("NOT_REGISTERED_DIALOG");
        Object localObject = locale;
        if (locale == null) {
            localObject = new AuthHelper.AuthInfo();
            ((AuthHelper.AuthInfo) localObject).a = paramn.b;
            localObject = e.a(this.o, (AuthHelper.AuthInfo) localObject);
        }
        ((e) localObject).a(f(), "NOT_REGISTERED_DIALOG");
    }

    private void p() {
        Object localObject2 = (i) f().a("FACEBOOK_FRAGMENT");
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = new i();
            localObject2 = f().a();
            ((ab) localObject2).a((Fragment) localObject1, "FACEBOOK_FRAGMENT");
            ((ab) localObject2).c();
            f().b();
        }
        ((i) localObject1).a(false);
        this.rootView.setVisibility(4);
    }

    private void q() {
        Object localObject2 = (j) f().a("TWITTER_FRAGMENT");
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = new j();
            localObject2 = f().a();
            ((ab) localObject2).a((Fragment) localObject1, "TWITTER_FRAGMENT");
            ((ab) localObject2).c();
            f().b();
        }
        ((j) localObject1).a(false);
        this.rootView.setVisibility(4);
    }

    private void r() {
        startActivityForResult(new Intent(this, LoginActivity.class), 1);
    }

    private void s() {
        this.rootView.setVisibility(0);
    }

    protected void a(a parama) {
    }

    public void a(String paramString1, String paramString2, n paramn) {
        if (TextUtils.equals(paramString1, "invalid_grant")) {
            a(paramn);
        }
        do {
            return;
            g.a(this, "app_flow", "sign_in_fail", o());
            this.rootView.setVisibility(0);
        } while (TextUtils.isEmpty(paramString2));
        Toast.makeText(this, paramString2, 0).show();
    }

    public void a(AccessToken paramAccessToken, User paramUser) {
        l.a().a(this, paramAccessToken, this.o, paramUser);
        Toast.makeText(this, 2131689904, 0).show();
        b(-1);
    }

    protected void b(int paramInt) {
        Object localObject = getIntent();
        if (((Intent) localObject).hasExtra("intent.callback.params")) {
            localObject = ((Intent) localObject).getBundleExtra("intent.callback.params");
            Intent localIntent = new Intent();
            localIntent.putExtras((Bundle) localObject);
            setResult(paramInt, localIntent);
        }
        for (; ; ) {
            finish();
            return;
            setResult(paramInt);
        }
    }

    public void n() {
        this.rootView.setVisibility(0);
    }

    protected String o() {
        switch (this.o) {
            default:
                return "unknown";
            case 0:
                return "facebook";
            case 3:
                return "gplus";
            case 1:
                return "twitter";
        }
        return "password";
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        switch (paramInt1) {
            default:
                super.onActivityResult(paramInt1, paramInt2, paramIntent);
                return;
        }
        b(paramInt2);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903070);
        getWindow().getAttributes().dimAmount = 0.8F;
        getWindow().addFlags(2);
        ButterKnife.inject(this);
        if (paramBundle == null) {
            g.a(this, "SignUp");
        }
    }

    @OnClick({2131493023})
    public void onFacebookClick(View paramView) {
        this.o = 0;
        p();
    }

    @OnClick({2131493029})
    public void onLoginClick(View paramView) {
        r();
    }

    protected void onRestoreInstanceState(Bundle paramBundle) {
        super.onRestoreInstanceState(paramBundle);
        this.o = paramBundle.getInt("STATE_AUTH_TYPE", -1);
        boolean bool = paramBundle.getBoolean("STATE_ROOT_VISIBLE");
        paramBundle = this.rootView;
        if (bool) {
        }
        for (int i = 0; ; i = 4) {
            paramBundle.setVisibility(i);
            return;
        }
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putInt("STATE_AUTH_TYPE", this.o);
        if (this.rootView.getVisibility() == 0) {
        }
        for (boolean bool = true; ; bool = false) {
            paramBundle.putBoolean("STATE_ROOT_VISIBLE", bool);
            return;
        }
    }

    @OnClick({2131493027})
    public void onSignUpClick(View paramView) {
        this.o = 2;
        a(this.o, null);
    }

    @OnClick({2131493024})
    public void onTwitterClick(View paramView) {
        this.o = 1;
        q();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/AuthActivityMain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */