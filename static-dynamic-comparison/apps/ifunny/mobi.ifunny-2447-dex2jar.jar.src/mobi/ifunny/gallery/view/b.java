package mobi.ifunny.gallery.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import mobi.ifunny.d;

class b
        extends GestureDetector.SimpleOnGestureListener {
    private b(GalleryItemFrameLayout paramGalleryItemFrameLayout) {
    }

    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
        d.b(GalleryItemFrameLayout.a(), "fling " + paramFloat1 + " " + paramFloat2);
        if (!GalleryItemFrameLayout.c(this.a)) {
        }
        do {
            do {
                do {
                    return false;
                }
                while (((paramFloat2 < 0.0F) && (GalleryItemFrameLayout.b(this.a) != 1)) || ((paramFloat2 >= 0.0F) && (GalleryItemFrameLayout.b(this.a) != 2)) || (Math.abs(paramFloat2) <= 1500.0F) || (GalleryItemFrameLayout.a(this.a, this.a, false, paramFloat2)));
                if (paramFloat2 <= 0.0F) {
                    break;
                }
                d.b(GalleryItemFrameLayout.a(), "onSwipeDown");
            } while (GalleryItemFrameLayout.d(this.a) == null);
            return GalleryItemFrameLayout.d(this.a).a(paramFloat2);
            d.b(GalleryItemFrameLayout.a(), "onSwipeUp");
        } while (GalleryItemFrameLayout.d(this.a) == null);
        return GalleryItemFrameLayout.d(this.a).b(paramFloat2);
    }

    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
        GalleryItemFrameLayout localGalleryItemFrameLayout;
        if ((GalleryItemFrameLayout.b(this.a) == 0) && (Math.abs(paramFloat1) < Math.abs(paramFloat2))) {
            localGalleryItemFrameLayout = this.a;
            if (paramFloat2 < 0.0F) {
                break label57;
            }
        }
        label57:
        for (int i = 1; ; i = 2) {
            GalleryItemFrameLayout.a(localGalleryItemFrameLayout, i);
            return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        }
    }

    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent) {
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */