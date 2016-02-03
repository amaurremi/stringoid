package org.b.b;

import java.util.Iterator;
import java.util.LinkedList;

public final class g
        extends c {
    private LinkedList<h> e = new LinkedList();
    private int f;

    public g(int paramInt) {
        super(paramInt);
    }

    public byte[] a() {
        byte[] arrayOfByte = new byte[this.f + this.b];
        Iterator localIterator = this.e.iterator();
        h localh;
        for (int i = 0; localIterator.hasNext(); i = localh.c + i) {
            localh = (h) localIterator.next();
            System.arraycopy(localh.a, localh.b, arrayOfByte, i, localh.c);
        }
        if (this.b > 0) {
            System.arraycopy(this.a, 0, arrayOfByte, i, this.b);
        }
        return arrayOfByte;
    }

    protected boolean b(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        this.e.add(new h(paramArrayOfByte, paramInt1, paramInt2));
        this.f += paramInt2;
        return false;
    }

    public void close() {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */