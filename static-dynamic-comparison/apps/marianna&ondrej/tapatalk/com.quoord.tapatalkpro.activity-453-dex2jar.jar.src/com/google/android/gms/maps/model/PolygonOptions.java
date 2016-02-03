package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolygonOptions
        implements SafeParcelable {
    public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();
    private float SK = 10.0F;
    private int SL = -16777216;
    private int SM = 0;
    private float SN = 0.0F;
    private boolean SO = true;
    private final List<LatLng> Tn;
    private final List<List<LatLng>> To;
    private boolean Tp = false;
    private final int xH;

    public PolygonOptions() {
        this.xH = 1;
        this.Tn = new ArrayList();
        this.To = new ArrayList();
    }

    PolygonOptions(int paramInt1, List<LatLng> paramList, List paramList1, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2) {
        this.xH = paramInt1;
        this.Tn = paramList;
        this.To = paramList1;
        this.SK = paramFloat1;
        this.SL = paramInt2;
        this.SM = paramInt3;
        this.SN = paramFloat2;
        this.SO = paramBoolean1;
        this.Tp = paramBoolean2;
    }

    public PolygonOptions add(LatLng paramLatLng) {
        this.Tn.add(paramLatLng);
        return this;
    }

    public PolygonOptions add(LatLng... paramVarArgs) {
        this.Tn.addAll(Arrays.asList(paramVarArgs));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> paramIterable) {
        paramIterable = paramIterable.iterator();
        while (paramIterable.hasNext()) {
            LatLng localLatLng = (LatLng) paramIterable.next();
            this.Tn.add(localLatLng);
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> paramIterable) {
        ArrayList localArrayList = new ArrayList();
        paramIterable = paramIterable.iterator();
        while (paramIterable.hasNext()) {
            localArrayList.add((LatLng) paramIterable.next());
        }
        this.To.add(localArrayList);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolygonOptions fillColor(int paramInt) {
        this.SM = paramInt;
        return this;
    }

    public PolygonOptions geodesic(boolean paramBoolean) {
        this.Tp = paramBoolean;
        return this;
    }

    public int getFillColor() {
        return this.SM;
    }

    public List<List<LatLng>> getHoles() {
        return this.To;
    }

    public List<LatLng> getPoints() {
        return this.Tn;
    }

    public int getStrokeColor() {
        return this.SL;
    }

    public float getStrokeWidth() {
        return this.SK;
    }

    int getVersionCode() {
        return this.xH;
    }

    public float getZIndex() {
        return this.SN;
    }

    List iF() {
        return this.To;
    }

    public boolean isGeodesic() {
        return this.Tp;
    }

    public boolean isVisible() {
        return this.SO;
    }

    public PolygonOptions strokeColor(int paramInt) {
        this.SL = paramInt;
        return this;
    }

    public PolygonOptions strokeWidth(float paramFloat) {
        this.SK = paramFloat;
        return this;
    }

    public PolygonOptions visible(boolean paramBoolean) {
        this.SO = paramBoolean;
        return this;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        if (v.iB()) {
            g.a(this, paramParcel, paramInt);
            return;
        }
        PolygonOptionsCreator.a(this, paramParcel, paramInt);
    }

    public PolygonOptions zIndex(float paramFloat) {
        this.SN = paramFloat;
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/model/PolygonOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */