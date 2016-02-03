package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.op;

import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata
        implements SafeParcelable {
    public static final Parcelable.Creator<ApplicationMetadata> CREATOR = new a();
    String a;
    String b;
    List<WebImage> c;
    List<String> d;
    String e;
    Uri f;
    private final int g;

    private ApplicationMetadata() {
        this.g = 1;
        this.c = new ArrayList();
        this.d = new ArrayList();
    }

    ApplicationMetadata(int paramInt, String paramString1, String paramString2, List<WebImage> paramList, List<String> paramList1, String paramString3, Uri paramUri) {
        this.g = paramInt;
        this.a = paramString1;
        this.b = paramString2;
        this.c = paramList;
        this.d = paramList1;
        this.e = paramString3;
        this.f = paramUri;
    }

    int a() {
        return this.g;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public Uri e() {
        return this.f;
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            return true;
            if (!(paramObject instanceof ApplicationMetadata)) {
                return false;
            }
            paramObject = (ApplicationMetadata) paramObject;
        }
        while ((op.a(this.a, ((ApplicationMetadata) paramObject).a)) && (op.a(this.c, ((ApplicationMetadata) paramObject).c)) && (op.a(this.b, ((ApplicationMetadata) paramObject).b)) && (op.a(this.d, ((ApplicationMetadata) paramObject).d)) && (op.a(this.e, ((ApplicationMetadata) paramObject).e)) && (op.a(this.f, ((ApplicationMetadata) paramObject).f)));
        return false;
    }

    public List<WebImage> f() {
        return this.c;
    }

    public int hashCode() {
        return ad.a(new Object[]{Integer.valueOf(this.g), this.a, this.b, this.c, this.d, this.e, this.f});
    }

    public String toString() {
        return this.b;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/cast/ApplicationMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */