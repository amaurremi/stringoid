package mobi.ifunny.intro;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;

class a
        extends AnimatorListenerAdapter {
    a(IntroFragment paramIntroFragment) {
    }

    public void onAnimationEnd(Animator paramAnimator) {
        super.onAnimationEnd(paramAnimator);
        this.a.introSmile.setImageLevel(1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/intro/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */