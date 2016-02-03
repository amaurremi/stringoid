package mobi.ifunny.view;

import android.view.MotionEvent;
import mobi.ifunny.gallery.view.f;
import mobi.ifunny.gallery.view.j;

class n
        extends j {
    private n(ImageViewEx paramImageViewEx) {
    }

    public boolean a(MotionEvent paramMotionEvent) {
        if (ImageViewEx.a(this.a) != null) {
            ImageViewEx.a(this.a).b(this.a);
            return true;
        }
        return false;
    }

    public boolean b(MotionEvent paramMotionEvent) {
        if (ImageViewEx.a(this.a) != null) {
            ImageViewEx.a(this.a).c(this.a);
            return true;
        }
        return false;
    }

    public boolean c(MotionEvent paramMotionEvent) {
        if (ImageViewEx.a(this.a) != null) {
            ImageViewEx.a(this.a).d(this.a);
            return true;
        }
        return false;
    }

    public boolean onDown(MotionEvent paramMotionEvent) {
        return ImageViewEx.a(this.a) != null;
    }

    public void onLongPress(MotionEvent paramMotionEvent) {
        if (ImageViewEx.a(this.a) != null) {
            ImageViewEx.a(this.a).e(this.a);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */