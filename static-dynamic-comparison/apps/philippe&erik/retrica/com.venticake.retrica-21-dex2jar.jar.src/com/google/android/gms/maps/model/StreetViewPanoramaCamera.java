package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.a;
import com.google.android.gms.internal.hm;

public class StreetViewPanoramaCamera
  implements SafeParcelable
{
  public static final StreetViewPanoramaCameraCreator CREATOR = new StreetViewPanoramaCameraCreator();
  private StreetViewPanoramaOrientation abb;
  public final float bearing;
  public final float tilt;
  private final int xM;
  public final float zoom;
  
  public StreetViewPanoramaCamera(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this(1, paramFloat1, paramFloat2, paramFloat3);
  }
  
  StreetViewPanoramaCamera(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool;
    if ((-90.0F <= paramFloat2) && (paramFloat2 <= 90.0F))
    {
      bool = true;
      hm.b(bool, "Tilt needs to be between -90 and 90 inclusive");
      this.xM = paramInt;
      this.zoom = paramFloat1;
      this.tilt = (0.0F + paramFloat2);
      if (paramFloat3 > 0.0D) {
        break label100;
      }
    }
    label100:
    for (paramFloat1 = paramFloat3 % 360.0F + 360.0F;; paramFloat1 = paramFloat3)
    {
      this.bearing = (paramFloat1 % 360.0F);
      this.abb = new StreetViewPanoramaOrientation.Builder().tilt(paramFloat2).bearing(paramFloat3).build();
      return;
      bool = false;
      break;
    }
  }
  
  public static StreetViewPanoramaCamera.Builder builder()
  {
    return new StreetViewPanoramaCamera.Builder();
  }
  
  public static StreetViewPanoramaCamera.Builder builder(StreetViewPanoramaCamera paramStreetViewPanoramaCamera)
  {
    return new StreetViewPanoramaCamera.Builder(paramStreetViewPanoramaCamera);
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
      if (!(paramObject instanceof StreetViewPanoramaCamera)) {
        return false;
      }
      paramObject = (StreetViewPanoramaCamera)paramObject;
    } while ((Float.floatToIntBits(this.zoom) == Float.floatToIntBits(((StreetViewPanoramaCamera)paramObject).zoom)) && (Float.floatToIntBits(this.tilt) == Float.floatToIntBits(((StreetViewPanoramaCamera)paramObject).tilt)) && (Float.floatToIntBits(this.bearing) == Float.floatToIntBits(((StreetViewPanoramaCamera)paramObject).bearing)));
    return false;
  }
  
  public StreetViewPanoramaOrientation getOrientation()
  {
    return this.abb;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing) });
  }
  
  public String toString()
  {
    return hk.e(this).a("zoom", Float.valueOf(this.zoom)).a("tilt", Float.valueOf(this.tilt)).a("bearing", Float.valueOf(this.bearing)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    StreetViewPanoramaCameraCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/model/StreetViewPanoramaCamera.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */