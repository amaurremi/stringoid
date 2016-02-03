package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class hz
  implements SafeParcelable
{
  public static final ff Qd = new ff();
  public final String Qe;
  public final String Qf;
  public final String Qg;
  public final List<String> Qh;
  public final String name;
  public final int versionCode;
  
  public hz(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, List<String> paramList)
  {
    this.versionCode = paramInt;
    this.name = paramString1;
    this.Qe = paramString2;
    this.Qf = paramString3;
    this.Qg = paramString4;
    this.Qh = paramList;
  }
  
  public int describeContents()
  {
    ff localff = Qd;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof hz)) {
        return false;
      }
      paramObject = (hz)paramObject;
    } while ((cz.b(this.name, ((hz)paramObject).name)) && (cz.b(this.Qe, ((hz)paramObject).Qe)) && (cz.b(this.Qf, ((hz)paramObject).Qf)) && (cz.b(this.Qg, ((hz)paramObject).Qg)) && (cz.b(this.Qh, ((hz)paramObject).Qh)));
    return false;
  }
  
  public int hashCode()
  {
    return cz.hashCode(new Object[] { this.name, this.Qe, this.Qf, this.Qg });
  }
  
  public String toString()
  {
    return cz.M(this).a("name", this.name).a("address", this.Qe).a("internationalPhoneNumber", this.Qf).a("regularOpenHours", this.Qg).a("attributions", this.Qh).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ff localff = Qd;
    ff.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/hz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */