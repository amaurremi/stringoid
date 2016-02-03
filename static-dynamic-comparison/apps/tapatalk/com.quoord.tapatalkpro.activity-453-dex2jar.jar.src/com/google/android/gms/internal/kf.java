package com.google.android.gms.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.c;
import com.google.android.gms.wearable.d;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class kf
        implements c {
    private byte[] Nf;
    private Map<String, d> adD;
    private Set<String> adE;
    private Uri mUri;

    public kf(c paramc) {
        this.mUri = paramc.getUri();
        this.Nf = paramc.getData();
        HashMap localHashMap = new HashMap();
        Iterator localIterator = paramc.ma().entrySet().iterator();
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            if (localEntry.getKey() != null) {
                localHashMap.put(localEntry.getKey(), ((d) localEntry.getValue()).freeze());
            }
        }
        this.adD = Collections.unmodifiableMap(localHashMap);
        this.adE = Collections.unmodifiableSet(paramc.mb());
    }

    public byte[] getData() {
        return this.Nf;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isDataValid() {
        return true;
    }

    public Map<String, d> ma() {
        return this.adD;
    }

    @Deprecated
    public Set<String> mb() {
        return this.adE;
    }

    public c mg() {
        return this;
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean paramBoolean) {
        StringBuilder localStringBuilder = new StringBuilder("DataItemEntity[");
        localStringBuilder.append("@");
        localStringBuilder.append(Integer.toHexString(hashCode()));
        Object localObject2 = new StringBuilder().append(",dataSz=");
        if (this.Nf == null) {
        }
        for (Object localObject1 = "null"; ; localObject1 = Integer.valueOf(this.Nf.length)) {
            localStringBuilder.append(localObject1);
            localStringBuilder.append(", numAssets=" + this.adD.size());
            localStringBuilder.append(", uri=" + this.mUri);
            if (paramBoolean) {
                break;
            }
            localStringBuilder.append("]");
            return localStringBuilder.toString();
        }
        localStringBuilder.append("\n  tags=[");
        localObject1 = this.adE.iterator();
        int i = 0;
        if (((Iterator) localObject1).hasNext()) {
            localObject2 = (String) ((Iterator) localObject1).next();
            if (i != 0) {
                localStringBuilder.append(", ");
            }
            for (; ; ) {
                localStringBuilder.append((String) localObject2);
                break;
                i = 1;
            }
        }
        localStringBuilder.append("]\n  assets: ");
        localObject1 = this.adD.keySet().iterator();
        while (((Iterator) localObject1).hasNext()) {
            localObject2 = (String) ((Iterator) localObject1).next();
            localStringBuilder.append("\n    " + (String) localObject2 + ": " + this.adD.get(localObject2));
        }
        localStringBuilder.append("\n  ]");
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/kf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */