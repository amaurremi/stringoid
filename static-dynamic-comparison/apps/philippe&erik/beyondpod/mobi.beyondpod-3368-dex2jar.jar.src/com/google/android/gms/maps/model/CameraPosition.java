package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.ee.a;
import com.google.android.gms.internal.eg;
import com.google.android.gms.maps.internal.r;

public final class CameraPosition
  implements SafeParcelable
{
  public static final CameraPositionCreator CREATOR = new CameraPositionCreator();
  public final float bearing;
  private final int kg;
  public final LatLng target;
  public final float tilt;
  public final float zoom;
  
  CameraPosition(int paramInt, LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    eg.b(paramLatLng, "null camera target");
    if ((0.0F <= paramFloat2) && (paramFloat2 <= 90.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      eg.b(bool, "Tilt needs to be between 0 and 90 inclusive");
      this.kg = paramInt;
      this.target = paramLatLng;
      this.zoom = paramFloat1;
      this.tilt = (paramFloat2 + 0.0F);
      paramFloat1 = paramFloat3;
      if (paramFloat3 <= 0.0D) {
        paramFloat1 = paramFloat3 % 360.0F + 360.0F;
      }
      this.bearing = (paramFloat1 % 360.0F);
      return;
    }
  }
  
  public CameraPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this(1, paramLatLng, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public static Builder builder(CameraPosition paramCameraPosition)
  {
    return new Builder(paramCameraPosition);
  }
  
  public static CameraPosition createFromAttributes(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return null;
    }
    paramContext = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.MapAttrs);
    if (paramContext.hasValue(2)) {}
    for (float f1 = paramContext.getFloat(2, 0.0F);; f1 = 0.0F)
    {
      if (paramContext.hasValue(3)) {}
      for (float f2 = paramContext.getFloat(3, 0.0F);; f2 = 0.0F)
      {
        paramAttributeSet = new LatLng(f1, f2);
        Builder localBuilder = builder();
        localBuilder.target(paramAttributeSet);
        if (paramContext.hasValue(5)) {
          localBuilder.zoom(paramContext.getFloat(5, 0.0F));
        }
        if (paramContext.hasValue(1)) {
          localBuilder.bearing(paramContext.getFloat(1, 0.0F));
        }
        if (paramContext.hasValue(4)) {
          localBuilder.tilt(paramContext.getFloat(4, 0.0F));
        }
        return localBuilder.build();
      }
    }
  }
  
  public static final CameraPosition fromLatLngZoom(LatLng paramLatLng, float paramFloat)
  {
    return new CameraPosition(paramLatLng, paramFloat, 0.0F, 0.0F);
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
    } while ((this.target.equals(((CameraPosition)paramObject).target)) && (Float.floatToIntBits(this.zoom) == Float.floatToIntBits(((CameraPosition)paramObject).zoom)) && (Float.floatToIntBits(this.tilt) == Float.floatToIntBits(((CameraPosition)paramObject).tilt)) && (Float.floatToIntBits(this.bearing) == Float.floatToIntBits(((CameraPosition)paramObject).bearing)));
    return false;
  }
  
  int getVersionCode()
  {
    return this.kg;
  }
  
  public int hashCode()
  {
    return ee.hashCode(new Object[] { this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing) });
  }
  
  public String toString()
  {
    return ee.e(this).a("target", this.target).a("zoom", Float.valueOf(this.zoom)).a("tilt", Float.valueOf(this.tilt)).a("bearing", Float.valueOf(this.bearing)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (r.eD())
    {
      a.a(this, paramParcel, paramInt);
      return;
    }
    CameraPositionCreator.a(this, paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    private LatLng Cm;
    private float Cn;
    private float Co;
    private float Cp;
    
    public Builder() {}
    
    public Builder(CameraPosition paramCameraPosition)
    {
      this.Cm = paramCameraPosition.target;
      this.Cn = paramCameraPosition.zoom;
      this.Co = paramCameraPosition.tilt;
      this.Cp = paramCameraPosition.bearing;
    }
    
    public Builder bearing(float paramFloat)
    {
      this.Cp = paramFloat;
      return this;
    }
    
    public CameraPosition build()
    {
      return new CameraPosition(this.Cm, this.Cn, this.Co, this.Cp);
    }
    
    public Builder target(LatLng paramLatLng)
    {
      this.Cm = paramLatLng;
      return this;
    }
    
    public Builder tilt(float paramFloat)
    {
      this.Co = paramFloat;
      return this;
    }
    
    public Builder zoom(float paramFloat)
    {
      this.Cn = paramFloat;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/maps/model/CameraPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */