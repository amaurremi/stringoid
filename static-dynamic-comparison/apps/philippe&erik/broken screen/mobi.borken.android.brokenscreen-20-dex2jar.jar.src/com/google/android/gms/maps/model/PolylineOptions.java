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
  private int Dg = -16777216;
  private final List<LatLng> aaU;
  private boolean aaW = false;
  private float aau = 0.0F;
  private boolean aav = true;
  private float aaz = 10.0F;
  private final int xJ;
  
  public PolylineOptions()
  {
    this.xJ = 1;
    this.aaU = new ArrayList();
  }
  
  PolylineOptions(int paramInt1, List paramList, float paramFloat1, int paramInt2, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.xJ = paramInt1;
    this.aaU = paramList;
    this.aaz = paramFloat1;
    this.Dg = paramInt2;
    this.aau = paramFloat2;
    this.aav = paramBoolean1;
    this.aaW = paramBoolean2;
  }
  
  public PolylineOptions add(LatLng paramLatLng)
  {
    this.aaU.add(paramLatLng);
    return this;
  }
  
  public PolylineOptions add(LatLng... paramVarArgs)
  {
    this.aaU.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public PolylineOptions addAll(Iterable<LatLng> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      LatLng localLatLng = (LatLng)paramIterable.next();
      this.aaU.add(localLatLng);
    }
    return this;
  }
  
  public PolylineOptions color(int paramInt)
  {
    this.Dg = paramInt;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public PolylineOptions geodesic(boolean paramBoolean)
  {
    this.aaW = paramBoolean;
    return this;
  }
  
  public int getColor()
  {
    return this.Dg;
  }
  
  public List<LatLng> getPoints()
  {
    return this.aaU;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public float getWidth()
  {
    return this.aaz;
  }
  
  public float getZIndex()
  {
    return this.aau;
  }
  
  public boolean isGeodesic()
  {
    return this.aaW;
  }
  
  public boolean isVisible()
  {
    return this.aav;
  }
  
  public PolylineOptions visible(boolean paramBoolean)
  {
    this.aav = paramBoolean;
    return this;
  }
  
  public PolylineOptions width(float paramFloat)
  {
    this.aaz = paramFloat;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.jG())
    {
      h.a(this, paramParcel, paramInt);
      return;
    }
    PolylineOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public PolylineOptions zIndex(float paramFloat)
  {
    this.aau = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/maps/model/PolylineOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */