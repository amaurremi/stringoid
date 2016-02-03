/*    */
package android.webkit;
/*    */ 
/*    */

import android.view.View;

/*    */
/*    */ 
/*    */ public class WebChromeClient
/*    */ {
    /*  8 */
    public WebChromeClient() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public void onProgressChanged(WebView view, int newProgress) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void onReceivedTitle(WebView view, String title) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void onReceivedIcon(WebView view, android.graphics.Bitmap icon) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void onReceivedTouchIconUrl(WebView view, String url, boolean precomposed) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void onShowCustomView(View view, CustomViewCallback callback) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void onShowCustomView(View view, int requestedOrientation, CustomViewCallback callback) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void onHideCustomView() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, android.os.Message resultMsg) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void onRequestFocus(WebView view) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void onCloseWindow(WebView window) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public void onExceededDatabaseQuota(String url, String databaseIdentifier, long quota, long estimatedDatabaseSize, long totalQuota, WebStorage.QuotaUpdater quotaUpdater) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void onReachedMaxAppCacheSize(long requiredStorage, long quota, WebStorage.QuotaUpdater quotaUpdater) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public void onGeolocationPermissionsHidePrompt() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public boolean onJsTimeout() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 29 */ public void onConsoleMessage(String message, int lineNumber, String sourceID) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public android.graphics.Bitmap getDefaultVideoPoster() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public View getVideoLoadingProgressView() {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public void getVisitedHistory(ValueCallback<String[]> callback) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface CustomViewCallback
/*    */ {
        /*    */
        public abstract void onCustomViewHidden();
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/webkit/WebChromeClient.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */