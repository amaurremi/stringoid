package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class hb
  extends gs
  implements SafeParcelable
{
  private static final hb AJ = new hb(0, new hd[0], new float[0], 0L);
  public static final hc CREATOR = new hc();
  private final hd[] AK;
  private final float[] AL;
  final int kg;
  private final long vO;
  
  hb(int paramInt, hd[] paramArrayOfhd, float[] paramArrayOfFloat, long paramLong)
  {
    if (paramArrayOfhd.length == paramArrayOfFloat.length) {}
    for (boolean bool = true;; bool = false)
    {
      eg.b(bool, "mismatched places to probabilities arrays");
      this.kg = paramInt;
      this.AK = paramArrayOfhd;
      this.AL = paramArrayOfFloat;
      this.vO = paramLong;
      return;
    }
  }
  
  public hd[] dU()
  {
    return this.AK;
  }
  
  public float[] dV()
  {
    return this.AL;
  }
  
  public int describeContents()
  {
    hc localhc = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof hb)) {
        return false;
      }
      paramObject = (hb)paramObject;
    } while ((this.AK.equals(((hb)paramObject).AK)) && (this.AL.equals(((hb)paramObject).AL)));
    return false;
  }
  
  public long getTimestampMillis()
  {
    return this.vO;
  }
  
  public int hashCode()
  {
    return ee.hashCode(new Object[] { this.AK, this.AL });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PlaceEstimate{");
    int i = 0;
    while (i < this.AK.length)
    {
      localStringBuilder.append(String.format("(%f, %s)", new Object[] { Float.valueOf(this.AL[i]), this.AK[i].toString() }));
      if (i != this.AK.length - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hc localhc = CREATOR;
    hc.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/hb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */