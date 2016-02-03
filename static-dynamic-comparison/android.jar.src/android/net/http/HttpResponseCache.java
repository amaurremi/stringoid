/*    */
package android.net.http;
/*    */ 
/*    */

import java.io.IOException;

/*    */
/*    */ public final class HttpResponseCache extends java.net.ResponseCache implements java.io.Closeable {
    /*  6 */   HttpResponseCache() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public static HttpResponseCache getInstalled() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public static HttpResponseCache install(java.io.File directory, long maxSize) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public java.net.CacheResponse get(java.net.URI uri, String requestMethod, java.util.Map<String, java.util.List<String>> requestHeaders) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public java.net.CacheRequest put(java.net.URI uri, java.net.URLConnection urlConnection) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public long size() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public long maxSize() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void flush() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public int getNetworkCount() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public int getHitCount() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public int getRequestCount() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void close() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void delete() throws IOException {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/http/HttpResponseCache.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */