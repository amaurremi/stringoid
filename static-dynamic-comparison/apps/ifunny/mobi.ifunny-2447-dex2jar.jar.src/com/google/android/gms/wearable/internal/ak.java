package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ak
        implements SafeParcelable {
    public static final Parcelable.Creator<ak> CREATOR = new h();
    final int a;
    private final String b;
    private final String c;

    ak(int paramInt, String paramString1, String paramString2) {
        this.a = paramInt;
        this.b = paramString1;
        this.c = paramString2;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof ak)) {
        }
        do {
            return false;
            paramObject = (ak) paramObject;
        } while ((!((ak) paramObject).b.equals(this.b)) || (!((ak) paramObject).c.equals(this.c)));
        return true;
    }

    public int hashCode() {
        return (this.b.hashCode() + 629) * 37 + this.c.hashCode();
    }

    public String toString() {
        return "NodeParcelable{" + this.b + "," + this.c + "}";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        h.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/internal/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */