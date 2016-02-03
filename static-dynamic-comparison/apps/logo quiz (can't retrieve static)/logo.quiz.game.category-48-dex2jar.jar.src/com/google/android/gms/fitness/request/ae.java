package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Subscription;

public class ae
  implements SafeParcelable
{
  public static final Parcelable.Creator<ae> CREATOR = new af();
  private final int BR;
  private final Subscription UH;
  private final boolean UI;
  
  ae(int paramInt, Subscription paramSubscription, boolean paramBoolean)
  {
    this.BR = paramInt;
    this.UH = paramSubscription;
    this.UI = paramBoolean;
  }
  
  private ae(a parama)
  {
    this.BR = 1;
    this.UH = a.a(parama);
    this.UI = a.b(parama);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public Subscription jB()
  {
    return this.UH;
  }
  
  public boolean jC()
  {
    return this.UI;
  }
  
  public String toString()
  {
    return m.h(this).a("subscription", this.UH).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    af.a(this, paramParcel, paramInt);
  }
  
  public static class a
  {
    private Subscription UH;
    private boolean UI = false;
    
    public a b(Subscription paramSubscription)
    {
      this.UH = paramSubscription;
      return this;
    }
    
    public ae jD()
    {
      if (this.UH != null) {}
      for (boolean bool = true;; bool = false)
      {
        n.a(bool, "Must call setSubscription()");
        return new ae(this, null);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */