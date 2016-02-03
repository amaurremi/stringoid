package android.support.v4.view;

import android.view.MotionEvent;

class at
        implements av {
    public int a(MotionEvent paramMotionEvent) {
        return 1;
    }

    public int a(MotionEvent paramMotionEvent, int paramInt) {
        if (paramInt == 0) {
            return 0;
        }
        return -1;
    }

    public int b(MotionEvent paramMotionEvent, int paramInt) {
        if (paramInt == 0) {
            return 0;
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float c(MotionEvent paramMotionEvent, int paramInt) {
        if (paramInt == 0) {
            return paramMotionEvent.getX();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float d(MotionEvent paramMotionEvent, int paramInt) {
        if (paramInt == 0) {
            return paramMotionEvent.getY();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */