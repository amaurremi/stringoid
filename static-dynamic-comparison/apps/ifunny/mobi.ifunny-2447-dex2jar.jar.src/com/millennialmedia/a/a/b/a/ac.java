package com.millennialmedia.a.a.b.a;

import com.millennialmedia.a.a.aa;
import com.millennialmedia.a.a.ae;
import com.millennialmedia.a.a.d.a;
import com.millennialmedia.a.a.d.c;
import com.millennialmedia.a.a.d.d;

final class ac
        extends ae<Character> {
    public Character a(a parama) {
        if (parama.f() == c.i) {
            parama.j();
            return null;
        }
        parama = parama.h();
        if (parama.length() != 1) {
            throw new aa("Expecting character, got: " + parama);
        }
        return Character.valueOf(parama.charAt(0));
    }

    public void a(d paramd, Character paramCharacter) {
        if (paramCharacter == null) {
        }
        for (paramCharacter = null; ; paramCharacter = String.valueOf(paramCharacter)) {
            paramd.b(paramCharacter);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/a/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */