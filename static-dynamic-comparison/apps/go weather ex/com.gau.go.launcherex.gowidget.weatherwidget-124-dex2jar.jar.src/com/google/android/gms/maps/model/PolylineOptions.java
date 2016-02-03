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
  private int Av = -16777216;
  private float SN = 0.0F;
  private boolean SO = true;
  private float SS = 10.0F;
  private final List<LatLng> Tn;
  private boolean Tp = false;
  private final int xH;
  
  public PolylineOptions()
  {
    this.xH = 1;
    this.Tn = new ArrayList();
  }
  
  PolylineOptions(int paramInt1, List paramList, float paramFloat1, int paramInt2, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.xH = paramInt1;
    this.Tn = paramList;
    this.SS = paramFloat1;
    this.Av = paramInt2;
    this.SN = paramFloat2;
    this.SO = paramBoolean1;
    this.Tp = paramBoolean2;
  }
  
  public PolylineOptions add(LatLng paramLatLng)
  {
    this.Tn.add(paramLatLng);
    return this;
  }
  
  public PolylineOptions add(LatLng... paramVarArgs)
  {
    this.Tn.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public PolylineOptions addAll(Iterable<LatLng> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      LatLng localLatLng = (LatLng)paramIterable.next();
      this.Tn.add(localLatLng);
    }
    return this;
  }
  
  public PolylineOptions color(int paramInt)
  {
    this.Av = paramInt;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public PolylineOptions geodesic(boolean paramBoolean)
  {
    this.Tp = paramBoolean;
    return this;
  }
  
  public int getColor()
  {
    return this.Av;
  }
  
  public List<LatLng> getPoints()
  {
    return this.Tn;
  }
  
  int getVersionCode()
  {
    return this.xH;
  }
  
  public float getWidth()
  {
    return this.SS;
  }
  
  public float getZIndex()
  {
    return this.SN;
  }
  
  public boolean isGeodesic()
  {
    return this.Tp;
  }
  
  public boolean isVisible()
  {
    return this.SO;
  }
  
  public PolylineOptions visible(boolean paramBoolean)
  {
    this.SO = paramBoolean;
    return this;
  }
  
  public PolylineOptions width(float paramFloat)
  {
    this.SS = paramFloat;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.iB())
    {
      h.a(this, paramParcel, paramInt);
      return;
    }
    PolylineOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public PolylineOptions zIndex(float paramFloat)
  {
    this.SN = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/maps/model/PolylineOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */