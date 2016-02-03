package com.flurry.sdk;

import java.io.IOException;
import java.util.Arrays;

public final class rm
        extends rz {
    static final rm c = new rm(new byte[0]);
    final byte[] d;

    public rm(byte[] paramArrayOfByte) {
        this.d = paramArrayOfByte;
    }

    public static rm a(byte[] paramArrayOfByte) {
        if (paramArrayOfByte == null) {
            return null;
        }
        if (paramArrayOfByte.length == 0) {
            return c;
        }
        return new rm(paramArrayOfByte);
    }

    public final void a(hf paramhf, jw paramjw)
            throws IOException, hk {
        paramhf.a(this.d);
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
        return Arrays.equals(((rm) paramObject).d, this.d);
    }

    public int hashCode() {
        if (this.d == null) {
            return -1;
        }
        return this.d.length;
    }

    public String n() {
        return hb.a().a(this.d, false);
    }

    public String toString() {
        return hb.a().a(this.d, true);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/rm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */