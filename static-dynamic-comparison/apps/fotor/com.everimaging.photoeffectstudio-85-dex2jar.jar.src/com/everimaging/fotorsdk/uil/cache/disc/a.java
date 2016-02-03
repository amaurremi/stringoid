package com.everimaging.fotorsdk.uil.cache.disc;

import java.io.File;

public abstract class a
        implements b {
    protected File a;
    private com.everimaging.fotorsdk.uil.cache.disc.naming.a b;

    public a(File paramFile, com.everimaging.fotorsdk.uil.cache.disc.naming.a parama) {
        if (paramFile == null) {
            throw new IllegalArgumentException(String.format("\"%s\" argument must be not null", new Object[]{"cacheDir"}));
        }
        if (parama == null) {
            throw new IllegalArgumentException(String.format("\"%s\" argument must be not null", new Object[]{"fileNameGenerator"}));
        }
        this.a = paramFile;
        this.b = parama;
    }

    public File a(String paramString) {
        paramString = this.b.a(paramString);
        return new File(this.a, paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/cache/disc/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */