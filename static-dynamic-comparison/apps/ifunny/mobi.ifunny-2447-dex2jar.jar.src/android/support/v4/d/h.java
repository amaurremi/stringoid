package android.support.v4.d;

import java.util.Iterator;

final class h<T>
        implements Iterator<T> {
    final int a;
    int b;
    int c;
    boolean d = false;

    h(g paramg, int paramInt) {
        this.a = paramInt;
        this.b = paramg.a();
    }

    public boolean hasNext() {
        return this.c < this.b;
    }

    public T next() {
        Object localObject = this.e.a(this.c, this.a);
        this.c += 1;
        this.d = true;
        return (T) localObject;
    }

    public void remove() {
        if (!this.d) {
            throw new IllegalStateException();
        }
        this.c -= 1;
        this.b -= 1;
        this.d = false;
        this.e.a(this.c);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */