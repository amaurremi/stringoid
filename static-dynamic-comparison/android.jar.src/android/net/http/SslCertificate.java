/*    */
package android.net.http;
/*    */ 
/*    */

import java.util.Date;

/*    */
/*    */ public class SslCertificate {
    /*  6 */   public class DName {
        public DName(String dName) {
            throw new RuntimeException("Stub!");
        }

        /*  7 */
        public String getDName() {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public String getCName() {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public String getOName() {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public String getUName() {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/*    */
    @Deprecated
/* 13 */ public SslCertificate(String issuedTo, String issuedBy, String validNotBefore, String validNotAfter) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 15 */ public SslCertificate(String issuedTo, String issuedBy, Date validNotBefore, Date validNotAfter) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public SslCertificate(java.security.cert.X509Certificate certificate) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public static android.os.Bundle saveState(SslCertificate certificate) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public static SslCertificate restoreState(android.os.Bundle bundle) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public Date getValidNotBeforeDate() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 21 */ public String getValidNotBefore() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public Date getValidNotAfterDate() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 24 */ public String getValidNotAfter() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public DName getIssuedTo() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public DName getIssuedBy() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/http/SslCertificate.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */