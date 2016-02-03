package mobi.ifunny.view;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.widget.Scroller;
import mobi.ifunny.d;
import mobi.ifunny.gallery.view.f;
import mobi.ifunny.gallery.view.j;

class r
        extends j {
    private boolean b;

    private r(PinchImageView paramPinchImageView) {
    }

    public boolean a(MotionEvent paramMotionEvent) {
        if (PinchImageView.b(this.a) != null) {
            PinchImageView.b(this.a).b(this.a);
        }
        return true;
    }

    public boolean b(MotionEvent paramMotionEvent) {
        d.b(PinchImageView.b(), "onDoubleTap");
        if (PinchImageView.b(this.a) != null) {
            PinchImageView.b(this.a).c(this.a);
        }
        return true;
    }

    public boolean c(MotionEvent paramMotionEvent) {
        d.b(PinchImageView.b(), "onTripleTap");
        if (PinchImageView.b(this.a) != null) {
            PinchImageView.b(this.a).d(this.a);
        }
        return true;
    }

    public boolean onDown(MotionEvent paramMotionEvent) {
        super.onDown(paramMotionEvent);
        PinchImageView.a(this.a).forceFinished(true);
        this.b = true;
        return true;
    }

    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
        d.b(PinchImageView.b(), "onFling vx " + paramFloat1 + " vy " + paramFloat2);
        super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        PinchImageView.e(this.a);
        PinchImageView.a(this.a, paramFloat1, paramFloat2);
        return true;
    }

    public void onLongPress(MotionEvent paramMotionEvent) {
        if (PinchImageView.b(this.a) != null) {
            PinchImageView.b(this.a).e(this.a);
        }
    }

    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
        int j = 0;
        super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        if ((PinchImageView.c(this.a)) || (PinchImageView.d(this.a))) {
            return false;
        }
        if (this.b) {
            this.b = false;
            return false;
        }
        PinchImageView.e(this.a);
        float f = PinchImageView.f(this.a).y - paramFloat2;
        int i = j;
        if (f >= PinchImageView.g(this.a).top) {
            i = j;
            if (f <= PinchImageView.g(this.a).bottom) {
                i = 1;
            }
        }
        f = paramFloat2;
        if (i == 0) {
            if (!PinchImageView.h(this.a)) {
                break label174;
            }
        }
        label174:
        for (f = paramFloat2 / 3.0F; ; f = 0.0F) {
            PinchImageView.i(this.a).postTranslate(-paramFloat1, -f);
            this.a.setImageMatrix(PinchImageView.i(this.a));
            return true;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */