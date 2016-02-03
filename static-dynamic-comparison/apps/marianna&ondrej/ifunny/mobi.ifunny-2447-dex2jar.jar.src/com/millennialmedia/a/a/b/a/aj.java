package com.millennialmedia.a.a.b.a;

import com.millennialmedia.a.a.ae;
import com.millennialmedia.a.a.d.a;
import com.millennialmedia.a.a.d.c;
import com.millennialmedia.a.a.d.d;
import com.millennialmedia.a.a.u;

import java.net.URI;
import java.net.URISyntaxException;

final class aj
        extends ae<URI> {
    public URI a(a parama) {
        if (parama.f() == c.i) {
            parama.j();
        }
        for (; ; ) {
            return null;
            try {
                parama = parama.h();
                if ("null".equals(parama)) {
                    continue;
                }
                parama = new URI(parama);
                return parama;
            } catch (URISyntaxException parama) {
                throw new u(parama);
            }
        }
    }

    public void a(d paramd, URI paramURI) {
        if (paramURI == null) {
        }
        for (paramURI = null; ; paramURI = paramURI.toASCIIString()) {
            paramd.b(paramURI);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/a/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */