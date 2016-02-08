package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class z
  implements SafeParcelable
{
  public static final Parcelable.Creator<z> CREATOR = new aa();
  private final int BR;
  private final PendingIntent mPendingIntent;
  
  z(int paramInt, PendingIntent paramPendingIntent)
  {
    this.BR = paramInt;
    this.mPendingIntent = paramPendingIntent;
  }
  
  public z(PendingIntent paramPendingIntent)
  {
    this.BR = 3;
    this.mPendingIntent = paramPendingIntent;
  }
  
  private boolean a(z paramz)
  {
    return m.equal(this.mPendingIntent, paramz.mPendingIntent);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof z)) && (a((z)paramObject)));
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
    aa.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */