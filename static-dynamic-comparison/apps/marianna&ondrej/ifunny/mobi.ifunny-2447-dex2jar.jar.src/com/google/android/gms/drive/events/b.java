package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

import java.util.ArrayList;

public class b
        implements Parcelable.Creator<CompletionEvent> {
    static void a(CompletionEvent paramCompletionEvent, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramCompletionEvent.a);
        c.a(paramParcel, 2, paramCompletionEvent.b, paramInt, false);
        c.a(paramParcel, 3, paramCompletionEvent.c, false);
        c.a(paramParcel, 4, paramCompletionEvent.d, paramInt, false);
        c.a(paramParcel, 5, paramCompletionEvent.e, paramInt, false);
        c.a(paramParcel, 6, paramCompletionEvent.f, paramInt, false);
        c.b(paramParcel, 7, paramCompletionEvent.g, false);
        c.a(paramParcel, 8, paramCompletionEvent.h);
        c.a(paramParcel, 9, paramCompletionEvent.i, false);
        c.a(paramParcel, i);
    }

    public CompletionEvent a(Parcel paramParcel) {
        int i = 0;
        IBinder localIBinder = null;
        int k = a.b(paramParcel);
        ArrayList localArrayList = null;
        MetadataBundle localMetadataBundle = null;
        ParcelFileDescriptor localParcelFileDescriptor1 = null;
        ParcelFileDescriptor localParcelFileDescriptor2 = null;
        String str = null;
        DriveId localDriveId = null;
        int j = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    j = a.g(paramParcel, m);
                    break;
                case 2:
                    localDriveId = (DriveId) a.a(paramParcel, m, DriveId.CREATOR);
                    break;
                case 3:
                    str = a.o(paramParcel, m);
                    break;
                case 4:
                    localParcelFileDescriptor2 = (ParcelFileDescriptor) a.a(paramParcel, m, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    localParcelFileDescriptor1 = (ParcelFileDescriptor) a.a(paramParcel, m, ParcelFileDescriptor.CREATOR);
                    break;
                case 6:
                    localMetadataBundle = (MetadataBundle) a.a(paramParcel, m, MetadataBundle.CREATOR);
                    break;
                case 7:
                    localArrayList = a.C(paramParcel, m);
                    break;
                case 8:
                    i = a.g(paramParcel, m);
                    break;
                case 9:
                    localIBinder = a.p(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + k, paramParcel);
        }
        return new CompletionEvent(j, localDriveId, str, localParcelFileDescriptor2, localParcelFileDescriptor1, localMetadataBundle, localArrayList, i, localIBinder);
    }

    public CompletionEvent[] a(int paramInt) {
        return new CompletionEvent[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/events/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */