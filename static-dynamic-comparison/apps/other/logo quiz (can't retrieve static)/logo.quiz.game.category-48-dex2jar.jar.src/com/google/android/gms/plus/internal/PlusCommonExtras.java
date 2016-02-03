package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;

public class PlusCommonExtras
  implements SafeParcelable
{
  public static final f CREATOR = new f();
  public static String TAG = "PlusCommonExtras";
  private final int BR;
  private String alp;
  private String alq;
  
  public PlusCommonExtras()
  {
    this.BR = 1;
    this.alp = "";
    this.alq = "";
  }
  
  PlusCommonExtras(int paramInt, String paramString1, String paramString2)
  {
    this.BR = paramInt;
    this.alp = paramString1;
    this.alq = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlusCommonExtras)) {}
    do
    {
      return false;
      paramObject = (PlusCommonExtras)paramObject;
    } while ((this.BR != ((PlusCommonExtras)paramObject).BR) || (!m.equal(this.alp, ((PlusCommonExtras)paramObject).alp)) || (!m.equal(this.alq, ((PlusCommonExtras)paramObject).alq)));
    return true;
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { Integer.valueOf(this.BR), this.alp, this.alq });
  }
  
  public String nc()
  {
    return this.alp;
  }
  
  public String nd()
  {
    return this.alq;
  }
  
  public void o(Bundle paramBundle)
  {
    paramBundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", c.a(this));
  }
  
  public String toString()
  {
    return m.h(this).a("versionCode", Integer.valueOf(this.BR)).a("Gpsrc", this.alp).a("ClientCallingPackage", this.alq).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/plus/internal/PlusCommonExtras.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */