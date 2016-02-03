package com.flurry.sdk;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public final class ms
        implements Iterable<mr> {
    protected LinkedHashMap<mz, mr> a;

    public mr a(String paramString, Class<?>[] paramArrayOfClass) {
        if (this.a == null) {
            return null;
        }
        return (mr) this.a.get(new mz(paramString, paramArrayOfClass));
    }

    public mr a(Method paramMethod) {
        if (this.a != null) {
            return (mr) this.a.remove(new mz(paramMethod));
        }
        return null;
    }

    public void a(mr parammr) {
        if (this.a == null) {
            this.a = new LinkedHashMap();
        }
        this.a.put(new mz(parammr.e()), parammr);
    }

    public boolean a() {
        return (this.a == null) || (this.a.size() == 0);
    }

    public mr b(Method paramMethod) {
        if (this.a == null) {
            return null;
        }
        return (mr) this.a.get(new mz(paramMethod));
    }

    public Iterator<mr> iterator() {
        if (this.a != null) {
            return this.a.values().iterator();
        }
        return Collections.emptyList().iterator();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */