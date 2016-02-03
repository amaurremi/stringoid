package com.mopub.mobileads;

import java.lang.ref.WeakReference;
import java.util.Map;

class AdLoadTask$CustomEventAdLoadTask
        extends AdLoadTask {
    private Map<String, String> mParamsMap;

    public AdLoadTask$CustomEventAdLoadTask(AdViewController paramAdViewController, Map<String, String> paramMap) {
        super(paramAdViewController);
        this.mParamsMap = paramMap;
    }

    void cleanup() {
        this.mParamsMap = null;
    }

    void execute() {
        AdViewController localAdViewController = (AdViewController) this.mWeakAdViewController.get();
        if ((localAdViewController == null) || (localAdViewController.isDestroyed())) {
            return;
        }
        localAdViewController.setNotLoading();
        localAdViewController.getMoPubView().loadCustomEvent(this.mParamsMap);
    }

    @Deprecated
    Map<String, String> getParamsMap() {
        return this.mParamsMap;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/AdLoadTask$CustomEventAdLoadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */