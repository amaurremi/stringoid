package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class mg
  implements SafeParcelable
{
  public static final mh CREATOR = new mh();
  private final int BR;
  private final int adW;
  private final int afe;
  private final mi aff;
  
  mg(int paramInt1, int paramInt2, int paramInt3, mi parammi)
  {
    this.BR = paramInt1;
    this.adW = paramInt2;
    this.afe = paramInt3;
    this.aff = parammi;
  }
  
  public int describeContents()
  {
    mh localmh = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof mg)) {
        return false;
      }
      paramObject = (mg)paramObject;
    } while ((this.adW == ((mg)paramObject).adW) && (this.afe == ((mg)paramObject).afe) && (this.aff.equals(((mg)paramObject).aff)));
    return false;
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { Integer.valueOf(this.adW), Integer.valueOf(this.afe) });
  }
  
  public int ma()
  {
    return this.adW;
  }
  
  public int me()
  {
    return this.afe;
  }
  
  public mi mf()
  {
    return this.aff;
  }
  
  public String toString()
  {
    return m.h(this).a("transitionTypes", Integer.valueOf(this.adW)).a("loiteringTimeMillis", Integer.valueOf(this.afe)).a("placeFilter", this.aff).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mh localmh = CREATOR;
    mh.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/mg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */