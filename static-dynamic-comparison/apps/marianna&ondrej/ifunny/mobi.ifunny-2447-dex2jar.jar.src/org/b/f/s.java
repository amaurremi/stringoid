package org.b.f;

import org.b.c;

public final class s {
    private int a = 0;
    private byte[] b = new byte[''];
    private int[] c = new int[''];

    public s() {
        this.b[0] = 0;
    }

    public void a() {
        if (this.c[this.a] > 0) {
        }
        do {
            return;
            if (this.b[this.a] == 1) {
                throw new c("Array is end but readArrayEnd() is not called");
            }
        } while (this.b[this.a] != 2);
        throw new c("Map is end but readMapEnd() is not called");
    }

    public void a(int paramInt) {
        this.a += 1;
        this.b[this.a] = 1;
        this.c[this.a] = paramInt;
    }

    public void b() {
        int[] arrayOfInt = this.c;
        int i = this.a;
        arrayOfInt[i] -= 1;
    }

    public void b(int paramInt) {
        this.a += 1;
        this.b[this.a] = 2;
        this.c[this.a] = (paramInt * 2);
    }

    public void c() {
        this.a -= 1;
    }

    public int d() {
        return this.a;
    }

    public int e() {
        return this.c[this.a];
    }

    public boolean f() {
        return this.b[this.a] == 1;
    }

    public boolean g() {
        return this.b[this.a] == 2;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/f/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */