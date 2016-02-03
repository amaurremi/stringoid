package com.everimaging.fotorsdk.editor.feature;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SeekBar;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.editor.FotorFeaturesFactory.FeatureType;
import com.everimaging.fotorsdk.editor.R.anim;
import com.everimaging.fotorsdk.editor.R.drawable;
import com.everimaging.fotorsdk.editor.R.id;
import com.everimaging.fotorsdk.editor.R.layout;
import com.everimaging.fotorsdk.editor.R.raw;
import com.everimaging.fotorsdk.editor.R.string;
import com.everimaging.fotorsdk.editor.c;
import com.everimaging.fotorsdk.editor.filter.params.CropParams;
import com.everimaging.fotorsdk.editor.widget.FotorCropRatioButton;
import com.everimaging.fotorsdk.editor.widget.FotorCropView;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.BitmapUtils;
import com.everimaging.fotorsdk.widget.FotorGuideView;
import com.everimaging.fotorsdk.widget.FotorGuideView.a;
import com.everimaging.fotorsdk.widget.FotorImageView;
import com.everimaging.fotorsdk.widget.FotorImageView.b;
import com.everimaging.fotorsdk.widget.FotorSliderPanelLayout;
import com.everimaging.fotorsdk.widget.FotorSliderPanelLayout.a;

public class CropFeature
        extends a
        implements View.OnClickListener, FotorGuideView.a, FotorImageView.b, FotorSliderPanelLayout.a {
    private static final String l = CropFeature.class.getSimpleName();
    private static final int[] m = {R.string.fotor_crop_free, R.string.fotor_crop_original, R.string.fotor_crop_1_1, R.string.fotor_crop_4_3, R.string.fotor_crop_6_4, R.string.fotor_crop_7_5, R.string.fotor_crop_10_8, R.string.fotor_crop_16_9};
    private static final int[] n = {R.string.fotor_crop_free, R.string.fotor_crop_original, R.string.fotor_crop_1_1, R.string.fotor_crop_3_4, R.string.fotor_crop_4_6, R.string.fotor_crop_5_7, R.string.fotor_crop_8_10, R.string.fotor_crop_9_16};
    private static final float[][] o;
    private View.OnClickListener A = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            CropFeature.d(CropFeature.this);
        }
    };
    private FotorLoggerFactory.c p = FotorLoggerFactory.a(l, FotorLoggerFactory.LoggerType.CONSOLE);
    private FotorImageView q;
    private LinearLayout r;
    private FotorCropView s;
    private FotorSliderPanelLayout t;
    private ImageButton u;
    private FotorCropRatioButton v;
    private FotorCropRatioButton[] w;
    private FotorGuideView x;
    private CropRatioMode y = CropRatioMode.RATIO_LANDSCAPE;
    private boolean z = false;

    static {
        float[] arrayOfFloat1 = {-2.0F, 1.0F};
        float[] arrayOfFloat2 = {4.0F, 3.0F};
        float[] arrayOfFloat3 = {7.0F, 5.0F};
        float[] arrayOfFloat4 = {10.0F, 8.0F};
        float[] arrayOfFloat5 = {16.0F, 9.0F};
        o = new float[][]{{0.0F, 1.0F}, {-1.0F, 1.0F}, arrayOfFloat1, arrayOfFloat2, {6.0F, 4.0F}, arrayOfFloat3, arrayOfFloat4, arrayOfFloat5};
    }

    public CropFeature(c paramc) {
        super(paramc);
    }

    private void a(float paramFloat) {
        float f1 = this.d.getWidth();
        float f2 = this.d.getHeight();
        f1 /= 2.0F;
        f2 /= 2.0F;
        float f3 = this.s.a(paramFloat);
        Matrix localMatrix1 = new Matrix();
        localMatrix1.setRotate(paramFloat, f1, f2);
        Matrix localMatrix2 = new Matrix();
        localMatrix2.setScale(f3, f3, f1, f2);
        Matrix localMatrix3 = this.q.getImageViewMatrix();
        localMatrix3.preConcat(localMatrix1);
        localMatrix3.preConcat(localMatrix2);
        this.q.setImageMatrix(localMatrix3);
        this.q.invalidate();
    }

    private void b() {
        if (com.everimaging.fotorsdk.preference.a.c(this.h)) {
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
            localLayoutParams.gravity = 48;
            this.x = new FotorGuideView(this.h);
            this.x.setGuideViewListener(this);
            this.a.b(this.x, localLayoutParams);
            this.a.e().post(new Runnable() {
                public void run() {
                    CropFeature.a(CropFeature.this).a(R.raw.fotor_guide_crop_config);
                }
            });
        }
    }

    private void c() {
        int[] arrayOfInt = m;
        if (this.y == CropRatioMode.RATIO_PORTRAIT) {
            arrayOfInt = n;
        }
        int i = 1;
        if (i < o.length) {
            FotorCropRatioButton localFotorCropRatioButton = this.w[i];
            localFotorCropRatioButton.setButtonName(this.h.getResources().getString(arrayOfInt[i]));
            if (this.y == CropRatioMode.RATIO_LANDSCAPE) {
                localFotorCropRatioButton.a(o[i][0], o[i][1]);
            }
            for (; ; ) {
                i += 1;
                break;
                localFotorCropRatioButton.a(o[i][1], o[i][0]);
            }
        }
    }

    private float d() {
        return (this.t.getSeekBar().getProgress() - 250) / 10.0F;
    }

    private void h() {
        this.t.setProgress(250);
        this.u.setEnabled(false);
    }

    public void A() {
        Object localObject = this.s.getStraightenSize();
        float f = d();
        Rect localRect = this.s.getCropBounds();
        CropParams localCropParams = new CropParams();
        localCropParams.setStraiSize((int[]) localObject);
        localCropParams.setStraiDegree(f);
        localCropParams.setCropBounds(localRect);
        localCropParams.setPreviewSize(this.d.getWidth(), this.d.getHeight());
        localObject = BitmapUtils.getStraiCropResult(this.d, (int[]) localObject, f, localRect);
        if (this.b != null) {
            this.b.a(this, (Bitmap) localObject, new BaseParams[]{localCropParams});
        }
    }

    protected void C() {
        float f = d();
        Rect localRect = this.s.getCropBounds();
        if ((Float.compare(f, 0.0F) != 0) || (localRect.width() != this.d.getWidth()) || (localRect.height() != this.d.getHeight())) {
            this.i = true;
            return;
        }
        this.i = false;
    }

    public void a() {
        if (this.z) {
            final RectF localRectF = this.q.getPictureRectF();
            this.a.e().postDelayed(new Runnable() {
                public void run() {
                    CropFeature.b(CropFeature.this).b(localRectF, CropFeature.this.d.getWidth(), CropFeature.this.d.getHeight());
                    CropFeature.a(CropFeature.this, false);
                    CropFeature.b(CropFeature.this).setVisibility(0);
                    CropFeature.a(CropFeature.this, CropFeature.e(CropFeature.this));
                }
            }, 100L);
        }
    }

    public void a(Configuration paramConfiguration) {
        super.a(paramConfiguration);
        this.z = true;
        this.s.setVisibility(4);
    }

    public void a(FotorSliderPanelLayout paramFotorSliderPanelLayout) {
        this.s.b();
    }

    public void a(FotorSliderPanelLayout paramFotorSliderPanelLayout, int paramInt, boolean paramBoolean) {
        float f = d();
        this.t.setDisplayValue(String.valueOf(f));
        a(f);
        if (f != 0.0F) {
            this.u.setEnabled(true);
            return;
        }
        this.u.setEnabled(false);
    }

    public void b(FotorSliderPanelLayout paramFotorSliderPanelLayout) {
        this.s.a();
    }

    public View c(LayoutInflater paramLayoutInflater) {
        return paramLayoutInflater.inflate(R.layout.fotor_feature_crop_operation_panel, null);
    }

    public View d(LayoutInflater paramLayoutInflater) {
        return paramLayoutInflater.inflate(R.layout.fotor_feature_fitscreen_draw_panel, null);
    }

    protected void m() {
        super.m();
        this.q.setImageBitmap(this.d);
        this.s = new FotorCropView(this.h);
        this.s.setVisibility(4);
        this.a.a(this.s, null);
        Object localObject = (FrameLayout.LayoutParams) this.s.getLayoutParams();
        ((FrameLayout.LayoutParams) localObject).width = -1;
        ((FrameLayout.LayoutParams) localObject).height = -1;
        this.s.setLayoutParams((ViewGroup.LayoutParams) localObject);
        localObject = this.q.getPictureRectF();
        this.s.a((RectF) localObject, this.d.getWidth(), this.d.getHeight());
        this.s.setRatio(0.0F);
        localObject = (AnimationSet) AnimationUtils.loadAnimation(this.h, R.anim.fotor_fit_view_fadein_animation);
        ((AnimationSet) localObject).setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation paramAnonymousAnimation) {
                CropFeature.c(CropFeature.this);
            }

            public void onAnimationRepeat(Animation paramAnonymousAnimation) {
            }

            public void onAnimationStart(Animation paramAnonymousAnimation) {
                CropFeature.b(CropFeature.this).setVisibility(0);
            }
        });
        this.s.startAnimation((Animation) localObject);
        this.t.setEnabled(true);
    }

    public void n() {
        this.a.d(this.x);
        com.everimaging.fotorsdk.preference.a.b(this.h, false);
        this.x = null;
    }

    public void onClick(View paramView) {
        if (!G()) {
            return;
        }
        Float localFloat = (Float) paramView.getTag();
        FotorCropRatioButton localFotorCropRatioButton = (FotorCropRatioButton) paramView;
        this.p.c(new Object[]{"onClick view ratio:" + localFloat});
        float f;
        if (localFloat.floatValue() > 0.0F) {
            if (localFotorCropRatioButton == this.v) {
                if (this.y == CropRatioMode.RATIO_LANDSCAPE) {
                    paramView = CropRatioMode.RATIO_PORTRAIT;
                    this.y = paramView;
                    c();
                }
            } else {
                if (this.y != CropRatioMode.RATIO_LANDSCAPE) {
                    break label183;
                }
                f = localFloat.floatValue();
                label114:
                paramView = Float.valueOf(f);
                this.s.setRatio(paramView.floatValue());
                label130:
                this.v.setSelected(false);
                this.v = localFotorCropRatioButton;
                this.v.setSelected(true);
                if (paramView.floatValue() != 0.0F) {
                    break label290;
                }
                paramView = "Custom";
            }
        }
        for (; ; ) {
            com.everimaging.fotorsdk.a.a("EDIT_CROP_ITEM_TAP", "Crop_Type", paramView);
            return;
            paramView = CropRatioMode.RATIO_LANDSCAPE;
            break;
            label183:
            f = 1.0F / localFloat.floatValue();
            break label114;
            paramView = localFloat;
            if (localFotorCropRatioButton == this.v) {
                break label130;
            }
            if (localFloat.floatValue() == 0.0F) {
                this.s.setRatio(0.0F);
                paramView = localFloat;
                break label130;
            }
            if (localFloat.floatValue() == -1.0F) {
                this.s.setRatio(this.d.getWidth() / this.d.getHeight());
                paramView = localFloat;
                break label130;
            }
            paramView = localFloat;
            if (localFloat.floatValue() != -2.0F) {
                break label130;
            }
            this.s.setRatio(1.0F);
            paramView = localFloat;
            break label130;
            label290:
            if (paramView.floatValue() == -1.0F) {
                paramView = "Original";
            } else if (!TextUtils.isEmpty(localFotorCropRatioButton.getButtonName())) {
                paramView = localFotorCropRatioButton.getButtonName().toString();
            } else {
                paramView = "Unknow";
            }
        }
    }

    protected void p() {
        super.p();
        AnimationSet localAnimationSet = (AnimationSet) AnimationUtils.loadAnimation(this.h, R.anim.fotor_fit_view_fadeout_animation);
        this.s.startAnimation(localAnimationSet);
    }

    protected void q() {
        super.q();
        this.q.setImageBitmap(null);
    }

    protected void t() {
        this.p.c(new Object[]{"==========initDatas=========="});
    }

    protected void u() {
        LayoutInflater localLayoutInflater = (LayoutInflater) this.h.getSystemService("layout_inflater");
        this.r = ((LinearLayout) v().findViewById(R.id.fotor_crop_operation_container));
        Object localObject;
        if (this.d.getWidth() >= this.d.getHeight()) {
            localObject = CropRatioMode.RATIO_LANDSCAPE;
            this.y = ((CropRatioMode) localObject);
            localObject = m;
            if (this.y != CropRatioMode.RATIO_PORTRAIT) {
                break label420;
            }
            localObject = n;
        }
        label88:
        label420:
        for (; ; ) {
            this.w = new FotorCropRatioButton[o.length];
            int i = 0;
            if (i < o.length) {
                View localView = localLayoutInflater.inflate(R.layout.fotor_feature_crop_ratio_item, null);
                FotorCropRatioButton localFotorCropRatioButton = (FotorCropRatioButton) localView.findViewById(R.id.fotor_crop_ratio_button);
                localFotorCropRatioButton.setButtonName(this.h.getResources().getString(localObject[i]));
                localFotorCropRatioButton.setTag(Float.valueOf(o[i][0] / o[i][1]));
                localFotorCropRatioButton.setOnClickListener(this);
                this.r.addView(localView, new LinearLayout.LayoutParams(-2, -1));
                this.w[i] = localFotorCropRatioButton;
                if (i == 0) {
                    localFotorCropRatioButton.setImageDrawable(this.h.getResources().getDrawable(R.drawable.fotor_crop_ratio_free_button));
                    this.v = localFotorCropRatioButton;
                    this.v.setSelected(true);
                }
                for (; ; ) {
                    i += 1;
                    break label88;
                    localObject = CropRatioMode.RATIO_PORTRAIT;
                    break;
                    if (this.y == CropRatioMode.RATIO_LANDSCAPE) {
                        localFotorCropRatioButton.a(o[i][0], o[i][1]);
                    } else {
                        localFotorCropRatioButton.a(o[i][1], o[i][0]);
                    }
                }
            }
            this.t = ((FotorSliderPanelLayout) v().findViewById(R.id.fotor_crop_slider));
            this.t.setMax(500);
            this.t.setProgress(250);
            this.t.setOnChangedListener(this);
            this.u = ((ImageButton) v().findViewById(R.id.fotor_crop_restore));
            this.u.setEnabled(false);
            this.u.setOnClickListener(this.A);
            this.q = ((FotorImageView) w().findViewById(R.id.fotor_fitscreen_imageview));
            this.q.setTouchable(false);
            this.q.setFotorImageViewLayoutListener(this);
            this.t.setEnabled(false);
            return;
        }
    }

    public FotorFeaturesFactory.FeatureType x() {
        return FotorFeaturesFactory.FeatureType.CROP;
    }

    public String y() {
        return this.h.getString(R.string.fotor_feature_crop);
    }

    public boolean z() {
        if (this.x != null) {
            this.x.a();
            return true;
        }
        return super.z();
    }

    private static enum CropRatioMode {
        RATIO_LANDSCAPE, RATIO_PORTRAIT;

        private CropRatioMode() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/feature/CropFeature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */