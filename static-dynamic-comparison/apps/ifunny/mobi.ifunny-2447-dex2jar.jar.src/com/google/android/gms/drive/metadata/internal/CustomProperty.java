package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class CustomProperty
        implements SafeParcelable {
    public static final Parcelable.Creator<CustomProperty> CREATOR = new e();
    final int a;
    final CustomPropertyKey b;
    final String c;

    CustomProperty(int paramInt, CustomPropertyKey paramCustomPropertyKey, String paramString) {
        this.a = paramInt;
        ag.a(paramCustomPropertyKey, "key");
        this.b = paramCustomPropertyKey;
        this.c = paramString;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        e.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/CustomProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */