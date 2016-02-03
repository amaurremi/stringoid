package mobi.ifunny.comments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class k
        extends AnimatorListenerAdapter {
    k(j paramj, View paramView) {
    }

    public void onAnimationCancel(Animator paramAnimator) {
        super.onAnimationCancel(paramAnimator);
        this.a.setVisibility(8);
        this.b.c = null;
    }

    public void onAnimationEnd(Animator paramAnimator) {
        super.onAnimationEnd(paramAnimator);
        this.a.setVisibility(8);
        this.b.c = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */