package uk.co.a.a.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class b
        extends AnimatorListenerAdapter {
    b(a parama) {
    }

    public void onAnimationEnd(Animator paramAnimator) {
        paramAnimator = this.a.g();
        if (paramAnimator != null) {
            paramAnimator.setVisibility(8);
        }
        this.a.e();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/uk/co/a/a/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */