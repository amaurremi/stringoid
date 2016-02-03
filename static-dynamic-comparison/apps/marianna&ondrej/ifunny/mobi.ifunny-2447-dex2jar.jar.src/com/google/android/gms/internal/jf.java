package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class jf
        implements SafeParcelable, ph<String, Integer> {
    public static final pf CREATOR = new pf();
    private final int a;
    private final HashMap<String, Integer> b;
    private final HashMap<Integer, String> c;
    private final ArrayList<jf.a> d;

    public jf() {
        this.a = 1;
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = null;
    }

    jf(int paramInt, ArrayList<jf.a> paramArrayList) {
        this.a = paramInt;
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = null;
        a(paramArrayList);
    }

    private void a(ArrayList<jf.a> paramArrayList) {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
            jf.a locala = (jf.a) paramArrayList.next();
            a(locala.b, locala.c);
        }
    }

    int a() {
        return this.a;
    }

    public jf a(String paramString, int paramInt) {
        this.b.put(paramString, Integer.valueOf(paramInt));
        this.c.put(Integer.valueOf(paramInt), paramString);
        return this;
    }

    public String a(Integer paramInteger) {
        String str = (String) this.c.get(paramInteger);
        paramInteger = str;
        if (str == null) {
            paramInteger = str;
            if (this.b.containsKey("gms_unknown")) {
                paramInteger = "gms_unknown";
            }
        }
        return paramInteger;
    }

    ArrayList<jf.a> b() {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.b.keySet().iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            localArrayList.add(new jf.a(str, ((Integer) this.b.get(str)).intValue()));
        }
        return localArrayList;
    }

    public int c() {
        return 7;
    }

    public int d() {
        return 0;
    }

    public int describeContents() {
        pf localpf = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        pf localpf = CREATOR;
        pf.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/jf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */