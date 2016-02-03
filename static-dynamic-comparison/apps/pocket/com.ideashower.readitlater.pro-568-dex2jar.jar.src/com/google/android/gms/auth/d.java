package com.google.android.gms.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class d
  implements Parcelable.Creator
{
  static void a(RecoveryDecision paramRecoveryDecision, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramRecoveryDecision.a);
    c.a(paramParcel, 2, paramRecoveryDecision.b, paramInt, false);
    c.a(paramParcel, 3, paramRecoveryDecision.c);
    c.a(paramParcel, 4, paramRecoveryDecision.d);
    c.a(paramParcel, 5, paramRecoveryDecision.e);
    c.a(paramParcel, 6, paramRecoveryDecision.f, paramInt, false);
    c.a(paramParcel, i);
  }
  
  public RecoveryDecision a(Parcel paramParcel)
  {
    PendingIntent localPendingIntent1 = null;
    boolean bool1 = false;
    int j = a.b(paramParcel);
    boolean bool2 = false;
    boolean bool3 = false;
    PendingIntent localPendingIntent2 = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.f(paramParcel, k);
        break;
      case 2: 
        localPendingIntent2 = (PendingIntent)a.a(paramParcel, k, PendingIntent.CREATOR);
        break;
      case 3: 
        bool3 = a.c(paramParcel, k);
        break;
      case 4: 
        bool2 = a.c(paramParcel, k);
        break;
      case 5: 
        bool1 = a.c(paramParcel, k);
        break;
      case 6: 
        localPendingIntent1 = (PendingIntent)a.a(paramParcel, k, PendingIntent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new b("Overread allowed size end=" + j, paramParcel);
    }
    return new RecoveryDecision(i, localPendingIntent2, bool3, bool2, bool1, localPendingIntent1);
  }
  
  public RecoveryDecision[] a(int paramInt)
  {
    return new RecoveryDecision[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/auth/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */