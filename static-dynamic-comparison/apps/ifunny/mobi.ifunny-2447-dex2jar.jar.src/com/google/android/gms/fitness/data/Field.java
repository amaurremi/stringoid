package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Field
        implements SafeParcelable {
    public static final Parcelable.Creator<Field> CREATOR = new j();
    private final int a;
    private final String b;
    private final int c;

    Field(int paramInt1, String paramString, int paramInt2) {
        this.a = paramInt1;
        this.b = paramString;
        this.c = paramInt2;
    }

    private boolean a(Field paramField) {
        return (this.b.equals(paramField.b)) && (this.c == paramField.c);
    }

    public String a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    int c() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return (this == paramObject) || (((paramObject instanceof Field)) && (a((Field) paramObject)));
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        String str2 = this.b;
        if (this.c == 1) {
        }
        for (String str1 = "i"; ; str1 = "f") {
            return String.format("%s(%s)", new Object[]{str2, str1});
        }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        j.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */