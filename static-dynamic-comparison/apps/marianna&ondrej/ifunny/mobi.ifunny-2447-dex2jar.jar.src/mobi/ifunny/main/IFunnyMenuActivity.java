package mobi.ifunny.main;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;

import java.util.Random;

import javafx.stage.PopupWindow;
import mobi.ifunny.IFunnyApplication;
import mobi.ifunny.gallery.GalleryFragment;
import mobi.ifunny.gallery.ak;
import mobi.ifunny.gallery.al;
import mobi.ifunny.intro.IntroFragment;
import mobi.ifunny.profile.ProfileStubFragment;
import mobi.ifunny.rest.Features;
import mobi.ifunny.rest.Features.RateTexts;
import mobi.ifunny.rest.Features.RateThisAppParams;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest$Counters;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.App;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Counters;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.rest.retrofit.RestNotification;
import mobi.ifunny.rest.retrofit.RestNotification.Counters;
import mobi.ifunny.search.SearchActivity;
import mobi.ifunny.util.cache.IFunnyCache;
import mobi.ifunny.util.cache.IFunnyCache.ListEntry;
import mobi.ifunny.util.r;

public class IFunnyMenuActivity
        extends f
        implements AdapterView.OnItemClickListener, PopupWindow.OnDismissListener, mobi.ifunny.c, j {
    private static final String p = IFunnyMenuActivity.class.getSimpleName();
    private static int u = -1;
    private static final RestHttpHandler<Features, h> x = new a();
    private static final RestHttpHandler<RestNotification.Counters, IFunnyMenuActivity> y = new b();
    private mobi.ifunny.main.a.a q;
    private mobi.ifunny.main.a.b r;
    private com.a.a.a s;
    private Features.RateTexts t;
    private int v = -1;
    private mobi.ifunny.popup.a w;

    private void D() {
        if (!e("rest.getCounters")) {
            IFunnyRestRequest$Counters.getCounters(this, "rest.getCounters", y);
        }
    }

    private void E() {
        mobi.ifunny.h.a().b("rate.last_check", System.currentTimeMillis());
        mobi.ifunny.b.g.a(this, "rate_app", "notification_hide");
        mobi.ifunny.b.c.a(this, "rate_app", "notification_hide");
    }

    private Fragment a(Parcelable paramParcelable) {
        ak localak = new ak();
        IFunnyApplication.b.d.a();
        IFunnyCache.ListEntry localListEntry = IFunnyApplication.b.d;
        if ((paramParcelable instanceof IFunnyCache.ListEntry)) {
        }
        for (paramParcelable = (IFunnyCache.ListEntry) paramParcelable; ; paramParcelable = localListEntry) {
            localak.a(paramParcelable.f());
            return localak;
        }
    }

    private Fragment a(Parcelable paramParcelable, boolean paramBoolean) {
        b(0);
        mobi.ifunny.gallery.f localf = new mobi.ifunny.gallery.f();
        if ((this.q.a() == mobi.ifunny.main.a.b.a) && (!paramBoolean)) {
            IFunnyApplication.b.a.a();
        }
        if ((paramParcelable instanceof IFunnyCache.ListEntry)) {
            localf.a(((IFunnyCache.ListEntry) paramParcelable).f());
            return localf;
        }
        if (this.q.c(mobi.ifunny.main.a.b.a) == null) {
            localf.a(IFunnyApplication.b.a.f());
            return localf;
        }
        b(mobi.ifunny.main.a.b.a);
        return localf;
    }

    private void a(mobi.ifunny.main.a.b paramb, Parcelable paramParcelable) {
        a(paramb, paramParcelable, false);
    }

    private void a(Features.RateTexts paramRateTexts) {
        Object localObject = new com.a.a.b(-1, 17170445);
        this.s = com.a.a.a.a(this, paramRateTexts.teaser, (com.a.a.b) localObject, 2130903155);
        paramRateTexts = new d(this.s, this, paramRateTexts);
        localObject = this.s.e();
        View localView = ((View) localObject).findViewById(2131493279);
        ((View) localObject).setOnClickListener(paramRateTexts);
        if (localView != null) {
            localView.setOnClickListener(paramRateTexts);
        }
        c(false);
        this.s.a();
    }

    private Fragment b(Parcelable paramParcelable, boolean paramBoolean) {
        al localal = new al();
        if ((this.q.a() == mobi.ifunny.main.a.b.d) && (!paramBoolean)) {
            IFunnyApplication.b.c.a();
        }
        if ((paramParcelable instanceof IFunnyCache.ListEntry)) {
            localal.a(((IFunnyCache.ListEntry) paramParcelable).f());
            return localal;
        }
        if (this.q.c(mobi.ifunny.main.a.b.d) == null) {
            localal.a(IFunnyApplication.b.c.f());
            return localal;
        }
        b(mobi.ifunny.main.a.b.d);
        return localal;
    }

    private Fragment b(mobi.ifunny.main.a.b paramb, Parcelable paramParcelable, boolean paramBoolean) {
        switch (c.a[paramb.ordinal()]) {
            default:
                paramb = null;
                return paramb;
            case 1:
                return a(paramParcelable, paramBoolean);
            case 2:
                return a(paramParcelable);
            case 3:
                return c(paramParcelable, paramBoolean);
            case 4:
                return b(paramParcelable, paramBoolean);
            case 5:
                return new mobi.ifunny.c.a();
        }
        paramParcelable = mobi.ifunny.social.auth.l.a();
        if (paramParcelable.h()) {
            paramParcelable = mobi.ifunny.profile.d.a(paramParcelable.d());
            if (!TextUtils.isEmpty(a(paramb))) {
            }
            for (int i = 1; ; i = 0) {
                paramb = paramParcelable;
                if (i == 0) {
                    break;
                }
                paramb = paramParcelable.getArguments();
                paramb.putInt("ARG_INITIAL_TAB", 2);
                paramParcelable.setArguments(paramb);
                return paramParcelable;
            }
        }
        return new ProfileStubFragment();
    }

    private void b(int paramInt) {
        if (e("TAG_UPDATE_BADGES")) {
            return;
        }
        new e(this, "TAG_UPDATE_BADGES", paramInt, null).execute(new Void[0]);
    }

    private void b(Features.RateTexts paramRateTexts) {
        a(paramRateTexts);
        mobi.ifunny.b.g.a(this, "rate_app", "notification_show");
        mobi.ifunny.b.c.a(this, "rate_app", "notification_show");
    }

    private Fragment c(Parcelable paramParcelable, boolean paramBoolean) {
        mobi.ifunny.gallery.a locala = new mobi.ifunny.gallery.a();
        if ((this.q.a() == mobi.ifunny.main.a.b.c) && (!paramBoolean)) {
            IFunnyApplication.b.b.a();
        }
        IFunnyCache.ListEntry localListEntry = IFunnyApplication.b.b;
        if ((paramParcelable instanceof IFunnyCache.ListEntry)) {
        }
        for (paramParcelable = (IFunnyCache.ListEntry) paramParcelable; ; paramParcelable = localListEntry) {
            locala.a(paramParcelable.f());
            return locala;
        }
    }

    private void c(Intent paramIntent) {
        a((mobi.ifunny.main.a.b) paramIntent.getSerializableExtra("intent.start_fragment"), paramIntent.getParcelableExtra("intent.start_data"));
        paramIntent.removeExtra("intent.start_fragment");
        paramIntent.removeExtra("intent.start_data");
    }

    private void c(mobi.ifunny.main.a.b paramb) {
        this.q.a(mobi.ifunny.main.a.b.a(paramb));
        this.r = paramb;
    }

    private boolean s() {
        boolean bool = false;
        if (!mobi.ifunny.h.a().a("pref.intro.was.shown", false)) {
            bool = true;
        }
        return bool;
    }

    private boolean t() {
        return (this.w != null) && (this.w.isShowing());
    }

    private void u() {
        if (t()) {
            return;
        }
        this.w = new mobi.ifunny.popup.a(this);
        this.w.setAnchorView(v());
        this.w.setAdapter(this.q);
        this.w.setContentWidth(getResources().getDimensionPixelSize(2131427438));
        this.w.setOnItemClickListener(this);
        this.w.setOnDismissListener(this);
        this.w.show();
        n();
    }

    private View v() {
        return getWindow().getDecorView().findViewById(getResources().getIdentifier("action_bar_container", "id", "android"));
    }

    private void w() {
        if ((Features.isUpdateNeeded()) && (!e("GET_FEATURES_TASK"))) {
            IFunnyRestRequest.App.getFeatures(this, "GET_FEATURES_TASK", x);
        }
    }

    public Object Q_() {
        i locali = (i) f().a("fragment");
        if (locali != null) {
            return locali.n();
        }
        return super.Q_();
    }

    public String a(mobi.ifunny.main.a.b paramb) {
        return this.q.c(paramb);
    }

    public void a(mobi.ifunny.main.a.b paramb, Parcelable paramParcelable, boolean paramBoolean) {
        if (paramb == mobi.ifunny.main.a.b.e) {
            startActivity(new Intent(this, SearchActivity.class));
            return;
        }
        ab localab = f().a();
        localab.b(2131493180, b(paramb, paramParcelable, paramBoolean), "fragment");
        localab.b();
        c(paramb);
    }

    public void a(RestNotification.Counters paramCounters) {
        b(paramCounters);
    }

    public void b(mobi.ifunny.main.a.b paramb) {
        this.q.b(paramb);
    }

    protected void b(RestNotification.Counters paramCounters) {
        this.q.a(paramCounters);
        if (paramCounters.news > 0) {
            this.v = (paramCounters.news - 1);
            i locali = (i) f().a("fragment");
            if ((locali instanceof mobi.ifunny.profile.l)) {
                ((mobi.ifunny.profile.l) locali).e(r.a(paramCounters.news));
            }
        }
    }

    public void c(boolean paramBoolean) {
        if (this.s == null) {
            return;
        }
        Object localObject = this.s.e();
        Resources localResources = getResources();
        TypedValue localTypedValue = new TypedValue();
        android.support.v7.a.a locala = h();
        Resources.Theme localTheme = getTheme();
        int i;
        if (localTheme.resolveAttribute(16843499, localTypedValue, true)) {
            i = TypedValue.complexToDimensionPixelSize(localTypedValue.data, localResources.getDisplayMetrics());
        }
        for (; ; ) {
            if (locala.h()) {
                label80:
                if (!paramBoolean) {
                    break label157;
                }
            }
            label157:
            for (long l = 300L; ; l = 0L) {
                localObject = ObjectAnimator.ofFloat(localObject, "translationY", new float[]{i});
                ((ObjectAnimator) localObject).setDuration(l);
                ((ObjectAnimator) localObject).start();
                return;
                if (!localTheme.resolveAttribute(2130771970, localTypedValue, true)) {
                    break label162;
                }
                i = TypedValue.complexToDimensionPixelSize(localTypedValue.data, getResources().getDisplayMetrics());
                break;
                i = 0;
                break label80;
            }
            label162:
            i = 0;
        }
    }

    public void onBackPressed() {
        i locali = (i) f().a("fragment");
        if ((locali != null) && (locali.q())) {
            return;
        }
        if (this.q.a() == mobi.ifunny.main.a.b.a) {
            super.onBackPressed();
            return;
        }
        a(mobi.ifunny.main.a.b.a, null);
    }

    protected void onCreate(Bundle paramBundle) {
        getWindow().requestFeature(8);
        setTheme(2131755189);
        super.onCreate(paramBundle);
        this.q = new mobi.ifunny.main.a.a();
        IFunnyApplication.a.a(this);
        Intent localIntent = getIntent();
        if (localIntent.hasExtra("intent.start_fragment")) {
            c(localIntent);
        }
        while (paramBundle != null) {
            return;
        }
        if ((s()) && (!m())) {
            paramBundle = IntroFragment.d();
            paramBundle.b(true);
            paramBundle.c(false);
            paramBundle.a(f(), "intro");
        }
        a(mobi.ifunny.main.a.b.a, null);
    }

    protected void onDestroy() {
        super.onDestroy();
        IFunnyApplication.a.b(this);
    }

    public void onDismiss() {
        o();
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        this.w.dismiss();
        if (this.s != null) {
            this.s.c();
        }
        a(this.q.a(paramInt), null);
    }

    protected void onNewIntent(Intent paramIntent) {
        super.onNewIntent(paramIntent);
        setIntent(paramIntent);
        if (paramIntent.hasExtra("intent.start_fragment")) {
            c(paramIntent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        u();
        return true;
    }

    protected void onRestoreInstanceState(Bundle paramBundle) {
        super.onRestoreInstanceState(paramBundle);
        c((mobi.ifunny.main.a.b) paramBundle.getSerializable("state.menu_item"));
        this.v = paramBundle.getInt("state.last_fresh_index", -1);
        this.t = ((Features.RateTexts) paramBundle.getParcelable("state.rate.texts"));
        if (this.t != null) {
            a(this.t);
        }
    }

    protected void onResume() {
        super.onResume();
        w();
        D();
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putSerializable("state.menu_item", this.r);
        paramBundle.putInt("state.last_fresh_index", this.v);
        if ((this.s != null) && (this.s.b())) {
            paramBundle.putParcelable("state.rate.texts", this.t);
        }
    }

    protected void onStart() {
        super.onStart();
        mobi.ifunny.hockeyapp.b.b(this);
    }

    protected void onStop() {
        super.onStop();
        if (t()) {
            this.w.dismiss();
        }
    }

    public int p() {
        int i = this.v;
        this.v = -1;
        return i;
    }

    public void q() {
        if (this.s != null) {
            return;
        }
        if (!Features.isRateThisAppTurnedOn()) {
            mobi.ifunny.d.b(p, "Rate app: feature is turned off");
            return;
        }
        Features.RateThisAppParams localRateThisAppParams = Features.getRateThisAppParams();
        if (localRateThisAppParams == null) {
            mobi.ifunny.d.b(p, "Rate app: invalid params");
            return;
        }
        Random localRandom = new Random();
        if (u < 0) {
            u = localRandom.nextInt(100);
        }
        if (u > localRateThisAppParams.rate) {
            mobi.ifunny.d.b(p, String.format("Rate app: bad luck for this session. Sample rate is %s", new Object[]{Integer.valueOf(localRateThisAppParams.rate)}));
            return;
        }
        mobi.ifunny.h localh = mobi.ifunny.h.a();
        if (localh.a("rate.dont_remind", false)) {
            mobi.ifunny.d.b(p, "Rate app: 'Don't remind' flag was turned on");
            return;
        }
        if ("4.0".equals(localh.a("rate.last_rated_version", ""))) {
            mobi.ifunny.d.b(p, "Rate app: this version has been rated already");
            return;
        }
        if (localRateThisAppParams.texts.length == 0) {
            mobi.ifunny.d.b(p, "Rate app: No texts were received from server");
            return;
        }
        this.t = localRateThisAppParams.texts[localRandom.nextInt(localRateThisAppParams.texts.length)];
        long l1 = localh.a("rate.last_check", 0L);
        long l2 = localh.a("pref.last_crash_time", 0L);
        long l3 = System.currentTimeMillis();
        if ((l3 < l1 + 2592000000L) || (l3 < l2 + 2592000000L)) {
            mobi.ifunny.d.b(p, "Rate app: Not enough time was past from last dialog or last crash");
            return;
        }
        if (!localRandom.nextBoolean()) {
            mobi.ifunny.d.b(p, "Rate app: bad luck for this particular show (50/50)");
            return;
        }
        b(this.t);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/main/IFunnyMenuActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */