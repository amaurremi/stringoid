package com.inmobi.commons.internal;

import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector;
import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector.ThinIceDataCollectedListener;

final class ThinICE$c
        implements IceDataCollector.ThinIceDataCollectedListener {
    public void onDataCollected() {
        if (ThinICE.b()) {
            ThinICE.a(false);
            ThinICE.a();
            IceDataCollector.start(InternalSDKUtil.getContext());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/internal/ThinICE$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */