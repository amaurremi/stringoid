package com.everimaging.fotorsdk.uil.core.assist;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class b
        extends FilterInputStream {
    public b(InputStream paramInputStream) {
        super(paramInputStream);
    }

    public long skip(long paramLong)
            throws IOException {
        long l2;
        for (long l1 = 0L; ; l1 = l2 + l1) {
            if (l1 < paramLong) {
                long l3 = this.in.skip(paramLong - l1);
                l2 = l3;
                if (l3 != 0L) {
                    continue;
                }
                if (read() >= 0) {
                }
            } else {
                return l1;
            }
            l2 = 1L;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/core/assist/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */