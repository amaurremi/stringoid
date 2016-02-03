package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.k;
import com.google.android.gms.fitness.data.k.a;

public class p
  implements SafeParcelable
{
  public static final Parcelable.Creator<p> CREATOR = new q();
  private final int BR;
  private final k Up;
  private final PendingIntent mPendingIntent;
  
  p(int paramInt, IBinder paramIBinder, PendingIntent paramPendingIntent)
  {
    this.BR = paramInt;
    if (paramIBinder == null) {}
    for (paramIBinder = null;; paramIBinder = k.a.an(paramIBinder))
    {
      this.Up = paramIBinder;
      this.mPendingIntent = paramPendingIntent;
      return;
    }
  }
  
  public p(k paramk, PendingIntent paramPendingIntent)
  {
    this.BR = 2;
    this.Up = paramk;
    this.mPendingIntent = paramPendingIntent;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public PendingIntent jl()
  {
    return this.mPendingIntent;
  }
  
  IBinder jq()
  {
    if (this.Up == null) {
      return null;
    }
    return this.Up.asBinder();
  }
  
  public String toString()
  {
    return String.format("SensorUnregistrationRequest{%s}", new Object[] { this.Up });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    q.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */