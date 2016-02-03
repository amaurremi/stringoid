package com.bumptech.glide.loader.model;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.loader.stream.StreamLoader;

import java.io.File;

public class StringLoader
        implements ModelLoader<String> {
    private final ModelLoader<Uri> uriLoader;

    public StringLoader(ModelLoader<Uri> paramModelLoader) {
        this.uriLoader = paramModelLoader;
    }

    public String getId(String paramString) {
        return paramString;
    }

    public StreamLoader getStreamLoader(String paramString, int paramInt1, int paramInt2) {
        Uri localUri2 = Uri.parse(paramString);
        Uri localUri1 = localUri2;
        if (localUri2.getScheme() == null) {
            localUri1 = Uri.fromFile(new File(paramString));
        }
        return this.uriLoader.getStreamLoader(localUri1, paramInt1, paramInt2);
    }

    public static class Factory
            implements ModelLoaderFactory<String> {
        public ModelLoader<String> build(Context paramContext, GenericLoaderFactory paramGenericLoaderFactory) {
            return new StringLoader(paramGenericLoaderFactory.buildModelLoader(Uri.class, paramContext));
        }

        public Class<? extends ModelLoader<String>> loaderClass() {
            return StringLoader.class;
        }

        public void teardown() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/loader/model/StringLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */