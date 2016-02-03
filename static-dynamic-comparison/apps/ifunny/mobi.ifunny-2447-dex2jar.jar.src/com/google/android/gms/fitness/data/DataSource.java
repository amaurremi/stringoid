package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.qt;

public class DataSource
        implements SafeParcelable {
    public static final Parcelable.Creator<DataSource> CREATOR = new g();
    private final int a;
    private final DataType b;
    private final String c;
    private final int d;
    private final Device e;
    private final a f;
    private final String g;
    private final boolean h;
    private final String i;

    DataSource(int paramInt1, DataType paramDataType, String paramString1, int paramInt2, Device paramDevice, a parama, String paramString2, boolean paramBoolean) {
        this.a = paramInt1;
        this.b = paramDataType;
        this.d = paramInt2;
        this.c = paramString1;
        this.e = paramDevice;
        this.f = parama;
        this.g = paramString2;
        this.h = paramBoolean;
        this.i = l();
    }

    private boolean a(DataSource paramDataSource) {
        return (this.b.equals(paramDataSource.b)) && (this.d == paramDataSource.d) && (ad.a(this.c, paramDataSource.c)) && (ad.a(this.e, paramDataSource.e)) && (ad.a(this.g, paramDataSource.g)) && (ad.a(this.f, paramDataSource.f));
    }

    private String l() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(m());
        localStringBuilder.append(":").append(this.b.a());
        if (this.f != null) {
            localStringBuilder.append(":").append(this.f.a());
        }
        if (this.e != null) {
            localStringBuilder.append(":").append(this.e.e());
        }
        if (this.g != null) {
            localStringBuilder.append(":").append(this.g);
        }
        return localStringBuilder.toString();
    }

    private String m() {
        switch (this.d) {
            default:
                throw new IllegalArgumentException("invalid type value");
            case 0:
                return "raw";
        }
        return "derived";
    }

    public DataType a() {
        return this.b;
    }

    public int b() {
        return this.d;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        if (this.f == null) {
            return null;
        }
        return this.f.a();
    }

    public int describeContents() {
        return 0;
    }

    public a e() {
        return this.f;
    }

    public boolean equals(Object paramObject) {
        return (this == paramObject) || (((paramObject instanceof DataSource)) && (a((DataSource) paramObject)));
    }

    public Device f() {
        return this.e;
    }

    public String g() {
        return this.g;
    }

    public boolean h() {
        return this.h;
    }

    public int hashCode() {
        return this.i.hashCode();
    }

    public String i() {
        StringBuilder localStringBuilder = new StringBuilder();
        if (this.d == 0) {
            str = "r";
            localStringBuilder = localStringBuilder.append(str).append(":").append(this.b.c());
            if (this.f != null) {
                break label139;
            }
            str = "";
            label49:
            localStringBuilder = localStringBuilder.append(str);
            if (this.e == null) {
                break label187;
            }
            str = ":" + this.e.b();
            label88:
            localStringBuilder = localStringBuilder.append(str);
            if (this.g == null) {
                break label193;
            }
        }
        label139:
        label187:
        label193:
        for (String str = ":" + this.g; ; str = "") {
            return str;
            str = "d";
            break;
            if (this.f.equals(a.a)) {
                str = ":gms";
                break label49;
            }
            str = ":" + this.f.a();
            break label49;
            str = "";
            break label88;
        }
    }

    public DataSource j() {
        Device localDevice;
        if (this.e == null) {
            localDevice = null;
            if (this.f != null) {
                break label63;
            }
        }
        label63:
        for (a locala = null; ; locala = this.f.d()) {
            return new DataSource(3, this.b, this.c, this.d, localDevice, locala, qt.a(this.g), this.h);
            localDevice = this.e.f();
            break;
        }
    }

    int k() {
        return this.a;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("DataSource{");
        localStringBuilder.append(m());
        if (this.c != null) {
            localStringBuilder.append(":").append(this.c);
        }
        if (this.f != null) {
            localStringBuilder.append(":").append(this.f);
        }
        if (this.e != null) {
            localStringBuilder.append(":").append(this.e);
        }
        if (this.g != null) {
            localStringBuilder.append(":").append(this.g);
        }
        localStringBuilder.append(":").append(this.b);
        return "}";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        g.a(qt.a(this), paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/DataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */