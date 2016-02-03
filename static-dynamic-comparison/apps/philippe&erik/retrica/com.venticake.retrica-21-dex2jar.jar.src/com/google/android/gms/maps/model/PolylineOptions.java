package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolylineOptions
  implements SafeParcelable
{
  public static final PolylineOptionsCreator CREATOR = new PolylineOptionsCreator();
  private int Dj = -16777216;
  private float aaC = 10.0F;
  private final List<LatLng> aaX;
  private boolean aaZ = false;
  private float aax = 0.0F;
  private boolean aay = true;
  private final int xM;
  
  public PolylineOptions()
  {
    this.xM = 1;
    this.aaX = new ArrayList();
  }
  
  PolylineOptions(int paramInt1, List paramList, float paramFloat1, int paramInt2, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.xM = paramInt1;
    this.aaX = paramList;
    this.aaC = paramFloat1;
    this.Dj = paramInt2;
    this.aax = paramFloat2;
    this.aay = paramBoolean1;
    this.aaZ = paramBoolean2;
  }
  
  public PolylineOptions add(LatLng paramLatLng)
  {
    this.aaX.add(paramLatLng);
    return this;
  }
  
  public PolylineOptions add(LatLng... paramVarArgs)
  {
    this.aaX.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public PolylineOptions addAll(Iterable<LatLng> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      LatLng localLatLng = (LatLng)paramIterable.next();
      this.aaX.add(localLatLng);
    }
    return this;
  }
  
  public PolylineOptions color(int paramInt)
  {
    this.Dj = paramInt;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public PolylineOptions geodesic(boolean paramBoolean)
  {
    this.aaZ = paramBoolean;
    return this;
  }
  
  public int getColor()
  {
    return this.Dj;
  }
  
  public List<LatLng> getPoints()
  {
    return this.aaX;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public float getWidth()
  {
    return this.aaC;
  }
  
  public float getZIndex()
  {
    return this.aax;
  }
  
  public boolean isGeodesic()
  {
    return this.aaZ;
  }
  
  public boolean isVisible()
  {
    return this.aay;
  }
  
  public PolylineOptions visible(boolean paramBoolean)
  {
    this.aay = paramBoolean;
    return this;
  }
  
  public PolylineOptions width(float paramFloat)
  {
    this.aaC = paramFloat;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.jL())
    {
      h.a(this, paramParcel, paramInt);
      return;
    }
    PolylineOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public PolylineOptions zIndex(float paramFloat)
  {
    this.aax = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/model/PolylineOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */