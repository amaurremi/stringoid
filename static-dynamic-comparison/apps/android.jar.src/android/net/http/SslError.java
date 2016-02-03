/*    */
package android.net.http;
/*    */

import java.security.cert.X509Certificate;

/*    */
/*    */ public class SslError {
    @Deprecated
/*  5 */ public SslError(int error, SslCertificate certificate) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/*  7 */ public SslError(int error, X509Certificate certificate) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public SslError(int error, SslCertificate certificate, String url) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public SslError(int error, X509Certificate certificate, String url) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public SslCertificate getCertificate() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public String getUrl() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public boolean addError(int error) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public boolean hasError(int error) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public int getPrimaryError() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int SSL_NOTYETVALID = 0;
    /*    */   public static final int SSL_EXPIRED = 1;
    /*    */   public static final int SSL_IDMISMATCH = 2;
    /*    */   public static final int SSL_UNTRUSTED = 3;
    /*    */   public static final int SSL_DATE_INVALID = 4;
    /*    */   public static final int SSL_INVALID = 5;
    /*    */
    @Deprecated
/*    */ public static final int SSL_MAX_ERROR = 6;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/http/SslError.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */