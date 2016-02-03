package android.support.v4.app;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class v
        implements Animation.AnimationListener {
    v(s params, Fragment paramFragment) {
    }

    public void onAnimationEnd(Animation paramAnimation) {
        if (this.a.mAnimatingAway != null) {
            this.a.mAnimatingAway = null;
            this.b.a(this.a, this.a.mStateAfterAnimating, 0, 0, false);
        }
    }

    public void onAnimationRepeat(Animation paramAnimation) {
    }

    public void onAnimationStart(Animation paramAnimation) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */