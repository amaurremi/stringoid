package com.flurry.sdk;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class be
        implements bf {
    private final List<bf> a;

    public be() {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new bd());
        localArrayList.add(new bi());
        localArrayList.add(new bb());
        localArrayList.add(new bh());
        this.a = Collections.unmodifiableList(localArrayList);
    }

    public boolean a(Context paramContext, bj parambj) {
        boolean bool2;
        if ((paramContext == null) || (parambj == null)) {
            bool2 = false;
        }
        Iterator localIterator;
        boolean bool1;
        do {
            return bool2;
            localIterator = this.a.iterator();
            bool1 = true;
            bool2 = bool1;
        } while (!localIterator.hasNext());
        if (!((bf) localIterator.next()).a(paramContext, parambj)) {
            bool1 = false;
        }
        for (; ; ) {
            break;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */