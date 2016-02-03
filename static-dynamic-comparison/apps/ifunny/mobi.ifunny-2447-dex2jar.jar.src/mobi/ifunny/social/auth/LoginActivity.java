package mobi.ifunny.social.auth;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ab;
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
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import mobi.ifunny.b.g;
import mobi.ifunny.profile.settings.s;
import mobi.ifunny.profile.settings.u;
import mobi.ifunny.rest.content.AccessToken;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Account;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.social.auth.c.b;
import mobi.ifunny.util.ak;

public class LoginActivity
        extends mobi.ifunny.l.a
        implements View.OnClickListener, u, x {
    private static final String o = LoginActivity.class.getSimpleName();
    private static int p;
    private static int q;
    private static int r;
    private static final RestHttpHandler<Void, LoginActivity> v = new q();
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
    @InjectView(2131493162)
    protected EditText passEdit;
    @InjectView(2131493163)
    protected View passwordBottomLine;
    @InjectView(2131493165)
    protected View resetPassword;
    private AuthHelper.AuthInfo s;
    private TextWatcher t = new o(this);
    private View.OnFocusChangeListener u = new p(this);

    private AuthHelper.AuthInfo a(i... paramVarArgs) {
        AuthHelper.AuthInfo localAuthInfo = new AuthHelper.AuthInfo();
        int j = paramVarArgs.length;
        int i = 0;
        if (i < j) {
            i locali = paramVarArgs[i];
            switch (s.a[locali.ordinal()]) {
            }
            for (; ; ) {
                i += 1;
                break;
                localAuthInfo.b = this.emailEdit.getText().toString();
                continue;
                localAuthInfo.c = this.passEdit.getText().toString();
            }
        }
        return localAuthInfo;
    }

    private void a(AuthHelper.AuthInfo paramAuthInfo) {
        Object localObject2 = (b) f().a("PASSWORD_FRAGMENT");
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = new b();
            localObject2 = f().a();
            ((ab) localObject2).a((Fragment) localObject1, "PASSWORD_FRAGMENT");
            ((ab) localObject2).c();
            f().b();
        }
        ((b) localObject1).a(paramAuthInfo);
    }

    private void a(AuthHelper.AuthInfo paramAuthInfo, i... paramVarArgs) {
        if (AuthHelper.a(paramAuthInfo, paramVarArgs) != null) {
            this.done.setOnClickListener(null);
            this.done.setBackgroundResource(2130837806);
            this.doneText.setAlpha(0.35F);
            return;
        }
        this.done.setOnClickListener(this);
        this.done.setBackgroundResource(2130837805);
        this.doneText.setAlpha(1.0F);
    }

    private void r() {
        InputMethodManager localInputMethodManager = (InputMethodManager) getSystemService("input_method");
        localInputMethodManager.hideSoftInputFromWindow(this.emailEdit.getWindowToken(), 0);
        localInputMethodManager.hideSoftInputFromWindow(this.passEdit.getWindowToken(), 0);
    }

    private void s() {
        if (this.emailEdit.getText().length() == 0) {
            Toast.makeText(this, 2131689862, 1).show();
            return;
        }
        s locals = new s();
        locals.b(true);
        locals.a(f(), "dialog.reset_password");
    }

    private void t() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.emailEdit.getWindowToken(), 0);
        a(this.s);
    }

    private void u() {
        i[] arrayOfi = new i[2];
        arrayOfi[0] = i.b;
        arrayOfi[1] = i.c;
        this.s = a(arrayOfi);
        a(this.s, arrayOfi);
    }

    public void O_() {
        IFunnyRestRequest.Account.passwordChangeRequest(this, "reset_password", this.emailEdit.getText().toString(), v);
    }

    protected void a() {
        super.a();
        if (this.emailEdit.hasFocus()) {
            this.emailEdit.postDelayed(new r(this), 100L);
        }
    }

    protected void a(android.support.v7.a.a parama) {
    }

    public void a(String paramString1, String paramString2, n paramn) {
        if (TextUtils.equals(paramString1, "invalid_grant")) {
            Toast.makeText(this, 2131689902, 0).show();
        }
        while (TextUtils.isEmpty(paramString2)) {
            return;
        }
        Toast.makeText(this, paramString2, 0).show();
    }

    public void a(AccessToken paramAccessToken, User paramUser) {
        l.a().a(this, paramAccessToken, 2, paramUser);
        Toast.makeText(this, 2131689904, 0).show();
        setResult(-1);
        finish();
    }

    public void n() {
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            default:
                return;
            case 2131493165:
                r();
                s();
                return;
            case 2131493084:
                finish();
                return;
        }
        t();
    }

    @SuppressLint({"WrongViewCast"})
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        getWindow().setFlags(8192, 8192);
        setContentView(2130903128);
        ButterKnife.inject(this);
        this.cancel.setOnClickListener(this);
        this.doneText.setText(getResources().getString(2131689909));
        this.resetPassword.setOnClickListener(this);
        Resources localResources = getResources();
        p = localResources.getColor(2131361883);
        q = localResources.getColor(2131361848);
        r = localResources.getColor(2131361835);
        this.emailEdit.setFilters(new InputFilter[]{new ak()});
        this.emailEdit.addTextChangedListener(this.t);
        this.passEdit.addTextChangedListener(this.t);
        this.emailEdit.setOnFocusChangeListener(this.u);
        this.passEdit.setOnFocusChangeListener(this.u);
        u();
        if (paramBundle == null) {
            this.emailEdit.setFocusableInTouchMode(true);
            this.emailEdit.requestFocus();
            g.a(this, "SignInWithEmail");
        }
    }

    protected void onRestoreInstanceState(Bundle paramBundle) {
        super.onRestoreInstanceState(paramBundle);
        this.s = ((AuthHelper.AuthInfo) paramBundle.getParcelable("STATE_AUTH_INFO"));
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putParcelable("STATE_AUTH_INFO", this.s);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/LoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */