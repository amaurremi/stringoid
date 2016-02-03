package com.a.a;

public class b {
    private final int a;
    private final int b;

    public b(int paramInt1, int paramInt2) {
        this.a = paramInt1;
        this.b = paramInt2;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof b)) {
        }
        do {
            return false;
            paramObject = (b) paramObject;
        } while ((((b) paramObject).a != this.a) || (((b) paramObject).b != this.b));
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */