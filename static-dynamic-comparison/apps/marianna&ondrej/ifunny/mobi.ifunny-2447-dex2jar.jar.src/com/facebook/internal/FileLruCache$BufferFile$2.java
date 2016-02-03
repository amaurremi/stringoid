package com.facebook.internal;

import java.io.File;
import java.io.FilenameFilter;

final class FileLruCache$BufferFile$2
        implements FilenameFilter {
    public boolean accept(File paramFile, String paramString) {
        return paramString.startsWith("buffer");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/FileLruCache$BufferFile$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */