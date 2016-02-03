package mobi.ifunny.intro;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;

class b
        extends AnimatorListenerAdapter {
    b(IntroFragment paramIntroFragment) {
    }

    public void onAnimationEnd(Animator paramAnimator) {
        super.onAnimationEnd(paramAnimator);
        IntroFragment.a(this.a).start();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/intro/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */