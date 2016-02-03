package com.bumptech.glide.loader.model;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.loader.stream.StreamLoader;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class UrlModelLoader<T>
        implements ModelLoader<T> {
    private final ModelLoader<URL> concreteLoader;
    private final Cache<URL> modelCache;

    public UrlModelLoader(Context paramContext) {
        this(paramContext, null);
    }

    public UrlModelLoader(Context paramContext, Cache<URL> paramCache) {
        this(Glide.buildModelLoader(URL.class, paramContext), paramCache);
    }

    public UrlModelLoader(ModelLoader<URL> paramModelLoader) {
        this(paramModelLoader, null);
    }

    public UrlModelLoader(ModelLoader<URL> paramModelLoader, Cache<URL> paramCache) {
        this.concreteLoader = paramModelLoader;
        this.modelCache = paramCache;
    }

    public StreamLoader getStreamLoader(T paramT, int paramInt1, int paramInt2) {
        String str1 = getId(paramT);
        if (this.modelCache != null) {
        }
        for (Object localObject = (URL) this.modelCache.get(str1, paramInt1, paramInt2); ; localObject = null) {
            if (localObject == null) {
                String str2 = getUrl(paramT, paramInt1, paramInt2);
                try {
                    URL localURL = new URL(str2);
                    localObject = localURL;
                } catch (MalformedURLException localMalformedURLException) {
                    for (; ; ) {
                        localMalformedURLException.printStackTrace();
                    }
                    paramT = (T) localObject;
                    if (this.modelCache == null) {
                        break label134;
                    }
                    this.modelCache.put(str1, paramInt1, paramInt2, localObject);
                    paramT = (T) localObject;
                }
                if (localObject == null) {
                    throw new IllegalArgumentException("Invalid URL for model=" + paramT + " url=" + str2);
                }
            }
            for (; ; ) {
                label134:
                return this.concreteLoader.getStreamLoader(paramT, paramInt1, paramInt2);
                paramT = (T) localObject;
            }
        }
    }

    protected abstract String getUrl(T paramT, int paramInt1, int paramInt2);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/loader/model/UrlModelLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */