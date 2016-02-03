package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;
import com.google.android.gms.wearable.c;
import com.google.android.gms.wearable.d;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class kg
        extends b
        implements c {
    private final int LE;

    public kg(DataHolder paramDataHolder, int paramInt1, int paramInt2) {
        super(paramDataHolder, paramInt1);
        this.LE = paramInt2;
    }

    public byte[] getData() {
        return getByteArray("data");
    }

    public Uri getUri() {
        return Uri.parse(getString("path"));
    }

    public Map<String, d> ma() {
        HashMap localHashMap = new HashMap(this.LE);
        int i = 0;
        if (i < this.LE) {
            ke localke = new ke(this.BB, this.BD + i);
            if (localke.mc() == null) {
            }
            for (; ; ) {
                i += 1;
                break;
                localHashMap.put(localke.mc(), localke);
            }
        }
        return localHashMap;
    }

    @Deprecated
    public Set<String> mb() {
        HashSet localHashSet = new HashSet();
        Object localObject = getString("tags");
        if (localObject != null) {
            localObject = ((String) localObject).split("\\|");
            int j = localObject.length;
            int i = 0;
            while (i < j) {
                localHashSet.add(localObject[i]);
                i += 1;
            }
        }
        return localHashSet;
    }

    public c mg() {
        return new kf(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/kg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */