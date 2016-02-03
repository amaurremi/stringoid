/*    */
package android.graphics;

/*    */
/*    */ public class Interpolator
/*    */ {
    /*    */   public static enum Result {
        /*  6 */     FREEZE_END,
        /*  7 */     FREEZE_START,
        /*  8 */     NORMAL;

        /*    */
        private Result() {
        }
    }

    /* 10 */
    public Interpolator(int valueCount) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public Interpolator(int valueCount, int frameCount) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void reset(int valueCount) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void reset(int valueCount, int frameCount) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public final int getKeyFrameCount() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public final int getValueCount() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void setKeyFrame(int index, int msec, float[] values) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void setKeyFrame(int index, int msec, float[] values, float[] blend) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setRepeatMirror(float repeatCount, boolean mirror) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public Result timeToValues(float[] values) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public Result timeToValues(int msec, float[] values) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/Interpolator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */