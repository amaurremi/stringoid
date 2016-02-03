/*   */
package android.drm;

/*   */
/*   */ public class DrmConvertedStatus {
    public static final int STATUS_OK = 1;
    public static final int STATUS_INPUTDATA_ERROR = 2;

    /* 4 */
    public DrmConvertedStatus(int statusCode, byte[] convertedData, int offset) {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */ 
/*   */   public static final int STATUS_ERROR = 3;
    /*   */   public final int statusCode;
    /* 9 */   public final byte[] convertedData = null;
    /*   */   public final int offset;
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/drm/DrmConvertedStatus.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */