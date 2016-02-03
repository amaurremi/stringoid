package mobi.ifunny.social.auth;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mobi.ifunny.fragment.h;
import mobi.ifunny.rest.content.AccessToken;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Users;
import mobi.ifunny.social.auth.c.b;
import mobi.ifunny.social.auth.c.e;
import mobi.ifunny.social.auth.d.j;
import mobi.ifunny.social.auth.d.m;

@SuppressLint({"Registered"})
public class RegisterActivityMain
        extends mobi.ifunny.l.a
        implements View.OnClickListener, x, y {
    private static HashMap<String, Integer> C = new ai();
    private static int q;
    private static int r;
    private static int s;
    private static int t;
    private static final Pattern w = Pattern.compile(".+@.+\\..+");
    private final String A = "STATE_AUTH_INFO";
    private final String B = "STATE_CHECKING";
    @InjectView(2131493084)
    protected View cancel;
    @InjectView(2131493085)
    protected View done;
    @InjectView(2131493086)
    protected TextView doneText;
    @InjectView(2131493159)
    protected View emailBottomLine;
    @InjectView(2131493029)
    protected EditText emailEdit;
    @InjectView(2131493285)
    protected View nickBottomLine;
    @InjectView(2131493284)
    protected ImageView nickChecked;
    @InjectView(2131493283)
    protected EditText nickEdit;
    protected int o;
    protected AuthHelper.AuthInfo p;
    @InjectView(2131493162)
    protected EditText passEdit;
    @InjectView(2131493160)
    protected View passLayout;
    @InjectView(2131493163)
    protected View passwordBottomLine;
    private boolean u;
    private boolean v;
    private am x;
    private TextWatcher y = new af(this);
    private View.OnFocusChangeListener z = new ag(this);

    private void D() {
        a(am.b);
    }

    private void E() {
        if (this.nickEdit.getText().toString().trim().length() > 0) {
            this.nickEdit.setTextColor(t);
            return;
        }
        F();
    }

    private void F() {
        EditText localEditText = this.nickEdit;
        if (this.u) {
        }
        for (int i = q; ; i = r) {
            localEditText.setTextColor(i);
            return;
        }
    }

    private boolean G() {
        if ((TextUtils.isEmpty(this.emailEdit.getText())) || (!w.matcher(this.emailEdit.getText()).matches())) {
            this.emailEdit.setTextColor(t);
            return false;
        }
        EditText localEditText = this.emailEdit;
        if (this.v) {
        }
        for (int i = q; ; i = r) {
            localEditText.setTextColor(i);
            return true;
        }
    }

    private void H() {
        a(am.b);
        o();
    }

    private AuthHelper.AuthInfo a(i... paramVarArgs) {
        AuthHelper.AuthInfo localAuthInfo = new AuthHelper.AuthInfo();
        int j = paramVarArgs.length;
        int i = 0;
        if (i < j) {
            i locali = paramVarArgs[i];
            switch (aj.b[locali.ordinal()]) {
            }
            for (; ; ) {
                i += 1;
                break;
                localAuthInfo.b = this.emailEdit.getText().toString().trim();
                continue;
                localAuthInfo.a = this.nickEdit.getText().toString().trim();
                continue;
                localAuthInfo.c = this.passEdit.getText().toString();
            }
        }
        return localAuthInfo;
    }

    private void a(AuthHelper.AuthInfo paramAuthInfo, i... paramVarArgs) {
        if ((AuthHelper.a(paramAuthInfo, paramVarArgs) != null) || (!G())) {
            this.done.setOnClickListener(null);
            this.done.setBackgroundResource(2130837806);
            this.doneText.setAlpha(0.35F);
            return;
        }
        this.done.setOnClickListener(this);
        this.done.setBackgroundResource(2130837805);
        this.doneText.setAlpha(1.0F);
    }

    private void a(am paramam) {
        this.x = paramam;
        switch (aj.a[this.x.ordinal()]) {
            default:
                return;
            case 1:
                E();
                paramam = this.nickChecked.getDrawable();
                paramam.setLevel(1);
                this.nickChecked.invalidateDrawable(paramam);
                return;
            case 2:
                F();
                paramam = this.nickChecked.getDrawable();
                paramam.setLevel(0);
                this.nickChecked.invalidateDrawable(paramam);
                return;
        }
        F();
        paramam = this.nickChecked.getDrawable();
        paramam.setLevel(1);
        this.nickChecked.invalidateDrawable(paramam);
    }

    private void b(int paramInt) {
        this.o = paramInt;
        switch (this.o) {
            default:
                return;
            case 0:
                this.passLayout.setVisibility(8);
                this.passwordBottomLine.setVisibility(8);
                return;
            case 1:
                this.passLayout.setVisibility(8);
                this.passwordBottomLine.setVisibility(8);
                return;
        }
        this.passLayout.setVisibility(0);
        this.passwordBottomLine.setVisibility(0);
    }

    private void c(String paramString) {
        if (e("CHECK_NICK_TAG")) {
            b(new String[]{"CHECK_NICK_TAG"});
        }
        IFunnyRestRequest.Users.checkNick(this, "CHECK_NICK_TAG", paramString, new al(null));
    }

    private void f(String paramString) {
        if (e("CHECK_NICK_TAG")) {
            b(new String[]{"CHECK_NICK_TAG"});
        }
        IFunnyRestRequest.Users.checkNick(this, "CHECK_NICK_TAG", paramString, new ak(null));
    }

    private void u() {
        switch (this.o) {
            default:
                return;
            case 0:
                arrayOfi = new i[2];
                arrayOfi[0] = i.a;
                arrayOfi[1] = i.b;
                this.p = a(arrayOfi);
                a(this.p, arrayOfi);
                return;
            case 3:
                arrayOfi = new i[2];
                arrayOfi[0] = i.a;
                arrayOfi[1] = i.b;
                this.p = a(arrayOfi);
                a(this.p, arrayOfi);
                return;
            case 1:
                arrayOfi = new i[2];
                arrayOfi[0] = i.a;
                arrayOfi[1] = i.b;
                this.p = a(arrayOfi);
                a(this.p, arrayOfi);
                return;
        }
        i[] arrayOfi = new i[3];
        arrayOfi[0] = i.a;
        arrayOfi[1] = i.b;
        arrayOfi[2] = i.c;
        this.p = a(arrayOfi);
        a(this.p, arrayOfi);
    }

    private void v() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.nickEdit.getWindowToken(), 0);
        switch (this.o) {
        }
        for (; ; ) {
            f(this.p.a);
            return;
            this.p = a(new i[]{i.a, i.b});
            continue;
            this.p = a(new i[]{i.a, i.b});
            continue;
            this.p = a(new i[]{i.a, i.b});
            continue;
            this.p = a(new i[]{i.a, i.b, i.c});
        }
    }

    private void w() {
        a(am.a);
    }

    public void P_() {
    }

    protected void a() {
        super.a();
        if (this.nickEdit.hasFocus()) {
            this.nickEdit.postDelayed(new ah(this), 100L);
        }
    }

    protected void a(android.support.v7.a.a parama) {
    }

    public void a(String paramString1, String paramString2) {
        if (C.containsKey(paramString1)) {
            paramString2 = getResources().getString(((Integer) C.get(paramString1)).intValue());
        }
        Toast.makeText(this, paramString2, 0).show();
        mobi.ifunny.b.g.a(this, "app_flow", "sign_up_fail", p());
    }

    public void a(String paramString1, String paramString2, n paramn) {
        if (TextUtils.equals(paramString1, "invalid_grant")) {
            Toast.makeText(this, 2131689902, 0).show();
        }
        for (; ; ) {
            finish();
            return;
            if (!TextUtils.isEmpty(paramString2)) {
                Toast.makeText(this, paramString2, 0).show();
            }
        }
    }

    public void a(AccessToken paramAccessToken, User paramUser) {
        l.a().a(this, paramAccessToken, this.o, paramUser);
        Toast.makeText(this, 2131689904, 0).show();
        setResult(-1);
        finish();
    }

    public void b() {
        mobi.ifunny.b.g.a(this, "app_flow", "sign_up_success", p());
        switch (this.o) {
            default:
                return;
            case 0:
                localObject2 = (mobi.ifunny.social.auth.a.i) f().a("FACEBOOK_LOGIN_TAG");
                localObject1 = localObject2;
                if (localObject2 == null) {
                    localObject2 = f().a();
                    localObject1 = new mobi.ifunny.social.auth.a.i();
                    ((ab) localObject2).a((Fragment) localObject1, "FACEBOOK_LOGIN_TAG");
                    ((ab) localObject2).b();
                    f().b();
                }
                ((mobi.ifunny.social.auth.a.i) localObject1).a(true);
                return;
            case 1:
                localObject2 = (j) f().a("TWITTER_LOGIN_TAG");
                localObject1 = localObject2;
                if (localObject2 == null) {
                    localObject2 = f().a();
                    localObject1 = new j();
                    ((ab) localObject2).a((Fragment) localObject1, "TWITTER_LOGIN_TAG");
                    ((ab) localObject2).b();
                    f().b();
                }
                ((j) localObject1).a(true);
                return;
        }
        Object localObject2 = (b) f().a("PASSWORD_LOGIN_TAG");
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject2 = f().a();
            localObject1 = new b();
            ((ab) localObject2).a((Fragment) localObject1, "PASSWORD_LOGIN_TAG");
            ((ab) localObject2).b();
            f().b();
        }
        ((b) localObject1).a(this.p);
    }

    protected void b(String paramString) {
        h.a(this, false, new String[]{paramString}).a(f(), "dialog.loading");
    }

    public void n() {
        finish();
    }

    protected void o() {
        switch (this.o) {
            default:
                return;
            case 0:
                localObject2 = (mobi.ifunny.social.auth.a.l) f().a("FACEBOOK_REGISTER_TAG");
                localObject1 = localObject2;
                if (localObject2 == null) {
                    localObject1 = new mobi.ifunny.social.auth.a.l();
                    localObject2 = f().a();
                    ((ab) localObject2).a((Fragment) localObject1, "FACEBOOK_REGISTER_TAG");
                    ((ab) localObject2).c();
                    f().b();
                }
                ((mobi.ifunny.social.auth.a.l) localObject1).a(this.p);
                return;
            case 1:
                localObject2 = (m) f().a("TWITTER_REGISTER_TAG");
                localObject1 = localObject2;
                if (localObject2 == null) {
                    localObject1 = new m();
                    localObject2 = f().a();
                    ((ab) localObject2).a((Fragment) localObject1, "TWITTER_REGISTER_TAG");
                    ((ab) localObject2).c();
                    f().b();
                }
                ((m) localObject1).a(this.p);
                return;
        }
        Object localObject2 = (e) f().a("PASSWORD_REGISTER_TAG");
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = new e();
            localObject2 = f().a();
            ((ab) localObject2).a((Fragment) localObject1, "PASSWORD_REGISTER_TAG");
            ((ab) localObject2).c();
            f().b();
        }
        ((e) localObject1).a(this.p);
    }

    public void onBackPressed() {
        super.onBackPressed();
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.nickEdit.getWindowToken(), 0);
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            default:
                return;
            case 2131493084:
                finish();
                return;
        }
        v();
    }

    @SuppressLint({"WrongViewCast"})
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        getWindow().setFlags(8192, 8192);
        setContentView(2130903156);
        ButterKnife.inject(this);
        Object localObject = getIntent();
        this.o = ((Intent) localObject).getIntExtra("INTENT_AUTH_TYPE", -1);
        if (this.o == -1) {
            throw new IllegalArgumentException();
        }
        this.p = ((AuthHelper.AuthInfo) ((Intent) localObject).getParcelableExtra("INTENT_AUTH_INFO"));
        this.cancel.setOnClickListener(this);
        this.doneText.setText(getResources().getString(2131689926));
        this.nickEdit.setFilters(new InputFilter[]{new mobi.ifunny.util.am()});
        localObject = getResources();
        t = ((Resources) localObject).getColor(2131361861);
        q = ((Resources) localObject).getColor(2131361883);
        r = ((Resources) localObject).getColor(2131361848);
        s = ((Resources) localObject).getColor(2131361835);
        a(am.c);
        this.nickEdit.addTextChangedListener(new ae(this));
        this.emailEdit.setFilters(new InputFilter[]{new mobi.ifunny.util.ak()});
        this.emailEdit.addTextChangedListener(this.y);
        this.passEdit.addTextChangedListener(this.y);
        this.nickEdit.setOnFocusChangeListener(this.z);
        this.emailEdit.setOnFocusChangeListener(this.z);
        this.passEdit.setOnFocusChangeListener(this.z);
        u();
        b(this.o);
        if (paramBundle == null) {
            if (this.p != null) {
                if (!TextUtils.isEmpty(this.p.b)) {
                    this.emailEdit.setText(this.p.b);
                }
                if (!TextUtils.isEmpty(this.p.a)) {
                    this.nickEdit.setText(this.p.a);
                    this.nickEdit.setSelection(this.nickEdit.getText().length());
                }
            }
            if ((this.p == null) || (TextUtils.isEmpty(this.p.b))) {
                paramBundle = mobi.ifunny.util.ai.a(this);
                if (!TextUtils.isEmpty(paramBundle)) {
                    this.emailEdit.setText(paramBundle);
                }
            }
            paramBundle = this.nickEdit.getText().toString().trim();
            if (paramBundle.length() > 0) {
                c(paramBundle);
            }
            this.nickEdit.setFocusableInTouchMode(true);
            this.nickEdit.requestFocus();
        }
    }

    protected void onRestoreInstanceState(Bundle paramBundle) {
        super.onRestoreInstanceState(paramBundle);
        this.p = ((AuthHelper.AuthInfo) paramBundle.getParcelable("STATE_AUTH_INFO"));
        a((am) paramBundle.getSerializable("STATE_CHECKING"));
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putParcelable("STATE_AUTH_INFO", this.p);
        paramBundle.putSerializable("STATE_CHECKING", this.x);
    }

    @OnClick({2131493288})
    public void onTermsOfServiceClick(View paramView) {
        paramView = new Intent("android.intent.action.VIEW");
        paramView.setData(Uri.parse("http://ifunny.mobi/docs/TOS/"));
        startActivity(paramView);
    }

    protected String p() {
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

    protected void q() {
        android.support.v4.app.g localg = (android.support.v4.app.g) f().a("dialog.loading");
        if (localg != null) {
            localg.b();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/RegisterActivityMain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */