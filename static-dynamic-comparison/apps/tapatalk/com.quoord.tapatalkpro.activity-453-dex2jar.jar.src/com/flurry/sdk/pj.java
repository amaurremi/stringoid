package com.flurry.sdk;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Iterator;

public class pj
        extends pb<EnumSet<? extends Enum<?>>> {
    public pj(sh paramsh, is paramis) {
        super(EnumSet.class, paramsh, true, null, paramis, null);
    }

    public pf<?> a(jz paramjz) {
        return this;
    }

    public void a(EnumSet<? extends Enum<?>> paramEnumSet, hf paramhf, jw paramjw)
            throws IOException, he {
        Object localObject = this.d;
        Iterator localIterator = paramEnumSet.iterator();
        for (paramEnumSet = (EnumSet<? extends Enum<?>>) localObject; localIterator.hasNext(); paramEnumSet = (EnumSet<? extends Enum<?>>) localObject) {
            Enum localEnum = (Enum) localIterator.next();
            localObject = paramEnumSet;
            if (paramEnumSet == null) {
                localObject = paramjw.a(localEnum.getDeclaringClass(), this.e);
            }
            ((jk) localObject).a(localEnum, paramhf, paramjw);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/pj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */