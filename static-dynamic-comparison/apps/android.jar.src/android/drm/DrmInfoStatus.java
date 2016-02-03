/*   */
package android.drm;

/*   */
/*   */ public class DrmInfoStatus {
    /* 4 */
    public DrmInfoStatus(int statusCode, int infoType, ProcessedData data, String mimeType) {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */   public static final int STATUS_OK = 1;
    /*   */   public static final int STATUS_ERROR = 2;
    /*   */   public final int statusCode;
    /*   */   public final int infoType;
    /*   */   public final String mimeType;
    /*   */   public final ProcessedData data;
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/drm/DrmInfoStatus.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */