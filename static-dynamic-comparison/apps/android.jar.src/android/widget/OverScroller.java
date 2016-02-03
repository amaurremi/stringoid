/*    */
package android.widget;
/*    */

import android.content.Context;

/*    */
/*  4 */ public class OverScroller {
    public OverScroller(Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public OverScroller(Context context, android.view.animation.Interpolator interpolator) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public OverScroller(Context context, android.view.animation.Interpolator interpolator, float bounceCoefficientX, float bounceCoefficientY) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public OverScroller(Context context, android.view.animation.Interpolator interpolator, float bounceCoefficientX, float bounceCoefficientY, boolean flywheel) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public final void setFriction(float friction) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public final boolean isFinished() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public final void forceFinished(boolean finished) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public final int getCurrX() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public final int getCurrY() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public float getCurrVelocity() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public final int getStartX() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public final int getStartY() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public final int getFinalX() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public final int getFinalY() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public boolean computeScrollOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void startScroll(int startX, int startY, int dx, int dy) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public boolean springBack(int startX, int startY, int minX, int maxX, int minY, int maxY) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY, int overX, int overY) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void notifyHorizontalEdgeReached(int startX, int finalX, int overX) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void notifyVerticalEdgeReached(int startY, int finalY, int overY) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public boolean isOverScrolled() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void abortAnimation() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/OverScroller.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */