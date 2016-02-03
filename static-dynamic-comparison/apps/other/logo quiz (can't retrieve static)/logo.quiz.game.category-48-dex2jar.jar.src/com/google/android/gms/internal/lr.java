package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class lr
  implements SafeParcelable
{
  public static final ls CREATOR = new ls();
  private final int BR;
  public final String packageName;
  public final int uid;
  
  lr(int paramInt1, int paramInt2, String paramString)
  {
    this.BR = paramInt1;
    this.uid = paramInt2;
    this.packageName = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof lr)) {}
    do
    {
      return false;
      paramObject = (lr)paramObject;
    } while ((((lr)paramObject).uid != this.uid) || (!m.equal(((lr)paramObject).packageName, this.packageName)));
    return true;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return this.uid;
  }
  
  public String toString()
  {
    return String.format("%d:%s", new Object[] { Integer.valueOf(this.uid), this.packageName });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ls.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/lr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */