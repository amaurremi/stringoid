/*    */
package android.view;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ScaleGestureDetector
/*    */ {
    /*    */   public static class SimpleOnScaleGestureListener
/*    */ implements ScaleGestureDetector.OnScaleGestureListener
/*    */ {
        /* 13 */
        public SimpleOnScaleGestureListener() {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public boolean onScale(ScaleGestureDetector detector) {
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            throw new RuntimeException("Stub!");
        }

        /* 16 */
        public void onScaleEnd(ScaleGestureDetector detector) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 18 */
    public ScaleGestureDetector(Context context, OnScaleGestureListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public boolean onTouchEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public boolean isInProgress() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public float getFocusX() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public float getFocusY() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public float getCurrentSpan() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public float getCurrentSpanX() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public float getCurrentSpanY() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public float getPreviousSpan() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public float getPreviousSpanX() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public float getPreviousSpanY() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public float getScaleFactor() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public long getTimeDelta() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public long getEventTime() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnScaleGestureListener
/*    */ {
        /*    */
        public abstract boolean onScale(ScaleGestureDetector paramScaleGestureDetector);

        /*    */
/*    */
        public abstract boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector);

        /*    */
/*    */
        public abstract void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/ScaleGestureDetector.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */