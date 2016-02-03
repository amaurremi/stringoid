package com.flurry.sdk;

import android.content.Context;

import java.io.File;
import java.util.List;
import java.util.Map;

public class cy {
    private static final String b = cy.class.getSimpleName();
    boolean a;
    private final cz c = new cz();
    private final File d;
    private String e;

    public cy() {
        this( do.a().b());
    }

    public cy(Context paramContext) {
        this.d = paramContext.getFileStreamPath(".flurryinstallreceiver.");
        eo.a(3, b, "Referrer file name if it exists:  " + this.d);
    }

    private void b() {
        if (this.a) {
            return;
        }
        this.a = true;
        eo.a(4, b, "Loading referrer info from file: " + this.d.getAbsolutePath());
        String str = fd.c(this.d);
        eo.a(b, "Referrer file contents: " + str);
        b(str);
    }

    private void b(String paramString) {
        if (paramString == null) {
            return;
        }
        this.e = paramString;
    }

    private void c() {
        fd.a(this.d, this.e);
    }

    public Map<String, List<String>> a(boolean paramBoolean) {
        try {
            b();
            Map localMap = this.c.a(this.e);
            if (paramBoolean) {
                a();
            }
            return localMap;
        } finally {
        }
    }

    public void a() {
        try {
            this.d.delete();
            this.e = null;
            this.a = true;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void a(String paramString) {
        try {
            this.a = true;
            b(paramString);
            c();
            return;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */