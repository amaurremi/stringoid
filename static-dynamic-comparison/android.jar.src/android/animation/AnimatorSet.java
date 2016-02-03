/*    */
package android.animation;
/*    */ 
/*    */

import java.util.Collection;

/*    */
/*    */ public final class AnimatorSet extends Animator {
    /*    */   public class Builder {
        /*  7 */     Builder() {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public Builder with(Animator anim) {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public Builder before(Animator anim) {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public Builder after(Animator anim) {
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public Builder after(long delay) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 13 */
    public AnimatorSet() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void playTogether(Animator... items) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void playTogether(Collection<Animator> items) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void playSequentially(Animator... items) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void playSequentially(java.util.List<Animator> items) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public java.util.ArrayList<Animator> getChildAnimations() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setTarget(Object target) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setInterpolator(TimeInterpolator interpolator) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public Builder play(Animator anim) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 23 */
    public void cancel() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void end() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public boolean isRunning() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public boolean isStarted() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public long getStartDelay() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setStartDelay(long startDelay) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public long getDuration() {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public AnimatorSet setDuration(long duration) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void setupStartValues() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void setupEndValues() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 34 */
    public void start() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public AnimatorSet clone() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/animation/AnimatorSet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */