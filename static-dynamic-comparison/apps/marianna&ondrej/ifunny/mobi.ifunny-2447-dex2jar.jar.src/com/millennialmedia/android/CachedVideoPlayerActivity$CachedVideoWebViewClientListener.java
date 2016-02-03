package com.millennialmedia.android;

import java.lang.ref.WeakReference;

class CachedVideoPlayerActivity$CachedVideoWebViewClientListener
        extends MMWebViewClient.MMWebViewClientListener {
    WeakReference<CachedVideoPlayerActivity> a;

    CachedVideoPlayerActivity$CachedVideoWebViewClientListener(CachedVideoPlayerActivity paramCachedVideoPlayerActivity) {
        this.a = new WeakReference(paramCachedVideoPlayerActivity);
    }

    public void onPageFinished(String paramString) {
        MMLog.b("CachedVideoPlayerActivity", "@@ ON PAGE FINISHED" + paramString);
        CachedVideoPlayerActivity localCachedVideoPlayerActivity = (CachedVideoPlayerActivity) this.a.get();
        if (localCachedVideoPlayerActivity != null) {
            CachedVideoPlayerActivity.a(localCachedVideoPlayerActivity, paramString);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/CachedVideoPlayerActivity$CachedVideoWebViewClientListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */