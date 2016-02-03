package uk.co.a.a.a.a;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class b
        implements Animation.AnimationListener {
    b(a parama) {
    }

    public void onAnimationEnd(Animation paramAnimation) {
        if (paramAnimation == a.a(this.a)) {
            paramAnimation = this.a.g();
            if (paramAnimation != null) {
                paramAnimation.setVisibility(8);
            }
            this.a.e();
        }
    }

    public void onAnimationRepeat(Animation paramAnimation) {
    }

    public void onAnimationStart(Animation paramAnimation) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/uk/co/a/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */