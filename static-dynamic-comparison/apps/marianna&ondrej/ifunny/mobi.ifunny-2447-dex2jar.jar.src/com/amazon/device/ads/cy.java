package com.amazon.device.ads;

public class cy
        implements ar {
    final String LOG_TAG;

    public cy() {
        this(cy.class.getSimpleName());
    }

    cy(String paramString) {
        this.LOG_TAG = paramString;
    }

    public void onAdCollapsed(aa paramaa) {
        dv.b(this.LOG_TAG, "Default ad listener called - Ad Collapsed.");
    }

    public void onAdDismissed(aa paramaa) {
        dv.b(this.LOG_TAG, "Default ad listener called - Ad Dismissed.");
    }

    public void onAdExpanded(aa paramaa) {
        dv.b(this.LOG_TAG, "Default ad listener called - Ad Will Expand.");
    }

    public void onAdFailedToLoad(aa paramaa, aj paramaj) {
        dv.a(this.LOG_TAG, "Default ad listener called - Ad Failed to Load. Error code: %s, Error Message: %s", new Object[]{paramaj.a(), paramaj.b()});
    }

    public void onAdLoaded(aa paramaa, bd parambd) {
        dv.b(this.LOG_TAG, "Default ad listener called - AdLoaded.");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */