package com.amazon.device.ads;

import java.util.Map;

class MraidCommandOpen
        extends MraidCommand {
    MraidCommandOpen(Map<String, String> paramMap, MraidView paramMraidView) {
        super(paramMap, paramMraidView);
    }

    void execute() {
        String str = getStringFromParamsForKey("url");
        this.mView.getBrowserController().open(str);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/MraidCommandOpen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */