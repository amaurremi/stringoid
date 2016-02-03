package com.amazon.device.ads;

import android.net.Uri;

class MraidBrowserController
        extends MraidAbstractController {
    private static final String LOGTAG = "MraidBrowserController";

    MraidBrowserController(MraidView paramMraidView) {
        super(paramMraidView);
    }

    protected void executeAmazonMobileCallback(MraidView paramMraidView, String paramString) {
        if (paramMraidView.getOnSpecialUrlClickListener() != null) {
            if (paramMraidView.getDisplayController().isExpanded()) {
                paramMraidView.getDisplayController().close();
            }
            paramMraidView.getOnSpecialUrlClickListener().onSpecialUrlClick(paramMraidView, paramString);
        }
    }

    protected void open(String paramString) {
        MraidView localMraidView = getView();
        if ((paramString == null) || (paramString.length() == 0)) {
            Log.e("MraidBrowserController", "URI cannot be null or empty");
            return;
        }
        Log.d("MraidBrowserController", "Opening in-app browser: %s", new Object[]{paramString});
        Object localObject1 = Uri.parse(paramString);
        if ((((Uri) localObject1).getScheme() != null) && (((Uri) localObject1).getScheme().equals("amazonmobile"))) {
            executeAmazonMobileCallback(localMraidView, paramString);
            return;
        }
        Object localObject2;
        try {
            localObject1 = ((Uri) localObject1).getQueryParameter("d.url");
            localObject2 = localObject1;
            if (localObject1 == null) {
                localObject2 = paramString;
            }
            if (((String) localObject2).startsWith("amazonmobile:")) {
                executeAmazonMobileCallback(localMraidView, (String) localObject2);
                return;
            }
        } catch (UnsupportedOperationException localUnsupportedOperationException) {
            Log.e("MraidBrowserController", "Could not open non-hierarchical URI: %s", new Object[]{paramString});
            return;
        }
        if (localMraidView.getOnOpenListener() != null) {
            localMraidView.getOnOpenListener().onOpen(localMraidView);
        }
        if ((((String) localObject2).startsWith("http:")) || (((String) localObject2).startsWith("https:"))) {
            new MraidBrowser.MraidBrowserBuilder().withContext(getView().getContext()).withUrl((String) localObject2).withExternalBrowserButton().show();
            return;
        }
        localMraidView.adView.launchExternalBrowserForLink((String) localObject2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/MraidBrowserController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */