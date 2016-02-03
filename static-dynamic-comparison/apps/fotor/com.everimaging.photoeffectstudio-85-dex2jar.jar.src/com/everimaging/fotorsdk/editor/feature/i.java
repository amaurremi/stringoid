package com.everimaging.fotorsdk.editor.feature;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.brush.b;
import com.everimaging.fotorsdk.brush.b.a;
import com.everimaging.fotorsdk.brush.brush.SmudgeBrush;
import com.everimaging.fotorsdk.brush.brush.SmudgeBrush.DrawStyle;
import com.everimaging.fotorsdk.brush.toolkit.c.a;
import com.everimaging.fotorsdk.brush.toolkit.c.b;
import com.everimaging.fotorsdk.brush.toolkit.e;
import com.everimaging.fotorsdk.brush.toolkit.e.a;
import com.everimaging.fotorsdk.editor.FotorFeaturesFactory.FeatureType;
import com.everimaging.fotorsdk.editor.R.anim;
import com.everimaging.fotorsdk.editor.R.dimen;
import com.everimaging.fotorsdk.editor.R.drawable;
import com.everimaging.fotorsdk.editor.R.id;
import com.everimaging.fotorsdk.editor.R.layout;
import com.everimaging.fotorsdk.editor.R.raw;
import com.everimaging.fotorsdk.editor.R.string;
import com.everimaging.fotorsdk.editor.c;
import com.everimaging.fotorsdk.editor.filter.f;
import com.everimaging.fotorsdk.editor.filter.params.MosaicParams;
import com.everimaging.fotorsdk.editor.widget.FotorMosaicBrushSizeDisplayer;
import com.everimaging.fotorsdk.editor.widget.FotorMosaicBrushSizeSlider;
import com.everimaging.fotorsdk.editor.widget.FotorMosaicBrushSizeSlider.a;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.BitmapUtils;
import com.everimaging.fotorsdk.utils.FotorAsyncTask;
import com.everimaging.fotorsdk.utils.FotorCommonDirUtils;
import com.everimaging.fotorsdk.utils.Utils;
import com.everimaging.fotorsdk.widget.FotorGuideView;
import com.everimaging.fotorsdk.widget.FotorGuideView.a;
import com.everimaging.fotorsdk.widget.FotorNavigationButtonShort;
import com.everimaging.fotorsdk.widget.FotorSliderPanelLayout;
import com.everimaging.fotorsdk.widget.FotorSliderPanelLayout.a;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

public class i
        extends a
        implements b.a, c.a, e.a, FotorGuideView.a {
    private static final String l = i.class.getSimpleName();
    private static final FotorLoggerFactory.c m = FotorLoggerFactory.a(l, FotorLoggerFactory.LoggerType.CONSOLE);
    private ImageButton A;
    private ImageButton B;
    private FotorNavigationButtonShort C;
    private FotorNavigationButtonShort D;
    private FotorNavigationButtonShort E;
    private FotorSliderPanelLayout F;
    private FotorMosaicBrushSizeSlider G;
    private FotorMosaicBrushSizeDisplayer H;
    private String I;
    private boolean J = false;
    private com.everimaging.fotorsdk.editor.feature.utils.a K;
    private float L;
    private float M;
    private float[] N;
    private FotorGuideView O;
    private View.OnClickListener P = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            if (paramAnonymousView == i.d(i.this)) {
                i.e(i.this).e();
            }
            while (paramAnonymousView != i.f(i.this)) {
                return;
            }
            i.e(i.this).f();
        }
    };
    private View.OnClickListener Q = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            if (i.g(i.this) != null) {
                i.g(i.this).setSelected(false);
            }
            if (paramAnonymousView == i.h(i.this)) {
                i.i(i.this).a(false);
                i.a(i.this, i.h(i.this));
            }
            for (; ; ) {
                i.g(i.this).setSelected(true);
                return;
                if (paramAnonymousView == i.j(i.this)) {
                    i.i(i.this).a(true);
                    i.a(i.this, i.j(i.this));
                }
            }
        }
    };
    private FotorSliderPanelLayout.a R = new FotorSliderPanelLayout.a() {
        public void a(FotorSliderPanelLayout paramAnonymousFotorSliderPanelLayout) {
        }

        public void a(FotorSliderPanelLayout paramAnonymousFotorSliderPanelLayout, int paramAnonymousInt, boolean paramAnonymousBoolean) {
            if (paramAnonymousBoolean) {
                i.k(i.this).setBlurPixels(i.a(i.this, paramAnonymousInt));
                i.this.h();
            }
        }

        public void b(FotorSliderPanelLayout paramAnonymousFotorSliderPanelLayout) {
        }
    };
    private FotorMosaicBrushSizeSlider.a S = new FotorMosaicBrushSizeSlider.a() {
        public void a(int paramAnonymousInt) {
            i.a(i.this, i.n(i.this)[paramAnonymousInt]);
            i.p(i.this).setBrushSize(i.o(i.this));
            float f = i.o(i.this) / i.q(i.this).d();
            i.i(i.this).b(f);
            i.i(i.this).b();
        }

        public void a(SeekBar paramAnonymousSeekBar) {
            i.l(i.this);
        }

        public void b(SeekBar paramAnonymousSeekBar) {
            i.m(i.this);
        }
    };
    private FrameLayout n;
    private e o;
    private com.everimaging.fotorsdk.brush.painter.beauty.a p;
    private SmudgeBrush q;
    private int r;
    private int s;
    private Bitmap t;
    private boolean u;
    private boolean v;
    private a w;
    private MosaicParams x;
    private f y;
    private View z;

    public i(c paramc) {
        super(paramc);
    }

    private float J() {
        float f1 = this.h.getResources().getDimension(R.dimen.fotor_main_imageview_margin);
        float f2 = this.d.getWidth();
        float f3 = this.d.getHeight();
        f1 = Math.min((this.p.getWidth() - f1) / f2, (this.p.getHeight() - f1) / f3);
        if (f1 > 1.0F) {
            return 1.0F;
        }
        return f1;
    }

    private void K() {
        new Thread(new Runnable() {
            public void run() {
                File localFile1 = new File(i.c(i.this));
                String[] arrayOfString = localFile1.list();
                if (arrayOfString != null) {
                    int j = arrayOfString.length;
                    int i = 0;
                    while (i < j) {
                        File localFile2 = new File(localFile1, arrayOfString[i]);
                        if (localFile2.exists()) {
                            localFile2.delete();
                        }
                        i += 1;
                    }
                }
            }
        }).start();
    }

    private void L() {
        Animation localAnimation = AnimationUtils.loadAnimation(this.h, R.anim.fotor_fit_view_fadein_animation);
        this.H.setVisibility(0);
        localAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation paramAnonymousAnimation) {
            }

            public void onAnimationRepeat(Animation paramAnonymousAnimation) {
            }

            public void onAnimationStart(Animation paramAnonymousAnimation) {
            }
        });
        this.H.startAnimation(localAnimation);
    }

    private void M() {
        Animation localAnimation = AnimationUtils.loadAnimation(this.h, R.anim.fotor_fit_view_fadeout_animation);
        localAnimation.setStartOffset(1000L);
        localAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation paramAnonymousAnimation) {
                i.p(i.this).setVisibility(8);
            }

            public void onAnimationRepeat(Animation paramAnonymousAnimation) {
            }

            public void onAnimationStart(Animation paramAnonymousAnimation) {
            }
        });
        this.H.startAnimation(localAnimation);
    }

    private boolean N() {
        try {
            boolean bool = this.v;
            return bool;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    private boolean O() {
        try {
            boolean bool = this.u;
            return bool;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    private float a(int paramInt) {
        int i = Math.min(this.d.getWidth(), this.d.getHeight());
        float f1 = (this.s - this.r) / 30.0F;
        float f2 = this.s;
        float f3 = paramInt;
        return i / (f2 - f1 * f3);
    }

    private void a(c.b paramb) {
        if (paramb != null) {
        }
        try {
            paramb = (MosaicParams) ((com.everimaging.fotorsdk.editor.feature.utils.a.a) paramb).b;
            if (paramb != null) {
                paramb = paramb.getMaskCachePath();
                if ((paramb != null) && (!paramb.isEmpty())) {
                    paramb = new File(paramb);
                    if (paramb.exists()) {
                        paramb.delete();
                    }
                }
            }
            return;
        } finally {
        }
    }

    private void a(boolean paramBoolean) {
        try {
            this.v = paramBoolean;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    @SuppressLint({"NewApi"})
    private boolean a(String paramString) {
        Bitmap localBitmap = BitmapUtils.copy(this.p.getMaskBitmap(), Bitmap.Config.ALPHA_8);
        try {
            int i = localBitmap.getRowBytes() * localBitmap.getHeight();
            if (Build.VERSION.SDK_INT >= 19) {
                i = localBitmap.getAllocationByteCount();
            }
            byte[] arrayOfByte = new byte[i];
            localBitmap.copyPixelsToBuffer(ByteBuffer.wrap(arrayOfByte));
            paramString = new FileOutputStream(paramString);
            paramString.write(arrayOfByte);
            paramString.close();
            return true;
        } catch (Exception paramString) {
            paramString.printStackTrace();
        }
        return false;
    }

    private void b(boolean paramBoolean) {
        try {
            this.u = paramBoolean;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    private void i() {
        if (com.everimaging.fotorsdk.preference.a.e(this.h)) {
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
            localLayoutParams.gravity = 48;
            this.O = new FotorGuideView(this.h);
            this.O.setGuideViewListener(this);
            this.a.b(this.O, localLayoutParams);
            this.a.e().post(new Runnable() {
                public void run() {
                    i.a(i.this).a(R.raw.fotor_guide_pixelate_config);
                }
            });
        }
    }

    private void j() {
        File localFile = new File(FotorCommonDirUtils.getTemporaryPath(), "mosaicMaskCache");
        if (!localFile.exists()) {
            localFile.mkdirs();
        }
        this.I = localFile.getAbsolutePath();
    }

    protected void A() {
        String str = this.a.a().k() + File.separator + Utils.generateFileName("cache");
        Bitmap localBitmap1 = this.p.getMaskBitmap();
        if (a(str)) {
            localBitmap2 = BitmapUtils.createBitmap(localBitmap1.getWidth(), localBitmap1.getHeight(), Bitmap.Config.ARGB_8888);
            this.p.a(localBitmap2);
            this.x.setMaskCachePath(str);
            this.x.setMaskWidth(localBitmap1.getWidth());
            this.x.setMaskHeight(localBitmap1.getHeight());
            if (this.b != null) {
                this.b.a(this, localBitmap2, new BaseParams[]{this.x});
            }
        }
        while (this.b == null) {
            Bitmap localBitmap2;
            return;
        }
        this.b.a(this);
    }

    public void a() {
        this.A.setEnabled(true);
        this.i = true;
    }

    public void a(float paramFloat) {
        paramFloat = this.M / paramFloat;
        this.q.b(paramFloat);
        this.q.b();
    }

    @SuppressLint({"NewApi"})
    public void a(final b paramb) {
        paramb = this.I + File.separator + Utils.generateFileName("cache");
        Bitmap localBitmap = this.p.getMaskBitmap();
        if (!a(paramb)) {
            a(this.K.a(1));
            a(paramb);
        }
        com.everimaging.fotorsdk.editor.feature.utils.a.a locala = (com.everimaging.fotorsdk.editor.feature.utils.a.a) this.K.g();
        MosaicParams localMosaicParams = new MosaicParams();
        localMosaicParams.setBlurPixels(this.L);
        localMosaicParams.setMaskCachePath(paramb);
        localMosaicParams.setMaskWidth(localBitmap.getWidth());
        localMosaicParams.setMaskHeight(localBitmap.getHeight());
        locala.b = localMosaicParams;
        paramb = this.K.a(locala);
        if (paramb != null) {
            new Thread(new Runnable() {
                public void run() {
                    Iterator localIterator = paramb.iterator();
                    while (localIterator.hasNext()) {
                        c.b localb = (c.b) localIterator.next();
                        i.a(i.this, localb);
                    }
                }
            });
        }
    }

    public void a(b paramb, MotionEvent paramMotionEvent) {
        paramb = AnimationUtils.loadAnimation(this.h, R.anim.fotor_fit_view_fadeout_animation);
        paramb.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation paramAnonymousAnimation) {
                i.b(i.this).setVisibility(4);
            }

            public void onAnimationRepeat(Animation paramAnonymousAnimation) {
            }

            public void onAnimationStart(Animation paramAnonymousAnimation) {
            }
        });
        this.z.startAnimation(paramb);
    }

    public void b() {
        this.B.setEnabled(true);
    }

    public void b(b paramb, MotionEvent paramMotionEvent) {
    }

    public View c(LayoutInflater paramLayoutInflater) {
        return paramLayoutInflater.inflate(R.layout.fotor_feature_mosaic_operation_panel, null);
    }

    public void c() {
        this.A.setEnabled(false);
        this.i = false;
    }

    public void c(b paramb, MotionEvent paramMotionEvent) {
        paramb = AnimationUtils.loadAnimation(this.h, R.anim.fotor_fit_view_fadein_animation);
        this.z.setVisibility(0);
        this.z.startAnimation(paramb);
    }

    public View d(LayoutInflater paramLayoutInflater) {
        return paramLayoutInflater.inflate(R.layout.fotor_feature_mosaic_draw_panel, null);
    }

    public void d() {
        this.B.setEnabled(false);
    }

    public void f() {
        super.f();
        if (this.y != null) {
            this.y.b();
        }
    }

    protected void h() {
        if (O()) {
            a(true);
            return;
        }
        b(true);
        this.w = new a(null);
        this.w.execute(new Void[0]);
    }

    protected void m() {
        super.m();
        float f = J();
        this.p.a(this.d, this.t);
        this.o.b(this.d.getWidth(), this.d.getHeight());
        this.o.b(f, f, 2.0F);
        this.p.invalidate();
        h();
        i();
    }

    public void n() {
        com.everimaging.fotorsdk.preference.a.d(this.h, false);
        this.a.d(this.O);
        this.O = null;
    }

    protected void p() {
        super.p();
        this.a.e(this.z);
        K();
    }

    protected void q() {
        super.q();
    }

    protected void t() {
        this.r = 20;
        int i = this.d.getWidth();
        this.s = (Math.min(this.d.getHeight(), i) / 5);
        this.t = BitmapUtils.copy(this.d, Bitmap.Config.ARGB_8888);
        this.L = a(30);
        this.x = new MosaicParams();
        this.x.setBlurPixels(this.L);
        this.x.setMaskWidth(this.d.getWidth());
        this.x.setMaskHeight(this.d.getHeight());
        this.y = new f(this, this.d, this.t, this.x);
        j();
        Resources localResources = this.h.getResources();
        this.N = new float[5];
        this.N[0] = localResources.getDimension(R.dimen.fotor_mosaic_brush_size_radius_1);
        this.N[1] = localResources.getDimension(R.dimen.fotor_mosaic_brush_size_radius_2);
        this.N[2] = localResources.getDimension(R.dimen.fotor_mosaic_brush_size_radius_3);
        this.N[3] = localResources.getDimension(R.dimen.fotor_mosaic_brush_size_radius_4);
        this.N[4] = localResources.getDimension(R.dimen.fotor_mosaic_brush_size_radius_5);
    }

    protected void u() {
        this.n = ((FrameLayout) w().findViewById(R.id.fotor_mosaic_painter_container));
        this.H = ((FotorMosaicBrushSizeDisplayer) w().findViewById(R.id.fotor_mosaic_brush_size_displayer));
        this.p = new com.everimaging.fotorsdk.brush.painter.beauty.a(this.h);
        this.n.addView(this.p);
        this.p.setOnPainterBeautyListenr(this);
        this.o = this.p.getViewCamera();
        this.o.a(false);
        this.o.a(this);
        this.M = this.N[4];
        this.q = new SmudgeBrush();
        this.H.setBrushSize(this.M);
        this.q.a(255);
        this.q.c(0.5F);
        this.q.a(1.0F);
        this.q.a(SmudgeBrush.DrawStyle.CIRCLE);
        this.q.a(false);
        this.q.b();
        this.p.setSmudgeBrush(this.q);
        this.z = LayoutInflater.from(this.h).inflate(R.layout.fotor_feature_mosaic_redoundo_panel, null);
        Object localObject = new FrameLayout.LayoutParams(-1, -2, 48);
        this.a.a(this.z, (FrameLayout.LayoutParams) localObject);
        this.A = ((ImageButton) this.z.findViewById(R.id.fotor_mosaic_undo_button));
        this.A.setOnClickListener(this.P);
        this.A.setEnabled(false);
        this.B = ((ImageButton) this.z.findViewById(R.id.fotor_mosaic_redo_button));
        this.B.setOnClickListener(this.P);
        this.B.setEnabled(false);
        this.K = new com.everimaging.fotorsdk.editor.feature.utils.a(this.p);
        this.K.h();
        this.K.a(this);
        localObject = v();
        LinearLayout localLinearLayout = (LinearLayout) ((View) localObject).findViewById(R.id.fotor_mosaic_operation_btn_container);
        this.C = new FotorNavigationButtonShort(this.h);
        this.C.setButtonNameResource(R.string.fotor_mosaic_brush_btn);
        this.C.setImageResource(R.drawable.fotor_mosaic_brush_button);
        this.C.setOnClickListener(this.Q);
        localLinearLayout.addView(this.C, new FrameLayout.LayoutParams(-2, -1));
        this.D = new FotorNavigationButtonShort(this.h);
        this.D.setButtonNameResource(R.string.fotor_mosaic_eraser_btn);
        this.D.setImageResource(R.drawable.fotor_mosaic_eraser_button);
        this.D.setOnClickListener(this.Q);
        localLinearLayout.addView(this.D, new FrameLayout.LayoutParams(-2, -1));
        this.E = this.C;
        this.E.setSelected(true);
        this.F = ((FotorSliderPanelLayout) ((View) localObject).findViewById(R.id.fotor_mosaic_density_slider));
        this.F.setMax(30);
        this.F.setProgress(30);
        this.F.setIsShowValue(false);
        this.F.setOnChangedListener(this.R);
        this.G = ((FotorMosaicBrushSizeSlider) ((View) localObject).findViewById(R.id.fotor_mosaic_brush_size_slider));
        this.G.setLevel(4);
        this.G.setSliderListener(this.S);
    }

    public FotorFeaturesFactory.FeatureType x() {
        return FotorFeaturesFactory.FeatureType.PIXELATE;
    }

    public String y() {
        return this.h.getString(R.string.fotor_feature_pixelate);
    }

    public boolean z() {
        if (this.O != null) {
            this.O.a();
            return true;
        }
        return super.z();
    }

    private class a
            extends FotorAsyncTask<Void, Void, Void> {
        private a() {
        }

        protected Void a(Void... paramVarArgs) {
            try {
                i.r(i.this).f();
                publishProgress(new Void[0]);
                if ((i.s(i.this)) && (!isCancelled())) {
                    i.a(i.this, false);
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
            if (!i.t(i.this)) {
                i.v(i.this).a(i.this.d, i.u(i.this));
                i.q(i.this).b(i.this.d.getWidth(), i.this.d.getHeight());
                i.b(i.this, true);
            }
            i.c(i.this, false);
            i.a(i.this, null);
        }

        protected void b(Void paramVoid) {
            i.c(i.this, false);
            i.a(i.this, null);
        }

        protected void b(Void... paramVarArgs) {
            if (!i.t(i.this)) {
                i.v(i.this).a(i.this.d, i.u(i.this));
                i.q(i.this).b(i.this.d.getWidth(), i.this.d.getHeight());
                i.b(i.this, true);
            }
            if (i.this.G()) {
                i.v(i.this).postInvalidate();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/feature/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */