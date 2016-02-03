package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class jm
        implements SafeParcelable {
    public static final pk CREATOR = new pk();
    private final int a;
    private final HashMap<String, HashMap<String, ji.a<?, ?>>> b;
    private final ArrayList<jm.a> c;
    private final String d;

    jm(int paramInt, ArrayList<jm.a> paramArrayList, String paramString) {
        this.a = paramInt;
        this.c = null;
        this.b = a(paramArrayList);
        this.d = ((String) ag.a(paramString));
        a();
    }

    private static HashMap<String, HashMap<String, ji.a<?, ?>>> a(ArrayList<jm.a> paramArrayList) {
        HashMap localHashMap = new HashMap();
        int j = paramArrayList.size();
        int i = 0;
        while (i < j) {
            jm.a locala = (jm.a) paramArrayList.get(i);
            localHashMap.put(locala.b, locala.a());
            i += 1;
        }
        return localHashMap;
    }

    public HashMap<String, ji.a<?, ?>> a(String paramString) {
        return (HashMap) this.b.get(paramString);
    }

    public void a() {
        Iterator localIterator1 = this.b.keySet().iterator();
        while (localIterator1.hasNext()) {
            Object localObject = (String) localIterator1.next();
            localObject = (HashMap) this.b.get(localObject);
            Iterator localIterator2 = ((HashMap) localObject).keySet().iterator();
            while (localIterator2.hasNext()) {
                ((ji.a) ((HashMap) localObject).get((String) localIterator2.next())).a(this);
            }
        }
    }

    int b() {
        return this.a;
    }

    ArrayList<jm.a> c() {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.b.keySet().iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            localArrayList.add(new jm.a(str, (HashMap) this.b.get(str)));
        }
        return localArrayList;
    }

    public String d() {
        return this.d;
    }

    public int describeContents() {
        pk localpk = CREATOR;
        return 0;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        Iterator localIterator1 = this.b.keySet().iterator();
        while (localIterator1.hasNext()) {
            Object localObject = (String) localIterator1.next();
            localStringBuilder.append((String) localObject).append(":\n");
            localObject = (HashMap) this.b.get(localObject);
            Iterator localIterator2 = ((HashMap) localObject).keySet().iterator();
            while (localIterator2.hasNext()) {
                String str = (String) localIterator2.next();
                localStringBuilder.append("  ").append(str).append(": ");
                localStringBuilder.append(((HashMap) localObject).get(str));
            }
        }
        return localStringBuilder.toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        pk localpk = CREATOR;
        pk.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/jm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */