package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.concurrent.TimeUnit;

public final class jr
  implements SafeParcelable
{
  public static final js CREATOR = new js();
  static final long Wj = TimeUnit.HOURS.toMillis(1L);
  private final long Vi;
  private final jn Wk;
  private final int mPriority;
  final int xJ;
  
  public jr(int paramInt1, jn paramjn, long paramLong, int paramInt2)
  {
    this.xJ = paramInt1;
    this.Wk = paramjn;
    this.Vi = paramLong;
    this.mPriority = paramInt2;
  }
  
  public int describeContents()
  {
    js localjs = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof jr)) {
        return false;
      }
      paramObject = (jr)paramObject;
    } while ((hl.equal(this.Wk, ((jr)paramObject).Wk)) && (this.Vi == ((jr)paramObject).Vi) && (this.mPriority == ((jr)paramObject).mPriority));
    return false;
  }
  
  public long getInterval()
  {
    return this.Vi;
  }
  
  public int getPriority()
  {
    return this.mPriority;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { this.Wk, Long.valueOf(this.Vi), Integer.valueOf(this.mPriority) });
  }
  
  public jn ja()
  {
    return this.Wk;
  }
  
  public String toString()
  {
    return hl.e(this).a("filter", this.Wk).a("interval", Long.valueOf(this.Vi)).a("priority", Integer.valueOf(this.mPriority)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    js localjs = CREATOR;
    js.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/jr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */