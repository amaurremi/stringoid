package com.everimaging.fotorsdk.store.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ViewFlipper;

public class FotorStackViewFlipper
        extends ViewFlipper {
    private a a;
    private boolean b = true;
    private boolean c = true;
    private Handler d = new Handler();

    public FotorStackViewFlipper(Context paramContext) {
        this(paramContext, null);
    }

    public FotorStackViewFlipper(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    private void b(final View paramView) {
        if ((this.c) && (this.b)) {
            this.d.post(new Runnable() {
                public void run() {
                    FotorStackViewFlipper.this.removeView(paramView);
                    if (FotorStackViewFlipper.a(FotorStackViewFlipper.this) != null) {
                        FotorStackViewFlipper.a(FotorStackViewFlipper.this).b(FotorStackViewFlipper.this);
                    }
                }
            });
        }
    }

    public void a(final View paramView) {
        if (paramView != null) {
            int i = indexOfChild(paramView);
            this.c = true;
            this.b = true;
            if (i > 0) {
                Animation localAnimation1 = getInAnimation();
                if ((localAnimation1 != null) && ((!localAnimation1.hasStarted()) || (localAnimation1.hasEnded()))) {
                    this.c = false;
                    localAnimation1.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationEnd(Animation paramAnonymousAnimation) {
                            FotorStackViewFlipper.a(FotorStackViewFlipper.this, true);
                            FotorStackViewFlipper.a(FotorStackViewFlipper.this, paramView);
                        }

                        public void onAnimationRepeat(Animation paramAnonymousAnimation) {
                        }

                        public void onAnimationStart(Animation paramAnonymousAnimation) {
                            if (FotorStackViewFlipper.a(FotorStackViewFlipper.this) != null) {
                                FotorStackViewFlipper.a(FotorStackViewFlipper.this).a(FotorStackViewFlipper.this);
                            }
                        }
                    });
                }
                Animation localAnimation2 = getOutAnimation();
                if ((localAnimation2 != null) && ((!localAnimation1.hasStarted()) || (localAnimation1.hasEnded()))) {
                    this.b = false;
                    localAnimation2.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationEnd(Animation paramAnonymousAnimation) {
                            FotorStackViewFlipper.b(FotorStackViewFlipper.this, true);
                            FotorStackViewFlipper.a(FotorStackViewFlipper.this, paramView);
                        }

                        public void onAnimationRepeat(Animation paramAnonymousAnimation) {
                        }

                        public void onAnimationStart(Animation paramAnonymousAnimation) {
                        }
                    });
                }
                setDisplayedChild(i - 1);
                b(paramView);
            }
        } else {
            return;
        }
        this.d.post(new Runnable() {
            public void run() {
                FotorStackViewFlipper.this.removeView(paramView);
            }
        });
    }

    public void a(View paramView, FrameLayout.LayoutParams paramLayoutParams) {
        if ((paramView.getParent() == null) && (paramView != null)) {
            addView(paramView, paramLayoutParams);
            int i = indexOfChild(paramView);
            if (i >= 0) {
                paramView = getInAnimation();
                if ((paramView != null) && ((!paramView.hasStarted()) || (paramView.hasEnded()))) {
                    paramView.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationEnd(Animation paramAnonymousAnimation) {
                            if (FotorStackViewFlipper.a(FotorStackViewFlipper.this) != null) {
                                FotorStackViewFlipper.a(FotorStackViewFlipper.this).b(FotorStackViewFlipper.this);
                            }
                        }

                        public void onAnimationRepeat(Animation paramAnonymousAnimation) {
                        }

                        public void onAnimationStart(Animation paramAnonymousAnimation) {
                            if (FotorStackViewFlipper.a(FotorStackViewFlipper.this) != null) {
                                FotorStackViewFlipper.a(FotorStackViewFlipper.this).a(FotorStackViewFlipper.this);
                            }
                        }
                    });
                }
                setDisplayedChild(i);
            }
        }
    }

    public void setFlipperAnimListener(a parama) {
        this.a = parama;
    }

    public static abstract interface a {
        public abstract void a(FotorStackViewFlipper paramFotorStackViewFlipper);

        public abstract void b(FotorStackViewFlipper paramFotorStackViewFlipper);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/widget/FotorStackViewFlipper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */