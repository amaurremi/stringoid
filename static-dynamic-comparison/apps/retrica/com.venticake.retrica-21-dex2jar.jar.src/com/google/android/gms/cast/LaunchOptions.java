package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.hk;
import java.util.Locale;

public class LaunchOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator<LaunchOptions> CREATOR = new c();
  private boolean Aq;
  private String Ar;
  private final int xM;
  
  public LaunchOptions()
  {
    this(1, false, gi.b(Locale.getDefault()));
  }
  
  LaunchOptions(int paramInt, boolean paramBoolean, String paramString)
  {
    this.xM = paramInt;
    this.Aq = paramBoolean;
    this.Ar = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof LaunchOptions)) {
        return false;
      }
      paramObject = (LaunchOptions)paramObject;
    } while ((this.Aq == ((LaunchOptions)paramObject).Aq) && (gi.a(this.Ar, ((LaunchOptions)paramObject).Ar)));
    return false;
  }
  
  public String getLanguage()
  {
    return this.Ar;
  }
  
  public boolean getRelaunchIfRunning()
  {
    return this.Aq;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { Boolean.valueOf(this.Aq), this.Ar });
  }
  
  public void setLanguage(String paramString)
  {
    this.Ar = paramString;
  }
  
  public void setRelaunchIfRunning(boolean paramBoolean)
  {
    this.Aq = paramBoolean;
  }
  
  public String toString()
  {
    return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", new Object[] { Boolean.valueOf(this.Aq), this.Ar });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/LaunchOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */