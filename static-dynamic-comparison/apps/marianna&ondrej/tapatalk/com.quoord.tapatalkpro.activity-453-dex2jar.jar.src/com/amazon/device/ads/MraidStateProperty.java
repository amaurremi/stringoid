package com.amazon.device.ads;

import java.util.Locale;

class MraidStateProperty
        extends MraidProperty {
    private final MraidView.ViewState mViewState;

    MraidStateProperty(MraidView.ViewState paramViewState) {
        this.mViewState = paramViewState;
    }

    public static MraidStateProperty createWithViewState(MraidView.ViewState paramViewState) {
        return new MraidStateProperty(paramViewState);
    }

    public String toJsonPair() {
        return "state: '" + this.mViewState.toString().toLowerCase(Locale.US) + "'";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/MraidStateProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */