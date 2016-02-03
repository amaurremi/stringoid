package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class jm$a
        implements SafeParcelable {
    public static final pl CREATOR = new pl();
    final int a;
    final String b;
    final ArrayList<jm.b> c;

    jm$a(int paramInt, String paramString, ArrayList<jm.b> paramArrayList) {
        this.a = paramInt;
        this.b = paramString;
        this.c = paramArrayList;
    }

    jm$a(String paramString, HashMap<String, ji.a<?, ?>> paramHashMap) {
        this.a = 1;
        this.b = paramString;
        this.c = a(paramHashMap);
    }

    private static ArrayList<jm.b> a(HashMap<String, ji.a<?, ?>> paramHashMap) {
        if (paramHashMap == null) {
            return null;
        }
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = paramHashMap.keySet().iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            localArrayList.add(new jm.b(str, (ji.a) paramHashMap.get(str)));
        }
        return localArrayList;
    }

    HashMap<String, ji.a<?, ?>> a() {
        HashMap localHashMap = new HashMap();
        int j = this.c.size();
        int i = 0;
        while (i < j) {
            jm.b localb = (jm.b) this.c.get(i);
            localHashMap.put(localb.b, localb.c);
            i += 1;
        }
        return localHashMap;
    }

    public int describeContents() {
        pl localpl = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        pl localpl = CREATOR;
        pl.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/jm$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */