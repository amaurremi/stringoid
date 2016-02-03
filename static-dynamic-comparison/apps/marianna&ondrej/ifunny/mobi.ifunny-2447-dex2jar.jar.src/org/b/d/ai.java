package org.b.d;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class ai
        extends a<String> {
    static final ai a = new ai();

    public static ai a() {
        return a;
    }

    public String a(q paramq, String paramString, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        return paramq.r();
    }

    public void a(e parame, String paramString, boolean paramBoolean) {
        if (paramString == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        parame.a(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */