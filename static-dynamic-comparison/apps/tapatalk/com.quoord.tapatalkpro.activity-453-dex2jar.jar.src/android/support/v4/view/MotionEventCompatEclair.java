package android.support.v4.view;

import android.view.MotionEvent;

class MotionEventCompatEclair {
    public static int findPointerIndex(MotionEvent paramMotionEvent, int paramInt) {
        return paramMotionEvent.findPointerIndex(paramInt);
    }

    public static int getPointerCount(MotionEvent paramMotionEvent) {
        return paramMotionEvent.getPointerCount();
    }

    public static int getPointerId(MotionEvent paramMotionEvent, int paramInt) {
        return paramMotionEvent.getPointerId(paramInt);
    }

    public static float getX(MotionEvent paramMotionEvent, int paramInt) {
        return paramMotionEvent.getX(paramInt);
    }

    public static float getY(MotionEvent paramMotionEvent, int paramInt) {
        return paramMotionEvent.getY(paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/android/support/v4/view/MotionEventCompatEclair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */