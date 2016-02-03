package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class ka
  implements SafeParcelable
{
  public static final kb CREATOR = new kb();
  public final String YV;
  public final String YW;
  public final int versionCode;
  
  public ka(int paramInt, String paramString1, String paramString2)
  {
    this.versionCode = paramInt;
    this.YV = paramString1;
    this.YW = paramString2;
  }
  
  public ka(String paramString, Locale paramLocale)
  {
    this.versionCode = 0;
    this.YV = paramString;
    this.YW = paramLocale.toString();
  }
  
  public int describeContents()
  {
    kb localkb = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof ka))) {
        return false;
      }
      paramObject = (ka)paramObject;
    } while ((this.YW.equals(((ka)paramObject).YW)) && (this.YV.equals(((ka)paramObject).YV)));
    return false;
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { this.YV, this.YW });
  }
  
  public String toString()
  {
    return hk.e(this).a("clientPackageName", this.YV).a("locale", this.YW).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    kb localkb = CREATOR;
    kb.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */