/*    */
package android.media.audiofx;

/*    */
/*    */ public class EnvironmentalReverb extends AudioEffect {
    public static final int PARAM_ROOM_LEVEL = 0;
    /*    */   public static final int PARAM_ROOM_HF_LEVEL = 1;
    /*    */   public static final int PARAM_DECAY_TIME = 2;
    /*    */   public static final int PARAM_DECAY_HF_RATIO = 3;
    /*    */   public static final int PARAM_REFLECTIONS_LEVEL = 4;

    /*    */
/*    */   public static class Settings {
        public short roomLevel;
        /*    */     public short roomHFLevel;
        public int decayTime;
        public short decayHFRatio;
        public short reflectionsLevel;

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
/*    */ 
/*    */     public int reflectionsDelay;
        /*    */
/*    */     public short reverbLevel;
        /*    */     public int reverbDelay;
        /*    */     public short diffusion;
        /*    */     public short density;
/*    */
    }

    /*    */
/* 25 */
    public EnvironmentalReverb(int priority, int audioSession)
/* 25 */     throws IllegalArgumentException, UnsupportedOperationException, RuntimeException {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void setRoomLevel(short room) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public short getRoomLevel() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setRoomHFLevel(short roomHF) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public short getRoomHFLevel() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void setDecayTime(int decayTime) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public int getDecayTime() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public void setDecayHFRatio(short decayHFRatio) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public short getDecayHFRatio() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void setReflectionsLevel(short reflectionsLevel) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public short getReflectionsLevel() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void setReflectionsDelay(int reflectionsDelay) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public int getReflectionsDelay() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public void setReverbLevel(short reverbLevel) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public short getReverbLevel() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public void setReverbDelay(int reverbDelay) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public int getReverbDelay() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public void setDiffusion(short diffusion) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public short getDiffusion() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public void setDensity(short density) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public short getDensity() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public void setParameterListener(OnParameterChangeListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public Settings getProperties() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public void setProperties(Settings settings) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int PARAM_REFLECTIONS_DELAY = 5;
    /*    */   public static final int PARAM_REVERB_LEVEL = 6;
    /*    */   public static final int PARAM_REVERB_DELAY = 7;
    /*    */   public static final int PARAM_DIFFUSION = 8;
    /*    */   public static final int PARAM_DENSITY = 9;

    /*    */   public static abstract interface OnParameterChangeListener
/*    */ {
        /*    */
        public abstract void onParameterChange(EnvironmentalReverb paramEnvironmentalReverb, int paramInt1, int paramInt2, int paramInt3);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/media/audiofx/EnvironmentalReverb.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */