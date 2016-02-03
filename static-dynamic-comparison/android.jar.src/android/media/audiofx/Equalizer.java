/*    */
package android.media.audiofx;

/*    */
/*    */ public class Equalizer extends AudioEffect {
    public static final int PARAM_NUM_BANDS = 0;
    /*    */   public static final int PARAM_LEVEL_RANGE = 1;
    /*    */   public static final int PARAM_BAND_LEVEL = 2;
    /*    */   public static final int PARAM_CENTER_FREQ = 3;
    /*    */   public static final int PARAM_BAND_FREQ_RANGE = 4;

    /*    */
/*    */   public static class Settings {
        public short curPreset;

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
/*    */     public short numBands;
        /* 16 */     public short[] bandLevels = null;
    }

    /*    */
/* 18 */
    public Equalizer(int priority, int audioSession) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException, RuntimeException {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public short getNumberOfBands() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public short[] getBandLevelRange() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void setBandLevel(short band, short level) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public short getBandLevel(short band) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public int getCenterFreq(short band) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public int[] getBandFreqRange(short band) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public short getBand(int frequency) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public short getCurrentPreset() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public void usePreset(short preset) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public short getNumberOfPresets() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public String getPresetName(short preset) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void setParameterListener(OnParameterChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public Settings getProperties() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void setProperties(Settings settings) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int PARAM_GET_BAND = 5;
    /*    */   public static final int PARAM_CURRENT_PRESET = 6;
    /*    */   public static final int PARAM_GET_NUM_OF_PRESETS = 7;
    /*    */   public static final int PARAM_GET_PRESET_NAME = 8;
    /*    */   public static final int PARAM_STRING_SIZE_MAX = 32;

    /*    */   public static abstract interface OnParameterChangeListener
/*    */ {
        /*    */
        public abstract void onParameterChange(Equalizer paramEqualizer, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/media/audiofx/Equalizer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */