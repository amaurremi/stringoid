package org.b.d;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class j
        extends a<Character> {
    static final j a = new j();

    public static j a() {
        return a;
    }

    public Character a(q paramq, Character paramCharacter, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        return Character.valueOf((char) paramq.l());
    }

    public void a(e parame, Character paramCharacter, boolean paramBoolean) {
        if (paramCharacter == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        parame.a(paramCharacter.charValue());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */