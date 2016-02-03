package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Operator
        implements SafeParcelable {
    public static final Parcelable.Creator<Operator> CREATOR = new l();
    public static final Operator a = new Operator("=");
    public static final Operator b = new Operator("<");
    public static final Operator c = new Operator("<=");
    public static final Operator d = new Operator(">");
    public static final Operator e = new Operator(">=");
    public static final Operator f = new Operator("and");
    public static final Operator g = new Operator("or");
    public static final Operator h = new Operator("not");
    public static final Operator i = new Operator("contains");
    final String j;
    final int k;

    Operator(int paramInt, String paramString) {
        this.k = paramInt;
        this.j = paramString;
    }

    private Operator(String paramString) {
        this(1, paramString);
    }

    public String a() {
        return this.j;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            do {
                return true;
                if (paramObject == null) {
                    return false;
                }
                if (getClass() != paramObject.getClass()) {
                    return false;
                }
                paramObject = (Operator) paramObject;
                if (this.j != null) {
                    break;
                }
            } while (((Operator) paramObject).j == null);
            return false;
        } while (this.j.equals(((Operator) paramObject).j));
        return false;
    }

    public int hashCode() {
        if (this.j == null) {
        }
        for (int m = 0; ; m = this.j.hashCode()) {
            return m + 31;
        }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        l.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/query/internal/Operator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */