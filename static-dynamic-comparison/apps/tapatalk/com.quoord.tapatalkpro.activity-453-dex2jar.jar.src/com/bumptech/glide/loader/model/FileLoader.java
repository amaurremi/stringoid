package com.bumptech.glide.loader.model;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.loader.stream.StreamLoader;

import java.io.File;

public class FileLoader
        implements ModelLoader<File> {
    private final ModelLoader<Uri> uriLoader;

    public FileLoader(ModelLoader<Uri> paramModelLoader) {
        this.uriLoader = paramModelLoader;
    }

    public String getId(File paramFile) {
        return paramFile.getAbsolutePath();
    }

    public StreamLoader getStreamLoader(File paramFile, int paramInt1, int paramInt2) {
        return this.uriLoader.getStreamLoader(Uri.fromFile(paramFile), paramInt1, paramInt2);
    }

    public static class Factory
            implements ModelLoaderFactory<File> {
        public ModelLoader<File> build(Context paramContext, GenericLoaderFactory paramGenericLoaderFactory) {
            return new FileLoader(paramGenericLoaderFactory.buildModelLoader(Uri.class, paramContext));
        }

        public Class<? extends ModelLoader<File>> loaderClass() {
            return FileLoader.class;
        }

        public void teardown() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/loader/model/FileLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */