package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class hs
  implements SafeParcelable
{
  public static final ht CREATOR = new ht();
  public final String Rl;
  public final String Rm;
  public final int versionCode;
  
  public hs(int paramInt, String paramString1, String paramString2)
  {
    this.versionCode = paramInt;
    this.Rl = paramString1;
    this.Rm = paramString2;
  }
  
  public hs(String paramString, Locale paramLocale)
  {
    this.versionCode = 0;
    this.Rl = paramString;
    this.Rm = paramLocale.toString();
  }
  
  public int describeContents()
  {
    ht localht = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof hs))) {
        return false;
      }
      paramObject = (hs)paramObject;
    } while ((this.Rm.equals(((hs)paramObject).Rm)) && (this.Rl.equals(((hs)paramObject).Rl)));
    return false;
  }
  
  public int hashCode()
  {
    return fo.hashCode(new Object[] { this.Rl, this.Rm });
  }
  
  public String toString()
  {
    return fo.e(this).a("clientPackageName", this.Rl).a("locale", this.Rm).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ht localht = CREATOR;
    ht.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/hs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */