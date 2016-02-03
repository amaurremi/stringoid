package org.b.f;

import java.io.EOFException;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.b.c.g;
import org.b.e.ae;

public class r
        implements Iterator<ae> {
    private final a a;
    private final g b;
    private IOException c;

    public r(a parama) {
        this.a = parama;
        this.b = new g(parama.a);
    }

    public ae a() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        ae localae = this.b.c();
        this.b.e();
        return localae;
    }

    public boolean hasNext() {
        if (this.b.c() != null) {
        }
        for (; ; ) {
            return true;
            try {
                this.a.a(this.b);
                if (this.b.c() == null) {
                    return false;
                }
            } catch (EOFException localEOFException) {
                return false;
            } catch (IOException localIOException) {
                this.c = localIOException;
            }
        }
        return false;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/f/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */