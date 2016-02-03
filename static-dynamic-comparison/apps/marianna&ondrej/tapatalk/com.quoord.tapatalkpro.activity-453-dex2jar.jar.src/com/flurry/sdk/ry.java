package com.flurry.sdk;

import java.io.IOException;

public final class ry
        extends rz {
    static final ry c = new ry("");
    final String d;

    public ry(String paramString) {
        this.d = paramString;
    }

    protected static void a(StringBuilder paramStringBuilder, String paramString) {
        paramStringBuilder.append('"');
        sk.a(paramStringBuilder, paramString);
        paramStringBuilder.append('"');
    }

    public static ry b(String paramString) {
        if (paramString == null) {
            return null;
        }
        if (paramString.length() == 0) {
            return c;
        }
        return new ry(paramString);
    }

    public double a(double paramDouble) {
        return ii.a(this.d, paramDouble);
    }

    public final void a(hf paramhf, jw paramjw)
            throws IOException, hk {
        if (this.d == null) {
            paramhf.f();
            return;
        }
        paramhf.b(this.d);
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1;
        if (paramObject == this) {
            bool1 = true;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramObject == null);
            bool1 = bool2;
        } while (paramObject.getClass() != getClass());
        return ((ry) paramObject).d.equals(this.d);
    }

    public boolean f() {
        return true;
    }

    public int hashCode() {
        return this.d.hashCode();
    }

    public String i() {
        return this.d;
    }

    public String n() {
        return this.d;
    }

    public String toString() {
        int i = this.d.length();
        StringBuilder localStringBuilder = new StringBuilder((i >> 4) + (i + 2));
        a(localStringBuilder, this.d);
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */