/*    */
package android.net.http;
/*    */ 
/*    */

import org.apache.http.HttpRequest;

/*    */
/*  5 */ public final class AndroidHttpClient implements org.apache.http.client.HttpClient {
    AndroidHttpClient() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public static AndroidHttpClient newInstance(String userAgent, android.content.Context context) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public static AndroidHttpClient newInstance(String userAgent) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public static void modifyRequestToAcceptGzipResponse(HttpRequest request) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public static java.io.InputStream getUngzippedContent(org.apache.http.HttpEntity entity) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void close() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public org.apache.http.params.HttpParams getParams() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public org.apache.http.conn.ClientConnectionManager getConnectionManager() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public org.apache.http.HttpResponse execute(org.apache.http.client.methods.HttpUriRequest request) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public org.apache.http.HttpResponse execute(org.apache.http.client.methods.HttpUriRequest request, org.apache.http.protocol.HttpContext context) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public org.apache.http.HttpResponse execute(org.apache.http.HttpHost target, HttpRequest request) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public org.apache.http.HttpResponse execute(org.apache.http.HttpHost target, HttpRequest request, org.apache.http.protocol.HttpContext context) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public <T> T execute(org.apache.http.client.methods.HttpUriRequest request, org.apache.http.client.ResponseHandler<? extends T> responseHandler) throws java.io.IOException, org.apache.http.client.ClientProtocolException {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public <T> T execute(org.apache.http.client.methods.HttpUriRequest request, org.apache.http.client.ResponseHandler<? extends T> responseHandler, org.apache.http.protocol.HttpContext context) throws java.io.IOException, org.apache.http.client.ClientProtocolException {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public <T> T execute(org.apache.http.HttpHost target, HttpRequest request, org.apache.http.client.ResponseHandler<? extends T> responseHandler) throws java.io.IOException, org.apache.http.client.ClientProtocolException {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public <T> T execute(org.apache.http.HttpHost target, HttpRequest request, org.apache.http.client.ResponseHandler<? extends T> responseHandler, org.apache.http.protocol.HttpContext context) throws java.io.IOException, org.apache.http.client.ClientProtocolException {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public static org.apache.http.entity.AbstractHttpEntity getCompressedEntity(byte[] data, android.content.ContentResolver resolver) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public static long getMinGzipSize(android.content.ContentResolver resolver) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void enableCurlLogging(String name, int level) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void disableCurlLogging() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public static long parseDate(String dateString) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static long DEFAULT_SYNC_MIN_GZIP_BYTES;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/http/AndroidHttpClient.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */