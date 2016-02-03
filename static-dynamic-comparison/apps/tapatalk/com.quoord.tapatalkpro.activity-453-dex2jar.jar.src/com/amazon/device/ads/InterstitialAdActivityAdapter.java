package com.amazon.device.ads;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

class InterstitialAdActivityAdapter
        implements IAdActivityAdapter, AdView {
    private final int CLOSE_BUTTON_SIZE_DP = 60;
    private final int CLOSE_BUTTON_TAP_TARGET_SIZE_DP = 80;
    private Activity activity = null;
    private String uniqueId = null;

    private void addNativeCloseButton(final FrameLayout paramFrameLayout) {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager) this.activity.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        final int i = (int) (60.0F * localDisplayMetrics.density + 0.5F);
        final int j = (int) (80.0F * localDisplayMetrics.density + 0.5F);
        ThreadUtils.executeAsyncTask(new AsyncTask() {
            protected RelativeLayout doInBackground(Void... paramAnonymousVarArgs) {
                paramAnonymousVarArgs = new RelativeLayout(paramFrameLayout.getContext());
                final ImageButton localImageButton = new ImageButton(paramFrameLayout.getContext());
                localImageButton.setImageDrawable(this.val$closeNormal);
                localImageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
                localImageButton.setBackgroundDrawable(null);
                Object localObject = new View.OnClickListener() {
                    public void onClick(View paramAnonymous2View) {
                        InterstitialAdActivityAdapter.this.activity.finish();
                    }
                };
                localImageButton.setOnClickListener((View.OnClickListener) localObject);
                paramAnonymousVarArgs.setOnClickListener((View.OnClickListener) localObject);
                localObject = new View.OnTouchListener() {
                    public boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent) {
                        switch (paramAnonymous2MotionEvent.getAction()) {
                        }
                        for (; ; ) {
                            return false;
                            localImageButton.setImageDrawable(InterstitialAdActivityAdapter .1. this.val$closePressed);
                            continue;
                            localImageButton.setImageDrawable(InterstitialAdActivityAdapter .1. this.val$closeNormal);
                        }
                    }
                };
                paramAnonymousVarArgs.setOnTouchListener((View.OnTouchListener) localObject);
                localImageButton.setOnTouchListener((View.OnTouchListener) localObject);
                localObject = new RelativeLayout.LayoutParams(i, i);
                ((RelativeLayout.LayoutParams) localObject).addRule(13);
                paramAnonymousVarArgs.addView(localImageButton, (ViewGroup.LayoutParams) localObject);
                return paramAnonymousVarArgs;
            }

            protected void onPostExecute(RelativeLayout paramAnonymousRelativeLayout) {
                FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(j, j, 5);
                localLayoutParams.topMargin = 0;
                localLayoutParams.rightMargin = 0;
                paramFrameLayout.addView(paramAnonymousRelativeLayout, localLayoutParams);
            }
        }, new Void[0]);
    }

    private void sendBroadcast(String paramString) {
        Intent localIntent = new Intent("amazon.mobile.ads.interstitial");
        localIntent.putExtra("action", paramString);
        localIntent.putExtra("uniqueIdentifier", this.uniqueId);
        this.activity.sendBroadcast(localIntent);
    }

    Activity getActivity() {
        return this.activity;
    }

    public int getHeight() {
        return 0;
    }

    public AdWebViewClient.UrlExecutor getSpecialUrlExecutor() {
        return new AdWebViewClient.AmazonMobileExecutor(this, this.activity);
    }

    public boolean isAdViewRenderable() {
        return true;
    }

    public boolean launchExternalBrowserForLink(String paramString) {
        if (isAdViewRenderable()) {
            return AdUtils.launchActivityForIntentLink(paramString, this.activity);
        }
        return false;
    }

    public void onCreate() {
        WebView localWebView = WebViewFactory.getInstance().createWebView(this.activity);
        if (DeviceInfo.getUserAgentString() == null) {
            DeviceInfo.setUserAgentString(localWebView.getSettings().getUserAgentString());
        }
        this.uniqueId = this.activity.getIntent().getStringExtra("uniqueIdentifier");
        String str = this.activity.getIntent().getStringExtra("creative").replace("<head>", "<head>\n  <script type='text/javascript'>\n  function fireImpression(a) {\n    var container = document.createElement('div');\n    var pix = document.createElement('img');\n    pix.setAttribute('src', a);\n    pix.style.position = 'absolute';\n    pix.style.top = '0px';\n    pix.style.right = '0px';\n    pix.style.display = 'none';\n    container.appendChild(pix);\n    document.body.appendChild(container);\n  }\n  </script>\n");
        MraidView localMraidView = MraidView.removeCachedMraidView(this.uniqueId);
        if (localMraidView == null) {
            localWebView.setBackgroundColor(0);
            localMraidView = new MraidView(this, this.activity, localWebView);
        }
        for (; ; ) {
            localMraidView.loadHtmlData("http://amazon-adsystem.amazon.com/", str);
            addNativeCloseButton(localMraidView);
            this.activity.setContentView(localMraidView);
            return;
            localMraidView.registerReceivers();
            localMraidView.setAdView(this);
        }
    }

    public void onPageFinished() {
        sendBroadcast("finished");
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onStop() {
        if (this.activity.isFinishing()) {
            sendBroadcast("dismissed");
        }
    }

    public void preOnCreate() {
        this.activity.requestWindowFeature(1);
        this.activity.getWindow().setFlags(1024, 1024);
        if (Build.VERSION.SDK_INT > 11) {
            AndroidTargetUtils.hideActionAndStatusBars(this.activity);
        }
    }

    public void setActivity(Activity paramActivity) {
        this.activity = paramActivity;
    }

    public boolean shouldDisableWebViewHardwareAcceleration() {
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/InterstitialAdActivityAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */