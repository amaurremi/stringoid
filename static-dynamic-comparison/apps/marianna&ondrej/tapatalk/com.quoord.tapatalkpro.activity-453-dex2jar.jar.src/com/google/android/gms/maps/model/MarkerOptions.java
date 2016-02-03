package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.maps.internal.v;

public final class MarkerOptions
        implements SafeParcelable {
    public static final MarkerOptionsCreator CREATOR = new MarkerOptionsCreator();
    private String EB;
    private boolean SO = true;
    private float SW = 0.5F;
    private float SX = 1.0F;
    private LatLng Sn;
    private String Tf;
    private BitmapDescriptor Tg;
    private boolean Th;
    private boolean Ti = false;
    private float Tj = 0.0F;
    private float Tk = 0.5F;
    private float Tl = 0.0F;
    private float mAlpha = 1.0F;
    private final int xH;

    public MarkerOptions() {
        this.xH = 1;
    }

    MarkerOptions(int paramInt, LatLng paramLatLng, String paramString1, String paramString2, IBinder paramIBinder, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
        this.xH = paramInt;
        this.Sn = paramLatLng;
        this.EB = paramString1;
        this.Tf = paramString2;
        if (paramIBinder == null) {
        }
        for (paramLatLng = null; ; paramLatLng = new BitmapDescriptor(d.a.K(paramIBinder))) {
            this.Tg = paramLatLng;
            this.SW = paramFloat1;
            this.SX = paramFloat2;
            this.Th = paramBoolean1;
            this.SO = paramBoolean2;
            this.Ti = paramBoolean3;
            this.Tj = paramFloat3;
            this.Tk = paramFloat4;
            this.Tl = paramFloat5;
            this.mAlpha = paramFloat6;
            return;
        }
    }

    public MarkerOptions alpha(float paramFloat) {
        this.mAlpha = paramFloat;
        return this;
    }

    public MarkerOptions anchor(float paramFloat1, float paramFloat2) {
        this.SW = paramFloat1;
        this.SX = paramFloat2;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public MarkerOptions draggable(boolean paramBoolean) {
        this.Th = paramBoolean;
        return this;
    }

    public MarkerOptions flat(boolean paramBoolean) {
        this.Ti = paramBoolean;
        return this;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getAnchorU() {
        return this.SW;
    }

    public float getAnchorV() {
        return this.SX;
    }

    public BitmapDescriptor getIcon() {
        return this.Tg;
    }

    public float getInfoWindowAnchorU() {
        return this.Tk;
    }

    public float getInfoWindowAnchorV() {
        return this.Tl;
    }

    public LatLng getPosition() {
        return this.Sn;
    }

    public float getRotation() {
        return this.Tj;
    }

    public String getSnippet() {
        return this.Tf;
    }

    public String getTitle() {
        return this.EB;
    }

    int getVersionCode() {
        return this.xH;
    }

    IBinder iE() {
        if (this.Tg == null) {
            return null;
        }
        return this.Tg.id().asBinder();
    }

    public MarkerOptions icon(BitmapDescriptor paramBitmapDescriptor) {
        this.Tg = paramBitmapDescriptor;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float paramFloat1, float paramFloat2) {
        this.Tk = paramFloat1;
        this.Tl = paramFloat2;
        return this;
    }

    public boolean isDraggable() {
        return this.Th;
    }

    public boolean isFlat() {
        return this.Ti;
    }

    public boolean isVisible() {
        return this.SO;
    }

    public MarkerOptions position(LatLng paramLatLng) {
        this.Sn = paramLatLng;
        return this;
    }

    public MarkerOptions rotation(float paramFloat) {
        this.Tj = paramFloat;
        return this;
    }

    public MarkerOptions snippet(String paramString) {
        this.Tf = paramString;
        return this;
    }

    public MarkerOptions title(String paramString) {
        this.EB = paramString;
        return this;
    }

    public MarkerOptions visible(boolean paramBoolean) {
        this.SO = paramBoolean;
        return this;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        if (v.iB()) {
            f.a(this, paramParcel, paramInt);
            return;
        }
        MarkerOptionsCreator.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/model/MarkerOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */