package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class ho
        implements SafeParcelable {
    public static final Parcelable.Creator<ho> CREATOR = new hp();
    private final LatLng Re;
    private final String Rf;
    private final List<hm> Rg;
    private final String Rh;
    private final String Ri;
    private final String mName;
    final int xH;

    ho(int paramInt, String paramString1, LatLng paramLatLng, String paramString2, List<hm> paramList, String paramString3, String paramString4) {
        this.xH = paramInt;
        this.mName = paramString1;
        this.Re = paramLatLng;
        this.Rf = paramString2;
        this.Rg = new ArrayList(paramList);
        this.Rh = paramString3;
        this.Ri = paramString4;
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.Rf;
    }

    public String getName() {
        return this.mName;
    }

    public String getPhoneNumber() {
        return this.Rh;
    }

    public LatLng ia() {
        return this.Re;
    }

    public List<hm> ib() {
        return this.Rg;
    }

    public String ic() {
        return this.Ri;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        hp.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */