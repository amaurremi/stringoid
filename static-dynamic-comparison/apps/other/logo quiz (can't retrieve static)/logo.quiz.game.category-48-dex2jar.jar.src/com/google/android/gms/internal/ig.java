package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ig
  implements SafeParcelable
{
  public static final Parcelable.Creator<ig> CREATOR = new ih();
  private final int BR;
  private String Gn;
  
  public ig()
  {
    this(1, null);
  }
  
  ig(int paramInt, String paramString)
  {
    this.BR = paramInt;
    this.Gn = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ig)) {
      return false;
    }
    paramObject = (ig)paramObject;
    return ik.a(this.Gn, ((ig)paramObject).Gn);
  }
  
  public String fz()
  {
    return this.Gn;
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.Gn });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ih.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/ig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */