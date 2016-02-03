package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.os.Handler;
import android.view.View;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

final class IAmraidWebView
        extends IAbaseWebView
        implements InneractiveInternalBrowserActivity.a {
    private IAadConfig mAdConfig;
    boolean mClicked;
    private l mGestDetector;
    private Handler mHandler;
    private boolean mHasFiredReadyEvent = false;
    private InneractiveInternalBrowserActivity mInternalBrowserActivity;
    private boolean mIsVisible;
    private IAmraidWebView.c mListenerInfo;
    private IAmraidWebViewController mMraidController;
    private final IAmraidWebView.MraidPlacementType mPlacementType;
    private U mWebViewClient;

    IAmraidWebView(Context paramContext, IAadConfig paramIAadConfig, IAmraidWebView.MraidPlacementType paramMraidPlacementType) {
        super(paramContext);
        this.mPlacementType = paramMraidPlacementType;
        this.mHandler = new Handler();
        this.mAdConfig = paramIAadConfig;
        this.mGestDetector = new l(paramContext, this, paramIAadConfig);
        this.mGestDetector.a(this);
        if (getVisibility() == 0) {
            bool = true;
        }
        this.mIsVisible = bool;
        addCloseHTML5VideoInterface();
        addUriJavascriptInterface();
    }

    private void postHandlerRunnable(Runnable paramRunnable) {
        this.mHandler.post(paramRunnable);
    }

    final void addCloseHTML5VideoInterface() {
        addJavascriptInterface(new IAmraidWebView.b(this), "InneractiveCloseHTML5VideoInterface");
    }

    final void addUriJavascriptInterface() {
        addJavascriptInterface(new IAmraidWebView.a(this), "UriJavascriptInterface");
    }

    final void closeHTML5VideoFullScreenViaJS() {
        loadUrl("javascript:(function() { \n\twindow.console.log('Exiting HTML5 video full-screen!'); \n\tvar videos = document.getElementsByTagName('video'); \n\tvar removeListreners = function(video) { \n\t\tvideo.removeEventListener('ended'); \n\t}; \n\t \n\tif (videos.length > 0) { \n\t\tvar video = videos[0]; \n\t\tif (video != null) { \n\t\t\twindow.console.log('Got <video> instance! Pausing.'); \n\t\t\tvideo.pause(); \n\t\t} else { \n\t\t\twindow.console.log('video reference is null!'); \n\t\t} \n\t} \n\tif (typeof InneractiveCloseHTML5VideoInterface !== 'undefined') {InneractiveCloseHTML5VideoInterface.closeHTML5Video();console.log('closing HTML 5 video natively');} \n})();");
    }

    public final void destroy() {
        this.mMraidController.destroy();
        super.destroy();
    }

    protected final void fireChangeEventForAsset(G paramG) {
        paramG = "{" + paramG.toString() + "}";
        injectJavaScript("window.mraidbridge.fireChangeEvent(" + paramG + ");");
        InneractiveAdView.Log.v("Inneractive_verbose", "Fire changes: " + paramG);
    }

    protected final void fireChangeEventForAssets(ArrayList paramArrayList) {
        paramArrayList = paramArrayList.toString();
        if (paramArrayList.length() < 2) {
            return;
        }
        paramArrayList = "{" + paramArrayList.substring(1, paramArrayList.length() - 1) + "}";
        injectJavaScript("window.mraidbridge.fireChangeEvent(" + paramArrayList + ");");
        InneractiveAdView.Log.v("Inneractive_verbose", "Fire changes: " + paramArrayList);
    }

    protected final void fireErrorEvent(IAmraidActionFactory.MraidJavascriptCommand paramMraidJavascriptCommand, String paramString) {
        paramMraidJavascriptCommand = paramMraidJavascriptCommand.a();
        injectJavaScript("window.mraidbridge.fireErrorEvent('" + paramMraidJavascriptCommand + "', '" + paramString + "');");
    }

    protected final void fireNativeCommandCompleteEvent(String paramString) {
        injectJavaScript("window.mraidbridge.nativeCallComplete('" + paramString + "');");
    }

    protected final void fireReadyEvent() {
        injectJavaScript("window.mraidbridge.fireReadyEvent();");
    }

    final IAadConfig getAdConfig() {
        return this.mAdConfig;
    }

    protected final InneractiveInternalBrowserActivity getBrowserController() {
        return this.mInternalBrowserActivity;
    }

    final boolean getIsVisible() {
        return this.mIsVisible;
    }

    public final V getListener() {
        return IAmraidWebView.c.access$200(this.mListenerInfo);
    }

    protected final IAmraidWebViewController getMraidWebViewController() {
        return this.mMraidController;
    }

    final IAmraidWebView.d getOnCloseButtonStateChangeListener() {
        return IAmraidWebView.c.access$300(this.mListenerInfo);
    }

    final U getmWebViewClient() {
        return this.mWebViewClient;
    }

    final void initialize(IAmraidWebView.ExpandMode paramExpandMode, IAmraidWebView.NativeCloseButtonMode paramNativeCloseButtonMode) {
        setScrollContainer(false);
        setOnTouchListener(new IAmraidWebView .1 (this));
        this.mInternalBrowserActivity = new InneractiveInternalBrowserActivity();
        InneractiveInternalBrowserActivity.a(this);
        this.mMraidController = new IAmraidWebViewController(this, paramExpandMode, paramNativeCloseButtonMode);
        this.mListenerInfo = new IAmraidWebView.c();
        this.mWebViewClient = new U(this);
        setWebViewClient(this.mWebViewClient);
    }

    protected final void injectJavaScript(String paramString) {
        if (paramString != null) {
            super.loadUrl("javascript:" + paramString);
        }
    }

    final void onAdReadyDOM() {
        if (getVisibility() == 0) {
        }
        for (boolean bool = true; ; bool = false) {
            this.mIsVisible = bool;
            fireChangeEventForAsset(M.a(this.mIsVisible));
            return;
        }
    }

    final void onAdReadyWindowOnLoad() {
        if (getVisibility() == 0) {
        }
        for (boolean bool = true; ; bool = false) {
            this.mIsVisible = bool;
            fireChangeEventForAsset(M.a(this.mIsVisible));
            if (!this.mHasFiredReadyEvent) {
                this.mMraidController.initializeJavaScriptState();
                fireChangeEventForAsset(new I(this.mPlacementType));
                fireReadyEvent();
                if (getListener() != null) {
                    getListener().onReady(this);
                }
            }
            this.mHasFiredReadyEvent = true;
            return;
        }
    }

    public final void onApplicationInBackground() {
        if (getListener() != null) {
            getListener().onAdWillOpenExternalApp();
        }
    }

    public final void onInternalBrowserDismissed() {
        if (getListener() != null) {
            getListener().onInternalBrowserDismissed();
        }
    }

    protected final void onVisibilityChanged(View paramView, int paramInt) {
        super.onVisibilityChanged(paramView, paramInt);
        if (paramInt == 0) {
        }
        for (boolean bool = true; ; bool = false) {
            if (bool != this.mIsVisible) {
                this.mIsVisible = bool;
                if (this.mHasFiredReadyEvent) {
                    fireChangeEventForAsset(M.a(this.mIsVisible));
                }
            }
            return;
        }
    }

    public final void setListener(V paramV) {
        IAmraidWebView.c.access$202(this.mListenerInfo, paramV);
    }

    final void setOnCloseButtonStateChange(IAmraidWebView.d paramd) {
        IAmraidWebView.c.access$302(this.mListenerInfo, paramd);
    }

    final boolean tryCommand(URI paramURI) {
        String str = paramURI.getHost();
        Object localObject = URLEncodedUtils.parse(paramURI, "UTF-8");
        paramURI = new HashMap();
        localObject = ((List) localObject).iterator();
        while (((Iterator) localObject).hasNext()) {
            NameValuePair localNameValuePair = (NameValuePair) ((Iterator) localObject).next();
            paramURI.put(localNameValuePair.getName(), localNameValuePair.getValue());
        }
        paramURI = IAmraidActionFactory.a(str, paramURI, this);
        if (paramURI == null) {
            fireNativeCommandCompleteEvent(str);
            return false;
        }
        if ((paramURI.a(this.mPlacementType)) && (!wasClicked())) {
            return false;
        }
        paramURI.a();
        fireNativeCommandCompleteEvent(str);
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAmraidWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */