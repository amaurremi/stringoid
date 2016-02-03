package com.millennialmedia.a.a.b.a;

import com.millennialmedia.a.a.aa;
import com.millennialmedia.a.a.ae;
import com.millennialmedia.a.a.d.a;
import com.millennialmedia.a.a.d.c;
import com.millennialmedia.a.a.d.d;

import java.util.BitSet;

final class ak
        extends ae<BitSet> {
    public BitSet a(a parama) {
        if (parama.f() == c.i) {
            parama.j();
            return null;
        }
        BitSet localBitSet = new BitSet();
        parama.a();
        Object localObject = parama.f();
        int i = 0;
        if (localObject != c.b) {
            boolean bool;
            switch (ay.a[localObject.ordinal()]) {
                default:
                    throw new aa("Invalid bitset value type: " + localObject);
                case 1:
                    if (parama.m() != 0) {
                        bool = true;
                    }
                    break;
            }
            for (; ; ) {
                if (bool) {
                    localBitSet.set(i);
                }
                i += 1;
                localObject = parama.f();
                break;
                bool = false;
                continue;
                bool = parama.i();
                continue;
                localObject = parama.h();
                try {
                    int j = Integer.parseInt((String) localObject);
                    if (j != 0) {
                        bool = true;
                    } else {
                        bool = false;
                    }
                } catch (NumberFormatException parama) {
                    throw new aa("Error: Expecting: bitset number value (1, 0), Found: " + (String) localObject);
                }
            }
        }
        parama.b();
        return localBitSet;
    }

    public void a(d paramd, BitSet paramBitSet) {
        if (paramBitSet == null) {
            paramd.f();
            return;
        }
        paramd.b();
        int i = 0;
        if (i < paramBitSet.length()) {
            if (paramBitSet.get(i)) {
            }
            for (int j = 1; ; j = 0) {
                paramd.a(j);
                i += 1;
                break;
            }
        }
        paramd.c();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/a/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */