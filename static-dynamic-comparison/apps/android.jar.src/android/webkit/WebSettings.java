/*     */
package android.webkit;

/*     */
/*     */ public abstract class WebSettings {
    public static final int LOAD_DEFAULT = -1;
    /*     */   public static final int LOAD_NORMAL = 0;

    /*     */
/*   6 */   public static enum LayoutAlgorithm {
        NARROW_COLUMNS,
        /*   7 */     NORMAL,
        /*   8 */     SINGLE_COLUMN;

        /*     */
/*     */
        private LayoutAlgorithm() {
        }
    }

    /*     */
/*     */
    @Deprecated
/*  13 */ public static enum TextSize {
        LARGER,
        /*  14 */     LARGEST,
        /*  15 */     NORMAL,
        /*  16 */     SMALLER,
        /*  17 */     SMALLEST;

        /*     */
/*     */
        private TextSize() {
        }
    }

    /*     */
/*  21 */   public static enum ZoomDensity {
        CLOSE,
        /*  22 */     FAR,
        /*  23 */     MEDIUM;

        /*     */
/*     */
        private ZoomDensity() {
        }
    }

    /*     */
/*  27 */   public static enum RenderPriority {
        HIGH,
        /*  28 */     LOW,
        /*  29 */     NORMAL;

        /*     */
/*     */
        private RenderPriority() {
        }
    }

    /*     */
/*  33 */   public static enum PluginState {
        OFF,
        /*  34 */     ON,
        /*  35 */     ON_DEMAND;

        /*     */
        private PluginState() {
        }
    }

    /*  37 */   WebSettings() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  39 */ public void setNavDump(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  41 */ public boolean getNavDump() {
        throw new RuntimeException("Stub!");
    }

    /*  42 */
    public void setSupportZoom(boolean support) {
        throw new RuntimeException("Stub!");
    }

    /*  43 */
    public boolean supportZoom() {
        throw new RuntimeException("Stub!");
    }

    /*  44 */
    public void setBuiltInZoomControls(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /*  45 */
    public boolean getBuiltInZoomControls() {
        throw new RuntimeException("Stub!");
    }

    /*  46 */
    public void setDisplayZoomControls(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /*  47 */
    public boolean getDisplayZoomControls() {
        throw new RuntimeException("Stub!");
    }

    /*  48 */
    public void setAllowFileAccess(boolean allow) {
        throw new RuntimeException("Stub!");
    }

    /*  49 */
    public boolean getAllowFileAccess() {
        throw new RuntimeException("Stub!");
    }

    /*  50 */
    public void setAllowContentAccess(boolean allow) {
        throw new RuntimeException("Stub!");
    }

    /*  51 */
    public boolean getAllowContentAccess() {
        throw new RuntimeException("Stub!");
    }

    /*  52 */
    public void setLoadWithOverviewMode(boolean overview) {
        throw new RuntimeException("Stub!");
    }

    /*  53 */
    public boolean getLoadWithOverviewMode() {
        throw new RuntimeException("Stub!");
    }

    /*  54 */
    public void setEnableSmoothTransition(boolean enable) {
        throw new RuntimeException("Stub!");
    }

    /*  55 */
    public boolean enableSmoothTransition() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  57 */ public void setUseWebViewBackgroundForOverscrollBackground(boolean view) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  59 */ public boolean getUseWebViewBackgroundForOverscrollBackground() {
        throw new RuntimeException("Stub!");
    }

    /*  60 */
    public void setSaveFormData(boolean save) {
        throw new RuntimeException("Stub!");
    }

    /*  61 */
    public boolean getSaveFormData() {
        throw new RuntimeException("Stub!");
    }

    /*  62 */
    public void setSavePassword(boolean save) {
        throw new RuntimeException("Stub!");
    }

    /*  63 */
    public boolean getSavePassword() {
        throw new RuntimeException("Stub!");
    }

    /*  64 */
    public synchronized void setTextZoom(int textZoom) {
        throw new RuntimeException("Stub!");
    }

    /*  65 */
    public synchronized int getTextZoom() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  67 */ public synchronized void setTextSize(TextSize t) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  69 */ public synchronized TextSize getTextSize() {
        throw new RuntimeException("Stub!");
    }

    /*  70 */
    public void setDefaultZoom(ZoomDensity zoom) {
        throw new RuntimeException("Stub!");
    }

    /*  71 */
    public ZoomDensity getDefaultZoom() {
        throw new RuntimeException("Stub!");
    }

    /*  72 */
    public void setLightTouchEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    /*  73 */
    public boolean getLightTouchEnabled() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  75 */ public synchronized void setUseDoubleTree(boolean use) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  77 */ public synchronized boolean getUseDoubleTree() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  79 */ public synchronized void setUserAgent(int ua) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/*  81 */ public synchronized int getUserAgent() {
        throw new RuntimeException("Stub!");
    }

    /*  82 */
    public synchronized void setUseWideViewPort(boolean use) {
        throw new RuntimeException("Stub!");
    }

    /*  83 */
    public synchronized boolean getUseWideViewPort() {
        throw new RuntimeException("Stub!");
    }

    /*  84 */
    public synchronized void setSupportMultipleWindows(boolean support) {
        throw new RuntimeException("Stub!");
    }

    /*  85 */
    public synchronized boolean supportMultipleWindows() {
        throw new RuntimeException("Stub!");
    }

    /*  86 */
    public synchronized void setLayoutAlgorithm(LayoutAlgorithm l) {
        throw new RuntimeException("Stub!");
    }

    /*  87 */
    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
        throw new RuntimeException("Stub!");
    }

    /*  88 */
    public synchronized void setStandardFontFamily(String font) {
        throw new RuntimeException("Stub!");
    }

    /*  89 */
    public synchronized String getStandardFontFamily() {
        throw new RuntimeException("Stub!");
    }

    /*  90 */
    public synchronized void setFixedFontFamily(String font) {
        throw new RuntimeException("Stub!");
    }

    /*  91 */
    public synchronized String getFixedFontFamily() {
        throw new RuntimeException("Stub!");
    }

    /*  92 */
    public synchronized void setSansSerifFontFamily(String font) {
        throw new RuntimeException("Stub!");
    }

    /*  93 */
    public synchronized String getSansSerifFontFamily() {
        throw new RuntimeException("Stub!");
    }

    /*  94 */
    public synchronized void setSerifFontFamily(String font) {
        throw new RuntimeException("Stub!");
    }

    /*  95 */
    public synchronized String getSerifFontFamily() {
        throw new RuntimeException("Stub!");
    }

    /*  96 */
    public synchronized void setCursiveFontFamily(String font) {
        throw new RuntimeException("Stub!");
    }

    /*  97 */
    public synchronized String getCursiveFontFamily() {
        throw new RuntimeException("Stub!");
    }

    /*  98 */
    public synchronized void setFantasyFontFamily(String font) {
        throw new RuntimeException("Stub!");
    }

    /*  99 */
    public synchronized String getFantasyFontFamily() {
        throw new RuntimeException("Stub!");
    }

    /* 100 */
    public synchronized void setMinimumFontSize(int size) {
        throw new RuntimeException("Stub!");
    }

    /* 101 */
    public synchronized int getMinimumFontSize() {
        throw new RuntimeException("Stub!");
    }

    /* 102 */
    public synchronized void setMinimumLogicalFontSize(int size) {
        throw new RuntimeException("Stub!");
    }

    /* 103 */
    public synchronized int getMinimumLogicalFontSize() {
        throw new RuntimeException("Stub!");
    }

    /* 104 */
    public synchronized void setDefaultFontSize(int size) {
        throw new RuntimeException("Stub!");
    }

    /* 105 */
    public synchronized int getDefaultFontSize() {
        throw new RuntimeException("Stub!");
    }

    /* 106 */
    public synchronized void setDefaultFixedFontSize(int size) {
        throw new RuntimeException("Stub!");
    }

    /* 107 */
    public synchronized int getDefaultFixedFontSize() {
        throw new RuntimeException("Stub!");
    }

    /* 108 */
    public synchronized void setLoadsImagesAutomatically(boolean flag) {
        throw new RuntimeException("Stub!");
    }

    /* 109 */
    public synchronized boolean getLoadsImagesAutomatically() {
        throw new RuntimeException("Stub!");
    }

    /* 110 */
    public synchronized void setBlockNetworkImage(boolean flag) {
        throw new RuntimeException("Stub!");
    }

    /* 111 */
    public synchronized boolean getBlockNetworkImage() {
        throw new RuntimeException("Stub!");
    }

    /* 112 */
    public synchronized void setBlockNetworkLoads(boolean flag) {
        throw new RuntimeException("Stub!");
    }

    /* 113 */
    public synchronized boolean getBlockNetworkLoads() {
        throw new RuntimeException("Stub!");
    }

    /* 114 */
    public synchronized void setJavaScriptEnabled(boolean flag) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    public abstract void setAllowUniversalAccessFromFileURLs(boolean paramBoolean);

    /*     */
    public abstract void setAllowFileAccessFromFileURLs(boolean paramBoolean);

    /*     */
    @Deprecated
/* 118 */ public synchronized void setPluginsEnabled(boolean flag) {
        throw new RuntimeException("Stub!");
    }

    /* 119 */
    public synchronized void setPluginState(PluginState state) {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/* 121 */ public synchronized void setPluginsPath(String pluginsPath) {
        throw new RuntimeException("Stub!");
    }

    /* 122 */
    public synchronized void setDatabasePath(String databasePath) {
        throw new RuntimeException("Stub!");
    }

    /* 123 */
    public synchronized void setGeolocationDatabasePath(String databasePath) {
        throw new RuntimeException("Stub!");
    }

    /* 124 */
    public synchronized void setAppCacheEnabled(boolean flag) {
        throw new RuntimeException("Stub!");
    }

    /* 125 */
    public synchronized void setAppCachePath(String appCachePath) {
        throw new RuntimeException("Stub!");
    }

    /* 126 */
    public synchronized void setAppCacheMaxSize(long appCacheMaxSize) {
        throw new RuntimeException("Stub!");
    }

    /* 127 */
    public synchronized void setDatabaseEnabled(boolean flag) {
        throw new RuntimeException("Stub!");
    }

    /* 128 */
    public synchronized void setDomStorageEnabled(boolean flag) {
        throw new RuntimeException("Stub!");
    }

    /* 129 */
    public synchronized boolean getDomStorageEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 130 */
    public synchronized String getDatabasePath() {
        throw new RuntimeException("Stub!");
    }

    /* 131 */
    public synchronized boolean getDatabaseEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 132 */
    public synchronized void setGeolocationEnabled(boolean flag) {
        throw new RuntimeException("Stub!");
    }

    /* 133 */
    public synchronized boolean getJavaScriptEnabled() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    public abstract boolean getAllowUniversalAccessFromFileURLs();

    /*     */
    public abstract boolean getAllowFileAccessFromFileURLs();

    /*     */
    @Deprecated
/* 137 */ public synchronized boolean getPluginsEnabled() {
        throw new RuntimeException("Stub!");
    }

    /* 138 */
    public synchronized PluginState getPluginState() {
        throw new RuntimeException("Stub!");
    }

    /*     */
    @Deprecated
/* 140 */ public synchronized String getPluginsPath() {
        throw new RuntimeException("Stub!");
    }

    /* 141 */
    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean flag) {
        throw new RuntimeException("Stub!");
    }

    /* 142 */
    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        throw new RuntimeException("Stub!");
    }

    /* 143 */
    public synchronized void setDefaultTextEncodingName(String encoding) {
        throw new RuntimeException("Stub!");
    }

    /* 144 */
    public synchronized String getDefaultTextEncodingName() {
        throw new RuntimeException("Stub!");
    }

    /* 145 */
    public synchronized void setUserAgentString(String ua) {
        throw new RuntimeException("Stub!");
    }

    /* 146 */
    public synchronized String getUserAgentString() {
        throw new RuntimeException("Stub!");
    }

    /* 147 */
    public void setNeedInitialFocus(boolean flag) {
        throw new RuntimeException("Stub!");
    }

    /* 148 */
    public synchronized void setRenderPriority(RenderPriority priority) {
        throw new RuntimeException("Stub!");
    }

    /* 149 */
    public void setCacheMode(int mode) {
        throw new RuntimeException("Stub!");
    }

    /* 150 */
    public int getCacheMode() {
        throw new RuntimeException("Stub!");
    }

    /*     */
/*     */   public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    /*     */   public static final int LOAD_NO_CACHE = 2;
    /*     */   public static final int LOAD_CACHE_ONLY = 3;
/*     */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/webkit/WebSettings.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */