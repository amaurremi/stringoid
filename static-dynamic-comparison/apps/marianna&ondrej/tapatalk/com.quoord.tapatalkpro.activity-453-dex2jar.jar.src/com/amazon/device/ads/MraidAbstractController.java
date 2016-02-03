package com.amazon.device.ads;

class MraidAbstractController {
    private final MraidView mView;

    MraidAbstractController(MraidView paramMraidView) {
        this.mView = paramMraidView;
    }

    public MraidView getView() {
        return this.mView;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/MraidAbstractController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */