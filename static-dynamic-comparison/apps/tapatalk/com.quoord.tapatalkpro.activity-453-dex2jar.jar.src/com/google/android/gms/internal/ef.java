package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ef
        implements Parcelable {
    @Deprecated
    public static final Parcelable.Creator<ef> CREATOR = new Parcelable.Creator() {
        @Deprecated
        public ef i(Parcel paramAnonymousParcel) {
            return new ef(paramAnonymousParcel);
        }

        @Deprecated
        public ef[] u(int paramAnonymousInt) {
            return new ef[paramAnonymousInt];
        }
    };
    private String mValue;
    private String wp;
    private String wq;

    @Deprecated
    public ef() {
    }

    @Deprecated
    ef(Parcel paramParcel) {
        readFromParcel(paramParcel);
    }

    public ef(String paramString1, String paramString2, String paramString3) {
        this.wp = paramString1;
        this.wq = paramString2;
        this.mValue = paramString3;
    }

    @Deprecated
    private void readFromParcel(Parcel paramParcel) {
        this.wp = paramParcel.readString();
        this.wq = paramParcel.readString();
        this.mValue = paramParcel.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.wp;
    }

    public String getValue() {
        return this.mValue;
    }

    @Deprecated
    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.wp);
        paramParcel.writeString(this.wq);
        paramParcel.writeString(this.mValue);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */