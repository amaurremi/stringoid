/*   */
package android.media;
/*   */

import java.util.UUID;

/*   */
/* 4 */ public final class MediaCrypto {
    public MediaCrypto(UUID uuid, byte[] initData) throws MediaCryptoException {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public static final boolean isCryptoSchemeSupported(UUID uuid) {
        throw new RuntimeException("Stub!");
    }

    /*   */
    public final native boolean requiresSecureDecoderComponent(String paramString);

    /* 7 */
    protected void finalize() {
        throw new RuntimeException("Stub!");
    }

    /*   */
/*   */
    public final native void release();
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/media/MediaCrypto.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */