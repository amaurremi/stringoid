package com.millennialmedia.android;

import java.io.File;
import java.io.FileFilter;

class CachedAd$1
        implements FileFilter {
    CachedAd$1(CachedAd paramCachedAd) {
    }

    public boolean accept(File paramFile) {
        return (paramFile.isFile()) && (paramFile.getName().startsWith(CachedAd.a(this.a)));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/CachedAd$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */