package com.everimaging.fotorsdk.editor.feature;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.everimaging.fotorsdk.algorithms.filter.params.AdjustParams;
import com.everimaging.fotorsdk.editor.FotorFeaturesFactory.FeatureType;
import com.everimaging.fotorsdk.editor.R.anim;
import com.everimaging.fotorsdk.editor.R.dimen;
import com.everimaging.fotorsdk.editor.R.drawable;
import com.everimaging.fotorsdk.editor.R.id;
import com.everimaging.fotorsdk.editor.R.integer;
import com.everimaging.fotorsdk.editor.R.layout;
import com.everimaging.fotorsdk.editor.R.string;
import com.everimaging.fotorsdk.editor.filter.AdjustFilter.AdjustFilterType;
import com.everimaging.fotorsdk.editor.widget.b.b;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.DeviceUtils;
import com.everimaging.fotorsdk.widget.FotorImageView;
import com.everimaging.fotorsdk.widget.FotorSliderPanelLayout;
import com.everimaging.fotorsdk.widget.FotorSliderPanelLayout.a;
import com.everimaging.fotorsdk.widget.FotorTextButton;

public class c
        extends b {
    private static final String y = c.class.getSimpleName();
    private static final FotorLoggerFactory.c z = FotorLoggerFactory.a(y, FotorLoggerFactory.LoggerType.CONSOLE);
    private FrameLayout A;
    private FotorSliderPanelLayout B;
    private FotorSliderPanelLayout C;
    private FotorSliderPanelLayout D;
    private FrameLayout E;
    private FotorTextButton F;
    private FotorTextButton G;
    private FrameLayout H;
    private com.everimaging.fotorsdk.editor.widget.b I;
    private boolean J = false;
    private int K;
    private boolean L = false;
    private FotorSliderPanelLayout.a M = new FotorSliderPanelLayout.a() {
        public void a(FotorSliderPanelLayout paramAnonymousFotorSliderPanelLayout) {
        }

        public void a(FotorSliderPanelLayout paramAnonymousFotorSliderPanelLayout, int paramAnonymousInt, boolean paramAnonymousBoolean) {
            c.h().b(new Object[]{"onRGBSliderChanged fromUser:" + paramAnonymousBoolean + ",progress:" + paramAnonymousInt});
            float f = paramAnonymousInt - 100;
            if (paramAnonymousFotorSliderPanelLayout == c.a(c.this)) {
                c.a(c.this).setDisplayValue(String.valueOf((int) f));
                c.this.q.setRgb_R(f);
            }
            for (; ; ) {
                c.this.d();
                return;
                if (paramAnonymousFotorSliderPanelLayout == c.b(c.this)) {
                    c.b(c.this).setDisplayValue(String.valueOf((int) f));
                    c.this.q.setRgb_G(f);
                } else if (paramAnonymousFotorSliderPanelLayout == c.c(c.this)) {
                    c.c(c.this).setDisplayValue(String.valueOf((int) f));
                    c.this.q.setRgb_B(f);
                }
            }
        }

        public void b(FotorSliderPanelLayout paramAnonymousFotorSliderPanelLayout) {
        }
    };
    private b.b N = new b.b() {
        public void a(float[] paramAnonymousArrayOfFloat) {
            c.this.q.setCurvePoints(paramAnonymousArrayOfFloat);
            c.this.d();
            c.e(c.this).setEnabled(c.d(c.this).a());
        }
    };
    private View.OnClickListener O = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            if (paramAnonymousView == c.f(c.this)) {
                if (c.f(c.this).isSelected()) {
                    c.g(c.this);
                    c.i(c.this);
                }
            }
            while (paramAnonymousView != c.e(c.this)) {
                for (; ; ) {
                    return;
                    c.h(c.this);
                }
            }
            c.d(c.this).b();
            c.e(c.this).setEnabled(false);
        }
    };
    private View.OnTouchListener P = new View.OnTouchListener() {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
            switch (paramAnonymousMotionEvent.getAction()) {
            }
            for (; ; ) {
                return true;
                if (c.f(c.this).isSelected()) {
                    c.g(c.this);
                    c.i(c.this);
                }
            }
        }
    };

    public c(com.everimaging.fotorsdk.editor.c paramc) {
        super(paramc);
    }

    private void J() {
        if ((this.J) || (this.H.getParent() == null)) {
            return;
        }
        AnimationSet localAnimationSet = (AnimationSet) AnimationUtils.loadAnimation(this.h, R.anim.fotor_footer_bar_out_animation);
        localAnimationSet.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation paramAnonymousAnimation) {
                c.this.a.b(c.j(c.this));
                c.a(c.this, false);
            }

            public void onAnimationRepeat(Animation paramAnonymousAnimation) {
            }

            public void onAnimationStart(Animation paramAnonymousAnimation) {
            }
        });
        this.a.a().f().startAnimation(localAnimationSet);
        this.J = true;
    }

    private void b(final View paramView) {
        final AnimationSet localAnimationSet1 = (AnimationSet) AnimationUtils.loadAnimation(this.h, R.anim.fotor_footer_bar_in_animation);
        localAnimationSet1.setDuration(localAnimationSet1.getDuration() / 2L);
        AnimationSet localAnimationSet2 = (AnimationSet) AnimationUtils.loadAnimation(this.h, R.anim.fotor_footer_bar_out_animation);
        localAnimationSet2.setDuration(localAnimationSet2.getDuration() / 2L);
        localAnimationSet2.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation paramAnonymousAnimation) {
                c.this.a(paramView);
                paramView.startAnimation(localAnimationSet1);
                c.b(c.this, false);
            }

            public void onAnimationRepeat(Animation paramAnonymousAnimation) {
            }

            public void onAnimationStart(Animation paramAnonymousAnimation) {
            }
        });
        if (this.m.getChildCount() > 0) {
            this.m.getChildAt(0).startAnimation(localAnimationSet2);
            this.L = true;
            return;
        }
        a(paramView);
        paramView.startAnimation(localAnimationSet1);
    }

    private void i() {
        if (this.F.isSelected()) {
            this.F.setText(R.string.fotor_adjust_curve_hide);
            return;
        }
        this.F.setText(R.string.fotor_adjust_curve_show);
    }

    private void j() {
        this.H.setVisibility(0);
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, this.s.getHeight(), 0, 0.0F);
        localTranslateAnimation.setDuration(this.h.getResources().getInteger(R.integer.fotor_anim_short_duration));
        localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
        this.H.startAnimation(localTranslateAnimation);
        this.F.setSelected(true);
    }

    private void n() {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, 0.0F, 0, this.s.getHeight());
        localTranslateAnimation.setDuration(this.h.getResources().getInteger(R.integer.fotor_anim_short_duration));
        localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
        localTranslateAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation paramAnonymousAnimation) {
                c.j(c.this).setVisibility(4);
            }

            public void onAnimationRepeat(Animation paramAnonymousAnimation) {
            }

            public void onAnimationStart(Animation paramAnonymousAnimation) {
            }
        });
        this.H.startAnimation(localTranslateAnimation);
        this.F.setSelected(false);
    }

    protected int a(AdjustFilter.AdjustFilterType paramAdjustFilterType) {
        float f = 0.0F;
        switch (8. a[paramAdjustFilterType.ordinal()])
        {
        }
        for (; ; ) {
            return (int) f;
            f = this.q.getDisplayVignette();
            continue;
            f = this.q.getDisplayShadows();
            continue;
            f = this.q.getDisplayHighlights();
            continue;
            f = this.q.getDisplayTemperature();
            continue;
            f = this.q.getDisplayTint();
        }
    }

    public void a(Configuration paramConfiguration) {
        super.a(paramConfiguration);
        if (this.H.getParent() != null) {
            paramConfiguration = (FrameLayout.LayoutParams) this.H.getLayoutParams();
            int i = this.h.getResources().getDimensionPixelSize(R.dimen.fotor_main_header_height);
            int j = this.h.getResources().getDimensionPixelSize(R.dimen.fotor_main_bottom_height);
            paramConfiguration.width = DeviceUtils.getScreenWidth();
            paramConfiguration.height = (DeviceUtils.getScreenHeight() - i - j);
            this.H.requestLayout();
            i = View.MeasureSpec.makeMeasureSpec(0, 0);
            j = View.MeasureSpec.makeMeasureSpec(0, 0);
            this.I.measure(i, j);
        }
    }

    protected int[] a() {
        return new int[]{R.string.fotor_adjust_vignette, R.string.fotor_adjust_shadow, R.string.fotor_adjust_highlight, R.string.fotor_adjust_temp, R.string.fotor_adjust_tint, R.string.fotor_adjust_rgb, R.string.fotor_adjust_curve};
    }

    protected int b(AdjustFilter.AdjustFilterType paramAdjustFilterType) {
        float f = 0.0F;
        switch (8. a[paramAdjustFilterType.ordinal()])
        {
        }
        for (; ; ) {
            return (int) f;
            f = this.q.getDisplayVignette() * 2.0F;
            continue;
            f = this.q.getDisplayShadows() + 100.0F;
            continue;
            f = this.q.getDisplayHighlights() + 100.0F;
            continue;
            f = this.q.getDisplayTemperature() + 100.0F;
            continue;
            f = this.q.getDisplayTint() + 100.0F;
        }
    }

    protected void b(FotorSliderPanelLayout paramFotorSliderPanelLayout, int paramInt, boolean paramBoolean) {
        if ((!paramBoolean) || (!G())) {
            return;
        }
        paramInt -= 100;
        if (this.p == AdjustFilter.AdjustFilterType.VIGNETTE) {
            this.q.setVignette(paramInt);
        }
        for (; ; ) {
            this.o.setDisplayValue(String.valueOf(a(this.p)));
            d();
            return;
            if (this.p == AdjustFilter.AdjustFilterType.SHADOW) {
                this.q.setShadows(paramInt);
            } else if (this.p == AdjustFilter.AdjustFilterType.HIGHLIGHT) {
                this.q.setHighlights(paramInt);
            } else if (this.p == AdjustFilter.AdjustFilterType.TEMP) {
                this.q.setTemperature(paramInt);
            } else if (this.p == AdjustFilter.AdjustFilterType.TINT) {
                this.q.setTint(paramInt);
            }
        }
    }

    protected int[] b() {
        return new int[]{R.drawable.fotor_adjust_vignette, R.drawable.fotor_adjust_shadow, R.drawable.fotor_adjust_highlight, R.drawable.fotor_adjust_temp, R.drawable.fotor_adjust_tint, R.drawable.fotor_adjust_rgb, R.drawable.fotor_adjust_curve};
    }

    protected AdjustFilter.AdjustFilterType[] c() {
        return new AdjustFilter.AdjustFilterType[]{AdjustFilter.AdjustFilterType.VIGNETTE, AdjustFilter.AdjustFilterType.SHADOW, AdjustFilter.AdjustFilterType.HIGHLIGHT, AdjustFilter.AdjustFilterType.TEMP, AdjustFilter.AdjustFilterType.TINT, AdjustFilter.AdjustFilterType.RGB, AdjustFilter.AdjustFilterType.CURVE};
    }

    public void onClick(View paramView) {
        if ((this.L) || (this.J)) {
        }
        AdjustFilter.AdjustFilterType localAdjustFilterType;
        do {
            return;
            localAdjustFilterType = (AdjustFilter.AdjustFilterType) paramView.getTag();
        } while ((localAdjustFilterType == this.p) || (!G()));
        this.p = localAdjustFilterType;
        if (this.v != null) {
            this.v.setSelected(false);
        }
        this.v = paramView;
        this.v.setSelected(true);
        if ((this.p != AdjustFilter.AdjustFilterType.RGB) && (this.p != AdjustFilter.AdjustFilterType.CURVE)) {
            this.o.setProgress(b(this.p));
            if (this.n.getParent() == null) {
                b(this.n);
                J();
            }
        }
        for (; ; ) {
            paramView = "Unknow";
            if (this.p != null) {
                paramView = this.p.name();
            }
            com.everimaging.fotorsdk.a.a("EDIT_ADVANCEADJUST_ITEM_TAP", "Advance_Adjust_Type", paramView);
            return;
            if (this.p == AdjustFilter.AdjustFilterType.RGB) {
                if (this.A.getParent() == null) {
                    b(this.A);
                    J();
                }
            } else if ((this.p == AdjustFilter.AdjustFilterType.CURVE) && (this.E.getParent() == null)) {
                this.F.setSelected(true);
                i();
                b(this.E);
                this.a.a(this.H);
                paramView = (FrameLayout.LayoutParams) this.H.getLayoutParams();
                int i = this.h.getResources().getDimensionPixelSize(R.dimen.fotor_main_header_height);
                int j = this.h.getResources().getDimensionPixelSize(R.dimen.fotor_main_bottom_height);
                paramView.width = DeviceUtils.getScreenWidth();
                paramView.height = (DeviceUtils.getScreenHeight() - i - j);
                this.H.requestLayout();
                i = View.MeasureSpec.makeMeasureSpec(0, 0);
                j = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.I.measure(i, j);
                j();
            }
        }
    }

    protected void u() {
        super.u();
        LayoutInflater localLayoutInflater = LayoutInflater.from(this.h);
        this.A = ((FrameLayout) localLayoutInflater.inflate(R.layout.fotor_feature_adjust_operation_rgb_tools, null));
        this.B = ((FotorSliderPanelLayout) this.A.findViewById(R.id.fotor_adjust_slider_r));
        this.B.setOnChangedListener(this.M);
        this.C = ((FotorSliderPanelLayout) this.A.findViewById(R.id.fotor_adjust_slider_g));
        this.C.setOnChangedListener(this.M);
        this.D = ((FotorSliderPanelLayout) this.A.findViewById(R.id.fotor_adjust_slider_b));
        this.D.setOnChangedListener(this.M);
        this.K = this.h.getResources().getDimensionPixelSize(R.dimen.fotor_advance_adjust_curve_view_max_size);
        this.I = new com.everimaging.fotorsdk.editor.widget.b(this.h, this.j, this.k);
        this.I.setOnCurveChangedListener(this.N);
        this.H = new FrameLayout(this.h);
        if ((DeviceUtils.getScreenWidth() > this.K) && (DeviceUtils.isTablet(this.h))) {
            this.H.addView(this.I, new FrameLayout.LayoutParams(this.K, this.K, 85));
        }
        for (; ; ) {
            this.H.setOnTouchListener(this.P);
            this.E = ((FrameLayout) localLayoutInflater.inflate(R.layout.fotor_feature_adjust_operation_curve_controller, null));
            this.F = ((FotorTextButton) this.E.findViewById(R.id.fotor_adjust_curve_toggle_button));
            this.F.setOnClickListener(this.O);
            this.G = ((FotorTextButton) this.E.findViewById(R.id.fotor_adjust_curve_reset_button));
            this.G.setOnClickListener(this.O);
            this.G.setEnabled(false);
            this.o.setProgress(0);
            return;
            this.H.addView(this.I, new FrameLayout.LayoutParams(-1, -2, 80));
        }
    }

    public FotorFeaturesFactory.FeatureType x() {
        return FotorFeaturesFactory.FeatureType.ADJUST_ADVANCE;
    }

    public String y() {
        return this.h.getString(R.string.fotor_feature_adjust_advance);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/feature/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */