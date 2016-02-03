package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.DriveId;

public class s
        implements Parcelable.Creator<OpenFileIntentSenderRequest> {
    static void a(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramOpenFileIntentSenderRequest.a);
        c.a(paramParcel, 2, paramOpenFileIntentSenderRequest.b, false);
        c.a(paramParcel, 3, paramOpenFileIntentSenderRequest.c, false);
        c.a(paramParcel, 4, paramOpenFileIntentSenderRequest.d, paramInt, false);
        c.a(paramParcel, i);
    }

    public OpenFileIntentSenderRequest a(Parcel paramParcel) {
        DriveId localDriveId = null;
        int j = a.b(paramParcel);
        int i = 0;
        String[] arrayOfString = null;
        String str = null;
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
                    str = a.o(paramParcel, k);
                    break;
                case 3:
                    arrayOfString = a.A(paramParcel, k);
                    break;
                case 4:
                    localDriveId = (DriveId) a.a(paramParcel, k, DriveId.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new OpenFileIntentSenderRequest(i, str, arrayOfString, localDriveId);
    }

    public OpenFileIntentSenderRequest[] a(int paramInt) {
        return new OpenFileIntentSenderRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */