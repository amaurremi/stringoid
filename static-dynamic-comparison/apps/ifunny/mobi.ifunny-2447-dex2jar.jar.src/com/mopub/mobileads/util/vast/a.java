package com.mopub.mobileads.util.vast;

import com.mopub.mobileads.VastVideoDownloadTask.VastVideoDownloadTaskListener;

class a
        implements VastVideoDownloadTask.VastVideoDownloadTaskListener {
    a(VastManager paramVastManager, VastVideoConfiguration paramVastVideoConfiguration) {
    }

    public void onComplete(boolean paramBoolean) {
        if ((paramBoolean) && (VastManager.a(this.b, this.a))) {
            if (VastManager.a(this.b) != null) {
                VastManager.a(this.b).onVastVideoConfigurationPrepared(this.a);
            }
        }
        while (VastManager.a(this.b) == null) {
            return;
        }
        VastManager.a(this.b).onVastVideoConfigurationPrepared(null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/util/vast/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */