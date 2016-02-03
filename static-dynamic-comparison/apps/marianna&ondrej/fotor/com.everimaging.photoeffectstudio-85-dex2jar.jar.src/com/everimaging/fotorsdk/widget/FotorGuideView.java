package com.everimaging.fotorsdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.everimaging.fotorsdk.R.anim;
import com.everimaging.fotorsdk.R.attr;
import com.everimaging.fotorsdk.utils.FotorResUtils;
import com.everimaging.fotorsdk.widget.entity.GuideFeatureEntity;
import com.everimaging.fotorsdk.widget.entity.GuideFeatureEntity.GuideFrame;
import com.everimaging.fotorsdk.widget.entity.GuideFeatureEntity.GuideText;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public class FotorGuideView
        extends FrameLayout
        implements View.OnClickListener {
    private Gson a;
    private GuideFeatureEntity b;
    private RelativeLayout c;
    private ImageView d;
    private int e = 0;
    private Runnable f = null;
    private a g;
    private boolean h = false;

    public FotorGuideView(Context paramContext) {
        this(paramContext, null);
    }

    public FotorGuideView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, R.attr.fotorDefaultGuideViewStyle);
    }

    public FotorGuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        b();
    }

    private void b() {
        this.d = new ImageView(getContext());
        this.d.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.d.setBackgroundColor(0);
        addView(this.d, new FrameLayout.LayoutParams(-1, -1));
        this.c = new RelativeLayout(getContext());
        addView(this.c, new FrameLayout.LayoutParams(-1, -1));
        this.a = new Gson();
        setOnClickListener(this);
        setVisibility(4);
    }

    private void b(int paramInt) {
        if (paramInt != 0) {
        }
        try {
            Object localObject = getResources().openRawResource(paramInt);
            if (localObject != null) {
                localObject = new InputStreamReader((InputStream) localObject);
                this.b = ((GuideFeatureEntity) this.a.fromJson((Reader) localObject, GuideFeatureEntity.class));
            }
            return;
        } catch (Exception localException) {
        }
    }

    private void c() {
        Animation localAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fotor_fit_view_fadeout_animation);
        localAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation paramAnonymousAnimation) {
                FotorGuideView.a(FotorGuideView.this, false);
                if (FotorGuideView.b(FotorGuideView.this) != null) {
                    FotorGuideView.b(FotorGuideView.this).n();
                }
            }

            public void onAnimationRepeat(Animation paramAnonymousAnimation) {
            }

            public void onAnimationStart(Animation paramAnonymousAnimation) {
                FotorGuideView.a(FotorGuideView.this, true);
            }
        });
        startAnimation(localAnimation);
    }

    private void d() {
        if (this.b != null) {
            this.c.removeAllViews();
            Object localObject = (GuideFeatureEntity.GuideFrame) this.b.getFrames().get(this.e);
            int i = FotorResUtils.getDrawableId(getContext(), ((GuideFeatureEntity.GuideFrame) localObject).getResFileName());
            this.d.setImageResource(i);
            RectF localRectF = new RectF();
            this.d.getImageMatrix().mapRect(localRectF);
            localRectF.right = (this.d.getWidth() - localRectF.left);
            localRectF.bottom = (this.d.getHeight() - localRectF.top);
            localObject = ((GuideFeatureEntity.GuideFrame) localObject).getGuideTextItems().iterator();
            if (((Iterator) localObject).hasNext()) {
                GuideFeatureEntity.GuideText localGuideText = (GuideFeatureEntity.GuideText) ((Iterator) localObject).next();
                FotorTextView localFotorTextView = new FotorTextView(getContext());
                localFotorTextView.setId(localGuideText.getId());
                localFotorTextView.setText(FotorResUtils.getStringId(getContext(), localGuideText.getResTextName()));
                localFotorTextView.setTextColor(Color.parseColor(localGuideText.getTextColor()));
                localFotorTextView.setTextSize(2, localGuideText.getTextSize());
                label229:
                label268:
                RelativeLayout.LayoutParams localLayoutParams;
                int j;
                if (localGuideText.isSingleLine()) {
                    localFotorTextView.setMaxLines(1);
                    switch (4. a[localGuideText.getTextAlign().ordinal()])
                    {
                        default:
                            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            i = (int) (localGuideText.getMarginH() * localRectF.width());
                            j = (int) (localGuideText.getMarginV() * localRectF.height());
                            switch (4. b[localGuideText.getAlignParentH().ordinal()])
                        {
                            default:
                                label344:
                                switch (4. b[localGuideText.getAlignParentV().ordinal()])
                            {
                            }
                            break;
                        }
                        break;
                    }
                }
                for (; ; ) {
                    if (localGuideText.getAlignTargetId() != -1) {
                        if (localGuideText.isAlignTargetAbove()) {
                            localLayoutParams.addRule(2, localGuideText.getAlignTargetId());
                            localLayoutParams.bottomMargin = j;
                        }
                        if (localGuideText.isAlignTargetBelow()) {
                            localLayoutParams.addRule(3, localGuideText.getAlignTargetId());
                            localLayoutParams.topMargin = j;
                        }
                        if (localGuideText.isAlignTargetLeft()) {
                            localLayoutParams.addRule(5, localGuideText.getAlignTargetId());
                        }
                        if (localGuideText.isAlignTargetRight()) {
                            localLayoutParams.addRule(7, localGuideText.getAlignTargetId());
                        }
                    }
                    this.c.addView(localFotorTextView, localLayoutParams);
                    break;
                    localFotorTextView.setMaxWidth((int) (localRectF.width() * localGuideText.getMaxWidth()));
                    break label229;
                    localFotorTextView.setGravity(3);
                    break label268;
                    localFotorTextView.setGravity(17);
                    break label268;
                    localFotorTextView.setGravity(5);
                    break label268;
                    localLayoutParams.addRule(9, -1);
                    float f1 = localRectF.left;
                    localLayoutParams.leftMargin = ((int) (i + f1));
                    break label344;
                    localLayoutParams.addRule(14, -1);
                    break label344;
                    localLayoutParams.addRule(11, -1);
                    f1 = localRectF.left;
                    localLayoutParams.rightMargin = ((int) (i + f1));
                    break label344;
                    localLayoutParams.addRule(10, -1);
                    localLayoutParams.topMargin = ((int) (localRectF.top + j));
                    continue;
                    localLayoutParams.addRule(15, -1);
                    continue;
                    localLayoutParams.addRule(12, -1);
                    localLayoutParams.bottomMargin = ((int) (localRectF.top + j));
                }
            }
        }
    }

    public void a() {
        if (this.h) {
            return;
        }
        this.e += 1;
        if ((this.b != null) && (this.e < this.b.getFrameNum())) {
            d();
            return;
        }
        c();
    }

    public void a(int paramInt) {
        b(paramInt);
        this.e = 0;
        if (getWidth() > 0) {
            d();
        }
        for (; ; ) {
            Animation localAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fotor_fit_view_fadein_animation);
            localAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation paramAnonymousAnimation) {
                    FotorGuideView.a(FotorGuideView.this, false);
                }

                public void onAnimationRepeat(Animation paramAnonymousAnimation) {
                }

                public void onAnimationStart(Animation paramAnonymousAnimation) {
                    FotorGuideView.this.setVisibility(0);
                    FotorGuideView.a(FotorGuideView.this, true);
                }
            });
            startAnimation(localAnimation);
            return;
            this.f = new Runnable() {
                public void run() {
                    FotorGuideView.a(FotorGuideView.this);
                }
            };
        }
    }

    public void onClick(View paramView) {
        a();
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        if (this.f != null) {
            this.f.run();
        }
        this.f = null;
    }

    public void setGuideViewListener(a parama) {
        this.g = parama;
    }

    public static abstract interface a {
        public abstract void n();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/FotorGuideView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */