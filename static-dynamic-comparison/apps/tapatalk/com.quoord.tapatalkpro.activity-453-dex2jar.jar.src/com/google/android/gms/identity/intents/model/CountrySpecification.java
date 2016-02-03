package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CountrySpecification
        implements SafeParcelable {
    public static final Parcelable.Creator<CountrySpecification> CREATOR = new a();
    String qd;
    private final int xH;

    CountrySpecification(int paramInt, String paramString) {
        this.xH = paramInt;
        this.qd = paramString;
    }

    public CountrySpecification(String paramString) {
        this.xH = 1;
        this.qd = paramString;
    }

    public int describeContents() {
        return 0;
    }

    public String getCountryCode() {
        return this.qd;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/identity/intents/model/CountrySpecification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */