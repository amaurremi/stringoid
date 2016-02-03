package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.DrivePreferences;

public class i
        implements Parcelable.Creator<OnDrivePreferencesResponse> {
    static void a(OnDrivePreferencesResponse paramOnDrivePreferencesResponse, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramOnDrivePreferencesResponse.a);
        c.a(paramParcel, 2, paramOnDrivePreferencesResponse.b, paramInt, false);
        c.a(paramParcel, i);
    }

    public OnDrivePreferencesResponse a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        DrivePreferences localDrivePreferences = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localDrivePreferences = (DrivePreferences) a.a(paramParcel, k, DrivePreferences.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new OnDrivePreferencesResponse(i, localDrivePreferences);
    }

    public OnDrivePreferencesResponse[] a(int paramInt) {
        return new OnDrivePreferencesResponse[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */