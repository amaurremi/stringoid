package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions
        implements SafeParcelable {
    public static final GoogleMapOptionsCreator CREATOR = new GoogleMapOptionsCreator();
    private Boolean RI;
    private Boolean RJ;
    private int RK = -1;
    private CameraPosition RL;
    private Boolean RM;
    private Boolean RN;
    private Boolean RO;
    private Boolean RP;
    private Boolean RQ;
    private Boolean RR;
    private final int xH;

    public GoogleMapOptions() {
        this.xH = 1;
    }

    GoogleMapOptions(int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, CameraPosition paramCameraPosition, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8) {
        this.xH = paramInt1;
        this.RI = com.google.android.gms.maps.internal.a.a(paramByte1);
        this.RJ = com.google.android.gms.maps.internal.a.a(paramByte2);
        this.RK = paramInt2;
        this.RL = paramCameraPosition;
        this.RM = com.google.android.gms.maps.internal.a.a(paramByte3);
        this.RN = com.google.android.gms.maps.internal.a.a(paramByte4);
        this.RO = com.google.android.gms.maps.internal.a.a(paramByte5);
        this.RP = com.google.android.gms.maps.internal.a.a(paramByte6);
        this.RQ = com.google.android.gms.maps.internal.a.a(paramByte7);
        this.RR = com.google.android.gms.maps.internal.a.a(paramByte8);
    }

    public static GoogleMapOptions createFromAttributes(Context paramContext, AttributeSet paramAttributeSet) {
        if (paramAttributeSet == null) {
            return null;
        }
        TypedArray localTypedArray = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.MapAttrs);
        GoogleMapOptions localGoogleMapOptions = new GoogleMapOptions();
        if (localTypedArray.hasValue(0)) {
            localGoogleMapOptions.mapType(localTypedArray.getInt(0, -1));
        }
        if (localTypedArray.hasValue(13)) {
            localGoogleMapOptions.zOrderOnTop(localTypedArray.getBoolean(13, false));
        }
        if (localTypedArray.hasValue(12)) {
            localGoogleMapOptions.useViewLifecycleInFragment(localTypedArray.getBoolean(12, false));
        }
        if (localTypedArray.hasValue(6)) {
            localGoogleMapOptions.compassEnabled(localTypedArray.getBoolean(6, true));
        }
        if (localTypedArray.hasValue(7)) {
            localGoogleMapOptions.rotateGesturesEnabled(localTypedArray.getBoolean(7, true));
        }
        if (localTypedArray.hasValue(8)) {
            localGoogleMapOptions.scrollGesturesEnabled(localTypedArray.getBoolean(8, true));
        }
        if (localTypedArray.hasValue(9)) {
            localGoogleMapOptions.tiltGesturesEnabled(localTypedArray.getBoolean(9, true));
        }
        if (localTypedArray.hasValue(11)) {
            localGoogleMapOptions.zoomGesturesEnabled(localTypedArray.getBoolean(11, true));
        }
        if (localTypedArray.hasValue(10)) {
            localGoogleMapOptions.zoomControlsEnabled(localTypedArray.getBoolean(10, true));
        }
        localGoogleMapOptions.camera(CameraPosition.createFromAttributes(paramContext, paramAttributeSet));
        localTypedArray.recycle();
        return localGoogleMapOptions;
    }

    public GoogleMapOptions camera(CameraPosition paramCameraPosition) {
        this.RL = paramCameraPosition;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean paramBoolean) {
        this.RN = Boolean.valueOf(paramBoolean);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CameraPosition getCamera() {
        return this.RL;
    }

    public Boolean getCompassEnabled() {
        return this.RN;
    }

    public int getMapType() {
        return this.RK;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.RR;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.RO;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.RQ;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.RJ;
    }

    int getVersionCode() {
        return this.xH;
    }

    public Boolean getZOrderOnTop() {
        return this.RI;
    }

    public Boolean getZoomControlsEnabled() {
        return this.RM;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.RP;
    }

    byte ig() {
        return com.google.android.gms.maps.internal.a.c(this.RI);
    }

    byte ih() {
        return com.google.android.gms.maps.internal.a.c(this.RJ);
    }

    byte ii() {
        return com.google.android.gms.maps.internal.a.c(this.RM);
    }

    byte ij() {
        return com.google.android.gms.maps.internal.a.c(this.RN);
    }

    byte ik() {
        return com.google.android.gms.maps.internal.a.c(this.RO);
    }

    byte il() {
        return com.google.android.gms.maps.internal.a.c(this.RP);
    }

    byte im() {
        return com.google.android.gms.maps.internal.a.c(this.RQ);
    }

    byte in() {
        return com.google.android.gms.maps.internal.a.c(this.RR);
    }

    public GoogleMapOptions mapType(int paramInt) {
        this.RK = paramInt;
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean paramBoolean) {
        this.RR = Boolean.valueOf(paramBoolean);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean paramBoolean) {
        this.RO = Boolean.valueOf(paramBoolean);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean paramBoolean) {
        this.RQ = Boolean.valueOf(paramBoolean);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean paramBoolean) {
        this.RJ = Boolean.valueOf(paramBoolean);
        return this;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        if (v.iB()) {
            a.a(this, paramParcel, paramInt);
            return;
        }
        GoogleMapOptionsCreator.a(this, paramParcel, paramInt);
    }

    public GoogleMapOptions zOrderOnTop(boolean paramBoolean) {
        this.RI = Boolean.valueOf(paramBoolean);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean paramBoolean) {
        this.RM = Boolean.valueOf(paramBoolean);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean paramBoolean) {
        this.RP = Boolean.valueOf(paramBoolean);
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/GoogleMapOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */