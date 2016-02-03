package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.Subscription;

public class af
  implements Parcelable.Creator<ae>
{
  static void a(ae paramae, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.a(paramParcel, 1, paramae.jB(), paramInt, false);
    b.c(paramParcel, 1000, paramae.getVersionCode());
    b.a(paramParcel, 2, paramae.jC());
    b.H(paramParcel, i);
  }
  
  public ae bS(Parcel paramParcel)
  {
    boolean bool = false;
    int j = a.C(paramParcel);
    Subscription localSubscription = null;
    int i = 0;
    if (paramParcel.dataPosition() < j)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      default: 
        a.b(paramParcel, k);
      }
      for (;;)
      {
        break;
        localSubscription = (Subscription)a.a(paramParcel, k, Subscription.CREATOR);
        continue;
        i = a.g(paramParcel, k);
        continue;
        bool = a.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ae(i, localSubscription, bool);
  }
  
  public ae[] dk(int paramInt)
  {
    return new ae[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */