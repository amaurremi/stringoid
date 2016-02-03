package com.everimaging.fotorsdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ViewFlipper;

public class FotorFlipperBarContainer
        extends ViewFlipper {
    private a a;

    public FotorFlipperBarContainer(Context paramContext) {
        super(paramContext);
    }

    public FotorFlipperBarContainer(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public void a() {
        if (getDisplayedChild() == 0) {
            Animation localAnimation = getInAnimation();
            if ((localAnimation != null) && ((!localAnimation.hasStarted()) || (localAnimation.hasEnded()))) {
                localAnimation.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationEnd(Animation paramAnonymousAnimation) {
                        if (FotorFlipperBarContainer.a(FotorFlipperBarContainer.this) != null) {
                            FotorFlipperBarContainer.a(FotorFlipperBarContainer.this).b(FotorFlipperBarContainer.this);
                        }
                    }

                    public void onAnimationRepeat(Animation paramAnonymousAnimation) {
                    }

                    public void onAnimationStart(Animation paramAnonymousAnimation) {
                        if (FotorFlipperBarContainer.a(FotorFlipperBarContainer.this) != null) {
                            FotorFlipperBarContainer.a(FotorFlipperBarContainer.this).a(FotorFlipperBarContainer.this);
                        }
                    }
                });
            }
            setDisplayedChild(1);
        }
    }

    public void b() {
        if (getDisplayedChild() == 1) {
            Animation localAnimation = getInAnimation();
            if ((localAnimation != null) && ((!localAnimation.hasStarted()) || (localAnimation.hasEnded()))) {
                localAnimation.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationEnd(Animation paramAnonymousAnimation) {
                        if (FotorFlipperBarContainer.a(FotorFlipperBarContainer.this) != null) {
                            FotorFlipperBarContainer.a(FotorFlipperBarContainer.this).b(FotorFlipperBarContainer.this);
                        }
                    }

                    public void onAnimationRepeat(Animation paramAnonymousAnimation) {
                    }

                    public void onAnimationStart(Animation paramAnonymousAnimation) {
                        if (FotorFlipperBarContainer.a(FotorFlipperBarContainer.this) != null) {
                            FotorFlipperBarContainer.a(FotorFlipperBarContainer.this).a(FotorFlipperBarContainer.this);
                        }
                    }
                });
                setDisplayedChild(0);
            }
        }
    }

    public View getFirstView() {
        return getChildAt(0);
    }

    public View getSecondView() {
        return getChildAt(1);
    }

    public void setOnFlipperBarAnimListener(a parama) {
        this.a = parama;
    }

    public static abstract interface a {
        public abstract void a(FotorFlipperBarContainer paramFotorFlipperBarContainer);

        public abstract void b(FotorFlipperBarContainer paramFotorFlipperBarContainer);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/FotorFlipperBarContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */