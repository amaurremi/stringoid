/*     */
package android.webkit;
/*     */ 
/*     */

import android.view.View;

/*     */
/*     */ public class WebView extends android.widget.AbsoluteLayout implements android.view.ViewTreeObserver.OnGlobalFocusChangeListener, android.view.ViewGroup.OnHierarchyChangeListener {
    /*     */   public static final String SCHEME_TEL = "tel:";

    /*     */
/*   8 */   public class WebViewTransport {
        public WebViewTransport() {
            throw new RuntimeException("Stub!");
        }

        /*   9 */
        public synchronized void setWebView(WebView webview) {
            throw new RuntimeException("Stub!");
        }

        /*  10 */
        public synchronized WebView getWebView() {
            throw new RuntimeException("Stub!");
        }
/*     */
    }

    /*     */
/*     */   public static abstract interface FindListener {
        public abstract void onFindResultReceived(int paramInt1, int paramInt2, boolean paramBoolean);
/*     */
    }

    /*     */
/*     */
    @Deprecated
/*     */ public static abstract interface PictureListener {
        @Deprecated
/*     */ public abstract void onNewPicture(WebView paramWebView, android.graphics.Picture paramPicture);
    }

    /*     */
/*     */   public static class HitTestResult {
        public static final int UNKNOWN_TYPE = 0;
        /*     */
        @Deprecated
/*     */ public static final int ANCHOR_TYPE = 1;

        /*     */
/*  24 */     HitTestResult() {
            throw new RuntimeException("Stub!");
        }

        /*  25 */
        public int getType() {
            throw new RuntimeException("Stub!");
        }

        /*  26 */
        public String getExtra() {
            throw new RuntimeException("Stub!");
        }

        /*     */
/*     */     public static final int PHONE_TYPE = 2;
        /*     */     public static final int GEO_TYPE = 3;
        /*     */     public static final int EMAIL_TYPE = 4;
        /*     */     public static final int IMAGE_TYPE = 5;
        /*     */
        @Deprecated
/*     */ public static final int IMAGE_ANCHOR_TYPE = 6;
        /*     */     public static final int SRC_ANCHOR_TYPE = 7;
        /*     */     public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        /*     */     public static final int EDIT_TEXT_TYPE = 9;
    }

    /*     */
/*     */   public static final String SCHEME_MAILTO = "mailto:";
    /*     */   public static final String SCHEME_GEO = "geo:0,0?q=";

    /*  40 */
    public WebView(android.content.Context context) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  41 */
    public WebView(android.content.Context context, android.util.AttributeSet attrs) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  42 */
    public WebView(android.content.Context context, android.util.AttributeSet attrs, int defStyle) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  43 */
    public WebView(android.content.Context context, android.util.AttributeSet attrs, int defStyle, boolean privateBrowsing) {
        super((android.content.Context) null, (android.util.AttributeSet) null, 0);
        throw new RuntimeException("Stub!");
    }

    /*  44 */
    public void setHorizontalScrollbarOverlay(boolean overlay) {
        throw new RuntimeException("Stub!");
    }

    /*  45 */
    public void setVerticalScrollbarOverlay(boolean overlay) {
        throw new RuntimeException("Stub!");
    }

    /*  46 */
    public boolean overlayHorizontalScrollbar() {
        throw new RuntimeException("Stub!");
    }

    /*  47 */
    public boolean overlayVerticalScrollbar() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  49 */ public int getVisibleTitleHeight() {
        throw new RuntimeException("Stub!");
    }

    /*  50 */
    public android.net.http.SslCertificate getCertificate() {
        throw new RuntimeException("Stub!");
    }

    /*  51 */
    public void setCertificate(android.net.http.SslCertificate certificate) {
        throw new RuntimeException("Stub!");
    }

    /*  52 */
    public void savePassword(String host, String username, String password) {
        throw new RuntimeException("Stub!");
    }

    /*  53 */
    public void setHttpAuthUsernamePassword(String host, String realm, String username, String password) {
        throw new RuntimeException("Stub!");
    }

    /*  54 */
    public String[] getHttpAuthUsernamePassword(String host, String realm) {
        throw new RuntimeException("Stub!");
    }

    /*  55 */
    public void destroy() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  57 */ public static void enablePlatformNotifications() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  59 */ public static void disablePlatformNotifications() {
        throw new RuntimeException("Stub!");
    }

    /*  60 */
    public void setNetworkAvailable(boolean networkUp) {
        throw new RuntimeException("Stub!");
    }

    /*  61 */
    public WebBackForwardList saveState(android.os.Bundle outState) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  63 */ public boolean savePicture(android.os.Bundle b, java.io.File dest) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  65 */ public boolean restorePicture(android.os.Bundle b, java.io.File src) {
        throw new RuntimeException("Stub!");
    }

    /*  66 */
    public WebBackForwardList restoreState(android.os.Bundle inState) {
        throw new RuntimeException("Stub!");
    }

    /*  67 */
    public void loadUrl(String url, java.util.Map<String, String> additionalHttpHeaders) {
        throw new RuntimeException("Stub!");
    }

    /*  68 */
    public void loadUrl(String url) {
        throw new RuntimeException("Stub!");
    }

    /*  69 */
    public void postUrl(String url, byte[] postData) {
        throw new RuntimeException("Stub!");
    }

    /*  70 */
    public void loadData(String data, String mimeType, String encoding) {
        throw new RuntimeException("Stub!");
    }

    /*  71 */
    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        throw new RuntimeException("Stub!");
    }

    /*  72 */
    public void saveWebArchive(String filename) {
        throw new RuntimeException("Stub!");
    }

    /*  73 */
    public void saveWebArchive(String basename, boolean autoname, ValueCallback<String> callback) {
        throw new RuntimeException("Stub!");
    }

    /*  74 */
    public void stopLoading() {
        throw new RuntimeException("Stub!");
    }

    /*  75 */
    public void reload() {
        throw new RuntimeException("Stub!");
    }

    /*  76 */
    public boolean canGoBack() {
        throw new RuntimeException("Stub!");
    }

    /*  77 */
    public void goBack() {
        throw new RuntimeException("Stub!");
    }

    /*  78 */
    public boolean canGoForward() {
        throw new RuntimeException("Stub!");
    }

    /*  79 */
    public void goForward() {
        throw new RuntimeException("Stub!");
    }

    /*  80 */
    public boolean canGoBackOrForward(int steps) {
        throw new RuntimeException("Stub!");
    }

    /*  81 */
    public void goBackOrForward(int steps) {
        throw new RuntimeException("Stub!");
    }

    /*  82 */
    public boolean isPrivateBrowsingEnabled() {
        throw new RuntimeException("Stub!");
    }

    /*  83 */
    public boolean pageUp(boolean top) {
        throw new RuntimeException("Stub!");
    }

    /*  84 */
    public boolean pageDown(boolean bottom) {
        throw new RuntimeException("Stub!");
    }

    /*  85 */
    public void clearView() {
        throw new RuntimeException("Stub!");
    }

    /*  86 */
    public android.graphics.Picture capturePicture() {
        throw new RuntimeException("Stub!");
    }

    /*  87 */
    public float getScale() {
        throw new RuntimeException("Stub!");
    }

    /*  88 */
    public void setInitialScale(int scaleInPercent) {
        throw new RuntimeException("Stub!");
    }

    /*  89 */
    public void invokeZoomPicker() {
        throw new RuntimeException("Stub!");
    }

    /*  90 */
    public HitTestResult getHitTestResult() {
        throw new RuntimeException("Stub!");
    }

    /*  91 */
    public void requestFocusNodeHref(android.os.Message hrefMsg) {
        throw new RuntimeException("Stub!");
    }

    /*  92 */
    public void requestImageRef(android.os.Message msg) {
        throw new RuntimeException("Stub!");
    }

    /*  93 */
    public String getUrl() {
        throw new RuntimeException("Stub!");
    }

    /*  94 */
    public String getOriginalUrl() {
        throw new RuntimeException("Stub!");
    }

    /*  95 */
    public String getTitle() {
        throw new RuntimeException("Stub!");
    }

    /*  96 */
    public android.graphics.Bitmap getFavicon() {
        throw new RuntimeException("Stub!");
    }

    /*  97 */
    public int getProgress() {
        throw new RuntimeException("Stub!");
    }

    /*  98 */
    public int getContentHeight() {
        throw new RuntimeException("Stub!");
    }

    /*  99 */
    public void pauseTimers() {
        throw new RuntimeException("Stub!");
    }

    /* 100 */
    public void resumeTimers() {
        throw new RuntimeException("Stub!");
    }

    /* 101 */
    public void onPause() {
        throw new RuntimeException("Stub!");
    }

    /* 102 */
    public void onResume() {
        throw new RuntimeException("Stub!");
    }

    /* 103 */
    public void freeMemory() {
        throw new RuntimeException("Stub!");
    }

    /* 104 */
    public void clearCache(boolean includeDiskFiles) {
        throw new RuntimeException("Stub!");
    }

    /* 105 */
    public void clearFormData() {
        throw new RuntimeException("Stub!");
    }

    /* 106 */
    public void clearHistory() {
        throw new RuntimeException("Stub!");
    }

    /* 107 */
    public void clearSslPreferences() {
        throw new RuntimeException("Stub!");
    }

    /* 108 */
    public WebBackForwardList copyBackForwardList() {
        throw new RuntimeException("Stub!");
    }

    /* 109 */
    public void setFindListener(FindListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 110 */
    public void findNext(boolean forward) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/* 112 */ public int findAll(String find) {
        throw new RuntimeException("Stub!");
    }

    /* 113 */
    public void findAllAsync(String find) {
        throw new RuntimeException("Stub!");
    }

    /* 114 */
    public boolean showFindDialog(String text, boolean showIme) {
        throw new RuntimeException("Stub!");
    }

    /* 115 */
    public static String findAddress(String addr) {
        throw new RuntimeException("Stub!");
    }

    /* 116 */
    public void clearMatches() {
        throw new RuntimeException("Stub!");
    }

    /* 117 */
    public void documentHasImages(android.os.Message response) {
        throw new RuntimeException("Stub!");
    }

    /* 118 */
    public void setWebViewClient(WebViewClient client) {
        throw new RuntimeException("Stub!");
    }

    /* 119 */
    public void setDownloadListener(DownloadListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 120 */
    public void setWebChromeClient(WebChromeClient client) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/* 122 */ public void setPictureListener(PictureListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 123 */
    public void addJavascriptInterface(Object object, String name) {
        throw new RuntimeException("Stub!");
    }

    /* 124 */
    public void removeJavascriptInterface(String name) {
        throw new RuntimeException("Stub!");
    }

    /* 125 */
    public WebSettings getSettings() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/* 127 */ public void emulateShiftHeld() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/* 129 */ public void onChildViewAdded(View parent, View child) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/* 131 */ public void onChildViewRemoved(View p, View child) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/* 133 */ public void onGlobalFocusChanged(View oldFocus, View newFocus) {
        throw new RuntimeException("Stub!");
    }

    /* 134 */
    public void setMapTrackballToArrowKeys(boolean setMap) {
        throw new RuntimeException("Stub!");
    }

    /* 135 */
    public void flingScroll(int vx, int vy) {
        throw new RuntimeException("Stub!");
    }

    /* 136 */
    public boolean canZoomIn() {
        throw new RuntimeException("Stub!");
    }

    /* 137 */
    public boolean canZoomOut() {
        throw new RuntimeException("Stub!");
    }

    /* 138 */
    public boolean zoomIn() {
        throw new RuntimeException("Stub!");
    }

    /* 139 */
    public boolean zoomOut() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/* 141 */ public void debugDump() {
        throw new RuntimeException("Stub!");
    }

    /* 142 */
    protected void onAttachedToWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 143 */
    protected void onDetachedFromWindow() {
        throw new RuntimeException("Stub!");
    }

    /* 144 */
    public void setLayoutParams(android.view.ViewGroup.LayoutParams params) {
        throw new RuntimeException("Stub!");
    }

    /* 145 */
    public void setOverScrollMode(int mode) {
        throw new RuntimeException("Stub!");
    }

    /* 146 */
    public void setScrollBarStyle(int style) {
        throw new RuntimeException("Stub!");
    }

    /* 147 */
    protected int computeHorizontalScrollRange() {
        throw new RuntimeException("Stub!");
    }

    /* 148 */
    protected int computeHorizontalScrollOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 149 */
    protected int computeVerticalScrollRange() {
        throw new RuntimeException("Stub!");
    }

    /* 150 */
    protected int computeVerticalScrollOffset() {
        throw new RuntimeException("Stub!");
    }

    /* 151 */
    protected int computeVerticalScrollExtent() {
        throw new RuntimeException("Stub!");
    }

    /* 152 */
    public void computeScroll() {
        throw new RuntimeException("Stub!");
    }

    /* 153 */
    public boolean onHoverEvent(android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 154 */
    public boolean onTouchEvent(android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 155 */
    public boolean onGenericMotionEvent(android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 156 */
    public boolean onTrackballEvent(android.view.MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 157 */
    public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 158 */
    public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 159 */
    public boolean onKeyMultiple(int keyCode, int repeatCount, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/* 161 */ public boolean shouldDelayChildPressedState() {
        throw new RuntimeException("Stub!");
    }

    /* 162 */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo info) {
        throw new RuntimeException("Stub!");
    }

    /* 163 */
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 164 */
    public boolean performAccessibilityAction(int action, android.os.Bundle arguments) {
        throw new RuntimeException("Stub!");
    }

    /* 165 */
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        throw new RuntimeException("Stub!");
    }

    /* 166 */
    protected void onWindowVisibilityChanged(int visibility) {
        throw new RuntimeException("Stub!");
    }

    /* 167 */
    protected void onDraw(android.graphics.Canvas canvas) {
        throw new RuntimeException("Stub!");
    }

    /* 168 */
    public boolean performLongClick() {
        throw new RuntimeException("Stub!");
    }

    /* 169 */
    protected void onConfigurationChanged(android.content.res.Configuration newConfig) {
        throw new RuntimeException("Stub!");
    }

    /* 170 */
    public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo outAttrs) {
        throw new RuntimeException("Stub!");
    }

    /* 171 */
    protected void onVisibilityChanged(View changedView, int visibility) {
        throw new RuntimeException("Stub!");
    }

    /* 172 */
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        throw new RuntimeException("Stub!");
    }

    /* 173 */
    protected void onFocusChanged(boolean focused, int direction, android.graphics.Rect previouslyFocusedRect) {
        throw new RuntimeException("Stub!");
    }

    /* 174 */
    protected void onSizeChanged(int w, int h, int ow, int oh) {
        throw new RuntimeException("Stub!");
    }

    /* 175 */
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        throw new RuntimeException("Stub!");
    }

    /* 176 */
    public boolean dispatchKeyEvent(android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 177 */
    public boolean requestFocus(int direction, android.graphics.Rect previouslyFocusedRect) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/* 179 */ protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    /* 180 */
    public boolean requestChildRectangleOnScreen(View child, android.graphics.Rect rect, boolean immediate) {
        throw new RuntimeException("Stub!");
    }

    /* 181 */
    public void setBackgroundColor(int color) {
        throw new RuntimeException("Stub!");
    }

    /* 182 */
    public void setLayerType(int layerType, android.graphics.Paint paint) {
        throw new RuntimeException("Stub!");
    }
/*     */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/webkit/WebView.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */