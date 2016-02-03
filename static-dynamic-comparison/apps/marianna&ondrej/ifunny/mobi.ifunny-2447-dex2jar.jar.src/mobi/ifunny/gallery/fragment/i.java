package mobi.ifunny.gallery.fragment;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import mobi.ifunny.comments.ah;
import mobi.ifunny.gallery.view.GalleryItemFrameLayout;

class i
        implements Animator.AnimatorListener {
    i(f paramf) {
    }

    public void onAnimationCancel(Animator paramAnimator) {
    }

    public void onAnimationEnd(Animator paramAnimator) {
        f.e(this.a).setVisibility(0);
        f.c(this.a).setVisibility(8);
        f.a(this.a).b();
        f.a(this.a, f.c(this.a));
        f.a(this.a, l.a);
        f.f(this.a).setUserVisibleHint(this.a.getUserVisibleHint());
        f.a(this.a, null);
    }

    public void onAnimationRepeat(Animator paramAnimator) {
    }

    public void onAnimationStart(Animator paramAnimator) {
        f.a(this.a).setUserVisibleHint(false);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */