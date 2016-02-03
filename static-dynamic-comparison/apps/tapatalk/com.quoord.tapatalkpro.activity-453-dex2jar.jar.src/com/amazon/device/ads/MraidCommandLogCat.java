package com.amazon.device.ads;

import java.util.Map;

class MraidCommandLogCat
        extends MraidCommand {
    private static final String MRAID_LOG_TAG = "MRAIDLog";

    MraidCommandLogCat(Map<String, String> paramMap, MraidView paramMraidView) {
        super(paramMap, paramMraidView);
    }

    void execute() {
        int i = getIntFromParamsForKey("level");
        String str = getStringFromParamsForKey("log");
        if (i == -1) {
        }
        while ((str == null) || (str.length() == 0)) {
            return;
        }
        switch (i) {
            case 4:
            default:
                Log.i("MRAIDLog", str);
                return;
            case 3:
                Log.d("MRAIDLog", str);
                return;
            case 2:
                Log.v("MRAIDLog", str);
                return;
            case 5:
                Log.w("MRAIDLog", str);
                return;
        }
        Log.e("MRAIDLog", str);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/MraidCommandLogCat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */