package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JsonCreator;
import com.flurry.org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

public class hg
        implements Serializable {
    public static final hg a = new hg("N/A", -1L, -1L, -1, -1);
    final long b;
    final long c;
    final int d;
    final int e;
    final Object f;

    public hg(Object paramObject, long paramLong, int paramInt1, int paramInt2) {
        this(paramObject, -1L, paramLong, paramInt1, paramInt2);
    }

    @JsonCreator
    public hg(@JsonProperty("sourceRef") Object paramObject, @JsonProperty("byteOffset") long paramLong1, @JsonProperty("charOffset") long paramLong2, @JsonProperty("lineNr") int paramInt1, @JsonProperty("columnNr") int paramInt2) {
        this.f = paramObject;
        this.b = paramLong1;
        this.c = paramLong2;
        this.d = paramInt1;
        this.e = paramInt2;
    }

    public long a() {
        return this.b;
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = true;
        boolean bool3 = false;
        if (paramObject == this) {
            bool1 = true;
        }
        do {
            do {
                do {
                    return bool1;
                    bool1 = bool3;
                } while (paramObject == null);
                bool1 = bool3;
            } while (!(paramObject instanceof hg));
            paramObject = (hg) paramObject;
            if (this.f != null) {
                break;
            }
            bool1 = bool3;
        } while (((hg) paramObject).f != null);
        if ((this.d == ((hg) paramObject).d) && (this.e == ((hg) paramObject).e) && (this.c == ((hg) paramObject).c) && (a() == ((hg) paramObject).a())) {
        }
        for (boolean bool1 = bool2; ; bool1 = false) {
            return bool1;
            if (this.f.equals(((hg) paramObject).f)) {
                break;
            }
            return false;
        }
    }

    public int hashCode() {
        if (this.f == null) {
        }
        for (int i = 1; ; i = this.f.hashCode()) {
            return ((i ^ this.d) + this.e ^ (int) this.c) + (int) this.b;
        }
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder(80);
        localStringBuilder.append("[Source: ");
        if (this.f == null) {
            localStringBuilder.append("UNKNOWN");
        }
        for (; ; ) {
            localStringBuilder.append("; line: ");
            localStringBuilder.append(this.d);
            localStringBuilder.append(", column: ");
            localStringBuilder.append(this.e);
            localStringBuilder.append(']');
            return localStringBuilder.toString();
            localStringBuilder.append(this.f.toString());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/hg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */