package com.mopub.mobileads.factories;

import com.mopub.mobileads.VastVideoDownloadTask;
import com.mopub.mobileads.VastVideoDownloadTask.VastVideoDownloadTaskListener;

public class VastVideoDownloadTaskFactory {
    private static VastVideoDownloadTaskFactory a = new VastVideoDownloadTaskFactory();

    public static VastVideoDownloadTask create(VastVideoDownloadTask.VastVideoDownloadTaskListener paramVastVideoDownloadTaskListener) {
        return a.a(paramVastVideoDownloadTaskListener);
    }

    @Deprecated
    public static void setInstance(VastVideoDownloadTaskFactory paramVastVideoDownloadTaskFactory) {
        a = paramVastVideoDownloadTaskFactory;
    }

    protected VastVideoDownloadTask a(VastVideoDownloadTask.VastVideoDownloadTaskListener paramVastVideoDownloadTaskListener) {
        return new VastVideoDownloadTask(paramVastVideoDownloadTaskListener);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/factories/VastVideoDownloadTaskFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */