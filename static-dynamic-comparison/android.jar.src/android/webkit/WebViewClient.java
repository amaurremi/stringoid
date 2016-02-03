/*    */
package android.webkit;
/*    */

import android.os.Message;

/*    */
/*  4 */ public class WebViewClient {
    public WebViewClient() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void onPageFinished(WebView view, String url) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void onLoadResource(WebView view, String url) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 11 */ public void onTooManyRedirects(WebView view, Message cancelMsg, Message continueMsg) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void onFormResubmission(WebView view, Message dontResend, Message resend) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void onReceivedSslError(WebView view, SslErrorHandler handler, android.net.http.SslError error) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public boolean shouldOverrideKeyEvent(WebView view, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void onUnhandledKeyEvent(WebView view, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void onScaleChanged(WebView view, float oldScale, float newScale) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void onReceivedLoginRequest(WebView view, String realm, String account, String args) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int ERROR_UNKNOWN = -1;
    /*    */   public static final int ERROR_HOST_LOOKUP = -2;
    /*    */   public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    /*    */   public static final int ERROR_AUTHENTICATION = -4;
    /*    */   public static final int ERROR_PROXY_AUTHENTICATION = -5;
    /*    */   public static final int ERROR_CONNECT = -6;
    /*    */   public static final int ERROR_IO = -7;
    /*    */   public static final int ERROR_TIMEOUT = -8;
    /*    */   public static final int ERROR_REDIRECT_LOOP = -9;
    /*    */   public static final int ERROR_UNSUPPORTED_SCHEME = -10;
    /*    */   public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    /*    */   public static final int ERROR_BAD_URL = -12;
    /*    */   public static final int ERROR_FILE = -13;
    /*    */   public static final int ERROR_FILE_NOT_FOUND = -14;
    /*    */   public static final int ERROR_TOO_MANY_REQUESTS = -15;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/webkit/WebViewClient.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */