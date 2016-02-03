package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomPropertyKey
        implements SafeParcelable {
    public static final Parcelable.Creator<CustomPropertyKey> CREATOR = new h();
    private static final Pattern d = Pattern.compile("[\\w.!@$%^&*()/-]+");
    final int a;
    final String b;
    final int c;

    CustomPropertyKey(int paramInt1, String paramString, int paramInt2) {
        ag.a(paramString, "key");
        ag.b(d.matcher(paramString).matches(), "key name characters must be alphanumeric or one of .!@$%^&*()-_/");
        boolean bool1 = bool2;
        if (paramInt2 != 0) {
            if (paramInt2 != 1) {
                break label69;
            }
        }
        label69:
        for (bool1 = bool2; ; bool1 = false) {
            ag.b(bool1, "visibility must be either PUBLIC or PRIVATE");
            this.a = paramInt1;
            this.b = paramString;
            this.c = paramInt2;
            return;
        }
    }

    public String a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        boolean bool = true;
        if (paramObject == null) {
        }
        do {
            return false;
            if (paramObject == this) {
                return true;
            }
        } while (!(paramObject instanceof CustomPropertyKey));
        paramObject = (CustomPropertyKey) paramObject;
        if ((((CustomPropertyKey) paramObject).a().equals(this.b)) && (((CustomPropertyKey) paramObject).b() == this.c)) {
        }
        for (; ; ) {
            return bool;
            bool = false;
        }
    }

    public int hashCode() {
        return (this.b + this.c).hashCode();
    }

    public String toString() {
        return "CustomPropertyKey(" + this.b + "," + this.c + ")";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        h.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/metadata/CustomPropertyKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */