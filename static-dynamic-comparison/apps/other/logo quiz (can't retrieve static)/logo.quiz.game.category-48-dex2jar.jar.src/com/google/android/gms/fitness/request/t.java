package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class t
  implements SafeParcelable
{
  public static final Parcelable.Creator<t> CREATOR = new u();
  private final int BR;
  private final PendingIntent mPendingIntent;
  
  t(int paramInt, PendingIntent paramPendingIntent)
  {
    this.BR = paramInt;
    this.mPendingIntent = paramPendingIntent;
  }
  
  public t(PendingIntent paramPendingIntent)
  {
    this.BR = 3;
    this.mPendingIntent = paramPendingIntent;
  }
  
  private boolean a(t paramt)
  {
    return m.equal(this.mPendingIntent, paramt.mPendingIntent);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof t)) && (a((t)paramObject)));
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.mPendingIntent });
  }
  
  public PendingIntent jl()
  {
    return this.mPendingIntent;
  }
  
  public String toString()
  {
    return m.h(this).a("pendingIntent", this.mPendingIntent).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    u.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */