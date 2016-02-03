package mobi.ifunny.gallery;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.app.g;
import android.support.v4.view.cg;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import mobi.ifunny.comments.ah;
import mobi.ifunny.d;
import mobi.ifunny.gallery.fragment.IFunnyWorkInfoFragment;
import mobi.ifunny.h;
import mobi.ifunny.main.IFunnyMenuActivity;
import mobi.ifunny.main.i;
import mobi.ifunny.profile.ProfileActivity;
import mobi.ifunny.rest.Features;
import mobi.ifunny.rest.content.Counters;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.IFunny.Source;
import mobi.ifunny.rest.content.IFunnyFeed;
import mobi.ifunny.rest.content.LoadingHelper;
import mobi.ifunny.rest.content.Paging;
import mobi.ifunny.rest.content.Paging.Cursors;
import mobi.ifunny.rest.content.RepublishedCounter;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.content.SmilesCounter;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Content;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.social.auth.AuthActivity;
import mobi.ifunny.studio.StudioActivity;
import mobi.ifunny.util.ai;
import mobi.ifunny.util.cache.IFunnyCache.ListEntry;

public abstract class GalleryFragment<T extends IFunnyFeed>
        extends i
        implements cg, View.OnClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener, mobi.ifunny.gallery.view.e, mobi.ifunny.gallery.view.f {
    private static final String b = GalleryFragment.class.getSimpleName();
    private final PopupMenu.OnMenuItemClickListener A = new m(this);
    private final View.OnClickListener B = new n(this);
    protected boolean a = true;
    @InjectView(2131493122)
    View activityAnchor;
    @InjectView(2131493114)
    View activityBtn;
    @InjectView(2131493105)
    View blackBackground;
    @InjectView(2131493108)
    View bottomPanel;
    private IFunnyCache.ListEntry c;
    @InjectView(2131493115)
    View commentsBtn;
    @InjectView(2131493117)
    TextView commentsCounter;
    private j d;
    private int e;
    @InjectView(2131493093)
    View emptyLayout;
    private String f;
    private boolean g;
    private Map<String, Bundle> h;
    private uk.co.a.a.a.a.c i;
    private mobi.ifunny.popup.b j;
    private TextView k;
    private x l;
    private AnimatorSet m;
    private AnimatorSet n;
    private ImageView o;
    @InjectView(2131493118)
    ImageView overlayAnimationView;
    private TextView p;
    @InjectView(2131493106)
    GalleryViewPager pager;
    @InjectView(2131493107)
    View progressBar;
    private TextView q;
    private Bitmap r;
    private Bitmap s;
    @InjectView(2131493109)
    View smileBtn;
    @InjectView(2131493111)
    TextView smileCounter;
    @InjectView(2131493110)
    ImageView smileImage;
    private PopupMenu t;
    private PopupWindow u;
    @InjectView(2131493112)
    View unsmileBtn;
    @InjectView(2131493113)
    ImageView unsmileImage;
    private mobi.ifunny.gallery.b.a v;
    private mobi.ifunny.popup.a w;
    private long x = 0L;
    private boolean y;
    private Animator.AnimatorListener z = new l(this);

    private void A(IFunny paramIFunny) {
        if (paramIFunny.isUnsmiled()) {
            IFunnyRestRequest.Content.deleteUnsmile(this, "rest.unsmile", paramIFunny.id, f(), new w(paramIFunny, false, false, null));
            return;
        }
        IFunnyRestRequest.Content.putUnsmile(this, "rest.unsmile", paramIFunny.id, f(), new w(paramIFunny, false, true, null));
    }

    private boolean F() {
        return (this.u != null) && (this.u.isShowing());
    }

    @SuppressLint({"RtlHardcoded"})
    private void G() {
        if (F()) {
        }
        do {
            return;
            if (this.y) {
                P();
            }
            android.support.v4.app.k localk = getActivity();
            View localView = View.inflate(localk, 2130903175, null);
            Resources localResources = getResources();
            this.u = new PopupWindow(localView, localResources.getDimensionPixelSize(2131427509), -2, true);
            this.u.setBackgroundDrawable(new ColorDrawable(0));
            this.u.setOutsideTouchable(true);
            this.u.setOnDismissListener(this);
            int i1 = localk.findViewById(2131492867).getHeight();
            int i2 = localResources.getDimensionPixelSize(2131427423);
            this.u.showAtLocation(this.activityBtn, 85, 0, i1 + i2);
        } while (this.j == null);
        this.j.n();
    }

    private boolean H() {
        return (this.w != null) && (this.w.isShowing());
    }

    private void I() {
        IFunny localIFunny = x();
        if (localIFunny != null) {
            mobi.ifunny.util.e.a(getActivity(), localIFunny.link);
            Toast.makeText(getActivity(), 2131689618, 0).show();
        }
    }

    private void J() {
        IFunny localIFunny = x();
        if (localIFunny != null) {
            ai.b(getActivity(), localIFunny.title, localIFunny.link);
            IFunnyRestRequest.Content.contentStat(this, "TASK_SHARE_OTHER_STAT", null, localIFunny.id, "share", "unknown");
        }
    }

    private void K() {
        mobi.ifunny.gallery.fragment.f localf = w();
        if (localf != null) {
            localf.i();
        }
    }

    private void L() {
        IFunny localIFunny = x();
        if (localIFunny != null) {
            p(localIFunny);
        }
    }

    private void M() {
        a(0.0F);
    }

    private void N() {
        IFunny localIFunny = x();
        if (localIFunny != null) {
            l(localIFunny);
        }
    }

    private void O() {
        IFunny localIFunny = x();
        if (localIFunny != null) {
            j(localIFunny);
        }
    }

    private void P() {
        if (!this.y) {
        }
        for (boolean bool = true; ; bool = false) {
            a(bool, true);
            IFunnyMenuActivity localIFunnyMenuActivity = D();
            if (localIFunnyMenuActivity != null) {
                localIFunnyMenuActivity.c(true);
            }
            return;
        }
    }

    private void Q() {
        if ((getActivity() == null) || (this.d == null) || (this.pager == null)) {
        }
        for (; ; ) {
            return;
            boolean bool1 = u();
            boolean bool2 = v();
            int i3 = this.d.getCount();
            int i4 = this.pager.getOffscreenPageLimit();
            int i2 = R();
            if (i2 >= 0) {
                int i1 = Math.max(i2 - i4, 0);
                i3 = Math.min(i4 + i2, i3 - 1);
                while (i1 <= i3) {
                    if (i1 != i2) {
                        mobi.ifunny.gallery.fragment.f localf = d(i1);
                        if (localf != null) {
                            localf.a(bool1, bool2);
                        }
                    }
                    i1 += 1;
                }
            }
        }
    }

    private int R() {
        if (this.pager == null) {
            return -1;
        }
        return this.pager.getCurrentItem();
    }

    private void S() {
        String str2 = e();
        if (this.y) {
        }
        for (String str1 = "fullscreen"; ; str1 = "normal") {
            mobi.ifunny.b.a.a(str2, str1);
            return;
        }
    }

    private void T() {
        com.makeramen.c localc = new com.makeramen.c(this.r);
        localc.a(true);
        this.o.setImageDrawable(localc);
        this.o.setTag("silhouette");
        this.o.getBackground().setLevel(0);
    }

    private void U() {
        com.makeramen.c localc = new com.makeramen.c(this.s);
        localc.a(true);
        this.o.setImageDrawable(localc);
        this.o.setTag("banned");
        this.o.getBackground().setLevel(0);
    }

    private float a(mobi.ifunny.gallery.fragment.m paramm) {
        switch (o.a[paramm.ordinal()]) {
            default:
                return 1.0F;
        }
        return 0.0F;
    }

    private Bundle a(String paramString, Parcelable paramParcelable) {
        Bundle localBundle = new Bundle();
        localBundle.putString("auth.action", paramString);
        localBundle.putParcelable("auth.data", paramParcelable);
        return localBundle;
    }

    private static String a(int paramInt, String paramString) {
        return "LOAD_AVATAR_TAG_BASE" + paramInt + paramString;
    }

    private void a(Drawable paramDrawable, String paramString) {
        this.o.setImageDrawable(paramDrawable);
        this.o.setTag(paramString);
        this.o.getBackground().setLevel(0);
    }

    private void a(View paramView, boolean paramBoolean) {
        Object localObject = getActivity();
        if (paramBoolean) {
        }
        for (int i1 = 2131034122; ; i1 = 2131034123) {
            localObject = AnimatorInflater.loadAnimator((Context) localObject, i1);
            ((Animator) localObject).setTarget(paramView);
            ((Animator) localObject).start();
            return;
        }
    }

    private void a(List<IFunny> paramList1, List<IFunny> paramList2) {
        int i3 = paramList2.size();
        int i4 = paramList1.size();
        int i1 = 0;
        label65:
        label112:
        label222:
        label224:
        label228:
        for (; ; ) {
            IFunny localIFunny;
            if (i1 < paramList2.size()) {
                localIFunny = (IFunny) paramList2.get(i1);
                if (e(localIFunny)) {
                    paramList2.remove(i1);
                    continue;
                }
                i2 = i1 - 1;
                if (i2 < 0) {
                    break label224;
                }
                if (a((IFunny) paramList2.get(i2), localIFunny)) {
                    paramList2.remove(i1);
                }
            }
            for (int i2 = 1; ; i2 = 0) {
                if (i2 != 0) {
                    break label228;
                }
                i2 = i4 - 1;
                if (i2 >= 0) {
                    if (a((IFunny) paramList1.get(i2), localIFunny)) {
                        paramList2.remove(i1);
                    }
                }
                for (i2 = 1; ; i2 = 0) {
                    if (i2 != 0) {
                        break label222;
                    }
                    i1 += 1;
                    break;
                    i2 -= 1;
                    break label65;
                    i2 -= 1;
                    break label112;
                    d.c(b, String.format("filterFeedUpdate filtered %d of %d", new Object[]{Integer.valueOf(i3 - paramList2.size()), Integer.valueOf(i3)}));
                    return;
                }
                break;
            }
        }
    }

    private void a(IFunny paramIFunny, String paramString) {
        mobi.ifunny.util.a.a locala = new mobi.ifunny.util.a.a(paramString, new Point(this.o.getWidth(), this.o.getHeight()), false);
        paramIFunny = a(paramIFunny.uniqueId, paramString);
        if (!f(paramIFunny)) {
            new u(this, locala, paramIFunny).execute(new String[]{paramString});
        }
    }

    private void a(IFunny paramIFunny, RepublishedCounter paramRepublishedCounter) {
        h(paramIFunny);
    }

    private void a(User paramUser, IFunny paramIFunny) {
        if (paramUser == null) {
            this.p.setText(getString(2131689661));
            T();
        }
        do {
            return;
            this.p.setText(paramUser.nick);
            if (paramUser.is_banned) {
                U();
                return;
            }
            paramUser = paramUser.getPhotoThumbSmallUrl();
        } while ((TextUtils.equals((String) this.o.getTag(), paramUser)) && (this.o.getDrawable() != null));
        if (TextUtils.isEmpty(paramUser)) {
            T();
            return;
        }
        a(paramIFunny, paramUser);
    }

    private void a(boolean paramBoolean1, boolean paramBoolean2) {
        if ((isDetached()) || (isRemoving())) {
            return;
        }
        android.support.v7.a.a locala;
        if ((paramBoolean2) && (this.m != null) && (this.n != null)) {
            if (paramBoolean1) {
                if ((this.m.isRunning()) || (this.m.isStarted())) {
                    this.m.cancel();
                }
                this.n.start();
                locala = a();
                if (!paramBoolean1) {
                    break label139;
                }
                locala.g();
            }
        }
        for (; ; ) {
            this.y = paramBoolean1;
            Q();
            return;
            if ((this.n.isRunning()) || (this.n.isStarted())) {
                this.n.cancel();
            }
            this.m.start();
            break;
            c(paramBoolean1);
            break;
            label139:
            locala.f();
        }
    }

    private void b(Bundle paramBundle) {
        Intent localIntent = new Intent(getActivity(), AuthActivity.class);
        localIntent.putExtra("intent.callback.params", paramBundle);
        startActivityForResult(localIntent, 0);
    }

    private void b(String paramString) {
        if (!TextUtils.isEmpty(paramString)) {
            Intent localIntent = new Intent(getActivity(), ProfileActivity.class);
            localIntent.putExtra("intent.uid", paramString);
            startActivity(localIntent);
        }
    }

    private void c(boolean paramBoolean) {
        if ((getActivity() == null) || (isDetached()) || (isRemoving())) {
            return;
        }
        View localView = getActivity().getWindow().getDecorView();
        if (paramBoolean) {
        }
        for (int i1 = 1; ; i1 = 0) {
            localView.setSystemUiVisibility(i1);
            return;
        }
    }

    private void h(int paramInt) {
        s locals = new s(paramInt, null);
        Paging localPaging;
        if (paramInt == 1) {
            localPaging = this.d.f();
            if (localPaging.hasNext) {
                d.c(b, "request next");
                b(null, localPaging.cursors.next, locals);
            }
        }
        do {
            do {
                return;
                if (paramInt != -1) {
                    break;
                }
                localPaging = this.d.e();
            } while (!localPaging.hasPrev);
            d.c(b, "request prev");
            b(localPaging.cursors.prev, null, locals);
            return;
        } while (paramInt != 0);
        d.c(b, "request init");
        b(null, null, locals);
    }

    private void i(int paramInt) {
        if (paramInt >= this.d.getCount() - 4) {
            h(1);
        }
    }

    private void j(IFunny paramIFunny) {
        if (mobi.ifunny.social.auth.l.a().h()) {
            k(paramIFunny);
            return;
        }
        b(a("abuse", paramIFunny));
    }

    private void k(IFunny paramIFunny) {
        mobi.ifunny.gallery.fragment.a.a(paramIFunny, getTag()).a(getActivity().f(), "dialog.abuse");
    }

    private void l(IFunny paramIFunny) {
        if (mobi.ifunny.social.auth.l.a().h()) {
            m(paramIFunny);
            return;
        }
        b(a("delete", paramIFunny));
    }

    private void m(IFunny paramIFunny) {
        mobi.ifunny.gallery.fragment.c.a(paramIFunny, getTag()).a(getActivity().f(), "dialog.delete");
    }

    private void n(IFunny paramIFunny) {
        if (H()) {
        }
        do {
            return;
            this.v.a(paramIFunny, h());
            int i1 = getResources().getDimensionPixelSize(2131427346);
            this.w = new mobi.ifunny.popup.a(getActivity());
            this.w.setAnchorView(this.activityAnchor);
            this.w.setAdapter(this.v);
            this.w.setContentWidth(i1);
            this.w.setOnItemClickListener(this);
            this.w.setOnDismissListener(this);
            this.w.show();
        } while (this.j == null);
        this.j.n();
    }

    private boolean o(IFunny paramIFunny) {
        return (paramIFunny != null) && (TextUtils.equals(paramIFunny.type, "_meanwhile"));
    }

    private void p(IFunny paramIFunny) {
        if (mobi.ifunny.social.auth.l.a().h()) {
            q(paramIFunny);
            return;
        }
        b(a("republish", paramIFunny));
    }

    private void q(IFunny paramIFunny) {
        if (paramIFunny.isRepublished()) {
            IFunnyRestRequest.Content.deleteRepublishContent(this, "DELETE_LIKE_TAG", paramIFunny.id, f(), new r(paramIFunny, null));
            this.l.f();
            return;
        }
        IFunnyRestRequest.Content.republishContent(this, "PUT_LIKE_TAG", paramIFunny.id, f(), new v(paramIFunny, null));
        paramIFunny = h.a();
        if (paramIFunny.a("user.knows.about.republish", false)) {
            this.l.e();
            return;
        }
        new AlertDialog.Builder(getActivity()).setTitle(null).setCancelable(true).setMessage(2131689621).setPositiveButton(2131689673, null).show();
        paramIFunny.b("user.knows.about.republish", true);
    }

    private void r(IFunny paramIFunny) {
        paramIFunny.setRepublished(true);
        Counters localCounters = paramIFunny.num;
        localCounters.republished += 1;
        w(paramIFunny);
    }

    private void s(IFunny paramIFunny) {
        if (paramIFunny.num.republished > 0) {
            Counters localCounters = paramIFunny.num;
            localCounters.republished -= 1;
        }
        w(paramIFunny);
    }

    private void t(IFunny paramIFunny) {
        paramIFunny.setRepublished(false);
        if (paramIFunny.num.republished > 0) {
            Counters localCounters = paramIFunny.num;
            localCounters.republished -= 1;
        }
        w(paramIFunny);
    }

    private void u(IFunny paramIFunny) {
        Counters localCounters = paramIFunny.num;
        localCounters.republished += 1;
        w(paramIFunny);
    }

    private void v(IFunny paramIFunny) {
        h(paramIFunny);
    }

    private void w(IFunny paramIFunny) {
        IFunny localIFunny = x();
        if (paramIFunny.equals(localIFunny)) {
            localIFunny.setRepublished(paramIFunny.isRepublished());
            localIFunny.num.republished = paramIFunny.num.republished;
            t();
        }
    }

    private boolean x(IFunny paramIFunny) {
        if (mobi.ifunny.social.auth.l.a().h()) {
            y(paramIFunny);
            return true;
        }
        b(a("smile", paramIFunny));
        return false;
    }

    private void y(IFunny paramIFunny) {
        if (paramIFunny.isSmiled()) {
            IFunnyRestRequest.Content.deleteSmile(this, "rest.smile", paramIFunny.id, f(), new w(paramIFunny, true, false, null));
        }
        do {
            return;
            IFunnyRestRequest.Content.putSmile(this, "rest.smile", paramIFunny.id, f(), new w(paramIFunny, true, true, null));
            paramIFunny = h.a();
        } while (paramIFunny.a("tutorial.gallery.shown", false));
        G();
        paramIFunny.b("tutorial.gallery.shown", true);
    }

    private boolean z(IFunny paramIFunny) {
        if (mobi.ifunny.social.auth.l.a().h()) {
            A(paramIFunny);
            return true;
        }
        b(a("unsmile", paramIFunny));
        return false;
    }

    protected int a(Bundle paramBundle) {
        return paramBundle.getInt("STATE_POSITION");
    }

    protected j a(android.support.v4.app.q paramq, Bundle paramBundle, Map<String, Bundle> paramMap) {
        return new j(paramq, (IFunnyCache.ListEntry) paramBundle.getParcelable("STATE_DATA"), paramMap);
    }

    public void a(float paramFloat, boolean paramBoolean) {
        ViewPropertyAnimator localViewPropertyAnimator = this.blackBackground.animate();
        if (paramBoolean) {
        }
        for (long l1 = 300L; ; l1 = 0L) {
            localViewPropertyAnimator.setDuration(l1).alpha(paramFloat);
            return;
        }
    }

    public void a(int paramInt) {
        if (this.w != null) {
            this.w.dismiss();
        }
        int i1 = this.d.getCount();
        IFunny localIFunny = this.d.a(paramInt);
        String str = b;
        StringBuilder localStringBuilder = new StringBuilder().append("onPageSelected ");
        Object localObject;
        if (localIFunny == null) {
            localObject = "null";
            d.c(str, localObject + " (" + paramInt + " of " + i1 + ")");
            i(paramInt);
            this.e = paramInt;
            S();
            a("content_view");
            localObject = D();
            if (localObject != null) {
                if ((!k()) || (paramInt <= 0) || (paramInt % 20 != 0)) {
                    break label194;
                }
            }
        }
        label194:
        for (paramInt = 1; ; paramInt = 0) {
            boolean bool = o(localIFunny);
            if ((paramInt != 0) || (bool)) {
                ((IFunnyMenuActivity) localObject).q();
            }
            this.g = false;
            return;
            localObject = Integer.valueOf(localIFunny.uniqueId);
            break;
        }
    }

    public void a(int paramInt1, float paramFloat, int paramInt2) {
        mobi.ifunny.gallery.fragment.f localf1;
        if (paramInt2 > 0) {
            paramInt2 = 1;
            localf1 = d(paramInt1);
            if ((paramInt1 != 0) || (paramInt2 != 0)) {
                break label27;
            }
        }
        label27:
        float f2;
        label103:
        do {
            return;
            paramInt2 = 0;
            break;
            if (paramInt2 != 0) {
                paramInt1 += 1;
            }
            for (; ; ) {
                mobi.ifunny.gallery.fragment.f localf2 = d(paramInt1);
                if ((localf1 == null) || (localf2 == null)) {
                    break;
                }
                float f1 = a(localf1.c());
                f2 = a(localf2.c());
                if (f1 == f2) {
                    break;
                }
                if (f2 != 1.0F) {
                    break label103;
                }
                a(paramFloat, false);
                return;
                paramInt1 -= 1;
            }
        } while (f2 != 0.0F);
        a(1.0F - paramFloat, false);
    }

    protected void a(int paramInt, T paramT) {
        if (paramT == null) {
            return;
        }
        if (paramT.size() > 0) {
            a(this.d.c().e(), paramT.getList());
        }
        int i1;
        if (this.d.getCount() == 0) {
            i1 = 1;
            paramT = paramT.getContent();
            if ((paramInt != 1) && (paramInt != 0)) {
                break label86;
            }
            this.d.a(paramT);
            label64:
            if (i1 == 0) {
                break label97;
            }
            r();
        }
        for (; ; ) {
            i(this.e);
            return;
            i1 = 0;
            break;
            label86:
            this.d.b(paramT);
            break label64;
            label97:
            t();
        }
    }

    protected void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
        IFunny localIFunny = f(paramInt);
        if (localIFunny != null) {
            if (!paramBoolean1) {
                break label42;
            }
            localIFunny.setSmiled(paramBoolean2);
            if (g(paramInt)) {
                this.g = paramBoolean2;
            }
        }
        for (; ; ) {
            i(localIFunny);
            return;
            label42:
            localIFunny.setUnsmiled(paramBoolean2);
        }
    }

    protected void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, SmilesCounter paramSmilesCounter) {
        IFunny localIFunny = f(paramInt);
        if (localIFunny != null) {
            localIFunny.num.smiles = paramSmilesCounter.num_smiles;
            localIFunny.num.unsmiles = paramSmilesCounter.num_unsmiles;
            mobi.ifunny.profile.l.h.add(mobi.ifunny.profile.u.d);
            i(localIFunny);
        }
    }

    protected void a(Bitmap paramBitmap, mobi.ifunny.util.a.a parama) {
        IFunny localIFunny = x();
        if ((localIFunny != null) && (TextUtils.equals(localIFunny.getPhotoUrl_ForGalleryCreatorAvatar(), parama.c()))) {
            if (paramBitmap == null) {
                T();
            }
        } else {
            return;
        }
        paramBitmap = new com.makeramen.c(paramBitmap);
        paramBitmap.a(true);
        a(paramBitmap, parama.c());
    }

    protected void a(Bundle paramBundle, int paramInt) {
        if (paramBundle != null) {
            paramBundle.putInt("STATE_POSITION", paramInt);
        }
    }

    protected void a(Bundle paramBundle, j paramj) {
        if (paramBundle != null) {
            paramBundle.putParcelable("STATE_DATA", paramj.c());
        }
    }

    protected void a(View paramView) {
    }

    protected void a(String paramString) {
        if ((!Features.isInnerStatTurnedOn()) || (!l())) {
        }
        IFunny localIFunny;
        do {
            return;
            localIFunny = x();
        } while ((localIFunny == null) || (TextUtils.isEmpty(localIFunny.id)));
        mobi.ifunny.b.c.a(this, e(), paramString, localIFunny.id);
    }

    protected abstract void a(String paramString1, String paramString2, RestHttpHandler<T, GalleryFragment> paramRestHttpHandler);

    protected void a(t paramt) {
        switch (o.c[paramt.ordinal()]) {
            default:
                return;
            case 1:
                this.emptyLayout.setVisibility(8);
                this.progressBar.setVisibility(0);
                this.pager.setVisibility(4);
                this.bottomPanel.setVisibility(4);
                return;
            case 2:
                this.emptyLayout.setVisibility(8);
                this.progressBar.setVisibility(8);
                this.pager.setVisibility(0);
                this.bottomPanel.setVisibility(0);
                return;
        }
        this.emptyLayout.setVisibility(0);
        this.progressBar.setVisibility(8);
        this.pager.setVisibility(4);
        this.bottomPanel.setVisibility(4);
    }

    public void a(IFunny paramIFunny) {
        IFunnyRestRequest.Content.putAbuse(this, getTag(), paramIFunny.id, f(), new p(paramIFunny, null));
    }

    public void a(RestError paramRestError) {
        if ((paramRestError != null) && (paramRestError.status == 403) && (TextUtils.equals(paramRestError.error, "entity_abused"))) {
            Toast.makeText(getActivity(), 2131689613, 0).show();
        }
    }

    public void a(IFunnyCache.ListEntry paramListEntry) {
        this.c = paramListEntry;
    }

    public void a(uk.co.a.a.b.a.b paramb) {
        this.i.a(paramb);
        this.i.a(true);
    }

    public boolean a(float paramFloat) {
        Object localObject = x();
        if ((localObject != null) && (((IFunny) localObject).isAbused())) {
        }
        do {
            return false;
            localObject = w();
        } while ((localObject == null) || (((mobi.ifunny.gallery.fragment.f) localObject).b()));
        mobi.ifunny.gallery.fragment.m localm = ((mobi.ifunny.gallery.fragment.f) localObject).c();
        switch (o.a[localm.ordinal()]) {
        }
        for (; ; ) {
            t();
            return true;
            ((mobi.ifunny.gallery.fragment.f) localObject).d();
            continue;
            ((mobi.ifunny.gallery.fragment.f) localObject).g();
        }
    }

    protected boolean a(IFunny paramIFunny1, IFunny paramIFunny2) {
        return (e(paramIFunny2)) || (TextUtils.equals(paramIFunny1.id, paramIFunny2.id));
    }

    protected String b() {
        return null;
    }

    public void b(int paramInt) {
        int i2 = 0;
        int i3 = R();
        int i4 = this.pager.getOffscreenPageLimit();
        int i1 = Math.max(i3 - i4, 0);
        i3 = Math.min(i3 + i4, this.d.getCount() - 1);
        mobi.ifunny.gallery.fragment.f localf;
        while (i1 <= i3) {
            localf = d(i1);
            if ((localf != null) && (localf.j() != null)) {
                localf.a(paramInt);
            }
            i1 += 1;
        }
        if (paramInt == 0) {
            Q();
            localf = w();
            if (localf != null) {
                paramInt = i2;
                if (localf.c() == mobi.ifunny.gallery.fragment.m.a) {
                    paramInt = 1;
                }
                if (paramInt == 0) {
                    break label134;
                }
            }
        }
        label134:
        for (float f1 = 1.0F; ; f1 = 0.0F) {
            a(f1, true);
            return;
        }
    }

    public void b(View paramView) {
        if (!isResumed()) {
        }
        do {
            do {
                return;
            } while (x() == null);
            paramView = w();
        } while ((paramView == null) || (paramView.c() != mobi.ifunny.gallery.fragment.m.a) || (getActivity() == null));
        P();
    }

    protected void b(String paramString1, String paramString2, RestHttpHandler<T, GalleryFragment> paramRestHttpHandler) {
        if (f(p())) {
            d.b(b, "Do not request feed - already running");
            return;
        }
        a(paramString1, paramString2, paramRestHttpHandler);
    }

    public void b(IFunny paramIFunny) {
        Toast.makeText(getActivity(), 2131689614, 0).show();
        i(paramIFunny);
    }

    public void b(uk.co.a.a.b.a.b paramb) {
        if (paramb == this.i.e()) {
            this.i.a(null);
            this.i.d();
        }
    }

    public void b(boolean paramBoolean) {
        this.a = paramBoolean;
        B();
    }

    public boolean b(float paramFloat) {
        Object localObject = x();
        if ((localObject != null) && (((IFunny) localObject).isAbused())) {
        }
        do {
            return false;
            localObject = w();
        } while ((localObject == null) || (((mobi.ifunny.gallery.fragment.f) localObject).b()));
        mobi.ifunny.gallery.fragment.m localm = ((mobi.ifunny.gallery.fragment.f) localObject).c();
        switch (o.a[localm.ordinal()]) {
        }
        for (; ; ) {
            t();
            return true;
            ((mobi.ifunny.gallery.fragment.f) localObject).f();
            continue;
            ((mobi.ifunny.gallery.fragment.f) localObject).e();
        }
    }

    protected void c(int paramInt) {
        if (paramInt == 0) {
            a(t.b);
            a(false, false);
        }
    }

    public void c(View paramView) {
        if (!isResumed()) {
        }
        do {
            return;
            paramView = x();
        } while ((paramView == null) || (paramView.isAbused()) || (!mobi.ifunny.social.auth.l.a().h()));
        if (paramView.isSmiled()) {
            this.l.b();
            a(this.smileImage, true);
        }
        for (; ; ) {
            y(paramView);
            return;
            this.l.a();
            a(this.smileImage, false);
        }
    }

    public void c(IFunny paramIFunny) {
        IFunnyRestRequest.Content.deleteContent(this, getTag(), paramIFunny.id, new q(paramIFunny, null));
    }

    protected boolean c() {
        return false;
    }

    public String d() {
        return "OtherFeed";
    }

    public mobi.ifunny.gallery.fragment.f d(int paramInt) {
        if (this.d == null) {
            return null;
        }
        return this.d.b(paramInt);
    }

    public void d(View paramView) {
        if (!isResumed()) {
        }
        do {
            do {
                return;
            } while (!g());
            paramView = x();
        } while ((paramView == null) || (paramView.isAbused()) || (!mobi.ifunny.social.auth.l.a().h()));
        if (paramView.isUnsmiled()) {
            this.l.d();
            a(this.unsmileImage, true);
        }
        for (; ; ) {
            A(paramView);
            return;
            this.l.c();
            a(this.unsmileImage, false);
        }
    }

    public void d(IFunny paramIFunny) {
        this.d.b(paramIFunny);
        if (this.d.getCount() == 0) {
            getActivity().finish();
            return;
        }
        a(this.pager.getCurrentItem());
    }

    public String e() {
        return "feed_unknown";
    }

    protected IFunny e(int paramInt) {
        if (this.d == null) {
            return null;
        }
        return this.d.a(paramInt);
    }

    public void e(View paramView) {
        if (!isResumed()) {
        }
        do {
            mobi.ifunny.gallery.fragment.f localf;
            do {
                return;
                paramView = x();
                localf = w();
            } while ((localf == null) || (localf.b()) || (paramView == null) || (paramView.isAbused()));
            n(paramView);
        } while (this.pager == null);
        this.pager.performHapticFeedback(0);
    }

    protected boolean e(IFunny paramIFunny) {
        if ((TextUtils.isEmpty(paramIFunny.id)) && (!TextUtils.equals(paramIFunny.type, "_meanwhile"))) {
            return true;
        }
        return TextUtils.isEmpty(paramIFunny.type);
    }

    protected String f() {
        return null;
    }

    protected IFunny f(int paramInt) {
        if ((this.d == null) || (this.d.getCount() == 0)) {
            return null;
        }
        return this.d.c(paramInt);
    }

    protected void f(IFunny paramIFunny) {
        paramIFunny.setRepublished(false);
        if (paramIFunny.num.republished > 0) {
            Counters localCounters = paramIFunny.num;
            localCounters.republished -= 1;
        }
        w(paramIFunny);
    }

    protected void g(IFunny paramIFunny) {
        paramIFunny.setRepublished(false);
        if (paramIFunny.num.republished > 0) {
            Counters localCounters = paramIFunny.num;
            localCounters.republished -= 1;
        }
        w(paramIFunny);
    }

    public boolean g() {
        return false;
    }

    protected boolean g(int paramInt) {
        IFunny localIFunny = x();
        return (localIFunny != null) && (localIFunny.uniqueId == paramInt);
    }

    protected int h() {
        return 1;
    }

    protected void h(IFunny paramIFunny) {
    }

    public void i(IFunny paramIFunny) {
        if (paramIFunny.equals(x())) {
            t();
        }
    }

    public boolean i() {
        return false;
    }

    protected boolean j() {
        return false;
    }

    protected boolean k() {
        return true;
    }

    protected boolean l() {
        return true;
    }

    protected boolean m() {
        return false;
    }

    public Object n() {
        return new Object();
    }

    public j o() {
        return this.d;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        paramBundle = a();
        paramBundle.b(true);
        paramBundle.a(b());
        paramBundle.c(true);
        paramBundle.a(2130903097);
        paramBundle.c(false);
        paramBundle = paramBundle.b();
        paramBundle.findViewById(2131493072).setOnClickListener(this.B);
        this.o = ((ImageView) paramBundle.findViewById(2131493071));
        this.o.getBackground().setLevel(1);
        this.o.setOnClickListener(this.B);
        this.p = ((TextView) paramBundle.findViewById(2131493073));
        this.q = ((TextView) paramBundle.findViewById(2131493074));
        this.r = BitmapFactory.decodeResource(getResources(), 2130837610);
        this.s = BitmapFactory.decodeResource(getResources(), 2130837611);
        this.t = new PopupMenu(getActivity(), paramBundle);
        this.t.inflate(2131820556);
        this.t.setOnMenuItemClickListener(this.A);
        paramBundle = new uk.co.a.a.b.f();
        paramBundle.a(0.85F);
        paramBundle.a();
        this.i = new uk.co.a.a.a.a.c(getActivity(), paramBundle.b());
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        int i1 = -1;
        switch (paramInt1) {
            default:
                super.onActivityResult(paramInt1, paramInt2, paramIntent);
        }
        do {
            return;
        }
        while ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.hasExtra("auth.action")) || (!paramIntent.hasExtra("auth.data")));
        String str = paramIntent.getStringExtra("auth.action");
        paramIntent = (IFunny) paramIntent.getParcelableExtra("auth.data");
        switch (str.hashCode()) {
            default:
                paramInt1 = i1;
        }
        for (; ; ) {
            switch (paramInt1) {
                default:
                    return;
                case 0:
                    l(paramIntent);
                    return;
                paramInt1 = i1;
                if (str.equals("delete")) {
                    paramInt1 = 0;
                    continue;
                    paramInt1 = i1;
                    if (str.equals("abuse")) {
                        paramInt1 = 1;
                        continue;
                        paramInt1 = i1;
                        if (str.equals("smile")) {
                            paramInt1 = 2;
                            continue;
                            paramInt1 = i1;
                            if (str.equals("unsmile")) {
                                paramInt1 = 3;
                                continue;
                                paramInt1 = i1;
                                if (str.equals("republish")) {
                                    paramInt1 = 4;
                                }
                            }
                        }
                    }
                }
                break;
            }
        }
        j(paramIntent);
        return;
        x(paramIntent);
        return;
        z(paramIntent);
        return;
        p(paramIntent);
    }

    public void onAttach(Activity paramActivity) {
        super.onAttach(paramActivity);
        try {
            this.j = ((mobi.ifunny.popup.b) paramActivity);
            return;
        } catch (ClassCastException paramActivity) {
        }
    }

    public void onClick(View paramView) {
        long l1 = SystemClock.uptimeMillis();
        int i1;
        if (l1 - this.x > 250L) {
            this.x = l1;
            i1 = paramView.getId();
            switch (i1) {
            }
        }
        do {
            boolean bool;
            do {
                do {
                    do {
                        do {
                            return;
                            P();
                            return;
                            paramView = w();
                        } while (paramView == null);
                        paramView = paramView.j();
                    } while (paramView == null);
                    switch (i1) {
                        case 2131493110:
                        case 2131493111:
                        case 2131493113:
                        default:
                            return;
                        case 2131493109:
                            bool = paramView.isSmiled();
                    }
                } while (!x(paramView));
                if (bool) {
                    this.l.b();
                }
                for (; ; ) {
                    a(this.smileImage, bool);
                    return;
                    this.l.a();
                }
                bool = paramView.isUnsmiled();
            } while (!z(paramView));
            if (bool) {
                this.l.d();
            }
            for (; ; ) {
                a(this.unsmileImage, bool);
                return;
                this.l.c();
            }
            n(paramView);
            return;
            paramView = w();
        } while ((paramView == null) || (paramView.c() != mobi.ifunny.gallery.fragment.m.a));
        paramView.f();
        t();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setHasOptionsMenu(true);
        Object localObject = getArguments();
        if (localObject != null) {
            this.f = ((Bundle) localObject).getString("ARG_SELECTED_ID");
            this.h = ((Map) ((Bundle) localObject).getSerializable("ARG_OPTION_ARGS"));
        }
        if (paramBundle == null) {
            localObject = getChildFragmentManager();
            if (this.c != null) {
                break label113;
            }
            this.d = new j((android.support.v4.app.q) localObject, new IFunnyCache.ListEntry(), this.h);
            this.e = 0;
        }
        for (; ; ) {
            this.y = false;
            this.v = new mobi.ifunny.gallery.b.a();
            if (paramBundle == null) {
                S();
            }
            return;
            label113:
            this.d = new j((android.support.v4.app.q) localObject, this.c, this.h);
            this.e = this.c.a;
            a(null);
        }
    }

    public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
        super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
        paramMenuInflater.inflate(2131820555, paramMenu);
        paramMenu.findItem(2131493380).setVisible(false);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903113, paramViewGroup, false);
        ButterKnife.inject(this, paramLayoutInflater);
        this.pager.setOffscreenPageLimit(2);
        this.pager.setOnPageChangeListener(this);
        this.progressBar.setOnClickListener(this);
        this.l = new x(getActivity(), this.overlayAnimationView);
        this.m = ((AnimatorSet) AnimatorInflater.loadAnimator(getActivity(), 2131034119));
        this.m.setTarget(this.bottomPanel);
        this.m.addListener(this.z);
        this.n = ((AnimatorSet) AnimatorInflater.loadAnimator(getActivity(), 2131034120));
        this.n.setTarget(this.bottomPanel);
        this.n.addListener(this.z);
        this.smileBtn.setOnClickListener(this);
        this.smileCounter.setText("…");
        this.unsmileBtn.setOnClickListener(this);
        if (g()) {
            this.unsmileBtn.setVisibility(0);
        }
        this.commentsBtn.setOnClickListener(this);
        this.commentsCounter.setText("…");
        this.activityBtn.setOnClickListener(this);
        a(this.emptyLayout);
        return paramLayoutInflater;
    }

    public void onDestroy() {
        super.onDestroy();
        this.i.f();
        this.i = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.l.g();
        if (this.m != null) {
            this.m.removeAllListeners();
            this.m.cancel();
            this.m = null;
        }
        if (this.n != null) {
            this.n.removeAllListeners();
            this.n.cancel();
            this.n = null;
        }
        ButterKnife.reset(this);
    }

    public void onDismiss() {
        if (this.j != null) {
            this.j.o();
        }
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        this.w.dismiss();
        paramAdapterView = this.v.a(paramInt);
        switch (o.b[paramAdapterView.ordinal()]) {
            default:
                return;
            case 1:
                I();
                return;
            case 2:
                J();
                return;
            case 3:
                K();
                return;
            case 4:
            case 5:
                L();
                return;
            case 6:
                M();
                return;
            case 7:
                N();
                return;
        }
        O();
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        boolean bool2 = true;
        boolean bool1;
        switch (paramMenuItem.getItemId()) {
            default:
                bool1 = super.onOptionsItemSelected(paramMenuItem);
        }
        do {
            do {
                do {
                    do {
                        do {
                            return bool1;
                            paramMenuItem = w();
                            bool1 = bool2;
                        } while (paramMenuItem == null);
                        switch (o.a[paramMenuItem.c().ordinal()]) {
                            default:
                                return true;
                            case 2:
                                paramMenuItem = paramMenuItem.m();
                                bool1 = bool2;
                        }
                    } while (paramMenuItem == null);
                    paramMenuItem.c();
                    return true;
                    paramMenuItem = paramMenuItem.l();
                    bool1 = bool2;
                } while (paramMenuItem == null);
                paramMenuItem.b(true);
                return true;
                startActivity(new Intent(getActivity(), StudioActivity.class));
                return true;
                paramMenuItem = w();
                bool1 = bool2;
            } while (paramMenuItem == null);
            switch (o.a[paramMenuItem.c().ordinal()]) {
                default:
                    return true;
            }
            paramMenuItem = paramMenuItem.m();
            bool1 = bool2;
        } while (paramMenuItem == null);
        paramMenuItem.d();
        return true;
    }

    public void onPause() {
        super.onPause();
        a(null, this.d);
        a(null, this.pager.getCurrentItem());
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        boolean bool = true;
        super.onPrepareOptionsMenu(paramMenu);
        Object localObject1 = paramMenu.findItem(2131493381);
        Object localObject2 = paramMenu.findItem(2131493393);
        MenuItem localMenuItem = paramMenu.findItem(2131493394);
        paramMenu = paramMenu.findItem(2131493380);
        mobi.ifunny.gallery.fragment.f localf = w();
        if (localf == null) {
            ((MenuItem) localObject1).setVisible(false);
            ((MenuItem) localObject2).setVisible(j());
            localMenuItem.setVisible(c());
            paramMenu.setVisible(false);
            return;
        }
        switch (o.a[localf.c().ordinal()]) {
            default:
                return;
            case 1:
                ((MenuItem) localObject1).setVisible(false);
                ((MenuItem) localObject2).setVisible(j());
                localMenuItem.setVisible(c());
                paramMenu.setVisible(false);
                return;
            case 2:
                ((MenuItem) localObject1).setVisible(true);
                ((MenuItem) localObject2).setVisible(false);
                localMenuItem.setVisible(false);
                localObject1 = mobi.ifunny.social.auth.l.a().d();
                localObject2 = localf.j().getOriginalAuthor();
                if ((localObject2 != null) && (TextUtils.equals((CharSequence) localObject1, ((User) localObject2).id))) {
                }
                for (; ; ) {
                    paramMenu.setVisible(bool);
                    return;
                    bool = false;
                }
        }
        ((MenuItem) localObject1).setVisible(true);
        ((MenuItem) localObject2).setVisible(false);
        localMenuItem.setVisible(false);
        paramMenu.setVisible(false);
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putString("STATE_SELECTED_ID", this.f);
        paramBundle.putBoolean("STATE_FULLSCREEN", this.y);
        paramBundle.putBoolean("state.tutorial", F());
        a(paramBundle, this.d);
        a(paramBundle, this.pager.getCurrentItem());
    }

    public void onStart() {
        super.onStart();
        if (E() == null) {
            this.y = false;
        }
        a(this.y, false);
    }

    public void onStop() {
        super.onStop();
        if (H()) {
            this.w.dismiss();
        }
        if (F()) {
            this.u.dismiss();
        }
    }

    public void onViewStateRestored(Bundle paramBundle) {
        super.onViewStateRestored(paramBundle);
        if (paramBundle != null) {
            this.f = paramBundle.getString("STATE_SELECTED_ID");
            this.d = a(getChildFragmentManager(), paramBundle, this.h);
            this.e = a(paramBundle);
            this.y = paramBundle.getBoolean("STATE_FULLSCREEN", false);
            if (paramBundle.getBoolean("state.tutorial", false)) {
                getView().post(new k(this));
            }
        }
        this.pager.setAdapter(this.d);
        if (this.d.getCount() > 0) {
            r();
            return;
        }
        this.d.g();
        this.pager.setAdapter(null);
        this.pager.setAdapter(this.d);
        a(t.a);
        h(0);
    }

    protected String p() {
        return "TASK_REQUEST_FEED";
    }

    public boolean q() {
        mobi.ifunny.gallery.fragment.f localf = w();
        if (localf != null) {
        }
        switch (o.a[localf.c().ordinal()]) {
            default:
                return super.q();
            case 2:
                localf.g();
                t();
                return true;
        }
        localf.e();
        t();
        return true;
    }

    protected void r() {
        d.b(b, "galleryLoaded(" + this.e + ")");
        a(t.b);
        int i2;
        int i1;
        if (!TextUtils.isEmpty(this.f)) {
            i2 = this.d.getCount();
            i1 = 0;
        }
        for (; ; ) {
            if (i1 < i2) {
                if (TextUtils.equals(this.d.a(i1).id, this.f)) {
                    this.e = i1;
                    this.f = null;
                }
            } else {
                this.pager.a(this.e, false);
                if (this.e != 0) {
                    break;
                }
                a(this.e);
                t();
                return;
            }
            i1 += 1;
        }
        this.pager.a(this.e, false);
    }

    public void s() {
        mobi.ifunny.gallery.fragment.f localf = w();
        if (localf != null) {
            localf.h();
            t();
        }
    }

    protected void t() {
        int i2 = 4;
        d.a(b, "updateUI");
        Object localObject2 = w();
        if (localObject2 == null) {
            d.d(b, " fragment == null");
            return;
        }
        IFunny localIFunny = ((mobi.ifunny.gallery.fragment.f) localObject2).j();
        Object localObject1 = a();
        if (((mobi.ifunny.gallery.fragment.f) localObject2).b()) {
            ((android.support.v7.a.a) localObject1).f();
            ((android.support.v7.a.a) localObject1).b(true);
            ((android.support.v7.a.a) localObject1).a(b());
            ((android.support.v7.a.a) localObject1).c(false);
            this.bottomPanel.setVisibility(4);
        }
        for (; ; ) {
            C().d();
            localObject1 = D();
            if (localObject1 != null) {
                ((IFunnyMenuActivity) localObject1).c(true);
            }
            if (this.k == null) {
                break;
            }
            this.k.setText(localIFunny.loadingHelper.getMimeType());
            return;
            localObject2 = ((mobi.ifunny.gallery.fragment.f) localObject2).c();
            switch (o.a[localObject2.ordinal()]) {
                default:
                    break;
                case 1:
                    boolean bool1 = localIFunny.isSmiled();
                    boolean bool2 = localIFunny.isUnsmiled();
                    boolean bool3 = localIFunny.isAbused();
                    if (this.y) {
                        ((android.support.v7.a.a) localObject1).g();
                        if ((!m()) || (bool3)) {
                            break label667;
                        }
                        ((android.support.v7.a.a) localObject1).b(false);
                        ((android.support.v7.a.a) localObject1).c(true);
                        if (!localIFunny.hasSource()) {
                            break label644;
                        }
                        localObject1 = localIFunny.source.creator;
                        a((User) localObject1, localIFunny);
                        this.q.setVisibility(0);
                        this.q.setText(getString(2131689658, new Object[]{localIFunny.creator.nick}));
                        if (localObject1 != null) {
                            break label634;
                        }
                        localObject1 = getString(2131689661);
                        localObject2 = this.t.getMenu();
                        ((Menu) localObject2).findItem(2131493395).setTitle((CharSequence) localObject1);
                        ((Menu) localObject2).findItem(2131493396).setTitle(localIFunny.creator.nick);
                        localObject1 = this.bottomPanel;
                        if (!this.y) {
                            break label691;
                        }
                        i1 = 4;
                        ((View) localObject1).setVisibility(i1);
                        localObject1 = this.smileBtn;
                        if ((!bool3) || (bool1)) {
                            break label696;
                        }
                        i1 = 4;
                        ((View) localObject1).setVisibility(i1);
                        localObject1 = this.smileImage;
                        if (!bool1) {
                            break label701;
                        }
                        i1 = 2130837892;
                        ((ImageView) localObject1).setImageResource(i1);
                        localObject1 = this.smileCounter;
                        localObject2 = getResources();
                        if (!bool1) {
                            break label708;
                        }
                        i1 = 2131361899;
                        ((TextView) localObject1).setTextColor(((Resources) localObject2).getColor(i1));
                        localObject2 = mobi.ifunny.util.r.a(localIFunny.num.smiles, localIFunny.num.unsmiles);
                        if (!g()) {
                            break label735;
                        }
                        TextView localTextView = this.smileCounter;
                        localObject1 = localObject2;
                        if (!bool1) {
                            if (!bool2) {
                                break label715;
                            }
                            localObject1 = localObject2;
                        }
                        localTextView.setText((CharSequence) localObject1);
                        localObject1 = this.unsmileBtn;
                        if (((!bool1) || (!this.g)) && (!bool3)) {
                            break label723;
                        }
                        i1 = 4;
                        ((View) localObject1).setVisibility(i1);
                        localObject1 = this.unsmileImage;
                        if (!bool2) {
                            break label728;
                        }
                        i1 = 2130837954;
                        ((ImageView) localObject1).setImageResource(i1);
                        localObject1 = this.commentsBtn;
                        if (!bool3) {
                            break label755;
                        }
                        i1 = 4;
                        ((View) localObject1).setVisibility(i1);
                        this.commentsCounter.setText(mobi.ifunny.util.r.c(localIFunny.num.comments));
                        localObject1 = this.activityBtn;
                        if (!bool3) {
                            break label760;
                        }
                    }
                    for (int i1 = i2; ; i1 = 0) {
                        ((View) localObject1).setVisibility(i1);
                        break;
                        ((android.support.v7.a.a) localObject1).f();
                        break label211;
                        localObject1 = ((User) localObject1).nick;
                        break label312;
                        a(localIFunny.creator, localIFunny);
                        this.q.setVisibility(8);
                        break label363;
                        ((android.support.v7.a.a) localObject1).b(true);
                        ((android.support.v7.a.a) localObject1).a(b());
                        ((android.support.v7.a.a) localObject1).c(false);
                        break label363;
                        i1 = 0;
                        break label378;
                        i1 = 0;
                        break label401;
                        i1 = 2130837891;
                        break label421;
                        i1 = 2131361883;
                        break label447;
                        localObject1 = "…";
                        break label509;
                        i1 = 0;
                        break label540;
                        i1 = 2130837953;
                        break label561;
                        this.smileCounter.setText((CharSequence) localObject2);
                        this.unsmileBtn.setVisibility(4);
                        break label567;
                        i1 = 0;
                        break label580;
                    }
                case 3:
                    ((android.support.v7.a.a) localObject1).f();
                    ((android.support.v7.a.a) localObject1).b(true);
                    ((android.support.v7.a.a) localObject1).a(getString(2131690187));
                    ((android.support.v7.a.a) localObject1).c(false);
                    this.bottomPanel.setVisibility(4);
                    break;
                case 2:
                    label211:
                    label312:
                    label363:
                    label378:
                    label401:
                    label421:
                    label447:
                    label509:
                    label540:
                    label561:
                    label567:
                    label580:
                    label634:
                    label644:
                    label667:
                    label691:
                    label696:
                    label701:
                    label708:
                    label715:
                    label723:
                    label728:
                    label735:
                    label755:
                    label760:
                    ((android.support.v7.a.a) localObject1).f();
                    ((android.support.v7.a.a) localObject1).b(true);
                    ((android.support.v7.a.a) localObject1).a(getString(2131689548));
                    ((android.support.v7.a.a) localObject1).c(false);
                    this.bottomPanel.setVisibility(4);
            }
        }
    }

    public boolean u() {
        return !this.y;
    }

    public boolean v() {
        if (getResources().getConfiguration().orientation == 1) {
        }
        for (int i1 = 1; (i1 != 0) && (!this.y); i1 = 0) {
            return true;
        }
        return false;
    }

    public mobi.ifunny.gallery.fragment.f w() {
        return d(R());
    }

    protected IFunny x() {
        return e(R());
    }

    public boolean y() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/GalleryFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */