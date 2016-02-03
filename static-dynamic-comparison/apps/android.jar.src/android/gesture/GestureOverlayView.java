/*    */
package android.gesture;
/*    */ 
/*    */

import android.content.Context;
/*    */ import android.graphics.Canvas;
/*    */ import android.graphics.Path;
/*    */ import android.util.AttributeSet;
/*    */ import android.view.MotionEvent;
/*    */ import android.widget.FrameLayout;
/*    */ import java.util.ArrayList;

/*    */
/*    */ public class GestureOverlayView
/*    */ extends FrameLayout
/*    */ {
    /*    */   public static final int GESTURE_STROKE_TYPE_SINGLE = 0;
    /*    */   public static final int GESTURE_STROKE_TYPE_MULTIPLE = 1;
    /*    */   public static final int ORIENTATION_HORIZONTAL = 0;
    /*    */   public static final int ORIENTATION_VERTICAL = 1;

    /*    */
/*    */
    public GestureOverlayView(Context context)
/*    */ {
/* 21 */
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public GestureOverlayView(Context context, AttributeSet attrs) {
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public GestureOverlayView(Context context, AttributeSet attrs, int defStyle) {
        super((Context) null, (AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public ArrayList<GesturePoint> getCurrentStroke() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public int getOrientation() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void setOrientation(int orientation) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void setGestureColor(int color) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setUncertainGestureColor(int color) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public int getUncertainGestureColor() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public int getGestureColor() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public float getGestureStrokeWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void setGestureStrokeWidth(float gestureStrokeWidth) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public int getGestureStrokeType() {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void setGestureStrokeType(int gestureStrokeType) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public float getGestureStrokeLengthThreshold() {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void setGestureStrokeLengthThreshold(float gestureStrokeLengthThreshold) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public float getGestureStrokeSquarenessTreshold() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void setGestureStrokeSquarenessTreshold(float gestureStrokeSquarenessTreshold) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public float getGestureStrokeAngleThreshold() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void setGestureStrokeAngleThreshold(float gestureStrokeAngleThreshold) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public boolean isEventsInterceptionEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public void setEventsInterceptionEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public boolean isFadeEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public void setFadeEnabled(boolean fadeEnabled) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public Gesture getGesture() {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public void setGesture(Gesture gesture) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public Path getGesturePath() {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public Path getGesturePath(Path path) {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public boolean isGestureVisible() {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public void setGestureVisible(boolean visible) {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public long getFadeOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public void setFadeOffset(long fadeOffset) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public void addOnGestureListener(OnGestureListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public void removeOnGestureListener(OnGestureListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public void removeAllOnGestureListeners() {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public void addOnGesturePerformedListener(OnGesturePerformedListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public void removeOnGesturePerformedListener(OnGesturePerformedListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public void removeAllOnGesturePerformedListeners() {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    public void addOnGesturingListener(OnGesturingListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    public void removeOnGesturingListener(OnGesturingListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    public void removeAllOnGesturingListeners() {
        throw new RuntimeException("Stub!");
    }

    /* 62 */
    public boolean isGesturing() {
        throw new RuntimeException("Stub!");
    }

    /* 63 */
    public void draw(Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 64 */
    public void clear(boolean animated) {
        throw new RuntimeException("Stub!");
    }

    /* 65 */
    public void cancelClearAnimation() {
        throw new RuntimeException("Stub!");
    }

    /* 66 */
    public void cancelGesture() {
        throw new RuntimeException("Stub!");
    }

    /* 67 */
    protected void onDetachedFromWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 68 */
    public boolean dispatchTouchEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnGesturePerformedListener
/*    */ {
        /*    */
        public abstract void onGesturePerformed(GestureOverlayView paramGestureOverlayView, Gesture paramGesture);
/*    */
    }

    /*    */
/*    */   public static abstract interface OnGestureListener
/*    */ {
        /*    */
        public abstract void onGestureStarted(GestureOverlayView paramGestureOverlayView, MotionEvent paramMotionEvent);

        /*    */
/*    */
        public abstract void onGesture(GestureOverlayView paramGestureOverlayView, MotionEvent paramMotionEvent);

        /*    */
/*    */
        public abstract void onGestureEnded(GestureOverlayView paramGestureOverlayView, MotionEvent paramMotionEvent);

        /*    */
/*    */
        public abstract void onGestureCancelled(GestureOverlayView paramGestureOverlayView, MotionEvent paramMotionEvent);
/*    */
    }

    /*    */
/*    */   public static abstract interface OnGesturingListener
/*    */ {
        /*    */
        public abstract void onGesturingStarted(GestureOverlayView paramGestureOverlayView);

        /*    */
/*    */
        public abstract void onGesturingEnded(GestureOverlayView paramGestureOverlayView);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/gesture/GestureOverlayView.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */