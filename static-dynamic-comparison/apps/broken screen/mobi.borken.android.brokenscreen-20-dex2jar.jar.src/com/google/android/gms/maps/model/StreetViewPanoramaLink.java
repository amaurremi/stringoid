package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

public class StreetViewPanoramaLink
  implements SafeParcelable
{
  public static final StreetViewPanoramaLinkCreator CREATOR = new StreetViewPanoramaLinkCreator();
  public final float bearing;
  public final String panoId;
  private final int xJ;
  
  StreetViewPanoramaLink(int paramInt, String paramString, float paramFloat)
  {
    this.xJ = paramInt;
    this.panoId = paramString;
    float f = paramFloat;
    if (paramFloat <= 0.0D) {
      f = paramFloat % 360.0F + 360.0F;
    }
    this.bearing = (f % 360.0F);
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
      if (!(paramObject instanceof StreetViewPanoramaLink)) {
        return false;
      }
      paramObject = (StreetViewPanoramaLink)paramObject;
    } while ((this.panoId.equals(((StreetViewPanoramaLink)paramObject).panoId)) && (Float.floatToIntBits(this.bearing) == Float.floatToIntBits(((StreetViewPanoramaLink)paramObject).bearing)));
    return false;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { this.panoId, Float.valueOf(this.bearing) });
  }
  
  public String toString()
  {
    return hl.e(this).a("panoId", this.panoId).a("bearing", Float.valueOf(this.bearing)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    StreetViewPanoramaLinkCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/maps/model/StreetViewPanoramaLink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */