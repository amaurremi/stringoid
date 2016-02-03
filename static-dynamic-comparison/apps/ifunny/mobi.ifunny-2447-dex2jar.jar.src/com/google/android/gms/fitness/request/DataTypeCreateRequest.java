package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Field;

import java.util.Collections;
import java.util.List;

public class DataTypeCreateRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<DataTypeCreateRequest> CREATOR = new q();
    private final int a;
    private final String b;
    private final List<Field> c;

    DataTypeCreateRequest(int paramInt, String paramString, List<Field> paramList) {
        this.a = paramInt;
        this.b = paramString;
        this.c = Collections.unmodifiableList(paramList);
    }

    private boolean a(DataTypeCreateRequest paramDataTypeCreateRequest) {
        return (ad.a(this.b, paramDataTypeCreateRequest.b)) && (ad.a(this.c, paramDataTypeCreateRequest.c));
    }

    public String a() {
        return this.b;
    }

    public List<Field> b() {
        return this.c;
    }

    int c() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return (paramObject == this) || (((paramObject instanceof DataTypeCreateRequest)) && (a((DataTypeCreateRequest) paramObject)));
    }

    public int hashCode() {
        return ad.a(new Object[]{this.b, this.c});
    }

    public String toString() {
        return ad.a(this).a("name", this.b).a("fields", this.c).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        q.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/DataTypeCreateRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */