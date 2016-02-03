package com.androidquery.util;

import java.io.ByteArrayOutputStream;

public class PredefinedBAOS
        extends ByteArrayOutputStream {
    public PredefinedBAOS(int paramInt) {
        super(paramInt);
    }

    public byte[] toByteArray() {
        if (this.count == this.buf.length) {
            return this.buf;
        }
        return super.toByteArray();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/androidquery/util/PredefinedBAOS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */