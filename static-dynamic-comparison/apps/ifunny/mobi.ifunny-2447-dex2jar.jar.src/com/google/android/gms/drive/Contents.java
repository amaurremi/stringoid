package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public class Contents
        implements SafeParcelable {
    public static final Parcelable.Creator<Contents> CREATOR = new a();
    final int a;
    final ParcelFileDescriptor b;
    final int c;
    final int d;
    final DriveId e;
    final boolean f;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;

    Contents(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2, int paramInt3, DriveId paramDriveId, boolean paramBoolean) {
        this.a = paramInt1;
        this.b = paramParcelFileDescriptor;
        this.c = paramInt2;
        this.d = paramInt3;
        this.e = paramDriveId;
        this.f = paramBoolean;
    }

    public int a() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/Contents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */