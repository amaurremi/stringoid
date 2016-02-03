package com.flurry.sdk;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class rw
        extends ro {
    protected LinkedHashMap<String, hh> c = null;

    public rw(rs paramrs) {
        super(paramrs);
    }

    private final hh b(String paramString, hh paramhh) {
        if (this.c == null) {
            this.c = new LinkedHashMap();
        }
        return (hh) this.c.put(paramString, paramhh);
    }

    public hh a(String paramString) {
        if (this.c != null) {
            return (hh) this.c.get(paramString);
        }
        return null;
    }

    public hh a(String paramString, hh paramhh) {
        Object localObject = paramhh;
        if (paramhh == null) {
            localObject = s();
        }
        return b(paramString, (hh) localObject);
    }

    public final void a(hf paramhf, jw paramjw)
            throws IOException, hk {
        paramhf.d();
        if (this.c != null) {
            Iterator localIterator = this.c.entrySet().iterator();
            while (localIterator.hasNext()) {
                Map.Entry localEntry = (Map.Entry) localIterator.next();
                paramhf.a((String) localEntry.getKey());
                ((rk) localEntry.getValue()).a(paramhf, paramjw);
            }
        }
        paramhf.e();
    }

    public void a(hf paramhf, jw paramjw, jz paramjz)
            throws IOException, hk {
        paramjz.b(this, paramhf);
        if (this.c != null) {
            Iterator localIterator = this.c.entrySet().iterator();
            while (localIterator.hasNext()) {
                Map.Entry localEntry = (Map.Entry) localIterator.next();
                paramhf.a((String) localEntry.getKey());
                ((rk) localEntry.getValue()).a(paramhf, paramjw);
            }
        }
        paramjz.e(this, paramhf);
    }

    public boolean c() {
        return true;
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
            return true;
        }
        if (paramObject == null) {
            return false;
        }
        if (paramObject.getClass() != getClass()) {
            return false;
        }
        paramObject = (rw) paramObject;
        if (((rw) paramObject).p() != p()) {
            return false;
        }
        if (this.c != null) {
            Iterator localIterator = this.c.entrySet().iterator();
            while (localIterator.hasNext()) {
                Object localObject2 = (Map.Entry) localIterator.next();
                Object localObject1 = (String) ((Map.Entry) localObject2).getKey();
                localObject2 = (hh) ((Map.Entry) localObject2).getValue();
                localObject1 = ((rw) paramObject).a((String) localObject1);
                if ((localObject1 == null) || (!((hh) localObject1).equals(localObject2))) {
                    return false;
                }
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.c == null) {
            return -1;
        }
        return this.c.hashCode();
    }

    public int p() {
        if (this.c == null) {
            return 0;
        }
        return this.c.size();
    }

    public Iterator<hh> q() {
        if (this.c == null) {
            return ro.a.a();
        }
        return this.c.values().iterator();
    }

    public Iterator<String> r() {
        if (this.c == null) {
            return ro.b.a();
        }
        return this.c.keySet().iterator();
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder((p() << 4) + 32);
        localStringBuilder.append("{");
        if (this.c != null) {
            Iterator localIterator = this.c.entrySet().iterator();
            int i = 0;
            while (localIterator.hasNext()) {
                Map.Entry localEntry = (Map.Entry) localIterator.next();
                if (i > 0) {
                    localStringBuilder.append(",");
                }
                ry.a(localStringBuilder, (String) localEntry.getKey());
                localStringBuilder.append(':');
                localStringBuilder.append(((hh) localEntry.getValue()).toString());
                i += 1;
            }
        }
        localStringBuilder.append("}");
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/rw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */