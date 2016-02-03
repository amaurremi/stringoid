package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.Locale;

public class FieldWithSortOrder
        implements SafeParcelable {
    public static final c CREATOR = new c();
    final String a;
    final boolean b;
    final int c;

    FieldWithSortOrder(int paramInt, String paramString, boolean paramBoolean) {
        this.c = paramInt;
        this.a = paramString;
        this.b = paramBoolean;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        Locale localLocale = Locale.US;
        String str2 = this.a;
        if (this.b) {
        }
        for (String str1 = "ASC"; ; str1 = "DESC") {
            return String.format(localLocale, "FieldWithSortOrder[%s %s]", new Object[]{str2, str1});
        }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        c.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/query/internal/FieldWithSortOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */