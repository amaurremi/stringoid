package mobi.ifunny.gallery;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;

class l
        implements Animator.AnimatorListener {
    l(GalleryFragment paramGalleryFragment) {
    }

    private void a() {
        View localView;
        if (this.a.getActivity() != null) {
            GalleryFragment.a(this.a, GalleryFragment.b(this.a));
            localView = this.a.bottomPanel;
            if (!GalleryFragment.b(this.a)) {
                break label61;
            }
        }
        label61:
        for (int i = 4; ; i = 0) {
            localView.setVisibility(i);
            this.a.bottomPanel.setAlpha(1.0F);
            return;
        }
    }

    public void onAnimationCancel(Animator paramAnimator) {
        a();
    }

    public void onAnimationEnd(Animator paramAnimator) {
        a();
    }

    public void onAnimationRepeat(Animator paramAnimator) {
    }

    public void onAnimationStart(Animator paramAnimator) {
        this.a.bottomPanel.setVisibility(0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */