package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class mi
        implements SafeParcelable {
    public static final rd CREATOR = new rd();
    final int a;
    final List<mo> b;
    final List<ms> c;
    final List<String> d;
    private final String e;
    private final boolean f;
    private final Set<mo> g;
    private final Set<ms> h;
    private final Set<String> i;

    mi(int paramInt, List<mo> paramList, String paramString, boolean paramBoolean, List<ms> paramList1, List<String> paramList2) {
        this.a = paramInt;
        if (paramList == null) {
            paramList = Collections.emptyList();
            this.b = paramList;
            paramList = paramString;
            if (paramString == null) {
                paramList = "";
            }
            this.e = paramList;
            this.f = paramBoolean;
            if (paramList1 != null) {
                break label112;
            }
            paramList = Collections.emptyList();
            label51:
            this.c = paramList;
            if (paramList2 != null) {
                break label121;
            }
        }
        label112:
        label121:
        for (paramList = Collections.emptyList(); ; paramList = Collections.unmodifiableList(paramList2)) {
            this.d = paramList;
            this.g = a(this.b);
            this.h = a(this.c);
            this.i = a(this.d);
            return;
            paramList = Collections.unmodifiableList(paramList);
            break;
            paramList = Collections.unmodifiableList(paramList1);
            break label51;
        }
    }

    private static <E> Set<E> a(List<E> paramList) {
        if (paramList.isEmpty()) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(paramList));
    }

    @Deprecated
    public String a() {
        return this.e;
    }

    public boolean b() {
        return this.f;
    }

    public int describeContents() {
        rd localrd = CREATOR;
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof mi)) {
                return false;
            }
            paramObject = (mi) paramObject;
        }
        while ((this.g.equals(((mi) paramObject).g)) && (this.f == ((mi) paramObject).f) && (this.h.equals(((mi) paramObject).h)) && (this.i.equals(((mi) paramObject).i)));
        return false;
    }

    public int hashCode() {
        return ad.a(new Object[]{this.g, Boolean.valueOf(this.f), this.h, this.i});
    }

    public String toString() {
        return ad.a(this).a("types", this.g).a("placeIds", this.i).a("requireOpenNow", Boolean.valueOf(this.f)).a("requestedUserDataTypes", this.h).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        rd localrd = CREATOR;
        rd.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/mi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */