/*   */
package android.media;

/*   */
/*   */ public class AudioFormat {
    /* 4 */
    public AudioFormat() {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */   public static final int ENCODING_INVALID = 0;
    /*   */   public static final int ENCODING_DEFAULT = 1;
    /*   */   public static final int ENCODING_PCM_16BIT = 2;
    /*   */   public static final int ENCODING_PCM_8BIT = 3;
    /*   */
    @Deprecated
/*   */ public static final int CHANNEL_CONFIGURATION_INVALID = 0;
    /*   */
    @Deprecated
/*   */ public static final int CHANNEL_CONFIGURATION_DEFAULT = 1;
    /*   */
    @Deprecated
/*   */ public static final int CHANNEL_CONFIGURATION_MONO = 2;
    /*   */
    @Deprecated
/*   */ public static final int CHANNEL_CONFIGURATION_STEREO = 3;
    /*   */   public static final int CHANNEL_INVALID = 0;
    /*   */   public static final int CHANNEL_OUT_DEFAULT = 1;
    /*   */   public static final int CHANNEL_OUT_FRONT_LEFT = 4;
    /*   */   public static final int CHANNEL_OUT_FRONT_RIGHT = 8;
    /*   */   public static final int CHANNEL_OUT_FRONT_CENTER = 16;
    /*   */   public static final int CHANNEL_OUT_LOW_FREQUENCY = 32;
    /*   */   public static final int CHANNEL_OUT_BACK_LEFT = 64;
    /*   */   public static final int CHANNEL_OUT_BACK_RIGHT = 128;
    /*   */   public static final int CHANNEL_OUT_FRONT_LEFT_OF_CENTER = 256;
    /*   */   public static final int CHANNEL_OUT_FRONT_RIGHT_OF_CENTER = 512;
    /*   */   public static final int CHANNEL_OUT_BACK_CENTER = 1024;
    /*   */   public static final int CHANNEL_OUT_MONO = 4;
    /*   */   public static final int CHANNEL_OUT_STEREO = 12;
    /*   */   public static final int CHANNEL_OUT_QUAD = 204;
    /*   */   public static final int CHANNEL_OUT_SURROUND = 1052;
    /*   */   public static final int CHANNEL_OUT_5POINT1 = 252;
    /*   */   public static final int CHANNEL_OUT_7POINT1 = 1020;
    /*   */   public static final int CHANNEL_IN_DEFAULT = 1;
    /*   */   public static final int CHANNEL_IN_LEFT = 4;
    /*   */   public static final int CHANNEL_IN_RIGHT = 8;
    /*   */   public static final int CHANNEL_IN_FRONT = 16;
    /*   */   public static final int CHANNEL_IN_BACK = 32;
    /*   */   public static final int CHANNEL_IN_LEFT_PROCESSED = 64;
    /*   */   public static final int CHANNEL_IN_RIGHT_PROCESSED = 128;
    /*   */   public static final int CHANNEL_IN_FRONT_PROCESSED = 256;
    /*   */   public static final int CHANNEL_IN_BACK_PROCESSED = 512;
    /*   */   public static final int CHANNEL_IN_PRESSURE = 1024;
    /*   */   public static final int CHANNEL_IN_X_AXIS = 2048;
    /*   */   public static final int CHANNEL_IN_Y_AXIS = 4096;
    /*   */   public static final int CHANNEL_IN_Z_AXIS = 8192;
    /*   */   public static final int CHANNEL_IN_VOICE_UPLINK = 16384;
    /*   */   public static final int CHANNEL_IN_VOICE_DNLINK = 32768;
    /*   */   public static final int CHANNEL_IN_MONO = 16;
    /*   */   public static final int CHANNEL_IN_STEREO = 12;
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/media/AudioFormat.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */