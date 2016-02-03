/*   */
package android.security;
/*   */

import android.content.Context;

/*   */
/* 4 */ public final class KeyChain {
    public KeyChain() {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public static android.content.Intent createInstallIntent() {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public static void choosePrivateKeyAlias(android.app.Activity activity, KeyChainAliasCallback response, String[] keyTypes, java.security.Principal[] issuers, String host, int port, String alias) {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public static java.security.PrivateKey getPrivateKey(Context context, String alias) throws KeyChainException, InterruptedException {
        throw new RuntimeException("Stub!");
    }

    /* 8 */
    public static java.security.cert.X509Certificate[] getCertificateChain(Context context, String alias) throws KeyChainException, InterruptedException {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */   public static final String EXTRA_NAME = "name";
    /*   */   public static final String EXTRA_CERTIFICATE = "CERT";
    /*   */   public static final String EXTRA_PKCS12 = "PKCS12";
    /*   */   public static final String ACTION_STORAGE_CHANGED = "android.security.STORAGE_CHANGED";
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/security/KeyChain.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */