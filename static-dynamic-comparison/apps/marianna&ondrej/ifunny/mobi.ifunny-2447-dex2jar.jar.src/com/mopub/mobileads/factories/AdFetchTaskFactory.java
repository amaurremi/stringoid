package com.mopub.mobileads.factories;

import com.mopub.mobileads.AdFetchTask;
import com.mopub.mobileads.AdViewController;
import com.mopub.mobileads.TaskTracker;

public class AdFetchTaskFactory {
    protected static AdFetchTaskFactory a = new AdFetchTaskFactory();

    public static AdFetchTask create(TaskTracker paramTaskTracker, AdViewController paramAdViewController, String paramString, int paramInt) {
        return a.a(paramTaskTracker, paramAdViewController, paramString, paramInt);
    }

    @Deprecated
    public static void setInstance(AdFetchTaskFactory paramAdFetchTaskFactory) {
        a = paramAdFetchTaskFactory;
    }

    protected AdFetchTask a(TaskTracker paramTaskTracker, AdViewController paramAdViewController, String paramString, int paramInt) {
        return new AdFetchTask(paramTaskTracker, paramAdViewController, paramString, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/factories/AdFetchTaskFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */