package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fv
        implements SafeParcelable {
    public static final fw CREATOR = new fw();
    private final fx DS;
    private final int xH;

    fv(int paramInt, fx paramfx) {
        this.xH = paramInt;
        this.DS = paramfx;
    }

    private fv(fx paramfx) {
        this.xH = 1;
        this.DS = paramfx;
    }

    public static fv a(ga.b<?, ?> paramb) {
        if ((paramb instanceof fx)) {
            return new fv((fx) paramb);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public int describeContents() {
        fw localfw = CREATOR;
        return 0;
    }

    fx eT() {
        return this.DS;
    }

    public ga.b<?, ?> eU() {
        if (this.DS != null) {
            return this.DS;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        fw localfw = CREATOR;
        fw.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/fv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */