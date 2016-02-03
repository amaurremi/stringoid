package com.facebook.internal;

import java.security.InvalidParameterException;

public final class FileLruCache$Limits {
    private int byteCount = 1048576;
    private int fileCount = 1024;

    int getByteCount() {
        return this.byteCount;
    }

    int getFileCount() {
        return this.fileCount;
    }

    void setByteCount(int paramInt) {
        if (paramInt < 0) {
            throw new InvalidParameterException("Cache byte-count limit must be >= 0");
        }
        this.byteCount = paramInt;
    }

    void setFileCount(int paramInt) {
        if (paramInt < 0) {
            throw new InvalidParameterException("Cache file count limit must be >= 0");
        }
        this.fileCount = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/FileLruCache$Limits.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */