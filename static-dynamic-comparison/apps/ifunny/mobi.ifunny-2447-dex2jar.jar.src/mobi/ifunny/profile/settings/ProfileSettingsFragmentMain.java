package mobi.ifunny.profile.settings;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ab;
import android.support.v4.app.g;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.content.UserSocial;
import mobi.ifunny.rest.content.UserSocials;
import mobi.ifunny.rest.content.UserSocials.ProfileSocialState;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Account;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.view.SettingsItemLayout;

public class ProfileSettingsFragmentMain
        extends mobi.ifunny.profile.b
        implements View.OnClickListener, d, u, mobi.ifunny.social.auth.a.b, mobi.ifunny.social.auth.d.b {
    private static final String i = ProfileSettingsFragmentMain.class.getSimpleName();
    private static final RestHttpHandler<Void, ProfileSettingsFragmentMain> j = new h();
    private static final RestHttpHandler<Void, ProfileSettingsFragmentMain> k = new i();
    private static final RestHttpHandler<Void, ProfileSettingsFragmentMain> l = new j();
    private static final RestHttpHandler<Void, ProfileSettingsFragmentMain> m = new k();
    @InjectView(2131493235)
    protected SettingsItemLayout emailView;
    @InjectView(2131493231)
    protected SettingsItemLayout facebookView;
    @InjectView(2131493233)
    protected SettingsItemLayout gplusView;
    protected UserSocials.ProfileSocialState h;
    @InjectView(2131493197)
    protected SettingsItemLayout notificationsView;
    @InjectView(2131493165)
    protected SettingsItemLayout resetPasswordView;
    @InjectView(2131493232)
    protected SettingsItemLayout twitterView;

    private void a(Boolean paramBoolean) {
        a locala = new a();
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("isChangingEmail", paramBoolean.booleanValue());
        locala.setArguments(localBundle);
        locala.b(true);
        locala.setTargetFragment(this, 0);
        locala.a(getActivity().f(), "dialog.edit_email");
    }

    private void b(boolean paramBoolean, String paramString1, String paramString2) {
        if (paramBoolean) {
            if (this.a.social == null) {
                this.a.social = new UserSocials();
            }
            this.a.social.fb = new UserSocial();
            this.a.social.fb.is_hidden = true;
            this.a.social.fb.id = paramString2;
            this.a.social.fb.nick = paramString1;
        }
        for (; ; ) {
            k();
            a(this.a);
            return;
            this.a.social.fb = null;
        }
    }

    public static e c(User paramUser) {
        Bundle localBundle = new Bundle();
        localBundle.putString("uid", mobi.ifunny.social.auth.l.a().d());
        localBundle.putParcelable("arg.profile", paramUser);
        paramUser = new e();
        paramUser.setArguments(localBundle);
        return paramUser;
    }

    private void c(String paramString) {
        if (this.a.email == null) {
            Toast.makeText(getActivity(), 2131689863, 0).show();
        }
        this.a.email = paramString;
        k();
        a(this.a);
    }

    private void c(boolean paramBoolean, String paramString1, String paramString2) {
        if (paramBoolean) {
            if (this.a.social == null) {
                this.a.social = new UserSocials();
            }
            this.a.social.tw = new UserSocial();
            this.a.social.tw.is_hidden = true;
            this.a.social.tw.id = paramString2;
            this.a.social.tw.nick = paramString1;
        }
        for (; ; ) {
            k();
            a(this.a);
            return;
            this.a.social.tw = null;
        }
    }

    private void d() {
        if (this.h.getEmail() == null) {
            Toast.makeText(getActivity(), 2131689862, 1).show();
            return;
        }
        s locals = new s();
        locals.b(true);
        locals.setTargetFragment(this, 0);
        locals.a(getActivity().f(), "dialog.reset_password");
    }

    private void m() {
        android.support.v4.app.q localq = getActivity().f();
        b("append_facebook");
        Object localObject2 = (mobi.ifunny.social.auth.a.a) localq.a("SETTINGS_FACEBOOK_FRAGMENT");
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = new mobi.ifunny.social.auth.a.a();
            localObject2 = localq.a();
            ((ab) localObject2).a((Fragment) localObject1, "SETTINGS_FACEBOOK_FRAGMENT");
            ((ab) localObject2).c();
            localq.b();
        }
        ((mobi.ifunny.social.auth.a.a) localObject1).setTargetFragment(this, 0);
        ((mobi.ifunny.social.auth.a.a) localObject1).a(false);
    }

    private void o() {
        if ((TextUtils.isEmpty(this.h.getEmail())) && (this.h.isLastNetworkConnected())) {
            h();
            return;
        }
        android.support.v4.app.q localq = getChildFragmentManager();
        m localm = (m) localq.a("DELETE_FACEBOOK_ALERT_TAG");
        if (localm != null) {
            localm.b();
            localq.b();
        }
        localm = new m();
        localm.a(getActivity(), 0, 2131689872, 2131689686, 2131689676);
        localm.a(localq, "DELETE_FACEBOOK_ALERT_TAG");
    }

    private void p() {
        IFunnyRestRequest.Account.socialsDelete(this, "delete_social", k, "fb");
    }

    private void r() {
        android.support.v4.app.q localq = getActivity().f();
        b("append_twitter");
        Object localObject2 = (mobi.ifunny.social.auth.d.a) localq.a("SETTINGS_TWITTER_FRAGMENT");
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = new mobi.ifunny.social.auth.d.a();
            localObject2 = localq.a();
            ((ab) localObject2).a((Fragment) localObject1, "SETTINGS_TWITTER_FRAGMENT");
            ((ab) localObject2).c();
            localq.b();
        }
        ((mobi.ifunny.social.auth.d.a) localObject1).setTargetFragment(this, 0);
        ((mobi.ifunny.social.auth.d.a) localObject1).a(false);
    }

    private void s() {
        if ((TextUtils.isEmpty(this.h.getEmail())) && (this.h.isLastNetworkConnected())) {
            h();
            return;
        }
        android.support.v4.app.q localq = getChildFragmentManager();
        o localo = (o) localq.a("DELETE_TWITTER_ALERT_TAG");
        if (localo != null) {
            localo.b();
            localq.b();
        }
        localo = new o();
        localo.a(getActivity(), 0, 2131689872, 2131689686, 2131689676);
        localo.a(localq, "DELETE_TWITTER_ALERT_TAG");
    }

    private void t() {
        IFunnyRestRequest.Account.socialsDelete(this, "delete_social", l, "tw");
    }

    private void u() {
        if ((this.h.getEmail() == null) && (this.h.isLastNetworkConnected())) {
            h();
            return;
        }
        android.support.v4.app.q localq = getChildFragmentManager();
        n localn = (n) localq.a("DELETE_GPLUS_ALERT_TAG");
        if (localn != null) {
            localn.b();
            localq.b();
        }
        localn = new n();
        localn.a(getActivity(), 0, 2131689872, 2131689686, 2131689676);
        localn.a(localq, "DELETE_GPLUS_ALERT_TAG");
    }

    private void v() {
        IFunnyRestRequest.Account.socialsDelete(this, "delete_social", m, "gplus");
    }

    public void O_() {
        IFunnyRestRequest.Account.passwordChangeRequest(this, "reset_password", this.a.email, j);
    }

    public void a(String paramString) {
        if (!mobi.ifunny.util.r.b(paramString)) {
            Toast.makeText(getActivity(), 2131689868, 0).show();
            return;
        }
        if (!paramString.equals(this.h.getEmail())) {
            IFunnyRestRequest.Account.emailPutRequest(this, "reset_password", paramString, new p(paramString, null));
            return;
        }
        Toast.makeText(getActivity(), 2131689867, 1).show();
    }

    protected void a(User paramUser) {
        this.h.update(paramUser);
        super.a(paramUser);
        paramUser = getResources();
        String str1 = paramUser.getString(2131689870);
        String str2 = paramUser.getString(2131689874);
        int n = paramUser.getColor(2131361883);
        int i1 = paramUser.getColor(2131361835);
        if (this.h.isFacebookConnected()) {
            this.facebookView.setRightText(str1);
            this.facebookView.getRightTextView().setTextColor(n);
            if (!this.h.isTwitterConnected()) {
                break label231;
            }
            this.twitterView.setRightText(str1);
            this.twitterView.getRightTextView().setTextColor(n);
            label112:
            if (!this.h.isGPlusConnected()) {
                break label254;
            }
            this.gplusView.setRightText(str1);
            this.gplusView.getRightTextView().setTextColor(n);
        }
        for (; ; ) {
            if (!TextUtils.isEmpty(this.h.getEmail())) {
                this.emailView.setRightText(this.h.getEmail());
                this.emailView.getRightTextView().setTextColor(n);
            }
            if (TextUtils.isEmpty(this.h.getEmail())) {
                this.emailView.setLeftText(getString(2131689851));
            }
            return;
            this.facebookView.setRightText(str2);
            this.facebookView.getRightTextView().setTextColor(i1);
            break;
            label231:
            this.twitterView.setRightText(str2);
            this.twitterView.getRightTextView().setTextColor(i1);
            break label112;
            label254:
            this.gplusView.setRightText(str2);
            this.gplusView.getRightTextView().setTextColor(i1);
        }
    }

    public void a(mobi.ifunny.social.auth.n paramn, String paramString1, String paramString2) {
        IFunnyRestRequest.Account.socialsPut(this, "append_twitter", new r(paramn.b, paramn.a, null), "tw", paramn.a, paramString1, paramString2, false);
    }

    protected void a(boolean paramBoolean, String paramString1, String paramString2) {
        if (paramBoolean) {
            if (this.a.social == null) {
                this.a.social = new UserSocials();
            }
            this.a.social.gplus = new UserSocial();
            this.a.social.gplus.is_hidden = true;
            this.a.social.gplus.id = paramString2;
            this.a.social.gplus.nick = paramString1;
        }
        for (; ; ) {
            k();
            a(this.a);
            return;
            this.a.social.gplus = null;
        }
    }

    protected void b(String paramString) {
        mobi.ifunny.fragment.h.a(this, false, new String[]{paramString}).a(getActivity().f(), "dialog.loading");
    }

    public void b(String paramString1, String paramString2, mobi.ifunny.social.auth.n paramn) {
        if (!TextUtils.isEmpty(paramString2)) {
            Toast.makeText(mobi.ifunny.e.a, paramString2, 1).show();
        }
        for (; ; ) {
            l();
            return;
            Toast.makeText(mobi.ifunny.e.a, 2131689929, 1).show();
        }
    }

    public void b(mobi.ifunny.social.auth.n paramn, String paramString) {
        IFunnyRestRequest.Account.socialsPut(this, "append_facebook", new q(paramn.b, paramn.a, null), "fb", paramn.a, paramString, null, false);
    }

    public void c(String paramString1, String paramString2, mobi.ifunny.social.auth.n paramn) {
        if (!TextUtils.isEmpty(paramString2)) {
            Toast.makeText(mobi.ifunny.e.a, paramString2, 1).show();
        }
        for (; ; ) {
            l();
            return;
            Toast.makeText(mobi.ifunny.e.a, 2131689929, 1).show();
        }
    }

    public String e() {
        return i + "-" + this.b;
    }

    public void g() {
        l();
    }

    protected void h() {
        android.support.v4.app.q localq = getChildFragmentManager();
        l locall = (l) localq.a("CANNOT_UNBIND_ALERT_TAG");
        if (locall != null) {
            locall.b();
            localq.b();
        }
        locall = new l();
        locall.a(getActivity(), 0, 2131689855, 17039370, 0);
        locall.a(localq, "CANNOT_UNBIND_ALERT_TAG");
    }

    public void j() {
        l();
    }

    protected void k() {
        Intent localIntent = new Intent();
        localIntent.putExtra("result.profile", this.a);
        getActivity().setResult(-1, localIntent);
    }

    protected void l() {
        g localg = (g) getActivity().f().a("dialog.loading");
        if (localg != null) {
            localg.b();
        }
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        a().a(getString(2131689875));
    }

    public void onClick(View paramView) {
        boolean bool2 = true;
        boolean bool1 = true;
        switch (paramView.getId()) {
            default:
            case 2131493231:
            case 2131493233:
                do {
                    return;
                    if (this.h.isFacebookConnected()) {
                        o();
                        return;
                    }
                    m();
                    return;
                } while (!this.h.isGPlusConnected());
                u();
                return;
            case 2131493232:
                if (this.h.isTwitterConnected()) {
                    s();
                    return;
                }
                r();
                return;
            case 2131493235:
                if (this.h.getEmail() != null) {
                }
                for (; ; ) {
                    a(Boolean.valueOf(bool1));
                    return;
                    bool1 = false;
                }
            case 2131493165:
                d();
                return;
        }
        paramView = mobi.ifunny.h.a();
        if (!paramView.a("pref.push.notifications", true)) {
        }
        for (bool1 = bool2; ; bool1 = false) {
            this.notificationsView.setSwitcherState(bool1);
            paramView.b("pref.push.notifications", bool1);
            return;
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.b = mobi.ifunny.social.auth.l.a().d();
        this.d = true;
        this.h = new UserSocials.ProfileSocialState();
        setHasOptionsMenu(true);
        this.a = ((User) getArguments().getParcelable("arg.profile"));
    }

    @SuppressLint({"WrongViewCast"})
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903144, paramViewGroup, false);
        ButterKnife.inject(this, paramLayoutInflater);
        this.facebookView.setOnClickListener(this);
        this.gplusView.setOnClickListener(this);
        this.twitterView.setOnClickListener(this);
        this.emailView.setOnClickListener(this);
        this.resetPasswordView.setOnClickListener(this);
        this.notificationsView.setOnClickListener(this);
        this.notificationsView.setSwitcherState(mobi.ifunny.h.a().a("pref.push.notifications", true));
        return paramLayoutInflater;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/settings/ProfileSettingsFragmentMain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */