package mobi.ifunny.util;

import java.io.ByteArrayOutputStream;

public class ag
        extends ByteArrayOutputStream {
    public ag() {
        super(8192);
    }

    public byte[] toByteArray() {
        try {
            byte[] arrayOfByte = this.buf;
            return arrayOfByte;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */