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
  public static final o CREATOR = new o();
  private final int BR;
  private float ajA = 0.0F;
  private boolean ajB = true;
  private float ajF = 10.0F;
  private final List<LatLng> aka;
  private boolean akc = false;
  private int mColor = -16777216;
  
  public PolylineOptions()
  {
    this.BR = 1;
    this.aka = new ArrayList();
  }
  
  PolylineOptions(int paramInt1, List paramList, float paramFloat1, int paramInt2, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.BR = paramInt1;
    this.aka = paramList;
    this.ajF = paramFloat1;
    this.mColor = paramInt2;
    this.ajA = paramFloat2;
    this.ajB = paramBoolean1;
    this.akc = paramBoolean2;
  }
  
  public PolylineOptions add(LatLng paramLatLng)
  {
    this.aka.add(paramLatLng);
    return this;
  }
  
  public PolylineOptions add(LatLng... paramVarArgs)
  {
    this.aka.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public PolylineOptions addAll(Iterable<LatLng> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      LatLng localLatLng = (LatLng)paramIterable.next();
      this.aka.add(localLatLng);
    }
    return this;
  }
  
  public PolylineOptions color(int paramInt)
  {
    this.mColor = paramInt;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public PolylineOptions geodesic(boolean paramBoolean)
  {
    this.akc = paramBoolean;
    return this;
  }
  
  public int getColor()
  {
    return this.mColor;
  }
  
  public List<LatLng> getPoints()
  {
    return this.aka;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public float getWidth()
  {
    return this.ajF;
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
  
  public PolylineOptions visible(boolean paramBoolean)
  {
    this.ajB = paramBoolean;
    return this;
  }
  
  public PolylineOptions width(float paramFloat)
  {
    this.ajF = paramFloat;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.mK())
    {
      p.a(this, paramParcel, paramInt);
      return;
    }
    o.a(this, paramParcel, paramInt);
  }
  
  public PolylineOptions zIndex(float paramFloat)
  {
    this.ajA = paramFloat;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/maps/model/PolylineOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */