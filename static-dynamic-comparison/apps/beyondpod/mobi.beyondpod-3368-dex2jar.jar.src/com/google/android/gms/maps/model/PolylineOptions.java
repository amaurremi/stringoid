package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolylineOptions
  implements SafeParcelable
{
  public static final PolylineOptionsCreator CREATOR = new PolylineOptionsCreator();
  private float CB = 10.0F;
  private final List<LatLng> CV;
  private boolean CX = false;
  private float Cw = 0.0F;
  private boolean Cx = true;
  private final int kg;
  private int mP = -16777216;
  
  public PolylineOptions()
  {
    this.kg = 1;
    this.CV = new ArrayList();
  }
  
  PolylineOptions(int paramInt1, List paramList, float paramFloat1, int paramInt2, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.kg = paramInt1;
    this.CV = paramList;
    this.CB = paramFloat1;
    this.mP = paramInt2;
    this.Cw = paramFloat2;
    this.Cx = paramBoolean1;
    this.CX = paramBoolean2;
  }
  
  public PolylineOptions add(LatLng paramLatLng)
  {
    this.CV.add(paramLatLng);
    return this;
  }
  
  public PolylineOptions add(LatLng... paramVarArgs)
  {
    this.CV.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public PolylineOptions addAll(Iterable<LatLng> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      LatLng localLatLng = (LatLng)paramIterable.next();
      this.CV.add(localLatLng);
    }
    return this;
  }
  
  public PolylineOptions color(int paramInt)
  {
    this.mP = paramInt;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public PolylineOptions geodesic(boolean paramBoolean)
  {
    this.CX = paramBoolean;
    return this;
  }
  
  public int getColor()
  {
    return this.mP;
  }
  
  public List<LatLng> getPoints()
  {
    return this.CV;
  }
  
  int getVersionCode()
  {
    return this.kg;
  }
  
  public float getWidth()
  {
    return this.CB;
  }
  
  public float getZIndex()
  {
    return this.Cw;
  }
  
  public boolean isGeodesic()
  {
    return this.CX;
  }
  
  public boolean isVisible()
  {
    return this.Cx;
  }
  
  public PolylineOptions visible(boolean paramBoolean)
  {
    this.Cx = paramBoolean;
    return this;
  }
  
  public PolylineOptions width(float paramFloat)
  {
    this.CB = paramFloat;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (r.eD())
    {
      h.a(this, paramParcel, paramInt);
      return;
    }
    PolylineOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public PolylineOptions zIndex(float paramFloat)
  {
    this.Cw = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/maps/model/PolylineOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */