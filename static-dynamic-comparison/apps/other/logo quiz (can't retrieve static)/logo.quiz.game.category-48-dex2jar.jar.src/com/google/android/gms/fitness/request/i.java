package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class i
  implements SafeParcelable
{
  public static final Parcelable.Creator<i> CREATOR = new j();
  private final int BR;
  private final String mName;
  
  i(int paramInt, String paramString)
  {
    this.BR = paramInt;
    this.mName = paramString;
  }
  
  public i(String paramString)
  {
    this.BR = 1;
    this.mName = paramString;
  }
  
  private boolean a(i parami)
  {
    return m.equal(this.mName, parami.mName);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof i)) && (a((i)paramObject)));
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.mName });
  }
  
  public String toString()
  {
    return m.h(this).a("name", this.mName).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */