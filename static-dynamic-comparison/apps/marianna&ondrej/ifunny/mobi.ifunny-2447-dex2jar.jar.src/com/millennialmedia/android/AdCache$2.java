package com.millennialmedia.android;

import java.io.File;
import java.io.FileFilter;

final class AdCache$2
        implements FileFilter {
    public boolean accept(File paramFile) {
        return (!paramFile.isDirectory()) && (paramFile.getName().endsWith("ad.dat"));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/AdCache$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */