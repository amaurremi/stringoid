package com.facebook;

final class AppEventsLogger$7
        implements Request.Callback {
    AppEventsLogger$7(AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair, Request paramRequest, AppEventsLogger.SessionEventsState paramSessionEventsState, AppEventsLogger.FlushStatistics paramFlushStatistics) {
    }

    public void onCompleted(Response paramResponse) {
        AppEventsLogger.access$900(this.val$accessTokenAppId, this.val$postRequest, paramResponse, this.val$sessionEventsState, this.val$flushState);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/AppEventsLogger$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */