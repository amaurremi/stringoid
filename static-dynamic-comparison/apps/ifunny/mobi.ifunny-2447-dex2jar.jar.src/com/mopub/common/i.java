package com.mopub.common;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class i
        extends ByteArrayOutputStream {
    i(h paramh, int paramInt) {
        super(paramInt);
    }

    public String toString() {
        if ((this.count > 0) && (this.buf[(this.count - 1)] == 13)) {
        }
        for (int i = this.count - 1; ; i = this.count) {
            try {
                String str = new String(this.buf, 0, i, h.a(this.a).name());
                return str;
            } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
                throw new AssertionError(localUnsupportedEncodingException);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */