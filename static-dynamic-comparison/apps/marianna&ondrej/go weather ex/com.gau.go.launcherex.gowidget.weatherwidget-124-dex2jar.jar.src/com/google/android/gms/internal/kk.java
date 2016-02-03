package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.f;

public class kk
  implements SafeParcelable, f
{
  public static final Parcelable.Creator<kk> CREATOR = new kl();
  private final String HA;
  private final String wp;
  final int xH;
  
  kk(int paramInt, String paramString1, String paramString2)
  {
    this.xH = paramInt;
    this.wp = paramString1;
    this.HA = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof kk)) {}
    do
    {
      return false;
      paramObject = (kk)paramObject;
    } while ((!((kk)paramObject).wp.equals(this.wp)) || (!((kk)paramObject).HA.equals(this.HA)));
    return true;
  }
  
  public String getDisplayName()
  {
    return this.HA;
  }
  
  public String getId()
  {
    return this.wp;
  }
  
  public int hashCode()
  {
    return (this.wp.hashCode() + 629) * 37 + this.HA.hashCode();
  }
  
  public String toString()
  {
    return "NodeParcelable{" + this.wp + "," + this.HA + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    kl.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/kk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */