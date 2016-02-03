package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class kb
  implements SafeParcelable
{
  public static final kc CREATOR = new kc();
  public final String YS;
  public final String YT;
  public final int versionCode;
  
  public kb(int paramInt, String paramString1, String paramString2)
  {
    this.versionCode = paramInt;
    this.YS = paramString1;
    this.YT = paramString2;
  }
  
  public kb(String paramString, Locale paramLocale)
  {
    this.versionCode = 0;
    this.YS = paramString;
    this.YT = paramLocale.toString();
  }
  
  public int describeContents()
  {
    kc localkc = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof kb))) {
        return false;
      }
      paramObject = (kb)paramObject;
    } while ((this.YT.equals(((kb)paramObject).YT)) && (this.YS.equals(((kb)paramObject).YS)));
    return false;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { this.YS, this.YT });
  }
  
  public String toString()
  {
    return hl.e(this).a("clientPackageName", this.YS).a("locale", this.YT).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    kc localkc = CREATOR;
    kc.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/kb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */