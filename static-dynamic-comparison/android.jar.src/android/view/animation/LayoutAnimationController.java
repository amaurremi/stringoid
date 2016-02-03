/*    */
package android.view.animation;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */ public class LayoutAnimationController {
    public static class AnimationParameters {
        public int count;

        /*  6 */
        public AnimationParameters() {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public int index;
    }

    /*    */
/* 10 */
    public LayoutAnimationController(Context context, android.util.AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public LayoutAnimationController(Animation animation) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public LayoutAnimationController(Animation animation, float delay) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int getOrder() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void setOrder(int order) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void setAnimation(Context context, int resourceID) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void setAnimation(Animation animation) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public Animation getAnimation() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setInterpolator(Context context, int resourceID) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setInterpolator(Interpolator interpolator) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public Interpolator getInterpolator() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public float getDelay() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void setDelay(float delay) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public boolean willOverlap() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void start() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public final Animation getAnimationForView(android.view.View view) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public boolean isDone() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    protected long getDelayForView(android.view.View view) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    protected int getTransformedIndex(AnimationParameters params) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int ORDER_NORMAL = 0;
    /*    */   public static final int ORDER_REVERSE = 1;
    /*    */   public static final int ORDER_RANDOM = 2;
    /*    */   protected Animation mAnimation;
    /*    */   protected java.util.Random mRandomizer;
    /*    */   protected Interpolator mInterpolator;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/view/animation/LayoutAnimationController.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */