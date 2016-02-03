package mobi.ifunny.gallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

class z
        extends AnimatorListenerAdapter {
    z(x paramx) {
    }

    public void onAnimationCancel(Animator paramAnimator) {
        x.b(this.a);
    }

    public void onAnimationEnd(Animator paramAnimator) {
        x.b(this.a);
    }

    public void onAnimationStart(Animator paramAnimator) {
        x.a(this.a).getDrawable().setLevel(1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */