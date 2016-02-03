package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.Collections;
import java.util.List;

public final class DataType
        implements SafeParcelable {
    public static final Parcelable.Creator<DataType> CREATOR = new h();
    private final int a;
    private final String b;
    private final List<Field> c;

    DataType(int paramInt, String paramString, List<Field> paramList) {
        this.a = paramInt;
        this.b = paramString;
        this.c = Collections.unmodifiableList(paramList);
    }

    private boolean a(DataType paramDataType) {
        return (this.b.equals(paramDataType.b)) && (this.c.equals(paramDataType.c));
    }

    public String a() {
        return this.b;
    }

    public List<Field> b() {
        return this.c;
    }

    public String c() {
        if (this.b.startsWith("com.google.")) {
            return this.b.substring(11);
        }
        return this.b;
    }

    int d() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return (this == paramObject) || (((paramObject instanceof DataType)) && (a((DataType) paramObject)));
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return String.format("DataType{%s%s}", new Object[]{this.b, this.c});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        h.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/DataType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */