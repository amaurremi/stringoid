package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class b
        implements Parcelable.Creator<FieldOnlyFilter> {
    static void a(FieldOnlyFilter paramFieldOnlyFilter, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1000, paramFieldOnlyFilter.b);
        c.a(paramParcel, 1, paramFieldOnlyFilter.a, paramInt, false);
        c.a(paramParcel, i);
    }

    public FieldOnlyFilter a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        MetadataBundle localMetadataBundle = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 1:
                    localMetadataBundle = (MetadataBundle) a.a(paramParcel, k, MetadataBundle.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + j, paramParcel);
        }
        return new FieldOnlyFilter(i, localMetadataBundle);
    }

    public FieldOnlyFilter[] a(int paramInt) {
        return new FieldOnlyFilter[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/query/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */