package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.a.d;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.cz.a;
import com.google.android.gms.internal.dc;
import com.google.android.gms.maps.a.y;

public final class CameraPosition
  implements SafeParcelable
{
  public static final c UO = new c();
  public final LatLng UP;
  public final float UQ;
  public final float UR;
  public final float US;
  private final int qh;
  
  CameraPosition(int paramInt, LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    dc.e(paramLatLng, "null camera target");
    if ((0.0F <= paramFloat2) && (paramFloat2 <= 90.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      dc.b(bool, "Tilt needs to be between 0 and 90 inclusive");
      this.qh = paramInt;
      this.UP = paramLatLng;
      this.UQ = paramFloat1;
      this.UR = (paramFloat2 + 0.0F);
      paramFloat1 = paramFloat3;
      if (paramFloat3 <= 0.0D) {
        paramFloat1 = paramFloat3 % 360.0F + 360.0F;
      }
      this.US = (paramFloat1 % 360.0F);
      return;
    }
  }
  
  public CameraPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this(1, paramLatLng, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static CameraPosition b(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return null;
    }
    paramContext = paramContext.getResources().obtainAttributes(paramAttributeSet, a.d.MapAttrs);
    if (paramContext.hasValue(2)) {}
    for (float f1 = paramContext.getFloat(2, 0.0F);; f1 = 0.0F)
    {
      if (paramContext.hasValue(3)) {}
      for (float f2 = paramContext.getFloat(3, 0.0F);; f2 = 0.0F)
      {
        paramAttributeSet = new LatLng(f1, f2);
        a locala = uN();
        locala.e(paramAttributeSet);
        if (paramContext.hasValue(5)) {
          locala.k(paramContext.getFloat(5, 0.0F));
        }
        if (paramContext.hasValue(1)) {
          locala.m(paramContext.getFloat(1, 0.0F));
        }
        if (paramContext.hasValue(4)) {
          locala.l(paramContext.getFloat(4, 0.0F));
        }
        return locala.uO();
      }
    }
  }
  
  public static a uN()
  {
    return new a();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof CameraPosition)) {
        return false;
      }
      paramObject = (CameraPosition)paramObject;
    } while ((this.UP.equals(((CameraPosition)paramObject).UP)) && (Float.floatToIntBits(this.UQ) == Float.floatToIntBits(((CameraPosition)paramObject).UQ)) && (Float.floatToIntBits(this.UR) == Float.floatToIntBits(((CameraPosition)paramObject).UR)) && (Float.floatToIntBits(this.US) == Float.floatToIntBits(((CameraPosition)paramObject).US)));
    return false;
  }
  
  public int hashCode()
  {
    return cz.hashCode(new Object[] { this.UP, Float.valueOf(this.UQ), Float.valueOf(this.UR), Float.valueOf(this.US) });
  }
  
  int lX()
  {
    return this.qh;
  }
  
  public String toString()
  {
    return cz.M(this).a("target", this.UP).a("zoom", Float.valueOf(this.UQ)).a("tilt", Float.valueOf(this.UR)).a("bearing", Float.valueOf(this.US)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (y.uL())
    {
      o.a(this, paramParcel, paramInt);
      return;
    }
    c.a(this, paramParcel, paramInt);
  }
  
  public static final class a
  {
    private LatLng UT;
    private float UU;
    private float UV;
    private float UW;
    
    public a e(LatLng paramLatLng)
    {
      this.UT = paramLatLng;
      return this;
    }
    
    public a k(float paramFloat)
    {
      this.UU = paramFloat;
      return this;
    }
    
    public a l(float paramFloat)
    {
      this.UV = paramFloat;
      return this;
    }
    
    public a m(float paramFloat)
    {
      this.UW = paramFloat;
      return this;
    }
    
    public CameraPosition uO()
    {
      return new CameraPosition(this.UT, this.UU, this.UV, this.UW);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/model/CameraPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */