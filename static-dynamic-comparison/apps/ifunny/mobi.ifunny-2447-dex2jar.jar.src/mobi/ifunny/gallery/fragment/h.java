package mobi.ifunny.gallery.fragment;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import mobi.ifunny.gallery.view.GalleryItemFrameLayout;

class h
        implements Animator.AnimatorListener {
    h(f paramf) {
    }

    public void onAnimationCancel(Animator paramAnimator) {
    }

    public void onAnimationEnd(Animator paramAnimator) {
        f.b(this.a).setVisibility(8);
        f.c(this.a).setVisibility(0);
        f.a(this.a).setUserVisibleHint(this.a.getUserVisibleHint());
        f.d(this.a).setUserVisibleHint(false);
        f.a(this.a, f.b(this.a));
        f.a(this.a, l.a);
        f.a(this.a, null);
    }

    public void onAnimationRepeat(Animator paramAnimator) {
    }

    public void onAnimationStart(Animator paramAnimator) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */