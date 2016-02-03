package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.op;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CastDevice
        implements SafeParcelable {
    public static final Parcelable.Creator<CastDevice> CREATOR = new b();
    String a;
    private final int b;
    private String c;
    private Inet4Address d;
    private String e;
    private String f;
    private String g;
    private int h;
    private List<WebImage> i;
    private int j;
    private int k;

    private CastDevice() {
        this(3, null, null, null, null, null, -1, new ArrayList(), 0, -1);
    }

    CastDevice(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, List<WebImage> paramList, int paramInt3, int paramInt4) {
        this.b = paramInt1;
        this.c = paramString1;
        this.a = paramString2;
        if (this.a != null) {
        }
        try {
            paramString1 = InetAddress.getByName(this.a);
            if ((paramString1 instanceof Inet4Address)) {
                this.d = ((Inet4Address) paramString1);
            }
            this.e = paramString3;
            this.f = paramString4;
            this.g = paramString5;
            this.h = paramInt2;
            this.i = paramList;
            this.j = paramInt3;
            this.k = paramInt4;
            return;
        } catch (UnknownHostException paramString1) {
            for (; ; ) {
                this.d = null;
            }
        }
    }

    int a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.f;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.g;
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            do {
                return true;
                if (!(paramObject instanceof CastDevice)) {
                    return false;
                }
                paramObject = (CastDevice) paramObject;
                if (b() != null) {
                    break;
                }
            } while (((CastDevice) paramObject).b() == null);
            return false;
        }
        while ((op.a(this.c, ((CastDevice) paramObject).c)) && (op.a(this.d, ((CastDevice) paramObject).d)) && (op.a(this.f, ((CastDevice) paramObject).f)) && (op.a(this.e, ((CastDevice) paramObject).e)) && (op.a(this.g, ((CastDevice) paramObject).g)) && (this.h == ((CastDevice) paramObject).h) && (op.a(this.i, ((CastDevice) paramObject).i)) && (this.j == ((CastDevice) paramObject).j) && (this.k == ((CastDevice) paramObject).k));
        return false;
    }

    public int f() {
        return this.h;
    }

    public List<WebImage> g() {
        return Collections.unmodifiableList(this.i);
    }

    public int h() {
        return this.j;
    }

    public int hashCode() {
        if (this.c == null) {
            return 0;
        }
        return this.c.hashCode();
    }

    public int i() {
        return this.k;
    }

    public String toString() {
        return String.format("\"%s\" (%s)", new Object[]{this.e, this.c});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        b.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/cast/CastDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */