/*    */
package android.webkit;
/*    */ 
/*    */

import java.io.InputStream;

/*    */
/*    */
@Deprecated
/*    */ public final class CacheManager {
    /*    */
    @Deprecated
/*  8 */ public static class CacheResult {
        public CacheResult() {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public int getHttpStatusCode() {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public long getContentLength() {
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public String getLocalPath() {
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public long getExpires() {
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public String getExpiresString() {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public String getLastModified() {
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public String getETag() {
            throw new RuntimeException("Stub!");
        }

        /* 16 */
        public String getMimeType() {
            throw new RuntimeException("Stub!");
        }

        /* 17 */
        public String getLocation() {
            throw new RuntimeException("Stub!");
        }

        /* 18 */
        public String getEncoding() {
            throw new RuntimeException("Stub!");
        }

        /* 19 */
        public String getContentDisposition() {
            throw new RuntimeException("Stub!");
        }

        /* 20 */
        public InputStream getInputStream() {
            throw new RuntimeException("Stub!");
        }

        /* 21 */
        public java.io.OutputStream getOutputStream() {
            throw new RuntimeException("Stub!");
        }

        /* 22 */
        public void setInputStream(InputStream stream) {
            throw new RuntimeException("Stub!");
        }

        /* 23 */
        public void setEncoding(String encoding) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 25 */
    public CacheManager() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 27 */ public static java.io.File getCacheFileBaseDir() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 29 */ public static boolean cacheDisabled() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 31 */ public static boolean startCacheTransaction() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 33 */ public static boolean endCacheTransaction() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 35 */ public static CacheResult getCacheFile(String url, java.util.Map<String, String> headers) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 37 */ public static void saveCacheFile(String url, CacheResult cacheResult) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/webkit/CacheManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */