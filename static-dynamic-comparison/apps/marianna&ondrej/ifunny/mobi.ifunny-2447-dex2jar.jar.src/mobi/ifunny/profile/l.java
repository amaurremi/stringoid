package mobi.ifunny.profile;

import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.ab;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.emilsjolander.components.StickyScrollViewItems.StickyScrollView;

import java.util.EnumSet;
import java.util.Iterator;

import mobi.ifunny.IFunnyApplication;
import mobi.ifunny.fragment.ImagePreviewFragment;
import mobi.ifunny.main.IFunnyMenuActivity;
import mobi.ifunny.profile.editor.ProfileEditorActivity;
import mobi.ifunny.profile.fragments.ProfileInfoFragment;
import mobi.ifunny.profile.settings.ProfileSettingsActivity;
import mobi.ifunny.rest.Features;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.content.UserStat;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Subscriptions;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Users;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.social.auth.AuthActivity;
import mobi.ifunny.social.auth.aa;
import mobi.ifunny.social.auth.ac;
import mobi.ifunny.studio.StudioActivity;
import mobi.ifunny.support.SupportActivity;
import mobi.ifunny.util.cache.IFunnyCache;
import mobi.ifunny.util.cache.IFunnyCache.ListEntry;
import mobi.ifunny.view.FragmentTabWidget;
import mobi.ifunny.view.ProgressBar;

public class l
        extends b
        implements View.OnClickListener, com.emilsjolander.components.StickyScrollViewItems.j, g, ac, mobi.ifunny.view.k {
    private static final RestHttpHandler<Void, l> O = new p();
    public static EnumSet<u> h;
    private static final String i = b.class.getSimpleName();
    private int A;
    private uk.co.a.a.a.a.c B;
    private MenuItem C;
    private FrameLayout.LayoutParams D;
    private Handler E;
    private Handler F;
    private Runnable G;
    private boolean H;
    private final int I = 5;
    private int J = 0;
    private v K = new v(this, null);
    private s L = new s(this, null);
    private r M = new r(this, null);
    private Runnable N = new n(this);
    private ViewGroup j;
    private View k;
    private View l;
    private View m;
    private ImageView n;
    private FrameLayout o;
    private ImageView p;
    private View q;
    private TextView r;
    private ImageView s;
    private Button t;
    private StickyScrollView u;
    private ProgressBar v;
    private View w;
    private ViewPager x;
    private FragmentTabWidget y;
    private mobi.ifunny.profile.fragments.b z;

    static {
        h = EnumSet.noneOf(u.class);
    }

    private void F() {
        mobi.ifunny.d.c(i, "subscribe");
        if (!f("task.subscribe")) {
            UserStat localUserStat = this.a.num;
            localUserStat.subscribers += 1;
            this.a.is_in_subscriptions = true;
            r();
            p();
            IFunnyRestRequest.Subscriptions.subscribeUser(this, "task.subscribe", this.b, new y(null));
        }
    }

    private void G() {
        mobi.ifunny.d.c(i, "unsubscribe");
        if (!f("task.unsubscribe")) {
            UserStat localUserStat = this.a.num;
            localUserStat.subscribers -= 1;
            this.a.is_in_subscriptions = false;
            r();
            p();
            IFunnyRestRequest.Subscriptions.unsubscribeUser(this, "task.unsubscribe", this.b, new z(null));
        }
    }

    private void H() {
        e locale = new e();
        locale.b(true);
        locale.setTargetFragment(this, 0);
        locale.a(getActivity().f(), "logout");
    }

    private void I() {
        if (this.y == null) {
        }
        mobi.ifunny.view.j localj;
        do {
            return;
            localj = this.y.c(2);
        } while ((localj == null) || (!(localj instanceof w)));
        ((w) localj).a();
    }

    private void a(int paramInt1, int paramInt2) {
        Object localObject = getResources();
        localObject = new w((Resources) localObject, ((Resources) localObject).getDrawable(paramInt1), ((Resources) localObject).getString(paramInt2), null);
        this.y.a((mobi.ifunny.view.j) localObject);
    }

    private void a(String paramString) {
        if (f("task.cover")) {
            mobi.ifunny.d.d(i, String.format("Interrupting cover loading. New url: %s", new Object[]{paramString}));
            a(new String[]{"task.cover"});
        }
        if (TextUtils.isEmpty(paramString)) {
            this.n.setImageDrawable(null);
            return;
        }
        new t(this, "task.cover", mobi.ifunny.util.cache.f.a(new mobi.ifunny.util.a.a(null, false))).execute(new String[]{paramString});
    }

    private void b(String paramString) {
        android.support.v4.app.q localq = getChildFragmentManager();
        ImagePreviewFragment localImagePreviewFragment = (ImagePreviewFragment) localq.a("dialog.avatar_preview");
        if (localImagePreviewFragment != null) {
            localImagePreviewFragment.b();
            localq.b();
        }
        ImagePreviewFragment.a(Uri.parse(paramString)).a(localq, "dialog.avatar_preview");
        localq.b();
    }

    private void b(String paramString1, String paramString2) {
        if (f("task.avatar")) {
            mobi.ifunny.d.d(i, String.format("Interrupting avatar loading. New url: %s", new Object[]{paramString1}));
            a(new String[]{"task.avatar"});
        }
        if (TextUtils.isEmpty(paramString1)) {
            paramString1 = (com.makeramen.c) com.makeramen.c.a(getResources().getDrawable(2130837607));
            paramString1.a(true);
            a(paramString1);
            return;
        }
        int i1 = mobi.ifunny.util.r.c(paramString2);
        if (i1 == 0) {
            paramString2 = getResources().getDrawable(2130837608);
            paramString2.setLevel(mobi.ifunny.util.r.b(1, 6));
            this.q.setBackgroundDrawable(paramString2);
        }
        for (; ; ) {
            new q(this, "task.avatar", mobi.ifunny.util.cache.f.b(new mobi.ifunny.util.a.a(new Point(this.p.getWidth(), this.p.getWidth()), false))).execute(new String[]{paramString1});
            return;
            paramString2 = new ShapeDrawable(new OvalShape());
            paramString2.getPaint().setColor(i1);
            this.q.setBackgroundDrawable(paramString2);
        }
    }

    public static String c(String paramString) {
        return i + "-" + paramString;
    }

    private void c(User paramUser) {
        if ((this.d) && (this.z != null) && (paramUser != null) && (!paramUser.is_banned)) {
            if (!h.isEmpty()) {
                Iterator localIterator = h.iterator();
                while (localIterator.hasNext()) {
                    u localu = (u) localIterator.next();
                    this.z.a(localu.ordinal(), paramUser, true);
                }
            }
            h.clear();
        }
    }

    public static String d(String paramString) {
        return i + "-NICK-" + paramString;
    }

    private void d(int paramInt) {
        if (this.G != null) {
            this.E.removeCallbacks(this.G);
        }
        this.G = new m(this, paramInt);
        this.E.postDelayed(this.G, 1500L);
    }

    private void d(User paramUser) {
        ImageView localImageView = this.s;
        if (paramUser.is_verified) {
        }
        for (int i1 = 0; ; i1 = 8) {
            localImageView.setVisibility(i1);
            return;
        }
    }

    private void g(String paramString) {
        if ((this.A == 2) || (this.y == null)) {
        }
        mobi.ifunny.view.j localj;
        do {
            return;
            h.add(u.c);
            localj = this.y.c(2);
        } while ((localj == null) || (!(localj instanceof w)));
        ((w) localj).a(paramString);
    }

    private void m() {
        boolean bool = true;
        int i1;
        MenuItem localMenuItem;
        if (this.C != null) {
            if ((this.z == null) || (this.x.getCurrentItem() != 2)) {
                break label54;
            }
            i1 = 1;
            localMenuItem = this.C;
            if ((!this.H) || (i1 == 0)) {
                break label59;
            }
        }
        for (; ; ) {
            localMenuItem.setVisible(bool);
            return;
            label54:
            i1 = 0;
            break;
            label59:
            bool = false;
        }
    }

    private void o() {
        this.x.setAdapter(null);
        this.z = null;
        if (this.d) {
            h.clear();
        }
    }

    private void p() {
        if (this.d) {
            this.t.setVisibility(8);
            return;
        }
        if (this.a.is_in_subscriptions) {
            this.t.setText(2131689790);
            this.t.setCompoundDrawablesWithIntrinsicBounds(2130837907, 0, 0, 0);
        }
        for (; ; ) {
            this.t.setVisibility(0);
            return;
            this.t.setText(2131689789);
            this.t.setCompoundDrawables(null, null, null, null);
        }
    }

    private void r() {
        ((ProfileInfoFragment) this.z.a(1)).a(this.a, true);
    }

    private void s() {
        Intent localIntent = new Intent(getActivity(), ProfileEditorActivity.class);
        localIntent.putExtra("intent.profile", this.a);
        startActivityForResult(localIntent, 100);
    }

    private void t() {
        Intent localIntent = new Intent(getActivity(), ProfileSettingsActivity.class);
        localIntent.putExtra("intent.profile", this.a);
        startActivityForResult(localIntent, 101);
    }

    private void u() {
        startActivity(new Intent(getActivity(), SupportActivity.class));
    }

    private void v() {
        new AlertDialog.Builder(getActivity()).setMessage(2131689781).setPositiveButton(2131689686, new o(this)).setNegativeButton(2131689676, null).show();
    }

    private void w() {
        if (this.a != null) {
            IFunnyRestRequest.Users.abuseProfile(this, "task.abuse.profile", this.a.id, O);
        }
    }

    public void N_() {
        a(mobi.ifunny.social.auth.l.a().c());
    }

    protected void a(int paramInt) {
        switch (paramInt) {
            default:
                return;
            case 0:
                localq = getChildFragmentManager();
                localObject2 = (aa) localq.a("TAG_LOGOUT_FACEBOOK");
                localObject1 = localObject2;
                if (localObject2 == null) {
                    localObject1 = new mobi.ifunny.social.auth.a.k();
                    localObject2 = localq.a();
                    ((ab) localObject2).a((Fragment) localObject1, "TAG_LOGOUT_FACEBOOK");
                    ((ab) localObject2).c();
                    localq.b();
                }
                ((aa) localObject1).h();
                return;
            case 1:
                localq = getChildFragmentManager();
                localObject2 = (aa) localq.a("TAG_LOGOUT_TWITTER");
                localObject1 = localObject2;
                if (localObject2 == null) {
                    localObject1 = new mobi.ifunny.social.auth.d.l();
                    localObject2 = localq.a();
                    ((ab) localObject2).a((Fragment) localObject1, "TAG_LOGOUT_TWITTER");
                    ((ab) localObject2).c();
                    localq.b();
                }
                ((aa) localObject1).h();
                return;
        }
        android.support.v4.app.q localq = getChildFragmentManager();
        Object localObject2 = (aa) localq.a("TAG_LOGOUT_PASSWORD");
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = new mobi.ifunny.social.auth.c.d();
            localObject2 = localq.a();
            ((ab) localObject2).a((Fragment) localObject1, "TAG_LOGOUT_PASSWORD");
            ((ab) localObject2).c();
            localq.b();
        }
        ((aa) localObject1).h();
    }

    public void a(int paramInt1, int paramInt2, int paramInt3) {
    }

    public void a(int paramInt, boolean paramBoolean) {
        this.A = paramInt;
        this.u.g();
        Object localObject = u.values()[paramInt];
        if ((this.d) && (h.contains(localObject))) {
            this.z.a(paramInt, this.a, true);
            h.remove(localObject);
        }
        for (; ; ) {
            this.z.a(paramInt, this.D);
            localObject = getActivity();
            if (((localObject instanceof IFunnyMenuActivity)) && (paramInt == 2)) {
                ((IFunnyMenuActivity) localObject).b(mobi.ifunny.main.a.b.f);
                I();
            }
            localObject = (w) this.y.c(this.A);
            a().a(((w) localObject).b());
            m();
            d(paramInt);
            return;
            this.z.a(paramInt, this.a, false);
        }
    }

    protected void a(Bitmap paramBitmap) {
        if (paramBitmap != null) {
            paramBitmap = new com.makeramen.c(paramBitmap);
            paramBitmap.a(true);
            a(paramBitmap);
        }
    }

    protected void a(Drawable paramDrawable) {
        int i1 = getResources().getInteger(17694720);
        mobi.ifunny.util.b.a(this.p, paramDrawable, i1);
        this.F.postDelayed(this.N, i1);
    }

    public void a(View paramView, int paramInt1, int paramInt2) {
    }

    public void a(String paramString1, String paramString2) {
        if (!TextUtils.isEmpty(paramString2)) {
            Toast.makeText(mobi.ifunny.e.a, paramString2, 1).show();
            return;
        }
        Toast.makeText(mobi.ifunny.e.a, 2131689929, 1).show();
    }

    protected void a(RestError paramRestError) {
        super.a(paramRestError);
        if ((this.d) && (paramRestError != null) && (!TextUtils.isEmpty(paramRestError.errorMessage))) {
            Toast.makeText(getActivity(), paramRestError.errorMessage, 1).show();
        }
    }

    protected void a(User paramUser) {
        super.a(paramUser);
        if (paramUser.is_banned) {
            this.m.setVisibility(0);
            Toast.makeText(getActivity(), 2131689593, 1).show();
        }
        if (this.z == null) {
            this.z = new mobi.ifunny.profile.fragments.b(getChildFragmentManager(), paramUser, this.D, this.d);
            this.x.setAdapter(this.z);
        }
        for (; ; ) {
            this.y.d(this.A);
            this.v.setVisibility(8);
            this.w.setVisibility(0);
            this.u.setVisibility(0);
            p();
            d(paramUser);
            this.r.setText(paramUser.nick);
            b(paramUser.getPhotoThumbLargeUrl(), paramUser.getPhotoBgColor());
            a(paramUser.cover_url);
            this.H = true;
            paramUser = (w) this.y.c(this.A);
            a().a(paramUser.b());
            C().d();
            return;
            c(paramUser);
        }
    }

    protected void a(mobi.ifunny.util.a.d paramd) {
        if (paramd != null) {
            paramd = new mobi.ifunny.view.drawable.f(paramd);
            this.n.setImageDrawable(paramd);
        }
    }

    public void a(uk.co.a.a.b.a.b paramb) {
        this.B.a(paramb);
        this.B.a(true);
    }

    protected void b() {
        this.v.setVisibility(0);
        this.w.setVisibility(4);
        this.u.setVisibility(4);
        this.H = false;
        C().d();
        o();
        super.b();
    }

    public void b(int paramInt) {
    }

    public void b_(boolean paramBoolean) {
    }

    protected void c() {
        super.c();
        o();
        this.v.setVisibility(8);
        this.k.setVisibility(8);
        TextView localTextView = (TextView) this.l.findViewById(2131493094);
        localTextView.setText(2131689796);
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130837958, 0, 0);
        this.l.setVisibility(0);
        this.H = false;
        C().d();
    }

    public void c(int paramInt) {
    }

    protected void d() {
        startActivity(new Intent(getActivity(), AuthActivity.class));
    }

    protected void e() {
    }

    public void e(String paramString) {
        if (this.z == null) {
            return;
        }
        mobi.ifunny.mynews.d locald = (mobi.ifunny.mynews.d) this.z.a(2);
        if (locald != null) {
            locald.g();
        }
        if (this.A == 2) {
            I();
            D().b(mobi.ifunny.main.a.b.f);
            return;
        }
        g(paramString);
    }

    protected void f() {
        UserStat localUserStat = this.a.num;
        localUserStat.subscribers -= 1;
        this.a.is_in_subscriptions = false;
        r();
        p();
    }

    protected void g() {
    }

    protected void h() {
        UserStat localUserStat = this.a.num;
        localUserStat.subscribers += 1;
        this.a.is_in_subscriptions = true;
        r();
        p();
    }

    public boolean i() {
        return false;
    }

    public void j() {
        Object localObject = D();
        ((IFunnyMenuActivity) localObject).b(mobi.ifunny.main.a.b.a);
        ((IFunnyMenuActivity) localObject).b(mobi.ifunny.main.a.b.d);
        ((IFunnyMenuActivity) localObject).b(mobi.ifunny.main.a.b.f);
        IFunnyApplication.b.a.a();
        IFunnyApplication.b.c.a();
        localObject = new Intent(getActivity(), IFunnyMenuActivity.class);
        ((Intent) localObject).putExtra("intent.start_fragment", mobi.ifunny.main.a.b.a);
        ((Intent) localObject).setFlags(67108864);
        startActivity((Intent) localObject);
    }

    public void k() {
    }

    public void l() {
        this.B.d();
        this.B.a(null);
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        paramBundle = new uk.co.a.a.b.f();
        paramBundle.a();
        this.B = new uk.co.a.a.a.a.c(getActivity(), paramBundle.b());
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        switch (paramInt1) {
            default:
                super.onActivityResult(paramInt1, paramInt2, paramIntent);
        }
        do {
            do {
                return;
            } while (paramInt2 != -1);
            paramIntent = (User) paramIntent.getParcelableExtra("result.profile");
            if (paramIntent == null) {
                mobi.ifunny.d.d(i, "Profile editor does not return updated profile");
                return;
            }
            mobi.ifunny.d.c(i, "Profile editor updates profile data");
            h.add(u.b);
            a(paramIntent);
            this.a = paramIntent;
            mobi.ifunny.social.auth.l.a().a(getActivity(), paramIntent);
            return;
        } while (paramInt2 != -1);
        paramIntent = (User) paramIntent.getParcelableExtra("result.profile");
        if (paramIntent == null) {
            mobi.ifunny.d.e(i, "Profile settings does not return updated profile");
            return;
        }
        h.add(u.b);
        a(paramIntent);
        this.a = paramIntent;
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            default:
            case 2131493227:
                do {
                    do {
                        return;
                    } while (this.a == null);
                    paramView = this.a.getPhotoUrl();
                } while (paramView == null);
                b(paramView);
                return;
            case 2131493243:
                Toast.makeText(getActivity(), 2131689593, 1).show();
                return;
        }
        if (mobi.ifunny.social.auth.l.a().h()) {
            if ((this.a == null) || (!this.a.is_in_subscriptions)) {
                F();
                return;
            }
            G();
            return;
        }
        startActivity(new Intent(getActivity(), AuthActivity.class));
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setHasOptionsMenu(true);
        this.E = new Handler();
        this.F = new Handler();
        if (paramBundle == null) {
            d(0);
        }
        paramBundle = getArguments();
        if (paramBundle != null) {
            this.A = paramBundle.getInt("ARG_INITIAL_TAB", 0);
        }
    }

    public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
        super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
        if (!this.H) {
            return;
        }
        if (this.d) {
            paramMenuInflater.inflate(2131820561, paramMenu);
            this.C = paramMenu.findItem(2131493381);
            return;
        }
        paramMenuInflater.inflate(2131820562, paramMenu);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903145, paramViewGroup, false);
        this.k = paramLayoutInflater.findViewById(2131493238);
        this.w = paramLayoutInflater.findViewById(2131493248);
        this.y = ((FragmentTabWidget) paramLayoutInflater.findViewById(2131493246));
        this.x = ((ViewPager) paramLayoutInflater.findViewById(2131493249));
        this.l = paramLayoutInflater.findViewById(2131493237);
        this.m = paramLayoutInflater.findViewById(2131493243);
        this.m.setOnClickListener(this);
        this.v = ((ProgressBar) paramLayoutInflater.findViewById(2131493236));
        this.j = ((ViewGroup) paramLayoutInflater.findViewById(2131493241));
        this.u = ((StickyScrollView) paramLayoutInflater.findViewById(2131493239));
        this.u.setStickyScrollListener(this);
        if (getResources().getConfiguration().orientation != 2) {
            this.u.a(this.j, new uk.co.chrisjenx.paralloid.c.a(), 0.6F);
        }
        this.o = ((FrameLayout) paramLayoutInflater.findViewById(2131493227));
        this.o.setOnClickListener(this);
        this.p = ((ImageView) this.o.findViewById(2131493229));
        this.q = this.o.findViewById(2131493228);
        this.r = ((TextView) paramLayoutInflater.findViewById(2131493244));
        this.n = ((ImageView) paramLayoutInflater.findViewById(2131493242));
        this.s = ((ImageView) paramLayoutInflater.findViewById(2131493245));
        this.t = ((Button) paramLayoutInflater.findViewById(2131493247));
        this.t.setOnClickListener(this);
        this.x.setOffscreenPageLimit(mobi.ifunny.profile.fragments.b.a(this.d));
        this.y.setup(this.x);
        if (this.d) {
        }
        for (int i1 = 2131689844; ; i1 = 2131689877) {
            a(2130837925, i1);
            a(2130837916, 2131689843);
            if (this.d) {
                a(2130837923, 2131689768);
                a(2130837924, 2131689743);
                a(2130837922, 2131689741);
            }
            this.y.setFragmentTabStateListener(this);
            this.u.setOnSizeChangedListener(new x(this, null));
            return paramLayoutInflater;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.F.removeCallbacks(this.N);
        this.E.removeCallbacks(this.G);
        this.B.f();
        this.B = null;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
            case 2131493401:
                if (this.a != null) {
                    s();
                }
                return true;
            case 2131493381:
                if ((this.z != null) && (this.x != null) && (this.x.getCurrentItem() == 2)) {
                    ((mobi.ifunny.mynews.d) this.z.a(2)).J();
                }
                return true;
            case 2131493402:
                if (this.a != null) {
                    t();
                }
                return true;
            case 2131493403:
                u();
                return true;
            case 2131493404:
                H();
                return true;
            case 2131493405:
                if (this.a != null) {
                    if (mobi.ifunny.social.auth.l.a().h()) {
                        break label180;
                    }
                    d();
                }
                for (; ; ) {
                    return true;
                    label180:
                    v();
                }
        }
        startActivity(new Intent(getActivity(), StudioActivity.class));
        return true;
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        m();
    }

    public void onResume() {
        super.onResume();
        c(this.a);
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putInt("STATE_PAGER_POSITION", this.x.getCurrentItem());
    }

    public void onViewStateRestored(Bundle paramBundle) {
        if (paramBundle != null) {
            this.A = paramBundle.getInt("STATE_PAGER_POSITION");
        }
        super.onViewStateRestored(paramBundle);
    }

    public boolean y() {
        return (Features.isProfileAdsEnabled()) && (!this.d);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */