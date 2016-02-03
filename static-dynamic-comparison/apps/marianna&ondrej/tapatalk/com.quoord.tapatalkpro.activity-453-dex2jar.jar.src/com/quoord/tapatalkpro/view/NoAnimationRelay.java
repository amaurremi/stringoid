package com.quoord.tapatalkpro.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.widget.RelativeLayout;

public class NoAnimationRelay
        extends RelativeLayout {
    private boolean mIsAnimatable = false;

    public NoAnimationRelay(Context paramContext) {
        super(paramContext);
    }

    public NoAnimationRelay(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public NoAnimationRelay(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    public void setAnimation(Animation paramAnimation) {
        if (this.mIsAnimatable) {
            super.setAnimation(paramAnimation);
        }
    }

    public void setLayoutAnimation(LayoutAnimationController paramLayoutAnimationController) {
        if (this.mIsAnimatable) {
            super.setLayoutAnimation(paramLayoutAnimationController);
        }
    }

    public void startAnimation(Animation paramAnimation) {
        if (this.mIsAnimatable) {
            super.startAnimation(paramAnimation);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/view/NoAnimationRelay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */