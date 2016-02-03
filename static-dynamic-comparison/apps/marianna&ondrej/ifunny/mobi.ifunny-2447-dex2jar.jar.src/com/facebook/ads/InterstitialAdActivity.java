package com.facebook.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.a.n;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.internal.AdWebViewInterface;
import com.facebook.ads.internal.AdWebViewUtils;
import com.facebook.ads.internal.HtmlAdDataModel;
import com.facebook.ads.internal.HtmlAdHandler;

public class InterstitialAdActivity
        extends Activity {
    private static final int AD_WEBVIEW_ID = 100001;
    private static final String DATA_MODEL_KEY = "dataModel";
    private static final String LAST_REQUESTED_ORIENTATION_KEY = "lastRequestedOrientation";
    private static final int ORIENTATION_REVERSE_LANDSCAPE = 8;
    private static final int ORIENTATION_REVERSE_PORTRAIT = 9;
    private static final String TAG = InterstitialAdActivity.class.getSimpleName();
    private HtmlAdHandler adHandler;
    private WebView adWebView;
    private HtmlAdDataModel dataModel;
    private int displayHeight;
    private int displayWidth;
    private boolean isRestart = false;
    private int lastRequestedOrientation;
    private String placementId;

    private void loadAdFromIntentOrSavedState(Intent paramIntent, Bundle paramBundle) {
        if ((paramBundle != null) && (paramBundle.containsKey("dataModel"))) {
            this.dataModel = HtmlAdDataModel.fromBundle(paramBundle.getBundle("dataModel"));
            if (this.dataModel != null) {
                this.adHandler.setAdDataModel(this.dataModel);
                this.adWebView.loadDataWithBaseURL("https://www.facebook.com/", this.dataModel.getMarkup(), "text/html", "utf-8", null);
            }
            this.lastRequestedOrientation = paramBundle.getInt("lastRequestedOrientation", -1);
            this.placementId = paramBundle.getString("adInterstitialUniqueId");
            this.isRestart = true;
        }
        do {
            return;
            this.displayWidth = paramIntent.getIntExtra("displayWidth", 0);
            this.displayHeight = paramIntent.getIntExtra("displayHeight", 0);
            this.placementId = paramIntent.getStringExtra("adInterstitialUniqueId");
            this.dataModel = HtmlAdDataModel.fromIntentExtra(paramIntent);
        } while (this.dataModel == null);
        this.adHandler.setAdDataModel(this.dataModel);
        this.adWebView.loadDataWithBaseURL("https://www.facebook.com/", this.dataModel.getMarkup(), "text/html", "utf-8", null);
    }

    private void sendBroadcastForEvent(String paramString) {
        paramString = new Intent(paramString);
        paramString.putExtra("adInterstitialUniqueId", this.placementId);
        n.a(this).a(paramString);
    }

    private void setScreenOrientation(int paramInt1, int paramInt2) {
        if (paramInt2 >= paramInt1) {
        }
        for (paramInt1 = 1; ; paramInt1 = 0) {
            paramInt2 = ((WindowManager) getSystemService("window")).getDefaultDisplay().getRotation();
            if (paramInt1 == 0) {
                break;
            }
            switch (paramInt2) {
                default:
                    setRequestedOrientation(1);
                    return;
            }
        }
        setRequestedOrientation(9);
        return;
        switch (paramInt2) {
            default:
                setRequestedOrientation(0);
                return;
        }
        setRequestedOrientation(8);
    }

    public void finish() {
        this.adHandler.cancelImpressionRetry();
        sendBroadcastForEvent("com.facebook.ads.interstitial.dismissed");
        super.finish();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        RelativeLayout localRelativeLayout = new RelativeLayout(this);
        this.adWebView = new WebView(this);
        this.adWebView.setId(100001);
        this.adWebView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        AdWebViewUtils.config(this.adWebView, new InterstitialAdActivity.AdWebViewClient(this, null), new AdWebViewInterface());
        localRelativeLayout.addView(this.adWebView);
        this.adHandler = new HtmlAdHandler(this.adWebView, null, 1000L);
        setContentView(localRelativeLayout, new RelativeLayout.LayoutParams(-1, -1));
        loadAdFromIntentOrSavedState(getIntent(), paramBundle);
        sendBroadcastForEvent("com.facebook.ads.interstitial.displayed");
    }

    public void onRestart() {
        super.onRestart();
        this.isRestart = true;
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        if (this.dataModel != null) {
            paramBundle.putBundle("dataModel", this.dataModel.saveToBundle());
        }
        paramBundle.putInt("lastRequestedOrientation", this.lastRequestedOrientation);
        paramBundle.putString("adInterstitialUniqueId", this.placementId);
    }

    public void onStart() {
        super.onStart();
        if (!this.isRestart) {
            setScreenOrientation(this.displayWidth, this.displayHeight);
        }
        for (; ; ) {
            this.isRestart = false;
            return;
            if (this.lastRequestedOrientation >= 0) {
                setRequestedOrientation(this.lastRequestedOrientation);
                this.lastRequestedOrientation = -1;
            }
        }
    }

    public void setRequestedOrientation(int paramInt) {
        this.lastRequestedOrientation = paramInt;
        super.setRequestedOrientation(paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/InterstitialAdActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */