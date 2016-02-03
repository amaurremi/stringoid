package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

public class ah
        implements SafeParcelable {
    public static final Parcelable.Creator<ah> CREATOR = new g();
    private final int a;
    private final DataType b;
    private final DataSource c;

    ah(int paramInt, DataType paramDataType, DataSource paramDataSource) {
        this.a = paramInt;
        this.b = paramDataType;
        this.c = paramDataSource;
    }

    private boolean a(ah paramah) {
        return (ad.a(this.c, paramah.c)) && (ad.a(this.b, paramah.b));
    }

    int a() {
        return this.a;
    }

    public DataType b() {
        return this.b;
    }

    public DataSource c() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return (this == paramObject) || (((paramObject instanceof ah)) && (a((ah) paramObject)));
    }

    public int hashCode() {
        return ad.a(new Object[]{this.c, this.b});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        g.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */