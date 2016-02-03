package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.ref.SoftReference;

public class hd {
    static final int a = ;
    static final int b = hf.a.a();
    protected static final ThreadLocal<SoftReference<si>> c = new ThreadLocal();
    protected sb d = sb.a();
    protected sa e = sa.a();
    protected hn f;
    protected int g = a;
    protected int h = b;
    protected id i;
    protected if j;
    protected ik k;

    public hd() {
        this(null);
    }

    public hd(hn paramhn) {
        this.f = paramhn;
    }

    public hd a(hj.a parama) {
        this.g |= parama.c();
        return this;
    }

    public hd a(hn paramhn) {
        this.f = paramhn;
        return this;
    }

    public hf a(OutputStream paramOutputStream, hc paramhc)
            throws IOException {
        ie localie = a(paramOutputStream, false);
        localie.a(paramhc);
        if (paramhc == hc.a) {
            paramhc = paramOutputStream;
            if (this.k != null) {
                paramhc = this.k.a(localie, paramOutputStream);
            }
            return a(paramhc, localie);
        }
        paramhc = a(paramOutputStream, paramhc, localie);
        paramOutputStream = paramhc;
        if (this.k != null) {
            paramOutputStream = this.k.a(localie, paramhc);
        }
        return a(paramOutputStream, localie);
    }

    protected hf a(OutputStream paramOutputStream, ie paramie)
            throws IOException {
        paramOutputStream = new hz(paramie, this.h, this.f, paramOutputStream);
        if (this.i != null) {
            paramOutputStream.a(this.i);
        }
        return paramOutputStream;
    }

    public hf a(Writer paramWriter)
            throws IOException {
        ie localie = a(paramWriter, false);
        Writer localWriter = paramWriter;
        if (this.k != null) {
            localWriter = this.k.a(localie, paramWriter);
        }
        return a(localWriter, localie);
    }

    protected hf a(Writer paramWriter, ie paramie)
            throws IOException {
        paramWriter = new ib(paramie, this.h, this.f, paramWriter);
        if (this.i != null) {
            paramWriter.a(this.i);
        }
        return paramWriter;
    }

    public hj a(InputStream paramInputStream)
            throws IOException, hi {
        ie localie = a(paramInputStream, false);
        InputStream localInputStream = paramInputStream;
        if (this.j != null) {
            localInputStream = this.j.a(localie, paramInputStream);
        }
        return a(localInputStream, localie);
    }

    protected hj a(InputStream paramInputStream, ie paramie)
            throws IOException, hi {
        return new hr(paramie, paramInputStream).a(this.g, this.f, this.e, this.d);
    }

    public hj a(Reader paramReader)
            throws IOException, hi {
        ie localie = a(paramReader, false);
        Reader localReader = paramReader;
        if (this.j != null) {
            localReader = this.j.a(localie, paramReader);
        }
        return a(localReader, localie);
    }

    protected hj a(Reader paramReader, ie paramie)
            throws IOException, hi {
        return new hy(paramie, this.g, paramReader, this.f, this.d.a(b(hj.a.j), b(hj.a.i)));
    }

    public hn a() {
        return this.f;
    }

    protected ie a(Object paramObject, boolean paramBoolean) {
        return new ie(b(), paramObject, paramBoolean);
    }

    protected Writer a(OutputStream paramOutputStream, hc paramhc, ie paramie)
            throws IOException {
        if (paramhc == hc.a) {
            return new io(paramie, paramOutputStream);
        }
        return new OutputStreamWriter(paramOutputStream, paramhc.a());
    }

    public si b() {
        Object localObject1 = (SoftReference) c.get();
        if (localObject1 == null) {
        }
        for (localObject1 = null; ; localObject1 = (si) ((SoftReference) localObject1).get()) {
            Object localObject2 = localObject1;
            if (localObject1 == null) {
                localObject2 = new si();
                c.set(new SoftReference(localObject2));
            }
            return (si) localObject2;
        }
    }

    public final boolean b(hj.a parama) {
        return (this.g & parama.c()) != 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/hd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */