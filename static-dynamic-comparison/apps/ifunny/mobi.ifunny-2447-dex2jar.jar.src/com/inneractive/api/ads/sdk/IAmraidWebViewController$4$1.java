package com.inneractive.api.ads.sdk;

final class IAmraidWebViewController$4$1
        implements Runnable {
    IAmraidWebViewController$4$1(IAmraidWebViewController.4param4) {
    }

    public final void run() {
        IAmraidWebViewController.access$200(this.this$1.this$0, "Image failed to download.");
        this.this$1.this$0.getView().fireErrorEvent(IAmraidActionFactory.MraidJavascriptCommand.j, "Error downloading and saving image file.");
        InneractiveAdView.Log.d("Inneractive_debug", "failed to download and save the image file.");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAmraidWebViewController$4$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */