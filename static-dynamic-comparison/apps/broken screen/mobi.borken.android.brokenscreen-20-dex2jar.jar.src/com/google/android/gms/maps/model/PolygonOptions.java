package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolygonOptions
  implements SafeParcelable
{
  public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();
  private final List<LatLng> aaU;
  private final List<List<LatLng>> aaV;
  private boolean aaW = false;
  private float aar = 10.0F;
  private int aas = -16777216;
  private int aat = 0;
  private float aau = 0.0F;
  private boolean aav = true;
  private final int xJ;
  
  public PolygonOptions()
  {
    this.xJ = 1;
    this.aaU = new ArrayList();
    this.aaV = new ArrayList();
  }
  
  PolygonOptions(int paramInt1, List<LatLng> paramList, List paramList1, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.xJ = paramInt1;
    this.aaU = paramList;
    this.aaV = paramList1;
    this.aar = paramFloat1;
    this.aas = paramInt2;
    this.aat = paramInt3;
    this.aau = paramFloat2;
    this.aav = paramBoolean1;
    this.aaW = paramBoolean2;
  }
  
  public PolygonOptions add(LatLng paramLatLng)
  {
    this.aaU.add(paramLatLng);
    return this;
  }
  
  public PolygonOptions add(LatLng... paramVarArgs)
  {
    this.aaU.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public PolygonOptions addAll(Iterable<LatLng> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      LatLng localLatLng = (LatLng)paramIterable.next();
      this.aaU.add(localLatLng);
    }
    return this;
  }
  
  public PolygonOptions addHole(Iterable<LatLng> paramIterable)
  {
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add((LatLng)paramIterable.next());
    }
    this.aaV.add(localArrayList);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public PolygonOptions fillColor(int paramInt)
  {
    this.aat = paramInt;
    return this;
  }
  
  public PolygonOptions geodesic(boolean paramBoolean)
  {
    this.aaW = paramBoolean;
    return this;
  }
  
  public int getFillColor()
  {
    return this.aat;
  }
  
  public List<List<LatLng>> getHoles()
  {
    return this.aaV;
  }
  
  public List<LatLng> getPoints()
  {
    return this.aaU;
  }
  
  public int getStrokeColor()
  {
    return this.aas;
  }
  
  public float getStrokeWidth()
  {
    return this.aar;
  }
  
  int getVersionCode()
  {
    return this.xJ;
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
  
  List jK()
  {
    return this.aaV;
  }
  
  public PolygonOptions strokeColor(int paramInt)
  {
    this.aas = paramInt;
    return this;
  }
  
  public PolygonOptions strokeWidth(float paramFloat)
  {
    this.aar = paramFloat;
    return this;
  }
  
  public PolygonOptions visible(boolean paramBoolean)
  {
    this.aav = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.jG())
    {
      g.a(this, paramParcel, paramInt);
      return;
    }
    PolygonOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public PolygonOptions zIndex(float paramFloat)
  {
    this.aau = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/maps/model/PolygonOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */