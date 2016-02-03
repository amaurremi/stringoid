package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class f
        implements Parcelable.Creator<UserMetadata> {
    static void a(UserMetadata paramUserMetadata, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramUserMetadata.a);
        c.a(paramParcel, 2, paramUserMetadata.b, false);
        c.a(paramParcel, 3, paramUserMetadata.c, false);
        c.a(paramParcel, 4, paramUserMetadata.d, false);
        c.a(paramParcel, 5, paramUserMetadata.e);
        c.a(paramParcel, 6, paramUserMetadata.f, false);
        c.a(paramParcel, paramInt);
    }

    public UserMetadata a(Parcel paramParcel) {
        boolean bool = false;
        String str1 = null;
        int j = a.b(paramParcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
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
                    str4 = a.o(paramParcel, k);
                    break;
                case 3:
                    str3 = a.o(paramParcel, k);
                    break;
                case 4:
                    str2 = a.o(paramParcel, k);
                    break;
                case 5:
                    bool = a.c(paramParcel, k);
                    break;
                case 6:
                    str1 = a.o(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new UserMetadata(i, str4, str3, str2, bool, str1);
    }

    public UserMetadata[] a(int paramInt) {
        return new UserMetadata[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */