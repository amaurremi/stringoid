package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class a
        implements Parcelable.Creator<ApplicationMetadata> {
    static void a(ApplicationMetadata paramApplicationMetadata, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramApplicationMetadata.a());
        c.a(paramParcel, 2, paramApplicationMetadata.b(), false);
        c.a(paramParcel, 3, paramApplicationMetadata.c(), false);
        c.c(paramParcel, 4, paramApplicationMetadata.f(), false);
        c.b(paramParcel, 5, paramApplicationMetadata.d, false);
        c.a(paramParcel, 6, paramApplicationMetadata.d(), false);
        c.a(paramParcel, 7, paramApplicationMetadata.e(), paramInt, false);
        c.a(paramParcel, i);
    }

    public ApplicationMetadata a(Parcel paramParcel) {
        Uri localUri = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        int i = 0;
        String str1 = null;
        ArrayList localArrayList1 = null;
        ArrayList localArrayList2 = null;
        String str2 = null;
        String str3 = null;
        while (paramParcel.dataPosition() < j) {
            int k = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(k)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
                    break;
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
                    break;
                case 2:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 4:
                    localArrayList2 = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k, WebImage.CREATOR);
                    break;
                case 5:
                    localArrayList1 = com.google.android.gms.common.internal.safeparcel.a.C(paramParcel, k);
                    break;
                case 6:
                    str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 7:
                    localUri = (Uri) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, Uri.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new ApplicationMetadata(i, str3, str2, localArrayList2, localArrayList1, str1, localUri);
    }

    public ApplicationMetadata[] a(int paramInt) {
        return new ApplicationMetadata[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/cast/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */