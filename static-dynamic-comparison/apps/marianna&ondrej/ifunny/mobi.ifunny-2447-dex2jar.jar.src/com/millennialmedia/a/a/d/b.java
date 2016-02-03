package com.millennialmedia.a.a.d;

import com.millennialmedia.a.a.b.a.g;
import com.millennialmedia.a.a.b.u;

final class b
        extends u {
    public void a(a parama) {
        if ((parama instanceof g)) {
            ((g) parama).o();
            return;
        }
        int j = a.a(parama);
        int i = j;
        if (j == 0) {
            i = a.b(parama);
        }
        if (i == 13) {
            a.a(parama, 9);
            return;
        }
        if (i == 12) {
            a.a(parama, 8);
            return;
        }
        if (i == 14) {
            a.a(parama, 10);
            return;
        }
        throw new IllegalStateException("Expected a name but was " + parama.f() + " " + " at line " + a.c(parama) + " column " + a.d(parama));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */