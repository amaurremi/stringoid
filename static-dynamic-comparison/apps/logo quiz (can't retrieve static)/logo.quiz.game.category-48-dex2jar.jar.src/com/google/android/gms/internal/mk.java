package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class mk
  implements SafeParcelable
{
  public static final ml CREATOR = new ml();
  final int BR;
  private final String afo;
  private final String mTag;
  
  mk(int paramInt, String paramString1, String paramString2)
  {
    this.BR = paramInt;
    this.afo = paramString1;
    this.mTag = paramString2;
  }
  
  public int describeContents()
  {
    ml localml = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof mk)) {}
    do
    {
      return false;
      paramObject = (mk)paramObject;
    } while ((!m.equal(this.afo, ((mk)paramObject).afo)) || (!m.equal(this.mTag, ((mk)paramObject).mTag)));
    return true;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.afo, this.mTag });
  }
  
  public String mi()
  {
    return this.afo;
  }
  
  public String toString()
  {
    return m.h(this).a("mPlaceId", this.afo).a("mTag", this.mTag).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ml localml = CREATOR;
    ml.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/mk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */