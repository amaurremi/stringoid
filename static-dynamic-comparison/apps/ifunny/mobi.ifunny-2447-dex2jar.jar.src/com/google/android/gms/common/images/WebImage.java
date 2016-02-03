package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WebImage
        implements SafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new h();
    private final int a;
    private final Uri b;
    private final int c;
    private final int d;

    WebImage(int paramInt1, Uri paramUri, int paramInt2, int paramInt3) {
        this.a = paramInt1;
        this.b = paramUri;
        this.c = paramInt2;
        this.d = paramInt3;
    }

    int a() {
        return this.a;
    }

    public Uri b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if ((paramObject == null) || (!(paramObject instanceof WebImage))) {
                return false;
            }
            paramObject = (WebImage) paramObject;
        }
        while ((ad.a(this.b, ((WebImage) paramObject).b)) && (this.c == ((WebImage) paramObject).c) && (this.d == ((WebImage) paramObject).d));
        return false;
    }

    public int hashCode() {
        return ad.a(new Object[]{this.b, Integer.valueOf(this.c), Integer.valueOf(this.d)});
    }

    public String toString() {
        return String.format("Image %dx%d %s", new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.d), this.b.toString()});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        h.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/images/WebImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */