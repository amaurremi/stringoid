package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class hf
  implements SafeParcelable
{
  public static final hg CREATOR = new hg();
  public final String Bf;
  public final String Bg;
  public final String Bh;
  public final List<String> Bi;
  public final String name;
  public final int versionCode;
  
  public hf(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, List<String> paramList)
  {
    this.versionCode = paramInt;
    this.name = paramString1;
    this.Bf = paramString2;
    this.Bg = paramString3;
    this.Bh = paramString4;
    this.Bi = paramList;
  }
  
  public int describeContents()
  {
    hg localhg = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof hf)) {
        return false;
      }
      paramObject = (hf)paramObject;
    } while ((ee.equal(this.name, ((hf)paramObject).name)) && (ee.equal(this.Bf, ((hf)paramObject).Bf)) && (ee.equal(this.Bg, ((hf)paramObject).Bg)) && (ee.equal(this.Bh, ((hf)paramObject).Bh)) && (ee.equal(this.Bi, ((hf)paramObject).Bi)));
    return false;
  }
  
  public int hashCode()
  {
    return ee.hashCode(new Object[] { this.name, this.Bf, this.Bg, this.Bh });
  }
  
  public String toString()
  {
    return ee.e(this).a("name", this.name).a("address", this.Bf).a("internationalPhoneNumber", this.Bg).a("regularOpenHours", this.Bh).a("attributions", this.Bi).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hg localhg = CREATOR;
    hg.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/hf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */