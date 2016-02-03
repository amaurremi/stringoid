package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.internal.v;

public final class CameraPosition
  implements SafeParcelable
{
  public static final CameraPositionCreator CREATOR = new CameraPositionCreator();
  public final float bearing;
  public final LatLng target;
  public final float tilt;
  private final int xJ;
  public final float zoom;
  
  CameraPosition(int paramInt, LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    hn.b(paramLatLng, "null camera target");
    if ((0.0F <= paramFloat2) && (paramFloat2 <= 90.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      hn.b(bool, "Tilt needs to be between 0 and 90 inclusive");
      this.xJ = paramInt;
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
    return this.xJ;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing) });
  }
  
  public String toString()
  {
    return hl.e(this).a("target", this.target).a("zoom", Float.valueOf(this.zoom)).a("tilt", Float.valueOf(this.tilt)).a("bearing", Float.valueOf(this.bearing)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.jG())
    {
      a.a(this, paramParcel, paramInt);
      return;
    }
    CameraPositionCreator.a(this, paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    private LatLng aak;
    private float aal;
    private float aam;
    private float aan;
    
    public Builder() {}
    
    public Builder(CameraPosition paramCameraPosition)
    {
      this.aak = paramCameraPosition.target;
      this.aal = paramCameraPosition.zoom;
      this.aam = paramCameraPosition.tilt;
      this.aan = paramCameraPosition.bearing;
    }
    
    public Builder bearing(float paramFloat)
    {
      this.aan = paramFloat;
      return this;
    }
    
    public CameraPosition build()
    {
      return new CameraPosition(this.aak, this.aal, this.aam, this.aan);
    }
    
    public Builder target(LatLng paramLatLng)
    {
      this.aak = paramLatLng;
      return this;
    }
    
    public Builder tilt(float paramFloat)
    {
      this.aam = paramFloat;
      return this;
    }
    
    public Builder zoom(float paramFloat)
    {
      this.aal = paramFloat;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/maps/model/CameraPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */