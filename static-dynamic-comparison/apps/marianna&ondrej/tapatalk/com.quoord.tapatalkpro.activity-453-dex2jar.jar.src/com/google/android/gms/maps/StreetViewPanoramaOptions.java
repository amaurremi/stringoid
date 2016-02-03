package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions
        implements SafeParcelable {
    public static final StreetViewPanoramaOptionsCreator CREATOR = new StreetViewPanoramaOptionsCreator();
    private Boolean RJ;
    private Boolean RP = Boolean.valueOf(true);
    private StreetViewPanoramaCamera Sl;
    private String Sm;
    private LatLng Sn;
    private Integer So;
    private Boolean Sp = Boolean.valueOf(true);
    private Boolean Sq = Boolean.valueOf(true);
    private Boolean Sr = Boolean.valueOf(true);
    private final int xH;

    public StreetViewPanoramaOptions() {
        this.xH = 1;
    }

    StreetViewPanoramaOptions(int paramInt, StreetViewPanoramaCamera paramStreetViewPanoramaCamera, String paramString, LatLng paramLatLng, Integer paramInteger, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5) {
        this.xH = paramInt;
        this.Sl = paramStreetViewPanoramaCamera;
        this.Sn = paramLatLng;
        this.So = paramInteger;
        this.Sm = paramString;
        this.Sp = a.a(paramByte1);
        this.RP = a.a(paramByte2);
        this.Sq = a.a(paramByte3);
        this.Sr = a.a(paramByte4);
        this.RJ = a.a(paramByte5);
    }

    public int describeContents() {
        return 0;
    }

    public Boolean getPanningGesturesEnabled() {
        return this.Sq;
    }

    public String getPanoramaId() {
        return this.Sm;
    }

    public LatLng getPosition() {
        return this.Sn;
    }

    public Integer getRadius() {
        return this.So;
    }

    public Boolean getStreetNamesEnabled() {
        return this.Sr;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.Sl;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.RJ;
    }

    public Boolean getUserNavigationEnabled() {
        return this.Sp;
    }

    int getVersionCode() {
        return this.xH;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.RP;
    }

    byte ih() {
        return a.c(this.RJ);
    }

    byte il() {
        return a.c(this.RP);
    }

    byte it() {
        return a.c(this.Sp);
    }

    byte iu() {
        return a.c(this.Sq);
    }

    byte iv() {
        return a.c(this.Sr);
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean paramBoolean) {
        this.Sq = Boolean.valueOf(paramBoolean);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera paramStreetViewPanoramaCamera) {
        this.Sl = paramStreetViewPanoramaCamera;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(String paramString) {
        this.Sm = paramString;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng paramLatLng) {
        this.Sn = paramLatLng;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng paramLatLng, Integer paramInteger) {
        this.Sn = paramLatLng;
        this.So = paramInteger;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean paramBoolean) {
        this.Sr = Boolean.valueOf(paramBoolean);
        return this;
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean paramBoolean) {
        this.RJ = Boolean.valueOf(paramBoolean);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean paramBoolean) {
        this.Sp = Boolean.valueOf(paramBoolean);
        return this;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        StreetViewPanoramaOptionsCreator.a(this, paramParcel, paramInt);
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean paramBoolean) {
        this.RP = Boolean.valueOf(paramBoolean);
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/StreetViewPanoramaOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */