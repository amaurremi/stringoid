package com.flurry.sdk;

public class hq
        implements Comparable<hq> {
    private static final hq e = new hq(0, 0, 0, null);
    protected final int a;
    protected final int b;
    protected final int c;
    protected final String d;

    public hq(int paramInt1, int paramInt2, int paramInt3, String paramString) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramInt3;
        this.d = paramString;
    }

    public int a(hq paramhq) {
        int j = this.a - paramhq.a;
        int i = j;
        if (j == 0) {
            j = this.b - paramhq.b;
            i = j;
            if (j == 0) {
                i = this.c - paramhq.c;
            }
        }
        return i;
    }

    public boolean a() {
        return (this.d != null) && (this.d.length() > 0);
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            return true;
            if (paramObject == null) {
                return false;
            }
            if (paramObject.getClass() != getClass()) {
                return false;
            }
            paramObject = (hq) paramObject;
        }
        while ((((hq) paramObject).a == this.a) && (((hq) paramObject).b == this.b) && (((hq) paramObject).c == this.c));
        return false;
    }

    public int hashCode() {
        return this.a + this.b + this.c;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a).append('.');
        localStringBuilder.append(this.b).append('.');
        localStringBuilder.append(this.c);
        if (a()) {
            localStringBuilder.append('-').append(this.d);
        }
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/hq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */