package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<CreateFileRequest> CREATOR = new af();
    final int a;
    final DriveId b;
    final MetadataBundle c;
    final Contents d;
    final Integer e;
    final boolean f;
    final String g;
    final int h;
    final int i;

    CreateFileRequest(int paramInt1, DriveId paramDriveId, MetadataBundle paramMetadataBundle, Contents paramContents, Integer paramInteger, boolean paramBoolean, String paramString, int paramInt2, int paramInt3) {
        if ((paramContents != null) && (paramInt3 != 0)) {
            if (paramContents.a() != paramInt3) {
                break label67;
            }
        }
        label67:
        for (boolean bool = true; ; bool = false) {
            ag.b(bool, "inconsistent contents reference");
            if (((paramInteger != null) && (paramInteger.intValue() != 0)) || (paramContents != null) || (paramInt3 != 0)) {
                break;
            }
            throw new IllegalArgumentException("Need a valid contents");
        }
        this.a = paramInt1;
        this.b = ((DriveId) ag.a(paramDriveId));
        this.c = ((MetadataBundle) ag.a(paramMetadataBundle));
        this.d = paramContents;
        this.e = paramInteger;
        this.g = paramString;
        this.h = paramInt2;
        this.f = paramBoolean;
        this.i = paramInt3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        af.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/CreateFileRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */