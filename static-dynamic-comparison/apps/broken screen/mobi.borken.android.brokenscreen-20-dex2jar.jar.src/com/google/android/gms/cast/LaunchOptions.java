package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.hl;
import java.util.Locale;

public class LaunchOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator<LaunchOptions> CREATOR = new c();
  private boolean An;
  private String Ao;
  private final int xJ;
  
  public LaunchOptions()
  {
    this(1, false, gj.b(Locale.getDefault()));
  }
  
  LaunchOptions(int paramInt, boolean paramBoolean, String paramString)
  {
    this.xJ = paramInt;
    this.An = paramBoolean;
    this.Ao = paramString;
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
    } while ((this.An == ((LaunchOptions)paramObject).An) && (gj.a(this.Ao, ((LaunchOptions)paramObject).Ao)));
    return false;
  }
  
  public String getLanguage()
  {
    return this.Ao;
  }
  
  public boolean getRelaunchIfRunning()
  {
    return this.An;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { Boolean.valueOf(this.An), this.Ao });
  }
  
  public void setLanguage(String paramString)
  {
    this.Ao = paramString;
  }
  
  public void setRelaunchIfRunning(boolean paramBoolean)
  {
    this.An = paramBoolean;
  }
  
  public String toString()
  {
    return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", new Object[] { Boolean.valueOf(this.An), this.Ao });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    private LaunchOptions Ap = new LaunchOptions();
    
    public LaunchOptions build()
    {
      return this.Ap;
    }
    
    public Builder setLocale(Locale paramLocale)
    {
      this.Ap.setLanguage(gj.b(paramLocale));
      return this;
    }
    
    public Builder setRelaunchIfRunning(boolean paramBoolean)
    {
      this.Ap.setRelaunchIfRunning(paramBoolean);
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/cast/LaunchOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */