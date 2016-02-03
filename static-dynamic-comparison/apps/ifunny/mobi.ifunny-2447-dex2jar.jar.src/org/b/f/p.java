package org.b.f;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

import org.b.c;

final class p
        extends b {
    String a;
    private CharsetDecoder b = Charset.forName("UTF-8").newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);

    public p() {
        super("raw value");
    }

    void a() {
        this.a = "";
    }

    public void a(ByteBuffer paramByteBuffer, boolean paramBoolean) {
        try {
            this.a = this.b.decode(paramByteBuffer).toString();
            return;
        } catch (CharacterCodingException paramByteBuffer) {
            throw new c(paramByteBuffer);
        }
    }

    void a(byte[] paramArrayOfByte) {
        try {
            this.a = this.b.decode(ByteBuffer.wrap(paramArrayOfByte)).toString();
            return;
        } catch (CharacterCodingException paramArrayOfByte) {
            throw new c(paramArrayOfByte);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/f/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */