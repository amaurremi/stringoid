package com.mopub.mobileads;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import com.mopub.common.util.VersionCode;
import com.mopub.common.util.Views;
import com.mopub.mobileads.util.WebViews;

public class BaseWebView
        extends WebView {
    protected boolean mIsDestroyed;

    public BaseWebView(Context paramContext) {
        super(paramContext.getApplicationContext());
        enablePlugins(false);
        WebViews.setDisableJSChromeClient(this);
    }

    public void destroy() {
        this.mIsDestroyed = true;
        Views.removeFromParent(this);
        super.destroy();
    }

    protected void enablePlugins(boolean paramBoolean) {
        if (VersionCode.currentApiLevel().isAtLeast(VersionCode.JELLY_BEAN_MR2)) {
            return;
        }
        if (paramBoolean) {
            getSettings().setPluginState(WebSettings.PluginState.ON);
            return;
        }
        getSettings().setPluginState(WebSettings.PluginState.OFF);
    }

    @Deprecated
    void setIsDestroyed(boolean paramBoolean) {
        this.mIsDestroyed = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/BaseWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */