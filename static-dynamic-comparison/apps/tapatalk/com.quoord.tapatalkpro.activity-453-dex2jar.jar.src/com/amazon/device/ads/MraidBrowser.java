package com.amazon.device.ads;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

class MraidBrowser
        implements IAdActivityAdapter {
    private static final int BUTTON_SIZE_DP = 50;
    private static final int HORIZONTAL_RULE_SIZE_DP = 3;
    protected static final String LOG_TAG = MraidBrowser.class.getSimpleName();
    protected static final String SHOW_OPEN_EXTERNAL_BROWSER_BTN = "extra_open_btn";
    protected static final String URL_EXTRA = "extra_url";
    private Activity activity;
    private ImageButton mBrowserBackButton;
    private ImageButton mBrowserForwardButton;
    private ImageButton mCloseButton;
    private ImageButton mOpenExternalBrowserButton;
    private ImageButton mRefreshButton;
    private WebView mWebView;
    private boolean showOpenExternalBrowserButton;

    private ImageButton createButton(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        ImageButton localImageButton = new ImageButton(this.activity);
        localImageButton.setImageBitmap(BitmapFactory.decodeFile(paramString));
        paramString = new RelativeLayout.LayoutParams(paramInt3, paramInt4);
        paramString.addRule(paramInt1, paramInt2);
        paramString.addRule(12);
        localImageButton.setLayoutParams(paramString);
        localImageButton.setBackgroundColor(0);
        localImageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return localImageButton;
    }

    private void enableCookies() {
        CookieSyncManager.createInstance(this.activity);
        CookieSyncManager.getInstance().startSync();
    }

    private void initializeButtons(final Intent paramIntent) {
        this.mBrowserBackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (MraidBrowser.this.mWebView.canGoBack()) {
                    MraidBrowser.this.mWebView.goBack();
                }
            }
        });
        this.mBrowserForwardButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (MraidBrowser.this.mWebView.canGoForward()) {
                    MraidBrowser.this.mWebView.goForward();
                }
            }
        });
        this.mRefreshButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                MraidBrowser.this.mWebView.reload();
            }
        });
        this.mCloseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                MraidBrowser.this.activity.finish();
            }
        });
        if (this.showOpenExternalBrowserButton) {
            this.mOpenExternalBrowserButton.setOnClickListener(new View.OnClickListener() {
                final String originalUrl = paramIntent.getStringExtra("extra_url");

                public void onClick(View paramAnonymousView) {
                    String str = MraidBrowser.this.mWebView.getUrl();
                    paramAnonymousView = str;
                    if (str == null) {
                        Log.w(MraidBrowser.LOG_TAG, "The current URL is null. Reverting to the original URL for external browser.");
                        paramAnonymousView = this.originalUrl;
                    }
                    AdUtils.launchActivityForIntentLink(paramAnonymousView, MraidBrowser.this.mWebView.getContext());
                }
            });
        }
    }

    @SuppressLint({"InlinedApi"})
    private void initializeEntireView(Intent paramIntent) {
        Object localObject = new DisplayMetrics();
        ((WindowManager) this.activity.getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics) localObject);
        float f = ((DisplayMetrics) localObject).density;
        int k = (int) (50.0F * f + 0.5F);
        int m = (int) (3.0F * f + 0.5F);
        if (this.showOpenExternalBrowserButton) {
        }
        for (int i = 5; ; i = 4) {
            int j = ((DisplayMetrics) localObject).widthPixels / i;
            i = j;
            if (j > k * 2) {
                i = k * 2;
            }
            localObject = new RelativeLayout(this.activity);
            ((RelativeLayout) localObject).setId(10280);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, k + m);
            localLayoutParams.addRule(12);
            ((RelativeLayout) localObject).setLayoutParams(localLayoutParams);
            ((RelativeLayout) localObject).setBackgroundColor(-986896);
            ThreadUtils.executeAsyncTask(new LoadButtonsTask(paramIntent, (ViewGroup) localObject, i, k), new Void[0]);
            paramIntent = new View(this.activity);
            paramIntent.setBackgroundColor(-3355444);
            localLayoutParams = new RelativeLayout.LayoutParams(-1, m);
            localLayoutParams.addRule(10);
            paramIntent.setLayoutParams(localLayoutParams);
            ((RelativeLayout) localObject).addView(paramIntent);
            this.mWebView = WebViewFactory.getInstance().createWebView(this.activity);
            paramIntent = new RelativeLayout.LayoutParams(-1, -1);
            paramIntent.addRule(2, ((RelativeLayout) localObject).getId());
            this.mWebView.setLayoutParams(paramIntent);
            paramIntent = new RelativeLayout(this.activity);
            paramIntent.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            paramIntent.addView(this.mWebView);
            paramIntent.addView((View) localObject);
            localObject = new LinearLayout(this.activity);
            ((LinearLayout) localObject).setOrientation(1);
            ((LinearLayout) localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            ((LinearLayout) localObject).addView(paramIntent);
            this.activity.setContentView((View) localObject);
            return;
        }
    }

    private void initializeWebView(Intent paramIntent) {
        WebViewFactory.setJavaScriptEnabledForWebView(true, this.mWebView, LOG_TAG);
        this.mWebView.loadUrl(paramIntent.getStringExtra("extra_url"));
        this.mWebView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2) {
                Log.w(MraidBrowser.LOG_TAG, "MRAID error: %s", new Object[]{paramAnonymousString1});
            }

            public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString) {
                if (paramAnonymousString == null) {
                }
                while ((!paramAnonymousString.startsWith("market:")) && (!paramAnonymousString.startsWith("tel:")) && (!paramAnonymousString.startsWith("voicemail:")) && (!paramAnonymousString.startsWith("sms:")) && (!paramAnonymousString.startsWith("mailto:")) && (!paramAnonymousString.startsWith("geo:")) && (!paramAnonymousString.startsWith("google.streetview:"))) {
                    return false;
                }
                try {
                    MraidBrowser.this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString)));
                    return true;
                } catch (ActivityNotFoundException paramAnonymousWebView) {
                    for (; ; ) {
                        Log.w(MraidBrowser.LOG_TAG, "Could not handle intent with URI: %s", new Object[]{paramAnonymousString});
                    }
                }
            }
        });
        this.mWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt) {
                Activity localActivity = (Activity) paramAnonymousWebView.getContext();
                localActivity.setTitle("Loading...");
                localActivity.setProgress(paramAnonymousInt * 100);
                if (paramAnonymousInt == 100) {
                    localActivity.setTitle(paramAnonymousWebView.getUrl());
                }
                MraidBrowser.this.updateNavigationButtons(paramAnonymousWebView);
            }
        });
    }

    private void updateNavigationButtons(WebView paramWebView) {
        if ((this.mBrowserBackButton != null) && (this.mBrowserForwardButton != null)) {
            if (!paramWebView.canGoBack()) {
                break label49;
            }
            AndroidTargetUtils.setImageButtonAlpha(this.mBrowserBackButton, 255);
        }
        while (paramWebView.canGoForward()) {
            AndroidTargetUtils.setImageButtonAlpha(this.mBrowserForwardButton, 255);
            return;
            label49:
            AndroidTargetUtils.setImageButtonAlpha(this.mBrowserBackButton, 102);
        }
        AndroidTargetUtils.setImageButtonAlpha(this.mBrowserForwardButton, 102);
    }

    protected boolean canPauseWebViewTimers() {
        return (getWebView() != null) && (getShouldPauseWebViewTimers());
    }

    protected boolean canResumeWebViewTimers() {
        return (getWebView() != null) && (getShouldPauseWebViewTimers());
    }

    protected boolean getShouldPauseWebViewTimers() {
        return Settings.getInstance().getBoolean("shouldPauseWebViewTimersInWebViewRelatedActivities", false);
    }

    protected WebView getWebView() {
        return this.mWebView;
    }

    protected boolean isAtLeastAndroidAPI(int paramInt) {
        return Build.VERSION.SDK_INT >= paramInt;
    }

    public void onCreate() {
        this.activity.getWindow().requestFeature(2);
        this.activity.getWindow().setFeatureInt(2, -1);
        Intent localIntent = this.activity.getIntent();
        this.showOpenExternalBrowserButton = localIntent.getBooleanExtra("extra_open_btn", false);
        initializeEntireView(localIntent);
        initializeWebView(localIntent);
        enableCookies();
    }

    public void onPause() {
        Log.d(LOG_TAG, "onPause");
        WebView localWebView = getWebView();
        if (isAtLeastAndroidAPI(11)) {
            webViewOnPause(localWebView);
        }
        for (; ; ) {
            if (canPauseWebViewTimers()) {
                localWebView.pauseTimers();
            }
            CookieSyncManager.getInstance().stopSync();
            return;
            Log.w(LOG_TAG, "Unable to call WebView.onPause");
        }
    }

    public void onResume() {
        Log.d(LOG_TAG, "onResume");
        WebView localWebView = getWebView();
        if (isAtLeastAndroidAPI(11)) {
            webViewOnResume(localWebView);
        }
        for (; ; ) {
            if (canResumeWebViewTimers()) {
                localWebView.resumeTimers();
            }
            CookieSyncManager.getInstance().startSync();
            return;
            Log.w(LOG_TAG, "Unable to call WebView.onResume");
        }
    }

    public void onStop() {
    }

    public void preOnCreate() {
    }

    public void setActivity(Activity paramActivity) {
        this.activity = paramActivity;
    }

    protected void webViewOnPause(WebView paramWebView) {
        AndroidTargetUtils.webViewOnPause(paramWebView);
    }

    protected void webViewOnResume(WebView paramWebView) {
        AndroidTargetUtils.webViewOnResume(paramWebView);
    }

    class LoadButtonsTask
            extends AsyncTask<Void, Void, Void> {
        private final int buttonHeight;
        private final int buttonWidth;
        private final Intent intent;
        private final ViewGroup layout;

        public LoadButtonsTask(Intent paramIntent, ViewGroup paramViewGroup, int paramInt1, int paramInt2) {
            this.intent = paramIntent;
            this.layout = paramViewGroup;
            this.buttonWidth = paramInt1;
            this.buttonHeight = paramInt2;
        }

        protected Void doInBackground(Void... paramVarArgs) {
            MraidBrowser.access$302(MraidBrowser.this, MraidBrowser.this.createButton(Assets.getInstance().getFilePath("amazon_ads_leftarrow.png"), 9, -1, this.buttonWidth, this.buttonHeight));
            MraidBrowser.this.mBrowserBackButton.setId(10537);
            MraidBrowser.access$502(MraidBrowser.this, MraidBrowser.this.createButton(Assets.getInstance().getFilePath("amazon_ads_rightarrow.png"), 1, MraidBrowser.this.mBrowserBackButton.getId(), this.buttonWidth, this.buttonHeight));
            MraidBrowser.this.mBrowserForwardButton.setId(10794);
            MraidBrowser.access$602(MraidBrowser.this, MraidBrowser.this.createButton(Assets.getInstance().getFilePath("amazon_ads_close.png"), 11, -1, this.buttonWidth, this.buttonHeight));
            if (MraidBrowser.this.showOpenExternalBrowserButton) {
                MraidBrowser.access$802(MraidBrowser.this, MraidBrowser.this.createButton(Assets.getInstance().getFilePath("amazon_ads_open_external_browser.png"), 1, MraidBrowser.this.mBrowserForwardButton.getId(), this.buttonWidth, this.buttonHeight));
                MraidBrowser.this.mOpenExternalBrowserButton.setId(10795);
                MraidBrowser.access$902(MraidBrowser.this, MraidBrowser.this.createButton(Assets.getInstance().getFilePath("amazon_ads_refresh.png"), 1, MraidBrowser.this.mOpenExternalBrowserButton.getId(), this.buttonWidth, this.buttonHeight));
            }
            for (; ; ) {
                return null;
                MraidBrowser.access$902(MraidBrowser.this, MraidBrowser.this.createButton(Assets.getInstance().getFilePath("amazon_ads_refresh.png"), 1, MraidBrowser.this.mBrowserForwardButton.getId(), this.buttonWidth, this.buttonHeight));
            }
        }

        protected void onPostExecute(Void paramVoid) {
            this.layout.addView(MraidBrowser.this.mBrowserBackButton);
            this.layout.addView(MraidBrowser.this.mBrowserForwardButton);
            this.layout.addView(MraidBrowser.this.mRefreshButton);
            this.layout.addView(MraidBrowser.this.mCloseButton);
            if (MraidBrowser.this.showOpenExternalBrowserButton) {
                this.layout.addView(MraidBrowser.this.mOpenExternalBrowserButton);
            }
            MraidBrowser.this.initializeButtons(this.intent);
        }
    }

    static class MraidBrowserBuilder {
        private static final String LOGTAG = MraidBrowserBuilder.class.getSimpleName();
        private Context context;
        private boolean showOpenExternalBrowserButton;
        private String url;

        void show() {
            if (this.context == null) {
                throw new IllegalArgumentException("Context must not be null");
            }
            if (Utils.isNullOrWhiteSpace(this.url)) {
                throw new IllegalArgumentException("Url must not be null or white space");
            }
            if (!Assets.getInstance().ensureAssetsCreated()) {
                Log.e(LOGTAG, "Could not load application assets, failed to open URI: %s", new Object[]{this.url});
                return;
            }
            Intent localIntent = new Intent(this.context, AdActivity.class);
            localIntent.putExtra("adapter", MraidBrowser.class.getName());
            localIntent.putExtra("extra_url", this.url);
            localIntent.putExtra("extra_open_btn", this.showOpenExternalBrowserButton);
            localIntent.addFlags(268435456);
            this.context.startActivity(localIntent);
        }

        MraidBrowserBuilder withContext(Context paramContext) {
            this.context = paramContext;
            return this;
        }

        MraidBrowserBuilder withExternalBrowserButton() {
            this.showOpenExternalBrowserButton = true;
            return this;
        }

        MraidBrowserBuilder withUrl(String paramString) {
            this.url = paramString;
            return this;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/MraidBrowser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */