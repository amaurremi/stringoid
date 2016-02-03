/*    */
package android.media.audiofx;

/*    */
/*    */ 
/*    */ public class Visualizer {
    /*    */   public static final int STATE_UNINITIALIZED = 0;
    /*    */   public static final int STATE_INITIALIZED = 1;
    /*    */   public static final int STATE_ENABLED = 2;

    /*    */
/*  9 */
    public Visualizer(int audioSession) throws UnsupportedOperationException, RuntimeException {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void release() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    protected void finalize() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int setEnabled(boolean enabled) throws IllegalStateException {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public boolean getEnabled() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public static native int[] getCaptureSizeRange();

    /*    */
    public static native int getMaxCaptureRate();

    /* 16 */
    public int setCaptureSize(int size) throws IllegalStateException {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public int getCaptureSize() throws IllegalStateException {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public int setScalingMode(int mode) throws IllegalStateException {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public int getScalingMode() throws IllegalStateException {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public int getSamplingRate() throws IllegalStateException {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public int getWaveForm(byte[] waveform) throws IllegalStateException {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public int getFft(byte[] fft) throws IllegalStateException {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public int setDataCaptureListener(OnDataCaptureListener listener, int rate, boolean waveform, boolean fft) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int SCALING_MODE_NORMALIZED = 0;
    /*    */   public static final int SCALING_MODE_AS_PLAYED = 1;
    /*    */   public static final int SUCCESS = 0;
    /*    */   public static final int ERROR = -1;
    /*    */   public static final int ALREADY_EXISTS = -2;
    /*    */   public static final int ERROR_NO_INIT = -3;
    /*    */   public static final int ERROR_BAD_VALUE = -4;
    /*    */   public static final int ERROR_INVALID_OPERATION = -5;
    /*    */   public static final int ERROR_NO_MEMORY = -6;
    /*    */   public static final int ERROR_DEAD_OBJECT = -7;

    /*    */   public static abstract interface OnDataCaptureListener
/*    */ {
        /*    */
        public abstract void onWaveFormDataCapture(Visualizer paramVisualizer, byte[] paramArrayOfByte, int paramInt);

        /*    */
/*    */
        public abstract void onFftDataCapture(Visualizer paramVisualizer, byte[] paramArrayOfByte, int paramInt);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/media/audiofx/Visualizer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */