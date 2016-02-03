package org.b.e;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.Arrays;

import org.b.c;
import org.b.c.e;

class j
        extends d {
    private static j a = new j(new byte[0], true);
    private static final ThreadLocal<CharsetDecoder> b = new k();
    private byte[] c;

    j(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        this.c = new byte[paramInt2];
        System.arraycopy(paramArrayOfByte, paramInt1, this.c, 0, paramInt2);
    }

    j(byte[] paramArrayOfByte, boolean paramBoolean) {
        if (paramBoolean) {
            this.c = paramArrayOfByte;
            return;
        }
        this.c = new byte[paramArrayOfByte.length];
        System.arraycopy(paramArrayOfByte, 0, this.c, 0, paramArrayOfByte.length);
    }

    public static v n() {
        return a;
    }

    public void a(e parame) {
        parame.a(this.c);
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1;
        if (this == paramObject) {
            bool1 = true;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (!(paramObject instanceof ae));
            paramObject = (ae) paramObject;
            bool1 = bool2;
        } while (!((ae) paramObject).h());
        return Arrays.equals(this.c, ((ae) paramObject).m().o());
    }

    public int hashCode() {
        return Arrays.hashCode(this.c);
    }

    public byte[] o() {
        return this.c;
    }

    public String p() {
        Object localObject = (CharsetDecoder) b.get();
        try {
            localObject = ((CharsetDecoder) localObject).decode(ByteBuffer.wrap(this.c)).toString();
            return (String) localObject;
        } catch (CharacterCodingException localCharacterCodingException) {
            throw new c(localCharacterCodingException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/e/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */