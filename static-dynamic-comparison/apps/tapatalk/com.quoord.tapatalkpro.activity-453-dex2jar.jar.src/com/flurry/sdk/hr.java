package com.flurry.sdk;

import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public final class hr {
    protected final ie a;
    protected final InputStream b;
    protected final byte[] c;
    protected int d;
    protected boolean e = true;
    protected int f = 0;
    private int g;
    private int h;
    private final boolean i;

    public hr(ie paramie, InputStream paramInputStream) {
        this.a = paramie;
        this.b = paramInputStream;
        this.c = paramie.e();
        this.g = 0;
        this.h = 0;
        this.d = 0;
        this.i = true;
    }

    private void a(String paramString)
            throws IOException {
        throw new CharConversionException("Unsupported UCS-4 endianness (" + paramString + ") detected");
    }

    private boolean b(int paramInt)
            throws IOException {
        switch (paramInt) {
        }
        int j;
        for (; ; ) {
            j = paramInt >>> 16;
            if (j != 65279) {
                break;
            }
            this.g += 2;
            this.f = 2;
            this.e = true;
            return true;
            this.e = true;
            this.g += 4;
            this.f = 4;
            return true;
            this.g += 4;
            this.f = 4;
            this.e = false;
            return true;
            a("2143");
            a("3412");
        }
        if (j == 65534) {
            this.g += 2;
            this.f = 2;
            this.e = false;
            return true;
        }
        if (paramInt >>> 8 == 15711167) {
            this.g += 3;
            this.f = 1;
            this.e = true;
            return true;
        }
        return false;
    }

    private boolean c(int paramInt)
            throws IOException {
        boolean bool = false;
        if (paramInt >> 8 == 0) {
            this.e = true;
        }
        for (; ; ) {
            this.f = 4;
            bool = true;
            do {
                return bool;
                if ((0xFFFFFF & paramInt) == 0) {
                    this.e = false;
                    break;
                }
                if ((0xFF00FFFF & paramInt) == 0) {
                    a("3412");
                    break;
                }
            } while ((0xFFFF00FF & paramInt) != 0);
            a("2143");
        }
    }

    private boolean d(int paramInt) {
        boolean bool = false;
        if ((0xFF00 & paramInt) == 0) {
        }
        for (this.e = true; ; this.e = false) {
            this.f = 2;
            bool = true;
            do {
                return bool;
            } while ((paramInt & 0xFF) != 0);
        }
    }

    public hc a()
            throws IOException, hi {
        int k = 1;
        int m;
        int j;
        hc localhc;
        if (a(4)) {
            m = this.c[this.g] << 24 | (this.c[(this.g + 1)] & 0xFF) << 16 | (this.c[(this.g + 2)] & 0xFF) << 8 | this.c[(this.g + 3)] & 0xFF;
            if (b(m)) {
                j = k;
                if (j != 0) {
                    break label188;
                }
                localhc = hc.a;
            }
        }
        for (; ; ) {
            this.a.a(localhc);
            return localhc;
            j = k;
            if (c(m)) {
                break;
            }
            j = k;
            if (d(m >>> 16)) {
                break;
            }
            do {
                j = 0;
                break;
            } while ((!a(2)) || (!d((this.c[this.g] & 0xFF) << 8 | this.c[(this.g + 1)] & 0xFF)));
            j = k;
            break;
            label188:
            switch (this.f) {
                case 3:
                default:
                    throw new RuntimeException("Internal error");
                case 1:
                    localhc = hc.a;
                    break;
                case 2:
                    if (this.e) {
                        localhc = hc.b;
                    } else {
                        localhc = hc.c;
                    }
                    break;
                case 4:
                    if (this.e) {
                        localhc = hc.d;
                    } else {
                        localhc = hc.e;
                    }
                    break;
            }
        }
    }

    public hj a(int paramInt, hn paramhn, sa paramsa, sb paramsb)
            throws IOException, hi {
        hc localhc = a();
        boolean bool1 = hj.a.j.a(paramInt);
        boolean bool2 = hj.a.i.a(paramInt);
        if ((localhc == hc.a) && (bool1)) {
            paramsa = paramsa.a(bool1, bool2);
            return new ia(this.a, paramInt, this.b, paramhn, paramsa, this.c, this.g, this.h, this.i);
        }
        return new hy(this.a, paramInt, b(), paramhn, paramsb.a(bool1, bool2));
    }

    protected boolean a(int paramInt)
            throws IOException {
        boolean bool2 = true;
        int k;
        for (int j = this.h - this.g; ; j = k + j) {
            boolean bool1 = bool2;
            if (j < paramInt) {
                if (this.b != null) {
                    break label42;
                }
            }
            label42:
            for (k = -1; k < 1; k = this.b.read(this.c, this.h, this.c.length - this.h)) {
                bool1 = false;
                return bool1;
            }
            this.h += k;
        }
    }

    public Reader b()
            throws IOException {
        hc localhc = this.a.b();
        switch (1. a[localhc.ordinal()])
        {
            default:
                throw new RuntimeException("Internal error");
            case 1:
            case 2:
                return new in(this.a, this.b, this.c, this.g, this.h, this.a.b().b());
        }
        Object localObject = this.b;
        if (localObject == null) {
            localObject = new ByteArrayInputStream(this.c, this.g, this.h);
        }
        for (; ; ) {
            return new InputStreamReader((InputStream) localObject, localhc.a());
            if (this.g < this.h) {
                localObject = new ih(this.a, (InputStream) localObject, this.c, this.g, this.h);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/hr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */