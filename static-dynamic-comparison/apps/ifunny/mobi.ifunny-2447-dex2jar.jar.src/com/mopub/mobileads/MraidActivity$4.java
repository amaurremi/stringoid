package com.mopub.mobileads;

class MraidActivity$4
        implements MraidView.OnCloseButtonStateChangeListener {
    MraidActivity$4(MraidActivity paramMraidActivity) {
    }

    public void onCloseButtonStateChange(MraidView paramMraidView, boolean paramBoolean) {
        if (paramBoolean) {
            this.this$0.showInterstitialCloseButton();
            return;
        }
        this.this$0.hideInterstitialCloseButton();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidActivity$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */