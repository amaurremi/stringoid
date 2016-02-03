package com.millennialmedia.a.a.b;

final class y<K, V> {
    private af<K, V> a;
    private int b;
    private int c;
    private int d;

    af<K, V> a() {
        af localaf = this.a;
        if (localaf.a != null) {
            throw new IllegalStateException();
        }
        return localaf;
    }

    void a(int paramInt) {
        this.b = (Integer.highestOneBit(paramInt) * 2 - 1 - paramInt);
        this.d = 0;
        this.c = 0;
        this.a = null;
    }

    void a(af<K, V> paramaf) {
        paramaf.c = null;
        paramaf.a = null;
        paramaf.b = null;
        paramaf.i = 1;
        if ((this.b > 0) && ((this.d & 0x1) == 0)) {
            this.d += 1;
            this.b -= 1;
            this.c += 1;
        }
        paramaf.a = this.a;
        this.a = paramaf;
        this.d += 1;
        if ((this.b > 0) && ((this.d & 0x1) == 0)) {
            this.d += 1;
            this.b -= 1;
            this.c += 1;
        }
        int i = 4;
        if ((this.d & i - 1) == i - 1) {
            af localaf1;
            if (this.c == 0) {
                paramaf = this.a;
                localaf1 = paramaf.a;
                af localaf2 = localaf1.a;
                localaf1.a = localaf2.a;
                this.a = localaf1;
                localaf1.b = localaf2;
                localaf1.c = paramaf;
                paramaf.i += 1;
                localaf2.a = localaf1;
                paramaf.a = localaf1;
            }
            for (; ; ) {
                i *= 2;
                break;
                if (this.c == 1) {
                    paramaf = this.a;
                    localaf1 = paramaf.a;
                    this.a = localaf1;
                    localaf1.c = paramaf;
                    paramaf.i += 1;
                    paramaf.a = localaf1;
                    this.c = 0;
                } else if (this.c == 2) {
                    this.c = 0;
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */