package org.b.e;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.b.c;
import org.b.c.e;

class ac
        extends d {
    private String a;

    ac(String paramString) {
        this.a = paramString;
    }

    public void a(e parame) {
        parame.a(this.a);
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
        if (paramObject.getClass() == ac.class) {
            return this.a.equals(((ac) paramObject).a);
        }
        return Arrays.equals(o(), ((ae) paramObject).m().o());
    }

    public byte[] o() {
        try {
            byte[] arrayOfByte = this.a.getBytes("UTF-8");
            return arrayOfByte;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            throw new c(localUnsupportedEncodingException);
        }
    }

    public String p() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/e/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */