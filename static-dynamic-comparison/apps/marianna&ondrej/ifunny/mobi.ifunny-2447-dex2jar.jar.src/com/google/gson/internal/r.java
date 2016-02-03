package com.google.gson.internal;

final class r<K, V> {
    private y<K, V> a;
    private int b;
    private int c;
    private int d;

    y<K, V> a() {
        y localy = this.a;
        if (localy.a != null) {
            throw new IllegalStateException();
        }
        return localy;
    }

    void a(int paramInt) {
        this.b = (Integer.highestOneBit(paramInt) * 2 - 1 - paramInt);
        this.d = 0;
        this.c = 0;
        this.a = null;
    }

    void a(y<K, V> paramy) {
        paramy.c = null;
        paramy.a = null;
        paramy.b = null;
        paramy.i = 1;
        if ((this.b > 0) && ((this.d & 0x1) == 0)) {
            this.d += 1;
            this.b -= 1;
            this.c += 1;
        }
        paramy.a = this.a;
        this.a = paramy;
        this.d += 1;
        if ((this.b > 0) && ((this.d & 0x1) == 0)) {
            this.d += 1;
            this.b -= 1;
            this.c += 1;
        }
        int i = 4;
        if ((this.d & i - 1) == i - 1) {
            y localy1;
            if (this.c == 0) {
                paramy = this.a;
                localy1 = paramy.a;
                y localy2 = localy1.a;
                localy1.a = localy2.a;
                this.a = localy1;
                localy1.b = localy2;
                localy1.c = paramy;
                paramy.i += 1;
                localy2.a = localy1;
                paramy.a = localy1;
            }
            for (; ; ) {
                i *= 2;
                break;
                if (this.c == 1) {
                    paramy = this.a;
                    localy1 = paramy.a;
                    this.a = localy1;
                    localy1.c = paramy;
                    paramy.i += 1;
                    paramy.a = localy1;
                    this.c = 0;
                } else if (this.c == 2) {
                    this.c = 0;
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/gson/internal/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */