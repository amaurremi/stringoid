/*    */
package android.animation;
/*    */ 
/*    */

import java.util.ArrayList;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class Animator
/*    */ implements Cloneable
/*    */ {
    /* 12 */
    public Animator() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void start() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void cancel() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void end() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract long getStartDelay();

    /*    */
    public abstract void setStartDelay(long paramLong);

    /*    */
    public abstract Animator setDuration(long paramLong);

    /*    */
    public abstract long getDuration();

    /*    */
    public abstract void setInterpolator(TimeInterpolator paramTimeInterpolator);

    /*    */
    public abstract boolean isRunning();

    /* 22 */
    public boolean isStarted() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void addListener(AnimatorListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void removeListener(AnimatorListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public ArrayList<AnimatorListener> getListeners() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void removeAllListeners() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public Animator clone() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setupStartValues() {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void setupEndValues() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void setTarget(Object target) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface AnimatorListener
/*    */ {
        /*    */
        public abstract void onAnimationStart(Animator paramAnimator);

        /*    */
/*    */
        public abstract void onAnimationEnd(Animator paramAnimator);

        /*    */
/*    */
        public abstract void onAnimationCancel(Animator paramAnimator);

        /*    */
/*    */
        public abstract void onAnimationRepeat(Animator paramAnimator);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/animation/Animator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */