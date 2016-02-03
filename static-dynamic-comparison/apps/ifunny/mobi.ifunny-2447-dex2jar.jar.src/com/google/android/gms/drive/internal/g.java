package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class g
        implements Parcelable.Creator<OnDownloadProgressResponse> {
    static void a(OnDownloadProgressResponse paramOnDownloadProgressResponse, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramOnDownloadProgressResponse.a);
        c.a(paramParcel, 2, paramOnDownloadProgressResponse.b);
        c.a(paramParcel, 3, paramOnDownloadProgressResponse.c);
        c.a(paramParcel, paramInt);
    }

    public OnDownloadProgressResponse a(Parcel paramParcel) {
        long l1 = 0L;
        int j = a.b(paramParcel);
        int i = 0;
        long l2 = 0L;
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
                    l2 = a.i(paramParcel, k);
                    break;
                case 3:
                    l1 = a.i(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new OnDownloadProgressResponse(i, l2, l1);
    }

    public OnDownloadProgressResponse[] a(int paramInt) {
        return new OnDownloadProgressResponse[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */