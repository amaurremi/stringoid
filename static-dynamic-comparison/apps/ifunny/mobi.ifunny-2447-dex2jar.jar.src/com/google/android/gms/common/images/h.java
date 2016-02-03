package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class h
        implements Parcelable.Creator<WebImage> {
    static void a(WebImage paramWebImage, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramWebImage.a());
        c.a(paramParcel, 2, paramWebImage.b(), paramInt, false);
        c.a(paramParcel, 3, paramWebImage.c());
        c.a(paramParcel, 4, paramWebImage.d());
        c.a(paramParcel, i);
    }

    public WebImage a(Parcel paramParcel) {
        int i = 0;
        int m = a.b(paramParcel);
        Uri localUri = null;
        int j = 0;
        int k = 0;
        if (paramParcel.dataPosition() < m) {
            int n = a.a(paramParcel);
            switch (a.a(n)) {
                default:
                    a.b(paramParcel, n);
            }
            for (; ; ) {
                break;
                k = a.g(paramParcel, n);
                continue;
                localUri = (Uri) a.a(paramParcel, n, Uri.CREATOR);
                continue;
                j = a.g(paramParcel, n);
                continue;
                i = a.g(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new WebImage(k, localUri, j, i);
    }

    public WebImage[] a(int paramInt) {
        return new WebImage[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/images/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */