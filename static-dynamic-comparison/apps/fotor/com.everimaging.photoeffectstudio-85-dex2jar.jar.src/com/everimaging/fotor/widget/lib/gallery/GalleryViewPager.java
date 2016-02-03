package com.everimaging.fotor.widget.lib.gallery;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.everimaging.fotor.widget.lib.gallery.a.a;

public class GalleryViewPager
        extends ViewPager {
    PointF a;
    public a b;

    public GalleryViewPager(Context paramContext) {
        super(paramContext);
    }

    public GalleryViewPager(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    private float[] a(MotionEvent paramMotionEvent) {
        switch (paramMotionEvent.getAction() & 0xFF) {
            default:
            case 0:
                for (; ; ) {
                    return null;
                    this.a = new PointF(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
                }
        }
        paramMotionEvent = new PointF(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
        return new float[]{paramMotionEvent.x - this.a.x, paramMotionEvent.y - this.a.y};
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        boolean bool2 = false;
        if ((paramMotionEvent.getAction() & 0xFF) == 1) {
            super.onInterceptTouchEvent(paramMotionEvent);
        }
        float[] arrayOfFloat = a(paramMotionEvent);
        boolean bool1;
        if (this.b.a()) {
            bool1 = super.onInterceptTouchEvent(paramMotionEvent);
        }
        do {
            do {
                return bool1;
                if ((arrayOfFloat != null) && (this.b.w) && (arrayOfFloat[0] < 0.0F)) {
                    return super.onInterceptTouchEvent(paramMotionEvent);
                }
                if ((arrayOfFloat != null) && (this.b.u) && (arrayOfFloat[0] > 0.0F)) {
                    return super.onInterceptTouchEvent(paramMotionEvent);
                }
                bool1 = bool2;
            } while (arrayOfFloat != null);
            if (this.b.u) {
                break;
            }
            bool1 = bool2;
        } while (!this.b.w);
        return super.onInterceptTouchEvent(paramMotionEvent);
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        boolean bool2 = false;
        if ((paramMotionEvent.getAction() & 0xFF) == 1) {
            super.onTouchEvent(paramMotionEvent);
        }
        float[] arrayOfFloat = a(paramMotionEvent);
        boolean bool1;
        if (this.b.a()) {
            bool1 = super.onTouchEvent(paramMotionEvent);
        }
        do {
            do {
                return bool1;
                if ((arrayOfFloat != null) && (this.b.w) && (arrayOfFloat[0] < 0.0F)) {
                    return super.onTouchEvent(paramMotionEvent);
                }
                if ((arrayOfFloat != null) && (this.b.u) && (arrayOfFloat[0] > 0.0F)) {
                    return super.onTouchEvent(paramMotionEvent);
                }
                bool1 = bool2;
            } while (arrayOfFloat != null);
            if (this.b.u) {
                break;
            }
            bool1 = bool2;
        } while (!this.b.w);
        return super.onTouchEvent(paramMotionEvent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/widget/lib/gallery/GalleryViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */