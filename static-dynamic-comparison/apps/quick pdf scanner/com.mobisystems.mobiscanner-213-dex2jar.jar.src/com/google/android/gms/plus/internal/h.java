package com.google.android.gms.plus.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.cz.a;
import java.util.Arrays;

public class h
  implements SafeParcelable
{
  public static final c Wh = new c();
  private final String[] Wi;
  private final String[] Wj;
  private final String[] Wk;
  private final String Wl;
  private final String Wm;
  private final String Wn;
  private final String Wo;
  private final PlusCommonExtras Wp;
  private final String qS;
  private final int qh;
  
  h(int paramInt, String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, String paramString5, PlusCommonExtras paramPlusCommonExtras)
  {
    this.qh = paramInt;
    this.qS = paramString1;
    this.Wi = paramArrayOfString1;
    this.Wj = paramArrayOfString2;
    this.Wk = paramArrayOfString3;
    this.Wl = paramString2;
    this.Wm = paramString3;
    this.Wn = paramString4;
    this.Wo = paramString5;
    this.Wp = paramPlusCommonExtras;
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
    } while ((this.qh != ((h)paramObject).qh) || (!cz.b(this.qS, ((h)paramObject).qS)) || (!Arrays.equals(this.Wi, ((h)paramObject).Wi)) || (!Arrays.equals(this.Wj, ((h)paramObject).Wj)) || (!Arrays.equals(this.Wk, ((h)paramObject).Wk)) || (!cz.b(this.Wl, ((h)paramObject).Wl)) || (!cz.b(this.Wm, ((h)paramObject).Wm)) || (!cz.b(this.Wn, ((h)paramObject).Wn)) || (!cz.b(this.Wo, ((h)paramObject).Wo)) || (!cz.b(this.Wp, ((h)paramObject).Wp)));
    return true;
  }
  
  public int hashCode()
  {
    return cz.hashCode(new Object[] { Integer.valueOf(this.qh), this.qS, this.Wi, this.Wj, this.Wk, this.Wl, this.Wm, this.Wn, this.Wo, this.Wp });
  }
  
  public int lX()
  {
    return this.qh;
  }
  
  public String qk()
  {
    return this.qS;
  }
  
  public String toString()
  {
    return cz.M(this).a("versionCode", Integer.valueOf(this.qh)).a("accountName", this.qS).a("requestedScopes", this.Wi).a("visibleActivities", this.Wj).a("requiredFeatures", this.Wk).a("packageNameForAuth", this.Wl).a("callingPackageName", this.Wm).a("applicationName", this.Wn).a("extra", this.Wp.toString()).toString();
  }
  
  public String vA()
  {
    return this.Wn;
  }
  
  public String vB()
  {
    return this.Wo;
  }
  
  public PlusCommonExtras vC()
  {
    return this.Wp;
  }
  
  public String[] vv()
  {
    return this.Wi;
  }
  
  public String[] vw()
  {
    return this.Wj;
  }
  
  public String[] vx()
  {
    return this.Wk;
  }
  
  public String vy()
  {
    return this.Wl;
  }
  
  public String vz()
  {
    return this.Wm;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/plus/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */