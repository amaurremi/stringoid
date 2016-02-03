package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

public class z
        extends FrameLayout
        implements fb.a {
    public static int a;
    private static int e;
    private static int f;
    private boolean A;
    private boolean B;
    private final String C = z.class.getSimpleName();
    private Bitmap D;
    private Bitmap E;
    private Bitmap F;
    private Bitmap G;
    private ImageButton H;
    private ImageButton I;
    private ImageButton J;
    private g K;
    private al L;
    private AtomicBoolean M = new AtomicBoolean(false);
    @SuppressLint({"HandlerLeak"})
    private Handler N = new Handler() {
        public void handleMessage(Message paramAnonymousMessage) {
            switch (paramAnonymousMessage.what) {
                default:
                    return;
                case 1:
                    eo.a(3, z.b(z.this), "HERE IN FADE_OUT");
                    z.this.h();
                    return;
            }
            int i = z.h(z.this);
            eo.a(3, z.b(z.this), "HERE IN setProgress " + i);
        }
    };
    fa b;
    do c;
    RelativeLayout d;
    private WeakReference<af> g = new WeakReference(null);
    private Context h;
    private PopupWindow i;
    private ProgressBar j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r = false;
    private boolean s;
    private boolean t = false;
    private boolean u = false;
    private int v = 0;
    private long w = 0L;
    private boolean x;
    private boolean y;
    private boolean z;

    public z(Context paramContext, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
        super(paramContext);
        e = fc.b(16);
        f = fc.b(5);
        a = fc.b(35);
        a(paramContext, new aa(), paramLong, paramBoolean1, paramBoolean2, paramBoolean3);
    }

    private void a(Context paramContext, aa paramaa, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
        this.h = paramContext;
        this.K = null;
        this.n = true;
        this.o = true;
        this.p = true;
        this.q = true;
        this.w = paramLong;
        this.x = paramBoolean1;
        this.y = paramBoolean2;
        this.z = paramBoolean3;
        paramaa.f();
        this.D = paramaa.b();
        this.E = paramaa.c();
        this.F = paramaa.d();
        this.G = paramaa.e();
    }

    private af getMediaPlayer() {
        return (af) this.g.get();
    }

    private void l() {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.setMargins(f, f, f, f);
        localLayoutParams.addRule(10);
        localLayoutParams.addRule(11);
        View localView = q();
        this.d.addView(localView, localLayoutParams);
    }

    private void m() {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(11);
        localLayoutParams.setMargins(e, e, e, e);
        View localView = r();
        this.d.addView(localView, localLayoutParams);
    }

    private void n() {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(13);
        localLayoutParams.setMargins(e, e, e, e);
        View localView = p();
        this.d.addView(localView, localLayoutParams);
    }

    private void o() {
        if (this.L == null) {
            this.L = new al(this.h, a, a);
        }
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(9);
        localLayoutParams.setMargins(e, e, e, e);
        this.d.addView(this.L.a(), localLayoutParams);
        if (this.B) {
            this.L.a().setVisibility(0);
            return;
        }
        this.L.a().setVisibility(8);
    }

    @SuppressLint({"NewApi"})
    private View p() {
        this.H = new ImageButton(getContext());
        this.H.setPadding(0, 0, 0, 0);
        this.H.setBackgroundColor(0);
        this.H.setImageBitmap(this.F);
        this.H.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                z.e(z.this);
                z.this.h();
            }
        });
        if ((getMediaPlayer() != null) && (getMediaPlayer().getCurrentPosition() <= getOffsetStartTime())) {
            this.H.setVisibility(0);
        }
        for (; ; ) {
            return this.H;
            this.H.setVisibility(8);
        }
    }

    @SuppressLint({"NewApi"})
    private View q() {
        this.I = new ImageButton(getContext());
        this.I.setPadding(0, 0, 0, 0);
        this.I.setImageBitmap(this.D);
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColor(-16777216);
        localGradientDrawable.setShape(1);
        localGradientDrawable.setAlpha(178);
        if (Build.VERSION.SDK_INT >= 16) {
            this.I.setBackground(localGradientDrawable);
            this.I.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    eo.a(3, z.b(z.this), "Show video close button.");
                    if (z.f(z.this) != null) {
                        z.f(z.this).a();
                    }
                    z.this.d();
                }
            });
            if (!this.l) {
                break label126;
            }
            this.I.setVisibility(0);
        }
        for (; ; ) {
            return this.I;
            this.I.setBackgroundDrawable(localGradientDrawable);
            break;
            label126:
            this.I.setVisibility(8);
        }
    }

    private View r() {
        this.J = new ImageButton(getContext());
        this.J.setPadding(0, 0, 0, 0);
        this.J.setBackgroundColor(0);
        this.J.setImageBitmap(this.G);
        this.J.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                eo.a(3, z.b(z.this), "Show video more info button.");
                if (z.f(z.this) != null) {
                    z.f(z.this).a("clicked", Collections.emptyMap(), z.f(z.this).getAdUnit(), z.f(z.this).getAdLog(), z.f(z.this).getAdFrameIndex(), 0);
                    z.g(z.this).setVisibility(8);
                }
            }
        });
        if (this.A) {
            this.J.setVisibility(0);
        }
        for (; ; ) {
            return this.J;
            this.J.setVisibility(8);
        }
    }

    private void s() {
        eo.a(3, this.C, "showPlayerAssets.");
        if ((this.H != null) && (getMediaPlayer() != null) && (!getMediaPlayer().isPlaying()) && (getMediaPlayer().getCurrentPosition() <= getOffsetStartTime())) {
            this.H.setVisibility(0);
        }
        if ((this.L != null) && (this.B)) {
            this.L.a().setVisibility(0);
        }
        if ((this.I != null) && (this.l)) {
            this.I.setVisibility(0);
        }
        if ((this.J != null) && (this.A)) {
            this.J.setVisibility(0);
        }
    }

    private int t() {
        if ((getMediaPlayer() == null) || (this.m)) {
            i1 = 0;
        }
        int i2;
        int i3;
        do {
            return i1;
            i2 = getMediaPlayer().getCurrentPosition();
            i3 = getMediaPlayer().getDuration();
            i1 = i2;
        } while (this.j == null);
        if (i3 > 0) {
            long l1 = 1000L * i2 / i3;
            this.j.setProgress((int) l1);
        }
        int i1 = getMediaPlayer().getBufferPercentage();
        this.j.setSecondaryProgress(i1 * 10);
        return i2;
    }

    private void u() {
        eo.a(3, this.C, "***********doPauseResume");
        if (getMediaPlayer() != null) {
            if (getMediaPlayer().isPlaying()) {
                getMediaPlayer().pause();
            }
        } else {
            return;
        }
        getMediaPlayer().start();
    }

    public void a() {
        if (this.i == null) {
            this.i = new PopupWindow(this.h);
            this.i.setBackgroundDrawable(null);
            this.i.setFocusable(true);
            if (this.d != null) {
                break label237;
            }
            this.d = new RelativeLayout(this.h);
            this.d.setBackgroundColor(0);
        }
        for (; ; ) {
            l();
            if ((!this.x) && (getMediaPlayer() != null) && (getMediaPlayer().getCurrentPosition() <= getOffsetStartTime())) {
                n();
            }
            if (this.y) {
                o();
            }
            if (this.z) {
                m();
            }
            this.d.setFocusableInTouchMode(true);
            this.d.setOnKeyListener(new View.OnKeyListener() {
                public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent) {
                    if (paramAnonymousInt == 4) {
                        if (z.a(z.this) == true) {
                            eo.a(3, z.b(z.this), "IN KEYCODE BACK");
                            if ((z.c(z.this) != null) && (z.c(z.this).isShowing())) {
                                eo.a(3, z.b(z.this), "dismissing popup");
                                z.this.d();
                            }
                        }
                        return true;
                    }
                    return false;
                }
            });
            this.i.setContentView(this.d);
            PopupWindow.OnDismissListener local2 = new PopupWindow.OnDismissListener() {
                public void onDismiss() {
                    eo.a(3, z.b(z.this), "here in onDismiss ");
                }
            };
            this.i.setOnDismissListener(local2);
            if (!this.r) {
                j();
            }
            if (this.c == null) {
                this.c = do.a();
            }
            this.c.a(new ff() {
                public void a() {
                    if (!z.d(z.this).get()) {
                        eo.a(3, z.b(z.this), "Initializing popUp");
                        z.c(z.this).showAtLocation(z.this.d, 17, 0, 0);
                        z.c(z.this).update(0, 0, z.this.getWidthDimensions(), z.this.getHeightDimensions());
                        return;
                    }
                    eo.a(3, z.b(z.this), "Popup initialization not required.");
                }
            }, 100L);
            return;
            eo.a(3, this.C, "PopupWindow exists so using current one!");
            break;
            label237:
            this.d.removeAllViews();
        }
    }

    public void a(int paramInt) {
        eo.a(3, this.C, "***********show called");
        if ((!this.k) && (this.i != null)) {
            eo.a(3, this.C, "********showing player assets in show()");
            s();
            this.k = true;
        }
        this.N.sendEmptyMessage(2);
        Message localMessage = this.N.obtainMessage(1);
        if (paramInt != 0) {
            this.N.removeMessages(1);
            this.N.sendMessageDelayed(localMessage, paramInt);
        }
    }

    public void a(int paramInt, float paramFloat) {
        if ((this.I != null) && (paramFloat >= (float) this.w) && (!this.l)) {
            this.I.setVisibility(0);
            this.l = true;
        }
        if ((this.L != null) && (paramFloat > 0.0F)) {
            if (!this.B) {
                this.B = true;
                this.L.a().setVisibility(0);
            }
            this.L.a(paramInt, this.k);
        }
        if ((this.J != null) && (paramFloat >= 3000.0F) && (!this.A) && (!this.t)) {
            this.A = true;
            this.J.setVisibility(0);
        }
        if ((this.H != null) && (paramFloat > getOffsetStartTime()) && (this.H.isShown())) {
            this.H.setVisibility(8);
        }
    }

    public void a(fb paramfb) {
        if (getMediaPlayer() == null) {
        }
        float f1;
        do {
            return;
            f1 = getMediaPlayer().getDuration();
            float f2 = getMediaPlayer().getCurrentPosition();
            int i1 = (int) Math.abs((f1 - f2) / 1000.0F);
            if (this.L != null) {
                this.L.a((int) f1);
            }
            a(i1, f2);
            if ((f2 > getOffsetStartTime()) && (this.n) && (this.K != null)) {
                this.n = false;
                this.K.a("videoStart", Collections.emptyMap(), this.K.getAdUnit(), this.K.getAdLog(), this.K.getAdFrameIndex(), 0);
            }
            f1 = f2 / f1;
            if ((f1 >= 0.25D) && (this.o) && (this.K != null)) {
                this.o = false;
                this.K.a("videoFirstQuartile", Collections.emptyMap(), this.K.getAdUnit(), this.K.getAdLog(), this.K.getAdFrameIndex(), 0);
            }
            if ((f1 >= 0.5D) && (this.p) && (this.K != null)) {
                this.p = false;
                this.K.a("videoMidpoint", Collections.emptyMap(), this.K.getAdUnit(), this.K.getAdLog(), this.K.getAdFrameIndex(), 0);
            }
        } while ((f1 < 0.75D) || (!this.q) || (this.K == null));
        this.q = false;
        this.K.a("videoThirdQuartile", Collections.emptyMap(), this.K.getAdUnit(), this.K.getAdLog(), this.K.getAdFrameIndex(), 0);
    }

    public void b() {
        if ((this.i != null) && (this.i.isShowing())) {
            this.i.update(0, 0, getWidthDimensions(), getHeightDimensions());
        }
    }

    public boolean c() {
        return this.u;
    }

    public void d() {
        if ((this.i != null) && (this.i.isShowing())) {
            eo.a(3, this.C, "dismissing popup");
            this.i.dismiss();
        }
        eo.a(3, this.C, "END OF DISMISS POPUP");
    }

    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
        int i1 = paramKeyEvent.getKeyCode();
        eo.a(3, this.C, "HERE IN dispatchKeyEvent");
        if ((paramKeyEvent.getRepeatCount() == 0) && (paramKeyEvent.getAction() == 0) && ((i1 == 79) || (i1 == 85) || (i1 == 62))) {
            u();
            e();
            return true;
        }
        if ((i1 == 4) || (i1 == 82)) {
            h();
            return true;
        }
        e();
        return super.dispatchKeyEvent(paramKeyEvent);
    }

    public void e() {
        a(3000);
    }

    public void f() {
        eo.a(3, this.C, "hidePlayerAssets.");
        if (this.H != null) {
            this.H.setVisibility(8);
        }
    }

    public boolean g() {
        return this.k;
    }

    public boolean getAutoPlay() {
        return this.x;
    }

    public ImageButton getCloseButton() {
        return this.I;
    }

    public int getHeightDimensions() {
        DisplayMetrics localDisplayMetrics = fc.b();
        eo.a(3, this.C, "height is " + localDisplayMetrics.heightPixels);
        return localDisplayMetrics.heightPixels;
    }

    public ImageButton getMoreInfoButton() {
        return this.J;
    }

    public boolean getMoreInfoClicked() {
        return this.s;
    }

    public int getOffsetStartTime() {
        return this.v;
    }

    public ImageButton getPauseButton() {
        return this.H;
    }

    public al getTimerView() {
        return this.L;
    }

    public int getWidthDimensions() {
        DisplayMetrics localDisplayMetrics = fc.b();
        eo.a(3, this.C, "width is " + localDisplayMetrics.widthPixels);
        return localDisplayMetrics.widthPixels;
    }

    public void h() {
        eo.a(3, this.C, "HERE IN HIDE");
        if (this.i == null) {
        }
        while (!this.k) {
            return;
        }
        try {
            eo.a(3, this.C, "********hiding player assets in hide()");
            f();
            this.k = false;
            return;
        } catch (IllegalArgumentException localIllegalArgumentException) {
            for (; ; ) {
                eo.a(5, this.C, "already removed");
            }
        }
    }

    public void i() {
        if ((this.s) || (c())) {
            if (this.i != null) {
                d();
            }
            a();
            setmCloseConfirmDialogClicked(false);
        }
        if ((!this.k) && (this.i != null)) {
            e();
        }
    }

    public void j() {
        eo.a(3, this.C, "***********addTimerListener hit");
        if (this.b == null) {
            this.b = fa.a();
        }
        this.b.a(this);
        this.r = true;
    }

    public void k() {
        eo.a(3, this.C, "***********removeTimerListener hit");
        if (this.b == null) {
            this.b = fa.a();
        }
        this.b.b(this);
        this.r = false;
    }

    public boolean onTrackballEvent(MotionEvent paramMotionEvent) {
        eo.a(3, this.C, "HERE IN onTrackballEvent");
        e();
        return false;
    }

    public void setAdUnityView(g paramg) {
        this.K = paramg;
    }

    public void setEnabled(boolean paramBoolean) {
        if (this.j != null) {
            this.j.setEnabled(paramBoolean);
        }
        super.setEnabled(paramBoolean);
    }

    public void setFlurryCore(do paramdo) {
        this.c = paramdo;
    }

    public void setInitialVideoMidpoint(boolean paramBoolean) {
        this.p = paramBoolean;
    }

    public void setIntialVideoFirstQuartile(boolean paramBoolean) {
        this.o = paramBoolean;
    }

    public void setIntialVideoStart(boolean paramBoolean) {
        this.n = paramBoolean;
    }

    public void setIntialVideoThirdQuartile(boolean paramBoolean) {
        this.q = paramBoolean;
    }

    public void setIsMediaPlayerReleased(boolean paramBoolean) {
        this.M.set(paramBoolean);
    }

    public void setMediaPlayer(f paramf) {
        this.g = new WeakReference(paramf);
        eo.a(3, this.C, "Here is adUnityViewView: " + paramf);
    }

    public void setOffsetStartTime(int paramInt) {
        this.v = paramInt;
    }

    public void setTickManager(fa paramfa) {
        this.b = paramfa;
    }

    public void setTimerView(al paramal) {
        this.L = paramal;
    }

    public void setVideoState(am paramam) {
        boolean bool2 = true;
        if (paramam != null) {
            if (paramam.b()) {
                break label84;
            }
            bool1 = true;
            this.n = bool1;
            if (paramam.c()) {
                break label89;
            }
            bool1 = true;
            label29:
            this.o = bool1;
            if (paramam.d()) {
                break label94;
            }
            bool1 = true;
            label43:
            this.p = bool1;
            if (paramam.e()) {
                break label99;
            }
        }
        label84:
        label89:
        label94:
        label99:
        for (boolean bool1 = bool2; ; bool1 = false) {
            this.q = bool1;
            this.s = paramam.f();
            this.t = paramam.h();
            this.A = false;
            return;
            bool1 = false;
            break;
            bool1 = false;
            break label29;
            bool1 = false;
            break label43;
        }
    }

    public void setmCloseConfirmDialogClicked(boolean paramBoolean) {
        this.u = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */