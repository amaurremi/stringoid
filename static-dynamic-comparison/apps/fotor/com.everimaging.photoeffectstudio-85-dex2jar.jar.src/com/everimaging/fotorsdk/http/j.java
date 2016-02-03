package com.everimaging.fotorsdk.http;

import java.io.File;

import org.apache.http.client.methods.HttpUriRequest;

public abstract class j
        extends g {
    private long c;
    private boolean d;

    public void a(HttpUriRequest paramHttpUriRequest) {
        if ((this.a.exists()) && (this.a.canWrite())) {
            this.c = this.a.length();
        }
        if (this.c > 0L) {
            this.d = true;
            paramHttpUriRequest.setHeader("Range", "bytes=" + this.c + "-");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/http/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */