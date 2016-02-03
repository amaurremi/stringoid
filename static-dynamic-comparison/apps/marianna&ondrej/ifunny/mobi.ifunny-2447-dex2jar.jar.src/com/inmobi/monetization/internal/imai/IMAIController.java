package com.inmobi.monetization.internal.imai;

import android.os.Build.VERSION;
import android.webkit.JavascriptInterface;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.internal.ApiStatCollector;
import com.inmobi.commons.internal.ApiStatCollector.ApiEventType;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.EventLog;
import com.inmobi.commons.metric.Logger;
import com.inmobi.re.container.IMWebView;

import java.lang.ref.WeakReference;

public class IMAIController {
    public static final String IMAI_BRIDGE = "imaiController";
    private transient WeakReference<IMWebView> a;
    private IMAIController.InterstitialAdStateListener b;

    public IMAIController(IMWebView paramIMWebView) {
        IMAICore.initialize();
        this.a = new WeakReference(paramIMWebView);
    }

    @JavascriptInterface
    public void fireAdFailed() {
        if (this.b != null) {
            this.b.onAdFailed();
        }
    }

    @JavascriptInterface
    public void fireAdReady() {
        if (this.b != null) {
            this.b.onAdReady();
        }
    }

    @JavascriptInterface
    public String getPlatformVersion() {
        Log.debug("[InMobi]-[Monetization]", "get platform version");
        return Integer.toString(Build.VERSION.SDK_INT);
    }

    @JavascriptInterface
    public String getSdkVersion() {
        Log.debug("[InMobi]-[Monetization]", "get sdk version");
        return InMobi.getVersion();
    }

    @JavascriptInterface
    public void log(String paramString) {
        Log.debug("[InMobi]-[Monetization]", paramString);
    }

    @JavascriptInterface
    public void openEmbedded(String paramString) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(1001), null));
        try {
            Log.debug("[InMobi]-[Monetization]", "IMAI open Embedded");
            if (!IMAICore.validateURL(paramString)) {
                IMAICore.fireErrorEvent(this.a, "Null url passed", "openEmbedded", paramString);
                return;
            }
            if ((paramString.startsWith("http")) || (paramString.startsWith("https"))) {
                IMAICore.launchEmbeddedBrowser(this.a, paramString);
                IMAICore.fireOpenEmbeddedSuccessful(this.a, paramString);
                return;
            }
        } catch (Exception localException) {
            IMAICore.fireErrorEvent(this.a, localException.getMessage(), "openEmbedded", paramString);
            Log.internal("[InMobi]-[Monetization]", "IMAI openEmbedded failed", localException);
            return;
        }
        openExternal(paramString);
    }

    @JavascriptInterface
    public void openExternal(String paramString) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(1002), null));
        try {
            Log.debug("[InMobi]-[Monetization]", "IMAI open external");
            if (!IMAICore.validateURL(paramString)) {
                IMAICore.fireErrorEvent(this.a, "Null url passed", "openExternal", paramString);
                return;
            }
            IMAICore.launchExternalApp(paramString);
            IMAICore.fireOpenExternalSuccessful(this.a, paramString);
            return;
        } catch (Exception localException) {
            IMAICore.fireErrorEvent(this.a, localException.getMessage(), "openExternal", paramString);
            Log.internal("[InMobi]-[Monetization]", "IMAI openExternal failed", localException);
        }
    }

    @JavascriptInterface
    public void ping(String paramString, boolean paramBoolean) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(1003), null));
        try {
            Log.debug("[InMobi]-[Monetization]", "IMAI ping");
            if (!IMAICore.validateURL(paramString)) {
                IMAICore.fireErrorEvent(this.a, "Null url passed", "ping", paramString);
                return;
            }
            if ((paramString.contains("http")) || (paramString.contains("https"))) {
                IMAICore.ping(this.a, paramString, paramBoolean);
                return;
            }
        } catch (Exception localException) {
            IMAICore.fireErrorEvent(this.a, localException.getMessage(), "ping", paramString);
            Log.internal("[InMobi]-[Monetization]", "IMAI ping failed", localException);
            return;
        }
        IMAICore.fireErrorEvent(this.a, "Invalid url passed", "ping", paramString);
    }

    @JavascriptInterface
    public void pingInWebView(String paramString, boolean paramBoolean) {
        ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector.ApiEventType(1004), null));
        try {
            Log.debug("[InMobi]-[Monetization]", "IMAI ping in webview");
            if (!IMAICore.validateURL(paramString)) {
                IMAICore.fireErrorEvent(this.a, "Null url passed", "pingInWebView", paramString);
                return;
            }
            if ((paramString.contains("http")) || (paramString.contains("https"))) {
                IMAICore.pingInWebview(this.a, paramString, paramBoolean);
                return;
            }
        } catch (Exception localException) {
            IMAICore.fireErrorEvent(this.a, localException.getMessage(), "pingInWebView", paramString);
            Log.internal("[InMobi]-[Monetization]", "IMAI pingInWebView failed", localException);
            return;
        }
        IMAICore.fireErrorEvent(this.a, "Invalid url passed", "pingInWebView", paramString);
    }

    public void setInterstitialAdStateListener(IMAIController.InterstitialAdStateListener paramInterstitialAdStateListener) {
        this.b = paramInterstitialAdStateListener;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/imai/IMAIController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */