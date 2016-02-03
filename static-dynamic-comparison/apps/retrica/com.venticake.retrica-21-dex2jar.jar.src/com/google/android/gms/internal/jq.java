package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.concurrent.TimeUnit;

public final class jq
  implements SafeParcelable
{
  public static final jr CREATOR = new jr();
  static final long Wm = TimeUnit.HOURS.toMillis(1L);
  private final long Vl;
  private final jm Wn;
  private final int mPriority;
  final int xM;
  
  public jq(int paramInt1, jm paramjm, long paramLong, int paramInt2)
  {
    this.xM = paramInt1;
    this.Wn = paramjm;
    this.Vl = paramLong;
    this.mPriority = paramInt2;
  }
  
  public int describeContents()
  {
    jr localjr = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof jq)) {
        return false;
      }
      paramObject = (jq)paramObject;
    } while ((hk.equal(this.Wn, ((jq)paramObject).Wn)) && (this.Vl == ((jq)paramObject).Vl) && (this.mPriority == ((jq)paramObject).mPriority));
    return false;
  }
  
  public long getInterval()
  {
    return this.Vl;
  }
  
  public int getPriority()
  {
    return this.mPriority;
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { this.Wn, Long.valueOf(this.Vl), Integer.valueOf(this.mPriority) });
  }
  
  public jm jf()
  {
    return this.Wn;
  }
  
  public String toString()
  {
    return hk.e(this).a("filter", this.Wn).a("interval", Long.valueOf(this.Vl)).a("priority", Integer.valueOf(this.mPriority)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jr localjr = CREATOR;
    jr.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/jq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */