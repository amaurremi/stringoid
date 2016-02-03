package com.bumptech.glide.resize.cache;

import com.jakewharton.disklrucache.DiskLruCache;
import com.jakewharton.disklrucache.DiskLruCache.Editor;
import com.jakewharton.disklrucache.DiskLruCache.Snapshot;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class DiskLruCacheWrapper
        implements DiskCache {
    private static final int APP_VERSION = 1;
    private static DiskLruCache CACHE = null;
    private static final int VALUE_COUNT = 1;
    private static DiskLruCacheWrapper WRAPPER = null;
    private final DiskLruCache diskLruCache;

    protected DiskLruCacheWrapper(DiskLruCache paramDiskLruCache) {
        this.diskLruCache = paramDiskLruCache;
    }

    public static DiskCache get(File paramFile, int paramInt)
            throws IOException {
        try {
            if (WRAPPER == null) {
                WRAPPER = new DiskLruCacheWrapper(getDiskLruCache(paramFile, paramInt));
            }
            paramFile = WRAPPER;
            return paramFile;
        } finally {
        }
    }

    private static DiskLruCache getDiskLruCache(File paramFile, int paramInt)
            throws IOException {
        try {
            if (CACHE == null) {
                CACHE = DiskLruCache.open(paramFile, 1, 1, paramInt);
            }
            paramFile = CACHE;
            return paramFile;
        } finally {
        }
    }

    public void delete(String paramString) {
        try {
            this.diskLruCache.remove(paramString);
            return;
        } catch (IOException paramString) {
            paramString.printStackTrace();
        }
    }

    public InputStream get(String paramString) {
        Object localObject = null;
        try {
            DiskLruCache.Snapshot localSnapshot = this.diskLruCache.get(paramString);
            paramString = (String) localObject;
            if (localSnapshot != null) {
                paramString = localSnapshot.getInputStream(0);
            }
            return paramString;
        } catch (IOException paramString) {
            paramString.printStackTrace();
        }
        return null;
    }

    public void put(String paramString, DiskCache.Writer paramWriter) {
        try {
            paramString = this.diskLruCache.edit(paramString);
            if (paramString != null) {
                paramWriter.write(paramString.newOutputStream(0));
                paramString.commit();
            }
            return;
        } catch (IOException paramString) {
            paramString.printStackTrace();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/resize/cache/DiskLruCacheWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */