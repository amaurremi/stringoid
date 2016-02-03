package com.flurry.sdk;

public class hx
        extends hl {
    protected final hx c;
    protected String d;
    protected hx e = null;

    protected hx(int paramInt, hx paramhx) {
        this.a = paramInt;
        this.c = paramhx;
        this.b = -1;
    }

    private final hx a(int paramInt) {
        this.a = paramInt;
        this.b = -1;
        this.d = null;
        return this;
    }

    public static hx g() {
        return new hx(0, null);
    }

    public final int a(String paramString) {
        if ((this.a != 2) || (this.d != null)) {
            return 4;
        }
        this.d = paramString;
        if (this.b < 0) {
            return 0;
        }
        return 1;
    }

    protected final void a(StringBuilder paramStringBuilder) {
        if (this.a == 2) {
            paramStringBuilder.append('{');
            if (this.d != null) {
                paramStringBuilder.append('"');
                paramStringBuilder.append(this.d);
                paramStringBuilder.append('"');
            }
            for (; ; ) {
                paramStringBuilder.append('}');
                return;
                paramStringBuilder.append('?');
            }
        }
        if (this.a == 1) {
            paramStringBuilder.append('[');
            paramStringBuilder.append(f());
            paramStringBuilder.append(']');
            return;
        }
        paramStringBuilder.append("/");
    }

    public final hx h() {
        hx localhx = this.e;
        if (localhx == null) {
            localhx = new hx(1, this);
            this.e = localhx;
            return localhx;
        }
        return localhx.a(1);
    }

    public final hx i() {
        hx localhx = this.e;
        if (localhx == null) {
            localhx = new hx(2, this);
            this.e = localhx;
            return localhx;
        }
        return localhx.a(2);
    }

    public final hx j() {
        return this.c;
    }

    public final int k() {
        int i = 0;
        if (this.a == 2) {
            if (this.d == null) {
                i = 5;
            }
        }
        do {
            int j;
            do {
                return i;
                this.d = null;
                this.b += 1;
                return 2;
                if (this.a != 1) {
                    break;
                }
                j = this.b;
                this.b += 1;
            } while (j < 0);
            return 1;
            this.b += 1;
        } while (this.b == 0);
        return 3;
    }

    public final String toString() {
        StringBuilder localStringBuilder = new StringBuilder(64);
        a(localStringBuilder);
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/hx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */