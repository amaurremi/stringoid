package com.everimaging.fotorsdk.uil.cache.disc.impl;

import java.io.File;

public class b
        extends com.everimaging.fotorsdk.uil.cache.disc.c {
    public b(File paramFile, int paramInt) {
        this(paramFile, com.everimaging.fotorsdk.uil.core.a.a(), paramInt);
    }

    public b(File paramFile, com.everimaging.fotorsdk.uil.cache.disc.naming.a parama, int paramInt) {
        super(paramFile, parama, paramInt);
        if (paramInt < 2097152) {
            com.everimaging.fotorsdk.uil.utils.c.c("You set too small disc cache size (less than %1$d Mb)", new Object[]{Integer.valueOf(2)});
        }
    }

    protected int a(File paramFile) {
        return (int) paramFile.length();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/cache/disc/impl/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */