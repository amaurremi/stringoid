/*    */
package android.media.audiofx;

/*    */
/*    */ public class Virtualizer
/*    */ extends AudioEffect {
    /*    */   public static final int PARAM_STRENGTH_SUPPORTED = 0;
    /*    */   public static final int PARAM_STRENGTH = 1;

    /*    */
/*    */   public static class Settings {
        /*    */     public short strength;

        /*    */
/* 11 */
        public Settings() {
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public Settings(String settings) {
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public String toString() {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/* 16 */
    public Virtualizer(int priority, int audioSession) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException, RuntimeException {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public boolean getStrengthSupported() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setStrength(short strength) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public short getRoundedStrength() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void setParameterListener(OnParameterChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public Settings getProperties() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void setProperties(Settings settings) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnParameterChangeListener
/*    */ {
        /*    */
        public abstract void onParameterChange(Virtualizer paramVirtualizer, int paramInt1, int paramInt2, short paramShort);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/media/audiofx/Virtualizer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */