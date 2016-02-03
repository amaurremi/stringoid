package org.b.e;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

abstract class d
        extends e
        implements v {
    private static final char[] a = "0123456789ABCDEF".toCharArray();

    private void a(StringBuilder paramStringBuilder, int paramInt) {
        paramStringBuilder.append("\\u");
        paramStringBuilder.append(a[(paramInt >> 12 & 0xF)]);
        paramStringBuilder.append(a[(paramInt >> 8 & 0xF)]);
        paramStringBuilder.append(a[(paramInt >> 4 & 0xF)]);
        paramStringBuilder.append(a[(paramInt & 0xF)]);
    }

    public StringBuilder a(StringBuilder paramStringBuilder) {
        Object localObject;
        int j;
        label24:
        int i;
        if (getClass() == ac.class) {
            localObject = p();
            paramStringBuilder.append("\"");
            j = 0;
            if (j >= ((String) localObject).length()) {
                break label299;
            }
            i = ((String) localObject).charAt(j);
            if (i >= 32) {
                break label207;
            }
            switch (i) {
                case 11:
                default:
                    a(paramStringBuilder, i);
            }
        }
        for (; ; ) {
            j += 1;
            break label24;
            localObject = Charset.forName("UTF-8").newDecoder().onMalformedInput(CodingErrorAction.IGNORE).onUnmappableCharacter(CodingErrorAction.IGNORE);
            try {
                localObject = ((CharsetDecoder) localObject).decode(ByteBuffer.wrap(o())).toString();
            } catch (CharacterCodingException localCharacterCodingException) {
                String str = new String(o());
            }
            break;
            paramStringBuilder.append("\\n");
            continue;
            paramStringBuilder.append("\\r");
            continue;
            paramStringBuilder.append("\\t");
            continue;
            paramStringBuilder.append("\\f");
            continue;
            paramStringBuilder.append("\\b");
            continue;
            label207:
            if (i <= 127) {
                switch (i) {
                    default:
                        paramStringBuilder.append(i);
                        break;
                    case 92:
                        paramStringBuilder.append("\\\\");
                        break;
                    case 34:
                        paramStringBuilder.append("\\\"");
                        break;
                }
            } else if ((i >= 55296) && (i <= 57343)) {
                a(paramStringBuilder, i);
            } else {
                paramStringBuilder.append(i);
            }
        }
        label299:
        paramStringBuilder.append("\"");
        return paramStringBuilder;
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
        return Arrays.equals(o(), ((ae) paramObject).m().o());
    }

    public boolean h() {
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(o());
    }

    public v m() {
        return this;
    }

    public String toString() {
        return a(new StringBuilder()).toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */