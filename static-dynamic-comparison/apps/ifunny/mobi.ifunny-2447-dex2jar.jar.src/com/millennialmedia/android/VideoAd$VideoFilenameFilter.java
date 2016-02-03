package com.millennialmedia.android;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.ref.WeakReference;

class VideoAd$VideoFilenameFilter
        implements FilenameFilter {
    private WeakReference<VideoAd> a;

    public VideoAd$VideoFilenameFilter(VideoAd paramVideoAd) {
        this.a = new WeakReference(paramVideoAd);
    }

    public boolean accept(File paramFile, String paramString) {
        paramFile = (VideoAd) this.a.get();
        if (paramFile != null) {
            paramFile = paramFile.e();
            if (paramFile == null) {
                return false;
            }
            return paramString.startsWith(paramFile);
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/VideoAd$VideoFilenameFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */