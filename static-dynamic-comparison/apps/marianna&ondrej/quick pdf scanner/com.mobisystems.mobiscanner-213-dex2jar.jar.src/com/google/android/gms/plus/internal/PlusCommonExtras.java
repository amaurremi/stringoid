package com.google.android.gms.plus.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.cz.a;

public class PlusCommonExtras
  implements SafeParcelable
{
  public static String TAG = "PlusCommonExtras";
  public static final b Wd = new b();
  private String We;
  private String Wf;
  private final int qh;
  
  public PlusCommonExtras()
  {
    this.qh = 1;
    this.We = "";
    this.Wf = "";
  }
  
  PlusCommonExtras(int paramInt, String paramString1, String paramString2)
  {
    this.qh = paramInt;
    this.We = paramString1;
    this.Wf = paramString2;
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
    } while ((this.qh != ((PlusCommonExtras)paramObject).qh) || (!cz.b(this.We, ((PlusCommonExtras)paramObject).We)) || (!cz.b(this.Wf, ((PlusCommonExtras)paramObject).Wf)));
    return true;
  }
  
  public int hashCode()
  {
    return cz.hashCode(new Object[] { Integer.valueOf(this.qh), this.We, this.Wf });
  }
  
  public int lX()
  {
    return this.qh;
  }
  
  public String toString()
  {
    return cz.M(this).a("versionCode", Integer.valueOf(this.qh)).a("Gpsrc", this.We).a("ClientCallingPackage", this.Wf).toString();
  }
  
  public String vt()
  {
    return this.We;
  }
  
  public String vu()
  {
    return this.Wf;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/plus/internal/PlusCommonExtras.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */