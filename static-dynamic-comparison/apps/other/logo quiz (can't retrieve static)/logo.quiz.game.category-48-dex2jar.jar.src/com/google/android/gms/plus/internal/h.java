package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public class h
  implements SafeParcelable
{
  public static final j CREATOR = new j();
  private final int BR;
  private final String Dd;
  private final String[] als;
  private final String[] alt;
  private final String[] alu;
  private final String alv;
  private final String alw;
  private final String alx;
  private final String aly;
  private final PlusCommonExtras alz;
  
  h(int paramInt, String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, String paramString5, PlusCommonExtras paramPlusCommonExtras)
  {
    this.BR = paramInt;
    this.Dd = paramString1;
    this.als = paramArrayOfString1;
    this.alt = paramArrayOfString2;
    this.alu = paramArrayOfString3;
    this.alv = paramString2;
    this.alw = paramString3;
    this.alx = paramString4;
    this.aly = paramString5;
    this.alz = paramPlusCommonExtras;
  }
  
  public h(String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, PlusCommonExtras paramPlusCommonExtras)
  {
    this.BR = 1;
    this.Dd = paramString1;
    this.als = paramArrayOfString1;
    this.alt = paramArrayOfString2;
    this.alu = paramArrayOfString3;
    this.alv = paramString2;
    this.alw = paramString3;
    this.alx = paramString4;
    this.aly = null;
    this.alz = paramPlusCommonExtras;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof h)) {}
    do
    {
      return false;
      paramObject = (h)paramObject;
    } while ((this.BR != ((h)paramObject).BR) || (!m.equal(this.Dd, ((h)paramObject).Dd)) || (!Arrays.equals(this.als, ((h)paramObject).als)) || (!Arrays.equals(this.alt, ((h)paramObject).alt)) || (!Arrays.equals(this.alu, ((h)paramObject).alu)) || (!m.equal(this.alv, ((h)paramObject).alv)) || (!m.equal(this.alw, ((h)paramObject).alw)) || (!m.equal(this.alx, ((h)paramObject).alx)) || (!m.equal(this.aly, ((h)paramObject).aly)) || (!m.equal(this.alz, ((h)paramObject).alz)));
    return true;
  }
  
  public String getAccountName()
  {
    return this.Dd;
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { Integer.valueOf(this.BR), this.Dd, this.als, this.alt, this.alu, this.alv, this.alw, this.alx, this.aly, this.alz });
  }
  
  public String[] ne()
  {
    return this.als;
  }
  
  public String[] nf()
  {
    return this.alt;
  }
  
  public String[] ng()
  {
    return this.alu;
  }
  
  public String nh()
  {
    return this.alv;
  }
  
  public String ni()
  {
    return this.alw;
  }
  
  public String nj()
  {
    return this.alx;
  }
  
  public String nk()
  {
    return this.aly;
  }
  
  public PlusCommonExtras nl()
  {
    return this.alz;
  }
  
  public Bundle nm()
  {
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
    this.alz.o(localBundle);
    return localBundle;
  }
  
  public String toString()
  {
    return m.h(this).a("versionCode", Integer.valueOf(this.BR)).a("accountName", this.Dd).a("requestedScopes", this.als).a("visibleActivities", this.alt).a("requiredFeatures", this.alu).a("packageNameForAuth", this.alv).a("callingPackageName", this.alw).a("applicationName", this.alx).a("extra", this.alz.toString()).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/plus/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */