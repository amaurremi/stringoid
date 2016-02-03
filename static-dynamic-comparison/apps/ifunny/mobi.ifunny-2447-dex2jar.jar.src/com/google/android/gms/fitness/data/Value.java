package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Value
        implements SafeParcelable {
    public static final Parcelable.Creator<Value> CREATOR = new v();
    private final int a;
    private final int b;
    private boolean c;
    private float d;

    Value(int paramInt1, int paramInt2, boolean paramBoolean, float paramFloat) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramBoolean;
        this.d = paramFloat;
    }

    private boolean a(Value paramValue) {
        if ((this.b == paramValue.b) && (this.c == paramValue.c)) {
            switch (this.b) {
                default:
                    if (this.d != paramValue.d) {
                        break;
                    }
                case 1:
                case 2:
                    do {
                        do {
                            return true;
                        } while (c() == paramValue.c());
                        return false;
                    } while (d() == paramValue.d());
                    return false;
            }
            return false;
        }
        return false;
    }

    public boolean a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        boolean bool = true;
        if (this.b == 1) {
        }
        for (; ; ) {
            ag.a(bool, "Value is not in int format");
            return Float.floatToRawIntBits(this.d);
            bool = false;
        }
    }

    public float d() {
        if (this.b == 2) {
        }
        for (boolean bool = true; ; bool = false) {
            ag.a(bool, "Value is not in float format");
            return this.d;
        }
    }

    public int describeContents() {
        return 0;
    }

    int e() {
        return this.a;
    }

    public boolean equals(Object paramObject) {
        return (this == paramObject) || (((paramObject instanceof Value)) && (a((Value) paramObject)));
    }

    float f() {
        return this.d;
    }

    public int hashCode() {
        return ad.a(new Object[]{Float.valueOf(this.d), Integer.valueOf(this.b), Boolean.valueOf(this.c)});
    }

    public String toString() {
        switch (this.b) {
            default:
                return "unknown";
            case 1:
                return Integer.toString(c());
        }
        return Float.toString(d());
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        v.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/Value.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */