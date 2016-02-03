package com.everimaging.fotorsdk.http;

import java.io.IOException;
import java.net.URI;

import org.apache.http.Header;
import org.apache.http.HttpResponse;

public abstract interface m {
    public abstract void a(URI paramURI);

    public abstract void a(HttpResponse paramHttpResponse)
            throws IOException;

    public abstract void a(boolean paramBoolean);

    public abstract void a(Header[] paramArrayOfHeader);

    public abstract boolean a();

    public abstract void b(int paramInt);

    public abstract void b(int paramInt1, int paramInt2);

    public abstract void b(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable);

    public abstract void f();

    public abstract void g();

    public abstract void h();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/http/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */