package com.mopub.mobileads;

import java.lang.ref.WeakReference;

import org.apache.http.HttpResponse;

abstract class AdLoadTask {
    WeakReference<AdViewController> mWeakAdViewController;

    AdLoadTask(AdViewController paramAdViewController) {
        this.mWeakAdViewController = new WeakReference(paramAdViewController);
    }

    static AdLoadTask fromHttpResponse(HttpResponse paramHttpResponse, AdViewController paramAdViewController) {
        return new AdLoadTask.TaskExtractor(paramHttpResponse, paramAdViewController).extract();
    }

    abstract void cleanup();

    abstract void execute();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/AdLoadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */