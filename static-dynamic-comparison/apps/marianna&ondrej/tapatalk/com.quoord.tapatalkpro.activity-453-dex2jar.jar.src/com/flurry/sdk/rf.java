package com.flurry.sdk;

public abstract class rf<T> {
    T a;
    a<T> b;
    a<T> c;
    int d;

    public T a() {
        b();
        if (this.a == null) {
            return (T) b(12);
        }
        return (T) this.a;
    }

    public final T a(T paramT, int paramInt) {
        paramT = new a(paramT, paramInt);
        if (this.b == null) {
            this.c = paramT;
            this.b = paramT;
            this.d += paramInt;
            if (paramInt >= 16384) {
                break label70;
            }
            paramInt += paramInt;
        }
        for (; ; ) {
            return (T) b(paramInt);
            this.c.a(paramT);
            this.c = paramT;
            break;
            label70:
            paramInt = (paramInt >> 2) + paramInt;
        }
    }

    protected abstract T b(int paramInt);

    public T b(T paramT, int paramInt) {
        int j = paramInt + this.d;
        Object localObject = b(j);
        a locala = this.b;
        int i = 0;
        while (locala != null) {
            i = locala.a(localObject, i);
            locala = locala.b();
        }
        System.arraycopy(paramT, 0, localObject, i, paramInt);
        paramInt = i + paramInt;
        if (paramInt != j) {
            throw new IllegalStateException("Should have gotten " + j + " entries, got " + paramInt);
        }
        return (T) localObject;
    }

    protected void b() {
        if (this.c != null) {
            this.a = this.c.a();
        }
        this.c = null;
        this.b = null;
        this.d = 0;
    }

    static final class a<T> {
        final T a;
        final int b;
        a<T> c;

        public a(T paramT, int paramInt) {
            this.a = paramT;
            this.b = paramInt;
        }

        public int a(T paramT, int paramInt) {
            System.arraycopy(this.a, 0, paramT, paramInt, this.b);
            return this.b + paramInt;
        }

        public T a() {
            return (T) this.a;
        }

        public void a(a<T> parama) {
            if (this.c != null) {
                throw new IllegalStateException();
            }
            this.c = parama;
        }

        public a<T> b() {
            return this.c;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/rf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */