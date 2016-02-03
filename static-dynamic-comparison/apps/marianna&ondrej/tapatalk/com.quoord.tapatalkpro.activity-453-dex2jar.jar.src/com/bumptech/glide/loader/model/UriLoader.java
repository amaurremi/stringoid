package com.bumptech.glide.loader.model;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.loader.stream.LocalUriLoader;
import com.bumptech.glide.loader.stream.StreamLoader;

import java.net.MalformedURLException;
import java.net.URL;

public class UriLoader
        implements ModelLoader<Uri> {
    private final Context context;
    private final ModelLoader<URL> urlLoader;

    public UriLoader(Context paramContext, ModelLoader<URL> paramModelLoader) {
        this.context = paramContext;
        this.urlLoader = paramModelLoader;
    }

    private boolean isLocalUri(String paramString) {
        return ("file".equals(paramString)) || ("content".equals(paramString)) || ("android.resource".equals(paramString));
    }

    public String getId(Uri paramUri) {
        return paramUri.toString();
    }

    public StreamLoader getStreamLoader(Uri paramUri, int paramInt1, int paramInt2) {
        String str = paramUri.getScheme();
        Object localObject3 = null;
        Object localObject1;
        if (isLocalUri(str)) {
            localObject1 = new LocalUriLoader(this.context, paramUri);
        }
        Object localObject2;
        while (localObject1 == null) {
            throw new IllegalArgumentException("No stream loader for uri=" + paramUri);
            if (!"http".equals(str)) {
                localObject1 = localObject3;
                if (!"https".equals(str)) {
                }
            } else {
                try {
                    localObject1 = this.urlLoader.getStreamLoader(new URL(paramUri.toString()), paramInt1, paramInt2);
                } catch (MalformedURLException localMalformedURLException) {
                    localMalformedURLException.printStackTrace();
                    localObject2 = localObject3;
                }
            }
        }
        return (StreamLoader) localObject2;
    }

    public static class Factory
            implements ModelLoaderFactory<Uri> {
        public ModelLoader<Uri> build(Context paramContext, GenericLoaderFactory paramGenericLoaderFactory) {
            return new UriLoader(paramContext, paramGenericLoaderFactory.buildModelLoader(URL.class, paramContext));
        }

        public Class<? extends ModelLoader<Uri>> loaderClass() {
            return UriLoader.class;
        }

        public void teardown() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/loader/model/UriLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */