package org.b.e;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

final class k
        extends ThreadLocal<CharsetDecoder> {
    protected CharsetDecoder a() {
        return Charset.forName("UTF-8").newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/e/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */