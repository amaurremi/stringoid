package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface ex<ObjectType> {
    public abstract ObjectType a(InputStream paramInputStream)
            throws IOException;

    public abstract void a(OutputStream paramOutputStream, ObjectType paramObjectType)
            throws IOException;
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/flurry/sdk/ex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */