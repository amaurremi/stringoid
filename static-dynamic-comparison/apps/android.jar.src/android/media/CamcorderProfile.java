/*   */
package android.media;

/*   */
/*   */ public class CamcorderProfile {
    /* 4 */   CamcorderProfile() {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public static CamcorderProfile get(int quality) {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public static CamcorderProfile get(int cameraId, int quality) {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public static boolean hasProfile(int quality) {
        throw new RuntimeException("Stub!");
    }

    /* 8 */
    public static boolean hasProfile(int cameraId, int quality) {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */   public static final int QUALITY_LOW = 0;
    /*   */   public static final int QUALITY_HIGH = 1;
    /*   */   public static final int QUALITY_QCIF = 2;
    /*   */   public static final int QUALITY_CIF = 3;
    /*   */   public static final int QUALITY_480P = 4;
    /*   */   public static final int QUALITY_720P = 5;
    /*   */   public static final int QUALITY_1080P = 6;
    /*   */   public static final int QUALITY_QVGA = 7;
    /*   */   public static final int QUALITY_TIME_LAPSE_LOW = 1000;
    /*   */   public static final int QUALITY_TIME_LAPSE_HIGH = 1001;
    /*   */   public static final int QUALITY_TIME_LAPSE_QCIF = 1002;
    /*   */   public static final int QUALITY_TIME_LAPSE_CIF = 1003;
    /*   */   public static final int QUALITY_TIME_LAPSE_480P = 1004;
    /*   */   public static final int QUALITY_TIME_LAPSE_720P = 1005;
    /*   */   public static final int QUALITY_TIME_LAPSE_1080P = 1006;
    /*   */   public static final int QUALITY_TIME_LAPSE_QVGA = 1007;
    /*   */   public int duration;
    /*   */   public int quality;
    /*   */   public int fileFormat;
    /*   */   public int videoCodec;
    /*   */   public int videoBitRate;
    /*   */   public int videoFrameRate;
    /*   */   public int videoFrameWidth;
    /*   */   public int videoFrameHeight;
    /*   */   public int audioCodec;
    /*   */   public int audioBitRate;
    /*   */   public int audioSampleRate;
    /*   */   public int audioChannels;
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/media/CamcorderProfile.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */