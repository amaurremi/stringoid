package com.inmobi.commons.internal;

import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector;

final class ThinICE$b
        implements ApplicationFocusManager.FocusChangedListener {
    public void onFocusChanged(boolean paramBoolean) {
        if (paramBoolean) {
            Log.internal("[InMobi]-4.5.1", "App comes in foreground");
            ThinICE.a(true);
            IceDataCollector.start(InternalSDKUtil.getContext());
            return;
        }
        Log.internal("[InMobi]-4.5.1", "App goes in background");
        ThinICE.a(false);
        ThinICE.a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/internal/ThinICE$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */