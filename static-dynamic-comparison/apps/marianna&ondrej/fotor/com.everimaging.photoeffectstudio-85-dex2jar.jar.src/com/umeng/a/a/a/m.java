package com.umeng.a.a.a;

import com.umeng.a.a.a.b.b.a;
import com.umeng.a.a.a.b.h;
import com.umeng.a.a.a.d.a;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

public class m {
    private final ByteArrayOutputStream a = new ByteArrayOutputStream();
    private final a b = new a(this.a);
    private h c;

    public m() {
        this(new b.a());
    }

    public m(com.umeng.a.a.a.b.j paramj) {
        this.c = paramj.a(this.b);
    }

    public String a(d paramd, String paramString)
            throws j {
        try {
            paramd = new String(a(paramd), paramString);
            return paramd;
        } catch (UnsupportedEncodingException paramd) {
            throw new j("JVM DOES NOT SUPPORT ENCODING: " + paramString);
        }
    }

    public byte[] a(d paramd)
            throws j {
        this.a.reset();
        paramd.b(this.c);
        return this.a.toByteArray();
    }

    public String b(d paramd)
            throws j {
        return new String(a(paramd));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/a/a/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */