package com.millennialmedia.a.a;

import java.util.Map.Entry;
import java.util.Set;

public final class w
        extends t {
    private final com.millennialmedia.a.a.b.w<String, t> a = new com.millennialmedia.a.a.b.w();

    public void a(String paramString, t paramt) {
        Object localObject = paramt;
        if (paramt == null) {
            localObject = v.a;
        }
        this.a.put(paramString, localObject);
    }

    public boolean equals(Object paramObject) {
        return (paramObject == this) || (((paramObject instanceof w)) && (((w) paramObject).a.equals(this.a)));
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public Set<Map.Entry<String, t>> o() {
        return this.a.entrySet();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */