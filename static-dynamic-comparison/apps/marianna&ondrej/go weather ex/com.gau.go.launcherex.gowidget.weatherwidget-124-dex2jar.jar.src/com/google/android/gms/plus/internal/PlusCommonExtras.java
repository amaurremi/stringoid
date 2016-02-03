package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.a;

public class PlusCommonExtras
  implements SafeParcelable
{
  public static final f CREATOR = new f();
  public static String TAG = "PlusCommonExtras";
  private String Uh;
  private String Ui;
  private final int xH;
  
  public PlusCommonExtras()
  {
    this.xH = 1;
    this.Uh = "";
    this.Ui = "";
  }
  
  PlusCommonExtras(int paramInt, String paramString1, String paramString2)
  {
    this.xH = paramInt;
    this.Uh = paramString1;
    this.Ui = paramString2;
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
    } while ((this.xH != ((PlusCommonExtras)paramObject).xH) || (!fo.equal(this.Uh, ((PlusCommonExtras)paramObject).Uh)) || (!fo.equal(this.Ui, ((PlusCommonExtras)paramObject).Ui)));
    return true;
  }
  
  public int getVersionCode()
  {
    return this.xH;
  }
  
  public int hashCode()
  {
    return fo.hashCode(new Object[] { Integer.valueOf(this.xH), this.Uh, this.Ui });
  }
  
  public String iN()
  {
    return this.Uh;
  }
  
  public String iO()
  {
    return this.Ui;
  }
  
  public void m(Bundle paramBundle)
  {
    paramBundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", c.a(this));
  }
  
  public String toString()
  {
    return fo.e(this).a("versionCode", Integer.valueOf(this.xH)).a("Gpsrc", this.Uh).a("ClientCallingPackage", this.Ui).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/plus/internal/PlusCommonExtras.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */