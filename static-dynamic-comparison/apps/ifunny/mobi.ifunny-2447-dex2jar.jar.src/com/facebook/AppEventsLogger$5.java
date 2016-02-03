package com.facebook;

import android.content.Context;

final class AppEventsLogger$5
        implements Runnable {
    AppEventsLogger$5(Context paramContext, AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair, AppEventsLogger.AppEvent paramAppEvent) {
    }

    public void run() {
        AppEventsLogger.access$600(this.val$context, this.val$accessTokenAppId).addEvent(this.val$event);
        AppEventsLogger.access$700();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/AppEventsLogger$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */