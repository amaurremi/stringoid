package com.everimaging.fotorsdk.editor.feature;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.SeekBar;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.brush.brush.TiltShiftBrush;
import com.everimaging.fotorsdk.brush.brush.TiltShiftBrush.TiltShiftMode;
import com.everimaging.fotorsdk.brush.toolkit.e;
import com.everimaging.fotorsdk.editor.FotorFeaturesFactory.FeatureType;
import com.everimaging.fotorsdk.editor.R.anim;
import com.everimaging.fotorsdk.editor.R.dimen;
import com.everimaging.fotorsdk.editor.R.id;
import com.everimaging.fotorsdk.editor.R.layout;
import com.everimaging.fotorsdk.editor.R.raw;
import com.everimaging.fotorsdk.editor.R.string;
import com.everimaging.fotorsdk.editor.c;
import com.everimaging.fotorsdk.editor.filter.k;
import com.everimaging.fotorsdk.editor.filter.params.TiltShiftParams;
import com.everimaging.fotorsdk.editor.widget.FotorTiltShiftView;
import com.everimaging.fotorsdk.editor.widget.FotorTiltShiftView.TiltShiftMode;
import com.everimaging.fotorsdk.editor.widget.FotorTiltShiftView.a;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.BitmapUtils;
import com.everimaging.fotorsdk.utils.FotorAsyncTask;
import com.everimaging.fotorsdk.utils.SimpleStatusMachine;
import com.everimaging.fotorsdk.utils.SimpleStatusMachine.OnStatusChangeListener;
import com.everimaging.fotorsdk.widget.FotorGuideView;
import com.everimaging.fotorsdk.widget.FotorGuideView.a;
import com.everimaging.fotorsdk.widget.FotorNavigationButtonShort;
import com.everimaging.fotorsdk.widget.FotorSliderPanelLayout;
import com.everimaging.fotorsdk.widget.FotorSliderPanelLayout.a;

import java.util.concurrent.CountDownLatch;

public class n
        extends a
        implements FotorTiltShiftView.a, SimpleStatusMachine.OnStatusChangeListener, FotorGuideView.a, FotorSliderPanelLayout.a {
    private static final String m = n.class.getSimpleName();
    private static final FotorLoggerFactory.c n = FotorLoggerFactory.a(m, FotorLoggerFactory.LoggerType.CONSOLE);
    private boolean A;
    private boolean B;
    private k C;
    private TiltShiftParams D;
    private boolean E = false;
    private a F;
    private FrameLayout G;
    private e H;
    private TiltShiftBrush I;
    private com.everimaging.fotorsdk.brush.painter.a J;
    private FotorGuideView K;
    private View.OnClickListener L = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            FotorTiltShiftView.TiltShiftMode localTiltShiftMode;
            if (n.c(n.this).getCurrentStatus() == 0) {
                paramAnonymousView = (FotorNavigationButtonShort) paramAnonymousView;
                localTiltShiftMode = (FotorTiltShiftView.TiltShiftMode) paramAnonymousView.getTag();
                if (paramAnonymousView != n.d(n.this)) {
                    n.d(n.this).setSelected(false);
                    n.a(n.this, paramAnonymousView);
                    n.d(n.this).setSelected(true);
                    n.b(n.this).a(localTiltShiftMode, n.e(n.this));
                    if (localTiltShiftMode == null) {
                        break label104;
                    }
                }
            }
            label104:
            for (paramAnonymousView = localTiltShiftMode.name(); ; paramAnonymousView = "Unknow") {
                com.everimaging.fotorsdk.a.a("EDIT_TILTSHIFT_ITEM_TAP", "Tilt_Shift_Type", paramAnonymousView);
                return;
            }
        }
    };
    private View.OnClickListener M = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            ImageButton localImageButton;
            if (n.c(n.this).getCurrentStatus() == 0) {
                localImageButton = (ImageButton) paramAnonymousView;
                if (localImageButton != n.f(n.this)) {
                    paramAnonymousView = "Unknow";
                    if (localImageButton != n.g(n.this)) {
                        break label99;
                    }
                    n.i(n.this).setProgress(n.h(n.this));
                    paramAnonymousView = "EDIT_TILTSHIFT_RADIUS_TAP";
                }
            }
            for (; ; ) {
                n.f(n.this).setSelected(false);
                n.a(n.this, localImageButton);
                n.f(n.this).setSelected(true);
                com.everimaging.fotorsdk.a.a(paramAnonymousView);
                return;
                label99:
                if (localImageButton == n.j(n.this)) {
                    n.i(n.this).setProgress(n.k(n.this));
                    paramAnonymousView = "EDIT_TILTSHIFT_STRENGTH_TAP";
                }
            }
        }
    };
    private View.OnTouchListener N = new View.OnTouchListener() {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
            return n.c(n.this).getCurrentStatus() != 0;
        }
    };
    protected Bitmap l;
    private FotorSliderPanelLayout o;
    private ImageButton p;
    private ImageButton q;
    private ImageButton r;
    private int s = 0;
    private int t = 9;
    private FotorNavigationButtonShort u;
    private FotorNavigationButtonShort v;
    private FotorNavigationButtonShort w;
    private FotorNavigationButtonShort x;
    private SimpleStatusMachine y;
    private FotorTiltShiftView z;

    public n(c paramc) {
        super(paramc);
    }

    private boolean J() {
        try {
            boolean bool = this.A;
            return bool;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    private float K() {
        int i = Math.max(this.d.getWidth(), this.d.getHeight());
        if (this.x == this.v) {
            return i / 3.0F * this.s / 100.0F;
        }
        return 1.0F + this.s / 100.0F;
    }

    private int L() {
        int i = 10;
        if (this.t == 0) {
            i = 0;
        }
        int j;
        do {
            return i;
            j = (int) (this.t * 10 / 100.0F) + 1;
        } while (j > 10);
        return j;
    }

    private RectF a(float paramFloat) {
        RectF localRectF = new RectF();
        float f1 = this.d.getWidth() * paramFloat;
        paramFloat = this.d.getHeight() * paramFloat;
        float f2 = (this.J.getWidth() - f1) / 2.0F;
        float f3 = (this.J.getHeight() - paramFloat) / 2.0F;
        localRectF.left = f2;
        localRectF.top = f3;
        localRectF.right = (f1 + f2);
        localRectF.bottom = (f3 + paramFloat);
        return localRectF;
    }

    private void a(boolean paramBoolean) {
        try {
            this.B = paramBoolean;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    private void b(boolean paramBoolean) {
        try {
            this.A = paramBoolean;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    private void d() {
        if (com.everimaging.fotorsdk.preference.a.d(this.h)) {
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
            localLayoutParams.gravity = 48;
            this.K = new FotorGuideView(this.h);
            this.K.setGuideViewListener(this);
            this.a.b(this.K, localLayoutParams);
            this.a.e().post(new Runnable() {
                public void run() {
                    n.a(n.this).a(R.raw.fotor_guide_tilt_shift_config);
                }
            });
        }
    }

    private float h() {
        float f1 = this.h.getResources().getDimension(R.dimen.fotor_main_imageview_margin);
        float f2 = this.d.getWidth();
        float f3 = this.d.getHeight();
        f1 = Math.min((this.J.getWidth() - f1) / f2, (this.J.getHeight() - f1) / f3);
        if (f1 > 1.0F) {
            return 1.0F;
        }
        return f1;
    }

    private void i() {
        this.I.a(this.D.getMode());
        this.I.c(this.D.getDegress());
        this.I.a(this.D.getCenterX());
        this.I.b(this.D.getCenterY());
        this.I.a(this.D.getInnerRadius(), this.D.getInnerRadiusY(), this.D.getOuterRadiusValue());
    }

    private boolean j() {
        try {
            boolean bool = this.B;
            return bool;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void A() {
        if (this.y.getCurrentStatus() == 2) {
        }
        do {
            return;
            this.y.setStatus(2);
        } while (this.b == null);
        if (J()) {
            this.z.a();
            this.z.setTouchable(false);
            return;
        }
        Bitmap localBitmap = BitmapUtils.createBitmap(this.d.getWidth(), this.d.getHeight(), this.d.getConfig());
        Canvas localCanvas = new Canvas(localBitmap);
        this.J.a(localCanvas);
        this.b.a(this, localBitmap, new BaseParams[]{this.D});
    }

    protected void C() {
        super.C();
        if (L() > 0) {
            this.i = true;
        }
    }

    public void OnStatusChanged(int paramInt1, int paramInt2) {
    }

    public void OnStatusUpdated(int paramInt) {
    }

    protected void a() {
        if (J()) {
            a(true);
            return;
        }
        b(true);
        this.F = new a(null);
        this.F.execute(new Void[0]);
    }

    public void a(int paramInt1, int paramInt2, PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3) {
        if (this.x == this.v) {
            this.D.setMode(TiltShiftBrush.TiltShiftMode.VECTOR);
            paramFloat2 = K();
            this.D.setInnerRadius(paramFloat1);
            this.D.setDegress(paramFloat3);
            this.D.setCenterX(paramPointF.x);
            this.D.setCenterY(paramPointF.y);
            this.D.setOuterRadius(paramFloat2);
            i();
            this.J.a();
            return;
        }
        if (this.x == this.u) {
            paramFloat2 = paramFloat1;
        }
        for (; ; ) {
            this.D.setInnerRadiusY(paramFloat2);
            this.D.setMode(TiltShiftBrush.TiltShiftMode.ELLIPSE);
            break;
            if (this.x != this.w) {
                paramFloat2 = 0.0F;
            }
        }
    }

    public void a(Configuration paramConfiguration) {
        super.a(paramConfiguration);
        this.E = true;
    }

    public void a(FotorSliderPanelLayout paramFotorSliderPanelLayout) {
        this.z.c();
        this.z.setTouchable(false);
    }

    public void a(FotorSliderPanelLayout paramFotorSliderPanelLayout, int paramInt, boolean paramBoolean) {
        if (paramBoolean) {
            if (this.r != this.p) {
                break label54;
            }
            this.s = paramInt;
            this.D.setOuterRadius(K());
            this.z.setOuterRadius(K());
            i();
            this.J.a();
        }
        label54:
        while (this.r != this.q) {
            return;
        }
        this.t = paramInt;
        this.D.setStrength(L());
        a();
    }

    public void b() {
        this.y.setStatus(1);
    }

    public void b(FotorSliderPanelLayout paramFotorSliderPanelLayout) {
        this.z.b();
        this.z.setTouchable(true);
    }

    public View c(LayoutInflater paramLayoutInflater) {
        return paramLayoutInflater.inflate(R.layout.fotor_feature_tilt_shift_operation_panel, null);
    }

    public void c() {
        this.y.setStatus(0);
    }

    public View d(LayoutInflater paramLayoutInflater) {
        return paramLayoutInflater.inflate(R.layout.fotor_feature_tilt_shift_draw_panel, null);
    }

    public void f() {
        super.f();
        if (this.C != null) {
            this.C.b();
        }
    }

    protected void m() {
        super.m();
        n.c(new Object[]{"onFeatureOpened"});
        this.l = BitmapUtils.copy(this.d, this.d.getConfig());
        this.D = new TiltShiftParams();
        this.D.setProcessImgSize(this.d.getWidth(), this.d.getHeight());
        this.D.setStrength(L());
        float f1 = K();
        this.D.setOuterRadius(f1);
        i();
        this.C = new k(this, this.d, this.l, this.D);
        this.H.b(this.d.getWidth(), this.d.getHeight());
        float f2 = h();
        this.H.b(f2, f2, f2);
        this.J.a(this.l, this.d);
        Object localObject = a(f2);
        this.z.a((RectF) localObject, this.d.getWidth(), this.d.getHeight());
        localObject = (AnimationSet) AnimationUtils.loadAnimation(this.h, R.anim.fotor_fit_view_fadein_animation);
        ((AnimationSet) localObject).setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation paramAnonymousAnimation) {
            }

            public void onAnimationRepeat(Animation paramAnonymousAnimation) {
            }

            public void onAnimationStart(Animation paramAnonymousAnimation) {
                n.b(n.this).setVisibility(0);
            }
        });
        this.z.startAnimation((Animation) localObject);
        this.z.setTiltShiftViewListener(this);
        this.z.a(FotorTiltShiftView.TiltShiftMode.MODE_CIRCLE, f1);
        this.y.setStatus(0);
        this.u.setOnClickListener(this.L);
        this.v.setOnClickListener(this.L);
        this.w.setOnClickListener(this.L);
        this.o.setOnChangedListener(this);
        this.q.setOnClickListener(this.M);
        this.p.setOnClickListener(this.M);
        a();
        n.c(new Object[]{"on feature opened ..."});
        d();
    }

    public void n() {
        com.everimaging.fotorsdk.preference.a.c(this.h, false);
        this.a.d(this.K);
        this.K = null;
    }

    protected void p() {
        if (this.F != null) {
            this.F.cancel(true);
        }
        this.y.setStatus(1);
        super.p();
    }

    protected void q() {
        super.q();
        this.z.setTiltShiftViewListener(null);
    }

    protected void t() {
        this.y = new SimpleStatusMachine();
        this.y.setStatus(1);
        this.y.setOnStatusChangeListener(this);
    }

    protected void u() {
        this.o = ((FotorSliderPanelLayout) v().findViewById(R.id.fotor_tilt_shift_slider));
        this.o.setIsShowValue(false);
        this.o.setProgress(this.o.getSeekBar().getMax() / 2);
        this.s = this.o.getSeekBar().getProgress();
        this.o.setOnTouchListener(this.N);
        this.p = ((ImageButton) v().findViewById(R.id.fotor_tilt_shift_gradient));
        this.q = ((ImageButton) v().findViewById(R.id.fotor_tilt_shift_strength));
        this.u = ((FotorNavigationButtonShort) v().findViewById(R.id.fotor_tilt_shift_circle));
        this.v = ((FotorNavigationButtonShort) v().findViewById(R.id.fotor_tilt_shift_linear));
        this.w = ((FotorNavigationButtonShort) v().findViewById(R.id.fotor_tilt_shift_ellipse));
        this.u.setTag(FotorTiltShiftView.TiltShiftMode.MODE_CIRCLE);
        this.v.setTag(FotorTiltShiftView.TiltShiftMode.MODE_LINE);
        this.w.setTag(FotorTiltShiftView.TiltShiftMode.MODE_ELLIPSE);
        this.x = this.u;
        this.x.setSelected(true);
        this.r = this.p;
        this.r.setSelected(true);
        this.G = ((FrameLayout) w().findViewById(R.id.fotor_tilt_shift_painter_container));
        this.I = new TiltShiftBrush();
        this.J = new com.everimaging.fotorsdk.brush.painter.a(this.h, this.I);
        this.H = this.J.getViewCamera();
        this.G.addView(this.J);
        this.z = new FotorTiltShiftView(this.h);
        this.z.setVisibility(4);
        this.G.addView(this.z);
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams) this.z.getLayoutParams();
        localLayoutParams.width = -1;
        localLayoutParams.height = -1;
        this.z.setLayoutParams(localLayoutParams);
    }

    public FotorFeaturesFactory.FeatureType x() {
        return FotorFeaturesFactory.FeatureType.TILT_SHIFT;
    }

    public String y() {
        return this.h.getString(R.string.fotor_feature_tilt_shift);
    }

    public boolean z() {
        if (this.K != null) {
            this.K.a();
            return true;
        }
        return super.z();
    }

    private class a
            extends FotorAsyncTask<Void, Void, Void> {
        private CountDownLatch b;

        private a() {
        }

        protected Void a(Void... paramVarArgs) {
            try {
                this.b = new CountDownLatch(1);
                n.l(n.this).f();
                publishProgress(new Void[0]);
                this.b.await();
                if ((n.m(n.this)) && (!isCancelled())) {
                    n.a(n.this, false);
                    a(new Void[0]);
                }
                return null;
            } catch (Exception paramVarArgs) {
                for (; ; ) {
                    paramVarArgs.printStackTrace();
                }
            }
        }

        protected void a(Void paramVoid) {
            n.b(n.this, false);
            n.a(n.this, null);
            if ((n.c(n.this).getCurrentStatus() == 2) && (n.this.b != null)) {
                n.this.b.a(n.this, n.this.l, new BaseParams[]{n.o(n.this)});
            }
        }

        protected void b(Void paramVoid) {
            n.b(n.this, false);
            n.a(n.this, null);
        }

        protected void b(Void... paramVarArgs) {
            if ((n.this.G()) && (n.c(n.this).getCurrentStatus() != 1)) {
                n.n(n.this).a();
            }
            n.this.a.e().post(new Runnable() {
                public void run() {
                    n.a.a(n.a.this).countDown();
                }
            });
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/feature/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */