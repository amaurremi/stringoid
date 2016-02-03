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
  public static final m CREATOR = new m();
  private final int BR;
  private float ajA = 0.0F;
  private boolean ajB = true;
  private float ajx = 10.0F;
  private int ajy = -16777216;
  private int ajz = 0;
  private final List<LatLng> aka;
  private final List<List<LatLng>> akb;
  private boolean akc = false;
  
  public PolygonOptions()
  {
    this.BR = 1;
    this.aka = new ArrayList();
    this.akb = new ArrayList();
  }
  
  PolygonOptions(int paramInt1, List<LatLng> paramList, List paramList1, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.BR = paramInt1;
    this.aka = paramList;
    this.akb = paramList1;
    this.ajx = paramFloat1;
    this.ajy = paramInt2;
    this.ajz = paramInt3;
    this.ajA = paramFloat2;
    this.ajB = paramBoolean1;
    this.akc = paramBoolean2;
  }
  
  public PolygonOptions add(LatLng paramLatLng)
  {
    this.aka.add(paramLatLng);
    return this;
  }
  
  public PolygonOptions add(LatLng... paramVarArgs)
  {
    this.aka.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public PolygonOptions addAll(Iterable<LatLng> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      LatLng localLatLng = (LatLng)paramIterable.next();
      this.aka.add(localLatLng);
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
    this.akb.add(localArrayList);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public PolygonOptions fillColor(int paramInt)
  {
    this.ajz = paramInt;
    return this;
  }
  
  public PolygonOptions geodesic(boolean paramBoolean)
  {
    this.akc = paramBoolean;
    return this;
  }
  
  public int getFillColor()
  {
    return this.ajz;
  }
  
  public List<List<LatLng>> getHoles()
  {
    return this.akb;
  }
  
  public List<LatLng> getPoints()
  {
    return this.aka;
  }
  
  public int getStrokeColor()
  {
    return this.ajy;
  }
  
  public float getStrokeWidth()
  {
    return this.ajx;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public float getZIndex()
  {
    return this.ajA;
  }
  
  public boolean isGeodesic()
  {
    return this.akc;
  }
  
  public boolean isVisible()
  {
    return this.ajB;
  }
  
  List mO()
  {
    return this.akb;
  }
  
  public PolygonOptions strokeColor(int paramInt)
  {
    this.ajy = paramInt;
    return this;
  }
  
  public PolygonOptions strokeWidth(float paramFloat)
  {
    this.ajx = paramFloat;
    return this;
  }
  
  public PolygonOptions visible(boolean paramBoolean)
  {
    this.ajB = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.mK())
    {
      n.a(this, paramParcel, paramInt);
      return;
    }
    m.a(this, paramParcel, paramInt);
  }
  
  public PolygonOptions zIndex(float paramFloat)
  {
    this.ajA = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/maps/model/PolygonOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */