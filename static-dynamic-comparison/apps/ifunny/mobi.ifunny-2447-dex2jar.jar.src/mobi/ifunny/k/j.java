package mobi.ifunny.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;

class j
        extends AnimatorListenerAdapter {
    j(i parami, ImageView paramImageView, l paraml) {
    }

    public void onAnimationCancel(Animator paramAnimator) {
        this.a.setAlpha(1.0F);
        if (!this.c.c()) {
            this.c.a(this.b, false);
            this.b.a(null);
        }
    }

    public void onAnimationEnd(Animator paramAnimator) {
        if (!this.c.c()) {
            this.c.a(this.b, false);
            this.b.a(null);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/k/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */