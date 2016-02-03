package com.everimaging.fotorsdk.editor.feature;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.everimaging.fotorsdk.algorithms.filter.params.AdjustParams;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.editor.R.anim;
import com.everimaging.fotorsdk.editor.R.id;
import com.everimaging.fotorsdk.editor.R.layout;
import com.everimaging.fotorsdk.editor.c;
import com.everimaging.fotorsdk.editor.filter.AdjustFilter;
import com.everimaging.fotorsdk.editor.filter.AdjustFilter.AdjustFilterType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.BitmapUtils;
import com.everimaging.fotorsdk.utils.FotorAsyncTask;
import com.everimaging.fotorsdk.widget.FotorImageView;
import com.everimaging.fotorsdk.widget.FotorImageView.c;
import com.everimaging.fotorsdk.widget.FotorNavigationButtonShort;
import com.everimaging.fotorsdk.widget.FotorSliderPanelLayout;
import com.everimaging.fotorsdk.widget.FotorSliderPanelLayout.a;

import java.util.concurrent.CountDownLatch;

public abstract class b
        extends a
        implements View.OnClickListener, FotorImageView.c, FotorSliderPanelLayout.a {
    private static final String y = b.class.getSimpleName();
    private static final FotorLoggerFactory.c z = FotorLoggerFactory.a(y, FotorLoggerFactory.LoggerType.CONSOLE);
    private boolean A;
    private boolean B;
    protected LinearLayout l;
    protected FrameLayout m;
    protected FrameLayout n;
    protected FotorSliderPanelLayout o;
    protected AdjustFilter.AdjustFilterType p;
    protected AdjustParams q;
    protected AdjustFilter r;
    protected FotorImageView s;
    protected Bitmap t;
    protected AdjustFilter.AdjustFilterType[] u;
    protected View v;
    protected int[] w;
    protected int[] x;

    public b(c paramc) {
        super(paramc);
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

    private boolean h() {
        try {
            boolean bool = this.B;
            return bool;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    private boolean i() {
        try {
            boolean bool = this.A;
            return bool;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void A() {
        if (this.b != null) {
            this.q.setPreviewSize(this.t.getWidth(), this.t.getHeight());
            this.b.a(this, this.t, new BaseParams[]{this.q});
        }
    }

    protected void a(View paramView) {
        try {
            this.m.removeAllViews();
            if (paramView != null) {
                FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.m.setVisibility(0);
                this.m.addView(paramView, localLayoutParams);
            }
            return;
        } finally {
        }
    }

    public void a(FotorImageView paramFotorImageView) {
    }

    public void a(FotorSliderPanelLayout paramFotorSliderPanelLayout) {
    }

    public void a(FotorSliderPanelLayout paramFotorSliderPanelLayout, int paramInt, boolean paramBoolean) {
        b(paramFotorSliderPanelLayout, paramInt, paramBoolean);
    }

    protected abstract int[] a();

    public void b(FotorImageView paramFotorImageView) {
    }

    public void b(FotorSliderPanelLayout paramFotorSliderPanelLayout) {
    }

    protected abstract void b(FotorSliderPanelLayout paramFotorSliderPanelLayout, int paramInt, boolean paramBoolean);

    protected abstract int[] b();

    public View c(LayoutInflater paramLayoutInflater) {
        return paramLayoutInflater.inflate(R.layout.fotor_feature_adjust_operation_panel, null);
    }

    public void c(FotorImageView paramFotorImageView) {
        this.s.setImageBitmap(this.d);
    }

    protected abstract AdjustFilter.AdjustFilterType[] c();

    public View d(LayoutInflater paramLayoutInflater) {
        return paramLayoutInflater.inflate(R.layout.fotor_feature_zoom_draw_panel, null);
    }

    protected void d() {
        if (i()) {
            a(true);
            return;
        }
        b(true);
        new a(null).execute(new Void[0]);
    }

    public void d(FotorImageView paramFotorImageView) {
        this.s.setImageBitmap(this.t);
    }

    public void f() {
        super.f();
        if (this.r != null) {
            this.r.b();
        }
    }

    protected void m() {
        super.m();
        this.t = BitmapUtils.copy(this.d, this.d.getConfig());
        this.s.setImageBitmap(this.t);
        this.q = new AdjustParams();
        this.r = new AdjustFilter(this, this.d, this.t, this.q);
        this.l.setEnabled(true);
    }

    protected void p() {
        super.p();
        this.n.startAnimation(AnimationUtils.loadAnimation(this.h, R.anim.fotor_footer_bar_out_animation));
    }

    protected void q() {
        super.q();
        this.s.setImageBitmap(null);
    }

    protected void t() {
    }

    protected void u() {
        LayoutInflater localLayoutInflater = (LayoutInflater) this.h.getSystemService("layout_inflater");
        this.l = ((LinearLayout) v().findViewById(R.id.fotor_adjust_pan_container));
        this.w = a();
        this.x = b();
        this.u = c();
        int i = 0;
        while (i < this.w.length) {
            FotorNavigationButtonShort localFotorNavigationButtonShort = new FotorNavigationButtonShort(this.h);
            localFotorNavigationButtonShort.setButtonName(this.h.getString(this.w[i]));
            localFotorNavigationButtonShort.setImageResource(this.x[i]);
            localFotorNavigationButtonShort.setTag(this.u[i]);
            localFotorNavigationButtonShort.setOnClickListener(this);
            localFotorNavigationButtonShort.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.l.addView(localFotorNavigationButtonShort);
            if (i == 0) {
                this.v = localFotorNavigationButtonShort;
                this.v.setSelected(true);
                this.p = this.u[i];
            }
            i += 1;
        }
        this.m = ((FrameLayout) v().findViewById(R.id.fotor_adjust_tools_container));
        this.n = ((FrameLayout) localLayoutInflater.inflate(R.layout.fotor_feature_adjust_operation_tools, null));
        this.o = ((FotorSliderPanelLayout) this.n.findViewById(R.id.fotor_adjust_slider));
        this.o.setOnChangedListener(this);
        this.s = ((FotorImageView) w().findViewById(R.id.fotor_zoom_imageview));
        this.s.setFotorImageViewListener(this);
        a(this.n);
        this.l.setEnabled(false);
    }

    private class a
            extends FotorAsyncTask<Void, Void, Void> {
        private CountDownLatch b;

        private a() {
        }

        protected Void a(Void... paramVarArgs) {
            try {
                this.b = new CountDownLatch(1);
                b.this.r.a();
                publishProgress(new Void[0]);
                this.b.await();
                if (b.a(b.this)) {
                    b.a(b.this, false);
                    a(new Void[0]);
                } else {
                    b.b(b.this, false);
                }
            } catch (Exception paramVarArgs) {
                paramVarArgs.printStackTrace();
            }
            return null;
        }

        protected void b(Void... paramVarArgs) {
            b.this.s.invalidate();
            b.this.i = true;
            b.this.a.e().post(new Runnable() {
                public void run() {
                    b.a.a(b.a.this).countDown();
                }
            });
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/feature/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */