package com.everimaging.fotorsdk.store.billing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class d {
    Map<String, g> a = new HashMap();
    Map<String, e> b = new HashMap();

    List<g> a() {
        return new ArrayList(this.a.values());
    }

    public void a(e parame) {
        this.b.put(parame.b(), parame);
    }

    public void a(g paramg) {
        this.a.put(paramg.a(), paramg);
    }

    public boolean a(String paramString) {
        return this.b.containsKey(paramString);
    }

    List<String> b(String paramString) {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.b.values().iterator();
        while (localIterator.hasNext()) {
            e locale = (e) localIterator.next();
            if (locale.a().equals(paramString)) {
                localArrayList.add(locale.b());
            }
        }
        return localArrayList;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/billing/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */