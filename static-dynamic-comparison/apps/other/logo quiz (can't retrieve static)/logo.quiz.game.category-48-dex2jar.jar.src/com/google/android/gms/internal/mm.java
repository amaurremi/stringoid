package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.concurrent.TimeUnit;

public final class mm
  implements SafeParcelable
{
  public static final mn CREATOR = new mn();
  static final long afp = TimeUnit.HOURS.toMillis(1L);
  final int BR;
  private final long aeh;
  private final mi afq;
  private final int mPriority;
  
  public mm(int paramInt1, mi parammi, long paramLong, int paramInt2)
  {
    this.BR = paramInt1;
    this.afq = parammi;
    this.aeh = paramLong;
    this.mPriority = paramInt2;
  }
  
  public int describeContents()
  {
    mn localmn = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof mm)) {
        return false;
      }
      paramObject = (mm)paramObject;
    } while ((m.equal(this.afq, ((mm)paramObject).afq)) && (this.aeh == ((mm)paramObject).aeh) && (this.mPriority == ((mm)paramObject).mPriority));
    return false;
  }
  
  public long getInterval()
  {
    return this.aeh;
  }
  
  public int getPriority()
  {
    return this.mPriority;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.afq, Long.valueOf(this.aeh), Integer.valueOf(this.mPriority) });
  }
  
  public mi mf()
  {
    return this.afq;
  }
  
  public String toString()
  {
    return m.h(this).a("filter", this.afq).a("interval", Long.valueOf(this.aeh)).a("priority", Integer.valueOf(this.mPriority)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mn localmn = CREATOR;
    mn.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/mm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */