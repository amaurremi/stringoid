package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UserMetadata
        implements SafeParcelable {
    public static final Parcelable.Creator<UserMetadata> CREATOR = new f();
    final int a;
    final String b;
    final String c;
    final String d;
    final boolean e;
    final String f;

    UserMetadata(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4) {
        this.a = paramInt;
        this.b = paramString1;
        this.c = paramString2;
        this.d = paramString3;
        this.e = paramBoolean;
        this.f = paramString4;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("Permission ID: '%s', Display Name: '%s', Picture URL: '%s', Authenticated User: %b, Email: '%s'", new Object[]{this.b, this.c, this.d, Boolean.valueOf(this.e), this.f});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        f.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/UserMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */