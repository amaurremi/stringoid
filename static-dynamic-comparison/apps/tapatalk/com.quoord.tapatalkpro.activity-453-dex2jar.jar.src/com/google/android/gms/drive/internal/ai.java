package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class ai
        implements Parcelable.Creator<OpenFileIntentSenderRequest> {
    static void a(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.c(paramParcel, 1, paramOpenFileIntentSenderRequest.xH);
        b.a(paramParcel, 2, paramOpenFileIntentSenderRequest.EB, false);
        b.a(paramParcel, 3, paramOpenFileIntentSenderRequest.EQ, false);
        b.a(paramParcel, 4, paramOpenFileIntentSenderRequest.EC, paramInt, false);
        b.F(paramParcel, i);
    }

    public OpenFileIntentSenderRequest W(Parcel paramParcel) {
        DriveId localDriveId = null;
        int j = a.o(paramParcel);
        int i = 0;
        String[] arrayOfString = null;
        String str = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.n(paramParcel);
            switch (a.R(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    str = a.n(paramParcel, k);
                    break;
                case 3:
                    arrayOfString = a.z(paramParcel, k);
                    break;
                case 4:
                    localDriveId = (DriveId) a.a(paramParcel, k, DriveId.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new OpenFileIntentSenderRequest(i, str, arrayOfString, localDriveId);
    }

    public OpenFileIntentSenderRequest[] aA(int paramInt) {
        return new OpenFileIntentSenderRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/internal/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */