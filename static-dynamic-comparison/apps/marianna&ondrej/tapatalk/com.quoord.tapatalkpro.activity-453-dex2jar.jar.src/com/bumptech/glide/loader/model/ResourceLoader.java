package com.bumptech.glide.loader.model;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.loader.stream.StreamLoader;

public class ResourceLoader
        implements ModelLoader<Integer> {
    private final Context context;
    private final ModelLoader<Uri> uriLoader;

    public ResourceLoader(Context paramContext, ModelLoader<Uri> paramModelLoader) {
        this.context = paramContext;
        this.uriLoader = paramModelLoader;
    }

    public String getId(Integer paramInteger) {
        return paramInteger.toString();
    }

    public StreamLoader getStreamLoader(Integer paramInteger, int paramInt1, int paramInt2) {
        paramInteger = Uri.parse("android.resource://" + this.context.getPackageName() + "/" + paramInteger.toString());
        return this.uriLoader.getStreamLoader(paramInteger, paramInt1, paramInt2);
    }

    public static class Factory
            implements ModelLoaderFactory<Integer> {
        public ModelLoader<Integer> build(Context paramContext, GenericLoaderFactory paramGenericLoaderFactory) {
            return new ResourceLoader(paramContext, paramGenericLoaderFactory.buildModelLoader(Uri.class, paramContext));
        }

        public Class<? extends ModelLoader<Integer>> loaderClass() {
            return ResourceLoader.class;
        }

        public void teardown() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/loader/model/ResourceLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */