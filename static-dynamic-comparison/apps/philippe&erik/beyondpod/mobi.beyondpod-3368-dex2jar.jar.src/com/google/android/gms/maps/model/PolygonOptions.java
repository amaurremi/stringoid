package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolygonOptions
  implements SafeParcelable
{
  public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();
  private final List<LatLng> CV;
  private final List<List<LatLng>> CW;
  private boolean CX = false;
  private float Ct = 10.0F;
  private int Cu = -16777216;
  private int Cv = 0;
  private float Cw = 0.0F;
  private boolean Cx = true;
  private final int kg;
  
  public PolygonOptions()
  {
    this.kg = 1;
    this.CV = new ArrayList();
    this.CW = new ArrayList();
  }
  
  PolygonOptions(int paramInt1, List<LatLng> paramList, List paramList1, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.kg = paramInt1;
    this.CV = paramList;
    this.CW = paramList1;
    this.Ct = paramFloat1;
    this.Cu = paramInt2;
    this.Cv = paramInt3;
    this.Cw = paramFloat2;
    this.Cx = paramBoolean1;
    this.CX = paramBoolean2;
  }
  
  public PolygonOptions add(LatLng paramLatLng)
  {
    this.CV.add(paramLatLng);
    return this;
  }
  
  public PolygonOptions add(LatLng... paramVarArgs)
  {
    this.CV.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public PolygonOptions addAll(Iterable<LatLng> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      LatLng localLatLng = (LatLng)paramIterable.next();
      this.CV.add(localLatLng);
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
    this.CW.add(localArrayList);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  List eH()
  {
    return this.CW;
  }
  
  public PolygonOptions fillColor(int paramInt)
  {
    this.Cv = paramInt;
    return this;
  }
  
  public PolygonOptions geodesic(boolean paramBoolean)
  {
    this.CX = paramBoolean;
    return this;
  }
  
  public int getFillColor()
  {
    return this.Cv;
  }
  
  public List<List<LatLng>> getHoles()
  {
    return this.CW;
  }
  
  public List<LatLng> getPoints()
  {
    return this.CV;
  }
  
  public int getStrokeColor()
  {
    return this.Cu;
  }
  
  public float getStrokeWidth()
  {
    return this.Ct;
  }
  
  int getVersionCode()
  {
    return this.kg;
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
  
  public PolygonOptions strokeColor(int paramInt)
  {
    this.Cu = paramInt;
    return this;
  }
  
  public PolygonOptions strokeWidth(float paramFloat)
  {
    this.Ct = paramFloat;
    return this;
  }
  
  public PolygonOptions visible(boolean paramBoolean)
  {
    this.Cx = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (r.eD())
    {
      g.a(this, paramParcel, paramInt);
      return;
    }
    PolygonOptionsCreator.a(this, paramParcel, paramInt);
  }
  
  public PolygonOptions zIndex(float paramFloat)
  {
    this.Cw = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/maps/model/PolygonOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */