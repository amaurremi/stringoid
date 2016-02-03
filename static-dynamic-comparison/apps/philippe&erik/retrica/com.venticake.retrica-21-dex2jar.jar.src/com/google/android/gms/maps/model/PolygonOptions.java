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
  private final List<LatLng> aaX;
  private final List<List<LatLng>> aaY;
  private boolean aaZ = false;
  private float aau = 10.0F;
  private int aav = -16777216;
  private int aaw = 0;
  private float aax = 0.0F;
  private boolean aay = true;
  private final int xM;
  
  public PolygonOptions()
  {
    this.xM = 1;
    this.aaX = new ArrayList();
    this.aaY = new ArrayList();
  }
  
  PolygonOptions(int paramInt1, List<LatLng> paramList, List paramList1, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.xM = paramInt1;
    this.aaX = paramList;
    this.aaY = paramList1;
    this.aau = paramFloat1;
    this.aav = paramInt2;
    this.aaw = paramInt3;
    this.aax = paramFloat2;
    this.aay = paramBoolean1;
    this.aaZ = paramBoolean2;
  }
  
  public PolygonOptions add(LatLng paramLatLng)
  {
    this.aaX.add(paramLatLng);
    return this;
  }
  
  public PolygonOptions add(LatLng... paramVarArgs)
  {
    this.aaX.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public PolygonOptions addAll(Iterable<LatLng> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      LatLng localLatLng = (LatLng)paramIterable.next();
      this.aaX.add(localLatLng);
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
    this.aaY.add(localArrayList);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public PolygonOptions fillColor(int paramInt)
  {
    this.aaw = paramInt;
    return this;
  }
  
  public PolygonOptions geodesic(boolean paramBoolean)
  {
    this.aaZ = paramBoolean;
    return this;
  }
  
  public int getFillColor()
  {
    return this.aaw;
  }
  
  public List<List<LatLng>> getHoles()
  {
    return this.aaY;
  }
  
  public List<LatLng> getPoints()
  {
    return this.aaX;
  }
  
  public int getStrokeColor()
  {
    return this.aav;
  }
  
  public float getStrokeWidth()
  {
    return this.aau;
  }
  
  int getVersionCode()
  {
    return this.xM;
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
  
  List jP()
  {
    return this.aaY;
  }
  
  public PolygonOptions strokeColor(int paramInt)
  {
    this.aav = paramInt;
    return this;
  }
  
  public PolygonOptions strokeWidth(float paramFloat)
  {
    this.aau = paramFloat;
    return this;
  }
  
  public PolygonOptions visible(boolean paramBoolean)
  {
    this.aay = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.jL())
    {
      g.a(this, paramParcel, paramInt);
      return;
    }
    PolygonOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public PolygonOptions zIndex(float paramFloat)
  {
    this.aax = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/model/PolygonOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */