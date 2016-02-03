package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;

public class FieldOnlyFilter
        implements SafeParcelable, Filter {
    public static final Parcelable.Creator<FieldOnlyFilter> CREATOR = new b();
    final MetadataBundle GH;
    private final MetadataField<?> GI;
    final int xH;

    FieldOnlyFilter(int paramInt, MetadataBundle paramMetadataBundle) {
        this.xH = paramInt;
        this.GH = paramMetadataBundle;
        this.GI = e.b(paramMetadataBundle);
    }

    public FieldOnlyFilter(SearchableMetadataField<?> paramSearchableMetadataField) {
        this(1, MetadataBundle.a(paramSearchableMetadataField, null));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        b.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/query/internal/FieldOnlyFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */