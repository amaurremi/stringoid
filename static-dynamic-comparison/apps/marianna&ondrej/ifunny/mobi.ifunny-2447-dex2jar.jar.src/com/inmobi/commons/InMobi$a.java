package com.inmobi.commons;

import com.inmobi.commons.analytics.events.AnalyticsEventsWrapper;
import com.inmobi.commons.data.LocationInfo;
import com.inmobi.commons.internal.ApplicationFocusManager.FocusChangedListener;
import com.inmobi.commons.uid.UID;

final class InMobi$a
        implements ApplicationFocusManager.FocusChangedListener {
    public void onFocusChanged(boolean paramBoolean) {
        if (paramBoolean) {
            UID.getInstance().refresh();
            LocationInfo.collectLocationInfo();
            AnalyticsEventsWrapper.getInstance().startSession(InMobi.a(), null);
            return;
        }
        AnalyticsEventsWrapper.getInstance().endSession(null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/InMobi$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */