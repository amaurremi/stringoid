/*    */
package android.animation;

/*    */
/*    */ public class ValueAnimator
/*    */ extends Animator {
    /*    */   public static final int RESTART = 1;
    /*    */   public static final int REVERSE = 2;
    /*    */   public static final int INFINITE = -1;

    /*    */
/*  9 */
    public ValueAnimator() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public static ValueAnimator ofInt(int... values) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public static ValueAnimator ofFloat(float... values) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public static ValueAnimator ofPropertyValuesHolder(PropertyValuesHolder... values) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public static ValueAnimator ofObject(TypeEvaluator evaluator, Object... values) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void setIntValues(int... values) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void setFloatValues(float... values) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void setObjectValues(Object... values) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void setValues(PropertyValuesHolder... values) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public PropertyValuesHolder[] getValues() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public ValueAnimator setDuration(long duration) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public long getDuration() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void setCurrentPlayTime(long playTime) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public long getCurrentPlayTime() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public long getStartDelay() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void setStartDelay(long startDelay) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public static long getFrameDelay() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public static void setFrameDelay(long frameDelay) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public Object getAnimatedValue() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public Object getAnimatedValue(String propertyName) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public void setRepeatCount(int value) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public int getRepeatCount() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void setRepeatMode(int value) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public int getRepeatMode() {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void addUpdateListener(AnimatorUpdateListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void removeAllUpdateListeners() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void removeUpdateListener(AnimatorUpdateListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void setInterpolator(TimeInterpolator value) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public TimeInterpolator getInterpolator() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void setEvaluator(TypeEvaluator value) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public void start() {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void cancel() {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public void end() {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public boolean isRunning() {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public boolean isStarted() {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public void reverse() {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public float getAnimatedFraction() {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public ValueAnimator clone() {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface AnimatorUpdateListener
/*    */ {
        /*    */
        public abstract void onAnimationUpdate(ValueAnimator paramValueAnimator);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/animation/ValueAnimator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */